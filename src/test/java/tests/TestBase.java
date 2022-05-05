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

        String selenoidAddress = System.getProperty("selenoid", "selenoid.autotests.cloud/wd/hub");
        String propertyBrowserSize = System.getProperty("propertyBrowserSize","1980x1024");
        String defaultUrl = System.getProperty("defaultUrl", "https://demoqa.com/");

        Configuration.baseUrl = defaultUrl;
        Configuration.browserSize = propertyBrowserSize;
        Configuration.remote = "https://"+ config.login() + ":" + config.password() +"@" + selenoidAddress;

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
