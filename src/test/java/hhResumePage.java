package hh;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.sun.beans.decoder.StringElementHandler;

import java.net.URL;

import static com.codeborne.selenide.Selenide.$x;

public class hhResumePage {
    private final SelenideElement gender = $x ("//span[@data-qa='resume-personal-gender']");
    private final SelenideElement age = $x ("//span[@data-qa='resume-personal-age']/span");
    private final SelenideElement city =$x ("//span[@data-qa='resume-personal-address']");
    private final SelenideElement liveData =$x ("//span[@data-qa='resume-personal-address']/ancestor::p");
    //   /ancestor:: - мы поднимаемся в директорию к родителю (/ancestor::p)
    //   /following-sibling:: - мы опустились на строчку ниже
    //   /preceding-sibling:: - мы поднялись на строчку выше
    //   /parent:: - мы обратились на пряму к родителю внутри которого находится наш элемент
    private final SelenideElement logoHH =$x("//span[@class='supernova-logo supernova-logo_inversed supernova-logo_hh-ru']");

    public hhResumePage(String URL) {
        Selenide.open(URL);
    }

    public boolean isLogoHH(){
        return logoHH.isDisplayed();
        /**  этот метод показывает если ли данный элемент на странице */

    }
    // 1ый вариант
   public String getGender(){
       /** Если нам нужно что-то вернуть пишем "String", если ничего, то "void" */
        String genderValue = gender.getText();
        /**  C помощью этого метода мы получаем текст из переменной веб элемента */
       if(genderValue == "Мужчина"){
           return "М";
       }
       return "Ж";}  /**  Если условия "if" выполняется, то выдаем "М",если нет,то "Ж"  */

     // 2ой вариант
    public String getGenderHard(){
        return gender.getText().equals("Мужчина") ? "М" : "Ж";
        /**
         * return(получаем текст из нашего веб-элемента) gender.getText().equals("Мужчина)"
         * если "equals" равен Мужчина, то ставим "М", иначе( ":") ставим "Ж"  */
    }

    public int getAge(){
     return Integer.parseInt(age.getText().replaceAll("\\D+", ""));
        // "age.getText()" - получаем от локатора текст
        // "replaceAll"  - всё что мыы нашли, мы заменим на что-то -
        // (в нашем случае найденные текстовые элементы заменяем ни на что)
        // ("\\D+", "")) - регулярное выражение (мы заменили текст на цифры) и это по-прежнему строка
        // Integer.parseInt - преобразовывает строку в число
        //p.s мы взяли текст(29 лет) и убрали из него все символы кроме цифр
        // и потом преобразовали найденное значение в число
        }
    public String getCity(){
        return city.getText();
    }

    public boolean isReadyToRelocate(){
        return !liveData.getText().split(", ")[2].equals("готов к переезду");
        /**
         * квадратными скобками мы создаем массив
         * split - разделение текста на части с определенным разделителем(запятая+пробел)
         *  если перед "liveData" поставить "!", то условия будут наоборот
         *  если есть "!" в наших условиях будет "false", без "!" будет "trye" */

    }

}
