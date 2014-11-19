package ghostdriver.pageobjects;

import static ghostdriver.setup.Constantes.TITULO_PAGINA_FECHAR_COMPRA;
import static ghostdriver.setup.Util.selectRadioButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FecharCompraPage extends BasePage
{
	@FindBy(css="button[title='Continuar']")
	private WebElement btnContinuarInfoCobranca;
	
	@FindBy(xpath="//div[@id='shipping-method-buttons-container']/button/span")
	private WebElement btnContinuarMetodoEnvio;
	
	@FindBy(id="p_method_cobredireto")
	private WebElement inputMetodoPagamentoCartao;
	
	@FindBy(xpath="//div[@id='payment-buttons-container']/button/span")
	private WebElement btnContinuarMetodoPagamento;
	
	public FecharCompraPage()
	{
		super();
	}
	
	@Override
	protected ExpectedCondition<?> getPageLoadCondition()
	{
		return ExpectedConditions.titleContains(TITULO_PAGINA_FECHAR_COMPRA);
	}

	public FecharCompraPage comMesmoEndereco()
	{
		btnContinuarInfoCobranca.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-step-shipping_method")));
		
		return this;
	}
	
	public FecharCompraPage comMetodoDeEnvio(String metodoEnvio)
	{
		String xpathMetodoEnvio = "//div[@id='checkout-shipping-method-load']/dl/dd[1]/"
						+ "ul/li/label[contains(text(), '"+ metodoEnvio +"')]/../input";
		WebElement inputMetodoEnvio = driver.findElement(By.xpath(xpathMetodoEnvio));
		selectRadioButton(inputMetodoEnvio);
		
		btnContinuarMetodoEnvio.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-step-payment")));
		
		return this;
	}
	
	public FecharCompraPage comPagamentoPorCartaoCredito()
	{
		selectRadioButton(inputMetodoPagamentoCartao);
		
		btnContinuarMetodoPagamento.click();
		
		return this;
	}
}
