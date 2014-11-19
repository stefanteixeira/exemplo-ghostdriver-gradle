package ghostdriver.tests;

import static ghostdriver.setup.Constantes.LIVRO_MENINA_QUE_ROUBAVA;
import static org.testng.Assert.assertTrue;
import ghostdriver.pageobjects.HomePage;

import org.testng.annotations.Test;

public class CompararProdutosTest extends BaseTest
{
	private HomePage home;

	@Test
	public void adicionarProdutoParaComparacao()
	{
		home = new HomePage();
		home.adicionarParaComparacao(LIVRO_MENINA_QUE_ROUBAVA);
		
		assertTrue(home.isMsgSucessoListaComparacaoPresente());
	}
}
