package co.uk.mybddapp.screens;

import co.uk.mybddapp.utils.WaitUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertTrue;

@Component
@Scope("cucumber-glue")
public class SearchScreen extends AbstractScreen {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Accessibility Node Provider']")
    private WebElement find_Search_TextBox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Accessibility']")
    public WebElement find_Search_Button;

    @Autowired
    public SearchScreen(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    public void assert_For_Search_TextBox()
    {
        WaitUtils.fluent_By_Wait_For_Element_Displayed(driver, By.xpath("//android.widget.TextView[@text='Accessibility Node Provider']"), 15, 1);
        assertTrue(find_Search_TextBox.isDisplayed());
    }

    public void search_For_A_Product_Category(String category){
        find_Search_TextBox.sendKeys(category + "\n");

    }
}
