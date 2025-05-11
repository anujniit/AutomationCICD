package anujpal.PurchaseAProductEnd_To_End;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GlobalComponent.CommonUtility;

public class CartPage extends BaseTest {
	
	public CartPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartButton;
	@FindBy(xpath = "//h1[text()='My Cart']")
	WebElement myCartText;
	@FindBy(css = ".cart")
	List<WebElement> cartList;
	@FindBy(xpath = "//button[contains(.,'Buy Now')]")
	WebElement buyNowButton;
	@FindBy(css = ".payment__title")
	WebElement paymentTitle;
	
	
	public void clickOnCartButton()
	{
		CommonUtility commonUtility=new CommonUtility();
		commonUtility.waitForElement(cartButton);
		cartButton.click();
	}
	
	public void verifyItemInCart(String productName)
	{
		CommonUtility commonUtility=new CommonUtility();
		commonUtility.waitForElementList(cartList);
		Boolean item=false;
		for(WebElement list:cartList)
		{
			String name = list.findElement(By.tagName("h3")).getText().trim();
			if(name.equalsIgnoreCase(productName))
			{
				buyNowButton.click();
				break;
			}
			
		}
		
		commonUtility.waitForElement(paymentTitle);
	}
	
	public Boolean verifyPaymentTitleDisplaye()
	{
		Boolean paymentTitletest=paymentTitle.isDisplayed();
		return paymentTitletest;
	}
}
