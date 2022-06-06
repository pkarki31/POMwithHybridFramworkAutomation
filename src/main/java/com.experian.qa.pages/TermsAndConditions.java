package com.experian.qa.pages;

import com.experian.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class TermsAndConditions extends TestBase {


    public TermsAndConditions(){

        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath="//*[text()='Terms & Conditions']")
    WebElement termsAndConditionLink;

    @FindBy(id="ensCloseBanner")
    public WebElement cookiesPrompt;

    public String validateTitle()  {

        try {
            cookiesPrompt.click();

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

            termsAndConditionLink.click();

            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());

            Thread.sleep(10000);

            driver.switchTo().window(tabs2.get(1));


        }

        catch (InterruptedException e){
            e.printStackTrace();
        }

        return driver.getTitle();

    }


}
