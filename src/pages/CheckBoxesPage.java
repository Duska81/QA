package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxesPage {
    private WebDriver driver;

    public CheckBoxesPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    //ova metoda ce da klikne na check box

    public void checkCheckBox(String value) {
        WebElement form = driver.findElement(By.id("checkboxes"));
        if (value.equals("checkbox 1")) {
            form.findElements(By.xpath(".//input")).get(0).click();
        } else if (value.equals("checkbox 2")) {
            form.findElements(By.xpath(".//input")).get(1).click();

        }

    }

    //vraca true ili false da li jeste ili nije
    public boolean isCheckBoxChecked(String value) {
        boolean toReturn = false;
        WebElement form = driver.findElement(By.id("checkboxes"));
        if (value.equals("checkbox 1")) {
            if (form.findElements(By.xpath(".//input")).get(0).getAttribute("checked") != null) {
                toReturn = true;

            } else {
                toReturn = false;

            }
        } else if (value.equals("checkbox 2")) {

                if (form.findElements(By.xpath(".//input")).get(1).getAttribute("checked") != null) {
                    toReturn = true;

                } else {
                    toReturn = false;

                }

            }


        return toReturn;
    }

    }
    /*public boolean isCheckBoxChecked2(String value) {
        WebElement form = driver.findElement(By.id("checkboxes"));
        if (value.equals("checkbox 1")) {
            return form.findElements(By.xpath(".//input")).get(0).isSelected();
        } else if (value.equals("checkbox 2")) {
            return form.findElements(By.xpath(".//input")).get(1).isSelected();
        } else {
            // Handle the case when the provided value doesn't match any checkbox
            throw new IllegalArgumentException("Invalid checkbox label: " + value);
        }
    }
}*/


