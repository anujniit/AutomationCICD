package anujpal.PurchaseAProductEnd_To_End;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GlobalComponent.CommonUtility;

public class ConfirmationPage extends BaseTest{

	public ConfirmationPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(css = ".hero-primary")
	WebElement confirmMessage;
	
	public String comfirmationMessage()
	{
		CommonUtility commonUtility=new CommonUtility();
		commonUtility.waitForElement(confirmMessage);
		String message=confirmMessage.getText();
		return message;
	}
}
