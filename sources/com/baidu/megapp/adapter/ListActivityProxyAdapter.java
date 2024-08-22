package com.baidu.megapp.adapter;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

public interface ListActivityProxyAdapter extends ActivityProxyAdapter {
    ListAdapter proxyGetListAdapter();

    ListView proxyGetListView();

    long proxyGetSelectedItemId();

    int proxyGetSelectedItemPosition();

    void proxyOnListItemClick(ListView listView, View view2, int i2, long j2);

    void proxySetListAdapter(ListAdapter listAdapter);

    void proxySetSelection(int i2);
}
