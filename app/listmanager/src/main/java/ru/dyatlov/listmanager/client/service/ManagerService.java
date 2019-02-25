package ru.dyatlov.listmanager.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.ArrayList;

@RemoteServiceRelativePath("ManagerService")
public interface ManagerService extends RemoteService {

    String getMessage(String msg);
    ArrayList<String> getDb();
    public static class App {
        private static ManagerServiceAsync ourInstance = GWT.create(ManagerService.class);

        public static synchronized ManagerServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
