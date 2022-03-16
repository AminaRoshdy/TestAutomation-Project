package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddToShoppingCartTestCases extends TestBase{

    HomePage homeObj;
    SearchPage searchObj;
    ProductDetailsPage DetailsPage;
    ShoppingCartPage shopObj;
    String ProductName= "Lenovo";

    @Test(priority = 1)
    public void SearchByProductSuccessfully () throws InterruptedException {
        searchObj= new SearchPage(driver);
        searchObj.SearchProduct(ProductName);

    }

    @Test (priority = 2)
    public void AddProductsToShoppingCart() throws InterruptedException {
        SoftAssert soft= new SoftAssert();
        DetailsPage= new ProductDetailsPage(driver);
        homeObj= new HomePage(driver);
        shopObj= new ShoppingCartPage(driver);
        Thread.sleep(2000);
        searchObj.AddProductToCart();
        searchObj.OpenDetailsPageofProduct();
        Thread.sleep(2000);
        DetailsPage.AddProductToShoppingCart();
        Thread.sleep(2000);
        System.out.println(" Number of products on shopping Cart= "+homeObj.ShoppingCartCount.getText());
        soft.assertTrue(homeObj.ShoppingCartCount.getText().contains("(2)"), "issue of Numer of products on shopping cart");
        soft.assertTrue(shopObj.SuccessMessage.isDisplayed(), " success message issue");

        homeObj.OpenShoppingCart();
        System.out.println(" Number of Rows=  "+shopObj.NumberofProductsonCart.size());
        soft.assertTrue((shopObj.NumberofProductsonCart.size()-5)==2);
    }

    @Test (priority = 3)
    public void RemoveProductFromShoppingCart()
    {
        homeObj.OpenShoppingCart();
        shopObj.RemoveProductFromShoppingCART();
        Assert.assertTrue(shopObj.NoDataMessage.getText().contains("Your Shopping Cart is empty!"));
        Assert.assertTrue(homeObj.ShoppingCartCount.getText().contains("(0)"));

    }


}
