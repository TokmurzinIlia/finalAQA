package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RecruitmentPage {
    SelenideElement recruitmentButton = $(By.id("menu_recruitment_viewRecruitmentModule"));
    public SelenideElement candidateButton = $(By.id("menu_recruitment_viewCandidates"));
    public SelenideElement candidateForm = $(By.id("frmList_ohrmListComponent"));
    SelenideElement addCandidateButton = $(By.id("btnAdd"));
    public SelenideElement candidateFirstName = $(By.id("addCandidate_firstName"));
    public SelenideElement candidateLastName = $(By.id("addCandidate_lastName"));
    SelenideElement candidateEmail = $(By.id("addCandidate_email"));
    SelenideElement candidateContactNo = $(By.id("addCandidate_contactNo"));
    SelenideElement candidateJobVacancyDropBox = $(By.id("addCandidate_vacancy"));
    SelenideElement candidateJobVacancyJuniorAccountAssistantx =
            $(By.xpath("//option[text()='Junior Account Assistants']"));
    SelenideElement candidatePayrollAdministrator =
            $(By.xpath("//option[text()='Payroll Administrator']"));
    SelenideElement candidateJobVacancySalesRepresentative =
            $(By.xpath("//option[text()='Sales Representative']"));
    SelenideElement candidateJobVacancySeniorQALead =
            $(By.xpath("//option[text()='Senior QA Lead']"));
    SelenideElement candidateJobVacancySeniorSupportSpecialist =
            $(By.xpath("//option[text()='Senior Support Specialist']"));
    SelenideElement candidateJobVacancySoftwareEngineer =
            $(By.xpath("//option[text()='Software Engineer']"));
    SelenideElement candidateContactKeywords = $(By.id("addCandidate_keyWords"));
    SelenideElement candidateContactComment = $(By.id("addCandidate_comment"));
    SelenideElement candidateContactDateOfApplication = $(By.id("addCandidate_appliedDate"));
    SelenideElement candidateContactConsentToKeepData = $(By.id("addCandidate_consentToKeepData"));
    SelenideElement candidateContactSaveButton = $(By.id("btnSave"));
    SelenideElement candidateNameSearchField = $(By.id("candidateSearch_candidateName"));
    SelenideElement candidateNameSearchButton = $(By.id("btnSrch"));

    public String firstName = "Silim";
    public String lastName = "Dilim";
    String eMail = "SilimDilim@mail.ru";
    String contactNo = "+375336897812";
    String contactKeywords = "QA";
    String comment = "Hello";
    String dateOfApplication = "2021-08-31";

    public String candidateNameCheckboxLocator =
            "//a[text()='" + firstName + "  " +  lastName + "']/../..//input[@name=\"chkSelectRow[]\"]";
    SelenideElement candidateNameCheckbox = $(By.xpath(candidateNameCheckboxLocator));

    SelenideElement deleteCandidateButton = $(By.id("btnDelete"));

    public SelenideElement deleteRecordOkButton = $(By.id("dialogDeleteBtn"));



    public void addCandidate(){
        recruitmentButton.click();
        addCandidateButton.click();
        candidateFirstName.setValue(firstName);
        candidateLastName.setValue(lastName);
        candidateEmail.setValue(eMail);
        candidateContactNo.setValue(contactNo);
        candidateJobVacancyDropBox.click();
        candidateJobVacancySeniorQALead.click();
        candidateContactKeywords.setValue(contactKeywords);
        candidateContactComment.setValue(comment);
        candidateContactDateOfApplication.clear();
        candidateContactDateOfApplication.setValue(dateOfApplication).pressEnter();
        candidateContactConsentToKeepData.click();
        candidateContactSaveButton.click();
        candidateButton();
        candidateNameSearchField.setValue(firstName + " " + lastName);
        candidateNameSearchButton.click();

    }

    public void deleteCandidate(){
        recruitmentButton.click();
        candidateNameSearchField.setValue(firstName + " " + lastName);
        candidateNameSearchButton.click();
        candidateNameCheckbox.click();
        deleteCandidateButton.click();
        deleteRecordOkButton.click();
        candidateNameSearchField.setValue(firstName + " " + lastName);
        candidateNameSearchButton.click();
    }
    public void candidateButton(){
        candidateButton.click();
    }

}
