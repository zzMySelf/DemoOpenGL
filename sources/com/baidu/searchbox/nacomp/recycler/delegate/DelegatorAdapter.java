package com.baidu.searchbox.nacomp.recycler.delegate;

import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.nacomp.util.CollectionUtils;
import com.baidu.searchbox.nacomp.util.UniqueId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DelegatorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final boolean DEBUG = false;
    private final SparseArray<DelegateAdapter> delegates = new SparseArray<>();
    private List<IAdapterData> itemList = new ArrayList();

    public IAdapterData getItem(int position) {
        List<IAdapterData> list = this.itemList;
        if (list == null) {
            return null;
        }
        return list.get(position);
    }

    public void setItems(List<IAdapterData> items) {
        this.itemList = items;
        notifyDataSetChanged();
    }

    public void put(DelegateAdapter adapter) {
        put(adapter, false);
    }

    public void put(DelegateAdapter adapter, boolean replaceOnConflict) {
        if (adapter != null) {
            UniqueId type = adapter.getType();
            if (this.delegates.get(type.getId()) == null || replaceOnConflict) {
                this.delegates.put(type.getId(), adapter);
            }
        }
    }

    public void putAll(Collection<DelegateAdapter> adapters) {
        if (!CollectionUtils.isEmpty(adapters)) {
            for (DelegateAdapter adapter : adapters) {
                put(adapter);
            }
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        DelegateAdapter adapter = this.delegates.get(viewType);
        if (adapter == null) {
            return null;
        }
        return adapter.onCreateViewHolder(parent);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DelegateAdapter adapter;
        IAdapterData item = getItem(position);
        if (item != null && (adapter = this.delegates.get(item.getType().getId())) != null) {
            adapter.onBindViewHolder(holder, item);
        }
    }

    public int getItemViewType(int position) {
        IAdapterData item = getItem(position);
        if (item != null) {
            return item.getType().getId();
        }
        return 0;
    }

    public int getItemCount() {
        List<IAdapterData> list = this.itemList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
