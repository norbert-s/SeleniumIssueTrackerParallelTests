//import base.Base;
//import org.openqa.selenium.WebDriver;
//
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import pageobject.DeleteIssue;
//import pageobject.SubmitIssue;
//import testdatamanipulation.CreateFile;
//import testdatamanipulation.ReadTxt;
//import utility.callWaitFor;
//
//import java.io.IOException;
//
//public class DeleteIssueTest implements CreateFile,ReadTxt, callWaitFor {
//
//    private String jsonText;
//    private boolean errOk=false;
//    private boolean success=false;
//
//    private DeleteIssue delete;
//    private SubmitIssue submit;
//
//
//    Base base;
//    WebDriver d;
//
//
//    @BeforeTest
//    public void setup() throws IOException {
//        base = new Base();
//        base.ChromeInit();
//        this.d = base.d;
//        delete = new DeleteIssue(d);
//        submit = new SubmitIssue(d);
//
//    }
//    @BeforeMethod
//    public void setupMethod()  {
//        errOk=false;
//        success=false;
//        jsonText="";
//        d.navigate().refresh();
//
//    }
//
//    @Test
//    public void nothingIsEnteredAndThenSubmitted_C27()  {
//        delete.getSubmit().click();
//        callWait(delete.getJson(),d);
//        jsonText = delete.getJson().getText();
//        if(jsonText.contains(getErrDeleteId())){
//            errOk=true;
//        }
//        Assert.assertTrue(errOk);
//    }
//
//    @Test
//    public void invalidIdEntered_C28() {
//        delete.getIdField().sendKeys(getValidText());
//        delete.getSubmit().click();
//
//        callWait(delete.getJson(),d);
//        jsonText = delete.getJson().getText();
//        if(jsonText.contains(getErrDeleteId())){
//            errOk=true;
//        }
//        Assert.assertTrue(errOk);
//    }
//
//    @Test
//    public void validIdEntered_26() throws InterruptedException {
//
//        submit.getTitle().sendKeys(getValidTitle());
//        submit.getText().sendKeys(getValidText());
//        submit.getCreatedBy().sendKeys(getValidCreatedBy());
//        submit.getSubmit().click();
//
//        Thread.sleep(3000);
//        callWait(delete.getJson(),d);
//
//        String json = submit.getJson().getText();
//        String [] tomb = json.split(" ");
//        json = tomb[4];
//        tomb = json.split("t");
//        String id = tomb[0];
//        d.navigate().refresh();
//        jsonText="";
//        delete.getIdField().sendKeys(id);
//        delete.getSubmit().submit();
//        callWait(delete.getJson(),d);
//        jsonText = delete.getJson().getText();
//        System.out.println(jsonText);
//        if(jsonText.contains("and the record below has been")){
//            success = true;
//        }
//        Assert.assertTrue(success);
//
//    }
//
//    @AfterMethod
//    public void tearDown(){
//        d.close();
//        d = null;
//    }
//
//
//
//}
