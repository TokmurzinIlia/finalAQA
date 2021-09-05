package pages;



import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
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
    public SelenideElement includeButton = $(By.id("empsearch_termination"));
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
    public SelenideElement employeeSearchField = $(By.id("empsearch_employee_name_empName"));
    public SelenideElement employeeSearchButton = $(By.id("searchBtn"));
    public SelenideElement employeeListSubUnitButton = $(By.id("empsearch_sub_unit"));
    public SelenideElement employeeListSubUnitSalesButton
            = $(By.xpath("//select[@id=\"empsearch_sub_unit\"]//option[@value=\"8\"]"));
    public SelenideElement employeeListSubUnitSalesNathanSales
            = $(By.xpath("//a[(text()='Nathan')]"));
    public SelenideElement personalDetailsSalesForm = $(By.id("employee-details"));
    public SelenideElement personalDetailsSalesFormFirstNameField = $(By.id("personal_txtEmpFirstName"));
    public SelenideElement personalDetailsSalesFormMiddleNameField = $(By.id("personal_txtEmpMiddleName"));
    public SelenideElement personalDetailsSalesFormLastNameField = $(By.id("personal_txtEmpLastName"));
    public SelenideElement personalDetailsSalesFormEmployeeIdField = $(By.id("personal_txtEmployeeId"));
    public SelenideElement personalDetailsSalesFormOtherIdField = $(By.id("personal_txtOtherID"));
    public SelenideElement personalDetailsSalesFormDriversLicenseNumberField = $(By.id("personal_txtLicenNo"));
    public SelenideElement personalDetailsSalesFormLicenseExpiryDateField = $(By.id("personal_txtLicExpDate"));
    public SelenideElement personalDetailsSalesFormSSNNumberField = $(By.id("personal_txtNICNo"));
    public SelenideElement personalDetailsSalesFormSINNumberField = $(By.id("personal_txtSINNo"));
    public SelenideElement personalDetailsSalesFormMaleCheckBox = $(By.xpath("//input[@name=\"personal[optGender]\"][@value=\"1\"]"));
    public SelenideElement personalDetailsSalesFormFemaleCheckBox = $(By.xpath("//input[@name=\"personal[optGender]\"][@value=\"2\"]"));
    public SelenideElement personalDetailsSalesFormMaritalStatusField = $(By.id("personal_cmbMarital"));
    public SelenideElement personalDetailsSalesFormNationalityField = $(By.id("personal_cmbNation"));
    public SelenideElement personalDetailsSalesFormDateOfBirthField = $(By.id("personal_DOB"));
    public SelenideElement personalDetailsSalesFormNickNameField = $(By.id("personal_txtEmpNickName"));
    public SelenideElement personalDetailsSalesSmokerField = $(By.id("personal_chkSmokeFlag"));
    public SelenideElement personalDetailsSalesMilitaryServiceField = $(By.id("personal_txtMilitarySer"));


    @Step("Adding employee")
    public void addEmployee(String firstName, String lastName) {

        pimButton.click();
        addEmployeeButton.click();
        employeeFirstNameField.setValue(firstName);
        employeeLastNameField.setValue(lastName);
        employeeSaveButton.click();
        employeeListEditButton.click();
        employeeListSaveButton.click();
        employeeListButton.click();
        currentAndPastEmployeesButton.click();
        employeeSearchField.setValue(firstName + " " + lastName);
        employeeSearchButton.click();



    }


    @Step("Deleting a employee")
    public void deleteEmploee(String firstName, String lastName){
        pimButton.click();
        currentAndPastEmployeesButton.click();
        employeeSearchField.setValue(firstName + " " + lastName);
        employeeSearchButton.click();
        employeeNameCheckbox.click();
        deleteEmployeeButton.click();
        deleteRecordOkButton.click();
        employeeSearchButton.click();

    }


    @Step("Sales form validation")
    public  void emploeeInformationSalesFormDetail(){
        pimButton.click();
        employeeListButton.click();
        employeeListSubUnitButton.click();
        employeeListSubUnitSalesButton.click();
        employeeSearchButton.click();
        employeeListSubUnitSalesNathanSales.click();
        personalDetailsSalesForm.shouldBe(text("Personal Details"), text("Full Name"), text("* First Name"), text("Middle Name"),
                text("* Last Name"), text("Employee Id"), text("Other Id"), text("Driver's License Number"), text("License Expiry Date"),
                text("SSN Number"), text("SIN Number"), text("Gender"), text("Male"), text("Female"), text("Marital Status"),
                text("Date of Birth"), text("Nick Name"), text("Smoker"), text("* Required field"), text("Custom Fields"), text("Blood Type"),
                text("Attachments"));
        personalDetailsSalesFormFirstNameField.shouldBe(visible);
        personalDetailsSalesFormMiddleNameField.shouldBe(visible);
        personalDetailsSalesFormLastNameField.shouldBe(visible);
        personalDetailsSalesFormOtherIdField.shouldBe(visible);
        personalDetailsSalesFormDriversLicenseNumberField.shouldBe(visible);
        personalDetailsSalesFormLicenseExpiryDateField.shouldBe(visible);
        personalDetailsSalesFormSSNNumberField.shouldBe(visible);
        personalDetailsSalesFormSINNumberField.shouldBe(visible);
        personalDetailsSalesFormMaleCheckBox.shouldBe(visible);
        personalDetailsSalesFormFemaleCheckBox.shouldBe(visible);
        personalDetailsSalesFormMaritalStatusField.shouldBe(visible);
        personalDetailsSalesFormNationalityField.shouldBe(visible);
        personalDetailsSalesFormDateOfBirthField.shouldBe(visible);
        personalDetailsSalesFormNickNameField.shouldBe(visible);
        personalDetailsSalesSmokerField.shouldBe(visible);
        personalDetailsSalesMilitaryServiceField.shouldBe(visible);
    }

}
