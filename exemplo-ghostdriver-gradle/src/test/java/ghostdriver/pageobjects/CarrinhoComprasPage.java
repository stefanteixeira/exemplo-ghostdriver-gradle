package ghostdriver.pageobjects;

import static ghostdriver.setup.Mensagens.MENSAGEM_SUCESSO_CARRINHO_COMPRAS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarrinhoComprasPage extends BasePage
{
	public CarrinhoComprasPage()
	{
		super();
	}
	
	@Override
	protected ExpectedCondition<?> getPageLoadCondition()
	{
		return ExpectedConditions.titleContains("Carrinho de Compras");
	}

	public boolean isMsgSucessoPresente()
	{
		String xpathMsgSucesso = "//li[@class='success-msg']/ul/li/span";
		WebElement msgSucesso = driver.findElement(By.xpath(xpathMsgSucesso));
		
		return wait.until(ExpectedConditions.textToBePresentInElement(msgSucesso, MENSAGEM_SUCESSO_CARRINHO_COMPRAS));
	}
}
