package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.temporal.IsoFields;

public class CheckOutTestCases extends TestBase{

    SearchPage searchObj;
    HomePage homeObj;
    String ProductName= "Laptop";
    ShoppingCartPage shopObj;
    RegisterationPage registerObj;
    CheckOutPage checkObj;
    String email="test44@aa.com";

    @Test (priority = 1)
    public  void UserCanRegisterSuccessfully()
    {
        homeObj= new HomePage(driver);
        registerObj= new RegisterationPage(driver);
        homeObj.OpenRegisterationForm();
        registerObj.Regiseration("Amina","Shams",email,"aa@12345");
        Assert.assertTrue(registerObj.successMeg.getText().contains("Your registration completed"),"the user can't register!!");
    }

    @Test(priority = 2)
    public void SearchByProductSuccessfully () throws InterruptedException {
        Thread.sleep(2000);
        searchObj= new SearchPage(driver);
        searchObj.SearchProduct(ProductName);

    }

    @Test (priority =3, dependsOnMethods = {"SearchByProductSuccessfully"})
    public void AddProductsToShoppingCart() throws InterruptedException {
        SoftAssert soft= new SoftAssert();
        homeObj= new HomePage(driver);
        shopObj= new ShoppingCartPage(driver);
        Thread.sleep(2000);
        searchObj.AddProductToCart();
        Thread.sleep(2000);
        soft.assertTrue(homeObj.ShoppingCartCount.getText().contains("(1)"));

        homeObj.OpenShoppingCart();
        System.out.println(" Number of Rows=  "+shopObj.NumberofProductsonCart.size());
        soft.assertTrue((shopObj.NumberofProductsonCart.size()-5)==1, "the number of product on Shopping Cart not correct");
    }

    @Test (priority = 4 , dependsOnMethods = {"AddProductsToShoppingCart"})
    public void LoggedUserCanCheckoutSuccessfully() throws InterruptedException {
        SoftAssert soft= new SoftAssert();
        checkObj= new CheckOutPage(driver);
        shopObj.SelectTermsofservice();
        shopObj.openCheckOutPage();
        Thread.sleep(3000);
        checkObj.EnterBillingAddress("Cairo","123 cairo", "12345","01020202");
        Thread.sleep(2000);
        soft.assertTrue(checkObj.successMessage.isDisplayed(),"issue of success message");
        soft.assertTrue(checkObj.OrderNumberTxt.isDisplayed(),"issue of Order Number");

    }


}
