package ru.dyatlov.listmanager.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.ArrayList;

public interface ManagerServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
    void getDb(AsyncCallback<String> async);

}