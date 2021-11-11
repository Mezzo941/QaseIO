package tests;

import adapters.ProjectAdapter;
import adapters.TestCaseAdapter;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

public abstract class BaseTest {

    protected final static String EMAIL = "asking1234@mail.ru";
    protected final static String PASS = "e0bajj11";

    LoginPage loginPage;
    ProjectAdapter projectAdapter;
    TestCaseAdapter testCaseAdapter;

    @BeforeMethod
    public void setUp() {
        Configuration.baseUrl = "https://app.qase.io/login";
        Configuration.browser = "chrome";
        Configuration.timeout = 3000;
        Configuration.startMaximized = true;
        loginPage = new LoginPage();
        projectAdapter = new ProjectAdapter();
        testCaseAdapter = new TestCaseAdapter();
    }

}

//title: test ,token: ffd0a24db5e9091651f225056c513714f56332af