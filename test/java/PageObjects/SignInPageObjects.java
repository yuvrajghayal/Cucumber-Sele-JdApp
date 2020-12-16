package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.junit.Assert;


public class SignInPageObjects {

	 private static final Logger logger = LogManager.getLogger(SignInPageObjects.class);

	    private WebDriver driver;

	    private By Input_Name = By.id("lgn_name");
	    private By Input_mobile_no = By.id("lgn_mob");
	    
	    public SignInPageObjects(WebDriver driver){
	        this.driver = driver;
	    }
	    
	    
	    public void ValidateMobileInputTextBoxIsDisplayed()
	    {
	    	if(driver.findElement(Input_Name).isDisplayed())
	    	{
	    		Assert.assertTrue(true);
	    		logger.info("Name input box is displayed");
	    		
	    	}else {
	    		logger.fatal("Name input box is not Displayed");
	    		Assert.fail("Name input box does not apper for login after click on sign up Button");
	    		
	    	}
	    }
	    public void EnterNameTextBox(String Text)
	    {
	    	logger.info("Name Entered in Name box:" + Text);
	    	driver.findElement(Input_Name).sendKeys(Text);
	    }
	    public void EnterMobNoBox(String text)
	    {
	    	logger.info("Number Entered in Mobile box" + text);
	    	driver.findElement(Input_mobile_no).sendKeys(text);
	    }
}
