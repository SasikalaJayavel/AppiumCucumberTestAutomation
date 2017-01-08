package co.uk.mybddapp.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertTrue;

@Component
@Scope("cucumber-glue")
public class SearchScreen extends AbstractScreen {

    @AndroidFindBy(id = "search_src_text")
    private WebElement find_Search_TextBox;

    @AndroidFindBy(id = "search_button")
    public WebElement find_Search_Button;

    @Autowired
    public SearchScreen(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    public void assert_For_Search_TextBox()
    {
        assertTrue(find_Search_TextBox.isDisplayed());
    }

    public void search_For_A_Product_Category(String category){
        find_Search_TextBox.sendKeys(category + "\n");

    }
}
