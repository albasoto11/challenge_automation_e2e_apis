package org.challenge.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class HomeUi extends PageObject {

    public static final Target BTN_ELEMENTS= Target.the("Boton elementos")
            .located(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));

    /* Este elemento BTN_LIST_ELEMENTS se deja parametrizado **/
    public static final Target BTN_LIST_ELEMENTS = Target.the("boton lista opciones elementos")
            .locatedBy("//div/div/div//div [@class='inventory_list']");

    public static final Target TXT_RANDOM_NAME_BTN= Target.the("texto random, del nombre de los botones")
            .located(By.xpath("//div[@class='inventory_item']"));
}
