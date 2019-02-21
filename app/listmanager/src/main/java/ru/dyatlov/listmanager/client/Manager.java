package ru.dyatlov.listmanager.client;

import ru.dyatlov.listmanager.client.service.ManagerService;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import ru.dyatlov.model.client.TakeTable;
import ru.dyatlov.listmanager.client.ui.Table;

public class Manager implements EntryPoint {

    public void onModuleLoad() {

            Table table = new Table();
            RootPanel.get("deleteButton").add(table);

    }

//    private static class ManagerAsyncCallback implements AsyncCallback<String> {
//        private Label label;
//
//        ManagerAsyncCallback(Label label) {
//            this.label = label;
//        }
//
//        public void onSuccess(String result) {
//            label.getElement().setInnerHTML(result);
//        }
//
//        public void onFailure(Throwable throwable) {
//            label.setText("Failed to receive answer from ru.dyatlov.listmanager.server!");
//        }
//    }
}
