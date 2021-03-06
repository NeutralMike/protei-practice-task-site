package ru.dyatlov.listmanager.client.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;
import java.util.Map;

@RemoteServiceRelativePath("ManagerService")
public interface ManagerService extends RemoteService {

    List<Map<String, String>> getContentMap();
    void addContent(String title, String author,String preview, String authorLogo, Boolean anonymous);
    void editContent(int id,String title, String author,String preview, String authorLogo, Boolean anonymous);
    void deleteContent(int id);
    Map<String,String> getContentById(int id);
}
