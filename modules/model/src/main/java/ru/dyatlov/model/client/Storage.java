package ru.dyatlov.model.client;

import ru.dyatlov.model.server.DB;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    public void delete(int id){
        DB.delete(id);
    }
    public void add(String title, String author,String preview, String authorLogo, Boolean anonymous){
        DB.add(title,author,preview,authorLogo, anonymous);
    }
    public Content getElementById(int id){
        return DB.getElementById(id);
    }

    public List<Content> getRecords(){
        return DB.getDB();
    }
    public String getRecordsInString(){
        return DB.getDBInString();
    }
}
