package com.dior;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseClass {


    private static final ExcelManager excel = new ExcelManager();
    private static String elementTranslate;
    private static String bug_statut;
    private static String element1_size;
    private static String element2_size;
    private static String askQuestionsButtonStatus = "";
    private static int cpt = 0;
    private static String sitelangage [] = {"https://www.dior.com/en_hk","https://www.dior.com/ja_jp","https://www.dior.com/zh_tw","https://www.dior.com/en_ro"};


    @FindBy(className = "ot-sdk-container")
    private static WebElement cookiesFrame;

    @FindBy(xpath = "/html/body/div[3]/div[3]/div/div/div[2]/div/div/button[1]")
    private static WebElement cookiesSelectOption;

    @FindBy(className = "popin ignore-use-click-outside")
    private static WebElement accessFrame;

    @FindBy(className = "popin__wrapper__close")
    private static WebElement accessSelectOption;

    //----------------------------- header page locators ----------------------------------------

    @FindBy(xpath = "/html/body/div/div[1]/div[3]/header/div/div[1]/div[1]/nav/button")
    private static WebElement headerMenuList;

    @FindBy(xpath = "/html/body/div/div[1]/div[4]/div[3]/div/nav/ul[1]/li[9]/div/div/button")
    private static WebElement headerMenuMaison;

    @FindBy(id = "prc-12-1")
    private static WebElement headerElementMaison;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/nav[1]/div[1]/ul[1]/li[10]/div[1]/div[1]/div[1]/a[1]/span[1]")
    private static WebElement headerElementNews_Defile;

    @FindBy(xpath = "/html/body/div[1]/div[1]/nav[2]/div[2]/ul/li[10]/div/div[2]/ul/li[4]/ul/li/div/a/span")
    private static WebElement MenuNews_Defile_SavoirFaire;

    @FindBy(className = "my-account")
    private static WebElement headerRectConnectElement;

    @FindBy(id = "login")
    private static WebElement emailfield;

    @FindBy(id = "password")
    private static WebElement pwdfield;

    @FindBy(className = "button-link__title")
    private static WebElement submitfield;

    @FindBy(className = "side-panel-close-icon")
    private static WebElement closeloginfield;

    @FindBy(className = "connected-account-logout")
    private static WebElement disconnectfield;

    @FindBy(id = "favoris-tab-header")
    private static WebElement favoristab;

    @FindBy(id = "compte-tab-header")
    private static WebElement comptetab;

    @FindBy(id = "panier-tab-header")
    private static WebElement paniertab;

    @FindBy(id = "prc-2-1")
    private static WebElement langageservice;







    // ---------------------------- inside page locators -----------------------------------------

    @FindBy(xpath = "/html/body/header/div/nav[2]/div/div[2]/ul[2]/li/a")
    private static WebElement connectionButton;


    //--------------------------- footer page locators ---------------------------------

    @FindBy(linkText = "Conditions Générales de Vente")
    private static WebElement footerCGV;




    //--------------------------- redirections --------------------------------------------

    // >---------------------- CGV ---------------------------<

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]")
    private static WebElement element1;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]")
    private static WebElement element2;

    // >-------------------- /contact-couture ----------------<

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/button[1]")
    private static WebElement askQuestionButton;

    @FindBy(className = "contact-form__fieldset__large-cell")
    private static WebElement text_area;

    @FindBy(id = "message")
    private static WebElement input_area;


    // >-------------------- /account/login ----------------<

    @FindBy(xpath = "/html/body/main/section/div[1]/div/div[2]/div/form/div[1]/input")
    private static WebElement emailLoginField;

    @FindBy(xpath = "/html/body/main/section/div[1]/div/div[2]/div/form/div[2]/input")
    private static WebElement passwordLoginField;

    // >-------------------- /account/inscription ----------------<

    @FindBy(xpath = "/html/body/main/section/form/div[3]/input")
    private static WebElement passwordInscriptionField;

    @FindBy(xpath = "/html/body/main/section/form/div[2]/input")
    private static WebElement emailInscriptionField;

    // >------------------- /savoirfaire ------------------------<

    @FindBy(xpath = "/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[3]/div[3]/a[1]")
    private static WebElement horlogerieOption;

    // >------------------- /maquillage ------------------------<

    @FindBy(className = "dots")
    private static WebElement verticalSlider;



    //--------------------------------------- methods -------------------------------------------------------

    public static void handleCookiesFrame() throws InterruptedException {

        try{

            WebElement frame1 = driver.findElement(By.cssSelector("#onetrust-reject-all-handler"));
            frame1.click();
            Thread.sleep(1000);

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static void handleAccessFrame() throws InterruptedException {

        try{

            WebElement frame2 = driver.findElement(By.cssSelector("body > div.popin.ignore-use-click-outside > div.popin__wrapper.popin__wrapper--fitcontent.popin__wrapper--with-overflow > div:nth-child(3) > button"));
            frame2.click();
            Thread.sleep(1000);

        }catch (Exception e){
            System.out.println(e);
        }

    }

    public static void connexion() throws InterruptedException {

        headerRectConnectElement.click();
        Thread.sleep(1000);
        emailfield.sendKeys("yoanntagne45@gmail.com");
        Thread.sleep(1000);
        pwdfield.sendKeys("1995P@oyon");
        Thread.sleep(1000);
        submitfield.click();
        Thread.sleep(5000);
        closeloginfield.click();
        Thread.sleep(1000);
    }

    public static void getFavorisElement1() throws InterruptedException {

        driver.navigate().refresh();
        Thread.sleep(5000);
        handleAccessFrame();

        headerRectConnectElement.click();
        Thread.sleep(2000);

        favoristab.click();
        Thread.sleep(2000);
        element1_size = favoristab.getText();

        comptetab.click();
        Thread.sleep(100);

        favoristab.click();
        Thread.sleep(1000);
        element1_size = favoristab.getText();

        comptetab.click();
        Thread.sleep(2000);

        disconnectfield.click();
        Thread.sleep(2000);

        closeloginfield.click();
        Thread.sleep(1000);

    }

    public static void getFavorisElement2() throws InterruptedException {

        driver.navigate().refresh();
        Thread.sleep(5000);
        handleAccessFrame();

        headerRectConnectElement.click();
        Thread.sleep(2000);

        favoristab.click();
        Thread.sleep(2000);
        element2_size = favoristab.getText();

        comptetab.click();
        Thread.sleep(100);

        favoristab.click();
        Thread.sleep(1000);
        element2_size = favoristab.getText();

        closeloginfield.click();
        Thread.sleep(1000);

    }

    public static void getHorlogerielink() throws InterruptedException {

        element1_size = driver.getCurrentUrl();
        horlogerieOption.click();
        Thread.sleep(3000);
        element2_size = driver.getCurrentUrl();
    }

    public static void getHeaderElementMaison() throws InterruptedException {

        elementTranslate = headerElementMaison.getText();
    }

    public static void getElementCGVSize() throws InterruptedException {

        element1_size = element1.getSize().toString();
        element2_size = element2.getSize().toString();
        Thread.sleep(2000);
    }

    public static void getAskQuestionEnability(){

        try {

            askQuestionButton.click();

        } catch (Exception e){
            askQuestionsButtonStatus = e.toString();
            System.out.println(e);
        }

    }

    public static void getLoginPasswordFieldSize() throws InterruptedException {

        element1_size = passwordLoginField.getAttribute("data-min-length");
        passwordLoginField.sendKeys("123");
        emailLoginField.sendKeys("banana");
        Thread.sleep(3000);

    }

    public static void getInscriptionPasswordFieldSize() throws InterruptedException {

        element2_size = passwordInscriptionField.getAttribute("data-min-length");
        passwordInscriptionField.sendKeys("123");
        emailInscriptionField.sendKeys("banana");
        Thread.sleep(3000);

    }

    public static void getToFindConnexion(){
        try{
            if (headerRectConnectElement.isDisplayed()){
                cpt++;
                headerRectConnectElement.click();
                Thread.sleep(3000);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void getPlayWithSlider() throws InterruptedException {

        element1_size = getScrollPosition(driver);
        System.out.println(element1_size);

        verticalSlider.click();
        int i = 1;
        while(i<=7){
            driver.findElement(By.xpath("/html/body/main/div/div[1]/ul/li["+i+"]/i")).click();
            element2_size = getScrollPosition(driver);
            if(!element2_size.equals(element1_size)){

                cpt++;
            }
            Thread.sleep(3000);

            i++;
        }

    }

    public static void getTextAreaSpace() throws InterruptedException {

        element1_size = text_area.getLocation().getX()+"";
        input_area.sendKeys("manger 05 fruits et legumes par jour");
        element2_size = input_area.getLocation().getX()+"";
        Thread.sleep(3000);

    }

    public static void getLangageService() throws InterruptedException {

        for (int i = 0; i<=3; i++){

            driver.navigate().to(sitelangage[i]);
            Thread.sleep(3000);
            handleAccessFrame();
            Thread.sleep(1000);

            try{

                Thread.sleep(1000);
                if(langageservice.isDisplayed()){

                    cpt++;
                }


            }catch (Exception e){
                System.out.println(e);
            }

            Thread.sleep(1000);

        }

    }

    public static void verifyServiceLangageAppear(){

        try {

            String Bug = "404";

            System.out.println("\noccurence d'appurition de la barre de service : "+cpt);

            if (cpt!=4) {

                System.out.println("\n les occurences sont inferieurs au version testées : "
                        + "\n\n\tBug Non Corrigé !!!");
                bug_statut = "KO";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());

            } else {

                System.out.println("\n les occurences sont égales au version testées  : "
                        + "\n\n\tBug Corrigé !!!");
                bug_statut = "OK";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());
            }

        } catch(Exception e) {

            System.out.println(" No more for this ");

        }



    }

    public static void verifyTextAreaSpace(){

        try {

            String Bug = "348";

            System.out.println("\nzone de texte position : "+element1_size
                            + "\nzone d'ecriture position : "+element2_size);

            if (element1_size.equals(element2_size)) {

                System.out.println("\n les elements se confondent : "
                        + "\n\n\tBug Non Corrigé !!!");
                bug_statut = "KO";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());

            } else {

                System.out.println("\n les elements se distinguent : "
                        + "\n\n\tBug Corrigé !!!");
                bug_statut = "OK";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());
            }

        } catch(Exception e) {

            System.out.println(" No more for this ");

        }


    }

    public static void verifyHeaderElementTranslate(){

        try {

            String Bug = "381";

            System.out.println(elementTranslate);

            if (elementTranslate.equals("MAISON")) {

                System.out.println("\n l'element <<"+elementTranslate+">> n'est pas traduit sur le site international"
                        + "\n\n\tBug Non Corrigé !!!");
                bug_statut = "KO";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());

            } else {

                System.out.println("\n l'element <<"+elementTranslate+">> est traduit sur le site international"
                        + "\n\n\tBug Corrigé !!!");
                bug_statut = "OK";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());
            }

        } catch(Exception e) {

            System.out.println(" No more for this ");

        }


    }

    public static void verifyCGVElementSize(){

        try {

            String Bug = "351";

            if (!element1_size.equals(element2_size)) {

                System.out.println("\n les elements n'ont pas la meme taille : "
                        +"\nelement 1 : "+element1_size
                        +"\nelement 2 : "+element2_size
                        + "\n\n\tBug Non Corrigé !!!");
                bug_statut = "KO";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());

            } else {

                System.out.println("\n les elements ont la meme taille : "
                        +"\nelement 1 : "+element1_size
                        +"\nelement 2 : "+element2_size
                        + "\n\n\tBug Corrigé !!!");
                bug_statut = "OK";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());
            }

        } catch(Exception e) {

            System.out.println(" No more for this ");

        }


    }

    public static void verifyAskQuestionEnability(){

        try {

            String Bug = "357";

            if(askQuestionsButtonStatus.contains("is not clickable")) {

                System.out.println("\n impossible de cliquer sur le button : "
                        + "\n\n\tBug Non Corrigé !!!");
                bug_statut = "KO";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());

            } else {

                System.out.println("\n possible de cliquer sur le bouton : "
                        + "\n\n\tBug Corrigé !!!");
                bug_statut = "OK";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());
            }

        } catch(Exception e) {

            System.out.println(" No more for this ");

        }





    }

    public static void verifyPasswordFieldSize(){

        try {

            String Bug = "375";

            System.out.println("\ntaille requise element 1 : "+element1_size
                    + "\ntaille requise element 2 : "+element2_size);

            if(!element1_size.equals(element2_size)) {

                System.out.println("\n la longueur du champs mot de passse requis varie : "
                        + "\n\n\tBug Non Corrigé !!!");
                bug_statut = "KO";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());

            } else {

                System.out.println("\n la longueur du champs mot de passse requis ne varie pas : "
                        + "\n\n\tBug Corrigé !!!");
                bug_statut = "OK";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());
            }

        } catch(Exception e) {

            System.out.println(" No more for this ");

        }



    }

    public static void verifyNewsDefileSameLink(){

        try {

            String Bug = "385";

            System.out.println("\nlien element 1 : "+element1_size
                    + "\nlien element 2 : "+element2_size);

            if(element1_size.equals(element2_size)) {

                System.out.println("\n l'horlogerie renvoit vers le lien par defaut qui est celui des metiers : "
                        + "\n\n\tBug Non Corrigé !!!");
                bug_statut = "KO";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());

            } else {

                System.out.println("\n l'horlogerie ne renvoit pas vers le lien par defaut qui est celui des metiers : "
                        + "\n\n\tBug Corrigé !!!");
                bug_statut = "OK";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());
            }

        } catch(Exception e) {

            System.out.println(" No more for this ");

        }


    }

    public static void verifyGetConnexionToInt_Website(){

        try {

            String Bug = "392";

            System.out.println("\ncompteur pour element de connexion : "+cpt);


            if(cpt<2) {

                System.out.println("\n Connexion depuis le site international impossible "
                        + "\n\n\tBug Non Corrigé !!!");
                bug_statut = "KO";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());

            } else {

                System.out.println("\n Connexion depuis le site international possible "
                        + "\n\n\tBug Corrigé !!!");
                bug_statut = "OK";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());
            }

        } catch(Exception e) {

            System.out.println(" No more for this ");

        }



    }

    public static void verifySliderFeature(){

        try {

            String Bug = "395";

            System.out.println("\ninitial scroll position : "+element1_size
                   + "\nfinal scroll position : "+element2_size);


            if(cpt<6) {

                System.out.println("\n Le slider ne fonctionne pas "
                        + "\n\n\tBug Non Corrigé !!!");
                bug_statut = "KO";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());

            } else {

                System.out.println("\n Le slider fonctionne bien "
                        + "\n\n\tBug Corrigé !!!");
                bug_statut = "OK";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());
            }

        } catch(Exception e) {

            System.out.println(" No more for this ");

        }


    }

    public static void verifyFavorisElementState(){

        try {

            String Bug = "391";

            System.out.println("\nfavoris apres connexion : "+element1_size
                    + "\nfavoris apres deconnexion : "+element2_size);


            if(element1_size.equals(element2_size)) {

                System.out.println("\n Les favoris sont maintenus après deconnexion "
                        + "\n\n\tBug Non Corrigé !!!");
                bug_statut = "KO";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());

            } else {

                System.out.println("\n Les favoris ne sont pas maintenus après deconnexion "
                        + "\n\n\tBug Corrigé !!!");
                bug_statut = "OK";
                excel.excelWriting(Bug,bug_statut, getDate(), getTime());
            }

        } catch(Exception e) {

            System.out.println(" No more for this ");

        }


    }

}
