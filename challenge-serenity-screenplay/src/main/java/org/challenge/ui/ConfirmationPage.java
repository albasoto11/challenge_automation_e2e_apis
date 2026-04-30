package org.challenge.ui;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ConfirmationPage extends PageObject {

    public static final Target CONFIRMATION_HEADER =
            Target.the("confirmation header").locatedBy(".complete-header");
}