package test;

import com.epam.training.tony_valderrama.model.User;
import com.epam.training.tony_valderrama.pages.LoginPage;
import com.epam.training.tony_valderrama.service.UserCreator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest extends CommonTestStuff {

    @Test
    public void validLogin() {
        // Leo datos de usuario de las propiedades
        User user = UserCreator.withCredentialsFromProperty();
        // Para depurar sin prompt de Maven
        //User user = new User("secret_sauce","standard_user");
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        // Creo página de Login y hago login
        LoginPage loginPage = new LoginPage(driver);
        System.out.println("User = " + user.getUsername());
        System.out.println("Pwd = " + user.getPassword());
        loginPage.enterUser(user.getUsername());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickLoginButton();

        // Veo si el URL es el correcto
        assertThat(loginPage.getURL(), equalTo(expectedURL));
    }
}
