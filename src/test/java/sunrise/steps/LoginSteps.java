package sunrise.steps;

import sunrise.pages.HeaderBox;
import sunrise.pages.LoginPage;

import static sunrise.data.Users.WITH_LOGIN;

public class LoginSteps {

    final private String login = WITH_LOGIN.getLogin();
    final private String password = WITH_LOGIN.getPassword();
    private LoginPage loginPage;
    private HeaderBox headerBox;

    public void login() {
        login(login, password);
    }

    public void login(final String login, final String password) {
        headerBox.clickOnSignInOrRegister();
        loginPage.typeLogin(login);
        loginPage.typePassword(password);
        loginPage.clickOnSignIn();
    }
}
