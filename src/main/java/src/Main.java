package src;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

public class Main {
    public static void main(String[] args) {
//
     String folderPath = "data/files";
      File folder = new File(folderPath);
//        File[] files = folder.listFiles();
//        for(File file: files){
//            System.out.println(file.getName());
//        }
        //System.out.println(Arrays.stream(files).count());
        //System.out.println(folder.getName());
       getFolderSize(folder);


        //htmlParser();
    }
    public static void getFolderSize(File folder) {
        if (folder.isFile()) {
            System.out.print(folder.getName());
            System.out.println("  " + folder.getPath());
        }

        File[] files = folder.listFiles();
        if(files == null){
            return;
        }
        for (File file : files) {
            //System.out.println(file.getName());
            getFolderSize(file);
        }

    }
    public static void htmlParser(){
        Document doc = null;
        try {
            doc = Jsoup.connect("https://skillbox-java.github.io").get();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    }

}
