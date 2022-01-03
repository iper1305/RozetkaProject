import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.page;

public class RozetkaLaptPageLogicSelenide extends RozetkaLaptPageElementsSelenide {

    public RozetkaLaptPageLogicSelenide addItemInCart(SelenideElement addItemInButton) {
        addItemInButton.shouldBe(Condition.visible);
        addItemInButton.click();
        return this;
    }

    public RozetkaCartPageLogicSelenide clickOnCart(SelenideElement cartButton) {
        cartButton.shouldBe(Condition.visible);
        cartButton.click();
        return page(RozetkaCartPageLogicSelenide.class);
    }
}
