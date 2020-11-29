//import base.Base;
//import base.DriverFactory;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.*;
//import pageobject.SubmitIssue;
//import testdatamanipulation.CreateFile;
//import testdatamanipulation.SubWord;
//import utility.CallWaitFor;
//import utility.Prop;
//
//import java.io.IOException;
//
//public class SubmitIssueTest implements CreateFile, SubWord, CallWaitFor, Prop {
//
//    boolean success=false;
//    public SubmitIssue s;
//    //Base base=null;
//    WebDriver d=null;
//
//    @BeforeClass
//    void prepareTest(){
//
//    }
//    @BeforeMethod
//    public void setupMethod() throws IOException {
//        properties();
//
//        d = Base.createBrowser();
//        DriverFactory.getInstance().setDriver(d);
//        d = DriverFactory.getInstance().getDriver();
////        base = new Base();
////        base.ChromeInit();
////        this.d = base.d;
//        //String url = prop.getProperty("url");
//        //d.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\nsusz\\\\OneDrive\\\\chromedriver\\\\chromedriver.exe");
//        //
//        String url=System.getProperty("https://issue-tracker-ns.herokuapp.com/");
//        s = new SubmitIssue(d);
//        d.navigate().to("https://issue-tracker-ns.herokuapp.com/");
//    }
//
//    @Test
//    public void validValuesForTheAPI_C1()  {
//        s.titleSend("");
//        s.getTitle().sendKeys(getValidTitle());
//        s.getText().sendKeys(getValidText());
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getSubmit().click();
//
//        callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
//        boolean containsSuccess=false;
//        if(jsonText.contains(getSuccess())){
//            containsSuccess=true;
//        }
//
//        Assert.assertTrue(containsSuccess);
//    }
////
//    @Test
//    public void nonValidTitle_C2()  {
//        s.getTitle().sendKeys(getInvalidShortTitle());
//        s.getSubmit().click();
//        callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
//        boolean errOk=false;
//        if(jsonText.contains(getErrTitleShort())){
//            errOk=true;
//        }
//        Assert.assertTrue(errOk);
//    }
//
//    @Test
//    public void nothingIsEnteredToBested_C3()  {
//        s.getSubmit().click();
//        callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
//        boolean errOk=false;
//        if(jsonText.contains(getErrTitleShort())){
//            errOk=true;
//        }
//        Assert.assertTrue(errOk);
//    }
//
//    @Test
//    public void mandatoryFieldsAreEnteredExceptTitle_C4()   {
//
//        s.getText().sendKeys(getValidText());
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getSubmit().click();
//        callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
//        boolean errOk=false;
//        if(jsonText.contains(getErrTitleShort())){
//            errOk=true;
//        }
//        Assert.assertTrue(errOk);
//    }
//    @Test
//    public void titleIsProvidedButNoTextField_C5()   {
//        s.getTitle().sendKeys(getValidTitle());
//        s.getSubmit().click();
//        callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
//        boolean errOk=false;
//        if(jsonText.contains(getErrTextShort())){
//            errOk=true;
//        }
//        Assert.assertTrue(errOk);
//    }
//    @Test
//    public void noTextIsEntered_C6()   {
//        s.getTitle().sendKeys(getValidTitle());
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getSubmit().click();
//        callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
//        boolean errOk=false;
//        if(jsonText.contains(getErrTextShort())){
//            errOk=true;
//        }
//        Assert.assertTrue(errOk);
//    }
//    @Test
//    public void firstTwoButNotThird_C7()   {
//        s.getTitle().sendKeys(getValidTitle());
//        s.getText().sendKeys(getValidText());
//        s.getSubmit().click();
//        callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
//        boolean errOk=false;
//        if(jsonText.contains(getErrCreatedByShort())){
//            errOk=true;
//        }
//        Assert.assertTrue(errOk);
//    }
//    @Test
//    public void firstIsTwoChars_C9()   {
//        s.getTitle().sendKeys(getInvalidShortTitle());
//        s.getText().sendKeys(getValidText());
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getSubmit().click();
//        callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
//        boolean errOk=false;
//        if(jsonText.contains(getErrTitleShort())){
//            errOk=true;
//        }
//        Assert.assertTrue(errOk);
//    }
//    @Test
//    public void secondIsTwoChars_C10()   {
//        s.getTitle().sendKeys(getValidTitle());
//        s.getText().sendKeys(getInvalidShortText());
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getSubmit().click();
//        callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
//       // //System.out.println(jsonText);
//        boolean errOk=false;
//        if(jsonText.contains(getErrTextShort())){
//            errOk=true;
//        }
//        Assert.assertTrue(errOk);
//    }
//
//    @Test
//    public void thirdIsTwoChars_C11()   {
//        s.getTitle().sendKeys(getValidTitle());
//        s.getText().sendKeys(getValidText());
//        s.getCreatedBy().sendKeys(getInvalidShortCreatedBy());
//        s.getSubmit().click();
//        callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
//        boolean errOk=false;
//        if(jsonText.contains(getErrCreatedByShort())){
//            errOk=true;
//        }
//        Assert.assertTrue(errOk);
//    }
//    @Test
//    public void FourEntered_C12()   {
//        s.getTitle().sendKeys(getValidTitle());
//        s.getText().sendKeys(getValidText());
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getAssignedTo().sendKeys(getAssignedTo());
//        s.getSubmit().click();
//        callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
////        //System.out.println(jsonText);
//        if(jsonText.contains(getSuccess())){
//            success=true;
//        }
//        Assert.assertTrue(success);
//    }
//    @Test
//    public void allFiveEntered_C14() {
//
//
//        s.getTitle().sendKeys(getValidTitle());
//        s.getText().sendKeys(getValidText());
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getAssignedTo().sendKeys(getAssignedTo());
//        s.getStatus().sendKeys(getStatus());
//        s.getSubmit().click();
//        callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
////        //System.out.println(jsonText);
//        if(jsonText.contains(getSuccess())){
//            success=true;
//        }
//        Assert.assertTrue(success);
//
//    }
//    @Test
//    public void  title256Chars_C15() throws IOException {
//
//        String chars256 = getString(256);
//        s.getTitle().sendKeys(chars256);
//        s.getText().sendKeys(getValidText());
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getAssignedTo().sendKeys(getAssignedTo());
//        s.getStatus().sendKeys(getStatus());
//        s.getSubmit().click();
//        callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
////        //System.out.println(jsonText);
//        if(jsonText.contains(getErrTitleShort())){
//            success=true;
//        }
//        Assert.assertTrue(success);
//    }
//    @Test
//    public void text3001Chars_C16() throws IOException {
//
//
//        String data = createData(3001);
//        s.getTitle().sendKeys(getValidTitle());
//        s.getText().sendKeys(data);
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getSubmit().click();
//        callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
////        //System.out.println(jsonText);
//        if(jsonText.contains(getErrTextShort())){
//            success=true;
//        }
//        Assert.assertTrue(success);
//    }
//    @Test
//    public void text3000Chars_C17() throws IOException {
//
//        String data = createData(3000);
//        s.getTitle().sendKeys(getValidTitle());
//        s.getText().sendKeys(data);
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getSubmit().click();
//        callWait(s.getJson(),d);
//        String jsonText = s.getJson().getText();
////        //System.out.println(jsonText);
//        if(jsonText.contains(getSuccess())){
//            success=true;
//        }
//        Assert.assertTrue(success);
//    }
//    @Test
//    public void title255Chars_C18() throws IOException {
//
//        String chars256 = getString(255);
//        s.getTitle().sendKeys(chars256);
//        s.getText().sendKeys(getValidText());
//        s.getCreatedBy().sendKeys(getValidCreatedBy());
//        s.getAssignedTo().sendKeys(getAssignedTo());
//        s.getStatus().sendKeys(getStatus());
//        s.getSubmit().click();
//        callWait(s.getJson(),d);
////        wait = callWait(s.getJson());
//        String jsonText = s.getJson().getText();
////        //System.out.println(jsonText);
//        if(jsonText.contains(getSuccess())){
//            success=true;
//        }
//        Assert.assertTrue(success);
//    }
//    @Test
//    public void createdBy256Chars_C20() throws IOException {
////        a = new SubWord();
////        String chars256 = a.getString(256);
//
//        String data = createData(256);
//        s.getTitle().sendKeys(getValidTitle());
//        s.getText().sendKeys(getValidText());
//        s.getCreatedBy().sendKeys(data);
//        s.getSubmit().click();
//        callWait(s.getJson(),d);
////        wait = callWait(s.getJson());
//        String jsonText = s.getJson().getText();
////        //System.out.println(jsonText);
//        if(jsonText.contains(getErrCreatedByShort())){
//            success=true;
//        }
//        Assert.assertTrue(success);
//    }
//    @Test
//    public void createdBy255Chars_C21() throws IOException {
////        a = new SubWord();
////        String chars256 = a.getString(255);
//
//        String data = createData(255);
//        s.getTitle().sendKeys(getValidTitle());
//        s.getText().sendKeys(getValidText());
//        s.getCreatedBy().sendKeys(data);
//        s.getSubmit().click();
//        callWait(s.getJson(),d);
//
////        wait = callWait(s.getJson());
//        String jsonText = s.getJson().getText();
////        //System.out.println(jsonText);
//        if(jsonText.contains(getSuccess())){
//            success=true;
//        }
//        Assert.assertTrue(success);
//    }
//
//    @AfterMethod
//    public void tearDown(){
//        d.quit();
//
//    }
//    @AfterClass
//    public void tearDownFinal(){
//
//    }
//}
