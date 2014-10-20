package ghostdriver.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage
{
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="pass")
	private WebElement senha;
	
	@FindBy(css="button[title='Entrar']")
	private WebElement btnEntrar;
	
	@FindBy(className="error-msg")
	private WebElement msgErro;
	
	@FindBy(id="advice-required-entry-email")
	private WebElement msgEmailObrigatorio;
	
	@FindBy(id="advice-required-entry-pass")
	private WebElement msgSenhaObrigatoria;
	
	@FindBy(id="advice-validate-email-email")
	private WebElement msgEmailInvalido;
	
	@FindBy(id="advice-validate-password-pass")
	private WebElement msgSenhaInvalida;
	
	public LoginPage()
	{
		super();
	}
	
	@Override
	protected ExpectedCondition<?> getPageLoadCondition()
	{
		return ExpectedConditions.visibilityOf(email);
	}
	
	public MinhaContaPage login(String _email, String _senha)
	{
		preencherESubmeterForm(_email, _senha);
		
		return new MinhaContaPage();
	}
	
	public void loginSemSucesso(String _email, String _senha)
	{
		preencherESubmeterForm(_email, _senha);
		
		wait.until(ExpectedConditions.visibilityOf(msgErro));
	}
	
	public void loginSemSucessoValidacaoCampos(String _email, String _senha)
	{
		preencherESubmeterForm(_email, _senha);
	}

	public String getMensagemErro()
	{
		return msgErro.getText();
	}
	
	public String getMsgEmailObrigatorio()
	{
		wait.until(ExpectedConditions.visibilityOf(msgEmailObrigatorio));
		
		return msgEmailObrigatorio.getText();
	}
	
	public String getMsgSenhaObrigatoria()
	{
		wait.until(ExpectedConditions.visibilityOf(msgSenhaObrigatoria));
		
		return msgSenhaObrigatoria.getText();
	}
	
	public String getMsgEmailInvalido()
	{
		wait.until(ExpectedConditions.visibilityOf(msgEmailInvalido));
		
		return msgEmailInvalido.getText();
	}
	
	public String getMsgSenhaInvalida()
	{
		wait.until(ExpectedConditions.visibilityOf(msgSenhaInvalida));
		
		return msgSenhaInvalida.getText();
	}
	
	private void preencherESubmeterForm(String _email, String _senha)
	{
		email.clear();
		email.sendKeys(_email);
		senha.clear();
		senha.sendKeys(_senha);
		
		btnEntrar.click();
	}
}
