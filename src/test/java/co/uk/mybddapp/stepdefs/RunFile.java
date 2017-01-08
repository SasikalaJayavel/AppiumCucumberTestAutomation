package co.uk.mybddapp.stepdefs;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
//        format = { "pretty",
//        "json:target/cucumber.json",
//        "html:target/site/cucumber-pretty"},
        glue = "co.uk.mybddapp.stepdefs" ,
        features="src/test/resources/features",
        tags="@solo")
public class RunFile
{


}
