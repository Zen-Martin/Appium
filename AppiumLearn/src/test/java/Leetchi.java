import com.appiumlearn.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Leetchi extends BaseClass {

    String _mdp = "Test@2021123456";
    String _mail =  "merlinmagicien1@gmail.com";

    //-------->>>  Test Case 01 : Bug 102 : No CalendarPicker Appear  <<<-------
    @Test
    public void getModifyCampagn() throws InterruptedException {

        /*------------------------------------------------------------------------------*/
            /*
             >>> Ce text est effectué avec un utilisateur ayant une cagnotte prédéfinie.
             >>> Validité juillet 2022.
            */
        /*-----------------------------------------------------------------------------*/

        //------------- GoTo Leetchi HomePage ---------------
        goToHomePage();

        //------------- GoTo Connexion Page ------------------
        accountConnexion();

        //----------- Try to access to cagnotte --------------
        driver.navigate().to("https://www.leetchi.com/fr/FundraisingManagement/Visibility/wzvKa6nw");
        Thread.sleep(2000);

        //---------- Try to open calendar --------------------
        driver.findElement(By.className("form-control form-input-date hasDatepicker valid")).click();
        Thread.sleep(1500);


    }

    //-------->>>  Test Case 02 : Bug 30 : Partial Image View  <<<--------------
    @Test
    public void getImage() throws InterruptedException {

        //------------- GoTo Leetchi HomePage -----------------
        goToHomePage();

        //------------ Scroll To Image ------------------------
        scroll(1500);
        scroll(1757);
        Thread.sleep(5000);

    }

    //-------->>>  Test Case 03 : Bug 45 : Signal Button  <<<---------------------
    @Test
    public void getCagnotte() throws InterruptedException {

        //------------- GoTo Leetchi HomePage -----------------
        goToHomePage();

        //------------ GoTo Cagnotte --------------------------
        driver.navigate().to("https://www.leetchi.com/fr/cagnottes");
        Thread.sleep(1500);

        //----------- Select Cagnotte -------------------------
        scroll(200);
        driver.findElement(By.xpath("/html/body/main/div/section[2]/div/div/article[1]")).click();
        Thread.sleep(1500);

        //------------ Scroll To Image ------------------------
        scroll(250);

    }

    //----------------------------------------------------------------------------
    public void goToHomePage() throws InterruptedException {
        //------------- GoTo Leetchi HomePage ---------------
        driver.get("https://www.leetchi.com/fr");
        Thread.sleep(3500);

        //------------- Cookies ------------------------------
        if (driver.findElement(By.className("cookie-modal")).isDisplayed()) {
            Thread.sleep(2000);
            driver.findElement(By.className("cn-decline")).click();
        }


    }

    public void scroll(int height) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+height+")", "");
        Thread.sleep(1500);
    }

    public void accountConnexion() throws InterruptedException {
        //------------- GoTo Connexion Page ------------------
        driver.navigate().to("https://www.leetchi.com/fr/User/Authenticate?returnUrl=%2F");

        //------------ Try connexion ------------------------
        driver.findElement(By.xpath("/html/body/main/section/div/div/div[3]/form/div[1]/input")).sendKeys(_mail);
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/main/section/div/div/div[3]/form/div[2]/input")).sendKeys(_mdp);
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/main/section/div/div/div[3]/form/button")).click();
        Thread.sleep(2000);

        //------------ Try accept conditions ---------------------------
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div/button")).click();
        Thread.sleep(1500);
    }


}
