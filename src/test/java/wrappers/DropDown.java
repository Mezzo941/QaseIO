package wrappers;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DropDown {

    private static final String DROPDOWN = "//div[@class='form-group']/label[contains(text(),'%s')]/ancestor::div[@class='form-group']/div[contains(@class, 'container')]";

    public static void input(String name, String option) {
        try {
            $(By.xpath(String.format(DROPDOWN, name))).click();
        }
        catch (Exception exception){
            System.out.println("Wrong dropdown name");
        }
        try {
            $$(By.xpath("//div[contains(@id,'option')]")).findBy(Condition.text(option)).click();
        }
        catch (Exception exception){
            System.out.println("Wrong dropdown option");
        }
    }


}
