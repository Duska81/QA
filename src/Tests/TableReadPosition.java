package Tests;

import models.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TableReadPosition {

    @Test
    public void readRowAtPosition() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        WebElement sortDataTables = driver.findElement(By.xpath("//a[@href='/tables']"));
        sortDataTables.click();
        List<Row> listRows = new ArrayList<>();
        List<List<String>> tableData = new ArrayList<>();
        WebElement table = driver.findElement(By.id("table1"));

        WebElement tBody = table.findElement(By.xpath("//tbody"));
        List<WebElement> tRows = tBody.findElements(By.xpath(".//tr"));
        //citamo npr 3 red

            List<WebElement> tData = tRows.get(3).findElements(By.xpath(".//td"));
            //System.out.println(tData);
            List<String> tableRowData = new ArrayList<>();

            for(int j = 0; j < tData.size(); j++) {
                System.out.println(tData.get(j).getText());
                tableRowData.add(tData.get(j).getText());
            }
    }
}





