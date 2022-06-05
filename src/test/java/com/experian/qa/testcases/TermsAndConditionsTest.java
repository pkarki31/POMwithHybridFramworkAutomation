package com.experian.qa.testcases;

import com.experian.qa.base.TestBase;
import com.experian.qa.pages.ConsolidatingOtherDebts;
import com.experian.qa.pages.TermsAndConditions;
import org.testng.Assert;
import org.testng.annotations.*;

public class TermsAndConditionsTest extends TestBase {

    TermsAndConditions termsAndConditions;

    public TermsAndConditionsTest(){

        super();
    }


    @BeforeMethod(groups = {"SmokeTest","FunctionalTest"})
    public void setup(){

        initialization();
        termsAndConditions = new TermsAndConditions();
    }

    @Test(groups = {"SmokeTest","FunctionalTest"})
    public void validateTitleTest(){

        System.out.println("hi ...");

        String title = termsAndConditions.validateTitle();

        System.out.println("title : "+title);

        Assert.assertEquals(prop.getProperty("termsAndConditionPageTitle"),title);
    }

    @AfterMethod(groups = {"SmokeTest","FunctionalTest"})
    public void tearDown(){

        driver.quit();
    }
}
