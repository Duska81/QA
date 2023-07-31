package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxesPage;

import java.time.Duration;

public class CheckBox {

    @Test
    public void verifyCheckBoxSecondStatus() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        WebElement checkBoxesItem = driver.findElement(By.xpath("//a[@href='/checkboxes']"));
        checkBoxesItem.click();
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        //checkBoxesPage.checkCheckBox("checkbox 2");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        Assert.assertEquals(checkBoxesPage.isCheckBoxChecked("checkbox 2"), true, "checkbox2 is not checked");


        driver.quit();

    }

    @Test
    public void verifyCheckBoxFirstStatus() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        WebElement checkBoxesItem = driver.findElement(By.xpath("//a[@href='/checkboxes']"));
        checkBoxesItem.click();
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        //checkBoxesPage.checkCheckBox("checkbox 1");
        Assert.assertEquals(checkBoxesPage.isCheckBoxChecked("checkbox 1"), false, "checkbox1 is  checked");


        driver.quit();

    }

    @Test
    public void verifyFirstCheckBoxChecked() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/");

        WebElement checkBoxesItem = driver.findElement(By.xpath("//a[@href='/checkboxes']"));
        checkBoxesItem.click();
        CheckBoxesPage checkBoxesPage = new CheckBoxesPage(driver);
        checkBoxesPage.checkCheckBox("checkbox 1");
        Assert.assertEquals(checkBoxesPage.isCheckBoxChecked("checkbox 1"), true, "checkbox1 is not checked");


        driver.quit();

    }
}


