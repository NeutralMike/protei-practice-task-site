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
    @UiField
    Button addButton;
    @UiField
    Button editButton;
    @UiField
    TextBox searchBox;
    @UiField
    Label filterLabel;
    @UiField
    TabBar durationTabBar;

    public Table() {
        initWidget(uiBinder.createAndBindUi(this));
        setClasses();
    }

    public void setClasses(){
        deleteButton.setStyleName("btn btn-danger");
        addButton.setStyleName("btn btn-success");
        editButton.setStyleName("btn btn-primary");
        searchBox.setStyleName("form-control mr-sm-2");
        durationTabBar.setStyleName("custom-range");
    }

    public void setDeleteButtonText(String text){
        deleteButton.setText(text);
    }
    public Button getDeleteButton() {
        return deleteButton;
    }

}