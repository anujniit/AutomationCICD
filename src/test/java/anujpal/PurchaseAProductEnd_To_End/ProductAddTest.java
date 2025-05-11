package anujpal.PurchaseAProductEnd_To_End;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductAddTest {

	@Test(priority = 2)
	public void addProductToCart()
	{
		ProductPage productPage=new ProductPage();
		System.out.println(productPage.VerifyProductDisplay("IPHONE 13 PRO"));
		Assert.assertTrue(productPage.VerifyProductDisplay("IPHONE 13 PRO"));
		productPage.addToCart();
		Assert.assertTrue(productPage.toastMessageAppear());
	}
}
