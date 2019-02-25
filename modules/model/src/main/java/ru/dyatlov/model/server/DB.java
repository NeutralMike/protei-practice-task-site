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
        ArrayList<String> result= new ArrayList<String>();
        for(int i=0;i<db.size();i++){
            try {
                result.add(db.get(i).take());
            } catch (Exception e){}
        }
        return result;
    }
    public class Content{
        int id;
        String preview;
        String title;
        String author;
        String authorLogo;
        public Content(int id,String title, String author,String preview, String authorLogo){
            this.author=author;
            this.authorLogo=authorLogo;
            this.id=id;
            this.preview=preview;
            this.title=title;
        }
        public String take(){
            return this.title+"/n" + this.author+"/n" + this.preview +"/n"+this.authorLogo;
        }

    }
}
