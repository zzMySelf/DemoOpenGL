package com.baidu.search.longpress.manager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.search.longpress.LongPressMenu;
import com.baidu.search.longpress.model.LongPressMenuListItem;
import com.baidu.search.longpress.view.LongPressListItemView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/search/longpress/manager/LongPressListAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "itemClickListener", "Lcom/baidu/search/longpress/LongPressMenu$ItemClickListener;", "listCommonItems", "", "Lcom/baidu/search/longpress/model/LongPressMenuListItem;", "createItemView", "Landroid/view/View;", "position", "", "getCount", "getItem", "getItemId", "", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "setItemClickListener", "", "setListCommonItems", "lib_search_long_press_menu_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LongPressListAdapter.kt */
public final class LongPressListAdapter extends BaseAdapter {
    private Context context;
    /* access modifiers changed from: private */
    public LongPressMenu.ItemClickListener itemClickListener;
    private List<LongPressMenuListItem> listCommonItems;

    public LongPressListAdapter(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final void setListCommonItems(List<LongPressMenuListItem> listCommonItems2) {
        this.listCommonItems = listCommonItems2;
    }

    public int getCount() {
        List<LongPressMenuListItem> list = this.listCommonItems;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public LongPressMenuListItem getItem(int position) {
        List<LongPressMenuListItem> list = this.listCommonItems;
        if (list != null) {
            return list.get(position);
        }
        return null;
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return createItemView(position);
    }

    private final View createItemView(int position) {
        LongPressMenuListItem itemDate = getItem(position);
        if (itemDate == null) {
            return null;
        }
        LongPressListItemView longPressListItemView = new LongPressListItemView(this.context, itemDate, position);
        longPressListItemView.setItemClickListener(new LongPressListAdapter$createItemView$1(this));
        return longPressListItemView;
    }

    public final void setItemClickListener(LongPressMenu.ItemClickListener itemClickListener2) {
        this.itemClickListener = itemClickListener2;
    }
}
