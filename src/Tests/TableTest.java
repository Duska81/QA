package Tests;

import models.Row;
import models.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TablePage;

import java.util.ArrayList;
import java.util.List;

public class TableTest {
    @Test
    public void readTable(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");
        //posto smo deo koda prebacili ua tablePage ovde kreiramo tabblePage, pageObject model

        TablePage tablePage=new TablePage(driver);
        tablePage.readTable("table1");

        WebElement sortDataTables = driver.findElement(By.xpath("//a[@href='/tables']"));
        sortDataTables.click();
        List<Row> listRows = new ArrayList<>();
        List<List<String>> tableData = new ArrayList<>();
        WebElement table = driver.findElement(By.id("table1"));
        //header
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
        //Row rowHeader = new Row(tableHeader);
        //listRows.add(rowHeader);
       // tableData.add(tableHeader);

        WebElement tBody = table.findElement(By.xpath("//tbody"));
        List<WebElement> tRows = tBody.findElements(By.xpath(".//tr"));
        for(int i = 0; i < tRows.size(); i++) {
            List<WebElement> tData = tRows.get(i).findElements(By.xpath(".//td"));

            List<String> tableRowData = new ArrayList<>();

            for(int j = 0; j < tData.size(); j++) {
                System.out.println(tData.get(j).getText());
                tableRowData.add(tData.get(j).getText());
            }
            //Row row = new Row(tableRowData);
           // listRows.add(row);
           // tableData.add(tableRowData);
        }
        //Table tableRows = new Table(listRows);
       // System.out.println("test");
    }
    //na 2 nacina mozemo iscitati tabelu, ili je samo iscitati ili kreirati nasu strukturu tj.tabelu koja se sastooji
    //od liste redova, a red je lista stringova i u tom slucau kreiramo klasu row i klasu table i ubacimo redove 19, 20,34,35,36,49,50,51,53,54

//dodajemo red u tabelu
    @Test
    public void verifyAddTableItem(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        WebElement sortDataTables = driver.findElement(By.xpath("//a[@href='/tables']"));
        sortDataTables.click();

        TablePage tablePage=new TablePage(driver);
        Table table1=tablePage.readTable("table1");
        List<String>lastRow=table1.returnRowAtPosition(table1.getRows().size()-1);

        SoftAssert softAssert=new SoftAssert();
        for (int i=0;i<lastRow.size();i++){
            softAssert.assertEquals(lastRow.get(0),"Conway");
            softAssert.assertEquals(lastRow.get(1),"Tim");

        }
        softAssert.assertAll();

        driver.quit();

    }
}




