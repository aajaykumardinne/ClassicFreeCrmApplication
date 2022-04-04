package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(), 'Contacts')]")
	WebElement contactslink;

	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement company;
	
	@FindBy(xpath="//parent::td[@colspan='2']//input[@type='submit' and @value='Save' ]")
	WebElement saveBtn;
	
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean clickoncontactlabel() {
		return contactslink.isDisplayed();
	}
	
	public void selectcontactsByname(String name) {
		driver.findElement(By.xpath("//a[text()='"+ name +"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createnewcontact(String title, String ltname, String ftname, String comp) {
		Select select = new Select(driver.findElement(By.name("title")));
		
		select.selectByVisibleText(title);
		
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		company.sendKeys(comp);
		saveBtn.click();
		
	}
	
	
	
	
}
