package ru.dyatlov.model.server;


import ru.dyatlov.model.client.Content;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DB {

    private static List<Content> db= new ArrayList<>();
    private static int i=0;

    public DB(){
    }

    public static void add(String title, String author,String preview, String authorLogo, Boolean anonymous){
        db.add(new Content(i++,title, author, preview, authorLogo, anonymous));
    }

    public static void delete(int id){
        for (Content content:
             db) {
            if(content.getId()==id){
                db.remove(content);
            }
        }
    }

    public static Map<String, String> getElementById(int id){
        return db.get(id).getMap();
    }

    public static List<Map<String,String>> getMap(){
        List<Map<String,String>> result = new ArrayList<>();
        for (Content content:db
             ) {
            result.add(content.getMap());
        }
        return result;
    }
}
