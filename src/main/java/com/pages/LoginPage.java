package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// 1. By Locators
	private By emailId = By.id("email");
	private By password = By.id("passwd");
	private By signIn = By.id("SubmitLogin");
	private By forgotPassword = By.linkText("Forgot your password?123");

	// 2. Constructor of page class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods
	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPassword).isDisplayed();
	}

	public void enterUsername(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLogin() {
		driver.findElement(signIn).click();
	}
	
	public AccountsPage doLogin(String un,String pwd) {
		System.out.println("Login with " +un+ "and" +pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signIn).click();
		return new AccountsPage(driver);
		
	}

}
