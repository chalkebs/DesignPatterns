package com.bridgelabz.SingletondesignPattern;

public class Clone implements Cloneable
{
	private static Clone s=new Clone();
	
	private Clone()
	{
		System.out.println("\nConstructor is Loaded...\n");
	}
		
	public static Clone getInstance()
	{
		return s;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException 
	{
		return super.clone();
	}
}

class Clone1
{
	public static void main(String[] args) throws Exception
	{
		Clone s1= Clone.getInstance();
		Clone s2= Clone.getInstance();
		
		System.out.println("Clone Implementation...\n");
		
		print("s1",s1);
		print("s2",s2);
	
		//Clone
		Clone s3=(Clone)s2.clone();
		print("s3",s3);
		
	}

	static void print(String string, Clone s1)
	{
		System.out.println(String.format("Object: %s, Hashcode: %d", string,s1.hashCode()));
	}
}

