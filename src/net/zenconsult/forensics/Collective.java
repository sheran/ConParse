package net.zenconsult.forensics;

import java.nio.ByteBuffer;
import java.util.Enumeration;
import java.util.Vector;

public class Collective {
	Vector<byte[]> buf = new Vector<byte[]>();
	private int size = 0;
	
	public Collective() {
	}
	
	public void add(byte[] data){
		buf.add(data);
		size += data.length;
	}
	
	public byte[] getContents(){
		ByteBuffer buffer = ByteBuffer.allocate(size);
		for(Enumeration<byte[]> e = buf.elements(); e.hasMoreElements();){
			byte[] data = e.nextElement();
			buffer.put(data);
		}
		return buffer.array();
	}
	
	public int size(){
		return size;
	}

}
