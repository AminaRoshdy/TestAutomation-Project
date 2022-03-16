package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CompareListPage extends PageBase{
    public CompareListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (linkText = "product comparison")
    public WebElement compareListLink;

    public void openCompareList()
    {
        clickONButton(compareListLink);
    }


}
