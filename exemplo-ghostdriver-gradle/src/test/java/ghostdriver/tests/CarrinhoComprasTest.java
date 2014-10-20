package ghostdriver.tests;

import static ghostdriver.setup.Constantes.LIVRO_FORTALEZA_DIGITAL;
import static org.testng.Assert.assertTrue;
import ghostdriver.pageobjects.CarrinhoComprasPage;
import ghostdriver.pageobjects.HomePage;

import org.testng.annotations.Test;

public class CarrinhoComprasTest extends BaseTest
{
	private HomePage home;
	private CarrinhoComprasPage carrinho;
	
	@Test
	public void adicionarProdutoAoCarrinho()
	{
		home = new HomePage();
		carrinho = home.adicionarAoCarrinho(LIVRO_FORTALEZA_DIGITAL);
		
		assertTrue(carrinho.isMsgSucessoPresente());
	}
}
