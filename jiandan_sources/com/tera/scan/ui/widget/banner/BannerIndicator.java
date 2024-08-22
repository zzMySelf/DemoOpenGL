package com.tera.scan.ui.widget.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.tera.scan.app.R$styleable;
import fe.mmm.qw.j.o;

public class BannerIndicator extends RecyclerView {
    public int mCurPos;
    public ad mIndicatorAdapter;
    public int mItemMargin;
    public Drawable mSelectedDrawable;
    public int mSize;
    public Drawable mUnselectedDrawable;

    public class ad extends RecyclerView.Adapter {

        public class qw extends RecyclerView.ViewHolder {
            public qw(ad adVar, View view) {
                super(view);
            }
        }

        public ad() {
        }

        public int getItemCount() {
            return BannerIndicator.this.mSize;
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i2) {
            ((ImageView) viewHolder.itemView).setImageDrawable(BannerIndicator.this.mCurPos == i2 ? BannerIndicator.this.mSelectedDrawable : BannerIndicator.this.mUnselectedDrawable);
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            ImageView imageView = new ImageView(BannerIndicator.this.getContext());
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-2, -2);
            layoutParams.setMargins(BannerIndicator.this.mItemMargin, BannerIndicator.this.mItemMargin, BannerIndicator.this.mItemMargin, BannerIndicator.this.mItemMargin);
            imageView.setLayoutParams(layoutParams);
            return new qw(this, imageView);
        }
    }

    public BannerIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BannerIndicator);
        this.mItemMargin = obtainStyledAttributes.getDimensionPixelOffset(0, o.qw(4.0f));
        this.mSelectedDrawable = obtainStyledAttributes.getDrawable(2);
        this.mUnselectedDrawable = obtainStyledAttributes.getDrawable(3);
        obtainStyledAttributes.recycle();
        if (this.mSelectedDrawable == null) {
            this.mSelectedDrawable = getResources().getDrawable(R.drawable.banner_indicator_select_icon);
        }
        if (this.mUnselectedDrawable == null) {
            this.mUnselectedDrawable = getResources().getDrawable(R.drawable.banner_indicator_unselect_icon);
        }
        setLayoutManager(new LinearLayoutManager(context, 0, false));
        ad adVar = new ad();
        this.mIndicatorAdapter = adVar;
        setAdapter(adVar);
    }

    public void updatePos(int i2, int i3) {
        this.mCurPos = i2;
        this.mSize = i3;
        if (i2 >= i3) {
            this.mCurPos = 0;
        }
        this.mIndicatorAdapter.notifyDataSetChanged();
    }

    public BannerIndicator(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BannerIndicator(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context, attributeSet);
    }
}
