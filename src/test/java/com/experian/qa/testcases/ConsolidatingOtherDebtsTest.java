package com.experian.qa.testcases;

import com.experian.qa.base.TestBase;
import com.experian.qa.pages.ConsolidatingOtherDebts;
import com.experian.qa.pages.HomePage;
import com.experian.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class

ConsolidatingOtherDebtsTest extends TestBase {

    ConsolidatingOtherDebts  debts;
    HomePage homePage;

    public ConsolidatingOtherDebtsTest(){
        super();
    }

    @BeforeMethod
    public void setup(){

        initialization();
        debts = new ConsolidatingOtherDebts();
        homePage= new HomePage();
    }


    @Test(dataProvider = "data-provider-borrowerAmt")
    public void invalidBorrowAmountLessThen500Test(String amount) {

        //  System.out.println("..... "+debts.validateCurrentUrl());


            homePage.cookiesPrompt.click();

            homePage.loansTab.click();

            debts.consolidatingOtherDebtsIcon.click();


            debts.borrowAmountInput.sendKeys(amount);

            debts.loanPeriodInput.sendKeys("1");

            debts.continueButton.click();



        try {
            System.out.println("debts.invalidAmountErrorMsg : " + debts.invalidAmountErrorMsg.isDisplayed());

            String errorMsg = debts.invalidAmountErrorMsg.getText();

            System.out.println("errorMsg : " + errorMsg);

            if (errorMsg.equalsIgnoreCase(prop.getProperty("invalidAmountErrorMsg"))) {

                System.out.println("inside  invalidAmountErrorMsg ...");

                if (driver.getCurrentUrl().contains("results")) {

                    System.out.println("inside  assert false  ...");

                    assert false;
                } else {

                    System.out.println("inside  assert true  ...");

                    assert true;
                }


            } else {

                assert false;
            }

            //  debts.validateCurrentUrl();

        }
        catch(NoSuchElementException e){
            e.printStackTrace();
            System.out.println("inside  assert false from catch  ...");
                assert false;
        }
        }

    @Test
    public void invalidBorrowAmountMoreThen50000Test() {

        homePage.cookiesPrompt.click();

        homePage.loansTab.click();

        debts.consolidatingOtherDebtsIcon.click();

        debts.borrowAmountInput.sendKeys("50001");

        debts.borrowAmountInput.sendKeys(Keys.TAB);

        debts.loanPeriodInput.sendKeys("1");

        debts.continueButton.click();

        debts.homeownerWithMortgagefalse.click();

        try {

                if (driver.getCurrentUrl().contains("results")) {

                    System.out.println("inside  assert false  ...");

                    assert false;
                } else {

                    System.out.println("inside  assert true  ...");

                    assert true;
                }

        }
        catch(NoSuchElementException e){
            e.printStackTrace();
            System.out.println("inside  assert false from catch  ...");
            assert false;
        }
       //   debts.validateCurrentUrl();
    }


    @DataProvider(name = "data-provider-borrowerAmt")
    public Object[][] dataProviderborrowerAmtMethod() {

        return new Object[][] {{"-3"},{"3"},{"3.5"},{"text"} };
    }



        @AfterMethod
        public void tearDown(){

            driver.quit();
        }
}
