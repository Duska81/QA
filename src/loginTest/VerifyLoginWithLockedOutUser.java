package loginTest;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

public class VerifyLoginWithLockedOutUser {
    public static void main(String[] args) {
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
    }
}
