package com.bridgelabz.SingletondesignPattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedAccess implements Cloneable
{
	private static MultiThreadedAccess s=null; //Lazily Creating Instance
	
	private MultiThreadedAccess()
	{
		System.out.println("\nConstructor is Loaded...\n");
	}
		
	public static MultiThreadedAccess getInstance()
	{
		if(s==null)
		{
			s=new MultiThreadedAccess();
		}
		return s;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException 
	{
		return super.clone();
	}
}

class MultiThreadedAccess1
{
	static void useMultiThreadedAccess()
	{
		MultiThreadedAccess m=MultiThreadedAccess.getInstance();
		print("MultiThreadedAccess",m);
	}
	public static void main(String[] args) throws Exception
	{
		System.out.println("MultiThreadAccess Implementation...\n");
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(MultiThreadedAccess1::useMultiThreadedAccess);
		service.submit(MultiThreadedAccess1::useMultiThreadedAccess);
	
		service.shutdown();
	}

	static void print(String string, MultiThreadedAccess s1)
	{
		System.out.println(String.format("Object: %s, Hashcode: %d", string,s1.hashCode()));
	}
}
