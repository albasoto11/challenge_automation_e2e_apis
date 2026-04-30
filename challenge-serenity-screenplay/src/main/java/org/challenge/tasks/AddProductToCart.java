package org.challenge.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.challenge.ui.InventoryPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddProductToCart implements Task {

    private final int quantity;

    public AddProductToCart(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 0; i < quantity; i++) {
            Target nthButton = Target.the("add to cart button #" + (i + 1))
                    .locatedBy("(//button[contains(@class,'btn_inventory')])[" + (i + 1) + "]");
            actor.attemptsTo(Click.on(nthButton));
        }
    }

    public static AddProductToCart items(int quantity) {
        return instrumented(AddProductToCart.class, quantity);
    }
}