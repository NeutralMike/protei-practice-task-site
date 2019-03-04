package ru.dyatlov.model.server;


import java.util.ArrayList;
import java.util.HashMap;
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

    public static void edit(int id,String title, String author,String preview, String authorLogo, Boolean anonymous){
        for (Content content:
                db) {
            if(content.getId()==id){
                content.setTitle(title);
                content.setAuthor(author);
                content.setAuthorLogo(authorLogo);
                content.setPreview(preview);
                content.setAnonymous(anonymous);
            }
        }
    }

    public static Map<String, String> getElementById(int id){
        Map<String,String> response = new HashMap<>();
        for (Content content:
                db) {
            if(content.getId()==id){
                response = content.getMap();
            }
        }
        return response;
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
