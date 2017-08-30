package plcS7;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class OtherTestConnection {
	  public static String ip;
	 
	OtherTestConnection(String newip){
		this.ip = newip;
	}
	
	    public static long Start(int load) {
	        S7Connection dc;
//	        String ip = "10.100.92.1";
	        Socket sock;
	        OutputStream oStream = null;
	        InputStream iStream = null;
	        PLCinterface di;
	        int slot = 0;

	        try {
//	            System.out.println("Inside the try block");
	            sock = new Socket(ip, 102);

	            if(sock != null) {
	                oStream = sock.getOutputStream();
	                iStream = sock.getInputStream();
	                di = new PLCinterface(
	                        oStream, 
	                        iStream, 
	                        "PLCInterface1", 
	                        0, 
	                        Nodave.PROTOCOL_ISOTCP);
	                di.initAdapter();
	                dc = new TCPConnection(di, 2, slot);            
	                int res = dc.connectPLC();
	                int PET = 0;
	                int CICLE = 0;

	                if (0 == res) {
//	                    System.out.println("++++++++++++++++++++++++++++++++++++");
//	                    System.out.println("PLC is connected");
//	                    System.out.println("++++++++++++++++++++++++++++++++++++");
	                 
	                    if (load == 1){

	                    CICLE = dc.readBytes(Nodave.DB, 411, 0, 4, null);

	                    if (CICLE == 0) {
//	                        System.out.println(dc.getDINT(0));
	                        return dc.getDINT(0);
	                       
	                    }
	                    }else{
	                    
	                     PET = dc.readBytes(Nodave.DB, 411, 4, 4, null);

	                    if (PET == 0) {
//	                        System.out.println(dc.getDINT(0));
	                        return dc.getDINT(0);
	                    }
	                    }




	                } else {
	                    System.out.println("PLC is not connected");
	                }

//	                System.out.println("Now disconnecting\n");
	                dc.disconnectPLC();
	                di.disconnectAdapter();

	                System.out.println();

	            }
	        } catch (UnknownHostException e) {
	            System.out.println("Unknown Host Exception is Caught during the declaration of the socket");
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            System.out.println("IO Exception is Caught during the declaration of the socket");
	            e.printStackTrace();
	        }
			return 0;
	    }

	}

