package ru.dyatlov.listmanager.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

import java.util.Map;

public class ContentView extends Composite {
    interface ContentUiBinder extends UiBinder<Widget, ContentView> {
    }

    @UiField
    HTMLPanel contentView;
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
    private static ContentUiBinder uiBinder = GWT.create(ContentUiBinder.class);

    public ContentView() {
        initWidget(uiBinder.createAndBindUi(this));
        editButton.setStyleName("btn btn-primary");
        contentView.setStyleName("list-group-item list-group-item-action");
    }
    public ContentView(Map<String,String> content){
        initWidget(uiBinder.createAndBindUi(this));
        authorLogo.setUrl(content.get("authorLogo"));
        preview.setUrl(content.get("preview"));
        title.setText(content.get("title"));
        author.setText(content.get("author"));
        created.setText(content.get("created"));
        editButton.setStyleName("btn btn-primary");
        contentView.setStyleName("list-group-item list-group-item-action");
    }
    public String contentViewHTML(){
        return contentView.toString();
    }
}