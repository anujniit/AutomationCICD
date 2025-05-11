package anujpal.PurchaseAProductEnd_To_End;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest {

	@Test(priority = 3)
	public void myCart()
	{
		CartPage cartPage=new CartPage();
		cartPage.clickOnCartButton();
		cartPage.verifyItemInCart("IPHONE 13 PRO");
		Assert.assertTrue(cartPage.verifyPaymentTitleDisplaye());
	}
}
