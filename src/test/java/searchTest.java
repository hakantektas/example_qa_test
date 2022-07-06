//import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.reporters.Files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Listeners(ListenerTest.class)
public class searchTest  {

    WebDriver driver;
    String folder_name;
    DateFormat df;



    public void captureScreenShots() throws IOException {
        folder_name="screenshot";
        File f=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //Date format fot screenshot file name
        df = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        //create dir with given folder name
        new File(folder_name).mkdir();
        //Setting file name
        String file_name=df.format(new Date())+".png";
        //coppy screenshot file into screenshot folder.
        FileUtils.copyFile(f, new File(folder_name + "/" + file_name));
    }


    @Test(priority = 0, description = "Title Correct Test")
    public void searchTest_1() throws InterruptedException, IOException {



     /*ChromeOptions chromeOptions = new ChromeOptions();
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver(chromeOptions);*/

        System.setProperty("webdriver.chrome.driver", "/Users/mobven/IdeaProjects/example_qa_test/drivers/chromedriver");
        driver = new ChromeDriver();
        /*System.setProperty("webdriver.gecko.driver", "/Users/mobven/IdeaProjects/example_qa_test/drivers/geckodriver");
        driver = new FirefoxDriver();*/


       driver.get("https://www.testrelic.com/");
       driver.manage().window().maximize();

       Thread.sleep(5000);
       driver.findElement(By.xpath("//*[contains(text(),'ACCEPT')]")).click();
       driver.findElement(By.xpath("(//*[@type='text' and @class='text-search-home'])[1]")).sendKeys("test deneme");
       captureScreenShots();
       driver.findElement(By.xpath("//*[contains(text(),'Search now')]")).click();
       Thread.sleep(2000);

       String value1= driver.findElement(By.xpath("//*[contains(text(),'This search matches 0 results!')]")).getText();
       System.out.println("Value Değeri"+" : "+value1);

       String value2="This search matches 0 results!\n" +
               "New search or back to home page";
       Assert.assertEquals(value1,value2,"Kontrol başarılı");
       Assert.assertTrue(true,value2);
       captureScreenShots();
        ///////cooikes çalışmaları///////
       /*


        driver.manage().getCookies();
        driver.manage().deleteAllCookies();
        Set<Cookie> cookiesList =  driver.manage().getCookies();
        for(Cookie getcookies :cookiesList) {
            System.out.println("Cookie Value "+" : "+getcookies);
        }
        Cookie cookieValue = driver.manage().getCookieNamed("PHPSESSID");
        driver.manage().deleteCookieNamed("PHPSESSID");
        System.out.println("Session Name" + " : " +cookieValue.getValue());
        //Cookie cookieName = null;
        //driver.manage().addCookie(cookieName);
        //For creating a new cookie we should pass the name of the cookie and its value
        Cookie cname = new Cookie("myCookie", "12345678999");
        driver.manage().addCookie(cname);
*/
//retrieve the cookies to view the newly added cookie
       /* Set<Cookie> cookiesList2 =  driver.manage().getCookies();
        for(Cookie getcookies :cookiesList2) {
            System.out.println(getcookies );
        }*/;

        Thread.sleep(2000);
        driver.quit();

    }

}
