package ru.dyatlov.listmanager.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.dyatlov.model.client.Content;

import java.util.ArrayList;
import java.util.List;

@RemoteServiceRelativePath("ManagerService")
public interface ManagerService extends RemoteService {

    String getMessage(String msg);
    List<Content> getContentList();
    String getContentListInString();
    void addContent(String title, String author,String preview, String authorLogo, Boolean anonymous);
}
