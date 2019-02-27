package ru.dyatlov.listmanager.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.*;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;

import java.util.List;
import java.util.Map;

public class Body extends Composite {

    interface TableUiBinder extends UiBinder<Widget, Body> {}
    private static TableUiBinder uiBinder = GWT.create(TableUiBinder.class);

    @UiField
    Button deleteButton;
    @UiField
    Button addButton;
    @UiField
    Panel contentBlock;
    @UiField
    Panel leftSidebarPanel;

    @UiField
    TextArea storage;

    @UiHandler("deleteButton")
    void clickHandler(ClickEvent e){
        for(int i=0;i<contentBlock.getElement().getFirstChild().getChildCount();i++){

        }

    }

    public Body() {
        initWidget(uiBinder.createAndBindUi(this));
        setClasses();
        leftSidebarPanel.add(new LeftSidebar());
    }

    public void setData(List<Map<String,String>> data){
        contentBlock.add(new ContentBlock(data));
    }

    public void setStorage(List<Map<String,String>> data){
        String result="";
        for (Map<String,String> content:
                data) {
            result+=content.toString();
            result+="\n";
        }
        storage.setText(result);
    }

    public void setStorage(String data){
        storage.setText(data);
    }

    private void setClasses(){
        deleteButton.setStyleName("btn btn-danger");
        addButton.setStyleName("btn btn-success");
        storage.setWidth("200%");
        storage.setHeight("70%");
    }

}