package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashBoardPage {
    SelenideElement dashBoardButton = $(By.id("menu_dashboard_index"));
    SelenideElement assignLeaveIcon = $("img[src=\"/webres_6051af48107ce6.31500353/orangehrmLeavePlugin/images/ApplyLeave.png\"]");
    SelenideElement leaveListIcon = $("img[src=\"/webres_6051af48107ce6.31500353/orangehrmLeavePlugin/images/MyLeave.png\"]");
    SelenideElement timeShitsIcon = $("img[src=\"/webres_6051af48107ce6.31500353/orangehrmTimePlugin/images/MyTimesheet.png\"]");
    SelenideElement applyLeaveIcon = $("img[src=\"/webres_6051af48107ce6.31500353/orangehrmLeavePlugin/images/ApplyLeave.png\"]");
    SelenideElement myLeaveIcon = $("img[src=\"/webres_6051af48107ce6.31500353/orangehrmLeavePlugin/images/MyLeave.png\"]");
    SelenideElement myTimeSheetIcon = $("img[src=\"/webres_6051af48107ce6.31500353/orangehrmTimePlugin/images/MyTimesheet.png\"]");
    SelenideElement employeeDistributionBySubunitDiagram = $(By.xpath("//canvas[@class=\"flot-overlay\"]"));
    SelenideElement legendMarker1 = $(By.xpath("//div[@style=\"width:4px;height:0;border:5px solid rgb(237,194,64);overflow:hidden\"]"));
    SelenideElement legendMarker2 = $(By.xpath("//div[@style=\"width:4px;height:0;border:5px solid rgb(175,216,248);overflow:hidden\"]"));
    SelenideElement legendMarker3 = $(By.xpath("//div[@style=\"width:4px;height:0;border:5px solid rgb(203,75,75);overflow:hidden\"]"));
    SelenideElement legendMarker4 = $(By.xpath("//div[@style=\"width:4px;height:0;border:5px solid rgb(77,167,77);overflow:hidden\"]"));
    SelenideElement legendMarker5 = $(By.xpath("//div[@style=\"width:4px;height:0;border:5px solid rgb(148,64,237);overflow:hidden\"]"));
    SelenideElement legendMarker6 = $(By.xpath("//div[@style=\"width:4px;height:0;border:5px solid rgb(189,155,51);overflow:hidden\"]"));
    SelenideElement legendMarker7 = $(By.xpath("//div[@style=\"width:4px;height:0;border:5px solid rgb(140,172,198);overflow:hidden\"]"));
    SelenideElement dashBoardForm = $(By.id("content"));


    @Step("Checking items dashboard")
    public void dashBoardPagePresenceElement(){
        dashBoardButton.click();
        assignLeaveIcon.shouldBe(visible);
        leaveListIcon.shouldBe(visible);
        timeShitsIcon.shouldBe(visible);
        applyLeaveIcon.shouldBe(visible);
        myLeaveIcon.shouldBe(visible);
        myTimeSheetIcon.shouldBe(visible);
        employeeDistributionBySubunitDiagram.shouldBe(visible);
        legendMarker1.shouldBe(visible);
        legendMarker2.shouldBe(visible);
        legendMarker3.shouldBe(visible);
        legendMarker4.shouldBe(visible);
        legendMarker5.shouldBe(visible);
        legendMarker6.shouldBe(visible);
        legendMarker7.shouldBe(visible);
        dashBoardForm.shouldBe(text("Dashboard"), text("Quick Launch"), text("Assign Leave"), text("Leave List"),
                text("Timesheets"), text("Apply Leave"), text("My Leave"), text("My Timesheet"), text("Employee Distribution by Subunit"),
                text("Legend"), text("Pending Leave Requests"), text("Not assigned to Subunits"), text("Administration"),
                text("Client Services"), text("Engineering"),text("Finance"), text("Human Resources"), text("Sales & Marketing"));

    }

}
