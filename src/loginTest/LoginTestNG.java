package loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.List;

public class LoginTestNG {
    @Test
    public void verifyLoginWithStandradUser(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

            List<WebElement> menu = driver.findElements(By.id("react-burger-menu-btn"));
            if (menu.size() == 1) {
                System.out.println("Nadjen meni na stranici.");
            } else {
                System.out.println("Nije pronađen meni na stranici.");
            }

        driver.quit();
    }


    @Test
    public void verifyLoginWithProblemUser(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("problem_user", "secret_sauce");

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("test je prosao, ulogovali smo se i dobili proizvode sa identicnim slikama");
        } else {
            System.out.println("Test je pao");
        }
            driver.quit();
        }





    @Test
    public void verifyLoginWithPerformanceGlitchUser(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("performance_glitch_user", "secret_sauce");

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("test je prosao, ulogovali smo se, iako sporije, i dobili inventory page");
        } else {
            System.out.println("Test je pao");
        }
            driver.quit();
        }



    @Test
    public void verifyLoginWithLockedOutUser(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");


        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.saucedemo.com/")) {
            System.out.println("test je prosao, ostali smo na login page");
        } else {
            System.out.println("Test je pao, ulogovali smo se");
        }
            driver.quit();
        }
}


