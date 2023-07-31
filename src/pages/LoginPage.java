package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


    public void login(String username, String password){

        WebElement inputUserName = driver.findElement(By.id("user-name"));
        inputUserName.clear();
        inputUserName.sendKeys(username);
        inputUserName.clear();

        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys(password);

        WebElement buttonLogin = driver.findElement(By.id("login-button"));
        buttonLogin.click();

    }

//posto je metoda public mozemo je bilo gde pozivati sa gore navedena 2 argumenta

    //dole je ukoliko imamo listu usera
    //public void login(List<String> username, String password) {
       // for(int i=0;i<username.size();i++){
           /* WebElement inputUserName = driver.findElement(By.xpath("//input[@id='user-name']"));
            inputUserName.clear();
            inputUserName.sendKeys(username.get(i));
            inputUserName.clear();

            WebElement inputPassword = driver.findElement(By.id("password"));
            inputPassword.sendKeys("secret_sauce");

            WebElement buttonLogin = driver.findElement(By.id("login-button"));
            buttonLogin.click();*/

        }




