import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class cookieRead {

    public static void main(String[] args)
    {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","/Users/mobven/IdeaProjects/example_qa_test/drivers/chromedriver");
        driver=new ChromeDriver();
        driver.get("https://www.testrelic.com/");


        // Input Email id and Password If you are already Register
        driver.findElement(By.xpath("(//*[@type='text' and @class='text-search-home'])[1]")).sendKeys("test deneme");

        driver.findElement(By.xpath("//*[contains(text(),'Search now')]")).click();
        String value1= driver.findElement(By.xpath("//*[contains(text(),'This search matches 0 results!')]")).getText();
        String value2="This search matches 0 results!\n" +
                "New search or back to home page";
        driver.findElement(By.xpath("//*[contains(text(),'Accept')]")).click();
        Assert.assertTrue(true,value2);


        // create file named Cookies to store Login Information
        File file = new File("Cookies.data");
        try
        {
            // Delete old file if exists
            file.delete();
            file.createNewFile();
            FileWriter fileWrite = new FileWriter(file);
            BufferedWriter Bwrite = new BufferedWriter(fileWrite);
            // loop for getting the cookie information

            // loop for getting the cookie information
            for(Cookie ck : driver.manage().getCookies())
            {
                Bwrite.write((ck.getName()+";\n"+ck.getValue()+";\n"+ck.getDomain()+";\n"+ck.getPath()+";\n"+ck.getExpiry()+";\n"+ck.isSecure()));
                Bwrite.newLine();
            }
            Bwrite.close();
            fileWrite.close();

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        driver.quit();
    }
}
