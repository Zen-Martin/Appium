package com.appiumlearn;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeTest
    public void setup() throws Exception {

        try {
            DesiredCapabilities capabilities=DesiredCapabilities.android();
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
            capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
            capabilities.setCapability(MobileCapabilityType.VERSION,"9");

            URL url= new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(url, capabilities);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 15);

        }catch (Exception e){
            System.out.println(e);
        }
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
