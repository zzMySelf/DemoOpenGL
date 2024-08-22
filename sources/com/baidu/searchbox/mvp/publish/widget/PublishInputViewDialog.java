package com.baidu.searchbox.mvp.publish.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.publishercomponent.R;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ugc.utils.ToastUtil;
import com.baidu.searchbox.ugc.utils.UiBaseUtils;
import com.baidu.spswitch.utils.SoftInputUtil;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 :2\u00020\u0001:\u0002:;B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020%H\u0002J\u0010\u0010'\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010\u000eJ\b\u0010)\u001a\u00020%H\u0002J\b\u0010*\u001a\u00020%H\u0016J\b\u0010+\u001a\u00020\u0006H\u0002J\b\u0010,\u001a\u00020%H\u0002J\b\u0010-\u001a\u00020%H\u0002J\u0012\u0010.\u001a\u00020%2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\u0012\u00101\u001a\u00020%2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0006\u00104\u001a\u00020%J\u000e\u00105\u001a\u00020%2\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u00106\u001a\u00020%2\b\u00107\u001a\u0004\u0018\u000103J\b\u00108\u001a\u00020%H\u0016J\b\u00109\u001a\u00020%H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/baidu/searchbox/mvp/publish/widget/PublishInputViewDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "themeResId", "", "(Landroid/content/Context;I)V", "cancelable", "", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "(Landroid/content/Context;ZLandroid/content/DialogInterface$OnCancelListener;)V", "activity", "Landroid/app/Activity;", "container", "Landroidx/constraintlayout/widget/ConstraintLayout;", "etInput", "Landroid/widget/EditText;", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "ivDelete", "Landroid/widget/ImageView;", "onInputListener", "Lcom/baidu/searchbox/mvp/publish/widget/PublishInputViewDialog$OnInputListener;", "rvInputBg", "Landroid/widget/RelativeLayout;", "split", "Landroid/view/View;", "toastTime", "", "tvCancel", "Landroid/widget/TextView;", "tvConfirm", "tvCount", "tvTitle", "applyNightMode", "", "applySoft", "attachAct", "act", "bindView", "dismiss", "getLayoutRes", "initListener", "onCheckConfirmSkin", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onToast", "text", "", "releaseListener", "setOnInputListener", "setTitleContent", "content", "show", "updateUI", "Companion", "OnInputListener", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PublishInputViewDialog.kt */
public final class PublishInputViewDialog extends BottomSheetDialog {
    public static final String ALL_SPACE_REGEX = "\\s*";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EMOJI_FILTER_REGEX = "[^\\u0020-\\u007E\\u00A0-\\u00BE\\u2E80-\\uA4CF\\uF900-\\uFAFF\\uFE30-\\uFE4F\\uFF00-\\uFFEF\\u0080-\\u009F\\u2000-\\u201f]";
    public static final String ENTER_BLANK_FILTER_REGEX = "[\n\r]";
    public static final int MAX_COUNT = 30;
    public static final int MIN_COUNT = 8;
    public static final String TAG = "PublishInputViewDialog";
    /* access modifiers changed from: private */
    public Activity activity;
    private ConstraintLayout container;
    /* access modifiers changed from: private */
    public EditText etInput;
    private ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private ImageView ivDelete;
    /* access modifiers changed from: private */
    public OnInputListener onInputListener;
    private RelativeLayout rvInputBg;
    private View split;
    private long toastTime;
    private TextView tvCancel;
    private TextView tvConfirm;
    /* access modifiers changed from: private */
    public TextView tvCount;
    private TextView tvTitle;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J!\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u0003H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/mvp/publish/widget/PublishInputViewDialog$OnInputListener;", "", "onCancel", "", "onConfirm", "text", "", "result", "", "(Ljava/lang/String;Ljava/lang/Boolean;)V", "onDismiss", "onGetText", "onInput", "onShow", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PublishInputViewDialog.kt */
    public interface OnInputListener {
        void onCancel();

        void onConfirm(String str, Boolean bool);

        void onDismiss();

        String onGetText();

        void onInput(String str);

