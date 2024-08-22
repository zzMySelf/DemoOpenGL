package com.baidu.searchbox.ui;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class BdHeaderFooterGridView extends GridView {
    private static final boolean DEBUG = false;
    private static final String TAG = "BdHeaderFooterGridView";
    private ArrayList<FixedViewInfo> mFooterViewInfos = new ArrayList<>();
    private ArrayList<FixedViewInfo> mHeaderViewInfos = new ArrayList<>();
    private ItemClickHandler mItemClickHandler;
    private int mNumColumns = -1;
    /* access modifiers changed from: private */
    public AdapterView.OnItemClickListener mOnItemClickListener;
    /* access modifiers changed from: private */
    public AdapterView.OnItemLongClickListener mOnItemLongClickListener;
    private ListAdapter mOriginalAdapter;
    private int mRowHeight = -1;
    private View mViewForMeasureRowHeight = null;

    private static class FixedViewInfo {
        public Object data;
        public boolean isSelectable;

        /* renamed from: view  reason: collision with root package name */
        public View f2836view;
        public ViewGroup viewContainer;

        private FixedViewInfo() {
        }
    }

    private void initGridView() {
    }

    public BdHeaderFooterGridView(Context context) {
        super(context);
        initGridView();
    }

    public BdHeaderFooterGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initGridView();
    }

    public BdHeaderFooterGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initGridView();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        ListAdapter adapter = getAdapter();
        if (adapter != null && (adapter instanceof HeaderViewGridAdapter)) {
            ((HeaderViewGridAdapter) adapter).setNumColumns(getNumColumnsCompatible());
            ((HeaderViewGridAdapter) adapter).setRowHeight(getRowHeight());
        }
    }

    public void setClipChildren(boolean clipChildren) {
    }

    public void setClipChildrenSupper(boolean clipChildren) {
        super.setClipChildren(false);
    }

    public void addHeaderView(View v) {
        addHeaderView(v, (Object) null, true);
    }

    public void addHeaderView(View v, Object data, boolean isSelectable) {
        ListAdapter adapter = getAdapter();
        if (adapter == null || (adapter instanceof HeaderViewGridAdapter)) {
            ViewGroup.LayoutParams lyp = v.getLayoutParams();
            FixedViewInfo info = new FixedViewInfo();
            FrameLayout fl = new FullWidthFixedViewLayout(getContext());
            if (lyp != null) {
                v.setLayoutParams(new FrameLayout.LayoutParams(lyp.width, lyp.height));
                fl.setLayoutParams(new AbsListView.LayoutParams(lyp.width, lyp.height));
            }
            fl.addView(v);
            info.f2836view = v;
            info.viewContainer = fl;
            info.data = data;
            info.isSelectable = isSelectable;
            this.mHeaderViewInfos.add(info);
            if (adapter != null) {
                ((HeaderViewGridAdapter) adapter).notifyDataSetChanged();
            }
        }
    }

    public void addFooterView(View v) {
        addFooterView(v, (Object) null, true);
    }

    public void addFooterView(View v, Object data, boolean isSelectable) {
        ListAdapter mAdapter = getAdapter();
        if (mAdapter == null || (mAdapter instanceof HeaderViewGridAdapter)) {
            ViewGroup.LayoutParams lyp = v.getLayoutParams();
            FixedViewInfo info = new FixedViewInfo();
            FrameLayout fl = new FullWidthFixedViewLayout(getContext());
            if (lyp != null) {
                v.setLayoutParams(new FrameLayout.LayoutParams(lyp.width, lyp.height));
                fl.setLayoutParams(new AbsListView.LayoutParams(lyp.width, lyp.height));
            }
            fl.addView(v);
            info.f2836view = v;
            info.viewContainer = fl;
            info.data = data;
            info.isSelectable = isSelectable;
            this.mFooterViewInfos.add(info);
            if (mAdapter != null) {
                ((HeaderViewGridAdapter) mAdapter).notifyDataSetChanged();
            }
        }
    }

    public int getHeaderViewCount() {
        return this.mHeaderViewInfos.size();
    }

    public int getFooterViewCount() {
        return this.mFooterViewInfos.size();
    }

    public boolean removeHeaderView(View v) {
        if (this.mHeaderViewInfos.size() <= 0) {
            return false;
        }
        boolean result = false;
        ListAdapter adapter = getAdapter();
        if (adapter != null && ((HeaderViewGridAdapter) adapter).removeHeader(v)) {
            result = true;
        }
        removeFixedViewInfo(v, this.mHeaderViewInfos);
        return result;
    }

    public boolean removeFooterView(View v) {
        if (this.mFooterViewInfos.size() <= 0) {
            return false;
        }
        boolean result = false;
        ListAdapter adapter = getAdapter();
        if (adapter != null && ((HeaderViewGridAdapter) adapter).removeFooter(v)) {
            result = true;
        }
        removeFixedViewInfo(v, this.mFooterViewInfos);
        return result;
    }

    private void removeFixedViewInfo(View v, ArrayList<FixedViewInfo> where) {
        int len = where.size();
        for (int i2 = 0; i2 < len; i2++) {
            if (where.get(i2).f2836view == v) {
                where.remove(i2);
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public int getNumColumnsCompatible() {
        return super.getNumColumns();
    }

    private int getColumnWidthCompatible() {
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getColumnWidth();
        }
        try {
            Field numColumns = GridView.class.getDeclaredField("mColumnWidth");
            numColumns.setAccessible(true);
            return numColumns.getInt(this);
        } catch (NoSuchFieldException e2) {
            Log.e(TAG, "getColumnWidthCompatible error: " + e2);
            return 0;
        } catch (IllegalAccessException e3) {
            Log.e(TAG, "getColumnWidthCompatible error: " + e3);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mViewForMeasureRowHeight = null;
    }

    public void invalidateRowHeight() {
        this.mRowHeight = -1;
    }

    public int getHeaderHeight(int row) {
        if (row >= 0) {
            return this.mHeaderViewInfos.get(row).f2836view.getMeasuredHeight();
        }
        return 0;
    }

    public int getVerticalSpacing() {
        try {
            if (Build.VERSION.SDK_INT >= 16) {
                return super.getVerticalSpacing();
            }
            Field field = GridView.class.getDeclaredField("mVerticalSpacing");
            field.setAccessible(true);
            return field.getInt(this);
        } catch (Exception e2) {
            return 0;
        }
    }

    public int getHorizontalSpacing() {
        try {
            if (Build.VERSION.SDK_INT >= 16) {
                return super.getHorizontalSpacing();
            }
            Field field = GridView.class.getDeclaredField("mHorizontalSpacing");
            field.setAccessible(true);
            return field.getInt(this);
        } catch (Exception e2) {
            return 0;
        }
    }

    public int getRowHeight() {
        int i2 = this.mRowHeight;
        if (i2 > 0) {
            return i2;
        }
        ListAdapter adapter = getAdapter();
        int numColumns = getNumColumnsCompatible();
        if (adapter == null || adapter.getCount() <= (this.mHeaderViewInfos.size() + this.mFooterViewInfos.size()) * numColumns) {
            return -1;
        }
        int mColumnWidth = getColumnWidthCompatible();
        View view2 = getAdapter().getView(this.mHeaderViewInfos.size() * numColumns, this.mViewForMeasureRowHeight, this);
        AbsListView.LayoutParams p = (AbsListView.LayoutParams) view2.getLayoutParams();
        if (p == null) {
            p = new AbsListView.LayoutParams(-1, -2, 0);
            view2.setLayoutParams(p);
        }
        view2.measure(getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(mColumnWidth, 1073741824), 0, p.width), getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, p.height));
        this.mViewForMeasureRowHeight = view2;
        int measuredHeight = view2.getMeasuredHeight();
        this.mRowHeight = measuredHeight;
        return measuredHeight;
    }

    public void tryToScrollToBottomSmoothly() {
        smoothScrollToPositionFromTop(getAdapter().getCount() - 1, 0);
    }

    public void tryToScrollToBottomSmoothly(int duration) {
        smoothScrollToPositionFromTop(getAdapter().getCount() - 1, 0, duration);
    }

    public void setAdapter(ListAdapter adapter) {
        this.mOriginalAdapter = adapter;
        if (this.mHeaderViewInfos.size() > 0 || this.mFooterViewInfos.size() > 0) {
            HeaderViewGridAdapter headerViewGridAdapter = new HeaderViewGridAdapter(this.mHeaderViewInfos, this.mFooterViewInfos, adapter);
            int numColumns = getNumColumnsCompatible();
            if (numColumns > 1) {
                headerViewGridAdapter.setNumColumns(numColumns);
            }
            headerViewGridAdapter.setRowHeight(getRowHeight());
            super.setAdapter(headerViewGridAdapter);
            return;
        }
        super.setAdapter(adapter);
    }

    public ListAdapter getOriginalAdapter() {
        return this.mOriginalAdapter;
    }

    private class FullWidthFixedViewLayout extends FrameLayout {
        public FullWidthFixedViewLayout(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean changed, int left, int top, int right, int bottom) {
            int realLeft = BdHeaderFooterGridView.this.getPaddingLeft() + getPaddingLeft();
            if (realLeft != left) {
                offsetLeftAndRight(realLeft - left);
            }
            super.onLayout(changed, left, top, right, bottom);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((BdHeaderFooterGridView.this.getMeasuredWidth() - BdHeaderFooterGridView.this.getPaddingLeft()) - BdHeaderFooterGridView.this.getPaddingRight(), View.MeasureSpec.getMode(widthMeasureSpec)), heightMeasureSpec);
        }
    }

    public void setNumColumns(int numColumns) {
        super.setNumColumns(numColumns);
        this.mNumColumns = numColumns;
        ListAdapter adapter = getAdapter();
        if (adapter != null && (adapter instanceof HeaderViewGridAdapter)) {
            ((HeaderViewGridAdapter) adapter).setNumColumns(numColumns);
        }
    }

    private static class HeaderViewGridAdapter implements WrapperListAdapter, Filterable {
        static final ArrayList<FixedViewInfo> EMPTY_INFO_LIST = new ArrayList<>();
        private final ListAdapter mAdapter;
        boolean mAreAllFixedViewsSelectable;
        private boolean mCacheFirstHeaderView;
        private boolean mCachePlaceHoldView;
        private final DataSetObservable mDataSetObservable = new DataSetObservable();
        ArrayList<FixedViewInfo> mFooterViewInfos;
        ArrayList<FixedViewInfo> mHeaderViewInfos;
        private final boolean mIsFilterable;
        private int mNumColumns;
        private int mRowHeight;

        public HeaderViewGridAdapter(ArrayList<FixedViewInfo> headerViewInfos, ArrayList<FixedViewInfo> footViewInfos, ListAdapter adapter) {
            boolean z = true;
            this.mNumColumns = 1;
            this.mRowHeight = -1;
            this.mCachePlaceHoldView = true;
            this.mCacheFirstHeaderView = false;
            this.mAdapter = adapter;
            this.mIsFilterable = adapter instanceof Filterable;
            if (headerViewInfos == null) {
                this.mHeaderViewInfos = EMPTY_INFO_LIST;
            } else {
                this.mHeaderViewInfos = headerViewInfos;
            }
            if (footViewInfos == null) {
                this.mFooterViewInfos = EMPTY_INFO_LIST;
            } else {
                this.mFooterViewInfos = footViewInfos;
            }
            this.mAreAllFixedViewsSelectable = (!areAllListInfosSelectable(this.mHeaderViewInfos) || !areAllListInfosSelectable(this.mFooterViewInfos)) ? false : z;
        }

        public void setNumColumns(int numColumns) {
            if (numColumns >= 1 && this.mNumColumns != numColumns) {
                this.mNumColumns = numColumns;
                notifyDataSetChanged();
            }
        }

        public void setRowHeight(int height) {
            this.mRowHeight = height;
        }

        public int getHeadersCount() {
            return this.mHeaderViewInfos.size();
        }

        public int getFootersCount() {
            return this.mFooterViewInfos.size();
        }

        public boolean isEmpty() {
            ListAdapter listAdapter = this.mAdapter;
            return listAdapter == null || listAdapter.isEmpty();
        }

        private boolean areAllListInfosSelectable(ArrayList<FixedViewInfo> infos) {
            if (infos == null) {
                return true;
            }
            Iterator<FixedViewInfo> it = infos.iterator();
            while (it.hasNext()) {
                if (!it.next().isSelectable) {
                    return false;
                }
            }
            return true;
        }

        public boolean removeHeader(View v) {
            int i2 = 0;
            while (true) {
                boolean z = false;
                if (i2 >= this.mHeaderViewInfos.size()) {
                    return false;
                }
                if (this.mHeaderViewInfos.get(i2).f2836view == v) {
                    this.mHeaderViewInfos.remove(i2);
                    if (areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos)) {
                        z = true;
                    }
                    this.mAreAllFixedViewsSelectable = z;
                    this.mDataSetObservable.notifyChanged();
                    return true;
                }
                i2++;
            }
        }

        public boolean removeFooter(View v) {
            int i2 = 0;
            while (true) {
                boolean z = false;
                if (i2 >= this.mFooterViewInfos.size()) {
                    return false;
                }
                if (this.mFooterViewInfos.get(i2).f2836view == v) {
                    this.mFooterViewInfos.remove(i2);
                    if (areAllListInfosSelectable(this.mHeaderViewInfos) && areAllListInfosSelectable(this.mFooterViewInfos)) {
                        z = true;
                    }
                    this.mAreAllFixedViewsSelectable = z;
                    this.mDataSetObservable.notifyChanged();
                    return true;
                }
                i2++;
            }
        }

        public int getCount() {
            if (this.mAdapter != null) {
                return ((getFootersCount() + getHeadersCount()) * this.mNumColumns) + getAdapterAndPlaceHolderCount();
            }
            return (getFootersCount() + getHeadersCount()) * this.mNumColumns;
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.mAdapter;
            return listAdapter == null || (this.mAreAllFixedViewsSelectable && listAdapter.areAllItemsEnabled());
        }

        private int getAdapterAndPlaceHolderCount() {
            return (int) (Math.ceil((double) ((((float) this.mAdapter.getCount()) * 1.0f) / ((float) this.mNumColumns))) * ((double) this.mNumColumns));
        }

        public boolean isEnabled(int position) {
            int headersCount = getHeadersCount();
            int i2 = this.mNumColumns;
            int numHeadersAndPlaceholders = headersCount * i2;
            if (position >= numHeadersAndPlaceholders) {
                int adjPosition = position - numHeadersAndPlaceholders;
                int adapterCount = 0;
                if (this.mAdapter == null || adjPosition >= (adapterCount = getAdapterAndPlaceHolderCount())) {
                    int footerPosition = adjPosition - adapterCount;
                    int i3 = this.mNumColumns;
                    if (footerPosition % i3 != 0 || !this.mFooterViewInfos.get(footerPosition / i3).isSelectable) {
                        return false;
                    }
                    return true;
                } else if (adjPosition >= this.mAdapter.getCount() || !this.mAdapter.isEnabled(adjPosition)) {
                    return false;
                } else {
                    return true;
                }
            } else if (position % i2 != 0 || !this.mHeaderViewInfos.get(position / i2).isSelectable) {
                return false;
            } else {
                return true;
            }
        }

        public Object getItem(int position) {
            int headersCount = getHeadersCount();
            int i2 = this.mNumColumns;
            int numHeadersAndPlaceholders = headersCount * i2;
            if (position >= numHeadersAndPlaceholders) {
                int adjPosition = position - numHeadersAndPlaceholders;
                int adapterCount = 0;
                if (this.mAdapter == null || adjPosition >= (adapterCount = getAdapterAndPlaceHolderCount())) {
                    int footerPosition = adjPosition - adapterCount;
                    if (footerPosition % this.mNumColumns == 0) {
                        return this.mFooterViewInfos.get(footerPosition).data;
                    }
                    return null;
                } else if (adjPosition < this.mAdapter.getCount()) {
                    return this.mAdapter.getItem(adjPosition);
                } else {
                    return null;
                }
            } else if (position % i2 == 0) {
                return this.mHeaderViewInfos.get(position / i2).data;
            } else {
                return null;
            }
        }

        public long getItemId(int position) {
            int adjPosition;
            int numHeadersAndPlaceholders = getHeadersCount() * this.mNumColumns;
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter == null || position < numHeadersAndPlaceholders || (adjPosition = position - numHeadersAndPlaceholders) >= listAdapter.getCount()) {
                return -1;
            }
            return this.mAdapter.getItemId(adjPosition);
        }

        public boolean hasStableIds() {
            ListAdapter listAdapter = this.mAdapter;
            return listAdapter != null && listAdapter.hasStableIds();
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            int headersCount = getHeadersCount();
            int i2 = this.mNumColumns;
            int numHeadersAndPlaceholders = headersCount * i2;
            if (position < numHeadersAndPlaceholders) {
                View headerViewContainer = this.mHeaderViewInfos.get(position / i2).viewContainer;
                if (position % this.mNumColumns == 0) {
                    return headerViewContainer;
                }
                if (convertView == null) {
                    convertView = new View(parent.getContext());
                }
                convertView.setVisibility(4);
                convertView.setMinimumHeight(headerViewContainer.getHeight());
                return convertView;
            }
            int adjPosition = position - numHeadersAndPlaceholders;
            int adapterCount = 0;
            if (this.mAdapter == null || adjPosition >= (adapterCount = getAdapterAndPlaceHolderCount())) {
                int footerPosition = adjPosition - adapterCount;
                if (footerPosition >= getCount()) {
                    return convertView;
                }
                View footViewContainer = this.mFooterViewInfos.get(footerPosition / this.mNumColumns).viewContainer;
                if (position % this.mNumColumns == 0) {
                    return footViewContainer;
                }
                if (convertView == null) {
                    convertView = new View(parent.getContext());
                }
                convertView.setVisibility(4);
                convertView.setMinimumHeight(footViewContainer.getHeight());
                return convertView;
            } else if (adjPosition < this.mAdapter.getCount()) {
                return this.mAdapter.getView(adjPosition, convertView, parent);
            } else {
                if (convertView == null) {
                    convertView = new View(parent.getContext());
                }
                convertView.setVisibility(4);
                convertView.setMinimumHeight(this.mRowHeight);
                return convertView;
            }
        }

        public int getItemViewType(int position) {
            int footerPosition;
            int numHeadersAndPlaceholders = getHeadersCount() * this.mNumColumns;
            ListAdapter listAdapter = this.mAdapter;
            int adapterViewTypeStart = listAdapter == null ? 0 : listAdapter.getViewTypeCount() - 1;
            int type = -2;
            if (this.mCachePlaceHoldView && position < numHeadersAndPlaceholders) {
                if (position == 0 && this.mCacheFirstHeaderView) {
                    type = this.mHeaderViewInfos.size() + adapterViewTypeStart + this.mFooterViewInfos.size() + 1 + 1;
                }
                int i2 = this.mNumColumns;
                if (position % i2 != 0) {
                    type = adapterViewTypeStart + (position / i2) + 1;
                }
            }
            int adjPosition = position - numHeadersAndPlaceholders;
            int adapterCount = 0;
            if (this.mAdapter != null) {
                adapterCount = getAdapterAndPlaceHolderCount();
                if (adjPosition >= 0 && adjPosition < adapterCount) {
                    if (adjPosition < this.mAdapter.getCount()) {
                        type = this.mAdapter.getItemViewType(adjPosition);
                    } else if (this.mCachePlaceHoldView) {
                        type = this.mHeaderViewInfos.size() + adapterViewTypeStart + 1;
                    }
                }
            }
            if (!this.mCachePlaceHoldView || (footerPosition = adjPosition - adapterCount) < 0 || footerPosition >= getCount() || footerPosition % this.mNumColumns == 0) {
                return type;
            }
            return this.mHeaderViewInfos.size() + adapterViewTypeStart + 1 + (footerPosition / this.mNumColumns) + 1;
        }

        public int getViewTypeCount() {
            ListAdapter listAdapter = this.mAdapter;
            int count = listAdapter == null ? 1 : listAdapter.getViewTypeCount();
            if (!this.mCachePlaceHoldView) {
                return count;
            }
            int offset = this.mHeaderViewInfos.size() + 1 + this.mFooterViewInfos.size();
            if (this.mCacheFirstHeaderView) {
                offset++;
            }
            return count + offset;
        }

        public void registerDataSetObserver(DataSetObserver observer) {
            this.mDataSetObservable.registerObserver(observer);
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                listAdapter.registerDataSetObserver(observer);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver observer) {
            this.mDataSetObservable.unregisterObserver(observer);
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                listAdapter.unregisterDataSetObserver(observer);
            }
        }

        public Filter getFilter() {
            if (this.mIsFilterable) {
                return ((Filterable) this.mAdapter).getFilter();
            }
            return null;
        }

        public ListAdapter getWrappedAdapter() {
            return this.mAdapter;
        }

        public void notifyDataSetChanged() {
            this.mDataSetObservable.notifyChanged();
        }
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener l) {
        this.mOnItemClickListener = l;
        super.setOnItemClickListener(getItemClickHandler());
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener listener) {
        this.mOnItemLongClickListener = listener;
        super.setOnItemLongClickListener(getItemClickHandler());
    }

    private ItemClickHandler getItemClickHandler() {
        if (this.mItemClickHandler == null) {
            this.mItemClickHandler = new ItemClickHandler();
        }
        return this.mItemClickHandler;
    }

    private class ItemClickHandler implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
        private ItemClickHandler() {
        }

        public void onItemClick(AdapterView<?> parent, View view2, int position, long id) {
            int resPos;
            if (BdHeaderFooterGridView.this.mOnItemClickListener != null && (resPos = position - (BdHeaderFooterGridView.this.getHeaderViewCount() * BdHeaderFooterGridView.this.getNumColumnsCompatible())) >= 0) {
                BdHeaderFooterGridView.this.mOnItemClickListener.onItemClick(parent, view2, resPos, id);
            }
        }

        public boolean onItemLongClick(AdapterView<?> parent, View view2, int position, long id) {
            int resPos;
            if (BdHeaderFooterGridView.this.mOnItemLongClickListener == null || (resPos = position - (BdHeaderFooterGridView.this.getHeaderViewCount() * BdHeaderFooterGridView.this.getNumColumnsCompatible())) < 0) {
                return true;
            }
            BdHeaderFooterGridView.this.mOnItemLongClickListener.onItemLongClick(parent, view2, resPos, id);
            return true;
        }
    }
}
