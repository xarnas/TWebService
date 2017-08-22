package org.javasavvy.services;

public class WorkerThread extends Thread {
	 
	public void run() {
        while (!this.isInterrupted()) {
            try {
               System.out.println("Running "+this.getName());
               this.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                this.interrupt();
              	System.out.println("Killed operation "+this.getName());
             
        }
    }
}
}