        void onShow();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublishInputViewDialog(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublishInputViewDialog(Context context, int themeResId) {
        super(context, themeResId);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/mvp/publish/widget/PublishInputViewDialog$Companion;", "", "()V", "ALL_SPACE_REGEX", "", "EMOJI_FILTER_REGEX", "ENTER_BLANK_FILTER_REGEX", "MAX_COUNT", "", "MIN_COUNT", "TAG", "newInstance", "Lcom/baidu/searchbox/mvp/publish/widget/PublishInputViewDialog;", "activity", "Landroid/app/Activity;", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PublishInputViewDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PublishInputViewDialog newInstance(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            PublishInputViewDialog dialog = new PublishInputViewDialog(activity, R.style.dynamic_publisher_publish_dialog);
            dialog.attachAct(activity);
            return dialog;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublishInputViewDialog(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void attachAct(Activity act) {
        this.activity = act;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        String it;
        EditText editText;
        View decorView;
        View decorView2;
        View decorView3;
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        Window window = getWindow();
        String str = null;
        WindowManager.LayoutParams layoutParams = window != null ? window.getAttributes() : null;
        if (layoutParams != null) {
            layoutParams.width = -1;
        }
        if (layoutParams != null) {
            layoutParams.height = -1;
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setStatusBarColor(0);
        }
        Window window4 = getWindow();
        if (!(window4 == null || (decorView3 = window4.getDecorView()) == null)) {
            decorView3.setPadding(0, 0, 0, 0);
        }
        Window window5 = getWindow();
        if (!(window5 == null || (decorView2 = window5.getDecorView()) == null)) {
            decorView2.setBackgroundColor(0);
        }
        try {
            Window window6 = getWindow();
            View v = (window6 == null || (decorView = window6.getDecorView()) == null) ? null : decorView.findViewById(com.google.android.material.R.id.design_bottom_sheet);
            if (v != null) {
                v.setBackgroundColor(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        bindView();
        EditText editText2 = this.etInput;
        if (editText2 != null) {
            OnInputListener onInputListener2 = this.onInputListener;
            if (onInputListener2 != null) {
                str = onInputListener2.onGetText();
            }
            editText2.setText(str);
        }
        OnInputListener onInputListener3 = this.onInputListener;
        if (!(onInputListener3 == null || (it = onInputListener3.onGetText()) == null || (editText = this.etInput) == null)) {
            editText.setSelection(it.length());
        }
        EditText editText3 = this.etInput;
        if (editText3 != null) {
            editText3.requestFocus();
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    private final void applyNightMode() {
        Activity it;
        if (NightModeHelper.getNightModeSwitcherState() && (it = this.activity) != null) {
            UiBaseUtils.setTextColor(this.tvCancel, ContextCompat.getColor(it, R.color.dynamic_publisher_color_444444));
            UiBaseUtils.setTextColor(this.tvTitle, ContextCompat.getColor(it, R.color.dynamic_publisher_color_666666));
            UiBaseUtils.setTextColor(this.etInput, ContextCompat.getColor(it, R.color.dynamic_publisher_color_4D4D4D));
            UiBaseUtils.setTextColor(this.tvCount, ContextCompat.getColor(it, R.color.dynamic_publisher_color_444444));
            UiBaseUtils.setViewBackgroundDrawable(this.container, ContextCompat.getDrawable(it, R.drawable.dynamic_publisher_input_bg_night));
            UiBaseUtils.setViewBackgroundDrawable(this.split, ContextCompat.getDrawable(it, R.color.dynamic_publisher_color_242424));
            ImageView imageView = this.ivDelete;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.dynamic_publisher_icon_close_night);
            }
            UiBaseUtils.setViewBackgroundDrawable(this.rvInputBg, ContextCompat.getDrawable(it, R.drawable.bg_mvp_ai_publisher_input_container_night));
            EditText editText = this.etInput;
            if (editText != null) {
                editText.setHintTextColor(ContextCompat.getColor(it, R.color.dynamic_publisher_color_4D4D4D));
            }
            UiBaseUtils.setTextColor(this.etInput, ContextCompat.getColor(it, R.color.dynamic_publisher_color_666666));
        }
        onCheckConfirmSkin();
    }

    public final void releaseListener() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.globalLayoutListener;
        if (onGlobalLayoutListener != null) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener2 = onGlobalLayoutListener;
            Activity activity2 = this.activity;
            if (activity2 != null) {
                Activity activity3 = activity2;
                SoftInputUtil.detach(activity2, onGlobalLayoutListener);
            }
        }
    }

    private final void initListener() {
        TextView textView = this.tvCancel;
        if (textView != null) {
            textView.setOnClickListener(new PublishInputViewDialog$$ExternalSyntheticLambda2(this));
        }
        TextView textView2 = this.tvConfirm;
        if (textView2 != null) {
            textView2.setOnClickListener(new PublishInputViewDialog$$ExternalSyntheticLambda3(this));
        }
        TextView textView3 = this.tvCount;
        if (textView3 != null) {
            textView3.setText("0/30");
        }
        EditText editText = this.etInput;
        if (editText != null) {
            editText.addTextChangedListener(new PublishInputViewDialog$initListener$3(this));
        }
        ImageView imageView = this.ivDelete;
        if (imageView != null) {
            imageView.setOnClickListener(new PublishInputViewDialog$$ExternalSyntheticLambda4(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initListener$lambda-4  reason: not valid java name */
    public static final void m1457initListener$lambda4(PublishInputViewDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SoftInputUtil.hideSoftInput(this$0.etInput);
        OnInputListener onInputListener2 = this$0.onInputListener;
        if (onInputListener2 != null) {
            onInputListener2.onCancel();
        }
        this$0.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: initListener$lambda-6  reason: not valid java name */
    public static final void m1458initListener$lambda6(PublishInputViewDialog this$0, View it) {
        Editable text;
        Editable text2;
        Editable text3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.etInput;
        String str = null;
        if (editText == null || (text2 = editText.getText()) == null || text2.length() >= 8) {
            SoftInputUtil.hideSoftInput(this$0.etInput);
            OnInputListener onInputListener2 = this$0.onInputListener;
            if (onInputListener2 != null) {
                EditText editText2 = this$0.etInput;
                if (!(editText2 == null || (text = editText2.getText()) == null)) {
                    str = text.toString();
                }
                onInputListener2.onConfirm(str, true);
            }
            this$0.dismiss();
            return;
        }
        ToastUtil toastUtil = ToastUtil.INSTANCE;
        Activity activity2 = this$0.activity;
        toastUtil.showToastWithMinDur(activity2 != null ? activity2.getString(R.string.dynamic_publisher_input_title_min) : null);
        OnInputListener onInputListener3 = this$0.onInputListener;
        if (onInputListener3 != null) {
            EditText editText3 = this$0.etInput;
            if (!(editText3 == null || (text3 = editText3.getText()) == null)) {
                str = text3.toString();
            }
            onInputListener3.onConfirm(str, false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initListener$lambda-7  reason: not valid java name */
    public static final void m1459initListener$lambda7(PublishInputViewDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.etInput;
        if (editText != null) {
            editText.setText("");
        }
    }

    private final void onToast(String text) {
        if (System.currentTimeMillis() - this.toastTime >= 2000) {
            this.toastTime = System.currentTimeMillis();
            if (text != null && text.length() > 30) {
                ToastUtil toastUtil = ToastUtil.INSTANCE;
                Activity activity2 = this.activity;
                toastUtil.showToastWithMinDur(activity2 != null ? activity2.getString(R.string.dynamic_publisher_input_title_max) : null);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getText();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void onCheckConfirmSkin() {
        /*
            r6 = this;
            android.widget.EditText r0 = r6.etInput
            r1 = 0
            if (r0 == 0) goto L_0x0010
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x0010
            int r0 = r0.length()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            r2 = 8
            if (r0 < r2) goto L_0x0016
            r1 = 1
        L_0x0016:
            r0 = r1
            android.app.Activity r1 = r6.activity
            if (r1 == 0) goto L_0x0063
            r2 = 0
            boolean r3 = com.baidu.searchbox.skin.NightModeHelper.getNightModeSwitcherState()
            if (r3 != 0) goto L_0x0042
            if (r0 != 0) goto L_0x0033
            android.widget.TextView r3 = r6.tvConfirm
            r4 = r1
            android.content.Context r4 = (android.content.Context) r4
            int r5 = com.baidu.searchbox.publishercomponent.R.color.dynamic_publisher_color_a30_4E6EF2
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            com.baidu.searchbox.ugc.utils.UiBaseUtils.setTextColor(r3, r4)
            goto L_0x0061
        L_0x0033:
            android.widget.TextView r3 = r6.tvConfirm
            r4 = r1
            android.content.Context r4 = (android.content.Context) r4
            int r5 = com.baidu.searchbox.publishercomponent.R.color.dynamic_publisher_color_4E6EF2
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            com.baidu.searchbox.ugc.utils.UiBaseUtils.setTextColor(r3, r4)
            goto L_0x0061
        L_0x0042:
            if (r0 != 0) goto L_0x0053
            android.widget.TextView r3 = r6.tvConfirm
            r4 = r1
            android.content.Context r4 = (android.content.Context) r4
            int r5 = com.baidu.searchbox.publishercomponent.R.color.dynamic_publisher_color_a20_263678
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            com.baidu.searchbox.ugc.utils.UiBaseUtils.setTextColor(r3, r4)
            goto L_0x0061
        L_0x0053:
            android.widget.TextView r3 = r6.tvConfirm
            r4 = r1
            android.content.Context r4 = (android.content.Context) r4
            int r5 = com.baidu.searchbox.publishercomponent.R.color.dynamic_publisher_color_263678
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r5)
            com.baidu.searchbox.ugc.utils.UiBaseUtils.setTextColor(r3, r4)
        L_0x0061:
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.mvp.publish.widget.PublishInputViewDialog.onCheckConfirmSkin():void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        if ((r0.length() > 0) == true) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateUI() {
        /*
            r3 = this;
            r3.onCheckConfirmSkin()
            android.widget.EditText r0 = r3.etInput
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001d
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x001d
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0019
            r0 = r1
            goto L_0x001a
        L_0x0019:
            r0 = r2
        L_0x001a:
            if (r0 != r1) goto L_0x001d
            goto L_0x001e
        L_0x001d:
            r1 = r2
        L_0x001e:
            if (r1 == 0) goto L_0x0029
            android.widget.ImageView r0 = r3.ivDelete
            if (r0 != 0) goto L_0x0025
            goto L_0x0033
        L_0x0025:
            r0.setVisibility(r2)
            goto L_0x0033
        L_0x0029:
            android.widget.ImageView r0 = r3.ivDelete
            if (r0 != 0) goto L_0x002e
            goto L_0x0033
        L_0x002e:
            r1 = 8
            r0.setVisibility(r1)
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.mvp.publish.widget.PublishInputViewDialog.updateUI():void");
    }

    public final void setTitleContent(String content) {
        EditText editText = this.etInput;
        if (editText != null) {
            editText.setText(content);
        }
        if (content != null) {
            String it = content;
            EditText editText2 = this.etInput;
            if (editText2 != null) {
                editText2.setSelection(it.length());
            }
        }
    }

    public void show() {
        super.show();
        OnInputListener onInputListener2 = this.onInputListener;
        if (onInputListener2 != null) {
            onInputListener2.onShow();
        }
        EditText it = this.etInput;
        if (it != null) {
            it.post(new PublishInputViewDialog$$ExternalSyntheticLambda0(it));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: show$lambda-12$lambda-11  reason: not valid java name */
    public static final void m1460show$lambda12$lambda11(EditText $it) {
        Intrinsics.checkNotNullParameter($it, "$it");
        $it.requestFocus();
        SoftInputUtil.showSoftInput($it);
    }

    public final void setOnInputListener(OnInputListener onInputListener2) {
        Intrinsics.checkNotNullParameter(onInputListener2, "onInputListener");
        this.onInputListener = onInputListener2;
    }

    private final int getLayoutRes() {
        return R.layout.dynamic_publisher_ai_modify_title_item;
    }

    private final void bindView() {
        this.tvCancel = (TextView) findViewById(R.id.dynamic_publisher_input_cancel);
        this.tvConfirm = (TextView) findViewById(R.id.dynamic_publisher_input_confirm);
        this.tvTitle = (TextView) findViewById(R.id.dynamic_publisher_input_title);
        this.tvCount = (TextView) findViewById(R.id.dynamic_publisher_tv_count);
        this.ivDelete = (ImageView) findViewById(R.id.dynamic_publisher_iv_close);
        this.etInput = (EditText) findViewById(R.id.et_dynamic_publisher_input);
        this.container = (ConstraintLayout) findViewById(R.id.dynamic_publisher_input_container);
        this.split = findViewById(R.id.dynamic_publisher_split);
        this.rvInputBg = (RelativeLayout) findViewById(R.id.dynamic_publisher_input_bg);
        initListener();
        applyNightMode();
        applySoft();
    }

    private final void applySoft() {
        ViewGroup decorView;
        Activity ctx = this.activity;
        if (ctx != null && (decorView = (ViewGroup) ctx.findViewById(16908290)) != null) {
            Intrinsics.checkNotNullExpressionValue(decorView, "decorView");
            ViewGroup view2 = decorView;
            if (view2 instanceof ViewGroup) {
                this.globalLayoutListener = SoftInputUtil.attach(ctx, view2, new PublishInputViewDialog$applySoft$1$1$1(view2), new PublishInputViewDialog$$ExternalSyntheticLambda1(this));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: applySoft$lambda-15$lambda-14$lambda-13  reason: not valid java name */
    public static final void m1456applySoft$lambda15$lambda14$lambda13(PublishInputViewDialog this$0, boolean isShowing) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!isShowing) {
            this$0.dismiss();
        }
    }

    public void dismiss() {
        super.dismiss();
        OnInputListener onInputListener2 = this.onInputListener;
        if (onInputListener2 != null) {
            onInputListener2.onDismiss();
        }
        EditText editText = this.etInput;
        if (editText != null) {
            EditText editText2 = editText;
            SoftInputUtil.hideSoftInput(editText);
        }
    }
}
