package com.bridgelabz.FactoryMethodDesignPattern;

public class ComputerFactory 
{
	public static Computer getComputer(String type, String ram, String hdd, String cpu)
	{
		if("PC".equalsIgnoreCase(type)) 
			return new Pc(ram, hdd, cpu);
		else if("server".equalsIgnoreCase(type)) 
				return new Server(ram, hdd, cpu);
		else if("Laptop".equalsIgnoreCase(type)) 
				return new Laptop(ram, hdd, cpu);
		
		return null;
	}
}
