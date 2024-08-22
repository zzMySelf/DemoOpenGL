package com.baidu.searchbox.lockscreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import com.baidu.searchbox.lightbrowser.view.LightBrowserView;
import com.baidu.searchbox.lockscreen.browser.LockScreenBrowserActivity;
import com.baidu.searchbox.lockscreen.contentdetail.presenter.DetailPresenterFactory;
import com.baidu.searchbox.lockscreen.contentdetail.presenter.IContentDetailPresenter;
import com.baidu.searchbox.lockscreen.util.CommonKey;

public class LockScreenContentDetail extends LockScreenBrowserActivity {
    private static final float JUMP_MARGIN_BOTTOM = 22.73f;
    private Button mJumpFeedButton;
    private IContentDetailPresenter mPresenter;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent != null) {
            this.mPresenter = DetailPresenterFactory.createPresenter(intent.getIntExtra(CommonKey.KEY_FROM_SOURCE, 0), this);
        }
        IContentDetailPresenter iContentDetailPresenter = this.mPresenter;
        if (iContentDetailPresenter != null) {
            iContentDetailPresenter.onCreate();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IContentDetailPresenter iContentDetailPresenter = this.mPresenter;
        if (iContentDetailPresenter != null) {
            iContentDetailPresenter.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        IContentDetailPresenter iContentDetailPresenter = this.mPresenter;
        if (iContentDetailPresenter != null) {
            iContentDetailPresenter.onNewIntent(intent);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IContentDetailPresenter iContentDetailPresenter = this.mPresenter;
        if (iContentDetailPresenter != null) {
            iContentDetailPresenter.onAttachedToWindow();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        IContentDetailPresenter iContentDetailPresenter = this.mPresenter;
        if (iContentDetailPresenter != null) {
            iContentDetailPresenter.onPause();
        }
    }

    public void finish() {
        super.finish();
        IContentDetailPresenter iContentDetailPresenter = this.mPresenter;
        if (iContentDetailPresenter != null) {
            iContentDetailPresenter.finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        IContentDetailPresenter iContentDetailPresenter = this.mPresenter;
        if (iContentDetailPresenter != null) {
            iContentDetailPresenter.onDestroy();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        IContentDetailPresenter iContentDetailPresenter = this.mPresenter;
        if (iContentDetailPresenter == null || iContentDetailPresenter.processKeyCode(event.getKeyCode())) {
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        IContentDetailPresenter iContentDetailPresenter = this.mPresenter;
        if (iContentDetailPresenter == null || iContentDetailPresenter.processKeyCode(keyCode)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void onLoadSuccess() {
        super.onLoadSuccess();
        IContentDetailPresenter iContentDetailPresenter = this.mPresenter;
        if (iContentDetailPresenter != null) {
            iContentDetailPresenter.onLoadSuccess();
        }
    }

    public void onLoadFailure() {
        super.onLoadFailure();
        IContentDetailPresenter iContentDetailPresenter = this.mPresenter;
        if (iContentDetailPresenter != null) {
            iContentDetailPresenter.onLoadFailure();
        }
    }

    public boolean handleUpdateFavorUI(String favorData) {
        IContentDetailPresenter iContentDetailPresenter = this.mPresenter;
        if (iContentDetailPresenter == null) {
            return super.handleUpdateFavorUI(favorData);
        }
        iContentDetailPresenter.updateStarUI(favorData);
        return true;
    }

    public LightBrowserView getLightBrowserView() {
        return getBrowserView();
    }

    public void updateBrowserShareData(String options) {
        getBrowserContainer().m20691lambda$notifyPageFinished$0$combaidusearchboxlightbrowsercontainerLightBrowserContainer(options);
    }

    public LockScreenActionBar getLockScreenActionBar() {
        return this.mLockScreenActionBar;
    }
}
