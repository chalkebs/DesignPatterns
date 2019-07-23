package com.bridgelabz.SingletondesignPattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationDeserialization implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static SerializationDeserialization s=null;
	
	private SerializationDeserialization()
	{
		System.out.println("\nConstructor is Loaded...\n");
	}
		
	public static SerializationDeserialization getInstance()
	{
		if(s==null)
			s = new SerializationDeserialization();
		return s;
	}
	
	private Object readResolve() throws Exception
	{
		System.out.println("\nRead Resolve...Deserialization...\n");
		return s;
	}
}

class SerializationDeserialization1
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("Fix 4 of Serialization Implementation using Serialization and Deserialization...");
		SerializationDeserialization s1= SerializationDeserialization.getInstance();
		SerializationDeserialization s2= SerializationDeserialization.getInstance();
		
		print("s1",s1);
		print("s2",s2);
	
		//Serialization and Deserialization
		try
		{
			ObjectOutputStream oos=new ObjectOutputStream(new 
					FileOutputStream("/home/admin28/eclipse-workspace/DesignPattern/src/s2.ser"));
			oos.writeObject(s2);
			
			ObjectInputStream ois=new ObjectInputStream(new 
					FileInputStream("/home/admin28/eclipse-workspace/DesignPattern/src/s2.ser"));
			SerializationDeserialization s3=(SerializationDeserialization)ois.readObject();
			print("s3",s3);
			oos.close();
			ois.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	static void print(String string, SerializationDeserialization s1)
	{
		System.out.println(String.format("Object: %s, Hashcode: %d", string,s1.hashCode()));
	}
}
