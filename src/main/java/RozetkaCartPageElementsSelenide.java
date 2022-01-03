import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class RozetkaCartPageElementsSelenide {

    ElementsCollection itemInCart;
    SelenideElement countItemInCart;

    public RozetkaCartPageElementsSelenide() {
        itemInCart = $$(By.xpath("//a[@class='cart-product__title']"));
        countItemInCart = $(By.xpath("//input[@class='cart-counter__input ng-untouched ng-pristine ng-valid']"));
    }
}
