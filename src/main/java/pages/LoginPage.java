package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private By username = By.name("username");
    private By password = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterUsername(String user) {
        WebElement userField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(username));
        userField.clear();
        userField.sendKeys(user);
    }

    public void enterPassword(String pass) {
        WebElement passField = driver.findElement(password);
        passField.clear();
        passField.sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

}