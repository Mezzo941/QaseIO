package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {

    private final static String PROJECT = "//tr[@class='project-row']//a[contains(text(),'%s')]";

    @Override
    public boolean isOpened() {
        $(By.xpath(String.format(TITLE,"Projects"))).shouldBe(Condition.visible);
        return super.isOpened();
    }

    public ProjectsPage openProject(String project) {
        try {
            $(By.xpath(String.format(PROJECT, project))).click();
        } catch (Exception exception) {
            System.out.println("No such project");
        }
        return new ProjectsPage();
    }

}
