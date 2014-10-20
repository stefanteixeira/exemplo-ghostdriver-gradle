package ghostdriver.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class Util
{
	private static WebDriver driver = DriverFactory.getDriver();
	private static Wait<WebDriver> wait = DriverFactory.getWait();
	
	public static String getUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public static void selectCheckbox(WebElement checkbox)
	{
		checkbox.click();
		wait.until(ExpectedConditions.elementToBeSelected(checkbox));
	}
	
	public static void selectOption(WebElement selectElement, String option)
	{
		Select combobox = new Select(selectElement);
		combobox.selectByVisibleText(option);
	}
}
