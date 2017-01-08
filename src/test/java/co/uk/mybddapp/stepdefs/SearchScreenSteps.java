package co.uk.mybddapp.stepdefs;

import cucumber.api.java.en.When;

/**
 * Created by sasikalaj on 5/3/16.
 */

public class SearchScreenSteps extends AbstractSteps {

    @When("^I search for a product category (.*?)$")
    public void search_Product_Category(String category)
    {
        searchScreen.search_For_A_Product_Category(category);
    }


}
