package com.qa.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guru99.base.Guru99Base;
import com.qa.guru99.pages.Home;

public class HomeTest extends Guru99Base {

	Home home;

	public HomeTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		home = new Home();

	}

	@Test(priority = 1)
	public void hometitle() {
		String title = home.HomePagetitle();
		System.out.println(title);
		Assert.assertEquals(title, "Home page");
	}

	@Test(priority = 2)
	public void logo() {
		System.out.println(home.LogoText());
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
