package com.tera.scan.widget.customrecyclerview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class IViewHolder extends RecyclerView.ViewHolder {
    public IViewHolder(View view) {
        super(view);
    }

    public final int getIAdapterPosition() {
        return getAdapterPosition() - 2;
    }

    public final long getIItemId() {
        return getItemId();
    }

    public final int getIItemViewType() {
        return getItemViewType();
    }

    public final int getILayoutPosition() {
        return getLayoutPosition() - 2;
    }

    public final int getIOldPosition() {
        return getOldPosition() - 2;
    }

    @Deprecated
    public final int getIPosition() {
        return getPosition() - 2;
    }
}
