package com.experian.qa.base;

import com.experian.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

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


        }

        catch(FileNotFoundException e) {

            e.printStackTrace();

        }

        catch(IOException e){

                e.printStackTrace();
        }

    }

    public static void initialization(String browser){

         browser = System.getProperty("browser", "chrome");


        if(browser.equalsIgnoreCase("chrome")){

            System.setProperty("webdriver.chrome.driver","Drivers/chromedriver");


            driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.get(prop.getProperty("baseUrl"));

            driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        }

        else if (browser.equalsIgnoreCase("firefox")){

            System.setProperty("webdriver.gecko.driver","Drivers/geckodriver");

            driver = new FirefoxDriver();

            driver.manage().window().maximize();

            driver.get(prop.getProperty("baseUrl"));

            driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        }



    }
}
