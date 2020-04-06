package com.qa.guru99.pages;

import java.nio.channels.SeekableByteChannel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

import com.qa.guru99.base.Guru99Base;

public class Checkout extends Guru99Base {

	Tv tv = new Tv();

	public static String order_num;

	@FindBy(xpath = "//div[@class='account-cart-wrapper']/a")
	WebElement Account;

	@FindBy(xpath = "(//a[@title='My Account'])[1]")
	WebElement MYAccount;

	@FindBy(xpath = "//input[@name='login[username]']")
	WebElement LoginEmail;

	@FindBy(xpath = "//input[@name='login[password]']")
	WebElement LoginPassword;

	@FindBy(xpath = "//button[@name='send']")
	WebElement LoginSend;

	@FindBy(xpath = "(//a[@href='http://live.demoguru99.com/index.php/wishlist/'])[2]")
	WebElement MyWishlist;

	@FindBy(xpath = "//a[contains(text(),'My Orders')]")
	WebElement Myorder;

	@FindBy(xpath = "(//span[text()='Add to Cart'])[1]")
	WebElement AddToCart;

	@FindBy(xpath = "//select[@id='country']")
	WebElement Country;

	@FindBy(xpath = "//select[@id='region_id']")
	WebElement province;

	@FindBy(xpath = "//input[@id='postcode']")
	WebElement ZipCode;

	@FindBy(xpath = "//button[@title='Estimate']")
	WebElement Estimate;

	@FindBy(xpath = "//label[contains(text(),'Fixed')]")
	WebElement shippingcost;

	@FindBy(xpath = "//button[@title='Update Total']")
	WebElement UpdateTotal;

	@FindBy(xpath = "//*[@id=\"shopping-cart-totals-table\"]/tbody/tr[2]/td[2]/span")
	WebElement shipping_handling;

	@FindBy(xpath = "(//button[@class='button btn-proceed-checkout btn-checkout'])[2]")
	WebElement ProceedToCHKout;

	@FindBy(xpath = "//input[@id='billing:firstname']")
	WebElement Name;

	@FindBy(xpath = "//input[@id='billing:lastname']")
	WebElement Lastname;

	@FindBy(xpath = "//input[@id='billing:street1']")
	WebElement Adress;

	@FindBy(xpath = "//input[@id='billing:city']")
	WebElement City;

	@FindBy(xpath = "//select[@id='billing:region_id']")
	WebElement StateBilling;

	@FindBy(xpath = "//input[@id='billing:postcode']")
	WebElement zipCodeBilling;

	@FindBy(xpath = "//select[@id='billing:country_id']")
	WebElement CountryBilling;

	@FindBy(xpath = "//input[@id='billing:telephone']")
	WebElement telephone;

	@FindBy(xpath = "//input[@id='billing:use_for_shipping_no']")
	WebElement ShipToThisAdd;

	@FindBy(xpath = "//div[@id='billing-buttons-container']/button")
	WebElement ContinueBilling;

	@FindBy(xpath = "//input[@id='shipping:firstname']")
	WebElement Name1;

	@FindBy(xpath = "//input[@id='shipping:lastname']")
	WebElement Lastname1;

	@FindBy(xpath = "//input[@id='shipping:street1']")
	WebElement Adress1;

	@FindBy(xpath = "//input[@id='shipping:city']")
	WebElement City1;

	@FindBy(xpath = "//select[@id='shipping:region_id']")
	WebElement StateBilling1;

	@FindBy(xpath = "//input[@id='shipping:postcode']")
	WebElement zipCodeBilling1;

	@FindBy(xpath = "//select[@id='shipping:country_id']")
	WebElement CountryBilling1;

	@FindBy(xpath = "//input[@id='shipping:telephone']")
	WebElement telephone1;

	@FindBy(xpath = "//div[@id='shipping-buttons-container']/button")
	WebElement Continueshiiping;

	@FindBy(xpath = "//label[@for='s_method_flatrate_flatrate']")
	WebElement shippingCost;

	@FindBy(xpath = "//div[@id='shipping-method-buttons-container']/button")
	WebElement Continueshipmethod;

	@FindBy(xpath = "//label[text()='Check / Money order ']")
	WebElement CheckMoneyOrder;

	@FindBy(xpath = "//div[@id='payment-buttons-container']/button")
	WebElement Continuepayment;

	@FindBy(xpath = "//td[contains(text(),'Shipping & Handling (Flat Rate - Fixed) ')]")
	WebElement ShippingFees;

	@FindBy(xpath = "//button[@title='Place Order']")
	WebElement PlaceOrder;

	@FindBy(xpath = "//p[text()='Your order # is: ']/a")
	WebElement OrderNum;

	@FindBy(xpath = "//a[contains(text(),'View Order')]")
	WebElement viewOrder;

	@FindBy(xpath = "//*[@id=\"my-orders-table\"]/tbody/tr/td[1]")
	WebElement RecentOrder;

	@FindBy(xpath = "//*[@id=\"my-orders-table\"]/tbody/tr/td[5]/em")
	WebElement Status;

	@FindBy(xpath = "//a[@class='link-print']")
	WebElement PrintPDF;

