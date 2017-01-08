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

    public AppiumDriver<? extends MobileElement> getDriver() throws MalformedURLException
    {

        System.out.println("Inside androidTuEmulatorLaunchAlreadyInstalled");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.6.3");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        capabilities.setCapability("appPackage", "io.appium.android.apis");
        capabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        capabilities.setCapability("unicodeKeyboard", "true");
        capabilities.setCapability("resetKeyboard", "true");

        serverUrl = new URL("http://localhost:" + appiumPort + "/wd/hub");
        driver = new AndroidDriver(serverUrl, capabilities);
        driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
        return driver;

    }
}