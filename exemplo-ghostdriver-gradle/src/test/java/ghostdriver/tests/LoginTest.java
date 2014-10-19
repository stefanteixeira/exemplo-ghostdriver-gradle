package ghostdriver.tests;

import static ghostdriver.setup.Mensagens.MENSAGEM_USUARIO_SENHA_INVALIDO;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import ghostdriver.pageobjects.HomePage;
import ghostdriver.pageobjects.LoginPage;
import ghostdriver.pageobjects.MinhaContaPage;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest
{
	private HomePage home;
	private LoginPage paginaLogin;
	private MinhaContaPage minhaConta;
	
	@BeforeMethod
	public void abrirPagina()
	{
		home = new HomePage();
		paginaLogin = home.abrirPaginaLogin();
	}
	
	@Test(groups="logout")
	public void efetuarLogin()
	{	
		minhaConta = paginaLogin.login("stefanfk@gmail.com", "teste123");
		
		assertTrue(minhaConta.getPageTitle().contains("Minha Conta"));
	}
	
	@Test
	public void efetuarLoginSenhaInvalida()
	{
		paginaLogin.loginSemSucesso("stefanfk@gmail.com", "aaaaaaaaaaaa");
		
		assertEquals(MENSAGEM_USUARIO_SENHA_INVALIDO, paginaLogin.getMensagemErro());
	}
	
	@AfterGroups(groups="logout")
	public void logout()
	{
		home.sair();
	}
}
