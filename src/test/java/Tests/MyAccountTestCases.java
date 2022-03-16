package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.RegisterationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTestCases extends TestBase
{
   MyAccountPage myAccountObj;
   HomePage homeObj;
   RegisterationPage registerObj;
   LoginPage loginObj;
   String oldPassword= "aa@12345";
   String newPassword= "12345678";
   String confirmPassword="12345678";
   String Emial="Test@aa.com";

    @Test(priority = 1)
    public  void UserCanRegisterSuccessfully()
    {
        homeObj= new HomePage(driver);
        registerObj= new RegisterationPage(driver);
        homeObj.OpenRegisterationForm();
        registerObj.Regiseration("Amina","Roshdy",Emial,oldPassword);

        //verify the success message appears
        Assert.assertTrue(registerObj.successMeg.getText().contains("Your registration completed"));
    }
    @Test (priority = 2)
    public void LoggedUserChangePasswordSuccessfully () throws InterruptedException
    {
        Thread.sleep(2000);
        myAccountObj= new MyAccountPage(driver);
        registerObj.OpenMyAccountPage();
        myAccountObj.OpenChangePasswordForm();
        myAccountObj.ChangePassword(oldPassword, newPassword, confirmPassword);
        Thread.sleep(2000);
        Assert.assertTrue(myAccountObj.SuccessMessage.getText().contains("Password was changed"));
    }

    @Test (priority = 2)
    public void UserCanLogoutSuccessfully() throws InterruptedException {
        homeObj.openHomePage();
        Thread.sleep(2000);
        registerObj.userLogout();
        Assert.assertTrue(homeObj.LoginLink.isDisplayed());
    }

    @Test(priority = 3)
    public void UserCanLoginSuccessfully() throws InterruptedException {
        Thread.sleep(3000);
        homeObj.OpenLoginPage();
        loginObj= new LoginPage(driver);
        loginObj.userLogin(Emial,newPassword );
        Assert.assertTrue(registerObj.logoutLink.isDisplayed());
    }

}
