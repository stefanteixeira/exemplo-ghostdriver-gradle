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

	public String getMensagemErro()
	{
		return msgErro.getText();
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
