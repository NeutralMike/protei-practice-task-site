package ru.dyatlov.model.server;


import ru.dyatlov.model.client.Content;

import java.util.ArrayList;
import java.util.List;

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
    public static String getDBInString(){
        String result="";
        for (Content content:db) {
            result+=content.getInString();
        }
        return result;
    }
}
