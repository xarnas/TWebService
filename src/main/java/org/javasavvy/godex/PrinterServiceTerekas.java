package org.javasavvy.godex;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

public class PrinterServiceTerekas {

	public void callPrinter() {
		              PrintService pservice = PrintServiceLookup.lookupDefaultPrintService(); //Need to find godex printer online
			          DocPrintJob job = pservice.createPrintJob();    
			          String commands="PrinterLabelCode";
			          DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
			          Doc  doc = new SimpleDoc(commands.getBytes(), flavor, null);
			          try {
						job.print(doc,null);
					  } catch (PrintException e) {
						e.printStackTrace();
					 }
			
	}

}
