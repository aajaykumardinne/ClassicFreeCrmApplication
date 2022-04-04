package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(), 'User: Aajay Kumar  Dinne')]")
	WebElement usernamecheck;

	@FindBy(xpath = "//a[contains(text(), 'Contacts')]")
	WebElement contactslink;

	@FindBy(xpath = "//a[contains(text(), 'Deals')]")
	WebElement dealslink;

	@FindBy(xpath = "//a[contains(text(), 'Tasks')]")
	WebElement taskslink;

	@FindBy(linkText= "Help")
	WebElement helplink;

	@FindBy(xpath = "//span[contains(text(), 'Go to CRM')]")
	WebElement gotocrmlink;

	@FindBy(xpath = "//a[contains(text(), 'New Contact')]")
	WebElement newcontactlink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateuserisplayed() {
		return usernamecheck.isDisplayed();
	}

	public ContactsPage clickoncontactslink() {
		contactslink.click();
		return new ContactsPage();
	}

	public DealsPage  clickondealslink() {
		dealslink.click();
		return new DealsPage();
	}

	public TasksPage  clickontaskslink() {
		taskslink.click();
		return new TasksPage();
	}

	public void clickonnewcontactlink() {
		Actions action = new Actions(driver);

		action.moveToElement(contactslink).build().perform();
		newcontactlink.click();

	}

	public void validatehelplink() {
		helplink.click();
//		gotocrmlink.click();
	}
	
	public String validatehomepagetitle() {
		return driver.getTitle();
	}
}
