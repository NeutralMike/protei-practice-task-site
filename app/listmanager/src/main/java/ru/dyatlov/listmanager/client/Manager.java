package ru.dyatlov.listmanager.client;

import com.google.gwt.core.client.GWT;
import ru.dyatlov.listmanager.client.service.ManagerService;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.dyatlov.listmanager.client.service.ManagerServiceAsync;
import ru.dyatlov.listmanager.client.ui.*;
import ru.dyatlov.model.client.Content;

import java.util.List;
import java.util.Map;

public class Manager implements EntryPoint {

    private ManagerServiceAsync managerService = GWT.create(ManagerService.class);

    public void onModuleLoad() {
        Main main = new Main();
        managerService.addContent("SomeTitle", "SomeAuthor", "/images/preview.jpg", "/images/preview.jpg", false, new AsyncCallback() {
            @Override
            public void onFailure(Throwable throwable) {
                main.setCreatedText("AddWtF");
            }

            @Override
            public void onSuccess(Object o) {
                main.setCreatedText("Added");
            }
        });
        managerService.getContentList(new AsyncCallback<List<Content>>() {
            @Override
            public void onSuccess(List<Content> result) {
                main.setTitleText(result.get(0).getTitle());
            }

            @Override
            public void onFailure(Throwable caught) {
                main.setTitleText("Failed");
            }
        });
        managerService.getMessage("Hi", new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable throwable) {
                main.setAuthorText("Failed msg");
            }

            @Override
            public void onSuccess(String s) {
                main.setAuthorText(s);
            }
        });
        managerService.getContentMap(new AsyncCallback<List<Map<String, String>>>() {
            @Override
            public void onFailure(Throwable throwable) {
                main.setStorage("Failed");
            }

            @Override
            public void onSuccess(List<Map<String,String>> s) {
                main.setStorage(s);
            }
        });
        RootPanel.get().add(main);
    }
}
