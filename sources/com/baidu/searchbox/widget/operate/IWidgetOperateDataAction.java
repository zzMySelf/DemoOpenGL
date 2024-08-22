package com.baidu.searchbox.widget.operate;

import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u00072\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007H&J\"\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0001\u0010\n\u001a\u00020\u0003H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\"\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0001\u0010\n\u001a\u00020\u0003H&J\u0012\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\fH&¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/widget/operate/IWidgetOperateDataAction;", "", "combineWidgetOperateData", "Lcom/baidu/searchbox/widget/operate/WidgetOperateList;", "addWidgetOperateList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/widget/operate/WidgetOperate;", "Lkotlin/collections/ArrayList;", "notAddWidgetOperateList", "getWidgetOperateAdded", "widgetOperateList", "getWidgetOperateListArray", "Lcom/baidu/searchbox/widget/operate/WidgetOperateListArray;", "getWidgetOperateNotAdded", "updateWidgetOperateData", "", "widgetOperateListArray", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IWidgetOperateDataAction.kt */
public interface IWidgetOperateDataAction {
    WidgetOperateList combineWidgetOperateData(ArrayList<WidgetOperate> arrayList, ArrayList<WidgetOperate> arrayList2);

    ArrayList<WidgetOperate> getWidgetOperateAdded(WidgetOperateList widgetOperateList);

    WidgetOperateListArray getWidgetOperateListArray();

    ArrayList<WidgetOperate> getWidgetOperateNotAdded(WidgetOperateList widgetOperateList);

    void updateWidgetOperateData(WidgetOperateListArray widgetOperateListArray);
}
