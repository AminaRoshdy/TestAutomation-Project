package Tests;

import Utilities.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TestBase {
    WebDriver driver= null;

    @BeforeClass
    public  void openChrome() throws InterruptedException
    {
        String chromPath= System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromPath);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");

        Thread.sleep(2000);
    }

    @AfterClass
    public void  CloseChome() throws InterruptedException
    {
        Thread.sleep(2000);
        driver.quit();
    }

    // if the test case is fail , take screenshot
    @AfterMethod
    public void TakeSreenShot(ITestResult res)
    {
        if(res.getStatus() == ITestResult.FAILURE)
        {
            System.out.println(" Test Case Fail, and Taking Screen shots ");
            Helper.SaveScreenShots(driver, res.getName());
        }
    }

}
