package ghostdriver.tests;

import static ghostdriver.setup.Constantes.EMAIL;
import static ghostdriver.setup.Constantes.LIVRO_FORTALEZA_DIGITAL;
import static ghostdriver.setup.Constantes.LIVRO_MENINA_QUE_ROUBAVA;
import static ghostdriver.setup.Constantes.METODO_ENVIO_PAC;
import static ghostdriver.setup.Constantes.SENHA;
import ghostdriver.pageobjects.HomePage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PedidoTest extends BaseTest
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
	public void efetuarPedido()
	{
		home.adicionarAoCarrinho(LIVRO_MENINA_QUE_ROUBAVA)
			.voltarParaHomePage()
			.adicionarAoCarrinho(LIVRO_FORTALEZA_DIGITAL)
			.fecharCompra()
			.comMesmoEndereco()
			.comMetodoDeEnvio(METODO_ENVIO_PAC)
			.comPagamentoPorCartaoCredito();
	}
}
