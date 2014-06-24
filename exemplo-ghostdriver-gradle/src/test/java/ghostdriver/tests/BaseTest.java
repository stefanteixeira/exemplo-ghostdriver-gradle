package ghostdriver.tests;

import ghostdriver.setup.DriverFactory;
import ghostdriver.setup.ScreenshotOnFailureListener;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners(ScreenshotOnFailureListener.class)
public class BaseTest
{
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUp()
	{
		driver = DriverFactory.getDriver();
	}

	@AfterClass
	public static void tearDown()
	{
		driver.quit();
	}	
}
