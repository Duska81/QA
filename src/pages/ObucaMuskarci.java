package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ObucaMuskarci {
    private WebDriver driver;

    public ObucaMuskarci(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public void sortBy(String sortValue){
        WebElement selectSorting=driver.findElement(By.id("sort"));
        List<WebElement> listOption=selectSorting.findElements(By.xpath(".//option"));
        for(int i=0;i<listOption.size();i++){
            if(listOption.get(i).equals(sortValue)){
                listOption.get(i).click();
                break;

            }
        }


    }
    public List<String>returnAllItems(){
        List<String>listOfProducts=new ArrayList<>();
        WebElement productsListing=driver.findElement(By.className("products-listing"));
        List<WebElement>products=productsListing.findElements(By.xpath(".//[@class='item']"));
        for(int i=0;i<products.size();i++){
           listOfProducts.add(products.get(i).getAttribute("data-productname="));
        }
        return listOfProducts;
    }
    public List<String>returnAllPrices(){
        List<String>listOfPPrices=new ArrayList<>();
        WebElement productsListing=driver.findElement(By.className("products-listing-items"));
        List<WebElement>products=productsListing.findElements(By.xpath(".//div[@class='item']"));
        for(int i=0;i<products.size();i++){
            WebElement currentPrice=products.get(i).findElement(By.xpath(".//div[@class='current-price']"));
            System.out.println(currentPrice.findElement(By.xpath(".//span")).getText());
            listOfPPrices.add(currentPrice.findElement(By.xpath(".//span")).getText());
        }
        return listOfPPrices;
    }
}
