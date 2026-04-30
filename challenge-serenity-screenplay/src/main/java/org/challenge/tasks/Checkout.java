package org.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import org.challenge.ui.CartPage;
import org.challenge.utils.Constants;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Checkout implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.url(Constants.CART_URL),
                Click.on(CartPage.CHECKOUT_BUTTON)
        );
    }

    public static Checkout fromCart() {
        return instrumented(Checkout.class);
    }
}