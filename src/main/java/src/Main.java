package src;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://skillbox-java.github.io").get();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        List<String> el = doc.select(".js-metro-line").eachText();
//        for (String str:el  ) {
//            System.out.println(str);
//        }
//        List<String> el1 = doc.select(".js-metro-line").eachAttr("data-line");
//        System.out.println(el1.size());
//        for (String str:el1  ) {
//            System.out.println(str);
//        }
        //находим все элементы соответсвующие классу ".js-metro-line"
        Elements elements = doc.select(".js-metro-line");

        for (Element element : elements) {
            //находим значение элемента и значение его атрибута
            System.out.println(element.text() + " " + element.attr("data-line"));
        }
        //находим элементв с классом js-depend
        Elements elements2 = doc.select(".js-depend");
        System.out.println("elements2.size()  " + elements2.size());
        //выводим номер линии и станцию которая ей соответствует
        for (Element element : elements2) {
            String attr = element.attr("data-depend-set");
            for (Element str : element.select(".name")) {
                String sub = attr.substring(6);
                System.out.println("Линия " + sub + "   станция " + str.text());
            }
        }
        //System.out.println(el.size());
        //System.out.println(el);

    }
}
