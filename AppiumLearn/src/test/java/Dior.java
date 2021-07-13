import com.appiumlearn.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Dior extends BaseClass {

    String url1 ="";
    String message ="";
    String bug_statut ="";
    String error_message = "Veuillez nous excuser, la page n'est pas disponible. Vous allez être redirigé vers la page d'accueil du site.";

    //-------->>>  Test Case 01 : Bug 384 : Not Contain After Redirection  <<<---------
    @Test
    public void getFaqPage() throws InterruptedException {

        //------------- GoTo Dior HomePage -------------
        driver.get("https://www.dior.com/fr_fr");
        Thread.sleep(2000);

        //------------- GoTo FAQ Page ------------------
        driver.navigate().to("https://www.dior.com/fr_fr/faq-couture#a-propos-du-site-dior-com");
        Thread.sleep(2000);
        WebElement category_choice = driver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div/div/div/div[1]/div/div[2]/nav/button/span[1]"));
        wait.until(ExpectedConditions.visibilityOf(category_choice));
        WebElement cookie_frame = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div/div/button[1]"));
        wait.until(ExpectedConditions.visibilityOf(cookie_frame));
        handleCookie();
        handleframe();

        //-------------- Categorie ---------------------
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div/div/div/div[1]/div/div[2]/nav/button/span[1]")).click();
        Thread.sleep(1500);

        //-------------- Dior & vous -------------------
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div/div/div/div[1]/div/div[2]/nav/ul/li[3]/div/a/span")).click();
        Thread.sleep(1500);

        //------------- Maison Dior ---------------------
        url1 = driver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div/div/div/div[2]/div/div[3]/div[1]/div/p[2]/a[1]")).getAttribute("href");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/main/div/div/div/div[2]/div/div[3]/div[1]/div/p[2]/a[1]")).click();
        Thread.sleep(2000);
        message = driver.findElement(By.xpath("/html/body")).getText();
        message = message.substring(0,116);

        try{

            if(!message.contains("la page n'est pas disponible")&&!message.contains("Vous allez être redirigé vers la page d'accueil du site")){
                bug_statut = "OK";
            }else{
                bug_statut = "KO";
            }

            System.out.println("lien avant le click : "+url1
                    +"\nmessage du contenu : "+message);

        }catch (Exception e){
            System.out.println(e.getCause());
        }

        Assert.assertEquals(bug_statut, "OK");

    }

    //------------ Useful methods -----------------------------------------------------
    public void handleCookie() {
        try{
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/div/div/button[1]")).click();
            Thread.sleep(1500);

        }catch (Exception e){
            System.out.println(e.getCause());
        }

    }
    public void handleframe()  {

        try{
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/button/span")).click();
            Thread.sleep(1500);

        }catch (Exception e){
            System.out.println(e.getCause());
        }

    }

}
