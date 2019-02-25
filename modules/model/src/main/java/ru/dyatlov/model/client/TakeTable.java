package ru.dyatlov.model.client;

import com.google.gwt.user.client.ui.*;
import ru.dyatlov.model.server.DB;

import java.util.ArrayList;

public class TakeTable{
    DB db = new DB();
    public void onModuleLoad() {

    }
    public void add(String title, String author,String preview, String authorLogo){
        db.add(title,author,preview,authorLogo);
    }
    public String getElementById(int id){
        return db.getElementById(id);
    }

    public ArrayList<String> getDB(){
        return db.getDB();
    }
}
