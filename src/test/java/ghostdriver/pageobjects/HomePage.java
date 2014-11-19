package ghostdriver.pageobjects;

import static ghostdriver.setup.Constantes.TITULO_PAGINA_AJUDA;
import static ghostdriver.setup.Constantes.TITULO_PAGINA_BUSCA_AVANCADA;
import static ghostdriver.setup.Constantes.TITULO_PAGINA_SAC;
import static ghostdriver.setup.Constantes.TITULO_PAGINA_SOBRE_NOS;
import static ghostdriver.setup.Constantes.TITULO_PAGINA_TERMOS_BUSCA;
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
	@FindBy(css="a[title='Entrar']")
	private WebElement linkMenuEntrar;
	
	@FindBy(css="a[title='Minha Conta']")
	private WebElement linkMenuMinhaConta;
	
	@FindBy(xpath="//div/div/div[1]/div/div/ul/li[2]/a")
	private WebElement linkMenuListaDesejos;
	
	@FindBy(xpath="//div/div/div[1]/div/div/ul/li[3]/a")
	private WebElement linkMenuCarrinho;
	
	@FindBy(css="a[title='Fechar Compra']")
	private WebElement linkMenuFecharCompra;
	
	@FindBy(css="a[title='Sair']")
	private WebElement linkMenuSair;
	
	@FindBy(id="search")
	private WebElement campoBusca;
	
	@FindBy(xpath="//button[@title='Buscar']")
	private WebElement btnBuscar;
	
	@FindBy(linkText="Sobre Nós")
	private WebElement linkSobreNos;

	@FindBy(linkText="Serviço ao Cliente")
	private WebElement linkSac;
	
	@FindBy(linkText="Página de Ajuda")
	private WebElement linkAjuda;

	@FindBy(css="a[title='Mapa do Site']")
	private WebElement linkMapaSite;
	
	@FindBy(css="a[title='Termos de Busca']")
	private WebElement linkTermosBusca;
	
	@FindBy(css="a[title='Busca Avançada']")
	private WebElement linkBuscaAvancada;
	
	@FindBy(xpath="//div[@id='bloco-twitter']/p/a/img")
	private WebElement linkTwitter;
	
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

	public ListaDesejosPage adicionarListaDesejos(String produto)
	{
		String xpathLinkListaDesejos = "//a[contains(text(), '"+produto+"')]/../../div/ul/li/a[contains(text(), 'Adicionar à Lista de Desejos')]";
		WebElement linkListaDesejos = driver.findElement(By.xpath(xpathLinkListaDesejos));
		linkListaDesejos.click();
		
		return new ListaDesejosPage();
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
	
	public LoginPage abrirPaginaLogin()
	{
		linkMenuEntrar.click();
		
		return new LoginPage();
	}
	
	public MinhaContaPage abrirMinhaConta()
	{
		linkMenuMinhaConta.click();
		
		return new MinhaContaPage();
	}
	
	public ListaDesejosPage abrirListaDesejos()
	{
		linkMenuListaDesejos.click();
		
		return new ListaDesejosPage();
	}
	
	public CarrinhoComprasPage abrirCarrinho()
	{
		linkMenuCarrinho.click();
		
		return new CarrinhoComprasPage();
	}
	
	public FecharCompraPage abrirPaginaFecharCompra()
	{
		linkMenuFecharCompra.click();
		
		return new FecharCompraPage();
	}
	
	public MapaSitePage abrirMapaSite()
	{
		linkMapaSite.click();
		
		return new MapaSitePage();
	}

	public void sair()
	{
		linkMenuSair.click();
		wait.until(ExpectedConditions.visibilityOf(linkMenuEntrar));
	}
	
	public void abrirLinkSobreNos()
	{
		linkSobreNos.click();
		
		wait.until(ExpectedConditions.titleContains(TITULO_PAGINA_SOBRE_NOS));
	}
	
	public void abrirLinkSac()
	{
		linkSac.click();
		
		wait.until(ExpectedConditions.titleContains(TITULO_PAGINA_SAC));
	}
	
	public void abrirLinkAjuda()
	{
		linkAjuda.click();
		
		wait.until(ExpectedConditions.titleContains(TITULO_PAGINA_AJUDA));
	}
	
	public void abrirLinkTermosBusca()
	{
		linkTermosBusca.click();
		
		wait.until(ExpectedConditions.titleContains(TITULO_PAGINA_TERMOS_BUSCA));
	}
	
	public void abrirLinkBuscaAvancada()
	{
		linkBuscaAvancada.click();
		
		wait.until(ExpectedConditions.titleContains(TITULO_PAGINA_BUSCA_AVANCADA));
	}
	
	public void abrirLinkTwitter()
	{
		linkTwitter.click();
		
		wait.until(ExpectedConditions.titleContains("Twitter"));
	}
}
