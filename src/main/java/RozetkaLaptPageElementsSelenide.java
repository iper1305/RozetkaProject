import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;


public class RozetkaLaptPageElementsSelenide {
    SelenideElement item = $(By.xpath("//span[@class='goods-tile__title']"));
    SelenideElement shoppingCart = $(By.xpath("//app-buy-button[@extclass='goods-tile__buy-button']"));
    SelenideElement cartButton = $(By.xpath("//button[@class='header__button ng-star-inserted header__button--active']"));
}
