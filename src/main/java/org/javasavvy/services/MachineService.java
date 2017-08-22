package org.javasavvy.services;
import java.util.Random;
public class MachineService {
  
    public int manuTemp;
    public int bottle; //for testing purpose
    private int bottleDif;
    
    Random rand = new Random();
    
	public MachineService(String ipAddress) {
		System.out.println("new connection with "+ipAddress);
		manuTemp=0; //Machine start count number
	}
	
	public void ManufactureCount() {
		int x = 0;
		while (x != 5) {	
			bottle=bottle+rand.nextInt(50) + 1;
			x++;
		}
	}
	
   public void ManufactureDiff() {
	   bottleDif=bottle-manuTemp;
	   manuTemp=bottle;
	   System.out.println("Bottle difference "+bottleDif);
	   //new PrinterService(bottleDif);
   }
}
