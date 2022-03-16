package Tests;

import Pages.HomePage;
import Pages.PageBase;
import Pages.SubCategoryListingPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SelectTagsTestCases extends TestBase{

    HomePage homeObj;
    SubCategoryListingPage subObj;

    @Test(priority = 1)
    public void SelectShoesSubCategorySuccessfully () throws InterruptedException {
        homeObj= new HomePage(driver);
        homeObj.openApperalCategoryMenu();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("shoes"));
    }

    @Test (priority = 2)
    public void SelectTagSuccessfully ()
    {
        subObj=new SubCategoryListingPage(driver);
        subObj.OpenTagLink();
        SoftAssert soft= new SoftAssert();
        soft.assertTrue(driver.getCurrentUrl().contains("awesome"), "the URL not contain the tage name !!");
        soft.assertTrue(subObj.tagPageTitle.getText().contains("Products tagged with 'awesome'"), "The Title not Contain the tag Name!!");
    }
}
