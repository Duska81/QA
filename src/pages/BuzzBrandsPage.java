package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BuzzBrandsPage {
    private WebDriver driver;

    public BuzzBrandsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    //ima argument zato sto biramo brend na koji treba da kliknemo
    public void selectBrand(String brand){

    }

    public List<String> returnAllBrands() {
        List<String> brends = new ArrayList<>();
        List<WebElement> container = driver.findElements(By.className("container"));
        List<WebElement> linkBrands = container.get(8).findElements(By.xpath(".//a"));

        for (int i = 0; i < linkBrands.size(); i++) {

            System.out.println(linkBrands.get(i).getAttribute("title"));
            brends.add(linkBrands.get(i).getAttribute("title"));
        }


        return brends;
    }

    }