	@FindBy(xpath = "//select[@id='billing-address-select']")
	WebElement SelectAdress;

	@FindBy(xpath = "//a[@class='link-reorder']")
	WebElement Reorder;

	@FindBy(xpath = "//input[@class='input-text qty']")
	WebElement QuantityReorder;

	@FindBy(xpath = "//button[@class='button btn-update']")
	WebElement Updatereorder;

	@FindBy(xpath = "//table[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]")
	WebElement TotalReorder;

	public Checkout() {
		PageFactory.initElements(driver, this);
	}

	public void billingandshipping() throws InterruptedException {
		Name.clear();
		Name.sendKeys("ajay");
		Lastname.clear();
		Lastname.sendKeys("luhar");
		Adress.clear();
		Adress.sendKeys("1050 markham road");
		City.clear();
		City.sendKeys("scarborough");
		Select select_countryB = new Select(CountryBilling);
		select_countryB.selectByVisibleText("Canada");
		Select select_stateB = new Select(StateBilling);
		select_stateB.selectByVisibleText("Ontario");
		zipCodeBilling.clear();
		zipCodeBilling.sendKeys("M1H2E9");
		telephone.clear();
		telephone.sendKeys("4177545244");

		Thread.sleep(3000);
		ShipToThisAdd.click();
		Thread.sleep(3000);
		JavascriptExecutor jse2 = (JavascriptExecutor) driver;
		jse2.executeScript("arguments[0].scrollIntoView()", ContinueBilling);
		ContinueBilling.click();

		Thread.sleep(3000);

		Name1.clear();
		Name1.sendKeys("ajay");
		Lastname1.clear();
		Lastname1.sendKeys("luhar");
		Adress1.clear();
		Adress1.sendKeys("1050 markham road");
		City1.clear();
		City1.sendKeys("scarborough");
		Select select_statec = new Select(StateBilling);
		select_statec.selectByVisibleText("Ontario");
		zipCodeBilling1.clear();
		zipCodeBilling1.sendKeys("M1H2E9");
		Select select_countryc = new Select(CountryBilling);
		select_countryc.selectByVisibleText("Canada");
		telephone1.clear();
		telephone1.sendKeys("4177545244");
		Thread.sleep(3000);
		jse2.executeScript("arguments[0].scrollIntoView()", Continueshiiping);
		Continueshiiping.click();

		System.out.println(shippingCost.getText());
		Assert.assertTrue(shippingCost.isDisplayed());
		Thread.sleep(3000);
		Continueshipmethod.click();

		CheckMoneyOrder.click();
		Thread.sleep(3000);
		Continuepayment.click();
		System.out.println(ShippingFees.getText());
		Assert.assertTrue(ShippingFees.isDisplayed());
		PlaceOrder.click();
		System.out.println("YOUR ORDER NUM IS--->" + OrderNum.getText());
		order_num = OrderNum.getText();
		Assert.assertTrue(OrderNum.isDisplayed());

	}

	public void checkout() throws InterruptedException {
		Account.click();
		MYAccount.click();
		LoginEmail.sendKeys("gurjot@gmail.com");
		LoginPassword.sendKeys("mmHH456@");
		LoginSend.click();
		tv.TV.click();
		tv.LGAddToWishList.click();
		MyWishlist.click();
		AddToCart.click();

		Select select_country = new Select(Country);
		select_country.selectByVisibleText("Canada");
		Select select_state = new Select(province);
		select_state.selectByVisibleText("Ontario");
		ZipCode.clear();
		ZipCode.sendKeys("M1H2E9");
		Estimate.click();
		Assert.assertTrue(shippingcost.isDisplayed());
		System.out.println(shippingcost.getText());
		shippingcost.click();
		UpdateTotal.click();
		Assert.assertTrue(shipping_handling.isDisplayed());
		System.out.println(shipping_handling.getText());
		Assert.assertTrue(shipping_handling.isDisplayed());
		ProceedToCHKout.click();
		billingandshipping();
	}

	public void pdfOrder() {

		Account.click();
		MYAccount.click();
		LoginEmail.sendKeys("gurjot@gmail.com");
		LoginPassword.sendKeys("mmHH456@");
		LoginSend.click();
		Myorder.click();
		System.out.println(RecentOrder.getText());
		String Recent_order = RecentOrder.getText();
		Assert.assertEquals(Recent_order, order_num);
		System.out.println(Status.getText());
		Assert.assertEquals(Status.getText(), "Pending");
		viewOrder.click();
		PrintPDF.click();

	}

	public void Reorder() throws InterruptedException {
		Account.click();
		MYAccount.click();
		LoginEmail.sendKeys("gurjot@gmail.com");
		LoginPassword.sendKeys("mmHH456@");
		LoginSend.click();
		Thread.sleep(3000);
		Reorder.click();
		QuantityReorder.clear();
		QuantityReorder.sendKeys("5");
		Updatereorder.click();
		System.out.println(TotalReorder.getText());
		Assert.assertTrue(TotalReorder.isDisplayed());

		ProceedToCHKout.click();
		billingandshipping();

	}
}