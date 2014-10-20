package ghostdriver.tests;

import static ghostdriver.setup.Constantes.LIVRO_FORTALEZA_DIGITAL;
import static ghostdriver.setup.Constantes.PRODUTO_NAO_EXISTENTE;
import static ghostdriver.setup.Mensagens.MENSAGEM_BUSCA_VAZIA;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import ghostdriver.pageobjects.BuscaProdutosPage;
import ghostdriver.pageobjects.HomePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BuscarProdutosTest extends BaseTest
{
	private HomePage home;
	private BuscaProdutosPage paginaBusca;
	
	@BeforeMethod(alwaysRun=true)
	public void abrePagina()
	{
		home = new HomePage();
	}

	@Test
	public void buscarProduto()
	{
		paginaBusca = home.buscarProduto(LIVRO_FORTALEZA_DIGITAL);
		
		assertTrue(paginaBusca.isResultadoBuscaPresente());
	}
	
	@Test
	public void buscarProdutoSemSucesso()
	{
		paginaBusca = home.buscarProduto(PRODUTO_NAO_EXISTENTE);
		
		assertEquals(MENSAGEM_BUSCA_VAZIA, paginaBusca.getMensagemBuscaVazia());
	}
}
