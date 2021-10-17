package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private static final String EMAIL = "#inputEmail";
    private static final String PASSWORD = "#inputPassword";
    private static final String REMEMBER_ME_CHECKBOX = ".custom-control-indicator";
    private static final String SUBMIT_BUTTON = "#btnLogin";

    public LoginPage open() {
        Selenide.open("/");
        return this;
    }

    public HomePage authorization(String email, String pass) {
        $(EMAIL).sendKeys(email);
        $(PASSWORD).sendKeys(pass);
        $(REMEMBER_ME_CHECKBOX).click();
        $(SUBMIT_BUTTON).click();
        return new HomePage();
    }


}
