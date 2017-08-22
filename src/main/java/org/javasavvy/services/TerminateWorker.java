package org.javasavvy.services;

import java.util.Set;

public class TerminateWorker {
	
	public void Terminate(String threadName,Set<Thread>setOfThread) {
		
			 for(Thread thread : setOfThread){
				 System.out.println("ThreadName: "+thread.getName());
			    if(thread.getName().equals(threadName)){
			        thread.interrupt();
			   }
	    }
    }
}
		