package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	// 1. private By locators:
//	private By username = By.id("input-email");
//	private By password = By.id("input-password");
//	private By loginButton = By.xpath("//button[@type='submit']");
	private By forgotPwdLink = By.xpath("//div[@class='mb-3']//a[normalize-space()='Forgotten Password']");
//	private By registerLink = By.linkText("Register");
//	private By loginErrorMessg = By.cssSelector("div.alert.alert-danger.alert-dismissible");
	
	private By username = By.xpath("//input[@name='userName']");
	private By password = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//input[@name='submit']");
    private By registerLink = By.linkText("Register");
    private By loginErrorMessg = By.xpath("//span[normalize-space()='Enter your userName and password correct']");

	// 2. constructors
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	// 3. public Page actions (methods)
	public String getLoginPageTitle() {
		//return driver.getTitle();
		return elementUtil.waitForTitle(5, Constants.LOGIN_PAGE_TITLE);
	}
	
	public String getLoginPageUrl() {
		//return driver.getCurrentUrl();
		return elementUtil.getPageUrl();
	}
	
	public boolean isForgotPwdLinkExist() {
		// return driver.findElement(forgotPwdLink).isDisplayed();
		return elementUtil.doIsDisplayed(forgotPwdLink);
	}

	public AccountsPage doLogin(String un, String pwd) {
//		driver.findElement(username).sendKeys(un);
//		driver.findElement(password).sendKeys(pwd);
//		driver.findElement(loginButton).click();
		
		elementUtil.doSendKeys(username, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginButton);
		
		return new AccountsPage(driver);
	}
	
	/*
	 * public RegistrationPage navigateToRegisterPage() {
	 * elementUtil.doClick(registerLink); return new RegistrationPage(driver); }
	 * 
	 * public boolean doLoginWrongData(String un, String pwd) {
	 * elementUtil.doSendKeys(username, un); elementUtil.doSendKeys(password, pwd);
	 * elementUtil.doClick(loginButton); return
	 * elementUtil.doIsDisplayed(loginErrorMessg); }
	 */

}
