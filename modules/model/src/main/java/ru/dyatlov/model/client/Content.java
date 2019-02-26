package ru.dyatlov.model.client;

import java.io.Serializable;
import java.util.Date;

public class Content implements Serializable {
    private int id;
    private String preview;
    private String title;
    private String author;
    private String authorLogo;
    private Date created;
    private Boolean anonymous;

    public Content(){}

    public Content(int id,String title, String author,String preview, String authorLogo,Boolean anonymous){
        this.id=id;
        this.author=author;
        this.authorLogo=authorLogo;
        this.preview=preview;
        this.title=title;
        this.anonymous=anonymous;
        this.created= new Date();
    }
    public String getInString(){
        return "id:" + id + "\n" + "title:" + title + "\n" + "author:" + author + "\n" +  "preview:" + preview + "\n" +  "authorLogo:" + authorLogo + "\n" + "anonymous:" + anonymous + "\n";
    }

    public void setPreview(String preview){
        this.preview=preview;
    }

    public String getPreview() {
        return preview;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public Boolean getAnonymous() {
        return anonymous;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthorLogo() {
        return authorLogo;
    }

    public void setAuthorLogo(String authorLogo) {
        this.authorLogo = authorLogo;
    }

    public Date getCreated() {
        return created;
    }
}