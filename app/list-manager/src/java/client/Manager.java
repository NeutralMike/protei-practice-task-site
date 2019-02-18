package client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class Manager implements EntryPoint {


    public void onModuleLoad() {
        final Button button = new Button("Click me");
        final Label label = new Label();
        button.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                if (label.getText().equals("")) {
                    ManagerService.App.getInstance().getMessage("Hello", new ManagerAsyncCallback(label));
                } else {
                    label.setText("");
                }
            }
        });

        RootPanel.get("slot1").add(button);
        RootPanel.get("slot2").add(label);
    }

    private static class ManagerAsyncCallback implements AsyncCallback<String> {
        private Label label;

        ManagerAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
}
