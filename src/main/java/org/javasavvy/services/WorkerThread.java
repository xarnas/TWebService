package org.javasavvy.services;

public class WorkerThread extends Thread {
	 
	public void run() {
		MachineService machServ = new MachineService("10.XX.XX.XX");
        while (!this.isInterrupted()) {
            try {
            	   machServ.ManufactureCount();
               System.out.println("Running operation "+this.getName());
               machServ.ManufactureDiff();
               this.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                this.interrupt();
              	System.out.println("Killed operation "+this.getName());
             
        }
    }
}
}
