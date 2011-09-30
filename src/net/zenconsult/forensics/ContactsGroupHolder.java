package net.zenconsult.forensics;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.Vector;

public class ContactsGroupHolder extends ConRecord{
	Vector<ContactGroupRecord> contactGroups = new Vector<ContactGroupRecord>();
	Vector<ConRecord> unknownRecs = new Vector<ConRecord>();
	
	public ContactsGroupHolder(byte[] data) {
		super(0x23, data);
		int count = 0;
		DataInputStream ds = new DataInputStream(new ByteArrayInputStream(data));
		while(true){
			try {
				int rSize = ds.readUnsignedShort();
				count +=2;
				int rType = ds.read();
				count++;
				
				byte[] rDat = new byte[rSize];
				ds.read(rDat);
				count +=rSize;
				
				if(rType == 0x06){
					contactGroups.add(new ContactGroupRecord(rDat));
				} else {
					unknownRecs.add(new ConRecord(rType,rDat));
				}
				if(count == getSize()){
					break;
				}
					
				
			} catch(EOFException e){
				break;
			} catch (IOException e) {
				e.printStackTrace();
				
			}
			
		}
		try {
			ds.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Vector<ContactGroupRecord> getContactGroups(){
		return contactGroups;
	}

}
