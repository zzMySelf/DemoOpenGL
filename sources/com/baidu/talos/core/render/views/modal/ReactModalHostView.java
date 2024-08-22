package com.baidu.talos.core.render.views.modal;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.baidu.searchbox.feed.statistic.FeedStatisticConstants;
import com.baidu.talos.TalosAppRuntimeInit;
import com.baidu.talos.core.context.TalosPageContext;
import com.baidu.talos.core.lifecycle.InstanceLifecycleListener;
import com.baidu.talos.core.render.TalosUIHelper;
import com.baidu.talos.core.render.TalosUIManagerHelper;
import com.baidu.talos.core.render.events.ITalosTouchEventRegister;
import com.baidu.talos.core.render.util.RootViewUtil;
import com.baidu.talos.core.render.views.viewgroup.ReactViewGroup;
import com.baidu.talos.core.util.ViewIDConvertUtil;
import com.baidu.talos.modules.R;
import com.baidu.talos.view.RootView;
import com.facebook.infer.annotation.Assertions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.annotation.Nullable;

public class ReactModalHostView extends ViewGroup implements InstanceLifecycleListener, ITalosTouchEventRegister {
    private String mAnimationType;
    @Nullable
    private ModalDialog mDialog;
    private boolean mHardwareAccelerated;
    private DialogRootViewGroup mHostView;
    private TalosPageContext mInstanceContext;
    private boolean mLifecycleActivity = false;
    /* access modifiers changed from: private */
    @Nullable
    public OnRequestCloseListener mOnRequestCloseListener;
    @Nullable
    private DialogInterface.OnShowListener mOnShowListener;
    private boolean mPropertyRequiresNewDialog;
    private boolean mStatusBarTranslucent;
    private boolean mTransparent;

    public interface OnRequestCloseListener {
        void onRequestClose(DialogInterface dialogInterface);
    }

    public void registeEventType(int type) {
    }

    public void unregisteEventType(int type) {
    }

    public ReactModalHostView(TalosPageContext context) {
        super(context);
        context.addActivityLifecyleListener(this);
        this.mInstanceContext = context;
        this.mHostView = new DialogRootViewGroup(context, this);
    }

    static class ModalDialog extends Dialog {
        private int mAnimationId;

        public ModalDialog(Context context, int themeResId) {
            super(context, themeResId);
        }

        public void setAnimations(int animation) {
            if (getWindow() != null) {
                getWindow().setWindowAnimations(animation);
                this.mAnimationId = animation;
            }
        }

