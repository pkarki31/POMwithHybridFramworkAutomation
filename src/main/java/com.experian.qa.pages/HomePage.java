package com.experian.qa.pages;

import com.experian.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    public HomePage(){

        PageFactory.initElements(driver,this);
    }

    @FindBy(id="ensCloseBanner")
    private WebElement cookiesPrompt;

    @FindBy(partialLinkText="credit")
    private WebElement creditCardsTab;

    @FindBy(partialLinkText="loans")
    private WebElement loansTab;

    @FindBy(partialLinkText="car-finance")
    private WebElement carFinance;

    @FindBy(partialLinkText="mortgages")
    private WebElement mortgages;

    @FindBy(partialLinkText="insurance")
    private WebElement carInsurance;


    public void clickOnCookiesPrompt(){

        cookiesPrompt.click();

    }

    public void clickOnLoanTab(){
        loansTab.click();
    }

    public void clickOnCarInsurance(){
        carInsurance.click();
    }

    public void clickOnCreditCardsTab(){
        creditCardsTab.click();
    }




}
