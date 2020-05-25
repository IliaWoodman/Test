import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class YandexTest {
    WebDriver driver;
    YandexPicture firstPage;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\driverForSelenium\\new\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://yandex.ru/images/?clid=2270456&win=420");
    }
    @Test
    public void firstTest(){
        firstPage = new YandexPicture(driver);
        firstPage.clickImageButton();
        firstPage.addImage("C:\\driverForSelenium\\kran.jpg");
        ArrayList<String> list = firstPage.getTags();
        System.out.println(list);
        Assert.assertTrue(firstPage.checkWord(list, "автокран"));

    }
}
