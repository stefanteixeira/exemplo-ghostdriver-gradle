package ghostdriver.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BuscaProdutosPage extends BasePage
{
	@FindBy(className="note-msg")
	private WebElement msgBuscaVazia;
	
	@FindBy(className="product-name")
	private WebElement itemResultadoBusca;
	
	public BuscaProdutosPage()
	{
		super();
	}
	
	@Override
	protected ExpectedCondition<?> getPageLoadCondition()
	{
		return ExpectedConditions.titleContains("Resultados da busca");
	}
	
	public String getMensagemBuscaVazia()
	{
		return msgBuscaVazia.getText();
	}
	
	public boolean isResultadoBuscaPresente()
	{
		return itemResultadoBusca.isDisplayed();
	}
}
