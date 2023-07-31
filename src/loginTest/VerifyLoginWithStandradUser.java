package loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;

public class VerifyLoginWithStandradUser {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        //ukoliko imamo vise validnih usera, njih stavljamo u lstu
        List<String> standardUser = new ArrayList<>();
        standardUser.add("standard_user");
        //standardUser.add("standard-user");
        //standardUser.add("standard-user");
        //standardUser.add("standard-user");


        LoginPage loginPage = new LoginPage(driver);
        for (int i = 0; i < standardUser.size(); i++) {

            loginPage.login(standardUser.get(i), "secret_sauce");
            if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
                System.out.println("Test je uspešno prošao, korisnik je ulogovan.");
                List<WebElement> menu = driver.findElements(By.id("react-burger-menu-btn"));
                if (menu.size() == 1) {
                    System.out.println("Nadjen meni na stranici.");
                } else {
                    System.out.println("Nije pronađen meni na stranici.");
                }
            } else {
                System.out.println("Test je pao, korisnik nije uspešno ulogovan.");
            }
            driver.quit();
        }
    }
}

