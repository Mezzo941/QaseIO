package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class ProjectsPage extends BasePage {

    private final static String CREATE_CASE_BUTTON = "#create-case-button";
    public static List<String> cases = new ArrayList<>();

    @Override
    public boolean isOpened() {
        return $(CREATE_CASE_BUTTON).getText().equals("Case") && super.isOpened();
    }


    public CasePage clickToCreateNewCase() {
        $(CREATE_CASE_BUTTON).click();
        return new CasePage();
    }

    public boolean findCaseOnThePage(String caseName) {
        try {
            $(By.xpath(String.format("//*[text()='%s']", caseName))).shouldBe(Condition.visible);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

}
