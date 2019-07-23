package com.bridgelabz.SingletondesignPattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fix2OfMultiThread2 implements Cloneable
{
	
	private Fix2OfMultiThread2()
	{
		System.out.println("\nConstructor Fix2OfMultiThread2 is Loaded...\n");
	}
	
	//change...
	public static Fix2OfMultiThread2 getInstance()
	{
		return Holder.INSTANCE;
	}
	
	//Singleton Holder...
	static class Holder
	{
		static final Fix2OfMultiThread2 INSTANCE = new Fix2OfMultiThread2();
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException 
	{
		return super.clone();
	}
}

class MultiThread2
{
	static void useFix2OfMultiThread2()
	{
		Fix2OfMultiThread2 m=Fix2OfMultiThread2.getInstance();
		print("MultiThread2edAccess",m);
	}
	public static void main(String[] args) throws Exception
	{
		System.out.println("Fix 2 Of MultiThreadAccess Implementation using Holder class...\n");
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(MultiThread2::useFix2OfMultiThread2);
		service.submit(MultiThread2::useFix2OfMultiThread2);
	
		service.shutdown();
	}

	static void print(String string, Fix2OfMultiThread2 s1)
	{
		System.out.println(String.format("Object: %s, Hashcode: %d", string,s1.hashCode()));
	}
}
