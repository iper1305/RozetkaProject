import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

public class RozetkaMainPageLogic {

    By searchBlock;
    By pricesOfItems = By.className("tile__price-value");
    By linkOfItems = By.className("tile__title");

    private WebDriver driver;
    private WebDriverWait wait;
    List<WebElement> itemsInBlock;

    public RozetkaMainPageLogic(WebDriver driver, WebDriverWait wait, String blockName) {
        this.driver = driver;
        this.wait = wait;
        searchBlock = By.xpath("//h2[contains(text(), '" + blockName + "')]/../ul/li");
        itemsInBlock = driver.findElements(searchBlock);
    }

    public LinkedList<String> getPrices() {
        LinkedList<String> pricesOfItem = new LinkedList<String>();
        for (WebElement element : itemsInBlock) {
            String price = element.findElement(pricesOfItems).getText();
            pricesOfItem.add(price);
        }
        return pricesOfItem;
    }

    public LinkedList<String> getLinks() {
        LinkedList<String> linkOfItem = new LinkedList<String>();
        for (WebElement element : itemsInBlock) {
            String link = element.findElement(linkOfItems).getAttribute("href");
            linkOfItem.add(link);
        }
        return linkOfItem;
    }
}

