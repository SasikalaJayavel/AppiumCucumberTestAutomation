package co.uk.mybddapp.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.junit.Assert.assertTrue;

@Component
@Scope("cucumber-glue")
public class HomeScreen extends AbstractScreen {


    @Autowired
    public HomeScreen(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }



}
