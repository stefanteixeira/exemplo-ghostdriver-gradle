package ghostdriver.setup;

import static ghostdriver.setup.DriverFactory.getDriver;
import static ghostdriver.setup.DriverFactory.getWait;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Util
{
	public static String getUrl()
	{
		return getDriver().getCurrentUrl();
	}
	
	public static void selectCheckbox(WebElement checkbox)
	{
		checkbox.click();
		getWait().until(ExpectedConditions.elementToBeSelected(checkbox));
	}
	
	public static void selectRadioButton(WebElement radioButton)
	{
		selectCheckbox(radioButton);
	}
	
	public static void selectOption(WebElement selectElement, String option)
	{
		Select combobox = new Select(selectElement);
		combobox.selectByVisibleText(option);
	}
}
