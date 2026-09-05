package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmployeePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By addEmployeeButton = By.xpath("//button[normalize-space()='Add']");
    private final By firstNameField = By.name("firstName");
    private final By lastNameField = By.name("lastName");
    private final By saveButton = By.xpath("//button[@type='submit']");
    private final By personalDetailsHeader = By.xpath("//h6[text()='Personal Details']");

    public EmployeePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Click Add Employee
    public void clickAddEmployee() {
        wait.until(
                        ExpectedConditions.elementToBeClickable(addEmployeeButton))
                .click();
    }

    // Fill employee details
    public void enterEmployeeDetails(String firstName, String lastName) {

        wait.until(
                        ExpectedConditions.visibilityOfElementLocated(firstNameField))
                .sendKeys(firstName);

        driver.findElement(lastNameField).sendKeys(lastName);
    }

    // Save employee
    public void clickSave() {

        wait.until(
                        ExpectedConditions.elementToBeClickable(saveButton))
                .click();
    }

    // Complete workflow
    public void addEmployee(String firstName, String lastName) {

        clickAddEmployee();
        enterEmployeeDetails(firstName, lastName);
        clickSave();

    }

    // Verify employee creation
    public boolean isEmployeeAdded() {

        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(personalDetailsHeader))
                .isDisplayed();

    }
}