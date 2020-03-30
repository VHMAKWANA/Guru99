package com.qa.guru99.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
		
		
		for (String sort_name:tempList) {
			System.out.println(sort_name);
		}
		
	}
}
