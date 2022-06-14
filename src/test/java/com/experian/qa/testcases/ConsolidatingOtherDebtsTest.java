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
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class

ConsolidatingOtherDebtsTest extends TestBase {

    ConsolidatingOtherDebts  debts;
    HomePage homePage;

    public ConsolidatingOtherDebtsTest(){
        super();
    }

    @BeforeMethod(groups = {"FunctionalTest"})
    @Parameters({"browser"})
    public void setup(String browser){

        initialization(browser);
        debts = new ConsolidatingOtherDebts();
        homePage= new HomePage();
    }


    @Test(dataProvider = "data-provider-borrowerAmt",groups = {"FunctionalTest"})
    public void invalidBorrowAmountLessThen500Test(String amount) {


            homePage.cookiesPrompt.click();

            homePage.loansTab.click();

            debts.consolidatingOtherDebtsIcon.click();


            debts.borrowAmountInput.sendKeys(amount);

            debts.loanPeriodInput.sendKeys("1");

            debts.continueButton.click();



        try {


            String errorMsg = debts.invalidAmountErrorMsg.getText();



            if (errorMsg.equalsIgnoreCase(prop.getProperty("invalidAmountErrorMsg"))) {



                if (driver.getCurrentUrl().contains("results")) {



                    assert false;
                } else {



                    assert true;
                }


            } else {

                assert false;
            }



        }
        catch(NoSuchElementException e){
            e.printStackTrace();
            System.out.println("inside  assert false from catch  ...");
                assert false;
        }

        }

    @Test(groups = {"FunctionalTest"})
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

                    assert false;
                } else {

                    assert true;
                }

        }
        catch(NoSuchElementException e){
            e.printStackTrace();
            System.out.println("inside  assert false from catch  ...");
            assert false;
        }

    }


    @DataProvider(name = "data-provider-borrowerAmt")
    public Object[][] dataProviderborrowerAmtMethod() {

        return new Object[][] {{"-3"},{"3"},{"3.5"},{"text"} };
    }



    @AfterMethod(groups = {"FunctionalTest"})
        public void tearDown(){

            driver.close();
        }
}
