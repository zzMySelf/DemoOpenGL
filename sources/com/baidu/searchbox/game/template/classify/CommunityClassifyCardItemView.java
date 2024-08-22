package com.baidu.searchbox.game.template.classify;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.game.template.R;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

public class CommunityClassifyCardItemView extends RelativeLayout {
    private SimpleDraweeView mAvatarView;
    private Context mContext;
    private TextView mDescView;
    private TextView mTitleView;

    public CommunityClassifyCardItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CommunityClassifyCardItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommunityClassifyCardItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.game_classify_card_item_layout, this);
        this.mAvatarView = (SimpleDraweeView) findViewById(R.id.community_template_author_icon);
        this.mTitleView = (TextView) findViewById(R.id.community_classify_card_item_title);
        this.mDescView = (TextView) findViewById(R.id.community_classify_card_item_desc);
        onNightModeChanged();
    }

    public void update(String avatarUrl, String title, String desc) {
        SimpleDraweeView simpleDraweeView = this.mAvatarView;
        if (simpleDraweeView != null) {
            simpleDraweeView.setImageURI(avatarUrl);
        }
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setText(title);
        }
        TextView textView2 = this.mDescView;
        if (textView2 != null) {
            textView2.setText(desc);
        }
    }

    public void onNightModeChanged() {
        Context context = this.mContext;
        if (context != null) {
            Drawable placeHolderDrawable = context.getApplicationContext().getResources().getDrawable(R.drawable.game_author_placeholder);
            SimpleDraweeView simpleDraweeView = this.mAvatarView;
            if (simpleDraweeView != null) {
                ((GenericDraweeHierarchy) simpleDraweeView.getHierarchy()).setPlaceholderImage(placeHolderDrawable, ScalingUtils.ScaleType.FIT_XY);
                RoundingParams roundingParams = ((GenericDraweeHierarchy) this.mAvatarView.getHierarchy()).getRoundingParams();
                if (roundingParams != null) {
                    roundingParams.setBorderColor(this.mContext.getApplicationContext().getResources().getColor(R.color.community_classify_card_avatar_stroke_color));
                    ((GenericDraweeHierarchy) this.mAvatarView.getHierarchy()).setRoundingParams(roundingParams);
                }
            }
            TextView textView = this.mTitleView;
            if (textView != null) {
                textView.setTextColor(this.mContext.getApplicationContext().getResources().getColor(R.color.community_classify_card_item_title_color));
            }
            TextView textView2 = this.mDescView;
            if (textView2 != null) {
                textView2.setTextColor(this.mContext.getApplicationContext().getResources().getColor(R.color.community_classify_card_item_desc_color));
            }
        }
    }
}
