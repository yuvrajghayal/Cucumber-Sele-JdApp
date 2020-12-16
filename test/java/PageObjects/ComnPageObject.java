package PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ComnPageObject {
	private static final Logger logger = LogManager.getLogger(ComnPageObject.class);
	WebDriver driver;
	
	private By Search_Text_Box = By.id("srchbx");
	private By Search_Button = By.xpath("//a[@class='header_sprite search-icon srIconwpr']");
	private By nav_login = By.id("h_login");
	
	public ComnPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void SetSearchTextBox(String text) {
		WebDriverWait webDriverWait = new WebDriverWait(driver,20);
		WebElement elementSearchBox = webDriverWait.until(ExpectedConditions.elementToBeClickable(Search_Text_Box));
		elementSearchBox.clear();
		elementSearchBox.sendKeys(text);
		logger.info("Value entered in search box: " + text);
	}
	public void ClickOnSearchButton() {
		driver.findElement(Search_Button).click();
		logger.info("Clicked on Search Button");
	}
	public void validateElementPresentInHeaderSection(String text) throws Exception {
		boolean b=false;

		switch(text.toLowerCase().trim()) {

		case "Login Account":
			b= driver.findElement(nav_login).isDisplayed();
			break;
		case "Search Text box":
			b = driver.findElement(Search_Text_Box).isDisplayed();
			break;
		default:
			logger.fatal("Header Link Description is not present in the case. Please add link description first.");
			throw new Exception("Header Link Description is not present in the case. Please add link description first.");
		}

		if (b) {
			logger.info("Header Link is displayed: " + text);
			Assert.assertEquals("Header Link displayed",true, b);
		}else {
			logger.fatal("Header Link is not displayed: " + text);
			Assert.fail("Header Link is not displayed: " + text);
		}
}
}
