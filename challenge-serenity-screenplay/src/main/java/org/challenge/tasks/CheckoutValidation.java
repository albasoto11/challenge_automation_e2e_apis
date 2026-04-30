package org.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import org.challenge.ui.CartPage;
import org.challenge.ui.CheckoutPage;
import org.challenge.utils.Constants;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CheckoutValidation implements Task {

    private final String firstName;
    private final String lastName;
    private final String zipCode;
    private final boolean fillInformation;

    public CheckoutValidation() {
        this.firstName = null;
        this.lastName = null;
        this.zipCode = null;
        this.fillInformation = false;
    }

    public CheckoutValidation(String firstName, String lastName, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.fillInformation = true;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(Constants.CART_URL),
                Click.on(CartPage.CHECKOUT_BUTTON)
        );

        if (fillInformation) {
            actor.attemptsTo(
                    Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME_FIELD),
                    Enter.theValue(lastName).into(CheckoutPage.LAST_NAME_FIELD),
                    Enter.theValue(zipCode).into(CheckoutPage.POSTAL_CODE_FIELD),
                    Click.on(CheckoutPage.CONTINUE_BUTTON)
            );
        }
    }

    public static Checkout fromCart() {
        return instrumented(Checkout.class);
    }

    public static Checkout withInformation(String firstName, String lastName, String zipCode) {
        return instrumented(Checkout.class, firstName, lastName, zipCode);
    }
}