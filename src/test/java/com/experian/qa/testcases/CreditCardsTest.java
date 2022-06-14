package com.experian.qa.testcases;

import com.experian.qa.base.TestBase;
import com.experian.qa.pages.CreditCards;
import com.experian.qa.pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreditCardsTest extends TestBase {

    CreditCards creditCards;

    public CreditCardsTest(){
        super();
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser){

        initialization(browser);
        creditCards = new CreditCards();
    }


}
