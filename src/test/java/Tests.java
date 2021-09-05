
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import pages.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests {

    @BeforeAll
    public void setup() {

        Configuration.startMaximized = true;

    }


    @AfterEach

    public void tearDown(){
        LoginPage loginPage = new LoginPage();
        String pageCurrentUrl = url();
        if (pageCurrentUrl.equals("https://opensource-demo.orangehrmlive.com/index.php/auth/login")){

        } else {
            loginPage.logOut();
        }
    }


    @Severity(SeverityLevel.BLOCKER)
    @Description("Login test")
    @Feature("Login")
    @DisplayName("Login test")
    @Test
    @Order(1)

public void loginTest() {
        LoginPage loginPage = new LoginPage();
        AdminPage adminPage = new AdminPage();
        loginPage.logIn();
        adminPage.lableIcon.shouldBe(visible);



    }
    @Severity(SeverityLevel.NORMAL)
    @Description("User add form validation")
    @Feature("User add form validation")
    @DisplayName("User add form validation")
    @Test
    @Order(3)

    public void addUserFormValidation () {
        AdminPage adminPage = new AdminPage();
        LoginPage loginPage = new LoginPage();
        loginPage.logIn();
        adminPage.pathAddUserMenu();
        adminPage.addUserFormValidation();

    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Adding user")
    @Feature("Adding user")
    @DisplayName("Adding user")
    @Test
    @Order(4)

    public void addUser () {
        AdminPage adminPage = new AdminPage();
        PimPage pimPage = new PimPage();
        LoginPage loginPage = new LoginPage();
        loginPage.logIn();
        adminPage.pathAddUserMenu();
        adminPage.addUser(pimPage.firstName + " " + pimPage.lastName,
                adminPage.userName,"12345678","12345678");
        adminPage.resultTableForm
                .shouldBe(text(pimPage.firstName + " " + pimPage.lastName));

    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Adding employee")
    @Feature("Adding employee")
    @DisplayName("Adding employee")
    @Test
    @Order(2)

    public void addEmployee(){

        LoginPage loginPage = new LoginPage();
        PimPage pimPage = new PimPage();
        loginPage.logIn();
        pimPage.addEmployee(pimPage.firstName, pimPage.lastName);
        String employeeFullName = pimPage.firstName + " " + pimPage.lastName;
        pimPage.employeeForm.shouldBe(text(employeeFullName));

    }



    @Severity(SeverityLevel.NORMAL)
    @Description("Deleting a user")
    @Feature("Deleting a user")
    @DisplayName("Deleting a user")
    @Test
    @Order(5)
    public void deleteUser(){
        AdminPage adminPage = new AdminPage();
        LoginPage loginPage = new LoginPage();
        loginPage.logIn();
        adminPage.adminPageTitle();
        adminPage.deleteUser();
        adminPage.resultTableForm.shouldNotBe(text(adminPage.userName));

        }


    @Severity(SeverityLevel.NORMAL)
    @Description("Deleting a employee")
    @Feature("Deleting a employee")
    @DisplayName("Deleting a employee")
    @Test
    @Order(6)
    public void deleteEmployee(){
        LoginPage loginPage = new LoginPage();
        PimPage pimPage = new PimPage();
        loginPage.logIn();
        pimPage.deleteEmploee(pimPage.firstName, pimPage.lastName);
        pimPage.resultTableForm.shouldNotBe(text(pimPage.lastName));

    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("Adding a candidate")
    @Feature("Adding a candidate")
    @DisplayName("Adding a candidate")
    @Test
    @Order(7)
    public void addCandidate(){
        LoginPage loginPage = new LoginPage();
        RecruitmentPage recruitmentPage = new RecruitmentPage();
        loginPage.logIn();
        recruitmentPage.addCandidate();

        recruitmentPage.candidateForm.shouldBe
                (text(recruitmentPage.firstName + " "
                        + recruitmentPage.lastName));

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Removing a candidate")
    @Feature("Removing a candidate")
    @DisplayName("Removing a candidate")

    @Test
    @Order(8)
    public void deleteCandidate(){
        LoginPage loginPage = new LoginPage();
        RecruitmentPage recruitmentPage = new RecruitmentPage();
        loginPage.logIn();
        recruitmentPage.deleteCandidate();

        recruitmentPage.candidateForm.shouldNotBe
                (text(recruitmentPage.firstName + "  "
                        + recruitmentPage.lastName));

    }


    @Severity(SeverityLevel.CRITICAL)
    @Description("Adding Job Title")
    @Feature("Adding Job Title")
    @DisplayName("Adding Job Title")
    @Test
    @Order(9)
    public void addJobTitle(){
        LoginPage loginPage = new LoginPage();
        AdminPage adminPage = new AdminPage();
        loginPage.logIn();
        adminPage.adminPageTitle();
        adminPage.pathJobTitles();
        adminPage.addButton();
        adminPage.jobTitleData(adminPage.jobTitle1,adminPage.jobDescription1, adminPage.jobNote1);
        adminPage.saveButton();
        adminPage.addButton();
        adminPage.jobTitleData(adminPage.jobTitle2,adminPage.jobDescription2, adminPage.jobNote2);
        adminPage.saveButton();
        adminPage.addButton();
        adminPage.jobTitleData(adminPage.jobTitle3,adminPage.jobDescription3, adminPage.jobNote3);
        adminPage.saveButton();
        adminPage.jobTitleForm.shouldBe(text(adminPage.jobTitle1),
                text(adminPage.jobTitle2), text(adminPage.jobTitle3));

    }


    @Severity(SeverityLevel.NORMAL)
    @Description("Delete Job Title")
    @Feature("Delete Job Title")
    @DisplayName("Delete Job Title")
    @Test
    @Order(10)
    public void deleteJobTitle(){
        LoginPage loginPage = new LoginPage();
        AdminPage adminPage = new AdminPage();
        loginPage.logIn();
        adminPage.adminPageTitle();
        adminPage.pathJobTitles();
        adminPage.deleteJobTitle(adminPage.jobTitle1);
        adminPage.deleteJobTitle(adminPage.jobTitle2);
        adminPage.deleteJobTitle(adminPage.jobTitle3);
        adminPage.jobTitleForm.shouldNotBe(text(adminPage.jobTitle1),
                text(adminPage.jobTitle2), text(adminPage.jobTitle3));

}


    @Severity(SeverityLevel.NORMAL)
    @Description("Form validation assign vacation")
    @Feature("Form validation assign vacation")
    @DisplayName("Form validation assign vacation")
    @Test
    @Order(11)
    public void addAssingLeaveFormValidation(){
        LoginPage loginPage = new LoginPage();
        LeavePage leavePage = new LeavePage();
        loginPage.logIn();
        leavePage.pathAssingLeave();
        leavePage.addAssingLeaveFormValidation();

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Assing Leave")
    @Feature("Assing Leave")
    @DisplayName("Assing Leave")
    @Test
    @Flaky
    @Order(12)
    public void addAssingLeave(){
        LoginPage loginPage = new LoginPage();
        LeavePage leavePage = new LeavePage();
        PimPage pimPage = new PimPage();
        loginPage.logIn();
        pimPage.addEmployee(pimPage.firstName, pimPage.lastName);
        String employeeFullName = pimPage.firstName + " " + pimPage.lastName;
        pimPage.employeeForm.shouldBe(text(employeeFullName));

        leavePage.pathAssingLeave();
        leavePage.addAssingLeave(employeeFullName);
        leavePage.leaveListSearchForm.shouldBe(text(employeeFullName));
        pimPage.deleteEmploee(pimPage.firstName, pimPage.lastName);
        pimPage.resultTableForm.shouldNotBe(text(pimPage.lastName));

    }

    @Severity(SeverityLevel.MINOR)
    @Description("Dashboard Page Presence Element")
    @Feature("Dashboard Page Presence Element")
    @DisplayName("Dashboard Page Presence Element")
    @Test

    @Order(13)
    public void dashBoardPagePresenceElement(){
        LoginPage loginPage = new LoginPage();
        DashBoardPage dashBoardPage = new DashBoardPage();
        loginPage.logIn();
        dashBoardPage.dashBoardPagePresenceElement();

    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Validation of the seller's personal data form")
    @Feature("Validation of the seller's personal data form")
    @DisplayName("Validation of the seller's personal data form")
    @Test
    @Order(14)
    public  void emploeeInformationSalesFormDetail(){
        LoginPage loginPage = new LoginPage();
        PimPage pimPage = new PimPage();
        loginPage.logIn();
        pimPage.emploeeInformationSalesFormDetail();


    }


    @Severity(SeverityLevel.NORMAL)
    @Description("Logout test")
    @Feature("Logout")
    @DisplayName("Logout test")
    @Test
    @Order(15)
    public  void logOut(){
        LoginPage loginPage = new LoginPage();
        loginPage.logIn();
        loginPage.logOut();
        loginPage.loginPageLoginPanel.shouldBe(visible);

    }


    @Severity(SeverityLevel.MINOR)
    @Description("Follow the logo link")
    @Feature("Follow the logo link")
    @DisplayName("Follow the logo link")
    @Test
    @Order(16)
    public  void followTheLogoLink(){
        LoginPage loginPage = new LoginPage();
        AdminPage adminPage = new AdminPage();
        loginPage.logIn();
        adminPage.lableIcon.click();

        switchTo().window(1);
        String pageCurrentUrl = url();
        Assertions.assertEquals("https://www.orangehrm.com/", pageCurrentUrl,
                "Открыта не https://www.orangehrm.com/ или название страницы неверно");
        Selenide.closeWindow();
        switchTo().window(0);
    }




}
