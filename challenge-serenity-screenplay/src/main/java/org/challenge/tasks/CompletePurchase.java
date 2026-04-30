package org.challenge.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.challenge.ui.CheckoutPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompletePurchase implements Task {

    private final String firstName;
    private final String lastName;
    private final String zip;

    public CompletePurchase(String firstName, String lastName, String zip) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.zip       = zip;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(firstName).into(CheckoutPage.FIRST_NAME_FIELD),
                Enter.theValue(lastName).into(CheckoutPage.LAST_NAME_FIELD),
                Enter.theValue(zip).into(CheckoutPage.POSTAL_CODE_FIELD),
                Click.on(CheckoutPage.CONTINUE_BUTTON),
                Click.on(CheckoutPage.FINISH_BUTTON)
        );
    }

    public static CompletePurchase withDetails(String firstName, String lastName, String zip) {
        return instrumented(CompletePurchase.class, firstName, lastName, zip);
    }
}
