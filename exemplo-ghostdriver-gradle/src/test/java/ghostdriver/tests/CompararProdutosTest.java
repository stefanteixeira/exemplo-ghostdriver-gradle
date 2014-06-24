package ghostdriver.tests;

import static org.testng.Assert.assertTrue;
import ghostdriver.pageobjects.HomePage;

import org.testng.annotations.Test;

public class CompararProdutosTest extends BaseTest
{
	private HomePage home;

	@Test
	public void adicionarLivroParaComparacao()
	{
		home = new HomePage();
		home.adicionarParaComparacao("A Menina que Roubava Livros");
		
		assertTrue(home.isMsgSucessoListaComparacaoPresente());
	}
}
