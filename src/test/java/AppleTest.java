import org.junit.Assert;
import org.junit.Test;

public class AppleTest  extends BaseTest{


    private final static String Base_URL = "https://appleinsider.ru/";
    /** private - доступна только в этом классе
     *  final - не можем ее изменить
     *  static - т.е она есть всегда (инициализируется)
     */
    private final static String Search_String = "Чем iPhone 13 отличается от iPhone 12";

    @Test
    public void checkHref(){
        MainPage mainPage = new MainPage(Base_URL); // ПЕРЕХОД НА  стра
        mainPage.search(Search_String); // ввод в строку наш запрос для поиска
        SearchPage searchPage = new SearchPage(); // инициализировали класс "SearchPage"
        String href = searchPage.getHrefFromFirstArticle();
        //  мы записали данные в переменную  href
        Assert.assertTrue(href.contains("iphone-13"));
        /** выполняем проверка, содержит ли первая ссылка href слово "iphone13"
         * Assert.assertTrue() - мы сравниваем да или нет
         * Assert.assertEquals();  -когда мы сравниваем два объекта
         */ ;


    }
}
