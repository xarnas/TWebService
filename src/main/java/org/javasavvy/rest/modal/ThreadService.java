package org.javasavvy.rest.modal;

public class ThreadService {
	
	    public String ThreadName;
	    public String ProdType;
	    public String ProdNum;
	    public String Company;
	    public String Plant;
	    public String IpAddress;
	    
	    public String getThreadName() {
			return ThreadName;
		}
		public void setThreadName(String threadName) {
			ThreadName = threadName;
		}
		public String getProdType() {
			return ProdType;
		}
		public void setProdType(String prodType) {
			ProdType = prodType;
		}
		public String getProdNum() {
			return ProdNum;
		}
		public void setProdNum(String prodNum) {
			ProdNum = prodNum;
		}
		public String getCompany() {
			return Company;
		}
		public void setCompany(String company) {
			Company = company;
		}
		public String getPlant() {
			return Plant;
		}
		public void setPlant(String plant) {
			Plant = plant;
		}
		public String getIpAddress() {
		    return IpAddress;
		}
		public void setIpAddress(String ipAddress) {
			IpAddress = ipAddress;
		}
}
