package com.baidu.live.business.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.live.business.util.CommonUtil;
import com.baidu.live.feed.page.R;
import com.baidu.live.framework.utils.ListUtils;
import com.baidu.live.uimode.UIModeUtils;
import java.util.ArrayList;
import java.util.List;

public class LiveFeedPageSubTipAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<LiveTabEntity.TabLabelInfo> mList = new ArrayList();
    /* access modifiers changed from: private */
    public OnItemClickListener mOnItemClickListener;
    private float[] mRadii;
    private String mScene;
    private int selectPos = 0;

    public interface OnItemClickListener {
        void onItemClick(View view2, int i2);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public LiveFeedPageSubTipAdapter(Context context, String scene) {
        this.mContext = context;
        this.mScene = scene;
        this.mInflater = LayoutInflater.from(context);
        float radius = (float) CommonUtil.dip2px(this.mContext, 14.0f);
        this.mRadii = new float[]{radius, radius, radius, radius, radius, radius, radius, radius};
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTxtTag;

        public ViewHolder(View view2) {
            super(view2);
        }
    }

    public int getItemCount() {
        return this.mList.size();
    }

    public int getSelectPos() {
        return this.selectPos;
    }

    public int getPosByType(String subTabType) {
        if (ListUtils.isEmpty(this.mList) || subTabType == null) {
            return -1;
        }
        for (int i2 = 0; i2 < this.mList.size(); i2++) {
            LiveTabEntity.TabLabelInfo labelInfo = this.mList.get(i2);
            if (labelInfo != null && subTabType.equals(labelInfo.type)) {
                return i2;
            }
        }
        return -1;
    }

    public LiveTabEntity.TabLabelInfo getSelectSubTabInfo() {
        return (LiveTabEntity.TabLabelInfo) ListUtils.getItem(this.mList, this.selectPos);
    }

    public void setSelectPos(int selectPos2) {
        this.selectPos = selectPos2;
    }

    public void setSubTabList(List<LiveTabEntity.TabLabelInfo> subTabList, String thirdTabType) {
        if (!ListUtils.isEmpty(subTabList)) {
            List<LiveTabEntity.TabLabelInfo> list = this.mList;
            if (list != null) {
                list.clear();
            } else {
                this.mList = new ArrayList();
            }
            this.mList.addAll(subTabList);
            this.selectPos = 0;
            int defaultSchemePos = 0;
            int defaultServerPos = 0;
            for (int i2 = 0; i2 < this.mList.size(); i2++) {
                LiveTabEntity.TabLabelInfo labelInfo = this.mList.get(i2);
                if (labelInfo != null) {
                    if (!TextUtils.isEmpty(thirdTabType) && defaultSchemePos == 0 && thirdTabType.equals(labelInfo.type)) {
                        defaultSchemePos = i2;
                        LiveFeedPageSdk.liveLog("Scheme指定找到了三级标签 = " + labelInfo.name);
                    }
                    if (labelInfo.selected && defaultServerPos == 0) {
                        defaultServerPos = i2;
                    }
                }
            }
            this.selectPos = defaultSchemePos != 0 ? defaultSchemePos : defaultServerPos;
            notifyDataSetChanged();
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View view2 = this.mInflater.inflate(R.layout.live_feed_page_sub_tag_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view2);
        viewHolder.mTxtTag = (TextView) view2.findViewById(R.id.tv_item);
        return viewHolder;
    }

    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        LiveTabEntity.TabLabelInfo item = (LiveTabEntity.TabLabelInfo) ListUtils.getItem(this.mList, position);
        if (item != null) {
            viewHolder.mTxtTag.setText(item.name);
            if (this.mOnItemClickListener != null) {
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        LiveFeedPageSubTipAdapter.this.mOnItemClickListener.onItemClick(viewHolder.itemView, viewHolder.getLayoutPosition());
                    }
                });
            }
            GradientDrawable mBg = new GradientDrawable();
            mBg.setCornerRadii(this.mRadii);
            if (position == this.selectPos) {
                viewHolder.mTxtTag.setTextColor(UIModeUtils.getInstance().getColor(this.mContext, this.mScene, "color_FF33551"));
                mBg.setColors(new int[]{UIModeUtils.getInstance().getColor(this.mContext, this.mScene, "color_FF33552"), UIModeUtils.getInstance().getColor(this.mContext, this.mScene, "color_FF33552")});
                viewHolder.mTxtTag.setTypeface(Typeface.defaultFromStyle(1));
            } else {
                viewHolder.mTxtTag.setTextColor(UIModeUtils.getInstance().getColor(this.mContext, this.mScene, "color_525252"));
                mBg.setColors(new int[]{UIModeUtils.getInstance().getColor(this.mContext, this.mScene, "color_F5F5F53"), UIModeUtils.getInstance().getColor(this.mContext, this.mScene, "color_F5F5F53")});
                viewHolder.mTxtTag.setTypeface(Typeface.defaultFromStyle(0));
            }
            viewHolder.mTxtTag.setBackgroundDrawable(mBg);
        }
    }

    public void onDestroy() {
        if (!ListUtils.isEmpty(this.mList)) {
            this.mList.clear();
        }
        notifyDataSetChanged();
    }
}
