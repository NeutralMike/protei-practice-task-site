package ru.dyatlov.listmanager.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import ru.dyatlov.listmanager.client.service.ManagerService;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.dyatlov.listmanager.client.ui.*;

import java.util.ArrayList;

public class Manager implements EntryPoint {
    private ManagerService managerService = GWT.create(ManagerService.class);

    public void onModuleLoad() {
        ArrayList<String> table = managerService.getDb();
        RootPanel.get().add(new Table());
    }
}
