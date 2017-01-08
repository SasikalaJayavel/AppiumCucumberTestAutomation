package co.uk.mybddapp.stepdefs;

import co.uk.mybddapp.utils.WaitUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

/**
 * Created by sasikalaj on 5/3/16.
 */

public class HomeScreenSteps extends AbstractSteps {

    @Given("^(I am|User is) already in the home screen$")
    public void assert_Home_Screen(String suffix)
    {
        WaitUtils.wait_For_Visibility_Of_Element(homeScreen.driver, By.xpath("//android.widget.TextView[@text='Accessibility']"), 15);
    }

    @When("^I click on (.*?) (button|link) on the home screen$")
    public void click_On(String clickOn, String screenName) throws Throwable {

        switch (clickOn.toLowerCase()) {
            case "dummy":

                break;

            default:
                throw new IllegalArgumentException(clickOn + " action not valid on the homescreen");
        }
    }

    @Then("^(.*?) should be displayed on the home screen$")
    public void assert_Elements_Displayed(String elements_To_Check) throws Throwable {

        switch (elements_To_Check.toLowerCase()) {
            case "dummy":

                break;
            default:
                throw new IllegalArgumentException(elements_To_Check + " element not valid on the home screen");
        }
    }

    @Given("^(I am|User is) already in the home screen in iOS$")
    public void assert_Home_Screen_iOS(String suffix)
    {
        WaitUtils.wait_For_Visibility_Of_Element(homeScreen.driver, By.name("Home"), 15);
    }






}
