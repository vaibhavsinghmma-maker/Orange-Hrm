package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.EmployeePage;
import pages.LoginPage;

public class EmployeeTest extends BaseTest {

    @Test
    public void addEmployeeTest() {

        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        EmployeePage employeePage = new EmployeePage(driver);

        // Login
        loginPage.login("Admin", "admin123");

        // Verify Dashboard
        Assert.assertTrue(
                dashboardPage.isDashboardDisplayed(),
                "Dashboard is not displayed after login."
        );

        // Navigate to PIM
        dashboardPage.clickPIM();

        // Add Employee
        employeePage.addEmployee("Mayank", "Singh");

        // Verify Employee Added
        Assert.assertTrue(
                employeePage.isEmployeeAdded(),
                "Employee was not added successfully."
        );
    }
}