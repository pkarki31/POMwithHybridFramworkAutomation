package com.experian.qa.pages;

import com.experian.qa.base.TestBase;
import com.experian.qa.util.TestUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsolidatingOtherDebts extends TestBase {


    @FindBy(xpath = "//*[@id=\"search-form\"]/div[3]/div/div[2]/div/fieldset/div/div[1]/label")
    public WebElement consolidatingOtherDebtsIcon;

    @FindBy(xpath="//input[@name='LoanDetails.Amount']")
    public WebElement borrowAmountInput;

    @FindBy(xpath="//input[@name='LoanDetails.Period']")
    public WebElement loanPeriodInput;

    @FindBy(xpath="//*[@id=\"search-form\"]/div[3]/div/div[3]/button")
    public WebElement continueButton;

    @FindBy(xpath="//*[text()='Tell us your status']")
    public WebElement tellUsStatus;

    @FindBy(xpath="//select[@name='Applicant.EmploymentStatus']")
    public WebElement employmentStatus;

    @FindBy(xpath="//*[text()='Please enter an amount between £500 and £50,000 to the nearest pound']")
    public WebElement invalidAmountErrorMsg;

    @FindBy(xpath="//*[text()='You must own a home secured by a mortgage for the amount you'd like to borrow. Please reduce the amount to £50,000 or less.']")
    public WebElement homeSecuredMortgageErrorMsg;

    @FindBy(xpath="//*[text()='No']")
    public WebElement homeownerWithMortgagefalse;


    public ConsolidatingOtherDebts(){

        PageFactory.initElements(driver,this);
    }



    public String validateTitle(){

        System.out.println("after consolidatingOtherDebtsIcon click  ...");


        return driver.getTitle();
    }

}
