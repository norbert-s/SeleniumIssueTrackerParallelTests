package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Prop;

import javax.annotation.concurrent.ThreadSafe;
import java.io.IOException;



public @ThreadSafe class SubmitIssue  {
    public WebDriver d;
    Prop propObj;

    public WebElement title,text,createdBy,assignedTo,status,submit,json;

    public SubmitIssue(WebDriver d) throws IOException {
        this.d = d;
        PageFactory.initElements(this.d,this);
    }

    @FindBy(css="form[method='post'] input[name='issue_title']")
    WebElement byTitle;

    @FindBy(css="form[method='post'] textarea[name='issue_text']")
    WebElement byText;

    @FindBy(css="form[method='post'] input[name='created_by']")
    WebElement byCreatedBy;

    @FindBy(css="form[method='post'] input[name='assigned_to']")
    WebElement byAssignedTo;

    @FindBy(css="form[method='post'] input[name='status_text']")
    WebElement byStatusText;

    @FindBy(css="form[method='post'] button[type='submit']")
    WebElement bySubmit;


    @FindBy(id="jsonResult")
    WebElement byJson;

    public  WebElement find(By x){
        return d.findElement(x);
    }


    public  void titleSend(String func){
        byTitle.sendKeys(func);
    }

    public void textSend(String func){
        byText.sendKeys(func);
    }

    public void createdBySend(String func){
        byCreatedBy.sendKeys(func);
    }



    public WebElement getTitle(){
        return byTitle;
    }

    public WebElement getText(){
        return  byText;

    }

    public WebElement getCreatedBy(){
        return byCreatedBy;

    }

    public WebElement getAssignedTo(){
        return byAssignedTo;

    }

    public WebElement getStatus(){
        return byStatusText;

    }

    public WebElement getSubmit() {
        return bySubmit;
    }

    public WebElement getJson(){
       return byJson;

    }
}
