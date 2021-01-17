import base.Base;
import base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobject.SubmitIssue;
import testdatamanipulation.CreateFile;
import testdatamanipulation.SubWord;
import utility.CallWaitFor;
import utility.Prop;

import java.io.IOException;
public class UiTests implements CreateFile, SubWord, CallWaitFor, Prop{



    public WebDriver setup(String browser) throws IOException {



            boolean success = false;
            SubmitIssue s;
            //Base base=null;
            WebDriver d = null;
            properties();

            d = Base.createBrowser(browser);
            DriverFactory.getInstance().setDriver(d);
            d = DriverFactory.getInstance().getDriver();
//        base = new Base();
//        base.ChromeInit();
//        this.d = base.d;
            //String url = prop.getProperty("url");
            //d.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            //System.setProperty("webdriver.chrome.driver","C:\\Users\\\\nsusz\\\\OneDrive\\\\chromedriver\\\\chromedriver.exe");
            //
            return d;




    }
    public WebDriver setup2(String browser) throws IOException {



        boolean success = false;
        SubmitIssue s;
        //Base base=null;
        WebDriver d = null;
        properties();

        d = Base.createBrowser(browser);
        DriverFactory.getInstance().setDriver(d);
        d = DriverFactory.getInstance().getDriver();
//        base = new Base();
//        base.ChromeInit();
//        this.d = base.d;
        //String url = prop.getProperty("url");
        //d.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\\\nsusz\\\\OneDrive\\\\chromedriver\\\\chromedriver.exe");
        //
        return d;




    }
    @Test
    @Parameters("browser")
    public void validValuesForTheAPI_C1(String browser) throws IOException {
        WebDriver d = setup(browser);
        SubmitIssue s = new SubmitIssue(d);
        d.navigate().to("https://issue-tracker-mongo.herokuapp.com/");
        s.titleSend("");
        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getSubmit().click();

        callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        boolean containsSuccess=false;
        if(jsonText.contains(getSuccess())){
            containsSuccess=true;
        }

        Assert.assertTrue(containsSuccess);
        tearDown(d);
    }


    //
    @Test
    @Parameters("browser")
    public void nonValidTitle_C2(String browser) throws IOException {
        WebDriver d = setup(browser);
        SubmitIssue s = new SubmitIssue(d);
        d.navigate().to("https://issue-tracker-mongo.herokuapp.com/");
        s.getTitle().sendKeys(getInvalidShortTitle());
        s.getSubmit().click();
        callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTitleShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
        tearDown(d);
    }

    @Test @Parameters("browser")
    public void nothingIsEnteredToBested_C3(String browser) throws IOException {
        WebDriver d = setup(browser);
        SubmitIssue s = new SubmitIssue(d);
        d.navigate().to("https://issue-tracker-mongo.herokuapp.com/");
        s.getSubmit().click();
        callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTitleShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
        tearDown(d);
    }

    @Test @Parameters("browser")
    public void mandatoryFieldsAreEnteredExceptTitle_C4(String browser) throws IOException {
        WebDriver d = setup(browser);
        SubmitIssue s = new SubmitIssue(d);
        d.navigate().to("https://issue-tracker-mongo.herokuapp.com/");
        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getSubmit().click();
        callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTitleShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
        tearDown(d);
    }
    @Test @Parameters("browser")
    public void titleIsProvidedButNoTextField_C5(String browser) throws IOException {
        WebDriver d = setup(browser);
        SubmitIssue s = new SubmitIssue(d);
        d.navigate().to("https://issue-tracker-mongo.herokuapp.com/");
        s.getTitle().sendKeys(getValidTitle());
        s.getSubmit().click();
        callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTextShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
        tearDown(d);
    }
    @Test @Parameters("browser")
    public void noTextIsEntered_C6(String browser) throws IOException {
        WebDriver d = setup(browser);
        SubmitIssue s = new SubmitIssue(d);
        d.navigate().to("https://issue-tracker-mongo.herokuapp.com/");
        s.getTitle().sendKeys(getValidTitle());
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getSubmit().click();
        callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTextShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
        tearDown(d);
    }
    @Test @Parameters("browser")
    public void firstTwoButNotThird_C7(String browser) throws IOException {
        WebDriver d = setup(browser);
        SubmitIssue s = new SubmitIssue(d);
        d.navigate().to("https://issue-tracker-mongo.herokuapp.com/");
        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(getValidText());
        s.getSubmit().click();
        callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrCreatedByShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
        tearDown(d);
    }
    @Test @Parameters("browser")
    public void firstIsTwoChars_C9(String browser) throws IOException {
        WebDriver d = setup(browser);
        SubmitIssue s = new SubmitIssue(d);
        d.navigate().to("https://issue-tracker-mongo.herokuapp.com/");
        s.getTitle().sendKeys(getInvalidShortTitle());
        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getSubmit().click();
        callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTitleShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
        tearDown(d);
    }
    @Test @Parameters("browser")
    public void secondIsTwoChars_C10(String browser) throws IOException {
        WebDriver d = setup(browser);
        SubmitIssue s = new SubmitIssue(d);
        d.navigate().to("https://issue-tracker-mongo.herokuapp.com/");
        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(getInvalidShortText());
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getSubmit().click();
        callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        // //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrTextShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
        tearDown(d);
    }

