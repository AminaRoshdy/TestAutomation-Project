package Tests;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectCategoryTestCases extends TestBase{

    HomePage home;

    @Test
    public void SelectCategoryAndOpensUBcategorySuccessfully () throws InterruptedException {
        Thread.sleep(1000);
        home= new HomePage(driver);
        home.openCategoryMenu();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("desktops"));
    }
}
