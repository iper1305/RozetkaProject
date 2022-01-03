
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class RozetkaAddToCartSelenide {

    @BeforeMethod
    public void before() {
        Configuration.startMaximized = true;
        open("https://rozetka.com.ua/");
    }

    @Test
    public void firstTest() {
        RozetkaLaptPageElementsSelenide laptopPageElements = new RozetkaLaptPageElementsSelenide();

        RozetkaCartPageLogicSelenide cartPageLogic = new RozetkaMainPageLogicSelenide()
                .clickOnCategory(new RozetkaMainPageElementsSelenide().laptopAndComputerTab)
                .clickOnSubCategory(new RozetkaCompLaptPageElementsSelenide().laptopTab)
                .addItemInCart(laptopPageElements.shoppingCart)
                .clickOnCart(laptopPageElements.cartButton);

        cartPageLogic.itemInCart.shouldBe(CollectionCondition.size(1));
        Assert.assertEquals(cartPageLogic.itemInCart.size(), 1);

        cartPageLogic.countItemInCart.shouldBe(Condition.visible);
        Assert.assertEquals(cartPageLogic.countItemInCart.getAttribute("value"), "1");
        Assert.assertEquals(laptopPageElements.item.getText().trim(), cartPageLogic.itemInCart.get(0).getText().trim());


    }
}
