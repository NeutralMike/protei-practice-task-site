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

public class Manager implements EntryPoint {
    private ManagerServiceAsync managerService = ManagerService.App.getInstance();

    public void onModuleLoad() {
        Table table = new Table();
        managerService.addContent("SomeTitle", "SomeAuthor", "/images/preview.jpg", "/images/preview.jpg", false, new AsyncCallback() {
            @Override
            public void onFailure(Throwable throwable) {
                table.setAuthorText("AddWtF");
            }

            @Override
            public void onSuccess(Object o) {
                table.setAuthorText("Added");
            }
        });
        managerService.getDB(new AsyncCallback<ArrayList<String>>() {
            public void onSuccess(ArrayList<String> result) {
                table.setTitleText("Succes");
            }

            public void onFailure(Throwable caught) {
                table.setTitleText("Failed");
            }
        });
        RootPanel.get().add(table);
    }
}
