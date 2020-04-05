package com.qa.guru99.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.guru99.base.Guru99Base;

public class Tv extends Guru99Base {

	@FindBy(xpath = "(//a[@title='My Account'])[2]")
	WebElement MyAccount;

	@FindBy(xpath = "//a[@title='Create an Account']")
	WebElement CreateAcc;

	@FindBy(xpath = "//input[@id='firstname']")
	WebElement FirstName;

	@FindBy(xpath = "//input[@id='lastname']")
	WebElement Lastname;

	@FindBy(xpath = "//input[@id='email_address']")
	WebElement EmailAdress;

	@FindBy(xpath = "//input[@id='password']")
	WebElement Password;

	@FindBy(xpath = "//input[@id='confirmation']")
	WebElement ConformPass;

	@FindBy(xpath = "//button[@title='Register']")
	WebElement Register;

	@FindBy(xpath = "//span[text()='Thank you for registering with Main Website Store.']")
	WebElement SuceesRegister;

	@FindBy(xpath = "//a[@href='http://live.demoguru99.com/index.php/tv.html']")
	WebElement TV;

	@FindBy(xpath = "(//a[@class='link-wishlist'])[1]")
	WebElement LGAddToWishList;

	@FindBy(xpath = "//span[text()='Share Wishlist']")
	WebElement ShareWishList;

	@FindBy(xpath = "//textarea[@id='email_address']")
	WebElement WishEmail;

	@FindBy(xpath = "//textarea[@id='message']")
	WebElement Message;

	@FindBy(xpath = "//span[text()='Share Wishlist']")
	WebElement sharwWishBTN;

	@FindBy(xpath = "//span[text()='Your Wishlist has been shared.']")
	WebElement WishSucessmessage;

	public Tv() {
		PageFactory.initElements(driver, this);
	}

	public void Account() {
		MyAccount.click();
		CreateAcc.click();
		FirstName.sendKeys("kruvil");
		Lastname.sendKeys("patel");
		EmailAdress.sendKeys("kruvil!@yahoo.com");
		Password.sendKeys("hm9228272442@");
		ConformPass.sendKeys("hm9228272442@");
		Register.click();
		System.out.println(SuceesRegister.getText());
		Assert.assertTrue(SuceesRegister.isDisplayed());
		TV.click();
		LGAddToWishList.click();
		ShareWishList.click();
		WishEmail.sendKeys("bbn@gmai.com");
		Message.sendKeys("hiiiiiiii");
		sharwWishBTN.click();
		Assert.assertTrue(WishSucessmessage.isDisplayed());
		System.out.println(WishSucessmessage.getText());

	}

}
