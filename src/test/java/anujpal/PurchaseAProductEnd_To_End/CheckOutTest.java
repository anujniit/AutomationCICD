package anujpal.PurchaseAProductEnd_To_End;

import org.testng.annotations.Test;

public class CheckOutTest {

	@Test(priority = 4, retryAnalyzer = Utils.RetryTest.class)
	public void checkOutItemTest() throws InterruptedException
	{
		CheckOutPage checkOutPage=new CheckOutPage();
		checkOutPage.country("India");
		checkOutPage.placeOrder();
	}
}
