package ru.dyatlov.listmanager.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;

public class LeftSidebar extends Composite{
    interface LeftSidebarUiBinder extends UiBinder<Widget, LeftSidebar> {
    }
    @UiField
    TextBox searchBox;
    @UiField
    Label filterLabel;
    @UiField
    CheckBox anonymousCheckbox;
    @UiField
    Label anonymousLabel;
    @UiField
    ListBox forLB;

    private static LeftSidebarUiBinder uiBinder = GWT.create(LeftSidebarUiBinder.class);

    public LeftSidebar() {
        initWidget(uiBinder.createAndBindUi(this));
        searchBox.setStyleName("form-control mr-sm-2 searchBox");
    }
}