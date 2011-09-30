package net.zenconsult.forensics;


public class StatusRecord extends ConRecord{

	public StatusRecord(byte[] data) {
		super(0x30, data);		
	}

}
