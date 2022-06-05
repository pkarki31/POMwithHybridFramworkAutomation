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
    public WebElement cookiesPrompt;

    @FindBy(partialLinkText="credit")
    public WebElement creditCardsTab;

    @FindBy(partialLinkText="loans")
    public WebElement loansTab;

    @FindBy(partialLinkText="car-finance")
    public WebElement carFinance;

    @FindBy(partialLinkText="mortgages")
    public WebElement mortgages;

    @FindBy(partialLinkText="insurance")
    public WebElement carInsurance;




}
