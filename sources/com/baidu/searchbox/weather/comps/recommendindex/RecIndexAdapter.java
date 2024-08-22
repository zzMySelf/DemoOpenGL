package com.baidu.searchbox.weather.comps.recommendindex;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.baidu.searchbox.nacomp.recycler.base.item.ItemAdapter;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.weather.R;

public class RecIndexAdapter extends ItemAdapter<RecIndexAptData, RecIndexComp> {
    public RecIndexAdapter(LifecycleOwner owner) {
        super(owner);
    }

    public RecIndexComp onCreateViewHolder(ViewGroup parent) {
        return new RecIndexComp(getLifecycleOwner(), LayoutInflater.from(parent.getContext()).inflate(R.layout.recommend_index, parent, false));
    }

    public UniqueId getType() {
        return RecIndexAptData.TYPE;
    }
}
