package sunrise.features;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import sunrise.pages.HeaderBox;
import sunrise.steps.LoginSteps;

import static org.assertj.core.api.Assertions.assertThat;
import static sunrise.data.Users.WITH_LOGIN;

public class LoginFeatures {

    final private String login = WITH_LOGIN.getLogin();
    final private String password = WITH_LOGIN.getPassword();

    private sunrise.pages.HomePage homePage;
    private HeaderBox headerBox;

    @Steps
    private LoginSteps loginSteps;


    @Given("^customer is on home page$")
    public void userIsOnHomePage() {
        homePage.open();
    }

    @When("^he logs in using correct credentials$")
    public void heLogsInUsingCorrectCredentials() {
        loginSteps.login();
    }

    @Then("^he is logged in$")
    public void heIsLoggedIn() {
        final boolean isSignOutButtonVisible = headerBox.isSignOutButtonVisible();
        assertThat(isSignOutButtonVisible).isTrue();
    }

    @When("^he tries to log in using wrong password$")
    public void heTriesToLogInUsingWrongPassword() {
        loginSteps.login(login, "bla");
    }

    @Then("^he is not logged in$")
    public void heIsNotLoggedIn() {
        final boolean isSignOutButtonVisible = headerBox.isSignOutButtonVisible();
        assertThat(isSignOutButtonVisible).isFalse();
    }

    @Given("^logged in customer is on home page$")
    public void loggedInCustomerIsOnHomePage() {
        homePage.open();
        loginSteps.login();
    }

    @When("^he logs out$")
    public void heLogsOut() {
        headerBox.clickOnSignOut();
    }

    @Then("^he is logged out$")
    public void heIsLoggedOut() {
        final boolean isSignInButtonDisplayed = headerBox.isSignInOrRegisterButtonVisible();
        assertThat(isSignInButtonDisplayed).isTrue();
    }

    @When("^he tries to log in using wrong login$")
    public void heTriesToLogInUsingWrongLogin() {
        loginSteps.login("bla@bla.bla", password);
    }

}
