package Tests;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchPage;
import Pages.WishesListPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WishesListTestCases extends TestBase{

    SearchPage searchObj;
    ProductDetailsPage DetailsPage;
    HomePage homeObj;
    WishesListPage wishObj;
    String ProductName= "Laptop";

    @Test (priority = 1)
    public void SearchByProductSuccessfully () throws InterruptedException {
        searchObj= new SearchPage(driver);
        searchObj.SearchProduct(ProductName);

    }

    @Test (priority = 2)
    public void AddProductsToWishesList() throws InterruptedException {
        DetailsPage= new ProductDetailsPage(driver);
        homeObj= new HomePage(driver);
        Thread.sleep(2000);
        searchObj.AddProductToWishesListFromSearchResult();
        searchObj.OpenDetailsPageofProduct();
        Thread.sleep(2000);
        DetailsPage.AddToWishListFromProductDetails();
        Thread.sleep(2000);
        Assert.assertTrue(homeObj.WishListCount.getText().contains("(2)"));

        homeObj.OpenWishesList();
        wishObj= new WishesListPage(driver);
        System.out.println(" Number of Rows=  "+wishObj.tabelRows.size());
        Assert.assertTrue((wishObj.tabelRows.size()-1)==2);
    }
    @Test (priority = 3)
    public void RemoveProductFromWishesList()
    {
        wishObj.removeProsudtFromWishesList();
        Assert.assertTrue(wishObj.NoDataMessage.getText().contains("The wishlist is empty!"));

    }



}
