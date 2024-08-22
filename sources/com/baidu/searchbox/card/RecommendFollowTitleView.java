package com.baidu.searchbox.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.notification.NotificationMsgData;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.push.R;
import com.baidu.searchbox.push.mymessagefragment.params.PushAttrs;
import com.baidu.searchbox.push.mymessagefragment.recyclerview.IPushNotifyView;
import java.util.Map;

public class RecommendFollowTitleView extends LinearLayout implements IPushNotifyView<NotificationMsgData> {
    private final Context mContext;
    private final LayoutInflater mInflater;
    private LinearLayout mLlItem;
    private PushAttrs mPushAttrs;
    private View mRootView;
    private TextView mTvRecommendFollows;

    public RecommendFollowTitleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RecommendFollowTitleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RecommendFollowTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        initView();
    }

    private void initView() {
        View inflate = this.mInflater.inflate(R.layout.card_view_recommend_follow_title, this);
        this.mRootView = inflate;
        this.mLlItem = (LinearLayout) inflate.findViewById(R.id.ll_recommend_follows);
        this.mTvRecommendFollows = (TextView) this.mRootView.findViewById(R.id.tv_recommend_follows);
        initTheme();
    }

    public void initTheme() {
        TextView textView;
        Context context = this.mContext;
        if (context != null && (textView = this.mTvRecommendFollows) != null) {
            textView.setTextColor(context.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
            FontSizeTextViewExtKt.setScaledSizeRes(this.mTvRecommendFollows, 0, R.dimen.message_dimens_16dp);
            LinearLayout linearLayout = this.mLlItem;
            if (linearLayout != null) {
                linearLayout.setBackgroundColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC10));
            }
        }
    }

    public View getViewInstance() {
        return this;
    }

    public Class<NotificationMsgData> getDataType() {
        return NotificationMsgData.class;
    }

    public void onSetCommonAttrs(PushAttrs attrs) {
        this.mPushAttrs = attrs;
    }

    public void onBindView(int position, NotificationMsgData data, Map<Integer, Object> map) {
    }

    public void onNightModeChanged() {
        initTheme();
    }
}
