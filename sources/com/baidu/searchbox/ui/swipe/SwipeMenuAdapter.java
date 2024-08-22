package com.baidu.searchbox.ui.swipe;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.baidu.searchbox.ui.swipe.SwipeMenuListView;
import com.baidu.searchbox.ui.swipe.SwipeMenuView;

public class SwipeMenuAdapter implements WrapperListAdapter, SwipeMenuView.OnSwipeItemClickListener {
    private static final boolean DEBUG = false;
    private static final String TAG = "SwipeMenuAdapter";
    private SwipeMenuContentAdapte mAdapter;
    private Context mContext;
    private SwipeMenuListView.OnMenuItemClickListener onMenuItemClickListener;

    public SwipeMenuAdapter(Context context, ListAdapter adapter) {
        if (adapter instanceof SwipeMenuContentAdapte) {
            this.mAdapter = (SwipeMenuContentAdapte) adapter;
        }
        this.mContext = context;
    }

    public int getCount() {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            return swipeMenuContentAdapte.getCount();
        }
        return 0;
    }

    public Object getItem(int position) {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            return swipeMenuContentAdapte.getItem(position);
        }
        return null;
    }

    public long getItemId(int position) {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            return swipeMenuContentAdapte.getItemId(position);
        }
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            View contentView = this.mAdapter.getView(position, (View) null, parent);
            if (getItemViewType(position) == this.mAdapter.getViewTypeCount()) {
                return contentView;
            }
            SwipeMenu menu = new SwipeMenu(this.mContext);
            menu.setViewType(this.mAdapter.getItemViewType(position));
            createMenu(menu);
            SwipeMenuView menuView = new SwipeMenuView(menu, (SwipeMenuListView) parent);
            menuView.setOnSwipeItemClickListener(this);
            SwipeMenuListView listView = (SwipeMenuListView) parent;
            SwipeMenuLayout layout = new SwipeMenuLayout(contentView, menuView, listView.getCloseInterpolator(), listView.getOpenInterpolator());
            layout.setPosition(position);
            return layout;
        } else if (getItemViewType(position) == this.mAdapter.getViewTypeCount()) {
            return this.mAdapter.getView(position, convertView, parent);
        } else {
            SwipeMenuLayout layout2 = (SwipeMenuLayout) convertView;
            layout2.closeMenu();
            layout2.setPosition(position);
            this.mAdapter.getView(position, layout2.getContentView(), parent);
            return layout2;
        }
    }

    public void createMenu(SwipeMenu menu) {
    }

    public void onItemClick(SwipeMenuView view2, SwipeMenu menu, int index) {
        SwipeMenuListView.OnMenuItemClickListener onMenuItemClickListener2 = this.onMenuItemClickListener;
        if (onMenuItemClickListener2 != null) {
            onMenuItemClickListener2.onMenuItemClick(view2.getPosition(), menu, index);
        }
    }

    public void setOnMenuItemClickListener(SwipeMenuListView.OnMenuItemClickListener onMenuItemClickListener2) {
        this.onMenuItemClickListener = onMenuItemClickListener2;
    }

    public void registerDataSetObserver(DataSetObserver observer) {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            swipeMenuContentAdapte.registerDataSetObserver(observer);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver observer) {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            swipeMenuContentAdapte.unregisterDataSetObserver(observer);
        }
    }

    public boolean areAllItemsEnabled() {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            return swipeMenuContentAdapte.areAllItemsEnabled();
        }
        return true;
    }

    public boolean isEnabled(int position) {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            return swipeMenuContentAdapte.isEnabled(position);
        }
        return true;
    }

    public boolean hasStableIds() {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            return swipeMenuContentAdapte.hasStableIds();
        }
        return false;
    }

    public int getItemViewType(int position) {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte == null) {
            return 0;
        }
        if (!swipeMenuContentAdapte.isCanDelete(position)) {
            return this.mAdapter.getViewTypeCount();
        }
        return this.mAdapter.getItemViewType(position);
    }

    public int getViewTypeCount() {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            return swipeMenuContentAdapte.getViewTypeCount() + 1;
        }
        return 1;
    }

    public boolean isEmpty() {
        SwipeMenuContentAdapte swipeMenuContentAdapte = this.mAdapter;
        if (swipeMenuContentAdapte != null) {
            return swipeMenuContentAdapte.isEmpty();
        }
        return getCount() == 0;
    }

    public ListAdapter getWrappedAdapter() {
        return this.mAdapter;
    }
}
