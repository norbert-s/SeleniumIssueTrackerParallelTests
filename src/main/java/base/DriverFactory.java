package base;



import org.openqa.selenium.WebDriver;

import javax.annotation.concurrent.ThreadSafe;

public @ThreadSafe class DriverFactory  {

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static DriverFactory instance = new DriverFactory();
    private DriverFactory(){

    }


    public static DriverFactory getInstance(){
        return instance;
    }



    public WebDriver getDriver(){
        return driver.get();
    }

    public void setDriver(WebDriver driverParam){
        driver.set(driverParam);
    }

    public void removeDriver(){
        driver.get().quit();
        driver.remove();
    }
}
