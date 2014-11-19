package ghostdriver.tests;

import static org.testng.Assert.assertTrue;
import ghostdriver.pageobjects.HomePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest
{
	private HomePage home;

	@BeforeMethod(alwaysRun=true)
	public void abrePagina()
	{
		home = new HomePage();
	}
	
	@Test
	public void verificarCarrinhoVazio()
	{
		assertTrue(home.isMsgCarrinhoVazioPresente());
	}
	
	@Test
	public void verificarListaComparacaoVazia()
	{
		assertTrue(home.isMsgListaComparacaoVaziaPresente());
	}
}
