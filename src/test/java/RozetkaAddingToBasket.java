import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RozetkaAddingToBasket {

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
    public void firstTest() {
        WebElement laptopAndComputerTab = driver.findElement(By.xpath("//ul[@class='menu-categories menu-categories_type_main']/li[1]"));
        laptopAndComputerTab.click();
        WebElement laptopTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Ноутбуки']")));
        laptopTab.click();

        String title = driver.findElement(By.className("goods-tile__heading")).getText().trim();

        WebElement basket = driver.findElement(By.xpath("//app-buy-button[@extclass='goods-tile__buy-button']"));
        basket.click();

        String countItemsInBasket = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='counter counter--green ng-star-inserted']"))).getAttribute("innerText");

        WebElement basketButton = driver.findElement(By.xpath("//button[@class='header__button ng-star-inserted header__button--active']"));
        basketButton.click();

        String titleOfProductInBasket = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//a[@class='cart-product__title']")))).getAttribute("innerText");

        Assert.assertEquals(titleOfProductInBasket, title, "The name of the goods does not match");
        Assert.assertEquals(countItemsInBasket, "1", "Number of items more than one");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

}