    @Test @Parameters("browser")
    public void thirdIsTwoChars_C11(String browser) throws IOException {
        WebDriver d = setup(browser);
        SubmitIssue s = new SubmitIssue(d);
        d.navigate().to("https://issue-tracker-mongo.herokuapp.com/");
        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(getInvalidShortCreatedBy());
        s.getSubmit().click();
        callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
        //System.out.println(jsonText);
        boolean errOk=false;
        if(jsonText.contains(getErrCreatedByShort())){
            errOk=true;
        }
        Assert.assertTrue(errOk);
        tearDown(d);
    }
    @Test @Parameters("browser")
    public void FourEntered_C12(String browser) throws IOException {
        boolean success=false;
        WebDriver d = setup(browser);
        SubmitIssue s = new SubmitIssue(d);
        d.navigate().to("https://issue-tracker-mongo.herokuapp.com/");
        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getAssignedTo().sendKeys(getAssignedTo());
        s.getSubmit().click();
        callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getSuccess())){
            success=true;
        }
        Assert.assertTrue(success);
        tearDown(d);
    }
    @Test @Parameters("browser")
    public void allFiveEntered_C14(String browser) throws IOException {
        boolean success = false;
        WebDriver d = setup(browser);
        SubmitIssue s = new SubmitIssue(d);
        d.navigate().to("https://issue-tracker-mongo.herokuapp.com/");

        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getAssignedTo().sendKeys(getAssignedTo());
        s.getStatus().sendKeys(getStatus());
        s.getSubmit().click();
        callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getSuccess())){
            success=true;
        }
        Assert.assertTrue(success);
        tearDown(d);
    }
    @Test @Parameters("browser")
    public void  title256Chars_C15(String browser) throws IOException {
        boolean success = false;
        WebDriver d = setup(browser);
        SubmitIssue s = new SubmitIssue(d);
        d.navigate().to("https://issue-tracker-mongo.herokuapp.com/");
        String chars256 = getString(256);
        s.getTitle().sendKeys(chars256);
        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getAssignedTo().sendKeys(getAssignedTo());
        s.getStatus().sendKeys(getStatus());
        s.getSubmit().click();
        callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getErrTitleShort())){
            success=true;
        }
        Assert.assertTrue(success);
        tearDown(d);
    }
    @Test @Parameters("browser")
    public void text3001Chars_C16(String browser) throws IOException {
        boolean success=false;
        WebDriver d = setup(browser);
        SubmitIssue s = new SubmitIssue(d);
        d.navigate().to("https://issue-tracker-mongo.herokuapp.com/");

        String data = createData(3001);
        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(data);
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getSubmit().click();
        callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getErrTextShort())){
            success=true;
        }
        Assert.assertTrue(success);
        tearDown(d);
    }
    @Test @Parameters("browser")
    public void text3000Chars_C17(String browser) throws IOException {
        boolean success=false;
        WebDriver d = setup(browser);
        SubmitIssue s = new SubmitIssue(d);
        d.navigate().to("https://issue-tracker-mongo.herokuapp.com/");
        String data = createData(3000);
        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(data);
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getSubmit().click();
        callWait(s.getJson(),d);
        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getSuccess())){
            success=true;
        }
        Assert.assertTrue(success);
        tearDown(d);
    }
    @Test @Parameters("browser")
    public void title255Chars_C18(String browser) throws IOException {
        boolean success=false;
        WebDriver d = setup(browser);
        SubmitIssue s = new SubmitIssue(d);
        d.navigate().to("https://issue-tracker-mongo.herokuapp.com/");
        String chars256 = getString(255);
        s.getTitle().sendKeys(chars256);
        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(getValidCreatedBy());
        s.getAssignedTo().sendKeys(getAssignedTo());
        s.getStatus().sendKeys(getStatus());
        s.getSubmit().click();
        callWait(s.getJson(),d);
//        wait = callWait(s.getJson());
        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getSuccess())){
            success=true;
        }
        Assert.assertTrue(success);
        tearDown(d);
    }
    @Test @Parameters("browser")
    public void createdBy256Chars_C20(String browser) throws IOException {
//        a = new SubWord();
//        String chars256 = a.getString(256);
        boolean success=false;
        WebDriver d = setup(browser);
        SubmitIssue s = new SubmitIssue(d);
        d.navigate().to("https://issue-tracker-mongo.herokuapp.com/");
        String data = createData(256);
        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(data);
        s.getSubmit().click();
        callWait(s.getJson(),d);
//        wait = callWait(s.getJson());
        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getErrCreatedByShort())){
            success=true;
        }
        Assert.assertTrue(success);
        tearDown(d);
    }
    @Test @Parameters("browser")
    public void createdBy255Chars_C21(String browser) throws IOException {
//        a = new SubWord();
//        String chars256 = a.getString(255);
        boolean success=false;
        WebDriver d = setup(browser);
        SubmitIssue s = new SubmitIssue(d);
        d.navigate().to("https://issue-tracker-mongo.herokuapp.com/");
        String data = createData(255);
        s.getTitle().sendKeys(getValidTitle());
        s.getText().sendKeys(getValidText());
        s.getCreatedBy().sendKeys(data);
        s.getSubmit().click();
        callWait(s.getJson(),d);

//        wait = callWait(s.getJson());
        String jsonText = s.getJson().getText();
//        //System.out.println(jsonText);
        if(jsonText.contains(getSuccess())){
            success=true;
        }
        Assert.assertTrue(success);
        tearDown(d);
    }
    public void tearDown(WebDriver d){
        d.quit();
    }

}
