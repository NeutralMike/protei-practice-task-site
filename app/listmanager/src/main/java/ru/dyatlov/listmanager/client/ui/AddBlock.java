package ru.dyatlov.listmanager.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;

import static ru.dyatlov.listmanager.client.Manager.INSTANCE;

public class AddBlock extends Composite {
    interface AddUiBinder extends UiBinder<Widget, AddBlock> {
    }

    private static AddUiBinder uiBinder = GWT.create(AddUiBinder.class);

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
    void addSubmitClick(ClickEvent e){
        INSTANCE.addRow(title.getText(),author.getText(),preview.getText(),authorLogo.getText(),anonymous.getValue());
    }

    public AddBlock() {
        initWidget(uiBinder.createAndBindUi(this));
        title.getElement().setPropertyString("placeholder","Title");
        author.getElement().setPropertyString("placeholder","Author");
        preview.getElement().setPropertyString("placeholder","Preview href");
        authorLogo.getElement().setPropertyString("placeholder","Author logo href");
        title.setStyleName("form-control mr-sm-2");
        author.setStyleName("form-control mr-sm-2");
        preview.setStyleName("form-control mr-sm-2");
        authorLogo.setStyleName("form-control mr-sm-2");
        submitButton.setStyleName("btn btn-success");
        cancelButton.setStyleName("btn btn-danger");
    }
}