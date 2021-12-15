import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
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
        int tabNumber = 1;
        for (var item : rozetkaMainPageLogic.getLinks()) {
            ((JavascriptExecutor) driver).executeScript("window.open()");
            WebDriver pageDriver = switchTabs(tabNumber);
            pageDriver.get(item);
            RozetkaProductPageLogic product = new RozetkaProductPageLogic(pageDriver, wait);

            String price = product.getPrice();
            Assert.assertEquals(prices.get(tabNumber - 1), price);
            tabNumber++;
        }

        switchTabs(0);
        driver.navigate().refresh();

        Assert.assertEquals(rozetkaMainPageLogic.itemsInBlock.size(), 6);
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

    private WebDriver switchTabs(int index) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        WebDriver pageDriver = driver.switchTo().window(tabs.get(index));
        return pageDriver;
    }
}


