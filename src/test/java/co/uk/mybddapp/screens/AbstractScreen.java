package co.uk.mybddapp.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public abstract class AbstractScreen {

    @Value("${explicit.wait}")
    public int explicitWaitTime;
    @Value("${implicit.wait}")
    public int implicitWaitTime;
    @Value("${default.wait}")
    public int defaultWaitTime;
    public AppiumDriver<? extends MobileElement> driver;
    @Autowired
    private Environment env;

    public boolean context_Switched_To_Webview = false;

    public AbstractScreen(AppiumDriver<? extends MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, implicitWaitTime,
                TimeUnit.SECONDS), this);

    }



    public void switch_To_WebView()
    {
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println("contextnames" + contextName.toString()); //prints out something like NATIVE_APP \n WEBVIEW_1
            if (contextName.toString().toLowerCase().contains("webview"))
            {
                System.out.println("Switched to context webview");
                driver.context(contextName.toString()); // set context to WEBVIEW_1
                context_Switched_To_Webview = true;
            }
        }
//        driver.context(contextNames.toArray()[1].toString()); // set context to WEBVIEW_1
//        //do some web testing
//        String myText = driver.findElement(By.cssSelector(".green_button")).click();


    }

    public void switch_To_NativeApp()
    {

        if ( context_Switched_To_Webview)
        {
            System.out.println("Switching conext to Native app");
            driver.context("NATIVE_APP");
            context_Switched_To_Webview = false;
        }
    }
}
