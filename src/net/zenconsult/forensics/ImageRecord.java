package net.zenconsult.forensics;


public class ImageRecord extends ConRecord{

	public ImageRecord(byte[] data) {
		super(0x1F, data);		
	}

}
