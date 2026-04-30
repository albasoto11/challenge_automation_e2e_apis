package org.challenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static org.challenge.ui.HomeUi.BTN_ELEMENTS;
import static org.challenge.ui.HomeUi.BTN_LIST_ELEMENTS;
import static org.challenge.utils.Constants.TIME_SHORT;

public class FuntionsElementsTask implements Task {
    public static FuntionsElementsTask choose() {
        return Tasks.instrumented(FuntionsElementsTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Scroll.to(BTN_LIST_ELEMENTS));
        actor.attemptsTo(WaitUntil.the(BTN_LIST_ELEMENTS, isEnabled())
                        .forNoMoreThan(TIME_SHORT).seconds(),
                Click.on(BTN_ELEMENTS));
    }

    }


