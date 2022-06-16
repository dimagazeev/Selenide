package hh;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class hhResumePage {
    private final SelenideElement gender = $x ("//span[@data-qa='resume-personal-gender']");
    private final SelenideElement age = $x ("//span[@data-qa='resume-personal-age']/span");
    private final SelenideElement city =$x ("//span[@data-qa='resume-personal-address']");
    private final SelenideElement liveData =$x ("//span[@data-qa='resume-personal-address']/ancestor::p");
    //   /ancestor:: - предыдущий элемент по дереву вверх (/ancestor::p)
    //   /following-sibling:: - мы опустились на строчку ниже
    //   /preceding-sibling:: - мы поднялись на строчку выше
    //   /parent:: - мы обратились на прямую к родителю внутри которого находится наш элемент
    private final SelenideElement logoHH =$x("//span[@class='supernova-logo supernova-logo_inversed supernova-logo_hh-ru']");
    private final SelenideElement isMetro = $x("//span[@data-qa='resume-personal-metro']");
    private final SelenideElement isEmail =$x("//a[@data-qa='resume-contact-preferred']");

    // КЛЮЧИ
    public static String GENDER = "Пол";
    public static String AGE = "Возраст";
    public static String CITY = "Город";
    public static String LOGO = "логотип";
    public static String READY_TO_RELOCATE = "готовность к переезду";
    public static String Metro = "Метро";
    public static String Email = "Почта";

    public Map<String, Object> getAttributes(){
        // это хэш карта с актуальным результатом
        // мы создали метод, который вернем там карту уже с заполненными значениями
        // put добавляет в карту данные(String(age) Object(getAge))
        //{{}} - говорит от том, что все вызванные методы будут связанны с картой
         return new HashMap<String, Object>(){{
            put(GENDER, getGender());
            put(AGE,getAge());
            put(CITY,getCity());
            put(LOGO,isLogoHH());
            put(READY_TO_RELOCATE,isReadyToRelocate());
            put(Metro,getMetro());
            put(Email,getEmail());
         }};}

    public hhResumePage(String URL) { //  создали с помощью конструктора (alt+inert)

        Selenide.open(URL); // метод для открытия ссылки
    }

    public boolean isLogoHH(){
        return logoHH.isDisplayed();
        /**  этот метод показывает если ли данный элемент на странице */
    }

    public String getEmail(){
        return isEmail.getText();
    }

     public String getGender(){
        return gender.getText().equals("Мужчина") ? "М" : "Ж";
     /**
      * * здесь использован тернальный оператор
      * return(получаем текст из нашего веб-элемента) gender.getText().equals("Мужчина)"
      * если "equals" равен Мужчина, то ставим "М", иначе( ":") вернем "Ж"  */
}
    public int getAge(){
     return Integer.parseInt(age.getText().replaceAll("\\D+", ""));
        // "age.getText()" - получаем от локатора текст
        // "replaceAll" - всё что мы нашли, мы заменим на что-то -
        // (в нашем случае найденные текстовые элементы заменяем ни на что)
        // ("\\D+", "")) - регулярное выражение (мы заменили текст на цифры) и это по-прежнему строка
        // Integer.parseInt - преобразовывает строку в число
        //p.s мы взяли текст(29 лет) и убрали из него все символы кроме цифр
        // и потом преобразовали найденное значение в число
        }

    public String getCity(){
        return city.getText(); // этим методом мы взяли именно текст(элемент) со страницы
    }

    public String getMetro(){
        return isMetro.getText();
    }

    public boolean isReadyToRelocate(){
        return liveData.getText().split(", ")[2].equals("готов к переезду");
        /**
         * split - создает массив, разделение текста на части с определенным разделителем(запятая+пробел)
         *  если перед "liveData" поставить "!", то условия будут наоборот
         *  есть "!" в наших условиях будет "false", без "!" будет "trye"
         *  наша строка делится на 3 части,[1]- "м. Бескудниково"; [2]- "готов к переезду"
         *  equals проверяем равен "готов к переезду" или нет*
         *  equals возвращает логическое значение "trye" или "false"/ */
    }

}
