package plcS7;

public class plcS7Terekas {
    public long PETManufac;
	
	public long MachineData(String ip){
		  
//         DataIsoTCP DITCP = new DataIsoTCP("10.100.92.1",102);
//         
//         DITCP.Start();
//         DITCP.ReadBlockDataTerekasCiklai();
//         //DITCP.ReadBlockDataTerekasPETai();
//         DITCP.StopConnection();
	
		
	    	OtherTestConnection OTC = new OtherTestConnection(ip);
//        OTC.Start(1);
//		 OTC.Start(0);

	    	
		  // System.out.println(OTC.Start(1)+"##"+OTC.Start(0));
		   
	    PETManufac =	OTC.Start(0);
		return PETManufac ;
		
	}

}





