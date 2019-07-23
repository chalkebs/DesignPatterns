package com.bridgelabz.VisitorDesignPattern;

public interface ItemElement 
{
	public int accept(ShoppingCartVisitor visitor);
}
