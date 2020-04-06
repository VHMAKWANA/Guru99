package com.qa.guru99.tests;

import com.qa.guru99.base.Guru99Base;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guru99.base.Guru99Base;
import com.qa.guru99.pages.Checkout;
import com.qa.guru99.pages.Home;
import com.qa.guru99.pages.Mobile;
import com.qa.guru99.pages.Tv;

public class CheckoutTest extends Guru99Base {

	Home home;
	Checkout checkout;

	@BeforeMethod
	public void setup() {
		initialization();
		home = new Home();
		checkout = new Checkout();

	}
	

	@Test(priority = 1)
	public void checkoutorder() throws InterruptedException {
		checkout.checkout();
	}
	
	@Test(priority = 2)
	public void OrderStatus()  {
		checkout.pdfOrder();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
