package com.baidu.searchbox.feed.template;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.model.FeedItemDataNews;
import com.baidu.searchbox.feed.styles.R;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import java.util.ArrayList;

public class FeedKnowIconsView extends LinearLayout {
    public static final int ICONS_MAX = 4;
    private final float OVERLAP_RATIO;
    private Context mContext;
    private float mPileWidth;
    private ArrayList<String> mUrls;
    private int mViewHeight;

    public FeedKnowIconsView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public FeedKnowIconsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FeedKnowIconsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.OVERLAP_RATIO = 0.14285715f;
        this.mContext = context;
        init();
    }

    private void init() {
        int scaledSizeRes = (int) FontSizeHelper.getScaledSizeRes(0, R.dimen.F_W_X15);
        this.mViewHeight = scaledSizeRes;
        this.mPileWidth = ((float) scaledSizeRes) * 0.14285715f;
        this.mUrls = new ArrayList<>();
    }

    public void update(FeedBaseModel baseModel) {
        if (baseModel != null && baseModel.data != null) {
            this.mViewHeight = (int) FontSizeHelper.getScaledSizeRes(0, R.dimen.F_W_X15);
            FeedItemDataNews itemData = (FeedItemDataNews) baseModel.data;
            if (itemData.avatarList != null && itemData.avatarList.size() >= 4) {
                this.mUrls = itemData.avatarList;
                removeAllViews();
                for (int i2 = 0; i2 < 4; i2++) {
                    FeedDraweeView imageView = new FeedDraweeView(this.mContext);
                    int i3 = this.mViewHeight;
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(i3, i3));
                    RoundingParams roundingParams = RoundingParams.asCircle();
                    roundingParams.setBorderColor(getResources().getColor(R.color.FC18));
                    roundingParams.setBorderWidth(3.0f);
                    ((GenericDraweeHierarchy) imageView.getHierarchy()).setRoundingParams(roundingParams);
                    imageView.asCircle().loadImage(this.mUrls.get(i2), baseModel);
                    addView(imageView);
                }
                requestLayout();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int childCount = getChildCount();
        int width = View.MeasureSpec.getSize(widthMeasureSpec);
        if (childCount > 0) {
            width = (int) (((float) (this.mViewHeight * childCount)) - (((float) (childCount - 1)) * this.mPileWidth));
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(width, widthMode), View.MeasureSpec.makeMeasureSpec(this.mViewHeight, 1073741824));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        int leftOffset = 0;
        int count = getChildCount();
        for (int i2 = 0; i2 < count; i2++) {
            int bottom = this.mViewHeight;
            getChildAt(i2).layout(leftOffset, 0, this.mViewHeight + leftOffset, bottom);
            leftOffset = (int) (((float) (leftOffset + this.mViewHeight)) - this.mPileWidth);
        }
    }
}
