package org.challenge.tasks;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static org.challenge.ui.HomeUi.BTN_ELEMENTS;
import static org.challenge.ui.HomeUi.BTN_LIST_ELEMENTS;

@AllArgsConstructor
public class ChooseRandomTask implements Task {


    private String numberRandomBtn;

    public static ChooseRandomTask witchParams(String numberRandomBtn) {

        return Tasks.instrumented(ChooseRandomTask.class, numberRandomBtn);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
     String number = numberRandomBtn;
     actor.attemptsTo(Scroll.to(BTN_LIST_ELEMENTS),
             Click.on(BTN_ELEMENTS.of(number))
     );
    }
}
