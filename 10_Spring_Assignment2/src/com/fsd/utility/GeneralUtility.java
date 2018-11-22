package com.fsd.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class GeneralUtility {

	public static ObjectInputStream getObjectInputStream(){
		FileInputStream fi;
		ObjectInputStream oi=null ;
		try {
			fi = new FileInputStream(new File("binary.ser"));
			oi = new ObjectInputStream(fi);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return oi;
	}
	
	
	public static ObjectOutputStream getObjectOutputStream(){
		FileOutputStream f;
		ObjectOutputStream o=null;
		try {
			f = new FileOutputStream(new File("binary.ser"));
			o = new ObjectOutputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return o;
	}
	
}
