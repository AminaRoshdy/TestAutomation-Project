package Tests;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SubCategoryListingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterByColorTestCases extends TestBase{

    HomePage homeObj;
    SubCategoryListingPage subObj;
    ProductDetailsPage detaiLsOBJ;

    @Test(priority = 1)
    public void SelectShoesSubCategorySuccessfully () throws InterruptedException {
        homeObj= new HomePage(driver);
        homeObj.openApperalCategoryMenu();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("shoes"));
    }

    @Test (priority = 2)
    public  void FilterByColorSuccessfully() throws InterruptedException {
        subObj= new SubCategoryListingPage(driver);
        subObj.FilterByRedColor();
        Thread.sleep(2000);
        Assert.assertTrue(subObj.RedColorCheckBox.isSelected());

    }

    @Test(priority = 3)
    public  void CheckColorOnDetailsPageofProduct() throws InterruptedException {
        detaiLsOBJ= new ProductDetailsPage(driver);
        subObj.OpenDetailsPageOfFirstProduct();
        System.out.println("the available color Of the product = "+detaiLsOBJ.ColorBoxes.get(0).getCssValue("background-color"));
        Assert.assertTrue(detaiLsOBJ.ColorBoxes.get(0).getCssValue("background-color").contains("rgba(102, 48, 48, 1)"));

    }





}
