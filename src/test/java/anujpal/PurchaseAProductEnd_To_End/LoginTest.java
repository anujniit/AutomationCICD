package anujpal.PurchaseAProductEnd_To_End;

import org.testng.annotations.Test;

import Utils.ExcelUtils;


public class LoginTest {

	@Test(dataProvider = "loginData", dataProviderClass = ExcelUtils.class, priority = 1)
	public void testLogin(String username, String password)
	{
		LoginPage loginPage=new LoginPage();
		loginPage.loginFunction(username, password);
	}
}
