package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {

    private static final String PROJECT = "//tr[@class='project-row']//a[contains(text(),'%s')]";

    public ProjectsPage openProject(String project) {
        try {
            $(By.xpath(String.format(PROJECT, project))).click();
        }
        catch (Exception exception){
            System.out.println("No such project");
        }
        return new ProjectsPage();
    }

}
