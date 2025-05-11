package anujpal.PurchaseAProductEnd_To_End;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfirmMessageTest {

	@Test(priority = 5, retryAnalyzer = Utils.RetryTest.class)
	public void confirmPageTest()
	{
		ConfirmationPage confirmationPage = new ConfirmationPage();
		//confirmationPage.confirmMessage
		Assert.assertTrue(confirmationPage.confirmMessage.getText().equalsIgnoreCase("Thankyou for the order."));
	}
}
