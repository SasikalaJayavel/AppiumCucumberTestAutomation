package co.uk.mybddapp.stepdefs;

import co.uk.mybddapp.utils.BrowserFactory;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.net.MalformedURLException;

/**
 * Created by sasikalaj on 5/19/16.
 */
public class Hooks {
    @Autowired
    public BrowserFactory browserFactory;

    private static AppiumDriverLocalService appium_Server;

//    @BeforeClass
//    public static void start_Appium_Server() {
//
//        String     node = "/usr/local/bin/node";
//        String     appium_Path = "/usr/local/lib/node_modules/appium/build/lib/main.js";
//
//        appium_Server = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//                .usingDriverExecutable(new File(node))
//                .usingPort(4723)
//                .withAppiumJS(new File(appium_Path)));
//        appium_Server.start();
//    }

    @AfterClass
    public void clear_Session() {

        //Stop browser
        try {
            browserFactory.getDriver().quit();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        // stop appium server
//        appium_Server.stop();
    }

}
