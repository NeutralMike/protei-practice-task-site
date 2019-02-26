package ru.dyatlov.listmanager.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ru.dyatlov.listmanager.client.service.ManagerService;
import ru.dyatlov.model.client.Storage;
import ru.dyatlov.model.client.Content;

import java.util.List;

public class ManagerServiceImpl extends RemoteServiceServlet implements ManagerService {
    private Storage storage = new Storage();
    public String getMessage(String msg) {
        return "Client said: \"" + storage.getRecords().get(0).getTitle() + "\"<br>Server answered: \"Hi!\"";
    }
    @Override
    public List<Content> getContentList(){
        return storage.getRecords();
    }
    public String getContentListInString(){ return storage.getRecordsInString();}
    public void addContent(String title, String author,String preview, String authorLogo, Boolean anonymous){
        storage.add(title,author,preview,authorLogo,anonymous);
    }
}