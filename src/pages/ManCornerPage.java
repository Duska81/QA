package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ManCornerPage {
    private WebDriver driver;

    public ManCornerPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public void openObuca(){
        List<WebElement> obuca = driver.findElements(By.xpath(".//a[@title='OBUĆA']"));
        obuca.get(2).click();



    }
    public void openOdeca(){

    }
    public void openOprema(){

    }
}
