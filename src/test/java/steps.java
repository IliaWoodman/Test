import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class steps {
    WebDriver driver;
    YandexPicture page;

    @Given("Open yandex picture")
    public void openY(){
        System.setProperty("webdriver.chrome.driver", "C:\\driverForSelenium\\new\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://yandex.ru/images/?clid=2270456&win=420");
    }
    @When("click search picture button")
    public void clickSearchPictureButton(){
        page = new YandexPicture(driver);
        page.clickImageButton();
    }
    @When("add picture link")
    public void addImage(){
        page.addImage("C:\\driverForSelenium\\kran.jpg");
    }
    @Then("check that tags have word")
    public void checkResult(){
        Assert.assertTrue(page.checkWord(page.getTags(),"автокран"));
    }
}
