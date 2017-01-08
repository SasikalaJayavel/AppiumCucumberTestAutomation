package co.uk.mybddapp.utils;


import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * Created by Sasikala on 18/02/2016
 * utility functions to
 * -- check for text available text  present
 * -- accept and close alert
 * -- wait for constant time
 * -- explicit wait until element is visible
 * -- implicit wait
 * -- explicit wait until element is displayed
 * */
public class WaitUtils
{


    public void implicitWait(WebDriver driver, long time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public void pause(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean is_Element_Present(WebDriver driver, WebElement element) {
        try {

            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void wait_For_Element_toBe_clickable(WebDriver driver, WebElement element, long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void wait_For_Element_Displayed(WebDriver driver, By by , long time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }



    public static void wait_For_Visibility_Of_Element(WebDriver driver, By by, long time_In_Seconds) {
        WebDriverWait wait = new WebDriverWait(driver, time_In_Seconds);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }


    public static void waitForPageLoad(WebDriver driver, long timeout_In_Seconds, long sleeptime_In_Milli_Seconds) {

        Wait<WebDriver> wait = new WebDriverWait(driver, timeout_In_Seconds, sleeptime_In_Milli_Seconds);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                // System.out.println("Current Window State : " + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });

    }

    public static void fluent_Wait_For_Element_Displayed(WebElement element, int timeOut, int pollingTime) {

        Wait<WebElement> wait = new FluentWait<WebElement>(element)
                .withTimeout(timeOut, TimeUnit.SECONDS)
                .pollingEvery(pollingTime, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);


        wait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement element) {
//                System.out.println("Element displayed? : " + element.isDisplayed());
                return element.isDisplayed();
            }
        });
    }

    public static void fluent_By_Wait_For_Element_Displayed(final WebDriver webDriver,By by, int timeOut, int pollingTime) {

        Wait<By> wait = new FluentWait<By>(by)
                .withTimeout(timeOut, TimeUnit.SECONDS)
                .pollingEvery(pollingTime, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);


        wait.until(new Function<By, Boolean>() {
            @Override
            public Boolean apply(By by) {
                try {
                    System.out.println("Element displayed? : " + webDriver.findElement(by).isDisplayed());
                    return webDriver.findElement(by).isDisplayed();
                }
                catch (StaleElementReferenceException e) {
                    return false;
                }
            }
        });
    }

    public static void fluent_Wait_For_Element_Enabled(WebElement element, int timeOut, int pollingTime) {

        Wait<WebElement> wait = new FluentWait<WebElement>(element)
                .withTimeout(timeOut, TimeUnit.SECONDS)
                .pollingEvery(pollingTime, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);


        wait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement element) {
//                System.out.println("Element Enabled? : " + element.isEnabled());
                return element.isEnabled();
            }
        });
    }

    public static void fluent_Wait_For_Partial_URL_Check(WebDriver driver, int timeOut, int pollingTime, final String expected_URL ) {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeOut, TimeUnit.SECONDS)
                .pollingEvery(pollingTime, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);


        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                System.out.println("Current URL : " + driver.getCurrentUrl().toLowerCase());
                return driver.getCurrentUrl().toLowerCase().contains(expected_URL.toLowerCase());
            }
        });
    }
    public static void fluent_Wait_For_Element_attribute(WebElement element, int timeOut, int pollingTime, final String expected_Attribute_Value,final String attribute ) {

        Wait<WebElement> wait = new FluentWait<WebElement>(element)
                .withTimeout(timeOut, TimeUnit.SECONDS)
                .pollingEvery(pollingTime, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);


        wait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement element) {
//                System.out.println("Element style value : " + element.getAttribute("style"));
                return element.getAttribute(attribute).equals(expected_Attribute_Value);
            }
        });
    }

    public static void fluent_Wait_For_Partial_Element_Text(WebElement element, int timeOut, int pollingTime, final String expected_Text ) {

        Wait<WebElement> wait = new FluentWait<WebElement>(element)
                .withTimeout(timeOut, TimeUnit.SECONDS)
                .pollingEvery(pollingTime, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);


        wait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement element) {
                System.out.println("Element text value : " + element.getText());
                return element.getText().toLowerCase().contains(expected_Text.toLowerCase());
            }
        });
    }

    public static void fluent_wait_for_iFrame_To_Load(WebDriver driver, int timeOut, int pollingTime, final By by, final int no_Of_Iframes)
    {

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(timeOut, TimeUnit.SECONDS)
                .pollingEvery(pollingTime, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        System.out.println("inside iframe size of less than 5 ");

        wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
//                System.out.println("size " +  driver.findElements(by).size()) ;
                return driver.findElements(by).size() == no_Of_Iframes ;
            }
        });
    }
}

