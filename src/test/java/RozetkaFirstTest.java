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


public class RozetkaFirstTest {

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

        WebElement inputSearch = driver.findElement(By.xpath("//input[@name='search']"));
        inputSearch.sendKeys("Mac");
        WebElement searchButton = driver.findElement(By.xpath("//button[contains(@class,'search-form__submit')]"));
        searchButton.click();

        WebElement titleOfFirstItem = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='goods-tile__heading ng-star-inserted']")));

        String titleOfFirstItemTextExpected = "Бокал для шампанского Chef&Sommelier 300 мл серия Macaron (L9348)";
        Assert.assertEquals(titleOfFirstItemTextExpected, titleOfFirstItem.getText().trim(), "Tittle does not equal");
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
