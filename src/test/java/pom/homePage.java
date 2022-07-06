package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class homePage {

    WebDriver driver;

    By search_txt = By.xpath("(//*[@type='text' and @class='text-search-home'])[1]");

    By search_btn = By.xpath("//*[contains(text(),'Search now')]");

    By cookie_accept_btn = By.xpath("//*[contains(text(),'ACCEPT')]");

    mainFunction mFunction;



    public homePage(WebDriver driver){

        this.driver = driver;

    }

    public void cookieAccept() throws InterruptedException, IOException {
        sleep(1000);
        mFunction.captureScreenShots();
        driver.findElement(cookie_accept_btn).click();

    }
    public String  getLoginTitle() throws IOException {
        mFunction = new mainFunction(driver);
        mFunction.captureScreenShots();
        String tit= driver.getTitle();
        System.out.println("Title Bilgisi"+" : " +driver.getTitle());
        return driver.getTitle();

    }

    public void homeCase() throws IOException, InterruptedException {
        this.cookieAccept();
        this.getLoginTitle();
    }

}
