import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RozetkaProductPageLogic {

    By findProductPrice = By.xpath("//p[contains(@class,'product-prices__big')]");

    private WebDriver driver;
    private WebDriverWait wait;

    public RozetkaProductPageLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getPrice() {
        String price = wait.until(ExpectedConditions.presenceOfElementLocated(findProductPrice)).getText().trim();
        return price.substring(0, price.length() - 1);
    }


}

