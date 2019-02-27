package ru.dyatlov.listmanager.client;

import com.google.gwt.core.client.GWT;
import ru.dyatlov.listmanager.client.service.ManagerService;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.dyatlov.listmanager.client.service.ManagerServiceAsync;
import ru.dyatlov.listmanager.client.ui.*;

import java.util.List;
import java.util.Map;

public class Manager implements EntryPoint {

    private ManagerServiceAsync managerService = GWT.create(ManagerService.class);

    public void onModuleLoad() {
        Body body = new Body();
        managerService.addContent("some title","sime author","/images/preview.jpg","/images/preview.jpg",false, new AsyncCallback() {
            @Override
            public void onFailure(Throwable throwable) {

            }

            @Override
            public void onSuccess(Object o) {

            }
        });
        managerService.getContentMap(new AsyncCallback<List<Map<String, String>>>() {
            @Override
            public void onFailure(Throwable throwable) {
                body.setStorage("Failed");
            }

            @Override
            public void onSuccess(List<Map<String,String>> data) {
                body.setStorage(data);
                body.drawContentBlock(data);
            }
        });
        RootPanel.get().add(body);
    }
}
