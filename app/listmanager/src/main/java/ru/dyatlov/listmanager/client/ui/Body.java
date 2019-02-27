package ru.dyatlov.listmanager.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.*;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
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
    UListElement contentList;
    @UiField
    Panel leftSidebarPanel;

    @UiField
    TextArea storage;

    public Body() {
        initWidget(uiBinder.createAndBindUi(this));
        setClasses();
        LeftSidebar leftSidebar= new LeftSidebar();
        leftSidebarPanel.add(leftSidebar);
    }

    public void drawContentBlock(List<Map<String,String>> data){
        for (Map<String,String>content:
             data) {
            contentList.appendChild(createContent(content));
        }
    }

    private Element createContent(Map<String,String> content){
        ContentView contentView = new ContentView(content);
        Element result = Document.get().createLIElement();
        result.setInnerHTML(contentView.contentViewHTML());
        return result;
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