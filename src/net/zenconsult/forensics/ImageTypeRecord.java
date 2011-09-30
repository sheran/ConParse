package net.zenconsult.forensics;


public class ImageTypeRecord extends ConRecord{

	public ImageTypeRecord(byte[] data) {
		super(0x1C, data);		
	}

}
