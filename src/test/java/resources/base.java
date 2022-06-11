package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class base {
public static WebDriver driver;
	
	public static WebDriver driverinitialze() throws Exception {
		System.setProperty(readProperties("browserdata"),readProperties("driverLocation"));
		driver = new FirefoxDriver();
		return driver;
	}
	public static WebDriver getdriver() throws Exception {
		if(driver == null) {
			driverinitialze();
		}
		return driver;
	}
	
	public static String readProperties(String propertename) throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Dhruv Rathod\\eclipse-workspace\\Shopinng_E2E_01\\src\\test\\java\\resources\\data.properties");
		prop.load(fis);
		String properteName = prop.getProperty(propertename);
		return properteName;
	}
	public static WebElement fluentWait(By by) {
		FluentWait wait = new FluentWait(driver).ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(3))
				.withTimeout(Duration.ofSeconds(30));
         WebElement element = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		
		return element ;
	}
	
    public void getScreenShotPath(String filename) throws Exception {
		
		TakesScreenshot tss = (TakesScreenshot) driver;
		File screenshotfile =tss.getScreenshotAs(OutputType.FILE);
		String destinationfile = System.getProperty("user.dir")+"\\reports\\"+filename+".png";
		FileUtils.copyFile(screenshotfile,new File(destinationfile));
	}
    
	public static void closeBrowserAndDriver() {
		
		if(driver!=null) {
			driver.quit();
		}
		}

}
