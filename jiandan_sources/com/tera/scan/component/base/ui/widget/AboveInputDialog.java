package com.tera.scan.component.base.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.aiscan.R;
import com.tera.scan.widget.LengthLimitedEditText;
import fe.mmm.qw.j.Cswitch;
import fe.mmm.qw.th.qw.th.i;

public class AboveInputDialog extends Dialog implements View.OnLayoutChangeListener {
    public static final String EDITTEXT_CONTENT_REGEX = "^[A-Za-z0-9_\\-\\u4e00-\\u9fa5]+$";
    public static final String TAG = "AboveInputDialog";
    public int[] decorViewOutLocation = new int[2];
    public int dialogMinOffset;
    public String inputEditRegex = EDITTEXT_CONTENT_REGEX;
    public InputMethodManager inputMethodManager;
    public Activity mActivity;
    public TextView mCancel;
    public boolean mCancelOutsideTouch = true;
    public ImageView mDelete;
    public LengthLimitedEditText mEditText;
    public TextView mErrorInfo;
    public TextView mInputNumText;
    public i mLoadingDialogHelper;
    public TextView mOk;
    public boolean mOkbuttonControl = false;
    public LinearLayout mRoot;
    public TextView mTitle;
    public int rightTextColor = 0;

    public class ad implements View.OnClickListener {
        public ad() {
        }

        public void onClick(View view) {
            AboveInputDialog.this.mEditText.setText((CharSequence) null);
        }
    }

    public class de implements Runnable {
        public de() {
        }

        public void run() {
            AboveInputDialog aboveInputDialog = AboveInputDialog.this;
            aboveInputDialog.showInputMethod(aboveInputDialog.getEditText());
            AboveInputDialog.this.listenInputMethodStatus();
        }
    }

    public class fe implements TextWatcher {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ int f6843ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ int f6844th;

        public fe(int i2, int i3) {
            this.f6843ad = i2;
            this.f6844th = i3;
        }

        public void afterTextChanged(Editable editable) {
            AboveInputDialog.this.textChangeListener(editable, this.f6843ad, this.f6844th);
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public class qw implements View.OnClickListener {
        public qw() {
        }

        public void onClick(View view) {
            AboveInputDialog.this.dismiss();
        }
    }

    public AboveInputDialog(Context context, Activity activity) {
        super(context, R.style.BaiduNetDiskDialogTheme);
        this.mActivity = activity;
        setContentView(R.layout.dialog_above_input_edit_layout);
        initDialog();
        updateWindow();
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        this.inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        this.mLoadingDialogHelper = new i(activity);
        this.rightTextColor = this.mActivity.getResources().getColor(R.color.ui_color_gc32);
    }

    private void clearInputMethodStatusListener() {
        if (getWindow() != null) {
            getWindow().getDecorView().removeOnLayoutChangeListener(this);
        }
    }

    private void hideInputMethod(EditText editText) {
        this.inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    private void initDialog() {
        this.mRoot = (LinearLayout) findViewById(R.id.ll_root);
        this.mCancel = (TextView) findViewById(R.id.alertdialog_btn_cancel);
        this.mOk = (TextView) findViewById(R.id.alertdialog_btn_confirm1);
        this.mTitle = (TextView) findViewById(R.id.txt_confirmdialog_title);
        this.mEditText = (LengthLimitedEditText) findViewById(R.id.input_edittext);
        ImageView imageView = (ImageView) findViewById(R.id.delete_edit_text);
        this.mDelete = imageView;
        imageView.setVisibility(8);
        this.mInputNumText = (TextView) findViewById(R.id.input_text_num);
        this.mErrorInfo = (TextView) findViewById(R.id.dialog_text_error);
        this.mCancel.setOnClickListener(new qw());
        this.mDelete.setOnClickListener(new ad());
    }

    private boolean isOutOfBounds(Context context, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int scaledWindowTouchSlop = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        Window window = getWindow();
        if (window == null) {
            return true;
        }
        View decorView = window.getDecorView();
        int i2 = -scaledWindowTouchSlop;
        if (x < i2 || y < i2 || x > decorView.getWidth() + scaledWindowTouchSlop || y > decorView.getHeight() + scaledWindowTouchSlop) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void listenInputMethodStatus() {
        if (getWindow() != null) {
            View decorView = getWindow().getDecorView();
            decorView.getLocationOnScreen(this.decorViewOutLocation);
            this.dialogMinOffset = this.decorViewOutLocation[1] / 3;
            decorView.addOnLayoutChangeListener(this);
        }
    }

    private void setNoticeInfo(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            this.mErrorInfo.setVisibility(0);
            this.mErrorInfo.setText(str);
        } else {
            this.mErrorInfo.setVisibility(8);
        }
        if (this.mOkbuttonControl) {
            return;
        }
        if (z) {
            this.mOk.setEnabled(true);
            this.mOk.setAlpha(1.0f);
            return;
        }
        this.mOk.setEnabled(false);
        this.mOk.setAlpha(0.5f);
    }

    /* access modifiers changed from: private */
    public void showInputMethod(EditText editText) {
        this.inputMethodManager.showSoftInput(editText, -1);
    }

    private void updateWindow() {
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = -1;
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.anim_dialog_slide_from_bottom);
        }
    }

