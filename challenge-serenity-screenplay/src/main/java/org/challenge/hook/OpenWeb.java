package org.challenge.hook;


import net.serenitybdd.model.environment.ConfiguredEnvironment;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.model.util.EnvironmentVariables;
import org.challenge.utils.Constants;
import net.serenitybdd.screenplay.actions.Open;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class OpenWeb implements Task {
    private final String webUrl;

    public OpenWeb(String webUrl) {
        this.webUrl = webUrl;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        EnvironmentVariables environmentVariables =
                ConfiguredEnvironment.getEnvironmentVariables();
        String pathWebUrl = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(webUrl);
        actor.attemptsTo(Open.url(pathWebUrl));
    }

    public static Performable browserURL(String webUrl) {
        return instrumented(OpenWeb.class, webUrl);
    }
}
