package ghostdriver.pageobjects;

import static ghostdriver.setup.Constantes.TITULO_PAGINA_CARRINHO_COMPRAS;
import static ghostdriver.setup.Mensagens.MENSAGEM_SUCESSO_CARRINHO_COMPRAS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarrinhoComprasPage extends BasePage
{
	@FindBy(css="button[title='Fechar Compra']")
	private WebElement btnFecharCompra;
	
	public CarrinhoComprasPage()
	{
		super();
	}
	
	@Override
	protected ExpectedCondition<?> getPageLoadCondition()
	{
		return ExpectedConditions.titleContains(TITULO_PAGINA_CARRINHO_COMPRAS);
	}

	public boolean isMsgSucessoPresente()
	{
		String xpathMsgSucesso = "//li[@class='success-msg']/ul/li/span";
		WebElement msgSucesso = driver.findElement(By.xpath(xpathMsgSucesso));
		
		return wait.until(ExpectedConditions.textToBePresentInElement(msgSucesso, MENSAGEM_SUCESSO_CARRINHO_COMPRAS));
	}
	
	public FecharCompraPage fecharCompra()
	{
		btnFecharCompra.click();
		
		return new FecharCompraPage();
	}
	
	public HomePage voltarParaHomePage()
	{
		return new HomePage();
	}
}
