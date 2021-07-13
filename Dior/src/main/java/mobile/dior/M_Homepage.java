package mobile.dior;

import com.dior.BaseClass;
import com.dior.ExcelManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class M_Homepage extends BaseClass {

    private static final ExcelManager excel = new ExcelManager();
    private static String url ="";
    private static String message ="";
    private static String bug_statut ="";

    @FindBy(xpath = "/html/body/div[1]/div[1]/main/div/div/div/div[1]/div/div[2]/nav/button/span[1]")
    private static WebElement category_choice;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[2]/div/div/button[1]")
    private static WebElement cookie_frame;

    @FindBy(xpath = "/html/body/div[3]/div[2]/div[3]/button/span")
    private static WebElement version_frame;

    @FindBy(xpath = "/html/body/div[1]/div[1]/main/div/div/div/div[1]/div/div[2]/nav/button/span[1]")
    private static WebElement category;

    @FindBy(xpath = "/html/body/div[1]/div[1]/main/div/div/div/div[1]/div/div[2]/nav/ul/li[3]/div/a/span")
    private static WebElement dior_you;

    @FindBy(xpath = "/html/body/div[1]/div[1]/main/div/div/div/div[2]/div/div[3]/div[1]/div/p[2]/a[1]")
    private static WebElement dior_house;


    //---------------------------------------------------------------------------------------------------------
    public static void handleCookie() {
        try{
            Thread.sleep(1000);
            cookie_frame.click();
            Thread.sleep(1500);

        }catch (Exception e){
            System.out.println(e.getCause());
        }

    }

    public static void handleframe()  {

        try{
            Thread.sleep(1000);
            version_frame.click();
            Thread.sleep(1500);

        }catch (Exception e){
            System.out.println(e.getCause());
        }

    }

    public static void gotoHomepage() throws InterruptedException {
        driver.get("https://www.dior.com/fr_fr");
        Thread.sleep(2000);
    }

    public static void getOnFaqPage() throws InterruptedException {

        driver.navigate().to("https://www.dior.com/fr_fr/faq-couture#a-propos-du-site-dior-com");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(category_choice));
        wait.until(ExpectedConditions.visibilityOf(cookie_frame));
        handleCookie();
        handleframe();

    }

    public static void getOnDiorHouse() throws InterruptedException {

        //-------------- Categorie ---------------------
        category.click();
        Thread.sleep(1500);

        //-------------- Dior & vous -------------------
        dior_you.click();
        Thread.sleep(1500);

        //------------- Maison Dior ---------------------
        url = dior_house.getAttribute("href");
        dior_house.click();
        message = driver.findElement(By.xpath("/html/body")).getText();
        message = message.substring(0,116);
        Thread.sleep(2000);


    }

    public static void verifyDiorHouseContentAppear(){

        try {

            String Bug = "384";

            System.out.println("lien avant le click : "+url
                    +"\nmessage du contenu : "+message);


            if(!message.contains("la page n'est pas disponible")&&!message.contains("Vous allez être redirigé vers la page d'accueil du site")){

                System.out.println("\n la page est accessible avec un contenu approprié : "
                        + "\n\n\tBug Corrigé !!!");
                bug_statut = "OK";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());

            }else{

                System.out.println("\n la page n'est accessible : "
                        + "\n\n\tBug Non Corrigé !!!");
                bug_statut = "KO";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());
            }

        } catch(Exception e) {

            System.out.println(e.getCause());

        }



    }







}
