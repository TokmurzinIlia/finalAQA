package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LeavePage {
    SelenideElement leaveButton = $(By.id("menu_leave_viewLeaveModule"));
    SelenideElement assingLeaveButton = $(By.id("menu_leave_assignLeave"));
    SelenideElement assingLeaveContent = $(By.id("content"));
    SelenideElement employeeNameField = $(By.id("assignleave_txtEmployee_empName"));
    SelenideElement leaveTypeField = $(By.id("assignleave_txtLeaveType"));
    SelenideElement leaveTypeUSBereavementField = $(By.xpath("//select[@id=\"assignleave_txtLeaveType\"]//option[@value = \"3\"]"));
    SelenideElement leaveBalanceField = $(By.id("assignleave_leaveBalance"));
    SelenideElement leaveFromDateField = $(By.id("assignleave_txtFromDate"));
    SelenideElement leaveToDateField = $(By.id("assignleave_txtToDate"));
    SelenideElement leaveCommentField = $(By.id("assignleave_txtComment"));
    SelenideElement leavePartialDaysField = $(By.id("assignleave_partialDays"));
    SelenideElement leavePartialDaysAllDaysButton = $(By.xpath("//option[@value=\"all\"]"));
    SelenideElement leavePartialDaysStartDayOnlyButton = $(By.xpath("//option[@value=\"start\"]"));
    SelenideElement leavePartialDaysEndDayOnlyButton = $(By.xpath("//option[@value=\"end\"]"));
    SelenideElement leavePartialDaysStartandEndDayButton = $(By.xpath("//option[@value=\"start_end\"]"));
    SelenideElement durationDurationField = $(By.id("assignleave_firstDuration_duration"));
    SelenideElement endDurationDurationField = $(By.id("assignleave_secondDuration_duration"));
    SelenideElement endDayDurationDurationField = $(By.id("assignleave_secondDuration_duration"));
    SelenideElement endDayDurationAmpmField = $(By.id("assignleave_secondDuration_ampm"));
    SelenideElement endDaydurationDurationHalfDayField = $(By.xpath("//select[@id=\"assignleave_secondDuration_duration\"]//option[@value=\"half_day\"]"));
    SelenideElement endDaydurationDurationSpecifyTimeField = $(By.xpath("//select[@id=\"assignleave_secondDuration_duration\"]//option[@value=\"specify_time\"]"));
    SelenideElement endDaydurationDurationSpecifyTimeFromField = $(By.id("assignleave_secondDuration_time_from"));
    SelenideElement endDaydurationDurationSpecifyTimeToField = $(By.id("assignleave_secondDuration_time_to"));
    SelenideElement endDaydurationDurationSpecifyTimeDurationField = $(By.xpath("//li[@style=\"\"]//input[@class=\"time_range_duration\"]"));
    SelenideElement durationDurationHalfDayField = $(By.xpath("//select[@id=\"assignleave_firstDuration_duration\"]//option[@value=\"half_day\"]"));
    SelenideElement durationDurationSpecifyTimeField = $(By.xpath("//select[@id=\"assignleave_firstDuration_duration\"]//option[@value=\"specify_time\"]"));
    SelenideElement durationDurationSpecifyTimeFromField = $(By.id("assignleave_firstDuration_time_from"));
    SelenideElement durationDurationSpecifyTimeToField = $(By.id("assignleave_firstDuration_time_to"));
    SelenideElement durationDurationSpecifyTimeDurationField = $(By.xpath("//li[@style=\"\"]//input[@class=\"time_range_duration\"]"));
    SelenideElement startAndEndDaydurationDurationSpecifyTimeDurationField = $(By.xpath("//span[@id=\"assignleave_secondDuration_specify_time_content\"]//input[@class=\"time_range_duration\"]"));

    SelenideElement durationAmpmField = $(By.id("assignleave_firstDuration_ampm"));
    SelenideElement durationAmpmMorningField = $(By.xpath("//option[@value=\"AM\"]"));
    SelenideElement durationAmpmAftenoonField = $(By.xpath("//option[@value=\"PM\"]"));
    SelenideElement durationDurationOneDateField = $(By.id("assignleave_duration_duration"));
    SelenideElement durationDurationOneDateHalfDayField = $(By.xpath("//select[@id=\"assignleave_duration_duration\"]//option[@value=\"half_day\"]"));
    SelenideElement durationDurationOneDateHalfDayAfternoonField = $(By.xpath("//span[@id=\"assignleave_duration_half_day_content\"]//option[@value=\"PM\"]"));
    SelenideElement durationDurationOneDateHalfDayAmpmField = $(By.id("assignleave_duration_ampm"));
    SelenideElement durationDurationOneDateHalfDaySpecifyTimeField = $(By.xpath("//select[@id=\"assignleave_duration_duration\"]//option[@value=\"specify_time\"]"));

    SelenideElement durationDurationSpecifyTimeOneDateFromField = $(By.id("assignleave_duration_time_from"));
    SelenideElement durationDurationSpecifyTimeOneDateToField = $(By.id("assignleave_duration_time_to"));
    SelenideElement durationDurationSpecifyTimeDurationOneDateField = $(By.xpath("//li[@style=\"\"]//input[@class=\"time_range_duration\"]"));
    SelenideElement assingButton = $(By.id("assignBtn"));
    SelenideElement oKButton = $(By.id("confirmOkButton"));
    SelenideElement leaveListButton = $(By.id("menu_leave_viewLeaveList"));
    SelenideElement showLeaveWithStatusAllCheckbox = $(By.id("leaveList_chkSearchFilter_checkboxgroup_allcheck"));
    SelenideElement emploeeLeaveListField = $(By.id("leaveList_txtEmployee_empName"));
    SelenideElement searchButton = $(By.id("btnSearch"));
    public SelenideElement leaveListSearchForm = $(By.id("search-results"));
    String fromDate = "2021-09-09";
    String toDate = "2021-09-26";
    public String emploeeName = "Otto Pilot";
    String comment = "New year";

    @Step("Validation the form for adding vacations")
    public void addAssingLeaveFormValidation(){
        assingLeaveContent.shouldBe(text("Assign Leave"),
                text("Employee Name *"), text("Leave Type *"), text("Leave Balance"),
                text("From Date *"), text("To Date *"), text("Comment"));
        employeeNameField.shouldBe(visible);
        leaveTypeField.shouldBe(visible);
        leaveTypeField.click();
        assingLeaveContent.shouldBe(text("--Select--"), text("CAN - Bereavement"),
                text("CAN - FMLA"),text("CAN - Matternity"), text("CAN - Personal"),
                text("CAN - Vacation"), text("US - Bereavement"), text("US - FMLA"),
                text("US - Matternity"), text("US - Personal"), text("US - Vacation"));


        leaveBalanceField.shouldBe(visible);
        leaveFromDateField.shouldBe(visible);
        leaveToDateField.shouldBe(visible);
        leaveCommentField.shouldBe(visible);
        leaveFromDateField.clear();
        leaveFromDateField.setValue(fromDate).pressEnter();
        leaveToDateField.clear();
        leaveToDateField.setValue(toDate).pressEnter();
        leavePartialDaysField.shouldBe(visible);
        assingLeaveContent.shouldBe(text("Partial Days"));
        leavePartialDaysField.click();
        assingLeaveContent.shouldBe(text("None"), text("All Days"), text("Start Day Only"),
                text("End Day Only"), text("Start and End Day"));
        leavePartialDaysField.click();
        leavePartialDaysAllDaysButton.click();
        assingLeaveContent.shouldBe(text("Duration"));
        durationDurationField.shouldBe(visible);
        durationAmpmField.shouldBe(visible);
        durationDurationField.click();
        assingLeaveContent.shouldBe(text("Half Day"), text("Specify Time"));
        durationAmpmField.click();
        assingLeaveContent.shouldBe(text("Morning"), text("Afternoon"));
        durationDurationField.click();
        durationDurationSpecifyTimeField.click();

        assingLeaveContent.shouldBe(text("From"), text("To"), text("Duration"));
        durationDurationSpecifyTimeFromField.shouldBe(visible);
        durationDurationSpecifyTimeToField.shouldBe(visible);
        durationDurationSpecifyTimeDurationField.shouldBe(visible);
        leavePartialDaysStartDayOnlyButton.click();
        assingLeaveContent.shouldBe(text("Start Day"));
        assingLeaveContent.shouldBe(text("From"), text("To"), text("Duration"));
        durationDurationSpecifyTimeFromField.shouldBe(visible);
        durationDurationSpecifyTimeToField.shouldBe(visible);
        durationDurationSpecifyTimeDurationField.shouldBe(visible);
        durationDurationHalfDayField.click();
        durationDurationField.click();
        assingLeaveContent.shouldBe(text("Half Day"), text("Specify Time"));
        durationAmpmField.click();
        assingLeaveContent.shouldBe(text("Morning"), text("Afternoon"));
        leavePartialDaysEndDayOnlyButton.click();
        assingLeaveContent.shouldBe(text("End Day"));
        endDayDurationDurationField.click();
        assingLeaveContent.shouldBe(text("Half Day"), text("Specify Time"));
        endDayDurationAmpmField.click();
        assingLeaveContent.shouldBe(text("Morning"), text("Afternoon"));
        endDaydurationDurationSpecifyTimeField.click();
        assingLeaveContent.shouldBe(text("From"), text("To"), text("Duration"));
        endDaydurationDurationSpecifyTimeFromField.shouldBe(visible);
        endDaydurationDurationSpecifyTimeToField.shouldBe(visible);
        endDaydurationDurationSpecifyTimeDurationField.shouldBe(visible);
        leavePartialDaysStartandEndDayButton.click();
        assingLeaveContent.shouldBe(text("Start Day"), text("End Day"));
        durationDurationField.click();
        assingLeaveContent.shouldBe(text("Half Day"), text("Specify Time"));
        durationAmpmField.click();
        assingLeaveContent.shouldBe(text("Morning"), text("Afternoon"));
        assingLeaveContent.shouldBe(text("From"), text("To"), text("Duration"));
        endDaydurationDurationSpecifyTimeFromField.shouldBe(visible);
        endDaydurationDurationSpecifyTimeToField.shouldBe(visible);
        startAndEndDaydurationDurationSpecifyTimeDurationField.shouldBe(visible);
        endDaydurationDurationHalfDayField.click();
        endDurationDurationField.click();
        assingLeaveContent.shouldBe(text("Half Day"), text("Specify Time"));
        endDayDurationAmpmField.click();
        assingLeaveContent.shouldBe(text("Morning"), text("Afternoon"));
        durationDurationSpecifyTimeField.click();
        assingLeaveContent.shouldBe(text("From"), text("To"), text("Duration"));
        durationDurationSpecifyTimeFromField.shouldBe(visible);
        durationDurationSpecifyTimeToField.shouldBe(visible);
        durationDurationSpecifyTimeDurationField.shouldBe(visible);
        leaveFromDateField.clear();
        leaveFromDateField.setValue(fromDate).pressEnter();
        leaveToDateField.clear();
        leaveToDateField.setValue(fromDate).pressEnter();
        assingLeaveContent.shouldBe(text("Duration"));
        durationDurationOneDateField.click();
        assingLeaveContent.shouldBe(text("Full Day"), text("Half Day"), text("Specify Time"));
        durationDurationOneDateHalfDayField.click();
        durationDurationOneDateHalfDayAmpmField.click();
        assingLeaveContent.shouldBe(text("Morning"), text("Afternoon"));
        durationDurationOneDateHalfDaySpecifyTimeField.click();
        assingLeaveContent.shouldBe(text("From"), text("To"), text("Duration"));
        durationDurationSpecifyTimeOneDateFromField.shouldBe(visible);
        durationDurationSpecifyTimeOneDateToField.shouldBe(visible);
        durationDurationSpecifyTimeDurationOneDateField.shouldBe(visible);

    }

    @Step("Open AssingLeave")
    public void pathAssingLeave(){
        leaveButton.click();
        assingLeaveButton.click();
    }

    @Step("Open AssingLeave")
    public void addAssingLeave(String emploeeName){
        employeeNameField.setValue(emploeeName).pressEnter();
        leaveTypeField.click();
        leaveTypeUSBereavementField.click();
        leaveFromDateField.clear();
        leaveFromDateField.setValue(fromDate).pressEnter();
        leaveToDateField.clear();
        leaveToDateField.setValue(fromDate).pressEnter();
        durationDurationOneDateField.click();
        durationDurationOneDateHalfDayField.click();
        durationDurationOneDateHalfDayAfternoonField.click();
        leaveCommentField.setValue(comment);
        assingButton.click();
        oKButton.click();
        leaveListButton.click();
        showLeaveWithStatusAllCheckbox.click();
        emploeeLeaveListField.setValue(emploeeName).pressEnter();
        searchButton.click();

    }
}



