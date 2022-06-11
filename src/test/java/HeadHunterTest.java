package hh;

import core.BaseTest;
import org.junit.Test;

public class HeadHunterTest extends BaseTest {
    private final static String URL = "https://hh.ru/resume/bfe9e65fff08acb3c10039ed1f646d79613759";

    @Test
    public void checkAttributesHushMap(){
        //Создаем экземпляр класса "hhResumePage" для перехода по URL

        hhResumePage HhresumePage = new hhResumePage(URL);



    }
}
