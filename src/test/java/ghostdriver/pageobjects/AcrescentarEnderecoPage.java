package ghostdriver.pageobjects;

import static ghostdriver.setup.Constantes.TITULO_PAGINA_ACRESCENTAR_ENDERECO;
import static ghostdriver.setup.Util.selectCheckbox;
import static ghostdriver.setup.Util.selectOption;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AcrescentarEnderecoPage extends BasePage
{
	@FindBy(id="telephone")
	private WebElement telefone;
	
	@FindBy(id="street_1")
	private WebElement endereco;
	
	@FindBy(id="street_2")
	private WebElement numero;
	
	@FindBy(id="street_3")
	private WebElement complemento;
	
	@FindBy(id="street_4")
	private WebElement bairro;
	
	@FindBy(id="city")
	private WebElement cidade;
	
	@FindBy(id="region_id")
	private WebElement estado;
	
	@FindBy(id="zip")
	private WebElement cep;
	
	@FindBy(id="primary_billing")
	private WebElement checkEndCobrancaPadrao;
	
	@FindBy(css="button[title='Salvar Endereço']")
	private WebElement btnSalvar;
	
	public AcrescentarEnderecoPage()
	{
		super();
	}
	
	@Override
	protected ExpectedCondition<?> getPageLoadCondition()
	{
		return ExpectedConditions.titleContains(TITULO_PAGINA_ACRESCENTAR_ENDERECO);
	}

	public AcrescentarEnderecoPage comEndereco(String _endereco, String _numero)
	{
		endereco.sendKeys(_endereco);
		numero.sendKeys(_numero);
		
		return this;
	}
	
	public AcrescentarEnderecoPage comComplemento(String _complemento)
	{
		complemento.sendKeys(_complemento);
		
		return this;
	}
	
	public AcrescentarEnderecoPage comBairro(String _bairro)
	{
		bairro.sendKeys(_bairro);
		
		return this;
	}
	
	public AcrescentarEnderecoPage comCidade(String _cidade)
	{
		cidade.sendKeys(_cidade);
		
		return this;
	}
	
	public AcrescentarEnderecoPage comEstado(String _estado)
	{
		selectOption(estado, _estado);
		
		return this;
	}
	
	public AcrescentarEnderecoPage comCEP(String _cep)
	{
		cep.sendKeys(_cep);
		
		return this;
	}
	
	public AcrescentarEnderecoPage comTelefone(String _telefone)
	{
		telefone.sendKeys(_telefone);
		
		return this;
	}
	
	public AcrescentarEnderecoPage setEnderecoCobrancaPadrao()
	{
		selectCheckbox(checkEndCobrancaPadrao);
		
		return this;
	}
	
	public ListaEnderecosPage salvar()
	{
		btnSalvar.submit();
		
		return new ListaEnderecosPage();
	}

}
