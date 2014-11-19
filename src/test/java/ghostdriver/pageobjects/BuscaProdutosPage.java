package ghostdriver.pageobjects;

import static ghostdriver.setup.Constantes.TITULO_PAGINA_BUSCA;

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
		return ExpectedConditions.titleContains(TITULO_PAGINA_BUSCA);
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
