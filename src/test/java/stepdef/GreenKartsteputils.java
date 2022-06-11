package stepdef;

import static org.testng.Assert.assertEquals;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import io.cucumber.java.en.And;
import resources.base;

public class GreenKartsteputils extends base {
WebDriver driver;
	
	GreenKartstepDefination greenKartstepDefination = new GreenKartstepDefination();
	
	
	private final String titlexpath="//div[@class='brand greenLogo']";
	
	private final String promocodexpath="//input[@class='promoCode']";
	
	private final String codeapplyxpath="//span[@class='promoInfo']";
	
	private final String numberxpath="//span[contains(text(),\"{noofitems}\")]";
	
	private final String noofitemsxpath="//b[contains(text(),'No. of Items     : ')]//parent::div[contains(text(),'3')]";

	
	public GreenKartsteputils() throws Exception {
		this.driver=base.getdriver();
		
	}
	
	@And("^I navigate to \"([^\"]*)\" and validate page title$")
	public void navigate_to_and_validate_page_title(String pageName) {
	
		assertEquals(pageName.toUpperCase(),fluentWait(By.xpath(titlexpath)).getText() ,"Page title name is not correct");
	}
	
	@And("^I enter the promo code \"([^\"]*)\"$")
	public void clickonbutton(String promocode){
		fluentWait(By.xpath(promocodexpath)).sendKeys(promocode);
	}
	
	@And("^I verified code apply successfully$")
	public void verified_code_apply_successfully(){
		String codeapply="Code applied ..!";
	  assertEquals(codeapply,fluentWait(By.xpath(codeapplyxpath)).getText(), "promocode is not correct please apply different code");
	}
	
	@And("^I verified \"([^\"]*)\" is \"([^\"]*)\"$")
	public void i_verified(String veri,String noofitems) throws Exception {
	if(veri.equals("No. of Items     : ")) {	
	String num =fluentWait(By.xpath(noofitemsxpath)).getText();
	String numofitem = num.split("No. of Items ")[1].toString().split("Total")[0].toString().split(" ")[1].toString().trim();
	Assert.assertEquals(numofitem, noofitems,"No of items are incorrect");
	}
	 		else {
		 Assert.assertEquals(noofitems,
				 fluentWait(By.xpath(numberxpath.replace("{noofitems}", noofitems))).getText(),
				 "Order details verification failed");
		}
		
	}

}
