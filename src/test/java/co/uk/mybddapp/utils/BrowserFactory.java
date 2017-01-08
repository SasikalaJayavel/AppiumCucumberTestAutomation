package co.uk.mybddapp.utils;

/**
 * Use below text to launch different types of tests


*/
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Configuration
public class BrowserFactory
{
    @Value("${explicit.wait}")
    public int explicitWaitTime;
    @Value("${implicit.wait}")
    public int implicitWaitTime;
    @Value("${default.wait}")
    public int defaultWaitTime;
    @Value("${application.path}")
    public String applicationName;
    public DesiredCapabilities capabilities;
    @Value("${appium.server.port}")
    private String appiumPort;
    @Value("${application.path}")
    private String appPath;
    @Value("${iosapplication.path}")
    private String iosapppath;
    @Value("${automation.instrumentation}")
    private String instrumentation;
    @Value("${androidautomation.instrumentation}")
    private String androidinstrumentation;
    @Value("${browser.name}")
    private String browserName;
    @Value("${platform.name}")
    private String platformName;
    @Value("${device.name}")
    private String deviceName;
    @Value("${platform.version}")
    private String platformVersion;
    @Value("${new.command.timeout}")
    private String newCommandTimeout;
    @Value("${device.ready.timeout}")
    private String deviceReadyTimeout;
    private URL serverUrl;
    private AppiumDriver<? extends MobileElement> driver;

    @Bean(destroyMethod = "quit")
//    @Scope("cucumber-glue")
    public AppiumDriver<? extends MobileElement> getDriver() throws MalformedURLException
    {
        String platform_Name = System.getProperty("platform");
        System.out.println("platform_Name: " + platform_Name);
        switch (platform_Name)
        {
            /** for all the tests the appium can be started in the command line with just the command : appium, unleass otherwise stated */

            case "androidDeviceInstallLaunchFromDOTapk":
            default:
            {
                /**
                 * This test is for testing Native or Hybrid apps with Webview by installing from the available .apk file
                 * and launching afresh in a android physical device
                 * In the device: Inside Developer options -> Select USB Configuration -> Enable MTP(Media Transfer protocol as the USB configuration
                 * /

                 /**
                 * This works but the webview context switching was not enabled and therefore there only one context.
                 * Since there was only one context when running in the real android device @AndroidFindBy page factory itself works
                 * for finding the elements
                 */


                capabilities = new DesiredCapabilities();
                capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.6.3");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.3.2");
                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName); //= empty String""
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion); // = "6.0.1"
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName); // = "Android"
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName); // = "Android"
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, androidinstrumentation); // = "Appium"
                capabilities.setCapability(MobileCapabilityType.APP, new File(ClassLoader.getSystemResource(appPath)
                        .getFile()).getAbsolutePath());
                capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
                capabilities.setCapability("unicodeKeyboard", "true");
                capabilities.setCapability("resetKeyboard", "true");

                serverUrl = new URL("http://localhost:" + appiumPort + "/wd/hub");
                driver = new AndroidDriver(serverUrl, capabilities);
                driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
                return driver;

            }

        }
    }
}