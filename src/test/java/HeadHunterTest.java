package hh;

import core.BaseTest;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HeadHunterTest extends BaseTest {
    private final static String URL = "https://hh.ru/resume/bfe9e65fff08acb3c10039ed1f646d79613759";

    @Test
    public void checkAttributesHushMap(){
        //Создаем экземпляр класса "hhResumePage" для перехода по URL

        hhResumePage HhresumePage = new hhResumePage(URL);
        Map<String, Object> expectedAttributes = new HashMap<>();
        // создали хэш карту с ожидаемым результатом
        expectedAttributes.put(hhResumePage.GENDER, "М");
        expectedAttributes.put(hhResumePage.AGE, 29);
        expectedAttributes.put(hhResumePage.CITY, "Москва");
        expectedAttributes.put(hhResumePage.READY_TO_RELOCATE, true);
        expectedAttributes.put(hhResumePage.LOGO, true);

        Map<String, Object> actualAttributes = HhresumePage.getAttributes();
        /** У нас есть ожидаемые атрибуты(expectedAttributes) и актуальные(getAttributes)
         * и теперь сравним их использую "assertEquals" сравниваем два объекта */
        Assert.assertEquals(expectedAttributes, actualAttributes);
    }
    @Test
    public void checkAttributesClass(){
        hhResumePage HhResumePage = new hhResumePage(URL);
        // Создаем экземпляр класса с ожидаемым результатом
        Resume expectedAttributes = new Resume
                ("М", "Москва", 29, true, true);
        // Создаем экземпляр класса с актуальным результатом
        Resume actualAttributes = new Resume
                (HhResumePage.getGender(),HhResumePage.getCity(),HhResumePage.getAge(),
                        HhResumePage.isReadyToRelocate(),HhResumePage.isLogoHH());



        // 1ЫЙ вариант
        Assert.assertTrue(EqualsBuilder.reflectionEquals(expectedAttributes,actualAttributes));
        // 2ой вариант
        Assert.assertEquals(expectedAttributes.getAge(), actualAttributes.getAge());
        Assert.assertEquals(expectedAttributes.getGender(), actualAttributes.getGender());
        Assert.assertEquals(expectedAttributes.getCity(), actualAttributes.getCity());
        Assert.assertEquals(expectedAttributes.isLogo(), actualAttributes.isLogo());
        Assert.assertEquals(expectedAttributes.isReady_to_relocate(),actualAttributes.isReady_to_relocate());

        /**так как в данном случае разные классы и мы не можем использовать обычный "Assert"
         * мы добавляем "EqualsBuilder.reflectionEquals"
         */


    }
}
