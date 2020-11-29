//import base.Base;
//import base.DriverFactory;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pageobject.GetIssue;
//import pageobject.SubmitIssue;
//import testdatamanipulation.CreateFile;
//import testdatamanipulation.ReadTxt;
//import testdatamanipulation.SubWord;
//
//import utility.CallWaitFor;
//
//
//import java.io.IOException;
//import java.util.List;
//
//public class GetIssueTest implements CreateFile,ReadTxt,SubWord, CallWaitFor {
//    private String jsonText;
//    private GetIssue getIssue;
//    private List<WebElement> list=null;
//    boolean errOk=false;
//    boolean success=false;
//    WebDriver d;
//    SubmitIssue s;
//
//    @BeforeMethod
//    public void setupMethod() throws IOException {
//
//        d = Base.createBrowser();
//        DriverFactory.getInstance().setDriver(d);
//        d = DriverFactory.getInstance().getDriver();
////        base = new Base();
////        base.ChromeInit();
////        this.d = base.d;
//        String url = prop.getProperty("url");
//        //d.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//
//        s = new SubmitIssue(d);
//        d.navigate().to(url);
//        getIssue = new GetIssue(d);
//        errOk=false;
//        success=false;
//        jsonText="";
//        d.navigate().refresh();
//    }
//
////    @Test
////    public void queryStatusOpenActiveWhenThereIsAlreadySomethingInTheDatabase_C30(){
////        getIssue.getSubmit().submit();
////        if(getIssue.getDivJsons().size()>0){
////            success=true;
////        }
////        System.out.println(getIssue.getDivJsons().size());
////        Assert.assertTrue(success);
////    }
////
////    @Test
////    public void queryStatusOpenActiveWhenDatabaseIsEmpty_C31(){
////        getIssue.getSubmit().submit();
////        callWait(getIssue.getJsonText(),d);
////        jsonText = getIssue.getJsonText().getText();
////
////        if(jsonText.contains(getErrWhenDbEmptyAndStatusActive())){
////            success=true;
////        }
//////        Assert.assertTrue(success); //ez kell ha valoban ures a db ahhoz, hogy igaz legyen
////        Assert.assertFalse(success);
////    }
////
////    @Test
////    public void statusClosedNoRecordsAreFlaggedAsClosed_C32() {
////        getIssue.getStatus().click();
////        getIssue.getStatus().sendKeys(Keys.ARROW_DOWN);
////        getIssue.getStatus().sendKeys(Keys.ARROW_DOWN);
////        getIssue.getStatus().sendKeys(Keys.COMMAND);
////        getIssue.getSubmit().submit();
////        callWait(getIssue.getJsonText(),d);
////        jsonText = getIssue.getJsonText().getText();
////
////        if(jsonText.contains(getErrWhenDbEmptyAndStatusActive())){
////            success=true;
////        }
//////        Assert.assertTrue(success);//ez kell ha nincs egy se falgelve ahhoz, hogy igaz legyen
////        Assert.assertFalse(success);
////    }
////    @Test //ha van closed akkor kizárja,h ez fusson
////    public void statusClosedThereAreRecordsFlaggedAsClosed_C33() throws RuntimeException {
////        getIssue.getStatus().click();
////        getIssue.getStatus().sendKeys(Keys.ARROW_DOWN);
////        getIssue.getStatus().sendKeys(Keys.ARROW_DOWN);
////        getIssue.getStatus().sendKeys(Keys.COMMAND);
////        getIssue.getSubmit().submit();
////        callWait(getIssue.getJsonText(),d);
////        jsonText = getIssue.getJsonText().getText();
////
////        List<WebElement> list = getIssue.getDivJsons();
////        if(list.size()>0){
////            success=true;
////        }
////        Assert.assertTrue(success);
////    }
//
//    @Test
//    public void validId_C34() throws IOException {
//        String id = returnRandomLineNumberOfIds();
//
//        getIssue.getId().sendKeys(id);
//
//        getIssue.getSubmit().click();
//        callWait(getIssue.getJsonText(),d);
//        try{
//            list = getIssue.getDivJsons();
//        }catch(Exception e){
//            System.out.println("something went wrong");
//        }
//        System.out.println(list.size());
//        if(list.size()==1){
//            success=true;
//        }
//        Assert.assertTrue(success);
//    }
//
////    @Test
////    public void invalidId_C35()  {
////
////        getIssue.getId().sendKeys(getValidTitle());
////        getIssue.getSubmit().click();
////        callWait(getIssue.getJsonText(),d);
////        jsonText = getIssue.getJsonText().getText();
////        if(jsonText.contains(getErrWhenDbEmptyAndStatusActive())){
////            success=true;
////        }
////        Assert.assertTrue(success);
////    }
////
////    @Test
////    public void validTitle_C36()  {
////        getIssue.getTitle().sendKeys("asd");
////        getIssue.getSubmit().click();
////        callWait(getIssue.getJsonText(),d);
////        jsonText = getIssue.getJsonText().getText();
////        list = getIssue.getDivJsons();
////        if(list.size()>0){
////            success=true;
////        }
////        Assert.assertTrue(success);
////    }
////
////    @Test
////    public void invalidTitle_C37(){
////        getIssue.getTitle().sendKeys(getInvalidShortTitle());
////        getIssue.getSubmit().click();
////        callWait(getIssue.getJsonText(),d);
////        jsonText = getIssue.getJsonText().getText();
////        list = getIssue.getDivJsons();
////        if(list.size()==0){
////            success=true;
////        }
////        Assert.assertTrue(success);
////    }
////
////    @Test
////    public void validText_C38(){
////        getIssue.getText().sendKeys(getValidText());
////        getIssue.getSubmit().click();
////        callWait(getIssue.getJsonText(),d);
////        jsonText = getIssue.getJsonText().getText();
////        list = getIssue.getDivJsons();
////        if(list.size()>0){
////            success=true;
////        }
////        Assert.assertTrue(success);
////    }
////
////    @Test
////    public void invalidText_39(){
////        getIssue.getText().sendKeys(getInvalidShortText());
////        getIssue.getSubmit().click();
////        callWait(getIssue.getJsonText(),d);
////        jsonText = getIssue.getJsonText().getText();
////        list = getIssue.getDivJsons();
////        if(list.size()==0){
////            success=true;
////        }
////        Assert.assertTrue(success);
////    }
////
////    @Test
////    public void validCreatedBy_40(){
////        getIssue.getCreatedBy().sendKeys(getValidCreatedBy());
////        getIssue.getSubmit().click();
////        callWait(getIssue.getJsonText(),d);
////        jsonText = getIssue.getJsonText().getText();
////        list = getIssue.getDivJsons();
////        if(list.size()>0){
////            success=true;
////        }
////        Assert.assertTrue(success);
////    }
////
////    @Test
////    public void invalidCreatedBy_41(){
////        getIssue.getCreatedBy().sendKeys(getInvalidShortCreatedBy());
////        getIssue.getSubmit().click();
////        callWait(getIssue.getJsonText(),d);
////        jsonText = getIssue.getJsonText().getText();
////        list = getIssue.getDivJsons();
////        if(list.size()==0){
////            success=true;
////        }
////        Assert.assertTrue(success);
////        Assert.assertTrue(jsonText.contains(getErrWhenDbEmptyAndStatusActive()));
////    }
////
////    @Test
////    public void validAssignedTo_42(){
////        getIssue.getAssignedTo().sendKeys(getAssignedTo2());
////        getIssue.getSubmit().click();
////        callWait(getIssue.getJsonText(),d);
////        jsonText = getIssue.getJsonText().getText();
////        list = getIssue.getDivJsons();
////        if(list.size()>0){
////            success=true;
////        }
////        Assert.assertTrue(success);
////    }
////
////    @Test
////    public void invalidAssignedTo_43(){
////        getIssue.getAssignedTo().sendKeys(getInvalidAssignedTo());
////        getIssue.getSubmit().click();
////        callWait(getIssue.getJsonText(),d);
////        jsonText = getIssue.getJsonText().getText();
////        list = getIssue.getDivJsons();
////        if(list.size()==0){
////            success=true;
////        }
////        Assert.assertTrue(success);
////        Assert.assertTrue(jsonText.contains(getErrWhenDbEmptyAndStatusActive()));
////    }
////
////    @Test
////    public void validStatusText_44(){
////        getIssue.getStatusText().sendKeys(getStatus());
////        getIssue.getSubmit().click();
////        callWait(getIssue.getJsonText(),d);
////        jsonText = getIssue.getJsonText().getText();
////        list = getIssue.getDivJsons();
////        if(list.size()>0){
////            success=true;
////        }
////        Assert.assertTrue(success);
////    }
////
////    @Test
////    public void invalidStatusText_45(){
////        getIssue.getStatusText().sendKeys(getInvalidStatusText());
////        getIssue.getSubmit().click();
////        callWait(getIssue.getJsonText(),d);
////        jsonText = getIssue.getJsonText().getText();
////        list = getIssue.getDivJsons();
////        if(list.size()==0){
////            success=true;
////        }
////        Assert.assertTrue(success);
////        Assert.assertTrue(jsonText.contains(getErrWhenDbEmptyAndStatusActive()));
////    }
//
//    @AfterMethod
//
//    public void tearDown(){
//        d.close();
//        d = null;
//    }
//}
