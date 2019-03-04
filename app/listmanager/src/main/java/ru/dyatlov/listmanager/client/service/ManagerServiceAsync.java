package ru.dyatlov.listmanager.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;
import java.util.Map;

public interface ManagerServiceAsync {
    void getContentMap(AsyncCallback<List<Map<String,String>>> callback);
    void addContent(String title, String author,String preview, String authorLogo, Boolean anonymous,AsyncCallback callback);
    void editContent(int id,String title, String author,String preview, String authorLogo, Boolean anonymous,AsyncCallback callback);
    void deleteContent(int id,AsyncCallback callback);
    void getContentById(int id, AsyncCallback<Map<String,String>> callback);
}