package org.challenge.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.challenge.ui.ConfirmationPage;

public class TheConfirmationMessage implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return ConfirmationPage.CONFIRMATION_HEADER
                .resolveFor(actor)
                .getText()
                .trim()
                .toUpperCase();
    }

    public static TheConfirmationMessage displayed() {
        return new TheConfirmationMessage();
    }
}