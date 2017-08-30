package org.javasavvy.services;

import java.util.Random;
import org.javasavvy.godex.*;
import plcS7.*;


public class MachineService {
  
    public long manuTemp;
    public long bottle;
    private long bottleDif;
    public String ipAddress;
    public long LabelBounds;
    public long LabelsOverLimit=0;
    
    plcS7Terekas plc = new plcS7Terekas();
    PrinterServiceTerekas ps = new PrinterServiceTerekas();
    
    Random rand = new Random(); //for testing purpose
    
	public MachineService(String ipAddressFromHttpPost,long LabelBoundHttpPost) {
		ipAddress=ipAddressFromHttpPost;
		LabelBounds=LabelBoundHttpPost;
		System.out.println("new connection with "+ipAddress+" Label Print Bound "+LabelBounds);
		
		manuTemp=0; //Machine start count number
	}
	
	//Manufacturing Simulation
	public void ManufactureCount() {
		//bottle=plc.MachineData(ipAddress); for Machine Networtk
		int x = 0;
		while (x != 5) {	
			bottle=bottle+rand.nextInt(200) + 1;
			x++;
		}
	}
	
   public void ManufactureDiff() {
	   bottleDif=bottle-manuTemp;
	   manuTemp=bottle;
	   System.out.println("Bottle difference "+bottleDif);
		   while (bottleDif >= LabelBounds) {	
			   System.out.println("Printed");
			   bottleDif=bottleDif-LabelBounds;
			   //ps.callPrinter(); not finished 
			} 
		   LabelsOverLimit=LabelsOverLimit+bottleDif;
	   }
   
	public void endPrint() {
		while (LabelsOverLimit >= LabelBounds) {	
			   System.out.println("End Print Printed");
			   LabelsOverLimit=LabelsOverLimit-LabelBounds;
			   //ps.callPrinter(); not finished 
			} 
		    System.out.println("Last label"+ LabelsOverLimit);
		    //ps.callPrinter(); not finished 
	   }
	}
