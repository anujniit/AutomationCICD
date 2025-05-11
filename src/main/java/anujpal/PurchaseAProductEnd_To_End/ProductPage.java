package anujpal.PurchaseAProductEnd_To_End;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GlobalComponent.CommonUtility;

public class ProductPage extends BaseTest {

	public ProductPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(css = ".mb-3")
	List<WebElement> productList;
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	@FindBy(xpath = "//div[contains(text(),'Product Added To Cart')]")
	WebElement toastMessege;
	
	@FindBy(xpath = "(//button[contains(text(),' Add To Cart')])[3]")
	WebElement addToCartButton;
	
	public Boolean VerifyProductDisplay(String productName) {
		CommonUtility commonUtility=new CommonUtility();
		commonUtility.waitForElementList(productList);
		//Boolean match = productList.stream().anyMatch(product -> product.findElement(By.tagName("b")).getText().equalsIgnoreCase(productName));
		 boolean match = productList.stream().anyMatch(product -> {
	            try {
	                String name = product.findElement(By.tagName("b")).getText().trim();
	                return name.equalsIgnoreCase(productName.trim());
	            } catch (Exception e) {
	                return false;
	            }
	        });
		return match;

	}
	
	public void addToCart()
	{
		CommonUtility commonUtility=new CommonUtility();
		commonUtility.waitForElement(addToCartButton);
		addToCartButton.click();
		commonUtility.waitForElement(spinner);
	}
	
	public Boolean toastMessageAppear()
	{
		CommonUtility commonUtility=new CommonUtility();
		commonUtility.waitForElement(toastMessege);
		Boolean isDisplayed= toastMessege.isDisplayed();
		return isDisplayed;
	}
}
