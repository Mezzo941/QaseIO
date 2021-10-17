package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import wrappers.DropDown;
import wrappers.Input;

import static com.codeborne.selenide.Selenide.$;

public class CasePage extends BasePage {

    private final static String SAVE_BUTTON = "#save-case";

    @Override
    public boolean isOpened() {
        $(By.xpath(String.format(TITLE,"Create test case"))).shouldBe(Condition.visible);
        return super.isOpened();
    }

    public ProjectsPage saveCase() {
        if (!Input.caseTitle.isEmpty()) {
            ProjectsPage.cases.add(Input.caseTitle);
            $(SAVE_BUTTON).click();
        } else {
            System.out.println("Case title is empty");
        }
        return new ProjectsPage();
    }

    public CasePage setCaseData() {
        Input.setTitle("OLOLO VO PRIKOL CHE MOGU");
        DropDown.input("Status", "Draft");
        DropDown.input("Suite", "SIGN UP");
        DropDown.input("Sever", "Minor");
        DropDown.input("Prior", "Low");
        DropDown.input("Type", "Smoke");
        DropDown.input("Auto", "Automated");
        Input.setText("Descr", "MAYBE I DON'T DESERVE TO BE HAPPY");
        Input.setText("Pre", "ok");
        Input.setText("Post", "pizdec");
        return this;
    }
}
