package ru.dyatlov.listmanager.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;

import java.util.Map;

import static ru.dyatlov.listmanager.client.Manager.INSTANCE;

public class EditBlock extends Composite {
    interface EditUiBinder extends UiBinder<Widget, EditBlock> {
    }

    private static EditUiBinder uiBinder = GWT.create(EditUiBinder.class);

    int id;
    @UiField
    TextBox title;
    @UiField
    TextBox author;
    @UiField
    TextBox preview;
    @UiField
    TextBox authorLogo;
    @UiField
    CheckBox anonymous;
    @UiField
    SubmitButton submitButton;
    @UiField
    Button cancelButton;

    @UiHandler("cancelButton")
    void cancleClick(ClickEvent e){
        INSTANCE.updateData();
    }

    @UiHandler("submitButton")
    void editClick(ClickEvent e){
        INSTANCE.editRow(id,title.getText(),author.getText(),preview.getText(),authorLogo.getText(),anonymous.getValue());
    }

    public EditBlock(){
        initWidget(uiBinder.createAndBindUi(this));
        title.setStyleName("form-control mr-sm-2");
        author.setStyleName("form-control mr-sm-2");
        preview.setStyleName("form-control mr-sm-2");
        authorLogo.setStyleName("form-control mr-sm-2");
        submitButton.setStyleName("btn btn-primary");
        cancelButton.setStyleName("btn btn-danger");
    }

    public void setData(Map<String,String> content) {
        title.setText(content.get("title"));
        author.setText(content.get("author"));
        preview.setText(content.get("preview"));
        authorLogo.setText(content.get("authorLogo"));
        anonymous.setValue(Boolean.parseBoolean(content.get("anonymous")));
        id = Integer.parseInt(content.get("id"));
    }
}