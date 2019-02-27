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
        managerService.getContentMap(new AsyncCallback<List<Map<String, String>>>() {
            @Override
            public void onFailure(Throwable throwable) {
                body.setStorage("Failed");
            }

            @Override
            public void onSuccess(List<Map<String,String>> s) {
                body.setStorage(s);
            }
        });
        RootPanel.get().add(body);
    }
}
