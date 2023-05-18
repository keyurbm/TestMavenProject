package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginPageTest extends BaseTest {

	@Description("login Page Title Test")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is: " + title);
		Assert.assertEquals(title,Constants.LOGIN_PAGE_TITLE);
	}

	@Description("login Page URL Test")
	@Severity(SeverityLevel.MINOR)
	@Test(enabled = true)
	public void loginPageUrlTest() {
		String url = loginPage.getLoginPageUrl();
		System.out.println("login page url is: " + url);
		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_VALUE));
	}

	@Test(enabled = false)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@Description("login Test")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 4)
	public void loginTest() {
		//loginPage.doLogin("naveenanimation20@gmail.com", "Selenium12345");
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	/*
	 * @DataProvider public Object[][] loginNegativeData() { return new Object[][] {
	 * { "test@gmail.com", "test@123" },{ "", "test@123" } }; }
	 * 
	 * 
	 * @Test(priority = 0, dataProvider = "loginNegativeData", enabled = false)
	 * public void loginNegativeTest(String un, String pwd) {
	 * loginPage.doLoginWrongData(un,pwd); }
	 */
}
