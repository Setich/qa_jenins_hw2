package tests.properties;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

public class OwnerTests {
    @Test
    void loginTest() {
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

        String login = config.login();
        String password = config.password();

        System.out.println("Login: "+ login);
        System.out.println("Password: "+ password);

        String massage = "I logged in as " + login + " with password " + password;
        System.out.println(massage);
    }

}
