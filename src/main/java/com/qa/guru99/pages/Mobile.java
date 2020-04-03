package com.qa.guru99.pages;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qa.guru99.base.Guru99Base;

public class Mobile extends Guru99Base {

	@FindBy(xpath = "(//*[@title='Sort By'])[1]")
	WebElement DropDown;

	@FindBy(xpath = "//ul[@class='products-grid products-grid--max-4-col first last odd']/li/a")
	List<WebElement> Productlist;

	@FindBy(xpath = "//ul[@class='products-grid products-grid--max-4-col first last odd']/li/a")
	List<WebElement> Productlist1;

	@FindBy(xpath = "//span[@class='price']")
	List<WebElement> Productlist2;

	@FindBy(xpath = "//span[@id='product-price-1']/span")
	WebElement listSonyPrice;

	@FindBy(xpath = "//span[@id='product-price-1']/span")
	WebElement DetailSonyPrice;

	@FindBy(xpath = "//img[@id='product-collection-image-1']")
	WebElement SonyLogo;

	@FindBy(xpath = "(//button[@class='button btn-cart'])[1]")
	WebElement SonyAddToCart;

	@FindBy(xpath = "//input[@class='input-text qty']")
	WebElement quantity;

	@FindBy(xpath = "//button[@class='button btn-update']")
	WebElement UpadteCart;

	@FindBy(xpath = "//span[contains(text(),'Some of the products cannot be ordered in requested quantity.')]")
	WebElement ErrorUpdateCart;

	@FindBy(xpath = "//span[contains(text(),'Empty Cart')]")
	WebElement EmptyCart;

	@FindBy(xpath = "//h1[contains(text(),'Shopping Cart is Empty')]")
	WebElement Emptystatus;

	@FindBy(xpath = "(//a[@class='link-compare'])[1]")
	WebElement CompareSony;

	@FindBy(xpath = "(//a[@class='link-compare'])[2]")
	WebElement CompareIphone;

	@FindBy(xpath = "//button[@title='Compare']")
	WebElement CompareButton;

	@FindBy(xpath = "(//a[@title='Sony Xperia'])[1]")
	WebElement PopUPSONY;

	@FindBy(xpath = "(//a[@title='IPhone'])[1]")
	WebElement PopUIPHONE;

	public Mobile() {
		PageFactory.initElements(driver, this);
	}

	public String MobilepageTitle() {
		return driver.getTitle();
	}

	public void ShortByName() {
		DropDown.click();
		Select name = new Select(DropDown);
		name.selectByVisibleText("Name");

		List<String> originalList = new ArrayList();

		for (WebElement ele : Productlist) {
			originalList.add(ele.getAttribute("title"));

		}
		List<String> tempList = originalList;
		Collections.sort(tempList);
		Assert.assertEquals(originalList, tempList);

		for (String sort_name : tempList) {
			System.out.println(sort_name);
		}

	}

	public void ShortByPosition() {
		DropDown.click();
		Select position = new Select(DropDown);
		position.selectByVisibleText("Position");

		List<String> originalList = new ArrayList();

		for (WebElement ele : Productlist1) {
			originalList.add(ele.getAttribute("title"));

		}
		List<String> tempList = originalList;
		Collections.sort(tempList);
		Assert.assertEquals(originalList, tempList);

		for (String sort_name : tempList) {
			System.out.println(sort_name);
		}
	}

	public void ShortByPrice() {
		DropDown.click();
		Select name = new Select(DropDown);
		name.selectByVisibleText("Price");

		List<WebElement> price = Productlist2;

		System.out.println(price.size());

		for (int i = 0; i < price.size(); i = i + 1) {
			System.out.println(price.get(i).getText());
		}

	}

	public void SonyXperiaPrice() {

		String List_sonyprice = listSonyPrice.getText();
		System.out.println(List_sonyprice);
		SonyLogo.click();
		String detail_price = DetailSonyPrice.getText();
		System.out.println(detail_price);
		Assert.assertEquals(List_sonyprice, detail_price, "Price not matching");
	}

	// CART

	public void SonyCart() {
		SonyAddToCart.click();
		quantity.clear();
		quantity.sendKeys("1000");
		UpadteCart.click();
		Assert.assertTrue(ErrorUpdateCart.isDisplayed());
		System.out.println(ErrorUpdateCart.getText());
		EmptyCart.click();
		Assert.assertTrue(Emptystatus.isDisplayed());
		System.out.println(Emptystatus.getText());
	}

	public void PopUpCompare() {
		CompareSony.click();
		CompareIphone.click();
		String parentID = driver.getWindowHandle();
		System.out.println(parentID);
		CompareButton.click();
		Set<String> windowsID = driver.getWindowHandles();
		int size = windowsID.size();
		System.out.println(size);

		for (String window : windowsID) {
			if (!parentID.equals(window)) {

				driver.switchTo().window(window);
				driver.manage().window().maximize();
				System.out.println(driver.getTitle());
				Assert.assertTrue(PopUPSONY.isDisplayed());
				Assert.assertTrue(PopUIPHONE.isDisplayed());
				driver.close();

			}
		}
	}
}
