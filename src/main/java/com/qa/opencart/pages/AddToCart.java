package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCart 
{
	WebDriver driver;
	
	public AddToCart() 
	{
		
	}
	
	private By username = By.xpath("//input[@name='userName']");
	
	public void LoginPage(WebDriver driver) { 
		System.out.println("add to cart");
	}
}
