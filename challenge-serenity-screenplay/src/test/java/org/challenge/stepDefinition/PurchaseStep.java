package org.challenge.stepDefinition;


import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.challenge.questions.TheCartItemCount;
import org.challenge.questions.TheConfirmationMessage;
import org.challenge.tasks.*;
import org.challenge.utils.Constants;

public class PurchaseStep {

    private Actor buyer;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        buyer = OnStage.theActorCalled("Buyer");
    }

    @Given("the user is on the SauceDemo login page")
    public void theUserIsOnTheLoginPage() {
       buyer.attemptsTo(Open.url("https://www.saucedemo.com"));
    }

    @When("the user logs in with username {string} and password {string}")
    public void theUserLogsIn(String username, String password) {
        buyer.attemptsTo(Login.withCredentials(username, password));
    }

    @And("the user adds {int} products to the cart")
    public void theUserAddsProductsToCart(int quantity) {
        buyer.attemptsTo(AddProductToCart.items(quantity));
    }

    @And("the user navigates to the cart")
    public void theUserNavigatesToTheCart() {
        buyer.attemptsTo(Checkout.fromCart());
    }

    @Then("the cart should contain {int} items")
    public void theCartShouldContain(int expectedCount) {
        buyer.should(
                Ensure.that(TheCartItemCount.inCart()).isEqualTo(expectedCount).toString()
        );
    }

    @When("the user completes checkout with first name {string}, last name {string} and zip {string}")
    public void theUserCompletesCheckout(String firstName, String lastName, String zip) {
        buyer.attemptsTo(CompletePurchase.withDetails(firstName, lastName, zip));
    }

    @Then("the user should see the confirmation message {string}")
    public void theUserShouldSeeConfirmation(String expectedMessage) {
        buyer.should(
                Ensure.that(TheConfirmationMessage.displayed())
                        .isEqualTo(expectedMessage).toString()
        );
    }

    @When("the user attempts checkout with first name {string}, last name {string} and zip {string}")
    public void the_user_attempts_checkout_with_first_name_last_name_and_zip(String firstName, String lastName, String zip) {
        buyer.attemptsTo(CheckoutValidation.withInformation(firstName, lastName, zip));

    }
    @Then("the user should see the error message {string}")
    public void the_user_should_see_the_error_message(String expectedMessage) {
        buyer.should(
                Ensure.that(TheConfirmationMessage.displayed())
                        .isEqualTo(expectedMessage).toString()
        );
    }






}