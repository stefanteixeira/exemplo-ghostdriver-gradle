package ghostdriver.tests;

import static ghostdriver.setup.Constantes.EMAIL;
import static ghostdriver.setup.Constantes.SENHA;
import static ghostdriver.setup.Util.getUrl;
import static org.testng.Assert.assertTrue;
import ghostdriver.pageobjects.HomePage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LinksMenuTest extends BaseTest
{
	private HomePage home;
	
	@BeforeClass
	public void abrirPagina()
	{
		home = new HomePage();
		home.abrirPaginaLogin()
			.login(EMAIL, SENHA)
			.voltarParaHomePage();
	}
	
	@Test
	public void verificarRedirecionamentoLinkMinhaConta()
	{
		home.abrirMinhaConta();
		
		assertTrue(getUrl().contains("/customer/account"));
	}
	
	@Test
	public void verificarRedirecionamentoLinkListaDesejos()
	{
		home.abrirListaDesejos();
		
		assertTrue(getUrl().contains("/wishlist"));
	}
	
	@Test
	public void verificarRedirecionamentoLinkCarrinho()
	{
		home.abrirCarrinho();
		
		assertTrue(getUrl().contains("/cart"));
	}
	
	@Test
	public void verificarRedirecionamentoLinkFecharCompra()
	{
		home.abrirPaginaFecharCompra();
		
		assertTrue(getUrl().contains("/checkout/onepage"));
	}
}
