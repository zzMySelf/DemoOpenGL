package com.baidu.searchbox.video.detail.plugin.component.right.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.ui.TouchStateListener;
import com.baidu.searchbox.video.detail.business.R;
import com.baidu.searchbox.video.detail.export.IVideoApkUtils;
import com.baidu.searchbox.video.detail.export.IVideoAppConfig;
import com.baidu.searchbox.video.detail.export.IVideoDownloadDialogUtils;
import com.baidu.searchbox.video.detail.export.IVideoSafeUrlManager;
import com.facebook.drawee.view.SimpleDraweeView;

public class VideoDetailDownloadView extends RelativeLayout implements View.OnClickListener {
    private static final boolean DEBUG = IVideoAppConfig.Impl.get().isDebug();
    private static final String TAG = "VideoDetailDownloadView";
    private AppInfo mAppInfo;
    private boolean mClickIntercept;
    private Context mContext;
    private TextView mDesc;
    private TextView mDownloadOpen;
    private SimpleDraweeView mIcon;
    private TextView mName;

    public static class AppInfo {
        public String appDesc;
        public String appIcon;
        public String appName;
        public String appPkgName;
        public String appPkgUrl;
        public String authorId;
    }

    public VideoDetailDownloadView(Context context) {
        this(context, (AttributeSet) null);
    }

    public VideoDetailDownloadView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VideoDetailDownloadView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private VideoDetailDownloadView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.video_detail_download_view_cmpnt, this, true);
        this.mIcon = (SimpleDraweeView) findViewById(R.id.app_download_icon);
        this.mName = (TextView) findViewById(R.id.app_download_name);
        this.mDesc = (TextView) findViewById(R.id.app_downlaod_desc);
        TextView textView = (TextView) findViewById(R.id.app_download_open);
        this.mDownloadOpen = textView;
        textView.setOnTouchListener(new TouchStateListener());
        updateUI();
    }

    public void setDownloadOpenBtnVisible(boolean visible) {
        this.mDownloadOpen.setVisibility(visible ? 0 : 8);
    }

    public void setClickIntercept(boolean clickIntercept) {
        this.mClickIntercept = clickIntercept;
    }

    public void updateTeenModeUI() {
        setBackground((Drawable) null);
        setClickIntercept(true);
        setDownloadOpenBtnVisible(false);
    }

    public void setData(AppInfo appInfo) {
        this.mAppInfo = appInfo;
        if (appInfo == null) {
            setVisibility(8);
            return;
        }
        this.mIcon.setImageURI(appInfo.appIcon);
        this.mName.setText(this.mAppInfo.appName);
        this.mDesc.setText(this.mAppInfo.appDesc);
        if (IVideoApkUtils.Impl.get().hasInstalled(this.mContext, this.mAppInfo.appPkgName)) {
            this.mDownloadOpen.setText(getResources().getString(com.baidu.android.common.ui.style.R.string.contextmenu_openlink));
        } else {
            this.mDownloadOpen.setText(getResources().getString(R.string.app_download_description_postfix));
        }
        setOnClickListener(this);
        this.mDownloadOpen.setOnClickListener(this);
    }

    public void updateUI() {
        setBackground(ContextCompat.getDrawable(getContext(), com.baidu.searchbox.feed.core.R.drawable.feed_item_bg_cu));
        this.mName.setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC1));
        this.mDesc.setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC4));
        this.mDownloadOpen.setTextColor(getResources().getColor(com.baidu.android.common.ui.style.R.color.GC68));
        this.mDownloadOpen.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.video_detail_author_open_app_btn_bg));
    }

    public void onClick(View v) {
        if (!this.mClickIntercept) {
            if (this.mAppInfo == null) {
                if (DEBUG) {
                    Log.w(TAG, "mAppInfo is null");
                }
            } else if (IVideoApkUtils.Impl.get().hasInstalled(this.mContext, this.mAppInfo.appPkgName)) {
                IVideoSafeUrlManager.Impl.get().startupApp(this.mContext, this.mAppInfo.appPkgName);
            } else if (!TextUtils.isEmpty(this.mAppInfo.appPkgUrl)) {
                IVideoDownloadDialogUtils.Impl.get().handleDownloadWithDialog(this.mContext, this.mAppInfo.appPkgUrl);
            }
        }
    }

    public void invalidateImage() {
        SimpleDraweeView simpleDraweeView = this.mIcon;
        if (simpleDraweeView != null) {
            simpleDraweeView.invalidate();
        }
    }
}
