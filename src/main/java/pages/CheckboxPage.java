package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxPage {

    private WebDriver driver;

    private By checkbox1 = By.xpath("(//input[@type='checkbox'])[1]");
    private By checkbox2 = By.xpath("(//input[@type='checkbox'])[2]");

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkBox1() {
        if (!driver.findElement(checkbox1).isSelected()) {
            driver.findElement(checkbox1).click();
        }
    }

    public void uncheckBox1() {
        if (driver.findElement(checkbox1).isSelected()) {
            driver.findElement(checkbox1).click();
        }
    }

    public boolean isCheckbox1Selected() {
        return driver.findElement(checkbox1).isSelected();
    }

    public void checkBox2() {
        if (!driver.findElement(checkbox2).isSelected()) {
            driver.findElement(checkbox2).click();
        }
    }

    public boolean isCheckbox2Selected() {
        return driver.findElement(checkbox2).isSelected();
    }
}
