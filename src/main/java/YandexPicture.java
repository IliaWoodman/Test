import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class YandexPicture {
    //https://yandex.ru/images/?clid=2270456&win=420
    private WebDriver driver;

    public YandexPicture(WebDriver driver) {
        this.driver = driver;
    }

    private By searchField = By.xpath("//input");
    private By searchButton = By.xpath("//button[@class = 'websearch-button']");
    private By searchImageButton = By.xpath("//span[@class = 'icon icon_type_cbir input__button']");
    private By chooseImageField = By.xpath("//input[@class = 'cbir-panel__file-input']");
    private By tags = By.xpath("//a[@class = 'Button2 Button2_width_auto Button2_view_default Button2_size_l Button2_type_link Button2_tone_gray Tags-Item']");

    public void typeSearchField(String text) {
        driver.findElement(searchField).sendKeys(text);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public void clickImageButton() {
        driver.findElement(searchImageButton).click();
    }

    public void addImage(String path) {
        driver.findElement(chooseImageField).sendKeys(path);
    }

    public ArrayList<String> getTags() {
        List<WebElement> list = driver.findElements(tags);
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(i).getText());
        }
        return result;
    }

    public boolean checkWord(ArrayList<String> list, String word){
        ArrayList<String> temp = new ArrayList<String>();
        String [] tempArray;
        String s = word;
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            tempArray = list.get(i).split(" ");
            for (int j = 0; j < tempArray.length; j++) {
                if (tempArray[j].equals(word)){
                    ++result;
                }
            }
        }
        //System.out.println(result);
        if (result > 0) return true;
        else return false;
    }
}
