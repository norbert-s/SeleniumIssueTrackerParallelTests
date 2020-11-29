package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import utility.Prop;

import javax.annotation.concurrent.ThreadSafe;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.firefox.FirefoxDriver;
public @ThreadSafe class Base {

    public static WebDriver createBrowser(String browser)  {
        WebDriver d=null;
        if (browser.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\nsusz\\\\OneDrive\\\\chromedriver\\\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            options.addArguments("window.size=1200*600");
            d = new ChromeDriver(options);

            return d;
        }
        else{
            System.setProperty("webdriver.gecko.driver","C:\\Users\\nsusz\\OneDrive\\geckodriver\\geckodriver.exe");



            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            d = new FirefoxDriver(options);

            return d;
        }
        //
        //String url=System.getProperty("https://issue-tracker-ns.herokuapp.com/");
//        System.setProperty("webdriver.chrome.driver",driverPath);

    }
}
