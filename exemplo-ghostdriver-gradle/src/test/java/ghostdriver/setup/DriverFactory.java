package ghostdriver.setup;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class DriverFactory
{
	private static WebDriver driver;
	private static Wait<WebDriver> wait;
	protected static DesiredCapabilities dcaps;
	protected static Properties config;

	private static final String CONFIG_FILE = "src/test/resources/config.properties";
	private static final String DRIVER_PHANTOMJS = "phantomjs";
	private static final String DRIVER_CHROME = "chrome";

	public static WebDriver getDriver()
	{
		if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null)
		{
			createDriver();
		}

		return driver;
	}

	public static WebDriver createDriver()
	{
		String driverProperty = getProperty("driver");
		
		if (driverProperty.equals(DRIVER_PHANTOMJS))
		{
			dcaps = DesiredCapabilities.phantomjs();
			dcaps.setJavascriptEnabled(true);
			dcaps.setCapability("takesScreenshot", false);
			ArrayList<String> cliArgsCap = new ArrayList<String>();
			cliArgsCap.add("--web-security=false");
			cliArgsCap.add("--ssl-protocol=any");
			cliArgsCap.add("--ignore-ssl-errors=true");
			cliArgsCap.add("--proxy-type=none");
			dcaps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS,
					cliArgsCap);
			driver = new PhantomJSDriver(dcaps);
			driver.manage().window().maximize();
		}
		if (driverProperty.equals(DRIVER_CHROME))
		{
			File file = new File("/Users/stefan/Downloads/chromedriver");
			System.setProperty("webdriver.chrome.driver",
					file.getAbsolutePath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = null;

		return driver;
	}

	public static Wait<WebDriver> getWait()
	{
		if (wait == null)
		{
			wait = createWait(10, 2);
		}

		return wait;
	}

	public static Wait<WebDriver> createWait(long withTimeout, long pollingEvery)
	{
		return new FluentWait<WebDriver>(getDriver())
				.withTimeout(withTimeout, TimeUnit.SECONDS)
				.pollingEvery(pollingEvery, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);		
	}
	
	private static Properties loadPropertiesFile() throws Exception
	{
		config = new Properties();
		config.load(new FileReader(CONFIG_FILE));

		return config;
	}

	public static String getProperty(String property)
	{
		try {
			Properties file = loadPropertiesFile();
			return file.getProperty(property, DRIVER_PHANTOMJS);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "Não foi possível carregar a propriedade do arquivo de configurações.";
		}
	}
}
