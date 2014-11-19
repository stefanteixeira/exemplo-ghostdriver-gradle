package ghostdriver.tests;

import static ghostdriver.setup.Util.getUrl;
import static org.testng.Assert.assertTrue;
import ghostdriver.pageobjects.HomePage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LinkTwitterTest extends BaseTest
{
	private HomePage home;
	
	@BeforeClass
	public void abrirPagina()
	{
		home = new HomePage();
	}
	
	@Test
	public void verificarRedirecionamentoLinkTwitter()
	{
		home.abrirLinkTwitter();
		
		assertTrue(getUrl().contains("twitter.com/lojaexemplo"));
	}
}
