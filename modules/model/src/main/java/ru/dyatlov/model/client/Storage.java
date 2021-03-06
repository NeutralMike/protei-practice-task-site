package ru.dyatlov.model.client;

import ru.dyatlov.model.server.DB;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Storage {

    public void delete(int id){
        DB.delete(id);
    }
    public void add(String title, String author,String preview, String authorLogo, Boolean anonymous){
        DB.add(title,author,preview,authorLogo, anonymous);
    }
    public void edit(int id,String title, String author,String preview, String authorLogo, Boolean anonymous){
        DB.edit(id,title,author,preview,authorLogo, anonymous);
    }
    public Map<String, String> getElementById(int id){
        return DB.getElementById(id);
    }

    public List<Map<String, String>> getRecordsMap(){
        return DB.getMap();
    }
}
