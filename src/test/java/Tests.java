import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import org.openqa.selenium.By;
import pages.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests {
    @BeforeAll
    public void setup() {

        Configuration.startMaximized = true;

    }

    @AfterEach
    public void logOut(){
        $(By.id("welcome")).click();
        $(By.xpath("//a[text()=\"Logout\"]")).click();
    }

    @Test
    @Order(1)

public void loginTest() {
        LoginPage loginPage = new LoginPage();
        AdminPage adminPage = new AdminPage();
        loginPage.logIn();
        adminPage.lableIcon.shouldBe(Condition.visible);


    }

    @Test
    @Order(3)

    public void addUserFormValidation () {
        AdminPage adminPage = new AdminPage();
        LoginPage loginPage = new LoginPage();
        loginPage.logIn();
        adminPage.addUserMenu();
        adminPage.addUserFormValidation();

    }

    @Test
    @Order(4)

    public void addUser () {
        AdminPage adminPage = new AdminPage();
        PimPage pimPage = new PimPage();
        LoginPage loginPage = new LoginPage();
        loginPage.logIn();
        adminPage.addUserMenu();
        adminPage.addUser(pimPage.firstName + " " + pimPage.lastName,
                adminPage.userName,"12345678","12345678");
        adminPage.resultTableForm
                .shouldBe(text(pimPage.firstName + " " + pimPage.lastName));

    }

    @Test
    @Order(2)

    public void addEmployee(){
        PimPage pimPage = new PimPage();
        LoginPage loginPage = new LoginPage();
        loginPage.logIn();
        pimPage.addEmployee(pimPage.firstName, pimPage.lastName);
        String employeeFullName = pimPage.firstName + " " + pimPage.lastName;
        pimPage.employeeForm.shouldBe(text(employeeFullName));

    }
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

    @Test
    @Order(6)
    public void deleteEmployee(){
        LoginPage loginPage = new LoginPage();
        PimPage pimPage = new PimPage();
        loginPage.logIn();
        pimPage.deleteEmploee();
        pimPage.resultTableForm.shouldNotBe(text(pimPage.lastName));

    }

    @Test
    @Order(7)
    public void addCandidate(){
        LoginPage loginPage = new LoginPage();
        RecruitmentPage recruitmentPage = new RecruitmentPage();
        loginPage.logIn();
        recruitmentPage.addCandidate();
        recruitmentPage.candidateButton();
        recruitmentPage.candidateForm.shouldBe
                (text(recruitmentPage.firstName + " "
                        + recruitmentPage.lastName));

    }
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
    @Test
    @Order(11)
    public void addAssingLeaveFormValidation(){
        LoginPage loginPage = new LoginPage();
        LeavePage leavePage = new LeavePage();
        loginPage.logIn();
        leavePage.pathAssingLeave();
        leavePage.addAssingLeaveFormValidation();
    }

}
