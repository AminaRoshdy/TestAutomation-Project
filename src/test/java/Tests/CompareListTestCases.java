package Tests;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareListTestCases extends TestBase{

    SearchPage searchObj;
    ProductDetailsPage DetailsPage;
    HomePage homeObj;
    WishesListPage wishObj;
    CompareListPage compareObj;
    String ProductName= "Laptop";

    @Test(priority = 1)
    public void SearchByProductSuccessfully () throws InterruptedException {
        searchObj= new SearchPage(driver);
        searchObj.SearchProduct(ProductName);

    }

    @Test (priority = 2)
    public void AddProductsToWishesList() throws InterruptedException {
        DetailsPage= new ProductDetailsPage(driver);
        homeObj= new HomePage(driver);
        compareObj= new CompareListPage(driver);
        Thread.sleep(2000);
        searchObj.AddProductToCompareList();
        Thread.sleep(1000);
        Assert.assertTrue(compareObj.compareListLink.isDisplayed());
        searchObj.OpenDetailsPageofProduct();
        Thread.sleep(2000);
        DetailsPage.AddProductToCompareList();
        Thread.sleep(1000);
        Assert.assertTrue(compareObj.compareListLink.isDisplayed());
        compareObj.openCompareList();
        Assert.assertTrue(driver.getCurrentUrl().contains("compareproducts"),"issue of compare list page ");


    }


}

