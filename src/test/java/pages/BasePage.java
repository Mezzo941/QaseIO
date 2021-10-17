package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.webdriver;

public abstract class BasePage {

    public boolean isOpened() {
        WebDriver driver = webdriver().object();
        return new WebDriverWait(driver, 2).until(webDriver ->
                ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}


