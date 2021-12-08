import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;


public class TestRozetkaSearchPageCountProduct {

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
    public void firstTest() throws IOException {
        WebElement laptopAndComputerTab = driver.findElement(By.xpath("//ul[@class='menu-categories menu-categories_type_main']/li[1]"));
        laptopAndComputerTab.click();
        WebElement laptopTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Ноутбуки']")));
        laptopTab.click();

        LinkedHashMap<String, String> titleAndPrice = new LinkedHashMap<>();

        for (WebElement i : driver.findElements(By.xpath("//div[@class='goods-tile__inner']"))) {
            String title = i.findElement(By.className("goods-tile__heading")).getText();
            String price = i.findElement(By.className("goods-tile__price-value")).getText();
            titleAndPrice.put(title, price);
        }

        FileWriter fileWriter = new FileWriter("rozetkaTest.txt");
        for (Map.Entry<String, String> entry : titleAndPrice.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            fileWriter.write(key + " - " + value + " грн." + "\n");
        }
        fileWriter.close();
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

}
