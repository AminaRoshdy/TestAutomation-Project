package Tests;

import Pages.HomePage;
import Pages.SearchPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchProductTestCases extends TestBase{

    SearchPage searchObj;
    String ProductName= "Laptop";

    @Test
    public void SearchByProductSuccessfully () throws InterruptedException {
        searchObj= new SearchPage(driver);
        searchObj.SearchProduct(ProductName);
        Thread.sleep(2000);
        for (WebElement product: searchObj.productsTitle) {
            System.out.println(product.getText());
            Assert.assertTrue(product.getText().contains(ProductName));

        }
        System.out.println(searchObj.GetTheProductName());

    }
}
