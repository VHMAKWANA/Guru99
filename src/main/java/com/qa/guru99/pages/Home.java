package com.qa.guru99.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru99.base.Guru99Base;

public class Home extends Guru99Base {

	@FindBy(xpath = "//a[@href='http://live.demoguru99.com/index.php/mobile.html']")
	WebElement MobileLink;
	
	@FindBy(xpath = "//a[@href='http://live.demoguru99.com/index.php/tv.html']")
	WebElement TVlink;

	@FindBy(xpath = "//*[@class='page-title']")
	WebElement Logo;

	public Home() {
		PageFactory.initElements(driver, this);
	}

	public String HomePagetitle() {
		return driver.getTitle();
	}

	public String LogoText() {
		return Logo.getText();

	}

	public Mobile mobile() {
		MobileLink.click();
		return new Mobile();
	}

	public Tv TV() {
		TVlink.click();
		return new Tv();
	}

}
