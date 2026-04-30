package org.challenge.stepDefinition.hook;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.challenge.hook.OpenWeb;
import org.challenge.utils.Time;
import org.hamcrest.Matchers;

import static org.challenge.utils.Constants.*;

public class hook {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }



    @Given("que el usuario {string} abre la página de inicio de sesión")
    public void que_el_usuario_abre_la_página_de_inicio_de_sesión(String actor) {

    }
}
