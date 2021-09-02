package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class PimPage {
    public SelenideElement pimButton = $(By.id("menu_pim_viewPimModule"));
    public SelenideElement addEmployeeButton = $(By.id("menu_pim_addEmployee"));
    public SelenideElement employeeFirstNameField = $(By.id("firstName"));
    public SelenideElement employeeLastNameField = $(By.id("lastName"));
    public SelenideElement employeeSaveButton = $(By.id("btnSave"));
    public SelenideElement employeeListEditButton = $(By.id("btnSave"));
    public SelenideElement employeeListSaveButton = $(By.id("btnSave"));
    public SelenideElement employeeListButton = $(By.id("menu_pim_viewEmployeeList"));
    public SelenideElement employeeForm = $(By.id("frmList_ohrmListComponent"));
    public SelenideElement personalDetailsForm = $(By.id("pdMainContainer"));
    public SelenideElement currentAndPastEmployeesButton =
            $(By.xpath("//option[text()='Current and Past Employees']"));
    public String firstName = "Vasili";
    public String lastName = "Terkin";
    public String employeeNameCheckboxLocator =
            "//a[text()='" + lastName  + "']/../..//input[@name=\"chkSelectRow[]\"]";
    public SelenideElement employeeNameCheckbox = $(By.xpath(employeeNameCheckboxLocator));
    public SelenideElement deleteEmployeeButton = $(By.id("btnDelete"));
    public SelenideElement resultTableForm = $(By.id("frmList_ohrmListComponent"));
    public SelenideElement deleteRecordOkButton = $(By.id("dialogDeleteBtn"));


    public void addEmployee(String firstName, String lastName) {

        pimButton.click();
        addEmployeeButton.click();
        employeeFirstNameField.setValue(firstName);
        employeeLastNameField.setValue(lastName);
        employeeSaveButton.click();
        employeeListEditButton.click();
        employeeListSaveButton.click();
        employeeListButton.click();

    }
    public void deleteEmploee(){
        pimButton.click();
        currentAndPastEmployeesButton.click();
        employeeNameCheckbox.click();
        deleteEmployeeButton.click();
        deleteRecordOkButton.click();

    }

}
