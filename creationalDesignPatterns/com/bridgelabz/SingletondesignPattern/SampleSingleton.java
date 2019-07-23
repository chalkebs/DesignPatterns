package com.bridgelabz.SingletondesignPattern;

public class SampleSingleton 
{
	private static SampleSingleton s=new SampleSingleton(); //Eagerly Creating Instance
	
	private SampleSingleton()
	{
		System.out.println("\nConstructor is Loaded...\n");
	}
		
	public static SampleSingleton getInstance()
	{
		return s;
	}
}

class Singleton
{
	public static void main(String[] args) throws Exception
	{
		SampleSingleton s1= SampleSingleton.getInstance();
		SampleSingleton s2= SampleSingleton.getInstance();
		
		System.out.println("Singleton Implementation...\n");
		
		print("s1",s1);
		print("s2",s2);
	
	}

	static void print(String string, SampleSingleton s1)
	{
		System.out.println(String.format("Object: %s, Hashcode: %d", string,s1.hashCode()));
	}
}