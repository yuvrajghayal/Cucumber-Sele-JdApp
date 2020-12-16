package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class HomePageObjects {

	private static final Logger logger = LogManager.getLogger(HomePageObjects.class);

    private WebDriver driver;
    
    private By nav_Singup = By.linkText("h_sin_up");
    
    
    
    public HomePageObjects(WebDriver driver) {
    	this.driver = driver;
    	
    }
    public void clickOnSingUp()
    {
    	driver.findElement(nav_Singup).click();
    	logger.info("click on Sing Up link");
    }
}
