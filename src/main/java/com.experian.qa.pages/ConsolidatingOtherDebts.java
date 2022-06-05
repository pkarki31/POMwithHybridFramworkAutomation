package com.experian.qa.pages;

import com.experian.qa.base.TestBase;
import com.experian.qa.util.TestUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsolidatingOtherDebts extends TestBase {

   // @FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/div[2]/section[2]/div/a[1]")
    @FindBy(xpath = "//*[@id=\"search-form\"]/div[3]/div/div[2]/div/fieldset/div/div[1]/label")
    public WebElement consolidatingOtherDebtsIcon;

//    @FindBy(id="ensCloseBanner")
//    public WebElement cookiesPrompt;

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


    // result url : https://creditmatcher.experian.co.uk/loans/results

    public ConsolidatingOtherDebts(){

        PageFactory.initElements(driver,this);
    }



    public String validateTitle(){

        System.out.println("after consolidatingOtherDebtsIcon click  ...");


        return driver.getTitle();
    }

    public boolean validateCurrentUrl(){

        //        homcookiesPrompt.click();

      //  loansTab.click();

        consolidatingOtherDebtsIcon.click();

        borrowAmountInput.sendKeys("50001");
        borrowAmountInput.sendKeys(Keys.TAB);
        loanPeriodInput.sendKeys("1");

        continueButton.click();

        homeownerWithMortgagefalse.click();



        String text = homeSecuredMortgageErrorMsg.getText();

        System.out.println("homeSecuredMortgageErrorMsg : "+text);

        System.out.println(employmentStatus.isDisplayed());

        System.out.println(employmentStatus.isEnabled());

        String currentUrl = driver.getCurrentUrl();

        System.out.println(" current URL : " +currentUrl);

        if(currentUrl.contains("DebtConsolidation")){

            return  true ;

        }

        return false ;
    }



}
