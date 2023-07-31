package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");//sistemska komanda koja kaze na kojoj lokaciji
        // se nalazi driver
        ChromeDriver driver = new ChromeDriver();//kreiranje objekta klase chromedriver kojem smo dali ime driver
        driver.get("https://www.saucedemo.com/");//otvaranje appp u browseru
        // linija od 8 do 11 ce biti defaultna komanda koja ce biti u svakom testu

        WebElement inputUserName = driver.findElement(By.id("user-name"));
        inputUserName.clear();//metoda kojom brisemo ako je nseto uneto u polje
        inputUserName.sendKeys("standard_user");
        inputUserName.clear();

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("secret_sauce");



        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();
        //moramo da kazemo Seleniumu, da bi znao da li je test prosao ili pao
        //1.nacin
       /* String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("test je prosao");
        } else {
            System.out.println("Test je pao");
        }*/
        //2 nacin

       /* WebElement cart = driver.findElement(By.id("shopping_cart_container"));//preko inspect nadjemo web element
        // koji sada trazimo da li se nalazi na stranici
        if(cart.isDisplayed()) {//na ovaj nacin potvrdjujemo da je gore navedeni element prikazan
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }*/
        //explicitni wait
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));//cekaj max 5 sec dok uslov ne bude ispunjen
        wait.until(ExpectedConditions.numberOfElementsToBe(By.id("shopping_cart_container"),1));//broj elem.sa ovim id bude 1

        List<WebElement> cartList = driver.findElements(By.id("shopping_cart_container"));
        if (cartList.size() == 1) {//web elemenata na stranici gore navedenih treba da ima 1
            System.out.println("test passed");
        } else {
            System.out.println("test failed");


            driver.quit();//zatvaranje app u browseru
        }
    }
}

