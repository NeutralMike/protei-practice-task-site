package ru.dyatlov.model.server;


import java.util.ArrayList;
import java.util.Date;
import java.text.*;

public class DB {

    private ArrayList<Content> db= new ArrayList<>();

    public DB(){
        db.add(new Content(0,"SomeTitle", "SomeAuthor", "/images/preview.jpg", "/images/preview.jpg", false));
    }

    public void add(String title, String author,String preview, String authorLogo, Boolean anonymous){
        db.add(new Content(db.size(),title, author, preview, authorLogo, anonymous));
    }

    public void delete(int id){
        db.remove(id);
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
        String created;
        Boolean anonymous;
        Content(int id,String title, String author,String preview, String authorLogo,Boolean anonymous){
            this.author=author;
            this.authorLogo=authorLogo;
            this.id=id;
            this.preview=preview;
            this.title=title;
            this.anonymous=anonymous;
            this.created= new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date());
        }
        private String take(){
            return this.title+"/n" + this.author+"/n" + this.preview +"/n"+this.authorLogo;
        }

    }
}
