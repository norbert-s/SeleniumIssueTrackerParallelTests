package utility;

import javax.annotation.concurrent.ThreadSafe;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public @ThreadSafe interface Prop {
    Properties prop = new Properties();



    default void properties()  {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:\\Users\\nsusz\\OneDrive\\source\\Idea2\\testing\\SeleniumIssueTracker\\src\\main\\java\\properties\\data.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    default String getCreateFileNew(){
        return prop.getProperty("createFileNew");
    }
    default String getValidTitle() {
        return  prop.getProperty("validTitle");
    }

    default String getValidText() {
        return prop.getProperty("validText");
    }

    default String getValidCreatedBy() {
        return prop.getProperty("validCreatedBy");
    }

    default String getAssignedTo(){
        return prop.getProperty("assignedTo");
    }

    default String getStatus(){
        return prop.getProperty("status");
    }

    default String getInvalidShortTitle() {
        return prop.getProperty("invalidShortTitle");
    }

    default String getInvalidShortText() {
        return prop.getProperty("invalidShortText");
    }

    default String getInvalidShortCreatedBy() {
        return prop.getProperty("invalidShortCreatedBy");
    }

    default String getUpdateErrId(){
        return prop.getProperty("errIdShort");
    }

    default String getErrTitleShort(){
        return prop.getProperty("errTitleShort");
    }

    default String getErrTextShort(){
        return prop.getProperty("errTextShort");
    }

    default String getErrCreatedByShort(){
        return prop.getProperty("errCreatedByShort");
    }

    default String getErrDeleteId(){
        return prop.getProperty("errDeleteId");
    }

    default String getSuccess(){
        return prop.getProperty("success");
    }

    default String getSuccessUpdate(){
        return prop.getProperty("successUpdate");
    }

    default String getTxtLocation(){
        return prop.getProperty("txtLocation");
    }

    default String getErrWhenDbEmptyAndStatusActive(){
        return prop.getProperty("QueryStatusActiveWhenDbIsEmpty");
    }
    default String getAssignedTo2(){
        return prop.getProperty("assignedTo2");
    }
    default String getInvalidAssignedTo(){
        return prop.getProperty("invalidAssignedTo");
    }

    default String getInvalidStatusText(){
        return prop.getProperty("invalidStatus");
    }

}
