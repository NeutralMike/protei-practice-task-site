package ru.dyatlov.listmanager.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.*;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

import java.util.List;
import java.util.Map;

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
    CheckBox done;
    @UiField
    Image authorLogo;
    @UiField
    Label author;
    @UiField
    Label created;
    @UiField
    Image preview;
    @UiField
    Label title;
    @UiField
    UListElement contentList;
    @UiField
    LIElement content;
    @UiField
    Panel leftSidebarPanel;

    @UiField
    TextArea storage;

    public Table() {
        initWidget(uiBinder.createAndBindUi(this));
        setClasses();
        authorLogo.setUrl("/images/preview.jpg");
        preview.setUrl("/images/preview.jpg");
        title.setText("Title");
        author.setText("Author");
        created.setText("Created");
        content.getStyle().setDisplay(Style.Display.NONE);
        LeftSidebar leftSidebar= new LeftSidebar();
        leftSidebarPanel.add(leftSidebar);
        contentList.appendChild(createContent());
        contentList.appendChild(createContent());
        contentList.appendChild(createContent());
    }

    private Element createContent(){
        LIElement result = Document.get().createLIElement();
        result.setInnerHTML("Something");
        return result;
    }


    public void setStorage(List<Map<String,String>> data){
        String result="";
        storage.setWidth("200%");
        storage.setHeight("70%");
        for (Map<String,String> content:
                data) {
            result+=content.toString();
            result+="\n";
        }
        storage.setText(result);
    }

    public void setStorage(String data){
        storage.setWidth("200%");
        storage.setHeight("70%");
        storage.setText(data);
    }

    private void setClasses(){
        deleteButton.setStyleName("btn btn-danger");
        addButton.setStyleName("btn btn-success");
        editButton.setStyleName("btn btn-primary");
    }
    public void setTitleText(String text){
        title.setText(text);
    }
    public void setAuthorText(String text){
        author.setText(text);
    }
    public void setCreatedText(String text){
        created.setText(text);
    }

}