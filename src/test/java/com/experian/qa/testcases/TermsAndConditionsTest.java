package com.experian.qa.testcases;

import com.experian.qa.base.TestBase;
import com.experian.qa.pages.ConsolidatingOtherDebts;
import com.experian.qa.pages.TermsAndConditions;
import com.experian.qa.util.ScreenShot;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.experian.qa.util.ScreenShot.captureScreenShot;

public class TermsAndConditionsTest extends TestBase {

    TermsAndConditions termsAndConditions;


    public TermsAndConditionsTest(){

        super();
    }

    @Parameters({"browser"})
    @BeforeMethod(groups = {"SmokeTest","FunctionalTest"})
    public void setup(String browser){

        initialization(browser);
        termsAndConditions = new TermsAndConditions();
    }


    @Test(groups = {"SmokeTest","FunctionalTest"})
    public void validateTitleTest(){

        String title = termsAndConditions.validateTitle();

        captureScreenShot(driver,"validateTitleTest");

        Assert.assertEquals(prop.getProperty("termsAndConditionPageTitle"),title);
    }

    @AfterMethod(groups = {"SmokeTest","FunctionalTest"} ,alwaysRun = true)
    public void tearDown(){

        driver.quit();
    }
}
