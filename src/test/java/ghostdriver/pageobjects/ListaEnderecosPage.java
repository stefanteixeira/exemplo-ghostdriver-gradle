package ghostdriver.pageobjects;

import static ghostdriver.setup.Constantes.TITULO_PAGINA_LISTA_ENDERECOS;
import static ghostdriver.setup.Mensagens.MENSAGEM_SUCESSO_ACRESCENTAR_ENDERECO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ListaEnderecosPage extends BasePage
{
	@FindBy(css="button[title='Acrescentar Endereço']")
	private WebElement btnAcrescentarEndereco;
	
	public ListaEnderecosPage()
	{
		super();
	}
	
	@Override
	protected ExpectedCondition<?> getPageLoadCondition()
	{
		return ExpectedConditions.titleContains(TITULO_PAGINA_LISTA_ENDERECOS);
	}
	
	public AcrescentarEnderecoPage abrirPaginaAcrescentarEndereco()
	{
		btnAcrescentarEndereco.click();
		
		return new AcrescentarEnderecoPage();
	}
	
	public boolean isMsgSucessoPresente()
	{
		String xpathMsgSucesso = "//li[@class='success-msg']/ul/li/span";
		WebElement msgSucesso = driver.findElement(By.xpath(xpathMsgSucesso));
		
		return wait.until(ExpectedConditions.textToBePresentInElement(msgSucesso, MENSAGEM_SUCESSO_ACRESCENTAR_ENDERECO));
	}

}
