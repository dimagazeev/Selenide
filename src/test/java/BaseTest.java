import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

abstract  public class BaseTest {
    /**
     * абстрактным класс делаем для того,
     * чтобы от него можно было только наследоваться
     * т.е общая конструкция для других классов
     */

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome"; // настройка браузера - хром (Configuration - настройка)
        Configuration.driverManagerEnabled = true; //  да, действительно у нас это есть
        Configuration.browserSize = "1920х1080"; //  размер экранам в котором будут запускаться тесты
        //Configuration.headless = true; // видим ли мы браузер во время теста(для Jenkins ставим false)
    }


    @After
    public void tearDown() {
        Selenide.closeWebDriver();//  закрывается WebDriver
    }
}


