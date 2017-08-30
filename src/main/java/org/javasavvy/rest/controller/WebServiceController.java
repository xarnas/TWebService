	package org.javasavvy.rest.controller;

	import java.util.ArrayList;
	
	import java.util.List;
import java.util.Set;

import org.javasavvy.dao.ResponseText;
import org.javasavvy.rest.modal.ThreadService;
	import org.javasavvy.services.*;
	import org.springframework.http.MediaType;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

	@Controller
	@RequestMapping("/service")
	public class WebServiceController {
	List<ThreadService> list = new ArrayList<ThreadService>();
	List<ThreadService> listRemove = new ArrayList<ThreadService>();
	static TerminateWorker tw = new TerminateWorker();

		@RequestMapping(value="/online-threads")
		public @ResponseBody  List<ThreadService> getAllThreads(){
			return list;
		}
		@RequestMapping(value="/get-thread-info/{ProdType}/{ProdNum}")
		public @ResponseBody String getThreadName(@PathVariable("ProdType") String ProdType,@PathVariable("ProdNum") String ProdNum){
			for(ThreadService obj : list){
                 if (obj.ProdType.contains(ProdType)
                		 && obj.ProdNum.contains(ProdNum))
                		 {
                	 return new Gson().toJson(obj);
                 } 
			}
	        return new Gson().toJson(new ResponseText("No thread on production order: "+ProdType+" "+ProdNum));
		}
		@RequestMapping(value="/add-thread",method=RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
							produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_VALUE})
		public @ResponseBody String addThread(@RequestBody ThreadService ts){
			list.add(ts);
			WorkerThread wt1=new WorkerThread(ts.getIpAddress(),ts.SingleLabelQuantity);  
			wt1.setName(ts.getThreadName());
			wt1.start();
	        return new Gson().toJson(new ResponseText("Thread started: "+ts.ThreadName+" Production order "+ts.ProdType+" "+ts.ProdNum));
		}
		
		@RequestMapping(value="/stop-thread",method=RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
				produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_JSON_VALUE})
        public @ResponseBody String stopThread(@RequestBody ThreadService ts){
		   Set<Thread> setOfThread = Thread.getAllStackTraces().keySet();
		   tw.Terminate(ts.getThreadName(),setOfThread); 
		   for(ThreadService obj : list){
               if (obj.ThreadName.contains(ts.getThreadName())
              		 && obj.ProdType.contains(ts.getProdType())
              		 && obj.ProdNum.contains(ts.getProdNum())
              		 && obj.Company.contains(ts.getCompany())
              		 && obj.Plant.contains(ts.getPlant())
              		 && obj.IpAddress.contains(ts.getIpAddress())
                     && (obj.SingleLabelQuantity == ts.getSingleLabelQuantity())){
            	   listRemove.add(obj);
               } 
		   }
		  list.removeAll(listRemove);
		  listRemove.clear();
        return new Gson().toJson(new ResponseText("Thread killed: "+ts.ThreadName+" Production order "+ts.ProdType+" "+ts.ProdNum+" :Done"));
       }
		
	}
		
