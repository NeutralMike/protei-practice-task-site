package ru.dyatlov.listmanager.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import ru.dyatlov.listmanager.client.service.ManagerService;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.dyatlov.listmanager.client.service.ManagerServiceAsync;
import ru.dyatlov.listmanager.client.ui.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager implements EntryPoint {

    public static final Manager INSTANCE=  new Manager();

    private ManagerServiceAsync managerService = GWT.create(ManagerService.class);
    Body body = new Body();

    public void onModuleLoad() {
//        addRow("SomeTitle","SomeAuthor","/images/preview.jpg","/images/preview.jpg",false);
        updateData();
        RootPanel.get().add(body);
    }


    public void showEditBlock(int id) {
        managerService.getContentById(id, new AsyncCallback<Map<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                Window.alert("Failed to ger row");
            }

            @Override
            public void onSuccess(Map<String, String> stringStringMap) {
                body.showEditBlock(stringStringMap);
            }
        });
    }

    public void addRow(String title, String author,String preview, String authorLogo, Boolean anonymous){
        managerService.addContent(title,author,preview,authorLogo,anonymous, new AsyncCallback() {
            @Override
            public void onFailure(Throwable throwable) {
                Window.alert("ErrorAddRow");
            }

            @Override
            public void onSuccess(Object o) {
                updateData();
            }
        });
    }
    public void deleteRow(int id){
        managerService.deleteContent(id, new AsyncCallback() {
            @Override
            public void onFailure(Throwable throwable) {
                Window.alert("ErrorDeleteRow");
            }

            @Override
            public void onSuccess(Object o) {
                updateData();
            }
        });
    }
    public void updateData(){
        managerService.getContentMap(new AsyncCallback<List<Map<String, String>>>() {
            @Override
            public void onFailure(Throwable throwable) {
                Window.alert("ErrorUpdateData");
            }

            @Override
            public void onSuccess(List<Map<String,String>> data) {
                body.setStorage(data);
                body.setData(data);
                RootPanel.get().clear();
                RootPanel.get().add(body);
            }
        });
    }
}
