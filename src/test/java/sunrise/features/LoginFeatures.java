package sunrise.features;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import sunrise.data.Users;
import sunrise.domain.User;
import sunrise.pages.HeaderBox;
import sunrise.pages.LoginPage;
import sunrise.steps.LoginSteps;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginFeatures {

    final private User VALID_USER = Users.WITH_LOGIN;
    final private String login = VALID_USER.getLogin();
    final private String password = VALID_USER.getPassword();

    private sunrise.pages.HomePage homePage;
    private HeaderBox headerBox;
    private LoginPage loginPage;

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
        final SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(isSignOutButtonVisible).isFalse();
        softAssertions.assertAll();
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
