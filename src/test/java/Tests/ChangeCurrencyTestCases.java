package Tests;

import Pages.HomePage;
import Pages.SearchPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.*;

public class ChangeCurrencyTestCases extends TestBase{

    HomePage homeObj;
    SearchPage searchObj;
    String ProductName= "Apple";


    @Test (priority = 1)
    public void UserChangeCurrencyToEuroSuccessfully() {
        homeObj= new HomePage(driver);
        homeObj.changeCurrency("Euro");
    }

    @Test (priority = 2)
    public void SearchByProductSuccessfully () throws InterruptedException {
        searchObj= new SearchPage(driver);
        searchObj.SearchProduct(ProductName);
        sleep(2000);
        for (WebElement Price: searchObj.ProductPricesLbl) {
            System.out.println(Price.getText());
            Assert.assertTrue(Price.getText().contains("€"));
        }
    }

    @Test (priority = 3)
    public void UserChangeCurrencyToDollarSuccessfully() {
        homeObj= new HomePage(driver);
        homeObj.changeCurrency("US Dollar");
        for (WebElement Price: searchObj.ProductPricesLbl) {
            System.out.println(Price.getText());
            Assert.assertTrue(Price.getText().contains("$"));
        }
    }
}
