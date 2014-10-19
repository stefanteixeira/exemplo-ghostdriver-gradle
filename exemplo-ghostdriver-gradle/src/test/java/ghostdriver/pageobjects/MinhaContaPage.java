package ghostdriver.pageobjects;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MinhaContaPage extends BasePage
{
	public MinhaContaPage()
	{
		super();
	}
	
	@Override
	protected ExpectedCondition<?> getPageLoadCondition()
	{
		return ExpectedConditions.titleContains("Minha Conta");
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}

}
