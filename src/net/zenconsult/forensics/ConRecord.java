package net.zenconsult.forensics;

public class ConRecord {
	private int recSize = 0;
	private int recType = 0;
	private byte[] recData;
	
	public ConRecord(int type, byte[] data){
		recType = type;
		recData = data;
		recSize = recData.length;
	}
	
	public int getType(){
		return recType;
	}
	
	public byte[] getRawData(){
		return recData;
	}
	
	public String getDataAsString(){
		String output = "";
		if(recData != null){
			output = new String(recData);
		}
		return output;
	}
	
	public String toHexString(){
		String output = "";
		if(recData != null){
			Hex.toHexF(recData);
		}
		return output;
	}
	
	public String getPrintableString() {
		StringBuffer buf = new StringBuffer();
		if(recData != null){
			for(int k = 0; k < recData.length;++k){
				if(recData[k] > 0x20 && recData[k] < 0x7F){
					buf.append((char)recData[k]);
				} else {
					buf.append(".");
				}
			}
		}
		
		return buf.toString();
	}
	
	public int getSize(){
		return recSize;
	}
	
}
