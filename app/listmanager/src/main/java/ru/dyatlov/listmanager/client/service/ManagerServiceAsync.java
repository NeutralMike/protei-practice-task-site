package ru.dyatlov.listmanager.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.dyatlov.model.client.Content;

import java.util.ArrayList;
import java.util.List;

public interface ManagerServiceAsync {
    void getMessage(String msg, AsyncCallback<String> callback);
    void getContentList(AsyncCallback<List<Content>> callback);
    void getContentListInString(AsyncCallback<String> callback);
    void addContent(String title, String author,String preview, String authorLogo, Boolean anonymous,AsyncCallback callback);

}