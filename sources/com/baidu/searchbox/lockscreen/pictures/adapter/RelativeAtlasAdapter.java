package com.baidu.searchbox.lockscreen.pictures.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.lockscreen.base.R;
import com.baidu.searchbox.lockscreen.pictures.listener.ItemClickListener;
import com.baidu.searchbox.lockscreen.pictures.model.AtlasItemPhotoRelative;
import com.baidu.searchbox.lockscreen.pictures.view.RelativeAtlasItemHolder;
import com.baidu.searchbox.lockscreen.util.LockScreenUtil;
import java.util.List;

public class RelativeAtlasAdapter extends RecyclerView.Adapter<RelativeAtlasItemHolder> {
    Context mContext;
    List<AtlasItemPhotoRelative> mDataList;
    /* access modifiers changed from: private */
    public ItemClickListener mItemClickListener;
    LayoutInflater mLayoutInflater;

    public RelativeAtlasAdapter(Context context, List<AtlasItemPhotoRelative> mDataList2) {
        this.mContext = context;
        this.mDataList = mDataList2;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    public RelativeAtlasItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RelativeAtlasItemHolder(this.mLayoutInflater.inflate(R.layout.lockscreen_relative_atlas_item, parent, false));
    }

    public void onBindViewHolder(RelativeAtlasItemHolder holder, final int position) {
        AtlasItemPhotoRelative item = this.mDataList.get(position);
        holder.mItemRootView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RelativeAtlasAdapter.this.mItemClickListener.onClick(v, (View) null, position);
            }
        });
        holder.mTitleTv.setText(item.title);
        LockScreenUtil.loadImage(holder.mIconIv, (Drawable) null, item.image);
    }

    public int getItemCount() {
        List<AtlasItemPhotoRelative> list = this.mDataList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public void setDataList(List<AtlasItemPhotoRelative> mDataList2) {
        this.mDataList = mDataList2;
    }

    public void setOnClickListener(ItemClickListener mOnClickListener) {
        this.mItemClickListener = mOnClickListener;
    }
}
