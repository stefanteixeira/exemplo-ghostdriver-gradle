package ghostdriver.pageobjects;

import static ghostdriver.setup.Mensagens.MENSAGEM_CARRINHO_VAZIO;
import static ghostdriver.setup.Mensagens.MENSAGEM_LISTA_COMPARACAO_VAZIA;
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
	
	@FindBy(id="search")
	private WebElement campoBusca;
	
	@FindBy(xpath="//button[@title='Buscar']")
	private WebElement btnBuscar;
	
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
		String xpathBtnComprar = "//a[contains(text(), '"+produto+"')]/../../div/form[@id='product_addtocart_form']/button";
		WebElement btnComprarProduto = driver.findElement(By.xpath(xpathBtnComprar));
		btnComprarProduto.click();
		
		return new CarrinhoComprasPage();
	}
	
	public void adicionarParaComparacao(String produto)
	{
		String xpathLinkComparacao = "//a[contains(text(), '"+produto+"')]/../../div/ul/li/a[contains(text(), 'Adicionar para Comparação')]";
		WebElement linkAdicionarComparacao = driver.findElement(By.xpath(xpathLinkComparacao));
		linkAdicionarComparacao.click();
	}
	
	public BuscaProdutosPage buscarProduto(String produto)
	{
		campoBusca.clear();
		campoBusca.sendKeys(produto);
		
		btnBuscar.click();
		
		return new BuscaProdutosPage();
	}

	public boolean isMsgSucessoListaComparacaoPresente()
	{
		String xpathMsgSucesso = "//li[@class='success-msg']/ul/li/span";
		WebElement msgSucesso = driver.findElement(By.xpath(xpathMsgSucesso));
		
		return wait.until(ExpectedConditions.textToBePresentInElement(msgSucesso, MENSAGEM_SUCESSO_LISTA_COMPARACAO));
	}
	
	public boolean isMsgCarrinhoVazioPresente()
	{
		String xpathMsgCarrinhoVazio = "//div[1]/div[2]/p[@class='empty']";
		WebElement msgCarrinhoVazio = driver.findElement(By.xpath(xpathMsgCarrinhoVazio));
		
		return wait.until(ExpectedConditions.textToBePresentInElement(msgCarrinhoVazio, MENSAGEM_CARRINHO_VAZIO));
	}
	
	public boolean isMsgListaComparacaoVaziaPresente()
	{
		String xpathMsgListaCompVazia = "//div[2]/div[2]/p[@class='empty']";
		WebElement msgListaCompVazia = driver.findElement(By.xpath(xpathMsgListaCompVazia));
		
		return wait.until(ExpectedConditions.textToBePresentInElement(msgListaCompVazia, MENSAGEM_LISTA_COMPARACAO_VAZIA));
	}
	
	public MapaSitePage abrirMapaSite()
	{
		linkMapaSite.click();
		
		return new MapaSitePage();
	}
}
