package ghostdriver.tests;

import static ghostdriver.setup.Constantes.EMAIL;
import static ghostdriver.setup.Constantes.SENHA;
import static org.testng.Assert.assertTrue;
import ghostdriver.pageobjects.AcrescentarEnderecoPage;
import ghostdriver.pageobjects.HomePage;
import ghostdriver.pageobjects.ListaEnderecosPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ListaEnderecosTest extends BaseTest
{
	private HomePage home;
	private ListaEnderecosPage listaEnderecos;
	private AcrescentarEnderecoPage acrescentarEndereco;
	
	@BeforeClass
	public void efetuarLogin()
	{
		home = new HomePage();
		listaEnderecos = home.abrirPaginaLogin()
							 .login(EMAIL, SENHA)
							 .abrirListaEnderecos();
	}
	
	@Test
	public void acrescentarEndereco()
	{
		acrescentarEndereco = listaEnderecos.abrirPaginaAcrescentarEndereco();
		
		acrescentarEndereco.comEndereco("Rua Teste", "12345")
						   .comComplemento("5678")
						   .comBairro("Tijuca")
						   .comCidade("Rio de Janeiro")
						   .comEstado("Rio de Janeiro")
						   .comCEP("20111090")
						   .comTelefone("2199998888")
						   .setEnderecoCobrancaPadrao()
						   .salvar();
		
		assertTrue(listaEnderecos.isMsgSucessoPresente());
	}
}
