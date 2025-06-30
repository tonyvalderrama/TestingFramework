package test;

import com.epam.training.tony_valderrama.pages.LoginPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Clase que realiza pruebas parametrizadas con JUnit
 */
public class LoginParameterTest extends CommonTestStuff {

    @ParameterizedTest
    @CsvFileSource(resources = "/logins.csv", numLinesToSkip = 1)
    void testLogins(String userName,String password,String expectedMessage) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName,password);
        assertThat(loginPage.getErrorMessage(),equalTo(expectedMessage));
    }
}
