package com.bridgelabz.SingletondesignPattern;

public class SingletonBillPugh 
{
	private static class SingletonBill
	{
		private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
	}
	
	private SingletonBillPugh()
	{
		
	}
	
	public static SingletonBillPugh getInstance()
	{
		return SingletonBill.INSTANCE;
	}
}

class BillPugh
{
	public static void main(String[] args) 
	{
		SingletonBillPugh s1= SingletonBillPugh.getInstance();
		SingletonBillPugh s2= SingletonBillPugh.getInstance();
		
		System.out.println("Bill pugh Singleton Implementation..\n.");
		
		print("s1",s1);
		print("s2",s2);
	}
	
	static void print(String string, SingletonBillPugh s1)
	{
		System.out.println(String.format("Object: %s, Hashcode: %d", string,s1.hashCode()));
	}
}