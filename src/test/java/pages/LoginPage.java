package pages;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    private final static String EMAIL = "#inputEmail";
    private final static String PASSWORD = "#inputPassword";
    private final static String REMEMBER_ME_CHECKBOX = ".custom-control-indicator";
    private final static String SUBMIT_BUTTON = "#btnLogin";

    @Override
    public boolean isOpened() {
        return $(SUBMIT_BUTTON).getText().equals("Login") && super.isOpened();
    }

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
