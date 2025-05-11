package com.resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.awt.*;
import java.io.FileInputStream;

import java.util.ArrayList;
import java.util.Properties;
public class OpenBrowser {
    private WebDriver driver;
    public Properties properties;
    public FileInputStream fi;

//    @BeforeSuite
    public ArrayList<Object> openBrowser() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        properties= new Properties();
        fi = new FileInputStream("src/main/java/com/resources/testData.properties");
        properties.load(fi);
        String url = properties.getProperty("url");
        driver.get(url);
        System.out.println("url is: "+url);
        ArrayList<Object> list = new ArrayList<>();
        list.add(driver);
        list.add(properties);
        return list;
    }

    public void closeBrowser(){
        driver.close();
    }
}
