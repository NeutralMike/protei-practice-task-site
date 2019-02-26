package ru.dyatlov.listmanager.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;

public interface ManagerServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
    void getDB(AsyncCallback<ArrayList<String>> callback);
    void addContent(String title, String author,String preview, String authorLogo, Boolean anonymous,AsyncCallback callback);

}