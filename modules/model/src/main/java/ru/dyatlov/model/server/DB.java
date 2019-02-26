package ru.dyatlov.model.server;

import java.util.ArrayList;

public class DB {

    ArrayList<Content> db;

    public void add(String title, String author,String preview, String authorLogo){
        db.add(new Content(db.size(),title, author, preview, authorLogo));
    }

    public String getElementById(int id){
        return db.get(id).take();
    }

    public ArrayList<String> getDB(){
        ArrayList<String> result= new ArrayList<>();
        for(Content content:db){
            try {
                result.add(content.take());
            } catch (Exception e){result.add("Can't take content!");}
        }
        return result;
    }
    public class Content{
        int id;
        String preview;
        String title;
        String author;
        String authorLogo;
        private Content(int id,String title, String author,String preview, String authorLogo){
            this.author=author;
            this.authorLogo=authorLogo;
            this.id=id;
            this.preview=preview;
            this.title=title;
        }
        private String take(){
            return this.title+"/n" + this.author+"/n" + this.preview +"/n"+this.authorLogo;
        }

    }
}
