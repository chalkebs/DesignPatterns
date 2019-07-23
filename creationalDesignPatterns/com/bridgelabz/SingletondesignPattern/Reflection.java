package com.bridgelabz.SingletondesignPattern;

import java.lang.reflect.Constructor;

public class Reflection 
{
	private static Reflection s=new Reflection();
	
	private Reflection()
	{
		System.out.println("\nConstructor is Loaded...\n");
	}
		
	public static Reflection getInstance()
	{
		return s;
	}
}

class Reflection1
{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) throws Exception
	{
		Reflection s1= Reflection.getInstance();
		Reflection s2= Reflection.getInstance();
		
		System.out.println("Reflection Implementation...\n");
		
		print("s1",s1);
		print("s2",s2);
		
		//Reflection
		Class cl= Class.forName("com.bridgelabz.SingletondesignPattern.Reflection");
		Constructor<Reflection> con= cl.getDeclaredConstructor();
		con.setAccessible(true);
		Reflection s3= con.newInstance();
		
		print("s3", s3);
	}

	static void print(String string, Reflection s1)
	{
		System.out.println(String.format("Object: %s, Hashcode: %d", string,s1.hashCode()));
	}
}
