package stepdef;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.base;

public class GreenKartstepDefination extends base {
	WebDriver driver;
	private final String vegelistcss="h4.product-name";
	
	private final String kgofvegexpath="//h4[contains(text(),\"{vegetableName}\")]//parent::div/div/a[2]";
	
	private final String addcartxpath="//h4[contains(text(),\"{vegetableName}\")]//parent::div/div/button";
	
	private final String bagiconxpath="//img[@alt='Cart']";
	
	private final String buttonxpath="//button[contains(text(),\"{button name}\")]";
	
	@Given("^Go to Greenkart page$")
	public void User_is_on_login_page() throws Exception{
		driver = driverinitialze();
		driver.get(readProperties("greenkarturl"));
	}

	@When("^I add Vegetables \"([^\"]*)\" Kg \"([^\"]*)\" and click on Add to cart button$")
	public void login_with_username_pass(int kg,String vegetablename){
		String vegetableName="";
        List<WebElement> vegitablelist = driver.findElements(By.cssSelector(vegelistcss));
        
        for(int i=0;i<vegitablelist.size();i++) {
        	String[] vegetableNamearry = vegitablelist.get(i).getText().split("-");
        vegetableName = vegetableNamearry[0].trim();
        if(vegetableName.equals(vegetablename)) {
                break;
        	}
        }
        //adding kilogram of vegetables
        if(kg!=1) {
        for(int i=0;i<kg;i++) {
        	fluentWait(By.xpath(kgofvegexpath.replace("{vegetableName}", vegetableName))).click();
        	System.out.println(kg);
                    }
        }
        	if(vegetableName.equals(vegetablename)) {
        		fluentWait(By.xpath(addcartxpath.replace("{vegetableName}", vegetableName))).click();
        	
        }
      
	}
	@Then("^I Click on Bag icon$")
	public void Home_populate(){
		fluentWait(By.xpath(bagiconxpath)).click();
	
	}
	@And("^I click on \"([^\"]*)\" button$")
	public void clickonbutton(String buttonName){
		fluentWait(By.xpath(buttonxpath.replace("{button name}", buttonName))).click();
	}

}
