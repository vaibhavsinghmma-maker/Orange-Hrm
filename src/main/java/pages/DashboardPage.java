package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    private final By pimMenu = By.xpath("//span[text()='PIM']");
    private final By profileIcon = By.cssSelector(".oxd-userdropdown-tab");
    private final By logoutButton = By.xpath("//a[text()='Logout']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Verify Dashboard is displayed
    public boolean isDashboardDisplayed() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(dashboardHeader))
                .isDisplayed();
    }

    // Navigate to PIM Module
    public void clickPIM() {
        wait.until(
                        ExpectedConditions.elementToBeClickable(pimMenu))
                .click();
    }

    // Logout
    public void logout() {
        wait.until(
                        ExpectedConditions.elementToBeClickable(profileIcon))
                .click();

        wait.until(
                        ExpectedConditions.elementToBeClickable(logoutButton))
                .click();
    }
}