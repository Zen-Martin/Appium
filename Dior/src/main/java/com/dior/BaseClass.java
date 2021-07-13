package com.dior;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.concurrent.TimeUnit;


public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait wait;
    private static LocalDate date;
    private static LocalTime tps;
    private static String value_tps;
    private static String value_date;
    private static String os = System.getProperty("os.name");
    private static String path;


    public static void setDriver(){
        System.out.println(os);
        if (os.startsWith("W")){
            path = (System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
        } else {
            path = (System.getProperty("user.dir")+"/src/main/resources/chromedriver");
        }

        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.addArguments("--disable-blink-features");
        options.addArguments("incognito");
        //capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    public static void mobileDriver() throws Exception {

        try {
            DesiredCapabilities capabilities = DesiredCapabilities.android();
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

    public static void navigateToHomePage_Int() throws InterruptedException {
        driver.get("https://www.dior.com/en_int");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.navigate().refresh();
    }

    public static void navigateToHomePage_fr() throws InterruptedException {
        driver.get("https://www.dior.com/fr_fr");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    public static void navigateToCGVPage() throws InterruptedException {
        driver.get("https://www.dior.com/fr_fr/cgv_choice");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    public static void navigateToContact_Couture() throws InterruptedException {
        driver.get("https://www.dior.com/fr_fr/contact-couture");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    public static void navigateToDiorMaquillage() throws InterruptedException {
        driver.get("https://www.dior.com/couture/fr_fr/la-maison-dior/les-metiers/maquillage");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    public static void navigateToAccountLogin() throws InterruptedException {
        driver.get("https://wwws.dior.com/couture/fr_fr/account/login");
        driver.manage().window().maximize();
        Thread.sleep(3000);


    }

    public static void navigateToMetier() throws InterruptedException {
        driver.get("https://www.dior.com/couture/fr_fr/la-maison-dior/les-metiers");
        driver.manage().window().maximize();
        Thread.sleep(3000);


    }

    public static void navigateToAccountInscription() throws InterruptedException {
        driver.get("https://wwws.dior.com/couture/fr_fr/account/inscription");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    public static String getDate(){
        date = LocalDate.now();
        value_date = date.toString();
        return value_date;
    }

    public static String getTime(){
        tps = LocalTime.now();
        value_tps = tps.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        return value_tps;
    }

    public static void scroll(int height) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+height+")", "");
        Thread.sleep(1500);
    }

    public static String getScrollPosition(WebDriver driver){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return (executor.executeScript("return window.pageYOffset;").toString());
    }


}
