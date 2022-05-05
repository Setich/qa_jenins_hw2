package tests.properties;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    void myProperties(){
        String baseUrl = System.getProperty("https://demoqa.com/");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        String version = System.getProperty("version", "101");
        String textOfTheGreeting= System.getProperty("Hello all testers, hello all developers");
        String yourName = System.getProperty("Alex");
        String selenoidAddress = System.getProperty("selenoid.autotests.cloud/wd/hub");

        System.out.println(baseUrl);
        System.out.println(browserSize);
        System.out.println(version);
        System.out.println(textOfTheGreeting);
        System.out.println(yourName);
        System.out.println(selenoidAddress);
    }

}
