package ghostdriver.tests;

import static ghostdriver.setup.Util.getUrl;
import static org.testng.Assert.assertTrue;
import ghostdriver.pageobjects.HomePage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LinksRodapeTest extends BaseTest
{
	private HomePage home;
	
	@BeforeClass
	public void abrirPagina()
	{
		home = new HomePage();
	}
	
	@Test
	public void verificarRedirecionamentoLinkSobreNos()
	{
		home.abrirLinkSobreNos();
		
		assertTrue(getUrl().contains("sobre-nos"));
	}
	
	@Test
	public void verificarRedirecionamentoLinkSAC()
	{
		home.abrirLinkSac();
		
		assertTrue(getUrl().contains("servico-ao-cliente"));
	}
	
	@Test
	public void verificarRedirecionamentoLinkAjuda()
	{
		home.abrirLinkAjuda();
		
		assertTrue(getUrl().contains("ajuda-loja-virtual"));
	}
}
