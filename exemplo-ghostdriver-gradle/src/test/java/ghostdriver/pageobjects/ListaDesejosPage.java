package ghostdriver.pageobjects;

import static ghostdriver.setup.Constantes.TITULO_PAGINA_LISTA_DESEJOS;
import static ghostdriver.setup.Mensagens.MENSAGEM_SUCESSO_LISTA_DESEJOS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ListaDesejosPage extends BasePage
{
	public ListaDesejosPage()
	{
		super();
	}
	
	@Override
	protected ExpectedCondition<?> getPageLoadCondition()
	{
		return ExpectedConditions.titleContains(TITULO_PAGINA_LISTA_DESEJOS);
	}
	
	public boolean isMsgSucessoListaDesejosPresente()
	{
		String xpathMsgSucesso = "//li[@class='success-msg']/ul/li/span";
		WebElement msgSucesso = driver.findElement(By.xpath(xpathMsgSucesso));
		
		return wait.until(ExpectedConditions.textToBePresentInElement(msgSucesso, MENSAGEM_SUCESSO_LISTA_DESEJOS));
	}

}
