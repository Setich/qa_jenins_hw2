package tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("systemProperties")
public class SystemPropertiesTests {
    @Test
    void myProperties(){
        String baseUrl = System.getProperty("baseUrl","https://demoqa.com/");
        String browserSize = System.getProperty("browserSize", "1920x1080");
        String version = System.getProperty("version", "101");
        String textOfTheGreeting= System.getProperty("textOfTheGreeting",
                "Hello all testers, hello all developers");
        String yourName = System.getProperty("yourName", "Alex");
        String selenoidAddress = System.getProperty("selenoidAddress", "selenoid.autotests.cloud/wd/hub");

        System.out.println(baseUrl);
        System.out.println(browserSize);
        System.out.println(version);
        System.out.println(textOfTheGreeting);
        System.out.println(yourName);
        System.out.println(selenoidAddress);
    }

}
