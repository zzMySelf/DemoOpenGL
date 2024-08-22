package com.baidu.searchbox.follow.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.follow.FollowActionRequest;
import com.baidu.searchbox.follow.FollowActionResult;
import com.baidu.searchbox.follow.FollowInfoModel;
import com.baidu.searchbox.follow.R;
import com.baidu.searchbox.ui.TouchStateListener;

public class FollowButtonView extends FrameLayout {
    private static final String TAG = "FeedFollowButtonView";
    public static final int TOAST_TYPE_FOLLOW_ERROR = 3;
    public static final int TOAST_TYPE_FOLLOW_SUCCESS = 1;
    public static final int TOAST_TYPE_UNFOLLOW_ERROR = 4;
    public static final int TOAST_TYPE_UNFOLLOW_SUCCESS = 2;
    private Context mContext;
    private TextView mFollowBtn;
    /* access modifiers changed from: private */
    public FollowButtonClickCallback mFollowButtonClickCallback;
    private FollowInfoModel mFollowInfo;
    private ProgressBar mFollowProgressBar;
    /* access modifiers changed from: private */
    public FollowResultCallback mFollowResultCallback;
    private boolean mIsFollowed;
    private ProgressBar mUnFollowProgressBar;

    public interface FollowButtonClickCallback {
        void onClick(Object obj);
    }

    public interface FollowResultCallback {
        void followFailed();

        void followSuccess(boolean z);
    }

    public FollowButtonView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FollowButtonView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FollowButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mIsFollowed = false;
        this.mContext = context;
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.follow_button_layout, this);
        setOnTouchListener(new TouchStateListener());
        this.mFollowBtn = (TextView) findViewById(R.id.follow_button);
        this.mFollowProgressBar = (ProgressBar) findViewById(R.id.follow_progress_bar);
        this.mUnFollowProgressBar = (ProgressBar) findViewById(R.id.unfollow_progress_bar);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (FollowButtonView.this.mFollowButtonClickCallback != null) {
                    FollowButtonView.this.mFollowButtonClickCallback.onClick(this);
                }
                FollowButtonView followButtonView = FollowButtonView.this;
                followButtonView.handleFollow(followButtonView.mFollowResultCallback);
            }
        });
    }

    /* access modifiers changed from: private */
    public void handleFollow(final FollowResultCallback followResultCallback) {
        if (NetWorkUtils.isNetworkConnected(this.mContext)) {
            final boolean isFollowed = isFollowed();
            showProgressBar(isFollowed);
            FollowActionRequest.getFollowAction(getContext(), this.mFollowInfo.type, this.mFollowInfo.thirdId, !isFollowed, this.mFollowInfo.sfrom, this.mFollowInfo.source, "", new FollowActionRequest.FollowActionCallBack() {
                public void onSuccess(FollowActionResult result, int errno) {
                    FollowButtonView.this.dismissProgressBar();
                    FollowButtonView.this.update(!isFollowed);
                    FollowResultCallback followResultCallback = followResultCallback;
                    if (followResultCallback != null) {
                        followResultCallback.followSuccess(!isFollowed);
                    }
                }

                public void onFailure(FollowActionResult result) {
                    FollowButtonView.this.dismissProgressBar();
                    FollowResultCallback followResultCallback = followResultCallback;
                    if (followResultCallback != null) {
                        followResultCallback.followFailed();
                    }
                }
            });
            return;
        }
        showToast(this.mIsFollowed ? 4 : 3);
    }

    public void setFollowResultCallback(FollowResultCallback callback) {
        this.mFollowResultCallback = callback;
    }

    public void setDataAndUpdate(FollowInfoModel model) {
        this.mFollowInfo = model;
        update(model.isFollowed);
    }

    private void showToast(int toastType) {
        int showTextId;
        switch (toastType) {
            case 1:
                showTextId = R.string.follow_add_success;
                break;
            case 2:
                showTextId = R.string.follow_remove_success;
                break;
            case 3:
                showTextId = R.string.follow_add_failure;
                break;
            case 4:
                showTextId = R.string.follow_remove_failure;
                break;
            default:
                showTextId = 0;
                break;
        }
        if (showTextId != 0) {
            UniversalToast.makeText(getContext(), getContext().getResources().getText(showTextId)).showToast();
        }
    }

    public void showProgressBar(boolean isFollowed) {
        this.mFollowBtn.setVisibility(8);
        if (isFollowed) {
            this.mUnFollowProgressBar.setVisibility(0);
            this.mFollowProgressBar.setVisibility(8);
            return;
        }
        this.mUnFollowProgressBar.setVisibility(8);
        this.mFollowProgressBar.setVisibility(0);
    }

    public void dismissProgressBar() {
        this.mFollowBtn.setVisibility(0);
        this.mUnFollowProgressBar.setVisibility(8);
        this.mFollowProgressBar.setVisibility(8);
    }

    public void update(boolean isFollowed) {
        int i2;
        int i3;
        int i4;
        Resources resources = getContext().getResources();
        this.mIsFollowed = isFollowed;
        this.mFollowProgressBar.setIndeterminateDrawable(ResourcesCompat.getDrawable(resources, R.drawable.follow_progress_drawable, (Resources.Theme) null));
        this.mUnFollowProgressBar.setIndeterminateDrawable(ResourcesCompat.getDrawable(resources, R.drawable.unfollow_progress_drawable, (Resources.Theme) null));
        TextView textView = this.mFollowBtn;
        Resources resources2 = getResources();
        if (isFollowed) {
            i2 = R.string.followed;
        } else {
            i2 = R.string.follow;
        }
        textView.setText(resources2.getString(i2));
        TextView textView2 = this.mFollowBtn;
        Resources resources3 = getResources();
        if (isFollowed) {
            i3 = R.color.followed_text_color;
        } else {
            i3 = R.color.follow_text_color;
        }
        textView2.setTextColor(resources3.getColor(i3));
        Resources resources4 = getResources();
        if (isFollowed) {
            i4 = R.drawable.followed_text_bg;
        } else {
            i4 = R.drawable.follow_btn_bg;
        }
        setBackground(ResourcesCompat.getDrawable(resources4, i4, (Resources.Theme) null));
    }

    public boolean isFollowed() {
        return this.mIsFollowed;
    }

    private int toggleColor(String deliverColor, int defaultColor) {
        return getResources().getColor(defaultColor);
    }

    private String getRightText(String textFromServer, Context context, boolean isFollowed) {
        if (!TextUtils.isEmpty(textFromServer)) {
            return textFromServer;
        }
        if (isFollowed) {
            return context.getResources().getString(R.string.followed);
        }
        return context.getResources().getString(R.string.follow);
    }
}
