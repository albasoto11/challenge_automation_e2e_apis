package org.challenge.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.challenge.ui.CartPage;

public class TheCartItemCount implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return CartPage.CART_ITEMS
                .resolveAllFor(actor)
                .size();
    }

    public static TheCartItemCount inCart() {
        return new TheCartItemCount();
    }
}