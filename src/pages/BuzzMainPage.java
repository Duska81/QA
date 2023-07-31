package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuzzMainPage {
    private WebDriver driver;

    public BuzzMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    //popisati sve metode koje vidimo na stranici
    public void openMans(){

    }
    public void openWomans(){
        WebElement linkZene=driver.findElement(By.xpath("//a[@title='Žene']"));
        linkZene.click();

    }
    public void openChild(){
        WebElement linkChild=driver.findElement(By.xpath("//a[@title='Deca']"));
        linkChild.click();

    }
    public void openBrands(){
        //ako je prefiks a stavimo prefiks link
        // ako je fild, i button isto
        WebElement linkBrendovi=driver.findElement(By.xpath("//a[@title='Brendovi']"));
        linkBrendovi.click();

    }
}
