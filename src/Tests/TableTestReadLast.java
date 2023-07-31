package Tests;

import models.Row;
import models.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TableTestReadLast {

    public List<List<String>> returnTableDataList() {
        return null;
    }

    public Table returnTableData() {
        return null;
    }

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

        //header
        //ovo nam je prva lista gde iscitavamo firstname, lastnema, email...
        WebElement tHeader = table.findElement(By.xpath(".//thead"));
        WebElement tRowHeader = tHeader.findElement(By.xpath(".//tr"));
        List<WebElement> tHeaderList = tRowHeader.findElements(By.xpath(".//th"));

        List<String> tableHeader = new ArrayList<>();
        for(int i = 0; i < tHeaderList.size(); i++) {
            WebElement span = tHeaderList.get(i).findElement(By.xpath(".//span"));
            String headerValue = span.getText();
            System.out.println(headerValue);
            tableHeader.add(headerValue);
        }
        Row rowHeader = new Row(tableHeader);
        listRows.add(rowHeader);
        tableData.add(tableHeader);

        WebElement tBody = table.findElement(By.xpath("//tbody"));
        List<WebElement> tRows = tBody.findElements(By.xpath(".//tr"));
        for(int i = 0; i < tRows.size(); i++) {
            List<WebElement> tData = tRows.get(i).findElements(By.xpath(".//td"));
            //System.out.println(tData);
            List<String> tableRowData = new ArrayList<>();

            for(int j = 0; j < tData.size(); j++) {
                System.out.println(tData.get(j).getText());
                tableRowData.add(tData.get(j).getText());
            }
            Row row = new Row(tableRowData);
            listRows.add(row);
            tableData.add(tableRowData);
        }
        //Table tableRows = new Table(listRows);
        Table tableRows=new Table(tableData);
        tableRows.returnRowAtPosition(4);
        // drugi nacin je da citamo red na nekoj poziciji izmenimo red 36 umesto public void readTable() { stavljamo public void readRowAtPosition() {

        tableRows.returnRowAtPosition(tableRows.getRows().size()-1);
        System.out.println("test");
    }

}





