package ru.dyatlov.listmanager.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;

import java.util.ArrayList;
//import java.awt.*;

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
    CheckBox anonymousCheckbox;
    @UiField
    CheckBox done;
    @UiField
    Label anonymousLabel;
    @UiField
    Image authorLogo;
    @UiField
    Label author;
    @UiField
    Image preview;
    @UiField
    Label title;
    @UiField
    ListBox forLB;

    public Table() {
        initWidget(uiBinder.createAndBindUi(this));
        setClasses();
        authorLogo.setUrl("/images/preview.jpg");
        preview.setUrl("/images/preview.jpg");
        title.setText("Title");
        author.setText("Author");
    }


    public void setData(ArrayList<String> data){
        initWidget(uiBinder.createAndBindUi(this));
        setClasses();
        authorLogo.setUrl("/images/preview.jpg");
        preview.setUrl("/images/preview.jpg");
        title.setText("SomeTitle");
        author.setText("Author");
    }

    private void setClasses(){
        deleteButton.setStyleName("btn btn-danger");
        addButton.setStyleName("btn btn-success");
        editButton.setStyleName("btn btn-primary");
        searchBox.setStyleName("form-control mr-sm-2 searchBox");
    }
    public void setTitleText(String text){
        title.setText(text);
    }

}