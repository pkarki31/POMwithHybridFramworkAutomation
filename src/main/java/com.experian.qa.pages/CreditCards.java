package com.experian.qa.pages;

import com.experian.qa.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class CreditCards extends TestBase    {


    public CreditCards(){

        PageFactory.initElements(driver,this);

        HomePage homePage = new HomePage();

    }




}
