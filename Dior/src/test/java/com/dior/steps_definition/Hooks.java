package com.dior.steps_definition;

import com.dior.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import mobile.dior.M_Homepage;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks extends BaseClass{

    private static String site_title = "Dior";
    private final String filePath = (System.getProperty("user.dir")+"/src/main/resources");
    public void sendEmail(String fromEmail, String FromEmailPassword, String toEmail){

        // Sending email from gmail
        String host = "smtp.gmail.com";

        // Port of SMTP
        String port = "587";

        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);

        // Create session object passing properties and authenticator instance
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, FromEmailPassword);
            }
        });

        try {
            // Create MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set the Senders mail to From
            message.setFrom(new InternetAddress(fromEmail));

            // Set the recipients email address
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            // Subject of the email
            message.setSubject(site_title+" Retest");

            Multipart multipart = new MimeMultipart();

            // add the body message
            BodyPart bodyPart = new MimeBodyPart();
            bodyPart.setText("Bonjour, \n  Ci-joint le fichier correspondant aux Retests sur le site "+site_title);
            multipart.addBodyPart(bodyPart);

            // attach the file
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.attachFile(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\Verification.xlsx"));

            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);

            // Send email.
            Transport.send(message);
            System.out.println("Mail sent successfully");
        } catch (MessagingException | IOException me) {
            me.printStackTrace();
        }
    }
    public void formatResult(String filePath,String fileName,String sheetName) throws IOException {

        File file =    new File(filePath+"\\"+fileName);

        FileInputStream inputStream = new FileInputStream(file);

        Workbook guru99Workbook = new XSSFWorkbook(inputStream);

        Sheet sheet = guru99Workbook.getSheet(sheetName);

        // Setting Background color
        CellStyle style1 = guru99Workbook.createCellStyle();
        style1.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
        style1.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        style1.setFillPattern(FillPatternType.FINE_DOTS);

        // Setting Background color
        CellStyle style2 = guru99Workbook.createCellStyle();
        style2.setFillBackgroundColor(IndexedColors.RED.getIndex());
        style2.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        style2.setFillPattern(FillPatternType.FINE_DOTS);

        // -----------  set color to field cell  ----------

        for (Row line : sheet) {       //browse lines
            for (Cell cell : line) {
                if (cell.getStringCellValue().contains("KO")){

                    cell.setCellStyle(style2);


                }
                else if (cell.getStringCellValue().contains("OK"))
                {
                    cell.setCellStyle(style1);
                }

            }

        }
        inputStream.close();

        /* Write changes to the guru99Workbook */
        FileOutputStream out = new FileOutputStream(file);
        guru99Workbook.write(out);
        out.close();

    }
    public int mailParametersCheck(String filePath,String fileName,String sheetName) throws IOException{
        //Create an object of File class to open xlsx file

        File file =    new File(filePath+"\\"+fileName);

        //Create an object of FileInputStream class to read excel file

        FileInputStream inputStream = new FileInputStream(file);

        Workbook guru99Workbook = null;

        //Find the file extension by splitting  file name in substring and getting only extension name

        String fileExtensionName = fileName.substring(fileName.indexOf("."));

        //Check condition if the file is xlsx file

        if(fileExtensionName.equals(".xlsx")){

            //If it is xlsx file then create object of XSSFWorkbook class

            guru99Workbook = new XSSFWorkbook(inputStream);

        }

        //Check condition if the file is xls file

        else if(fileExtensionName.equals(".xls")){

            //If it is xls file then create object of XSSFWorkbook class

            guru99Workbook = new HSSFWorkbook(inputStream);

        }

        //Read excel sheet by sheet name

        Sheet sheet = guru99Workbook.getSheet(sheetName);

        // -----------  send mail  ----------
        int bugImplementNumber = 0;

        for (Row line : sheet) {       //browse lines
            for (Cell cell : line) {
                if (cell.getStringCellValue().contains(getDate())){

                    bugImplementNumber++;

                } //browse columns
            }

        }

        inputStream.close();

        return bugImplementNumber;
    }

    @Before("@Web")
    public void setup() throws Exception {

        try{
            setDriver();
            PageFactory.initElements(driver, HomePage.class);
            System.out.println("initialisation du driver : "+driver);

        }catch (Exception e){
            System.out.println(e.getCause());
        }

    }

    @Before("@Mobile")
    public void Appiumsetup() throws Exception {

        try{
            mobileDriver();
            PageFactory.initElements(driver, M_Homepage.class);
            System.out.println("initialisation du driver : "+driver);


        }catch (Exception e){
            System.out.println(e.getCause());
        }

    }



    @After
    public void teardown() throws IOException {
        driver.quit();
        formatResult(filePath,"Verification.xlsx","Data");
        System.out.println(mailParametersCheck(filePath,"Verification.xlsx","Data"));
        if(mailParametersCheck(filePath,"Verification.xlsx","Data")>=10){
            sendEmail("martin.kuatepk67@gmail.com", "Zenity@2021", "martinkuate9@gmail.com");
            sendEmail("martin.kuatepk67@gmail.com", "Zenity@2021", "fokourou@zenity.fr");
            System.out.println(" ");
        }
    }

}
