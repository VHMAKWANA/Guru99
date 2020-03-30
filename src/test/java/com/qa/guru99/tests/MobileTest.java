package com.qa.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guru99.base.Guru99Base;
import com.qa.guru99.pages.Home;
import com.qa.guru99.pages.Mobile;

public class MobileTest extends Guru99Base {

	Home home;
	Mobile mobile;

	@BeforeMethod
	public void setup() {
		initialization();
		home = new Home();
		mobile = home.mobile();
		

	}

	//@Test(priority = 1)
	public void mobiletitle() {
		String title = mobile.MobilepageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Mobile");
	}
	
	@Test(priority = 2)
	public void Shortname() {
		mobile.ShortByName();
	}

	

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
