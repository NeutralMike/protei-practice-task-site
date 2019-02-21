package ru.dyatlov.listmanager.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

public class Table extends Composite {

    interface TableUiBinder extends UiBinder<Widget, Table> {}
    private static TableUiBinder uiBinder = GWT.create(TableUiBinder.class);

    @UiField
    Button deleteButton;

    public Table() {
        initWidget(uiBinder.createAndBindUi(this));
        deleteButton.setText("Delete");
    }

    public void setDeleteButtonText(String text){
        deleteButton.setText(text);
    }
    public Button getDeleteButton() {
        return deleteButton;
    }

}