package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.listeners.TestAllureListener;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegistrationPage;

@Listeners(TestAllureListener.class)

public class BaseTest {
	DriverFactory df;
	public WebDriver driver;
	public Properties prop;
	
	public LoginPage loginPage;
	public AccountsPage accPage;
	public RegistrationPage registrationPage;
	
	@Parameters({"browser"})
	@BeforeTest
	//public void setup() {
	public void setup(String browserName) // Take browser preference from testng_regression.xml
	{
		df = new DriverFactory();
		prop = df.init_prop();
		//driver = df.init_driver("chrome");
		prop.setProperty("browser", browserName);
		driver = df.init_driver(prop);
		loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown( ) {
		driver.quit();
	}
}
