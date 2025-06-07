package com.resources;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.awt.*;
import java.io.FileInputStream;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

public class OpenBrowser {
    public static WebDriver driver;
    public static Properties properties;
    public static FileInputStream fi;
    public static WebDriverWait wait;
    @BeforeSuite
    public static ArrayList<Object> openBrowser() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        properties = new Properties();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        fi = new FileInputStream("src/main/java/com/resources/testData.properties");
        properties.load(fi);
        String url = properties.getProperty("url");
        driver.get(url);
        //System.out.println("url is: "+url);
        ArrayList<Object> list = new ArrayList<>();
        list.add(driver);
        list.add(properties);
        return list;
    }
    @AfterSuite
    public static void closeBrowser(){
        driver.close();
    }
}
