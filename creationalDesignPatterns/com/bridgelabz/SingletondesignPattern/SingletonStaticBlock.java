package com.bridgelabz.SingletondesignPattern;

public class SingletonStaticBlock 
{
	private static SingletonStaticBlock s=null;
	
	private SingletonStaticBlock()
	{
	}
	
	static
	{
		s = new SingletonStaticBlock();
	}
	
	public static SingletonStaticBlock getInstance()
	{
		return s;
	}
}

class StaticBlock
{
	public static void main(String[] args) throws Exception
	{
		SingletonStaticBlock s1= SingletonStaticBlock.getInstance();
		SingletonStaticBlock s2= SingletonStaticBlock.getInstance();
		
		System.out.println("Static Block Singleton Implementation...\n");
		
		print("s1",s1);
		print("s2",s2);
	
	}

	static void print(String string, SingletonStaticBlock s1)
	{
		System.out.println(String.format("Object: %s, Hashcode: %d", string,s1.hashCode()));
	}
}
