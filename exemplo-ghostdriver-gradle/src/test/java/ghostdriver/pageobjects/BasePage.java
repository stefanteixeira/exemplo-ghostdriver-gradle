package ghostdriver.pageobjects;

import ghostdriver.setup.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;

public abstract class BasePage
{
	protected WebDriver driver = DriverFactory.getDriver();
	protected Wait<WebDriver> wait = DriverFactory.getWait();
	
	public BasePage()
	{
		PageFactory.initElements(driver, this);

		wait.until(getPageLoadCondition());
	}

	protected abstract ExpectedCondition<?> getPageLoadCondition();
}
