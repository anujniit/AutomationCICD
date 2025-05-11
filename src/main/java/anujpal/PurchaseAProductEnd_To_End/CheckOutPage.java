package anujpal.PurchaseAProductEnd_To_End;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import GlobalComponent.CommonUtility;

public class CheckOutPage extends BaseTest {

	public CheckOutPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement selectCountry;
	
//	@FindBy(xpath = "//section[@class='ta-results list-group ng-star-inserted']")
//	List<WebElement> countryListed;
	
	@FindBy(xpath = "//button[@type='button']")
	List<WebElement> countryListed;
	
	@FindBy(xpath = "//a[contains(.,'Place Order')]")
	WebElement placeOrderButton;
	
	@FindBy(css = ".ta-results")
	WebElement backDrop;
	
	public void country(String countryName)
	{
		CommonUtility commonUtility=new CommonUtility();
		Actions action=new Actions(getDriver());
//		action.click(selectCountry).build().perform();
//		selectCountry.sendKeys(countryName);
		action.click(selectCountry).sendKeys(countryName).build().perform();
		
		commonUtility.waitForElementList(countryListed);
		
		for(WebElement countryDisplays: countryListed)
		{
			String countryToSelect=countryDisplays.getText();
			System.out.println(countryToSelect);
			if(countryToSelect.equalsIgnoreCase(countryName))
			{
				commonUtility.waitForElementToBeClickable(countryDisplays);
				countryDisplays.click();
				break;
			}
		}
		
	}
	
	public void placeOrder() throws InterruptedException
	{
		CommonUtility commonUtility=new CommonUtility();
		commonUtility.waitForInvisisbilityOfElement(backDrop);
		commonUtility.waitForElement(placeOrderButton);
		placeOrderButton.click();
		   try {
		        // Try normal click first
		        placeOrderButton.click();
		    } catch (org.openqa.selenium.ElementClickInterceptedException e) {
		        System.out.println("Standard click failed. Trying JavaScript click...");

		        // Use JavaScript click as fallback
		        JavascriptExecutor js = (JavascriptExecutor) getDriver();
		        js.executeScript("arguments[0].click();", placeOrderButton);
		        Thread.sleep(5000);
		    }
	}
}
