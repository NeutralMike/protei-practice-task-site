package ru.dyatlov.listmanager.client;

import ru.dyatlov.listmanager.client.service.ManagerService;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.dyatlov.model.client.TakeTable;
import ru.dyatlov.listmanager.client.ui.*;

public class Manager implements EntryPoint {

    public void onModuleLoad() {
        RootPanel.get().add(new Table());
    }
}
