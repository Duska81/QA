package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TableExample2 {
    public List<List<String>> returnTableDataList() {
        List<List<String>> tableDataList = new ArrayList<>();

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        WebElement sortDataTables = driver.findElement(By.xpath("//a[@href='/tables']"));
        sortDataTables.click();

        WebElement table = driver.findElement(By.id("table2"));

        WebElement tBody = table.findElement(By.xpath(".//tbody"));
        List<WebElement> tRows = tBody.findElements(By.xpath(".//tr"));
        for (int i = 0; i < tRows.size(); i++) {
            List<WebElement> tData = tRows.get(i).findElements(By.xpath(".//td"));

            List<String> tableRowData = new ArrayList<>();

            for (int j = 0; j < tData.size(); j++) {
                System.out.println(tData.get(j).getText());
                tableRowData.add(tData.get(j).getText());
            }

            tableDataList.add(tableRowData);
        }

        driver.quit();

        return tableDataList;// prikupljamo podatke iz tabele i  smestamo ih u nasu listu
        // ovako imamo red koji je lista stringova, a tabela je lista redova
    }

    @Test
    public void readTable() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        WebElement sortDataTables = driver.findElement(By.xpath("//a[@href='/tables']"));
        sortDataTables.click();

        WebElement table = driver.findElement(By.id("table2"));
        //header
        WebElement tHeader = table.findElement(By.xpath(".//thead"));
        WebElement tRowHeader = tHeader.findElement(By.xpath(".//tr"));
        List<WebElement> tHeaderList = tRowHeader.findElements(By.xpath(".//th"));

        List<String> tableHeader = new ArrayList<>();
        for (int i = 0; i < tHeaderList.size(); i++) {
            WebElement span = tHeaderList.get(i).findElement(By.xpath(".//span"));
            String headerValue = span.getText();
            System.out.println(headerValue);
            tableHeader.add(headerValue);
        }
        WebElement tBody = table.findElement(By.xpath("//tbody"));
        List<WebElement> tRows = tBody.findElements(By.xpath(".//tr"));
        for(int i = 0; i < tRows.size(); i++) {
            List<WebElement> tData = tRows.get(i).findElements(By.xpath(".//td"));

            List<String> tableRowData = new ArrayList<>();

            for(int j = 0; j < tData.size(); j++) {
                System.out.println(tData.get(j).getText());
                tableRowData.add(tData.get(j).getText());
            }

                }

        driver.quit();
    }
}

