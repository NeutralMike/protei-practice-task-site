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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static ru.dyatlov.listmanager.client.Manager.INSTANCE;

public class Body extends Composite {

    interface TableUiBinder extends UiBinder<Widget, Body> {}
    private static TableUiBinder uiBinder = GWT.create(TableUiBinder.class);

    @UiField
    Button deleteButton;
    @UiField
    Button addButton;
    @UiField
    Panel contentBlockPanel;
    @UiField
    Panel leftSidebarPanel;

    LeftSidebar sidebar = new LeftSidebar();
    ContentBlock contentBlock;
    List<ContentView> contentViewList= new ArrayList<>();

    @UiField
    TextArea storage;

    @UiHandler("deleteButton")
    void clickHandler(ClickEvent e){
        for (ContentView content:
             contentViewList) {
            if(content.isChecked()){
                INSTANCE.deleteRow(Integer.parseInt(content.id));
            }
        }
    }

    public Body() {
        initWidget(uiBinder.createAndBindUi(this));
        setClasses();
        leftSidebarPanel.add(sidebar);
    }

    public void setData(List<Map<String,String>> data){
        contentBlock=new ContentBlock(data);
        contentBlockPanel.add(contentBlock);
        contentViewList=contentBlock.getContentViewList();
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