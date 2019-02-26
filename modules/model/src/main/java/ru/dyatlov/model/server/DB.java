package ru.dyatlov.model.server;


import ru.dyatlov.model.client.Content;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DB {

    private static List<Content> db= new ArrayList<>();

    public DB(){
    }

    public static void add(String title, String author,String preview, String authorLogo, Boolean anonymous){
        db.add(new Content(db.size(),title, author, preview, authorLogo, anonymous));
    }

    public static void delete(int id){
        db.remove(id);
    }

    public static Content getElementById(int id){
        return db.get(id);
    }

    public static List<Content> getDB() {
        return db;
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
