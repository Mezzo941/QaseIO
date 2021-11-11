package wrappers;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Input {

    private static final String TITLE = "#title";
    private static final String INPUT = "//label[contains(text(),'%s')]/ancestor::div[@class='form-group']//p";
    public static String caseTitle;

    public static void setTitle(String caseTitle) {
        $(TITLE).sendKeys(caseTitle);
        Input.caseTitle = caseTitle;
    }

    public static void setText(String name, String text) {
        try {
            $(By.xpath(String.format(INPUT, name))).sendKeys(text);
        } catch (Exception exception) {
            System.out.println("Wrong input");
        }
    }

}
