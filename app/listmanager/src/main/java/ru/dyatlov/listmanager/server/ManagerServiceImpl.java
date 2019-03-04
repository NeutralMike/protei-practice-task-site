package ru.dyatlov.listmanager.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ru.dyatlov.listmanager.client.service.ManagerService;
import ru.dyatlov.model.client.Storage;

import java.util.List;
import java.util.Map;

public class ManagerServiceImpl extends RemoteServiceServlet implements ManagerService {
    private Storage storage = new Storage();
    @Override
    public List<Map<String, String>> getContentMap(){ return storage.getRecordsMap();}
    @Override
    public void addContent(String title, String author,String preview, String authorLogo, Boolean anonymous){
        storage.add(title,author,preview,authorLogo,anonymous);
    }
    @Override
    public void editContent(int id,String title, String author,String preview, String authorLogo, Boolean anonymous){
        storage.edit(id,title,author,preview,authorLogo,anonymous);
    }
    @Override
    public void deleteContent(int id){
        storage.delete(id);
    }
    @Override
    public Map<String,String> getContentById(int id){
        return storage.getElementById(id);
    }
}