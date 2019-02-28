package ru.dyatlov.listmanager.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContentBlock extends Composite {
    interface ContentBlockUiBinder extends UiBinder<Widget, ContentBlock> {
    }

    private static ContentBlockUiBinder uiBinder = GWT.create(ContentBlockUiBinder.class);
    @UiField
    HTMLPanel contentBlock;

    List<ContentView> contentViewList = new ArrayList<>();

    public ContentBlock(List<Map<String,String>> data) {
        initWidget(uiBinder.createAndBindUi(this));
        for (Map<String,String> content:
             data) {
            contentViewList.add(new ContentView(content));
            contentBlock.add(contentViewList.get(contentViewList.size()-1));
        }
    }

    public List<ContentView> getContentViewList(){
        return contentViewList;
    }
}