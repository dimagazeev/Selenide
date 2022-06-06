import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

/** Главная страница appleinsider.ru  */

public class MainPage  {
    private final SelenideElement textBoxInput = $x("//input[@type='text']");

    public  MainPage(String URL){
        Selenide.open(URL);
    }

    /** Выполняется поиск статей на сайте и нажимается кнопка Enter
     * @param  searchString это поисковая строка
     * */

    public void search(String searchString){
        textBoxInput.setValue(searchString);
        textBoxInput.sendKeys(Keys.ENTER);

    }
}
