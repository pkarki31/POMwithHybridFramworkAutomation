package com.experian.qa.base;

import com.experian.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver ;
    public static Properties prop ;


    public TestBase(){

        try {

            System.out.println("indside testbase constructor ..");
            prop = new Properties();

            FileInputStream fileInputStream = new FileInputStream("config.properties");

            prop.load(fileInputStream);

            System.out.println("browser : "+prop.getProperty("browser"));

        }

        catch(FileNotFoundException e) {

            e.printStackTrace();

        }

        catch(IOException e){

                e.printStackTrace();
        }

    }

    public static void initialization(){

        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")){

            System.setProperty("webdriver.chrome.driver","Drivers/chromedriver");


            driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.get(prop.getProperty("baseUrl"));

            driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);




        }


    }
}
