package ghostdriver.tests;

import static ghostdriver.setup.Constantes.EMAIL;
import static ghostdriver.setup.Constantes.LIVRO_STEVE_JOBS;
import static ghostdriver.setup.Constantes.SENHA;
import static org.testng.Assert.assertTrue;
import ghostdriver.pageobjects.HomePage;
import ghostdriver.pageobjects.ListaDesejosPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ListaDesejosTest extends BaseTest
{
	private HomePage home;
	private ListaDesejosPage listaDesejos;
	
	@BeforeClass
	public void efetuarLogin()
	{
		home = new HomePage();
		home.abrirPaginaLogin()
			.login(EMAIL, SENHA)
			.voltarParaHomePage();
	}
	
	@Test
	public void adicionarProdutoListaDesejos()
	{
		listaDesejos = home.adicionarListaDesejos(LIVRO_STEVE_JOBS);
		
		assertTrue(listaDesejos.isMsgSucessoListaDesejosPresente());
	}
}
