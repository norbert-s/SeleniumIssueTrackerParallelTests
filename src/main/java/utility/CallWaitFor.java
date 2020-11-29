package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.concurrent.ThreadSafe;

public @ThreadSafe interface CallWaitFor {
    public default WebDriverWait callWait(WebElement getJsonLocation, WebDriver d){
        WebDriverWait wait= new WebDriverWait(d,15);
        WebElement waitForJson = wait.until(ExpectedConditions.visibilityOf(getJsonLocation));
        return wait;
    }
}
