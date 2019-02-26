package ru.dyatlov.listmanager.client;

import com.google.gwt.core.client.GWT;
import ru.dyatlov.listmanager.client.service.ManagerService;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.dyatlov.listmanager.client.service.ManagerServiceAsync;
import ru.dyatlov.listmanager.client.ui.*;
import ru.dyatlov.model.client.Content;

import java.util.ArrayList;
import java.util.List;

public class Manager implements EntryPoint {

    private ManagerServiceAsync managerService = GWT.create(ManagerService.class);

    public void onModuleLoad() {
        Table table = new Table();
        managerService.addContent("SomeTitle", "SomeAuthor", "/images/preview.jpg", "/images/preview.jpg", false, new AsyncCallback() {
            @Override
            public void onFailure(Throwable throwable) {
                table.setCreatedText("AddWtF");
            }

            @Override
            public void onSuccess(Object o) {
                table.setCreatedText("Added");
            }
        });
        managerService.getContentList(new AsyncCallback<List<Content>>() {
            @Override
            public void onSuccess(List<Content> result) {
                table.setTitleText(result.get(0).getTitle());
            }

            @Override
            public void onFailure(Throwable caught) {
                table.setTitleText("Failed");
            }
        });
        managerService.getMessage("Hi", new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable throwable) {
                table.setAuthorText("Failed msg");
            }

            @Override
            public void onSuccess(String s) {
                table.setAuthorText(s);
            }
        });
        managerService.getContentListInString(new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable throwable) {
                table.setStorage("Failed");
            }

            @Override
            public void onSuccess(String s) {
                table.setStorage(s);
            }
        });
        RootPanel.get().add(table);
    }
}