    public void dismiss() {
        hideInputMethod(getEditText());
        this.mLoadingDialogHelper.fe();
        super.dismiss();
    }

    public TextView getCancel() {
        return this.mCancel;
    }

    public ImageView getDeleteView() {
        return this.mDelete;
    }

    public LengthLimitedEditText getEditText() {
        return this.mEditText;
    }

    public TextView getErrorInfoView() {
        return this.mErrorInfo;
    }

    public TextView getInputNumTextView() {
        return this.mInputNumText;
    }

    public TextView getOk() {
        return this.mOk;
    }

    public LinearLayout getRootView() {
        return this.mRoot;
    }

    public TextView getTitle() {
        return this.mTitle;
    }

    public void hideSoftKeyboard() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.mEditText.getWindowToken(), 0);
    }

    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int[] iArr = this.decorViewOutLocation;
        int i10 = iArr[1];
        view.getLocationOnScreen(iArr);
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (!this.mCancelOutsideTouch || !isOutOfBounds(getContext(), motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        dismiss();
        return true;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        clearInputMethodStatusListener();
        if (!z || getWindow() == null) {
            hideInputMethod(getEditText());
        } else {
            getWindow().getDecorView().postDelayed(new de(), 100);
        }
    }

    public void setBottomTipsVisible(boolean z) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.above_tips);
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 0 : 4);
        }
    }

    public void setCanCancelOutsideTouch(boolean z) {
        this.mCancelOutsideTouch = z;
    }

    public void setCancelButtonClickListener(View.OnClickListener onClickListener) {
        this.mCancel.setOnClickListener(onClickListener);
    }

    public void setDialogTitle(int i2) {
        this.mTitle.setText(i2);
    }

    public void setEditContent(String str) {
        this.mEditText.setText(str);
        LengthLimitedEditText lengthLimitedEditText = this.mEditText;
        lengthLimitedEditText.setSelection(lengthLimitedEditText.getText().length());
    }

    public void setEditMaxLength(int i2) {
        setEditMaxLength(i2 * 2, 0);
    }

    public void setErrorInfo(int i2) {
        if (i2 != -1) {
            setNoticeInfo(getContext().getResources().getString(i2), false);
        }
    }

    public void setInputEditRegex(String str) {
        this.inputEditRegex = str;
    }

    public AboveInputDialog setOkEnable(boolean z) {
        this.mOkbuttonControl = z;
        return this;
    }

    public void setRightBtnOnClickListener(View.OnClickListener onClickListener) {
        this.mOk.setOnClickListener(onClickListener);
    }

    public void setRightBtnText(int i2) {
        this.mOk.setText(i2);
    }

    public void show() {
        Activity activity = this.mActivity;
        if (activity != null && !activity.isFinishing()) {
            super.show();
            this.mEditText.requestFocus();
        }
    }

    public void switch2LoadingMode() {
        this.mEditText.setEnabled(false);
        this.mEditText.setClickable(false);
        this.mLoadingDialogHelper.rg(R.string.loading);
        this.mCancel.setEnabled(false);
        setCancelable(false);
    }

    public void switch2NormalMode() {
        this.mEditText.setEnabled(true);
        this.mEditText.setClickable(true);
        this.mLoadingDialogHelper.fe();
        this.mCancel.setEnabled(true);
        setCancelable(true);
    }

    public void textChangeListener(Editable editable, int i2, int i3) {
        int qw2 = Cswitch.qw(editable.toString());
        this.mOk.setTextColor(this.rightTextColor);
        if (qw2 <= 0) {
            this.mDelete.setVisibility(8);
            this.mInputNumText.setText(this.mActivity.getResources().getString(R.string.edit_settings_count, new Object[]{0, Integer.valueOf(i2 / 2)}));
            setNoticeInfo((String) null, false);
            return;
        }
        this.mDelete.setVisibility(0);
        this.mInputNumText.setText(this.mActivity.getResources().getString(R.string.edit_settings_count, new Object[]{Integer.valueOf((qw2 + 1) / 2), Integer.valueOf(i2 / 2)}));
        setNoticeInfo((String) null, true);
    }

    public void setDialogTitle(String str) {
        this.mTitle.setText(str);
    }

    public void setEditMaxLength(int i2, int i3) {
        this.mEditText.addTextChangedListener(new fe(i2, i3));
        textChangeListener(this.mEditText.getEditableText(), i2, i3);
    }
}
