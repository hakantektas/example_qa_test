package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

import static java.lang.Thread.*;

public class searchPage {

    WebDriver driver;

    By search_txt = By.xpath("(//*[@type='text' and @class='text-search-home'])[1]");

    By search_btn = By.xpath("//*[contains(text(),'Search now')]");


//    String result = driver.findElement(By.xpath("//*[contains(text(),'This search matches 0 results!')]")).getText();

    mainFunction mFunction;

    public searchPage(WebDriver driver){

        this.driver = driver;
        mFunction = new mainFunction(driver);

    }
    public void searchBox(String searchText) throws InterruptedException, IOException {
        sleep(1000);
        driver.findElement(search_txt).sendKeys(searchText);

        mFunction.captureScreenShots();

    }
    public void searchBtn() throws InterruptedException, IOException {
        sleep(1000);
        driver.findElement(search_btn).click();
        mFunction.captureScreenShots();
    }
    public String getLoginTitle() throws IOException {

        mFunction.captureScreenShots();
        return  driver.getCurrentUrl();

    }

   /* public void assert_(String text){

        Assert.assertEquals(result,text,"");

    }*/
    public void search_function(String searchText) throws InterruptedException, IOException {


        //search text

        this.searchBox(searchText);

        //search button

        this.searchBtn();

        //web title

        this.getLoginTitle();


       // this.assert_("This search matches 0 results!");


    }
}
