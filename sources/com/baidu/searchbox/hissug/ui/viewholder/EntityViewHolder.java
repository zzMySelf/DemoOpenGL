package com.baidu.searchbox.hissug.ui.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.searchbox.hissug.R;
import com.baidu.searchbox.hissug.searchable.bean.EntitySuggestion;
import com.baidu.searchbox.hissug.searchable.bean.Suggestion;
import com.baidu.searchbox.hissug.ubc.SugUbc;
import com.baidu.searchbox.hissug.util.SugResourceUtils;
import com.baidu.searchbox.hissug.util.common.HisPageSizeUtilsKt;
import com.baidu.searchbox.hissug.util.common.SugSizeUtilsKt;
import com.facebook.drawee.view.SimpleDraweeView;

public class EntityViewHolder extends SugVH {
    View bgView;
    ImageView btnKuang;
    View clickArea;
    TextView description;
    View item;
    View leftArea;
    SimpleDraweeView netImageView;
    TextView title;

    public EntityViewHolder(View convertView) {
        super(convertView);
        this.title = (TextView) convertView.findViewById(R.id.suggestion_item_title);
        this.description = (TextView) convertView.findViewById(R.id.suggestion_item_description);
        this.netImageView = (SimpleDraweeView) convertView.findViewById(R.id.suggestion_item_icon1);
        this.bgView = convertView.findViewById(R.id.id_sug_item_basic_bg);
        this.item = convertView.findViewById(R.id.suggestion_item_layout);
        this.leftArea = convertView.findViewById(R.id.suggstion_item_texts);
        this.clickArea = convertView.findViewById(R.id.suggestion_item_click_area);
        this.btnKuang = (ImageView) convertView.findViewById(R.id.suggestion_item_btn);
    }

    public void bindHolder(Suggestion data, int position) {
        if (this.mAdapter != null && this.mAdapterContext != null && data != null && (data instanceof EntitySuggestion)) {
            EntitySuggestion suggestion = (EntitySuggestion) data;
            suggestion.mPosInList = position;
            View view2 = this.bgView;
            if (view2 != null) {
                view2.setBackground(this.mAdapterContext.getResources().getDrawable(SugResourceUtils.getSugBg()));
            }
            View view3 = this.item;
            if (view3 != null) {
                view3.setTag(suggestion);
            }
            View view4 = this.leftArea;
            if (view4 != null) {
                view4.setTag(suggestion);
            }
            View view5 = this.clickArea;
            if (view5 != null) {
                view5.setBackground(this.mAdapterContext.getResources().getDrawable(SugResourceUtils.getSugClickAreaBg()));
                this.clickArea.setOnClickListener(this.mAdapter.mItemClickListener);
                this.clickArea.setTag(suggestion);
            }
            if (this.netImageView != null) {
                if (!TextUtils.isEmpty(suggestion.getImage())) {
                    setImageUrl(this.netImageView, suggestion.getImage(), false);
                } else {
                    this.netImageView.setImageURI("");
                }
            }
            TextView textView = this.title;
            if (textView != null) {
                textView.setText(suggestion.getQuery());
                this.title.setTextColor(this.mAdapterContext.getResources().getColor(SugResourceUtils.getSugTitleTextColor()));
                this.title.setTextSize(0, SugSizeUtilsKt.getSugTitleTextSize());
            }
            TextView textView2 = this.description;
            if (textView2 != null) {
                textView2.setText(suggestion.getBrief());
                this.description.setTextColor(this.mAdapterContext.getResources().getColor(SugResourceUtils.getSugInfoTextColor()));
                this.description.setTextSize(0, SugSizeUtilsKt.getSugInfoTextSize());
            }
            ImageView imageView = this.btnKuang;
            if (imageView != null) {
                imageView.setImageDrawable(this.mAdapterContext.getResources().getDrawable(SugResourceUtils.getSugBtnKuangIcon()));
                this.btnKuang.setTag(suggestion);
                this.btnKuang.setOnClickListener(this.mAdapter.mQueryRefineClickListener);
                HisPageSizeUtilsKt.updateSize(this.btnKuang, SugSizeUtilsKt.getUpIconSize(), SugSizeUtilsKt.getUpIconSize());
            }
            SugUbc.ubcDirectSug("entity", "show");
        }
    }
}
