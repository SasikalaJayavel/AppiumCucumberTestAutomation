package co.uk.mybddapp.stepdefs;

import co.uk.mybddapp.utils.WaitUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

/**
 * Created by sasikala.jayavel on 20/12/2016.
 */
public class CommonSteps extends AbstractSteps
{

    @When("^I click on (.*?) (button|link)$")
    public void click_On(String clickOn, String screenName) throws Throwable {

        switch (clickOn.toLowerCase()) {
            case "search":
                searchScreen.find_Search_Button.click();
                break;

            default:
                throw new IllegalArgumentException(clickOn + " action not valid on the homescreen");
        }
    }

    @Then("^(.*?) should be displayed$")
    public void assert_Elements_Displayed(String elements_To_Check) throws Throwable {

        switch (elements_To_Check.toLowerCase()) {
            case "search textbox":
                searchScreen.assert_For_Search_TextBox();
                break;
            default:
                throw new IllegalArgumentException(elements_To_Check + " element not valid on the home screen");
        }
    }

    @When("^I click on (.*?) (button|link) on iOS$")
    public void click_On_iOS(String clickOn, String screenName) throws Throwable {

        switch (clickOn.toLowerCase()) {
            case "search":
                searchScreen.find_Search_Button.click();
                break;

            default:
                throw new IllegalArgumentException(clickOn + " action not valid on the homescreen in iOS");
        }
    }



}
