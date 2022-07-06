package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class searchTest_1 {



    WebDriver driver;
    String driverPath ="/Users/mobven/IdeaProjects/example_qa_test/drivers/chromedriver";
    searchPage sPage;
    homePage hPage;
    String url = "https://www.testrelic.com/";
    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test(priority = 0, description = "Title Correct Test")
    public void test_title_correct() throws IOException, InterruptedException {
        hPage = new homePage(driver);
        String homePageTitle=hPage.getLoginTitle();
        hPage.homeCase();
        Assert.assertTrue(homePageTitle.toLowerCase().contains("You searched for Test - TestRelic"));
    }
    @Test(priority = 1 )
    public void search_case() throws InterruptedException, IOException {

        sPage = new searchPage(driver);
        sPage.search_function("Test");

    }
    @AfterTest
    public void init() {
        if (driver != null) {
            driver.quit();
        }
    }
}
