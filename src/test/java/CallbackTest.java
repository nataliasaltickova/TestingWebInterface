import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class CallbackTest {
    private WebDriver driver;

    @BeforeAll
     public static void setUpAll() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\79271\\Downloads\\TestingWebInterface\\driver\\win\\chromedriver.exe");
     }
     @BeforeEach
     public void setUp() {
        driver = new ChromeDriver();
     }
     @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;
     }
     @Test
    public void shouldSendForm() {
        driver.get("http://localhost:9999");
         List<WebElement> textFields = driver.findElements(By.className("input__control"));
         textFields.get(0).sendKeys("Natalia");
         textFields.get(1).sendKeys("+78968584534");
         driver.findElement(By.className("checkbox__box")).click();
         driver.findElement(By.tagName("button"));
         String actualText = driver.findElement(By.className("paragraph")).getText();
         String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
         assertEquals(expected,actualText);

     }



}
