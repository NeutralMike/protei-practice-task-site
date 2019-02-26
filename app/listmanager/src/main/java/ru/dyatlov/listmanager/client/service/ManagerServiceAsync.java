package ru.dyatlov.listmanager.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.dyatlov.model.client.Content;

import java.util.List;
import java.util.Map;

public interface ManagerServiceAsync {
    void getMessage(String msg, AsyncCallback<String> callback);
    void getContentList(AsyncCallback<List<Content>> callback);
    void getContentMap(AsyncCallback<List<Map<String,String>>> callback);
    void addContent(String title, String author,String preview, String authorLogo, Boolean anonymous,AsyncCallback callback);

}