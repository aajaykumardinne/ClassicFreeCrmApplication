package com.crm.qa.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	
	String sheetname = "EmployeesInfo";
	
	public ContactPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.validateSigninpage(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = new ContactsPage();
		testutil = new TestUtil();
		testutil.switchtoframe();
		contactspage = homepage.clickoncontactslink();
	}

	@Test(priority=1)
	public void clickoncontactlabelTest() {
		boolean flag = contactspage.clickoncontactlabel();
		Assert.assertTrue(flag);
		
	}

	@Test(priority=2)
	public void selectSinglecontactTest() {
		contactspage.selectcontactsByname("Aajay34 Dinne34");
	}
	
	
	@Test(priority=3)
	public void selectMutiplecontactsTest() {
		contactspage.selectcontactsByname("Aajay34 Dinne34");
		contactspage.selectcontactsByname("David Cris");
	}
	
	@DataProvider
	public  Object[][] getCrmTestData() {
		Object data[] [] = null;
		try {
			data= TestUtil.getTestData(sheetname);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	@Test(priority=4, dataProvider= "getCrmTestData")
	public void createnewcontactTest(String head, String firstname, String lastname, String company) {
		homepage.clickonnewcontactlink();
		contactspage.createnewcontact(head, firstname, lastname, company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
