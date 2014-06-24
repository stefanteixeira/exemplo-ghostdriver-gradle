package ghostdriver.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MapaSitePage extends BasePage
{
	@FindBy(css="a[title='Mapa dos Produtos']")
	private WebElement linkMapaProdutos;
	
	public MapaSitePage()
	{
		super();
	}
	
	@Override
	protected ExpectedCondition<?> getPageLoadCondition()
	{
		return ExpectedConditions.titleContains("Mapa do Site");
	}

	public int getNumeroCategorias()
	{
		List<WebElement> listaCategorias = getListaMapaSite();
		
		return listaCategorias.size();
	}
	
	public int getNumeroProdutos()
	{
		abrirMapaProdutos();
		List<WebElement> listaProdutos = getListaMapaSite();
		
		return listaProdutos.size();
	}
	
	private void abrirMapaProdutos()
	{
		linkMapaProdutos.click();
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.className("page-title"), "Produtos"));
	}
	
	private List<WebElement> getListaMapaSite()
	{
		String xpathListaMapaSite = "//ul[@class='sitemap']/li";
		return driver.findElements(By.xpath(xpathListaMapaSite));
	}
}
