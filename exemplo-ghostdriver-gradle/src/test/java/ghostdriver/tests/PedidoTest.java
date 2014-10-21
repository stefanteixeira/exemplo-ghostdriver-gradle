package ghostdriver.tests;

import ghostdriver.pageobjects.HomePage;
import ghostdriver.setup.Constantes;

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
			.login(Constantes.EMAIL, Constantes.SENHA)
			.voltarParaHomePage();
	}
	
	@Test
	public void efetuarPedido()
	{
		home.adicionarAoCarrinho(Constantes.LIVRO_MENINA_QUE_ROUBAVA)
			.voltarParaHomePage()
			.adicionarAoCarrinho(Constantes.LIVRO_FORTALEZA_DIGITAL)
			.fecharCompra()
			.comMesmoEndereco()
			.comMetodoDeEnvio(Constantes.METODO_ENVIO_PAC)
			.comPagamentoPorCartaoCredito();
	}
}
