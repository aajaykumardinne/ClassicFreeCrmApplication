package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page factory or Object Repository
	@FindBy(name="username")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginbtn;

	@FindBy(xpath = "//img[contains(@class, 'img-responsive')]") // doubt
	WebElement crmLogo;
	
	@FindBy(xpath = "//a[contains(text(), 'Forgot Password?')]")
	WebElement forgtpwdLink;
	
	// initialzing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validatelogintitle() {
		return driver.getTitle();
	}

	public boolean validatecrmLogo() {
		return crmLogo.isDisplayed();
	}

	public  HomePage validateSigninpage(String uname, String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);

		loginbtn.click();
		return new HomePage();
	}
	
	public void validateforgetpassword() {
		forgtpwdLink.click();
	}

}
