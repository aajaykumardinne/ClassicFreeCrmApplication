package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;


public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	DealsPage dealspage;
	TasksPage taskspage;

	public HomePageTest() {
		super();
	}

	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.validateSigninpage(prop.getProperty("username"), prop.getProperty("password"));
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		dealspage = new DealsPage();
		taskspage = new TasksPage();
	}

	@Test(priority = 1)
	public void usernamedisplayedTest() {
		testutil.switchtoframe();
		boolean flag = homepage.validateuserisplayed();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void clickoncontactslink() {
		testutil.switchtoframe();
		contactspage = homepage.clickoncontactslink();
	}

	@Test(priority = 3)
	public void clickondealslink() {
		testutil.switchtoframe();
		dealspage = homepage.clickondealslink();
	}

	@Test(priority = 4)
	public void clickontaskslinkTest() {
		testutil.switchtoframe();
		taskspage = homepage.clickontaskslink();
	}

//	@Test(priority = 5)
//	public void newcontactlinkTest() {
//		
//		homepage.validatenewcontactlink();
//	}

	@Test(priority = 5)
	public void homepagetitleTest() {
		String title = homepage.validatehomepagetitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test(priority = 6)
	public void helplinkTest() {
		testutil.switchtoframe();
		homepage.validatehelplink();
	}
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
