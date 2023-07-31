package pages;

import models.Row;
import models.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TablePage {
    private WebDriver driver;

    public TablePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public Table readTable(String tableId) {
        WebElement sortDataTables = driver.findElement(By.xpath("//a[@href='/tables']"));
        sortDataTables.click();
        List<Row> listRows = new ArrayList<>();
        List<List<String>> tableData = new ArrayList<>();
        WebElement table = driver.findElement(By.id(tableId));
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
        Row rowHeader = new Row(tableHeader);
        listRows.add(rowHeader);
        tableData.add(tableHeader);

        WebElement tBody = table.findElement(By.xpath("//tbody"));
        List<WebElement> tRows = tBody.findElements(By.xpath(".//tr"));
        for (int i = 0; i < tRows.size(); i++) {
            List<WebElement> tData = tRows.get(i).findElements(By.xpath(".//td"));

            List<String> tableRowData = new ArrayList<>();

            for (int j = 0; j < tData.size(); j++) {
                System.out.println(tData.get(j).getText());
                tableRowData.add(tData.get(j).getText());
            }
            Row row = new Row(tableRowData);
            listRows.add(row);
            tableData.add(tableRowData);

        }
        Table tableRows = new Table(tableData);
        tableRows.returnRowAtPosition(tableRows.getRows().size() - 1);
        System.out.println("test");

        return tableRows;
    }
}

