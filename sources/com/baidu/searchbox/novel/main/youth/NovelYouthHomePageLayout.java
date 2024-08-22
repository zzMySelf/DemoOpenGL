package com.baidu.searchbox.novel.main.youth;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentManager;
import com.baidu.searchbox.novel.R;
import com.baidu.searchbox.novel.main.youth.listener.NovelYouthHomePageCallback;
import com.baidu.searchbox.novel.main.youth.view.NovelYouthPullToRefreshLayout;
import com.baidu.searchbox.noveladapter.concurrent.NovelUiThreadUtilWrapper;
import com.baidu.searchbox.noveladapter.eventbus.ContainerEventRegister;
import com.baidu.searchbox.noveladapter.skin.INovelNightModeChangeListener;
import com.baidu.searchbox.noveladapter.skin.NovelNightModeHelperWrapper;
import com.baidu.searchbox.noveladapter.skin.NovelNightModeUtils;
import com.baidu.searchbox.ui.CommonEmptyView;

public class NovelYouthHomePageLayout extends RelativeLayout implements INovelNightModeChangeListener {
    private View bgView;
    /* access modifiers changed from: private */
    public NovelYouthHomePageCallback callback;
    private CommonEmptyView errorView;
    private Object fontSizeTag = new Object();
    private Object nightModeTag = new Object();
    /* access modifiers changed from: private */
    public NovelYouthPullToRefreshLayout novelYouthPullToRefreshLayout;

    public NovelYouthHomePageLayout(Context context, FragmentManager fragmentManager) {
        super(context);
        setBackgroundColor(NovelNightModeUtils.getColor(R.color.NC507));
        View view2 = new View(context);
        this.bgView = view2;
        view2.setBackground(NovelNightModeUtils.getDrawable(R.drawable.novel_youth_layout_bg));
        addView(this.bgView, new RelativeLayout.LayoutParams(-1, 270));
        CommonEmptyView commonEmptyView = new CommonEmptyView(context);
        this.errorView = commonEmptyView;
        commonEmptyView.setVisibility(8);
        addView(this.errorView, new RelativeLayout.LayoutParams(-1, -1));
        NovelYouthPullToRefreshLayout novelYouthPullToRefreshLayout2 = new NovelYouthPullToRefreshLayout(context, fragmentManager);
        this.novelYouthPullToRefreshLayout = novelYouthPullToRefreshLayout2;
        novelYouthPullToRefreshLayout2.setErrorView(this.errorView);
        addView(this.novelYouthPullToRefreshLayout, new RelativeLayout.LayoutParams(-1, -1));
        this.novelYouthPullToRefreshLayout.setYouthPullToRefreshCallback(new NovelYouthHomePageCallback() {
            public void refreshComplete(boolean success) {
                if (NovelYouthHomePageLayout.this.callback != null) {
                    NovelYouthHomePageLayout.this.callback.refreshComplete(success);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        onNightModeChanged(NovelNightModeUtils.isNightMode());
        onFontSizeChanged();
        NovelNightModeHelperWrapper.subscribeNightModeChangeEvent(this.nightModeTag, this);
        registerFontSizeChangeMessage();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NovelNightModeHelperWrapper.unsubscribeNightModeChangedEvent(this.nightModeTag);
        unRegisterFontSizeChangeMessage();
    }

    private void registerFontSizeChangeMessage() {
        ContainerEventRegister.registerFontSizeChangeEvent(this.fontSizeTag, new ContainerEventRegister.NovelFontSizeMessageEventCallback() {
            public void call(int messageId, Object messageContent) {
                NovelYouthHomePageLayout.this.onFontSizeChanged();
            }
        });
    }

    private void unRegisterFontSizeChangeMessage() {
        ContainerEventRegister.unRegisterFontSizeChangeEvent(this.fontSizeTag);
    }

    public void setCallback(NovelYouthHomePageCallback callback2) {
        this.callback = callback2;
    }

    public void onContentPageAppear() {
        NovelYouthPullToRefreshLayout novelYouthPullToRefreshLayout2 = this.novelYouthPullToRefreshLayout;
        if (novelYouthPullToRefreshLayout2 != null) {
            novelYouthPullToRefreshLayout2.onContentPageAppear();
        }
    }

    public void onContentPageDisAppear() {
        NovelYouthPullToRefreshLayout novelYouthPullToRefreshLayout2 = this.novelYouthPullToRefreshLayout;
        if (novelYouthPullToRefreshLayout2 != null) {
            novelYouthPullToRefreshLayout2.onContentPageDisAppear();
        }
    }

    public void contentPageViewRefresh() {
        if (this.novelYouthPullToRefreshLayout != null) {
            NovelUiThreadUtilWrapper.runOnUiThread(new Runnable() {
                public void run() {
                    NovelYouthHomePageLayout.this.novelYouthPullToRefreshLayout.refreshYouthPage(true);
                }
            });
        }
    }

    public void onDestroy() {
        NovelYouthPullToRefreshLayout novelYouthPullToRefreshLayout2 = this.novelYouthPullToRefreshLayout;
        if (novelYouthPullToRefreshLayout2 != null) {
            novelYouthPullToRefreshLayout2.onDestroy();
        }
    }

    public void onNightModeChanged(boolean isNightMode) {
        NovelYouthPullToRefreshLayout novelYouthPullToRefreshLayout2 = this.novelYouthPullToRefreshLayout;
        if (novelYouthPullToRefreshLayout2 != null) {
            novelYouthPullToRefreshLayout2.onNightModeChanged(isNightMode);
        }
        View view2 = this.bgView;
        if (view2 != null) {
            view2.setBackground(NovelNightModeUtils.getDrawable(R.drawable.novel_youth_layout_bg));
        }
        setBackgroundColor(NovelNightModeUtils.getColor(R.color.NC507));
    }

    /* access modifiers changed from: private */
    public void onFontSizeChanged() {
        NovelYouthPullToRefreshLayout novelYouthPullToRefreshLayout2 = this.novelYouthPullToRefreshLayout;
        if (novelYouthPullToRefreshLayout2 != null) {
            novelYouthPullToRefreshLayout2.onFontSizeChanged();
        }
    }
}