        public void onWindowFocusChanged(boolean hasFocus) {
            Activity dialogContext = (Activity) TalosUIHelper.findContextOfType(getContext(), Activity.class);
            if (dialogContext != null && !dialogContext.isFinishing() && getWindow() != null) {
                getWindow().setWindowAnimations(hasFocus ? this.mAnimationId : R.style.DialogAnimationNon);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismiss();
    }

    public void addView(View child, int index) {
        this.mHostView.addView(child, index);
    }

    public int getChildCount() {
        return this.mHostView.getChildCount();
    }

    public View getChildAt(int index) {
        return this.mHostView.getChildAt(index);
    }

    public void removeView(View child) {
        this.mHostView.removeView(child);
    }

    public void removeViewAt(int index) {
        this.mHostView.removeView(getChildAt(index));
    }

    public void addChildrenForAccessibility(ArrayList<View> arrayList) {
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        return false;
    }

    public void onDropInstance() {
        ((TalosPageContext) getContext()).removeActivityLifecycleListener(this);
        dismiss();
    }

    private void dismiss() {
        Activity dialogContext;
        ModalDialog modalDialog = this.mDialog;
        if (modalDialog != null) {
            if (modalDialog.isShowing() && ((dialogContext = (Activity) TalosUIHelper.findContextOfType(this.mDialog.getContext(), Activity.class)) == null || !dialogContext.isFinishing())) {
                this.mDialog.dismiss();
            }
            this.mDialog = null;
            ((ViewGroup) this.mHostView.getParent()).removeViewAt(0);
        }
    }

    /* access modifiers changed from: protected */
    public void setOnRequestCloseListener(OnRequestCloseListener listener) {
        this.mOnRequestCloseListener = listener;
    }

    /* access modifiers changed from: protected */
    public void setOnShowListener(DialogInterface.OnShowListener listener) {
        this.mOnShowListener = listener;
    }

    /* access modifiers changed from: protected */
    public void setTransparent(boolean transparent) {
        this.mTransparent = transparent;
    }

    /* access modifiers changed from: protected */
    public void setStatusBarTranslucent(boolean statusBarTranslucent) {
        if (this.mStatusBarTranslucent != statusBarTranslucent) {
            this.mStatusBarTranslucent = statusBarTranslucent;
            this.mPropertyRequiresNewDialog = true;
        }
    }

    /* access modifiers changed from: protected */
    public void useLifecycleActivity(boolean lifecycleActivity) {
        if (this.mLifecycleActivity != lifecycleActivity) {
            this.mLifecycleActivity = lifecycleActivity;
            this.mPropertyRequiresNewDialog = true;
        }
    }

    /* access modifiers changed from: protected */
    public void setAnimationType(String animationType) {
        if (!TextUtils.equals(this.mAnimationType, animationType)) {
            this.mAnimationType = animationType;
            this.mPropertyRequiresNewDialog = true;
        }
    }

    /* access modifiers changed from: protected */
    public void setHardwareAccelerated(boolean hardwareAccelerated) {
        if (this.mHardwareAccelerated != hardwareAccelerated) {
            this.mHardwareAccelerated = hardwareAccelerated;
            this.mPropertyRequiresNewDialog = true;
        }
    }

    public void onInstanceResume() {
    }

    public void onInstancePause() {
    }

    public void onInstanceDestroy() {
        onDropInstance();
    }

    @Nullable
    public Dialog getDialog() {
        return this.mDialog;
    }

    /* access modifiers changed from: protected */
    public void showOrUpdate() {
        if (this.mDialog != null) {
            if (this.mPropertyRequiresNewDialog) {
                dismiss();
            } else {
                updateProperties();
                return;
            }
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            this.mPropertyRequiresNewDialog = false;
            ModalDialog modalDialog = new ModalDialog(currentActivity, R.style.Theme_FullScreenDialog);
            this.mDialog = modalDialog;
            modalDialog.setContentView(getContentView());
            updateProperties();
            this.mDialog.setOnShowListener(this.mOnShowListener);
            this.mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    if (event.getAction() != 1) {
                        return false;
                    }
                    if (keyCode == 4) {
                        Assertions.assertNotNull(ReactModalHostView.this.mOnRequestCloseListener, "setOnRequestCloseListener must be called by the manager");
                        ReactModalHostView.this.mOnRequestCloseListener.onRequestClose(dialog);
                        return true;
                    }
                    Activity currentActivity = ReactModalHostView.this.getCurrentActivity();
                    if (currentActivity != null) {
                        return currentActivity.onKeyUp(keyCode, event);
                    }
                    return false;
                }
            });
            if (this.mHardwareAccelerated) {
                this.mDialog.getWindow().addFlags(16777216);
            }
            if (currentActivity != null && !currentActivity.isFinishing()) {
                this.mDialog.setAnimations(getDialogAnimation());
                this.mDialog.show();
            }
        }
    }

    private int getDialogAnimation() {
        int theme = R.style.DialogAnimationNon;
        if (FeedStatisticConstants.UBC_ATTENTION_NEW_TIP_TYPE_FADE.equals(this.mAnimationType)) {
            return R.style.DialogAnimationFade;
        }
        if ("slide".equals(this.mAnimationType)) {
            return R.style.DialogAnimationSlide;
        }
        return theme;
    }

    /* access modifiers changed from: private */
    public Activity getCurrentActivity() {
        if (this.mLifecycleActivity) {
            return TalosAppRuntimeInit.getCurrentActivity();
        }
        return this.mInstanceContext.getHostActivity();
    }

    private View getContentView() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.addView(this.mHostView);
        if (this.mStatusBarTranslucent) {
            frameLayout.setSystemUiVisibility(1024);
        } else {
            frameLayout.setFitsSystemWindows(true);
        }
        return frameLayout;
    }

    private void updateProperties() {
        Assertions.assertNotNull(this.mDialog, "mDialog must exist when we call updateProperties");
        Activity dialogContext = (Activity) TalosUIHelper.findContextOfType(this.mDialog.getContext(), Activity.class);
        if (dialogContext != null && !dialogContext.isFinishing()) {
            if (this.mStatusBarTranslucent) {
                this.mDialog.getWindow().clearFlags(67108864);
                this.mDialog.getWindow().addFlags(Integer.MIN_VALUE);
                this.mDialog.getWindow().setStatusBarColor(0);
            }
            if (this.mTransparent) {
                this.mDialog.getWindow().clearFlags(2);
                return;
            }
            this.mDialog.getWindow().setDimAmount(0.5f);
            this.mDialog.getWindow().setFlags(2, 2);
        }
    }

    static class DialogRootViewGroup extends ReactViewGroup implements RootView {
        private boolean hasAdjustedSize = false;
        private WeakReference<ReactModalHostView> modalHostView = new WeakReference<>((Object) null);
        private int viewHeight;
        private int viewWidth;

        public DialogRootViewGroup(TalosPageContext context, ReactModalHostView hostView) {
            super(context);
            this.modalHostView = new WeakReference<>(hostView);
        }

        /* access modifiers changed from: protected */
        public void onSizeChanged(int w, int h2, int oldw, int oldh) {
            super.onSizeChanged(w, h2, oldw, oldh);
            this.viewWidth = w;
            this.viewHeight = h2;
            updateFirstChildView();
        }

        private void updateFirstChildView() {
            if (getChildCount() > 0) {
                this.hasAdjustedSize = false;
                TalosUIManagerHelper.getRenderImpl((TalosPageContext) getContext()).updateNodeSize(ViewIDConvertUtil.getTalosViewTag(getChildAt(0)), this.viewWidth, this.viewHeight);
                return;
            }
            this.hasAdjustedSize = true;
        }

        public void addView(View child, int index, ViewGroup.LayoutParams params) {
            super.addView(child, index, params);
            if (this.hasAdjustedSize) {
                updateFirstChildView();
            }
        }

        public void requestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }

        public void onAttached() {
        }

        public long getRootId() {
            RootView rootView = RootViewUtil.getRootView((View) this.modalHostView.get());
            if (rootView != null) {
                return rootView.getRootId();
            }
            return -1;
        }
    }
}
