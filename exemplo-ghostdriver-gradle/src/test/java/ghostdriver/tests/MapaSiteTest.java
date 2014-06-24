package ghostdriver.tests;

import static org.testng.Assert.assertEquals;
import ghostdriver.pageobjects.HomePage;
import ghostdriver.pageobjects.MapaSitePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MapaSiteTest extends BaseTest
{
	private HomePage home;
	private MapaSitePage mapaSite;
	
	@BeforeMethod
	public void abrirMapaSite()
	{
		home = new HomePage();
		mapaSite = home.abrirMapaSite();
	}
	
	@Test
	public void verificarNumeroCategorias()
	{
		assertEquals(23, mapaSite.getNumeroCategorias());
	}
	
	@Test
	public void verificarNumeroProdutos()
	{
		assertEquals(43, mapaSite.getNumeroProdutos());
	}
}
