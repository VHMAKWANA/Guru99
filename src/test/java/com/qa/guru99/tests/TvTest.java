package com.qa.guru99.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guru99.base.Guru99Base;
import com.qa.guru99.pages.Home;
import com.qa.guru99.pages.Mobile;
import com.qa.guru99.pages.Tv;

public class TvTest extends Guru99Base {

	Home home;
	Tv tv;

	@BeforeMethod
	public void setup() {
		initialization();
		home = new Home();
		tv = home.TV();
	}

	@Test(priority = 1)
	public void Account() {
		tv.Account();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
