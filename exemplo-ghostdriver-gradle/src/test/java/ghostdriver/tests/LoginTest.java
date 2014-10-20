package ghostdriver.tests;

import static ghostdriver.setup.Constantes.EMAIL;
import static ghostdriver.setup.Constantes.EMAIL_INVALIDO;
import static ghostdriver.setup.Constantes.SENHA;
import static ghostdriver.setup.Constantes.SENHA_INCORRETA;
import static ghostdriver.setup.Constantes.TITULO_PAGINA_MINHA_CONTA;
import static ghostdriver.setup.Mensagens.MENSAGEM_CAMPO_OBRIGATORIO;
import static ghostdriver.setup.Mensagens.MENSAGEM_EMAIL_INVALIDO;
import static ghostdriver.setup.Mensagens.MENSAGEM_SENHA_INVALIDA;
import static ghostdriver.setup.Mensagens.MENSAGEM_USUARIO_SENHA_INVALIDO;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import ghostdriver.pageobjects.HomePage;
import ghostdriver.pageobjects.LoginPage;
import ghostdriver.pageobjects.MinhaContaPage;
import ghostdriver.setup.Constantes;

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
		minhaConta = paginaLogin.login(EMAIL, SENHA);
		
		assertTrue(minhaConta.getPageTitle().contains(TITULO_PAGINA_MINHA_CONTA));
	}
	
	@Test
	public void efetuarLoginSenhaInvalida()
	{
		paginaLogin.loginSemSucesso(EMAIL, SENHA_INCORRETA);
		
		assertEquals(MENSAGEM_USUARIO_SENHA_INVALIDO, paginaLogin.getMensagemErro());
	}
	
	@Test
	public void efetuarLoginComEmailEmBranco()
	{
		paginaLogin.loginSemSucessoValidacaoCampos("", SENHA);
		
		assertEquals(MENSAGEM_CAMPO_OBRIGATORIO, paginaLogin.getMsgEmailObrigatorio());
	}
	
	@Test
	public void efetuarLoginComSenhaEmBranco()
	{
		paginaLogin.loginSemSucessoValidacaoCampos(EMAIL, "");
		
		assertEquals(MENSAGEM_CAMPO_OBRIGATORIO, paginaLogin.getMsgSenhaObrigatoria());
	}
	
	@Test
	public void efetuarLoginComEmailInvalido()
	{
		paginaLogin.loginSemSucessoValidacaoCampos(EMAIL_INVALIDO, SENHA);
		
		assertEquals(MENSAGEM_EMAIL_INVALIDO, paginaLogin.getMsgEmailInvalido());
	}
	
	@Test
	public void efetuarLoginComSenhaInvalida()
	{
		paginaLogin.loginSemSucessoValidacaoCampos(EMAIL, Constantes.SENHA_INVALIDA);
		
		assertEquals(MENSAGEM_SENHA_INVALIDA, paginaLogin.getMsgSenhaInvalida());
	}
	
	@AfterGroups(groups="logout")
	public void logout()
	{
		home.sair();
	}
}
