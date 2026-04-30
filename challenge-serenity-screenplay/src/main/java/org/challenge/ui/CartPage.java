package org.challenge.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CartPage extends PageObject {

    public static final Target CART_ITEMS =
            Target.the("cart items").locatedBy(".cart_item");

    public static final Target CHECKOUT_BUTTON =
            Target.the("checkout button").locatedBy("#checkout");
}
