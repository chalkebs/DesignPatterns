package com.bridgelabz.SingletondesignPattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Fix1OfMultiThreaded implements Cloneable
{
	//volatile
	private static volatile Fix1OfMultiThreaded s=null; //Lazily Creating Instance
	
	private Fix1OfMultiThreaded()
	{
		System.out.println("\nConstructor is Loaded...\n");
	}
		
	public static Fix1OfMultiThreaded getInstance()
	{
		//Double Checked Locking
		
		if(s==null) //Check 1
		{
			synchronized(Fix1OfMultiThreaded.class)
			{
				if(s==null) //Check 2
					s=new Fix1OfMultiThreaded();
			}
		}
		return s;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException 
	{
		return super.clone();
	}
}

class MultiThread
{
	static void useFixOfMultiThreaded()
	{
		Fix1OfMultiThreaded m=Fix1OfMultiThreaded.getInstance();
		print("MultiThreadedAccess",m);
	}
	public static void main(String[] args) throws Exception
	{
		System.out.println("Fix 1 of MultiThreadedAccess Implementation using Synchronized and volatile...\n");
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(MultiThread::useFixOfMultiThreaded);
		service.submit(MultiThread::useFixOfMultiThreaded);
	
		service.shutdown();
	}

	static void print(String string, Fix1OfMultiThreaded s1)
	{
		System.out.println(String.format("Object: %s, Hashcode: %d", string,s1.hashCode()));
	}
}
