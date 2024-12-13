package com.qapitol.testcaes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointtableTestCases {
    @Test
    public void buzz(){
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.cricbuzz.com/cricket-series/8525/womens-big-bash-league-2024/points-table");
        driver.manage().window().maximize();

        List<WebElement> teams = driver.findElements(By.xpath("//table//tr//td[@class='cb-srs-pnts-name']"));

        List<WebElement> points = driver.findElements(By.xpath("//table//tr//td[@class='cb-srs-pnts-td text-bold']"));

        for (int i = 0; i < points.size(); i++) {
            String pointsText = points.get(i).getText();
            int points1 = Integer.parseInt(pointsText);
            if (points1 >= 9) {
                String teamName = teams.get(i).getText();
              System.out.println(teamName +":"+ points1);
            }
        }









    }

}
