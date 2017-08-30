package org.javasavvy.services;

public class WorkerThread extends Thread {
	
	private String MachineIp;
	private long SingleLabelQuantity;
	
	public WorkerThread(String ipAddress, long SingleLabelQuantityU) {
		MachineIp=ipAddress;
		SingleLabelQuantity=SingleLabelQuantityU;
	}
	
	public void run() {
		MachineService machServ = new MachineService(MachineIp,SingleLabelQuantity);
        while (!this.isInterrupted()) {
            try {
            	   machServ.ManufactureCount();
               System.out.println("Running operation "+this.getName());
               machServ.ManufactureDiff();
               this.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                machServ.endPrint();
                this.interrupt();
              	System.out.println("Killed operation "+this.getName());
             
        }
    }
}
}
