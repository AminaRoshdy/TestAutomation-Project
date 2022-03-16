package Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.PortUnreachableException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PublicKey;

public class Helper {

    // Method to take screenshots when testcases are fail
    public static void SaveScreenShots (WebDriver driver, String ScreenShotName)
    {
        Path location= Paths.get("./ScreenShots",ScreenShotName+".png");
        try {
            Files.createDirectory(location.getParent());
            FileOutputStream fos= new FileOutputStream(location.toString());
            fos.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
            fos.close();
        }
        catch (IOException e)
        {
            System.out.println("Expection occurs while takeing screenshot");
            e.printStackTrace();
        }
    }
}
