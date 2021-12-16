import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.LinkedList;

public class RozetkaTestWithPO {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
    }

    @Test
    public void testWithPageObject() {
        RozetkaMainPageLogic rozetkaMainPageLogic = new RozetkaMainPageLogic(driver, wait, "Акционные предложения");

        Assert.assertEquals(rozetkaMainPageLogic.itemsInBlock.size(), 6);

        LinkedList<String> prices = rozetkaMainPageLogic.getPrices();

        int index = 0;
        for (var item : rozetkaMainPageLogic.getLinks()) {
            driver.get(item);
            RozetkaProductPageLogic product = new RozetkaProductPageLogic(driver, wait);

            String price = product.getPrice();
            Assert.assertEquals(prices.get(index++), price);

            driver.navigate().back();
        }

        RozetkaMainPageLogic rozetkaMainPageLogicAfterReturn = new RozetkaMainPageLogic(driver, wait, "Акционные предложения");
        Assert.assertEquals(rozetkaMainPageLogicAfterReturn.itemsInBlock.size(), 6);
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}


