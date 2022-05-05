package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

        String selenoidUrlAddress = System.getProperty("selenoidUrlAddress",
                "selenoid.autotests.cloud/wd/hub");
        String defaultBrowserSize = System.getProperty("defaultBrowserSize","1920x1080");
        String defaultUrlAddress = System.getProperty("defaultUrlAddress", "https://demoqa.com/");
        String defaultBrowser = System.getProperty("defaultBrowser", "chrome");
        String defaultBrowserVersion = System.getProperty("defaultBrowserVersion", "100");

        Configuration.baseUrl = defaultUrlAddress;
        Configuration.browserSize = defaultBrowserSize;
        Configuration.remote = "https://"+ config.login() + ":" + config.password() +"@" + selenoidUrlAddress;
        Configuration.browser = defaultBrowser;
        Configuration.browserVersion = defaultBrowserVersion;


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("Скриншот");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
        closeWebDriver();
    }
}
