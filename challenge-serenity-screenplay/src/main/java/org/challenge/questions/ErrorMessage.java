package org.challenge.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.challenge.ui.CheckoutPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ErrorMessage {
    public static Question<String> displayed() {
        return Question.about("error message").answeredBy(actor -> {
            // Esperar a que el mensaje de error sea visible
            actor.attemptsTo(
                    WaitUntil.the(CheckoutPage.ERROR_MESSAGE, isVisible()).forNoMoreThan(5).seconds()
            );
            return Text.of(CheckoutPage.ERROR_MESSAGE).answeredBy(actor).toString();
        });
    }
}
