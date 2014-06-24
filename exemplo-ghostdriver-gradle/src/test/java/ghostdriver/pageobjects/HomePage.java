package ghostdriver.pageobjects;

import static ghostdriver.setup.Mensagens.MENSAGEM_SUCESSO_LISTA_COMPARACAO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage
{
	@FindBy(css="a[title='Mapa do Site']")
	private WebElement linkMapaSite;
	
	public HomePage()
	{
		super();
	}
	
	@Override
	protected ExpectedCondition<?> getPageLoadCondition()
	{
		driver.get("http://www.lojaexemplodelivros.com.br");
		return ExpectedConditions.titleContains("Loja Virtual de Exemplo");
	}
	
	public CarrinhoComprasPage adicionarAoCarrinho(String produto)
	{
		String xpathBtnComprar = "//ul/li/h2/a[contains(text(), '"+produto+"')]/../../div/form[@id='product_addtocart_form']/button";
		WebElement btnComprarProduto = driver.findElement(By.xpath(xpathBtnComprar));
		btnComprarProduto.click();
		
		return new CarrinhoComprasPage();
	}
	
	public HomePage adicionarParaComparacao(String produto)
	{
		String xpathLinkComparacao = "//ul/li/h2/a[contains(text(), '"+produto+"')]/../../div/ul/li/a[contains(text(), 'Adicionar para Comparação')]";
		WebElement linkAdicionarComparacao = driver.findElement(By.xpath(xpathLinkComparacao));
		linkAdicionarComparacao.click();
		
		return this;
	}

	public boolean isMsgSucessoListaComparacaoPresente()
	{
		String xpathMsgSucesso = "//li[@class='success-msg']/ul/li/span";
		WebElement msgSucesso = driver.findElement(By.xpath(xpathMsgSucesso));
		
		return wait.until(ExpectedConditions.textToBePresentInElement(msgSucesso, MENSAGEM_SUCESSO_LISTA_COMPARACAO));
	}
	
	public MapaSitePage abrirMapaSite()
	{
		linkMapaSite.click();
		
		return new MapaSitePage();
	}
}
