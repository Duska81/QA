package pages;

import jdk.dynalink.linker.LinkerServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    public CartPage() {

    }

    public WebDriver getDriver() {
        return driver;

    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    public List<String> itemsInCart(){
        List<String>productNames=new ArrayList<>();
        WebElement cartList=driver.findElement(By.className("cart_list"));
        List<WebElement>cartItems=cartList.findElements(By.className("cart_item"));
        for(int i=0; i<cartItems.size();i++){
            WebElement inventoryItemName=cartItems.get(i).findElement(By.className("inventory_item_name"));
            String name =inventoryItemName.getText();
            productNames.add(name);

        }



        return productNames;
    }
}
