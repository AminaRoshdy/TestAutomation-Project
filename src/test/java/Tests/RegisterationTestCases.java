package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterationTestCases extends TestBase{

    HomePage homeObj;
    RegisterationPage registerObj;
    LoginPage loginObj;
    String email= "test33@auto.com";


    // register with valid  email
    @Test (priority = 1)
    public  void UserCanRegisterSuccessfully()
    {
        homeObj= new HomePage(driver);
        registerObj= new RegisterationPage(driver);
        homeObj.OpenRegisterationForm();
        registerObj.Regiseration("Amina","Shams",email,"1234567");

        //verify the success message appears
        Assert.assertTrue(registerObj.successMeg.getText().contains("Your registration completed"));
    }

    @Test (priority = 2, dependsOnMethods = {"UserCanRegisterSuccessfully"})
    public void UserCanLogoutSuccessfully()
    {
        registerObj.userLogout();
        Assert.assertTrue(homeObj.LoginLink.isDisplayed());
    }


    @Test(priority = 4, dependsOnMethods ={"UserCanLogoutSuccessfully"})
    public void UserCanLoginSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        homeObj.OpenLoginPage();
        loginObj= new LoginPage(driver);
        loginObj.userLogin(email,"1234567" );
        Thread.sleep(1000);
        Assert.assertTrue(registerObj.logoutLink.isDisplayed());
    }
}
