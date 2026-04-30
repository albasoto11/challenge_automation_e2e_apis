package org.challenge.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage extends PageObject {

    public static final Target FIRST_NAME_FIELD =
            Target.the("first name field").located(By.id("first-name"));

    public static final Target LAST_NAME_FIELD =
            Target.the("last name field").located(By.id("last-name"));

    public static final Target POSTAL_CODE_FIELD =
            Target.the("postal code field").located(By.id("postal-code"));

    public static final Target CONTINUE_BUTTON =
            Target.the("continue button").locatedBy("#continue");

    public static final Target FINISH_BUTTON =
            Target.the("finish button").locatedBy("#finish");

    public static final Target ERROR_MESSAGE = Target.the("error-message-container")
            .locatedBy(".error-message-container");
}


