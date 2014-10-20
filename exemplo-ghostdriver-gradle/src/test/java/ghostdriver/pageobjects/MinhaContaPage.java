package ghostdriver.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MinhaContaPage extends BasePage
{
	@FindBy(linkText="Lista de Endereços")
	private WebElement linkListaEnderecos;
	
	public MinhaContaPage()
	{
		super();
	}
	
	@Override
	protected ExpectedCondition<?> getPageLoadCondition()
	{
		return ExpectedConditions.titleContains("Minha Conta");
	}
	
	public ListaEnderecosPage abrirListaEnderecos()
	{
		linkListaEnderecos.click();
		
		return new ListaEnderecosPage();
	}
	
	public HomePage voltarParaHomePage()
	{
		return new HomePage();
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
}
