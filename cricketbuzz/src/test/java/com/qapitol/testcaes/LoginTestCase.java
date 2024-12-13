package com.qapitol.testcaes;


import com.qapitol.baseClass.Excel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class LoginTestCase {

    @Test(dataProvider="datas")
    public void login(String name,String pwd) {
        WebDriver driver = new ChromeDriver();
        driver.get("http://139.59.27.246:3000/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("userNameOrEmail")).sendKeys(name);
        driver.findElement(By.id("password")).sendKeys(pwd);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String actualText = driver.findElement(By.cssSelector(".show")).getText();
        String expected="\"Bad credentials\"";
        Assert.assertEquals(actualText,expected,"expected is matching with actual");

    }


    @DataProvider(name="datas")
    public Object[][] getData() throws IOException {

        Object[][] data = Excel.getData();
        return data;


    }


    }


