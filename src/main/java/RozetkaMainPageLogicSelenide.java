import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;


public class RozetkaMainPageLogicSelenide extends RozetkaMainPageElementsSelenide {

    public RozetkaCompLaptPageLogicSelenide clickOnCategory(SelenideElement category) {
        category.shouldBe(Condition.visible);
        category.click();
        return page(RozetkaCompLaptPageLogicSelenide.class);
    }
}
