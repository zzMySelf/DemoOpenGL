package com.baidu.searchbox.card;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.notification.NotificationMsgData;
import com.baidu.searchbox.message.interactionupgrade.InteractionUpgradeBaseFragment;
import com.baidu.searchbox.push.R;
import com.baidu.searchbox.push.mymessagefragment.params.PushAttrs;
import com.baidu.searchbox.push.mymessagefragment.recyclerview.IPushNotifyView;
import com.baidu.searchbox.ui.CommonEmptyView;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class EmptyWithRecommendFollowView extends LinearLayout implements IPushNotifyView<NotificationMsgData> {
    private static final String SCHEME_MY_FOLLOW = "baiduboxapp://account/open?sortType=4&type=follow&from=inter_square";
    /* access modifiers changed from: private */
    public final Context mContext;
    private CommonEmptyView mEmptyView;
    private final LayoutInflater mInflater;
    private LinearLayout mLlItem;
    private View.OnTouchListener mOnTouchListener;
    private PushAttrs mPushAttrs;
    private View mRootView;
    private TextView mTvGotoMyFollow;

    public EmptyWithRecommendFollowView(Context context) {
        this(context, (AttributeSet) null);
    }

    public EmptyWithRecommendFollowView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EmptyWithRecommendFollowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mOnTouchListener = new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == 1 || event.getAction() == 3) {
                    v.setAlpha(1.0f);
                }
                if (event.getAction() != 0) {
                    return false;
                }
                v.setAlpha(0.2f);
                return false;
            }
        };
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        initView();
    }

    private void initView() {
        View inflate = this.mInflater.inflate(R.layout.card_view_empty_with_recommend_follow, this);
        this.mRootView = inflate;
        this.mLlItem = (LinearLayout) inflate.findViewById(R.id.ll_item);
        this.mEmptyView = (CommonEmptyView) this.mRootView.findViewById(R.id.push_notify_empty);
        this.mTvGotoMyFollow = (TextView) this.mRootView.findViewById(R.id.tv_goto_my_follow);
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
        try {
            JSONObject jsonObject = new JSONObject(data.getMsg().getmExtJson());
            String fragmentName = jsonObject.optString(InteractionUpgradeBaseFragment.KEY_FRAGMENT_NAME, "");
            if (TextUtils.equals(fragmentName, "all")) {
                this.mEmptyView.setIcon(R.drawable.push_notify_empty);
                this.mEmptyView.setTitle(R.string.message_interaction_empty);
            } else if (TextUtils.equals(fragmentName, "follow")) {
                this.mEmptyView.setIcon(R.drawable.push_notify_empty);
                this.mEmptyView.setTitle(R.string.message_follow_empty);
            }
            this.mTvGotoMyFollow.setVisibility(jsonObject.optBoolean(InteractionUpgradeBaseFragment.KEY_FRAGMENT_SHOW_FOLLOW_GUIDE) ? 0 : 8);
            this.mTvGotoMyFollow.setOnTouchListener(this.mOnTouchListener);
            this.mTvGotoMyFollow.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view2) {
                    if (EmptyWithRecommendFollowView.this.mContext != null) {
                        SchemeRouter.invokeSchemeForInner(EmptyWithRecommendFollowView.this.mContext, Uri.parse(EmptyWithRecommendFollowView.SCHEME_MY_FOLLOW));
                    }
                }
            });
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void onNightModeChanged() {
        LinearLayout linearLayout = this.mLlItem;
        if (linearLayout != null) {
            linearLayout.setBackgroundColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.GC10));
        }
        TextView textView = this.mTvGotoMyFollow;
        if (textView != null) {
            textView.setTextColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.BC60));
            ((GradientDrawable) this.mTvGotoMyFollow.getBackground()).setColor(this.mContext.getResources().getColor(com.baidu.android.common.ui.style.R.color.BC59));
        }
    }
}
