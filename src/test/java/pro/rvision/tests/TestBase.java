package pro.rvision.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import pro.rvision.helpers.Attach;
import pro.rvision.pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        String browser = System.getProperty("browser");
        String version = System.getProperty("version");

        Configuration.browserVersion = version;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
        Configuration.browser = browser;

        String login = System.getProperty("login","user1");
        String password = System.getProperty("password", "1234");
        String url = System.getProperty("url");
        String remoteUrl = "https://" + login + ":" + password + "@" + url;

        Configuration.remote = remoteUrl;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
