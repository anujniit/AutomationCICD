package GlobalComponent;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import anujpal.PurchaseAProductEnd_To_End.BaseTest;

public class CommonUtility extends BaseTest {

	public void waitForElement(WebElement element)
	{
		getWait().until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForElementList(List<WebElement> elementList)
	{
		getWait().until(ExpectedConditions.visibilityOfAllElements(elementList));
	}
	public void waitForElementToBeClickable(WebElement element)
	{
		getWait().until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForInvisisbilityOfElement(WebElement element)
	{
		getWait().until(ExpectedConditions.invisibilityOf(element));
	}
	
}
