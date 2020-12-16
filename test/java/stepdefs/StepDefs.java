package stepdefs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Base.WebDriverFactory;
import PageObjects.ComnPageObject;
import PageObjects.HomePageObjects;
import PageObjects.SignInPageObjects;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


public class StepDefs {

	
	private static final Logger logger = LogManager.getLogger(StepDefs.class);
	
	WebDriver driver;
	String base_url="http://justdial.com";
	int implicit_wait_timeout_in_sec = 20;
	Scenario scn;
	
	
	ComnPageObject comnPageObject;
	HomePageObjects homePageObjects;
	SignInPageObjects signInPageObjects;
	
	@Before
	
	public void setUp(Scenario scn) throws Exception
	{
		this.scn = scn;
		
		String browserName = WebDriverFactory.getBrowserName();
		driver = WebDriverFactory.getWebDriverForBrowser(browserName);
		logger.info("Browser Invoked");
		
		comnPageObject = new ComnPageObject(driver);
		homePageObjects = new HomePageObjects(driver);
		signInPageObjects = new SignInPageObjects(driver);
	}
	@After(order=1)
	public void cleanUp()
	{
		WebDriverFactory.quitDriver();
		scn.log("Browser Closed");
	}
	 @After(order=2)
	    public void takeScreenShot(Scenario s) {
	        if (s.isFailed()) {
	            TakesScreenshot scrnShot = (TakesScreenshot)driver;
	            byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
	            scn.attach(data, "image/png","Failed Step Name: " + s.getName());
	        }else{
	            scn.log("Test case is passed, no screen shot captured");
	        }
	 }
@Given("User navigates to the application url")
public void User_navigates_to_the_application_url() {
	WebDriverFactory.navigateToTheUrl(base_url);
	scn.log("Browser Navigated To the Url : " + base_url);
}
@When("User clicks on Sign up link at the top right corner of the application")
public void User_clicks_on_Signup_link_at_the_top_right_corner_of_the_application()
{
	signInPageObjects.EnterNameTextBox("Akash");
	signInPageObjects.EnterMobNoBox("9123456789");
	logger.info("Name  and Mobile number Enter:");
}
}
