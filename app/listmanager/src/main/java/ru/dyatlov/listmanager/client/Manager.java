package ru.dyatlov.listmanager.client;

import com.google.gwt.core.client.GWT;
import ru.dyatlov.listmanager.client.service.ManagerService;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.dyatlov.listmanager.client.service.ManagerServiceAsync;
import ru.dyatlov.listmanager.client.ui.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Manager implements EntryPoint {

    private ManagerServiceAsync managerService = GWT.create(ManagerService.class);
    private List<Map<String,String>> storage = new ArrayList<>();

    public void onModuleLoad() {
        addRow("SomeTitle","SomeAuthor","/images/preview.jpg","/images/preview.jpg",false);
        Body body = new Body();
        managerService.getContentMap(new AsyncCallback<List<Map<String, String>>>() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(List<Map<String,String>> data) {
                body.setStorage(data);
                body.setData(data);
            }
        });
        RootPanel.get().add(body);
    }

    private void addRow(String title, String author,String preview, String authorLogo, Boolean anonymous){
        managerService.addContent(title,author,preview,authorLogo,anonymous, new AsyncCallback() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(Object o) {

            }
        });
    }
}
