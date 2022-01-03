import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class RozetkaCompLaptPageLogicSelenide extends RozetkaCompLaptPageElementsSelenide {

    public RozetkaLaptPageLogicSelenide clickOnSubCategory(SelenideElement category) {
        category.shouldBe(Condition.visible);
        category.click();
        return page(RozetkaLaptPageLogicSelenide.class);
    }
}
