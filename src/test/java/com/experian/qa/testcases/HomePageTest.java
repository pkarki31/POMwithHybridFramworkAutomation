package com.experian.qa.testcases;

import com.experian.qa.base.TestBase;
import com.experian.qa.pages.ConsolidatingOtherDebts;
import com.experian.qa.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.experian.qa.base.TestBase.driver;
import static com.experian.qa.base.TestBase.initialization;

public class HomePageTest extends TestBase {


    HomePage home;

    public HomePageTest(){
        super();
    }

    @BeforeMethod(groups = {"SmokeTest","FunctionalTest"})
    @Parameters({"browser"})
    public void setup(String browser){

        initialization(browser);
        home = new HomePage();
    }

    @Test(groups = {"SmokeTest","FunctionalTest"})
    public void verifyLoansTabtest(){

        home.cookiesPrompt.click();

        home.loansTab.click();

        String loanTitle = driver.getTitle();

        System.out.println("loanTitle : "+loanTitle);

       String loanUrl = driver.getCurrentUrl();

       Assert.assertEquals(loanTitle,prop.getProperty("loanTitle"));

        if(loanUrl.contains(prop.getProperty("loanUrl"))){

            assert true;

        }

        else {

            assert false;
        }
    }

    @Test(groups = {"SmokeTest","FunctionalTest"})
    public void verifyCreditCardTabtest(){

        home.cookiesPrompt.click();

        home.creditCardsTab.click();

        String creditCardTitle = driver.getTitle();

        String creditCardUrl = driver.getCurrentUrl();

        System.out.println("creditCardTitle : "+creditCardTitle);
        Assert.assertEquals(creditCardTitle,prop.getProperty("creditCardTitle"));

        if(creditCardUrl.contains(prop.getProperty("creditCardUrl"))){

            assert true;

        }

        else {

            assert false;
        }


    }

    @Test(groups = {"SmokeTest","FunctionalTest"})
    public void verifyCarInsuranceTabtest(){

        home.cookiesPrompt.click();

        home.carInsurance.click();

        String carInsuranceTitle = driver.getTitle();

        String carInsuranceURL = driver.getCurrentUrl();

        System.out.println("carInsuranceTitle : "+carInsuranceTitle);
        Assert.assertEquals(carInsuranceTitle,prop.getProperty("carInsuranceTitle"));

        if(carInsuranceURL.contains(prop.getProperty("carInsuranceURL"))){

            assert true;

        }

        else {

            assert false;
        }

    }

    @AfterMethod(groups = {"SmokeTest","FunctionalTest"},alwaysRun = true)
    public void tearDown(){

        driver.quit();
    }
}
