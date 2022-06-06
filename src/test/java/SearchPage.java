import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$x;
/** Создаем коллекцию элементов и получаем первый элемент(т.е кол-во статей на сайте)
 * нам нужна первая статья
 * поэтому для поиска элементов используем $$x
 *  */

public class SearchPage {
    private final ElementsCollection articleTitle = $$x("//h2//a");

    public String getHrefFromFirstArticle() {
        return articleTitle.first().getAttribute("href");

        /**first используем,т.к нам нужен первый элемент
         * используем "getAttribute" чтоб получить атрибут
         * "return" возвращает href из первой статьи */



    }


}
