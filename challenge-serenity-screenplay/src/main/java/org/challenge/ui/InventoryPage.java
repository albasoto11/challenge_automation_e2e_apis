package org.challenge.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class InventoryPage extends PageObject {

    public static final Target ADD_TO_CART_BUTTONS =
            Target.the("add to cart buttons")
                    .locatedBy(".btn_primary.btn_inventory");

    public static final Target CART_ICON =
            Target.the("cart icon").locatedBy(".shopping_cart_link");

    public static final Target CART_BADGE =
            Target.the("cart badge").locatedBy(".shopping_cart_badge");
}