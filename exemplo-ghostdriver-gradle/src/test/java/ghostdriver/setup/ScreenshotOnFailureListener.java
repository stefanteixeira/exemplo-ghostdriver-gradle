package ghostdriver.setup;

import static ghostdriver.setup.DriverFactory.getDriver;

import java.io.File;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ScreenshotOnFailureListener extends TestListenerAdapter
{
	@Override
	public void onTestFailure(ITestResult testResult)
	{
		super.onTestFailure(testResult);
		captureScreenshot(testResult.getClass().getSimpleName(), testResult.getMethod().getMethodName());
	}

	public void captureScreenshot(String className, String methodName)
	{
		try
		{
			new File("target/screenshots/").mkdirs();
			Calendar c = Calendar.getInstance();
			int hora = c.get(Calendar.HOUR_OF_DAY);
			int minuto = c.get(Calendar.MINUTE);

			File f = ((TakesScreenshot) getDriver())
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File("target/screenshots/failures/" + className
					+ "-" + methodName + "-" + hora + "-" + minuto
					+ "-screenshot.png"));
		} catch (Exception e)
		{
		}
	}
}
