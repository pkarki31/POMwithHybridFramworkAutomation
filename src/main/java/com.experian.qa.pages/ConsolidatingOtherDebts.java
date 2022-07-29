package com.experian.qa.pages;

import com.experian.qa.base.TestBase;
import com.experian.qa.util.TestUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsolidatingOtherDebts extends TestBase {


    @FindBy(xpath = "//*[@id=\"search-form\"]/div[3]/div/div[2]/div/fieldset/div/div[1]/label")
    private WebElement consolidatingOtherDebtsIcon;

    @FindBy(xpath="//input[@name='LoanDetails.Amount']")
    private WebElement borrowAmountInput;

    @FindBy(xpath="//input[@name='LoanDetails.Period']")
    private WebElement loanPeriodInput;

    @FindBy(xpath="//*[@id=\"search-form\"]/div[3]/div/div[3]/button")
    private WebElement continueButton;

    @FindBy(xpath="//*[text()='Tell us your status']")
    private WebElement tellUsStatus;

    @FindBy(xpath="//select[@name='Applicant.EmploymentStatus']")
    private WebElement employmentStatus;

    @FindBy(xpath="//*[text()='Please enter an amount between £500 and £50,000 to the nearest pound']")
    private WebElement invalidAmountErrorMsg;

    @FindBy(xpath="//*[text()='You must own a home secured by a mortgage for the amount you'd like to borrow. Please reduce the amount to £50,000 or less.']")
    private WebElement homeSecuredMortgageErrorMsg;

    @FindBy(xpath="//*[text()='No']")
    private WebElement homeownerWithMortgagefalse;


    public ConsolidatingOtherDebts(){

        PageFactory.initElements(driver,this);
    }

    public void clickOnConsolidatingOtherDebtsIcon(){
        consolidatingOtherDebtsIcon.click();
    }

    public void sendBorrowAmountInput(String amount){
        borrowAmountInput.sendKeys(amount);
    }

    public void sendLoanPeriodInput(String period){
        loanPeriodInput.sendKeys(period);
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    public String getTextForInvalidAmountErrorMsg(){
       return  invalidAmountErrorMsg.getText();
    }

    public void clickOnHomeownerWithMortgageFalse(){
        homeownerWithMortgagefalse.click();
    }



    public String validateTitle(){

        System.out.println("after consolidatingOtherDebtsIcon click  ...");


        return driver.getTitle();
    }

}
