package ru.dyatlov.listmanager.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ru.dyatlov.listmanager.client.service.ManagerService;
import ru.dyatlov.model.client.TakeTable;

import java.util.ArrayList;

public class ManagerServiceImpl extends RemoteServiceServlet implements ManagerService {
    private TakeTable table = new TakeTable();
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
    public ArrayList<String> getDB(){
        return table.getDB();
    }
    public void addContent(String title, String author,String preview, String authorLogo, Boolean anonymous){
        table.add(title,author,preview,authorLogo,anonymous);
    }
}