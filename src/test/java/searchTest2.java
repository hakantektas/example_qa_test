import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class searchTest2 {

    WebDriver driver;

    @Test
    public void searchNew() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/mobven/IdeaProjects/example_qa_test/drivers/chromedriver");
        driver = new ChromeDriver();

        driver.get("https://www.testrelic.com/");
        driver.manage().window().maximize();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[contains(text(),'ACCEPT')]")).click();
        driver.findElement(By.xpath("(//*[@type='text' and @class='text-search-home'])[1]")).sendKeys("test deneme");

        driver.findElement(By.xpath("//*[contains(text(),'Search now')]")).click();
        Thread.sleep(2000);

        String result_1 = driver.findElement(By.xpath("//*[contains(text(),'This search matches 0 results!')]")).getText();
        System.out.println("değer"+":"+result_1);

        String resulu_2 = "This search matches 0 results!\n" +
                "New search or back to home page";

        Assert.assertEquals(result_1,resulu_2,"Kontrol başarılı");


    }

}
