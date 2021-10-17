package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

public abstract class BaseTest {

    protected final static String EMAIL = "asking1234@mail.ru";
    protected final static String PASS = "e0bajj11";

    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        Configuration.baseUrl = "https://app.qase.io/login";
        Configuration.browser = "chrome";
        Configuration.timeout = 3000;
        Configuration.startMaximized = true;
        loginPage = new LoginPage();
    }

}
