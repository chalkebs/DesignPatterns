package com.bridgelabz.SingletondesignPattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialization implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private static Serialization s=new Serialization();
	
	private Serialization()
	{
		System.out.println("\nConstructor is Loaded...\n");
	}
		
	public static Serialization getInstance()
	{
		return s;
	}
}

class Serialization1
{
	public static void main(String[] args) throws Exception
	{
		Serialization s1= Serialization.getInstance();
		Serialization s2= Serialization.getInstance();
		
		System.out.println("Serialization Implementation...\n");
		
		print("s1",s1);
		print("s2",s2);
	
		//Serialization
		try
		{
			ObjectOutputStream oos=new ObjectOutputStream(new 
					FileOutputStream("/home/admin28/eclipse-workspace/DesignPattern/src/s2.ser"));
			oos.writeObject(s2);
			
			ObjectInputStream ois=new ObjectInputStream(new 
					FileInputStream("/home/admin28/eclipse-workspace/DesignPattern/src/s2.ser"));
			Serialization s3=(Serialization)ois.readObject();
			print("s3",s3);
			oos.close();
			ois.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	static void print(String string, Serialization s1)
	{
		System.out.println(String.format("Object: %s, Hashcode: %d", string,s1.hashCode()));
	}
}
