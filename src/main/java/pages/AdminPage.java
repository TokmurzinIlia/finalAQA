package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AdminPage {
    public SelenideElement lableIcon = $("img[src=\"/webres_6051af48107ce6.31500353/themes/default/images/logo.png\"]");
    public SelenideElement adminButton = $(By.id("menu_admin_viewAdminModule"));
    public SelenideElement addButton = $(By.id("btnAdd"));
    public SelenideElement deleteButton = $(By.id("btnDelete"));
    public SelenideElement addUserForm = $(By.id("systemUser"));
    public SelenideElement userRoleField = $(By.id("systemUser_userType"));
    public SelenideElement employeeNameField = $(By.id("systemUser_employeeName_empName"));
    public SelenideElement userNameField = $(By.id("systemUser_userName"));
    public SelenideElement statusField = $(By.id("systemUser_status"));
    public SelenideElement passwordField = $(By.id("systemUser_password"));
    public SelenideElement confirmPasswordField = $(By.id("systemUser_confirmPassword"));
    public SelenideElement saveButton = $(By.id("btnSave"));
    public SelenideElement resultTableForm = $(By.id("resultTable"));
    public String userName = "Vasili Peterkin";
    public String userNameMarkerLocator = "//a[text()='" + userName + "']/../..//input[@name=\"chkSelectRow[]\"]";
    public SelenideElement userSearchField = $(By.id("searchSystemUser_userName"));
    public SelenideElement userSearchButton = $(By.id("searchBtn"));

    public SelenideElement userNameMarker = $(By.xpath(userNameMarkerLocator));
    public SelenideElement deleteRecordOkButton = $(By.id("dialogDeleteBtn"));
    public SelenideElement jobButton = $(By.id("menu_admin_Job"));
    public SelenideElement jobTitleButton = $(By.id("menu_admin_viewJobTitleList"));
    public SelenideElement jobTitleJobTitleField = $(By.id("jobTitle_jobTitle"));
    public SelenideElement jobTitleJobDescriptionField = $(By.id("jobTitle_jobDescription"));
    public SelenideElement jobTitleJobNoteField = $(By.id("jobTitle_note"));
    public SelenideElement jobTitleForm = $(By.id("frmList_ohrmListComponent"));

    public String jobTitle1 = "Electrician";
    public String jobTitle2 = "Locksmith-repairman";
    public String jobTitle3 = "Cook";
    public String jobDescription1 = "On the territory of the employer. Social package";
    public String jobDescription2 = "Social package" +
            "Work of the Republic of Belarus" +
            "Schedule according to the TC of the Republic of Belarus" +
            "Official employment" +
            "Timely, without delay, salary of 1000 rubles." +
            "schedule from 8 to 16: 30" +
            "a five-day working week (weekend-Saturday, Sunday).";
    public String jobDescription3 = "Full-time, full-time" +

            "Required work experience: With experience" +

            "Full employment." +
            "The production company LLC \"Yulidi\", in connection with " +
            "the expansion of production, invites cooks of the hot shop to " +
            "work permanently for the production of pies." +

            "Responsibilities:" +

            "production of pies. We make the best pies in Grodno!" +
            " (on night shifts)";
    public String jobNote1 = "Availability of education. Work experience." +
            " Without bad habits. Category 4";
    public String jobNote2 = "discipline," +
            "easy learning, responsibility,";
    public String jobNote3 = "specialized education; (Or the desire to learn " +
            "cooking at the expense of the employer)" +
            "the presence of a valid sanitary certificate" +
            " (or the willingness to do it); (Subject to employment-the" +
            " costs of the sanitary book are compensated in full)" +
            "work experience is welcome, but we can train you and assign " +
            "a qualification" +
            "production of pies. We make the best pies " +
            "in Grodno! (on night shifts)";

    public String jobTitleCheckboxLocator1 = "//a[text()='" + jobTitle1 +
            "']/../..//input[@name=\"chkSelectRow[]\"]";
    public SelenideElement jobTitleCheckbox1 = $(By.xpath(jobTitleCheckboxLocator1));

    public String jobTitleCheckboxLocator2 = "//a[text()='" + jobTitle2 +
            "']/../..//input[@name=\"chkSelectRow[]\"]";

    public SelenideElement jobTitleCheckbox2 = $(By.xpath(jobTitleCheckboxLocator2));

    public String jobTitleCheckboxLocator3 = "//a[text()='" + jobTitle3 +
            "']/../..//input[@name=\"chkSelectRow[]\"]";
    public SelenideElement jobTitleCheckbox3 = $(By.xpath(jobTitleCheckboxLocator3));

    public void addUserMenu() {

        adminButton.click();
        addButton.click();
    }

    public void addUserFormValidation(){
        addUserForm.shouldBe(text("User Role *"))
                   .shouldBe(text("Employee Name *"))
                   .shouldBe(text("Username *"))
                   .shouldBe(text("Status *"))
                   .shouldBe(text("Password *"))
                   .shouldBe(text("Confirm Password *"));
        userRoleField.shouldBe(visible);
        employeeNameField.shouldBe(visible);
        userNameField.shouldBe(visible);
        statusField.shouldBe(visible);
        passwordField.shouldBe(visible);
        confirmPasswordField.shouldBe(visible);
    }
    public void addUser(String employeeName, String userName,
                        String password, String  confirmPassword){
        employeeNameField.setValue(employeeName);
        userNameField.setValue(userName);
        passwordField.setValue(password);
        confirmPasswordField.setValue(confirmPassword);
        saveButton.click();
        userSearchField.setValue(userName);
        userSearchButton.click();
    }

    public void deleteUser(){
        userSearchField.setValue(userName);
        userSearchButton.click();
        userNameMarker.click();
        deleteButton.click();
        deleteRecordOkButton.click();
        userSearchField.setValue(userName);
        userSearchButton.click();

    }

    public void adminPageTitle() {

        adminButton.click();
    }

    public void jobTitleData(String jobTitle, String jobDescription, String jobNote){
        jobTitleJobTitleField.setValue(jobTitle);
        jobTitleJobDescriptionField.setValue(jobDescription);
        jobTitleJobNoteField.setValue(jobNote);
    }

    public void pathJobTitles(){
        jobButton.click();
        jobTitleButton.click();

    }

    public void addButton(){
        addButton.click();
    }

    public void saveButton(){
        saveButton.click();
    }

    public void deleteJobTitle(String jobTitle){
        String jobTitleCheckboxLocator = "//a[text()='" + jobTitle +
                "']/../..//input[@name=\"chkSelectRow[]\"]";
        SelenideElement jobTitleCheckbox = $(By.xpath(jobTitleCheckboxLocator));
        jobTitleCheckbox.click();
        deleteButton.click();
        deleteRecordOkButton.click();


    }
}
