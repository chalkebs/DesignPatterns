package com.bridgelabz.SingletondesignPattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

enum Fix3ByEnumExample 
{
	INSTANCE;
	public String getConfiguration()
	{
		return "sbsbsb";
	}
}
class Multi
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("Fix 3 Of MultiThreadAccess Implementation using Static block...\n");
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(Multi::useFix3ByEnumExample);
		service.submit(Multi::useFix3ByEnumExample);
	
		service.shutdown();
	}
	
	static void useFix3ByEnumExample()
	{
		Fix3ByEnumExample m=Fix3ByEnumExample.INSTANCE;
		print("Fix of MultiThreadedAccess by enum...",m);
	}

	static void print(String string, Fix3ByEnumExample s1)
	{
		System.out.println(String.format("Object: %s, Hashcode: %d", string,s1.hashCode()));
	}
}