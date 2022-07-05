import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class loginTest {


    public static void main(String[] args) throws InterruptedException {

       /* System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();*/


       ChromeOptions chromeOptions = new ChromeOptions();
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver(chromeOptions);
       driver.get("https://www.testrelic.com/");
       driver.manage().window().maximize();

       driver.findElement(By.xpath("(//*[@type='text' and @class='text-search-home'])[1]")).sendKeys("test deneme");

       driver.findElement(By.xpath("//*[contains(text(),'Search now')]")).click();
      /* String value1=driver.findElement(By.xpath("This search matches 0 results!\n")).getText();
       String value2="This search matches 0 results";

       Assert.assertEquals(value1,value2,"Doğrulama başarılı");

       */
        Thread.sleep(2000);
        driver.quit();


    }

    public void searchTest(){

    }

}
