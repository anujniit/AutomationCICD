
package Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import anujpal.PurchaseAProductEnd_To_End.BaseTest;

public class ScreenshotUtility {

	
	static String screenshotPath;
	public static String captureScreenshot(String testName)
	{
		WebDriver driver=BaseTest.getDriver();
		if (driver == null) {
            System.out.println("Driver is not initialized. Screenshot could not be captured.");
            return null;
        }
		try 
		{
			
			File srcFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String timestamp= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmSS"));
			File destinationFile=new File("./Screenshot/" + testName + "_" + timestamp + ".png");
			Files.copy(srcFile.toPath(), destinationFile.toPath());
			screenshotPath=destinationFile.getAbsolutePath();
			System.out.println("Screenshot saved at: " + screenshotPath);
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotPath;
	}
}
