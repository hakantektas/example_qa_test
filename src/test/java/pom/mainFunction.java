package pom;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class mainFunction {

    String folder_name;
    DateFormat df;
    WebDriver driver;
    public mainFunction(WebDriver driver){

        this.driver = driver;

    }

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
}
