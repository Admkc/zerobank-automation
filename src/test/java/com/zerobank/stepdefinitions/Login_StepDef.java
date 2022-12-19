package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountsummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class Login_StepDef {
    LoginPage loginPage=new LoginPage();
    AccountsummaryPage accountsummaryPage=new AccountsummaryPage();

    @Given("The user should be on the page")
    public void the_user_should_be_on_the_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }
    @When("The user click Sign in button")
    public void the_user_click_sign_in_button() {

        loginPage.signinButtpn_loc.click();



    }
    @When("The user should input {string} and {string}")
    public void the_user_should_input_and(String string, String string2) {
        loginPage.loginUser();

    }

    @Then("The User should go to another page")
    public void the_user_should_go_to_another_page() {
        Driver.get().get(ConfigurationReader.get("url2"));

    }

    @And("The user input {string} and {string}")
    public void theUserInputAnd(String name, String password) {

        loginPage.loginWithParameters(name,password);

        
    }

    @Then("Then The warning message contains {string}")
    public void thenTheWarningMessageContains(String expectedMesaj) {

        String actMsj=loginPage.getWarningText();
        String exp="Login and/or password are wrong.";

        Assert.assertEquals(exp,actMsj);


    }

    @And("The user click Sign in button after login")
    public void theUserClickSignInButtonAfterLogin() {
        loginPage.sign_loc.click();
    }

    @And("get the title of the page and verify")
    public void getTheTitleOfThePageAndVerify() {
        System.out.println("Driver.get().getTitle() = " + Driver.get().getTitle());
        String act=Driver.get().getTitle();
        String exp="Zero - Account Summary";

        Assert.assertEquals(exp,act);
    }

    @And("User should be able to see account options")
    public void userShouldBeAbleToSeeAccountOptions(List<String > accounts) {

        List<String > actAct=BrowserUtils.getElementsText(accountsummaryPage.accountOptions_loc);


        System.out.println("actAct = " + actAct);
        System.out.println("accounts = " + accounts);


    }
}
