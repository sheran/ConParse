package net.zenconsult.forensics;


public class CountryFlagRecord extends ConRecord{

	public CountryFlagRecord(byte[] data) {
		super(0x31, data);		
	}

}
