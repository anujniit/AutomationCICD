package anujpal.PurchaseAProductEnd_To_End;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GlobalComponent.CommonUtility;

public class LoginPage extends BaseTest {

	public LoginPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(css = "#userEmail")
	WebElement userEmail;
	
	@FindBy(css = "#userPassword")
	WebElement userPassword;
	
	@FindBy(css = "#login")
	WebElement loginButton;
	
	
	public void loginFunction(String user, String pass)
	{
		CommonUtility commonUtility=new CommonUtility();
		commonUtility.waitForElement(userEmail);
		userEmail.sendKeys(user);
		userPassword.sendKeys(pass);
		loginButton.click();
	}
}
