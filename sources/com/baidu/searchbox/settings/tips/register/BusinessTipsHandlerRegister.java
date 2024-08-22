package com.baidu.searchbox.settings.tips.register;

import com.baidu.pyramid.annotation.component.DefaultListHolder;
import com.baidu.pyramid.annotation.component.ListHolder;
import com.baidu.searchbox.settings.tips.IBusinessTipsInfoHandler;
import com.baidu.searchbox.settings.tips.IBusinessTipsInfoHandler_BusinessTipsHandlerRegister_ListProvider;
import java.util.ArrayList;
import java.util.List;

public class BusinessTipsHandlerRegister {
    private ListHolder<IBusinessTipsInfoHandler> mBusinessTipsInfoHandler;

    public void initmBusinessTipsInfoHandler() {
        DefaultListHolder create = DefaultListHolder.create();
        this.mBusinessTipsInfoHandler = create;
        create.setList(new IBusinessTipsInfoHandler_BusinessTipsHandlerRegister_ListProvider());
    }

    public BusinessTipsHandlerRegister() {
        initmBusinessTipsInfoHandler();
    }

    public List<IBusinessTipsInfoHandler> getBusinessTipsInfoHandlerList() {
        ListHolder<IBusinessTipsInfoHandler> listHolder = this.mBusinessTipsInfoHandler;
        if (listHolder == null) {
            return new ArrayList();
        }
        return listHolder.getList();
    }
}
