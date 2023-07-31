package selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class AddProduct {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement inputUserName = driver.findElement(By.id("user-name"));
        inputUserName.clear();
        inputUserName.sendKeys("standard_user");
        inputUserName.clear();

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

        AddProduct addProduct = new AddProduct();

        //treba da utvrdimo kakvo je stanje u korpi pre dodavanja
        //broj u korpi pre dodavanja
        Integer itemNumberBeforeAdd= addProduct.returnItemNumber(driver);
        //posto je korpa prazna, test je pao. Ovo funkcionise samo ako ima nesto u korpi, posto kad nema nista taj span nestane
        //u ovakvim slucajevima se drzimo elementa koji je uvek prisutan


        addProduct.addProductToCartByName(driver, "Sauce Labs Onesie");
        //broj u korpi nakon dodavanja
        Integer itemNumberAfterAdd = addProduct.returnItemNumber(driver);
        //validiramo da li je test prosao ili pao

        if (itemNumberAfterAdd == itemNumberBeforeAdd + 1) {
            System.out.println("test je prosao");
        } else {
            System.out.println("test je pao, broj u korpi nije onaj koji ocekujemo");
        }


        driver.quit(); //zakomentarisala sam da mi se ne bi automatski zatvorila stranica u chromu
    }

    public void addProductToCartByName(ChromeDriver driver, String productName) {
        WebElement inventoryList = driver.findElement(By.className("inventory_list"));
        List<WebElement> inventoryItems = inventoryList.findElements(By.className("inventory_item"));
        for (int i = 0; i < inventoryItems.size(); i++) {
            WebElement inventoryItemName = inventoryItems.get(i).findElement(By.className("inventory_item_name"));
            if (inventoryItemName.getText().equals(productName)) {
                WebElement addToCartButton = inventoryItems.get(i).findElement(By.xpath(".//button"));
                addToCartButton.click();
                break;
            }
        }
    }
    //ovo metoda funkcionise kad ima nesto u korpi

    /*public Integer returnItemNumber(ChromeDriver driver) {
        WebElement spanItemNumber = driver.findElement(By.className("shopping_cart_badge"));
        String itemNumber = spanItemNumber.getText();

        return Integer.parseInt(itemNumber);*/

        //drzimo se stalno prisutnog elementa kad nemamo nista u korpi
        public Integer returnItemNumber(ChromeDriver driver) {
            Integer toReturn = null;
        WebElement linkShoppingCart = driver.findElement(By.className("shopping_cart_link"));
        List<WebElement>spanItemNumber=linkShoppingCart.findElements(By.className("shopping_cart_badge"));
        if(spanItemNumber.size()==0){
            toReturn=0;

        }else{
           toReturn=Integer.parseInt(spanItemNumber.get(0).getText());

        }
        return toReturn;

    }
}
