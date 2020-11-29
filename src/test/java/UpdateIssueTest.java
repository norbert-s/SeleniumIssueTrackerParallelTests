//import base.Base;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pageobject.UpdateIssue;
//import testdatamanipulation.CreateFile;
//import testdatamanipulation.ReadTxt;
//import utility.callWaitFor;
//
//
//import java.io.IOException;
//
//public class UpdateIssueTest implements CreateFile,ReadTxt, callWaitFor {
//    String jsonText,id;
//    boolean errOk=false;
//    boolean success=false;
//
//    Base base;
//    WebDriver d;
//    private UpdateIssue update=null;
//
//    @BeforeMethod
//    public void setupMethod() throws IOException {
//        base = new Base();
//        base.ChromeInit();
//        this.d = base.d;
//        d.navigate();
//        errOk=false;
//        success=false;
//        d.navigate().refresh();
//        id = returnRandomLineNumberOfIds();
//    }
//
//    @Test
//    public void nothingIsEnteredAndThenSubmitted_C22(){
//        update.getSubmit().click();
//        callWait(update.getJson(),d);
//        jsonText = update.getJson().getText();
//        if(jsonText.contains(getUpdateErrId())){
//            errOk=true;
//        }
//        Assert.assertTrue(errOk);
//
//    }
//
//    @Test
//    public void validIdIsNotEnteredButOtherFields_C23(){
//        update.getTitle().sendKeys(getValidTitle());
//        update.getText().sendKeys(getValidText());
//        update.getSubmit().click();
//        callWait(update.getJson(),d);
//        jsonText = update.getJson().getText();
//        if(jsonText.contains(getUpdateErrId())){
//            errOk=true;
//        }
//        Assert.assertTrue(errOk);
//    }
//    @Test
//    public void everythingIsValidEntered_C24() {
//        update.getId().sendKeys(id);
//        update.getTitle().sendKeys(getValidTitle());
//        update.getText().sendKeys(getValidText());
//        update.getSubmit().click();
//        callWait(update.getJson(),d);
//        jsonText = update.getJson().getText();
//        if(jsonText.contains(getSuccessUpdate())){
//            success=true;
//        }
//        Assert.assertTrue(success);
//    }
//    @Test
//    public void everythingIsValidEntered_C25() {
//        update.getId().sendKeys(id);
//        update.getTitle().sendKeys(getValidTitle());
//        update.getText().sendKeys(getValidText());
//        update.changeStatus().click();
//        update.getSubmit().click();
//        callWait(update.getJson(),d);
//        jsonText = update.getJson().getText();
//        if(jsonText.contains(getSuccessUpdate()) && jsonText.contains("status: false")){
//            success=true;
//        }
//        Assert.assertTrue(success);
//    }
//    @Test
//    public void notValidIdIsEntered_C26(){
//        update.getId().sendKeys(getInvalidShortText()); //providing not valid id
//        update.getTitle().sendKeys(getValidTitle());
//        update.getText().sendKeys(getValidText());
//        update.getSubmit().click();
//        callWait(update.getJson(),d);
//        jsonText = update.getJson().getText();
//        if(jsonText.contains(getUpdateErrId())){
//            errOk=true;
//        }
//        Assert.assertTrue(errOk);
//    }
//    @AfterMethod
//    public void tearDown(){
//        d.close();
//        base = null;
//    }
//}
