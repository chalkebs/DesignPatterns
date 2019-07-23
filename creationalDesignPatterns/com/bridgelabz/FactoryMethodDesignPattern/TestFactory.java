package com.bridgelabz.FactoryMethodDesignPattern;

public class TestFactory 
{
	public static void main(String[] args) 
	{
		Computer pc = ComputerFactory.getComputer("pc","2 GB","500 GB","2.4 GHz");
		Computer server = ComputerFactory.getComputer("server","16 GB","1 TB","2.9 GHz");
		Computer laptop = ComputerFactory.getComputer("laptop","4 GB","1 TB","3.2 GHz");

		System.out.println("Factory PC Config : "+pc);
		System.out.println("\nFactory Server Config : "+server);
		System.out.println("\nFactory Laptop Config : "+laptop);

	}
}
