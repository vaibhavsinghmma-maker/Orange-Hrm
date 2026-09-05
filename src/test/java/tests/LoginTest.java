package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        loginPage.login("Admin", "admin123");

        Assert.assertTrue(
                dashboardPage.isDashboardDisplayed(),
                "Dashboard is not displayed after login."
        );
    }

    @Test(priority = 2)
    public void invalidLoginTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("Admin", "wrongPassword");

        String expectedMessage = "Invalid credentials";

        String actualMessage = driver.findElement(
                        org.openqa.selenium.By.xpath("//p[contains(@class,'oxd-alert-content-text')]"))
                .getText();

        Assert.assertEquals(actualMessage, expectedMessage);
    }
}