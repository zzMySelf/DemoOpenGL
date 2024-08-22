package com.baidu.searchbox.settings.teenager.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.android.common.ui.style.R;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.controller.InputMethodController;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.skin.NightModeHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 /2\u00020\u0001:\u0004/012B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB)\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u001a\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020 H\u0002J\b\u0010'\u001a\u00020#H\u0002J\u0010\u0010(\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0014J\u0006\u0010)\u001a\u00020#J\u0006\u0010*\u001a\u00020#J\u0012\u0010+\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0006\u0010.\u001a\u00020#R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u000e¢\u0006\u0004\n\u0002\u0010!¨\u00063"}, d2 = {"Lcom/baidu/searchbox/settings/teenager/view/PasswordInputView;", "Landroid/widget/EditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mCurrentInput", "mHandler", "Landroid/os/Handler;", "mInputComplete", "Lcom/baidu/searchbox/settings/teenager/view/PasswordInputView$InputComplete;", "getMInputComplete", "()Lcom/baidu/searchbox/settings/teenager/view/PasswordInputView$InputComplete;", "setMInputComplete", "(Lcom/baidu/searchbox/settings/teenager/view/PasswordInputView$InputComplete;)V", "mInputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "getMInputMethodManager", "()Landroid/view/inputmethod/InputMethodManager;", "mNightMode", "", "mPaint", "Landroid/graphics/Paint;", "passwords", "", "Lcom/baidu/searchbox/settings/teenager/view/PasswordInputView$Password;", "[Lcom/baidu/searchbox/settings/teenager/view/PasswordInputView$Password;", "drawItem", "", "canvas", "Landroid/graphics/Canvas;", "password", "init", "onDraw", "release", "reset", "setLayoutParams", "params", "Landroid/view/ViewGroup$LayoutParams;", "showSoftInput", "Companion", "InputComplete", "Password", "PasswordHandler", "lib-settings-teenager_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PasswordInputView.kt */
public final class PasswordInputView extends EditText {
    public static final Companion Companion;
    private static final long MESSAGE_FREQUENCY_INTERVAL = 500;
    private static final int MESSAGE_WHAT_FREQUENCY = 1;
    private static final int MESSAGE_WHAT_INPUT = 2;
    private static final float PASSWORD_BG_RADIUS;
    private static final float PASSWORD_BG_SIZE;
    private static final float PASSWORD_CURSOR_HEIGHT;
    private static final float PASSWORD_CURSOR_WIDTH;
    private static final float PASSWORD_HIDE_CIRCLE;
    private static final float PASSWORD_INTERVAL;
    private static final int PASSWORD_LENGTH = 4;
    private static final float PASSWORD_SHADOW_SIZE;
    private static final float PASSWORD_TEXT_SIZE;
    private static final int STYLE_INPUTED = 2;
    private static final int STYLE_INPUTING = 1;
    private static final int STYLE_UNINPUT = 0;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    /* access modifiers changed from: private */
    public int mCurrentInput;
    /* access modifiers changed from: private */
    public Handler mHandler;
    private InputComplete mInputComplete;
    private InputMethodManager mInputMethodManager;
    private final boolean mNightMode;
    private Paint mPaint;
    /* access modifiers changed from: private */
    public Password[] passwords;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/settings/teenager/view/PasswordInputView$InputComplete;", "", "complete", "", "password", "", "lib-settings-teenager_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PasswordInputView.kt */
    public interface InputComplete {
        void complete(String str);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/settings/teenager/view/PasswordInputView$Companion;", "", "()V", "MESSAGE_FREQUENCY_INTERVAL", "", "MESSAGE_WHAT_FREQUENCY", "", "MESSAGE_WHAT_INPUT", "PASSWORD_BG_RADIUS", "", "PASSWORD_BG_SIZE", "PASSWORD_CURSOR_HEIGHT", "PASSWORD_CURSOR_WIDTH", "PASSWORD_HIDE_CIRCLE", "PASSWORD_INTERVAL", "PASSWORD_LENGTH", "PASSWORD_SHADOW_SIZE", "PASSWORD_TEXT_SIZE", "STYLE_INPUTED", "STYLE_INPUTING", "STYLE_UNINPUT", "dp2px", "context", "Landroid/content/Context;", "dpValue", "lib-settings-teenager_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PasswordInputView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final float dp2px(Context context, int dpValue) {
            return (((float) dpValue) * context.getResources().getDisplayMetrics().density) + 0.5f;
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        Context appContext = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext, "getAppContext()");
        PASSWORD_INTERVAL = companion.dp2px(appContext, 17);
        Context appContext2 = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext2, "getAppContext()");
        PASSWORD_BG_SIZE = companion.dp2px(appContext2, 41);
        Context appContext3 = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext3, "getAppContext()");
        PASSWORD_BG_RADIUS = companion.dp2px(appContext3, 8);
        Context appContext4 = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext4, "getAppContext()");
        PASSWORD_SHADOW_SIZE = companion.dp2px(appContext4, 14);
        Context appContext5 = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext5, "getAppContext()");
        PASSWORD_CURSOR_HEIGHT = companion.dp2px(appContext5, 17);
        Context appContext6 = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext6, "getAppContext()");
        PASSWORD_CURSOR_WIDTH = companion.dp2px(appContext6, 1);
        Context appContext7 = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext7, "getAppContext()");
        PASSWORD_HIDE_CIRCLE = companion.dp2px(appContext7, 9) / ((float) 2);
        Context appContext8 = AppRuntime.getAppContext();
        Intrinsics.checkNotNullExpressionValue(appContext8, "getAppContext()");
        PASSWORD_TEXT_SIZE = companion.dp2px(appContext8, 18);
    }

    /* access modifiers changed from: private */
    public final InputMethodManager getMInputMethodManager() {
        if (this.mInputMethodManager == null) {
            Object systemService = getContext().getSystemService(InputMethodController.BUTTON_INPUT_METHOD);
            if (systemService != null) {
                this.mInputMethodManager = (InputMethodManager) systemService;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            }
        }
        return this.mInputMethodManager;
    }

    public final InputComplete getMInputComplete() {
        return this.mInputComplete;
    }

    public final void setMInputComplete(InputComplete inputComplete) {
        this.mInputComplete = inputComplete;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/settings/teenager/view/PasswordInputView$PasswordHandler;", "Landroid/os/Handler;", "(Lcom/baidu/searchbox/settings/teenager/view/PasswordInputView;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "lib-settings-teenager_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PasswordInputView.kt */
    public final class PasswordHandler extends Handler {
        public PasswordHandler() {
        }

        public void handleMessage(Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    PasswordInputView.this.mHandler.removeMessages(1);
                    PasswordInputView.this.mHandler.sendEmptyMessageDelayed(1, 500);
                    for (Password password : PasswordInputView.this.passwords) {
                        if (password.getStyle() == 1) {
                            password.setCursorVisible(!password.getCursorVisible());
                        } else if (password.getStyle() == 2) {
                            password.setHide(!password.isHide() ? !password.isHide() : password.isHide());
                        }
                    }
                    PasswordInputView.this.invalidate();
                    return;
                case 2:
                    PasswordInputView.this.requestFocus();
                    InputMethodManager access$getMInputMethodManager = PasswordInputView.this.getMInputMethodManager();
                    if (access$getMInputMethodManager != null) {
                        access$getMInputMethodManager.showSoftInput(PasswordInputView.this, 0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public PasswordInputView(Context context) {
        super(context);
        Password[] passwordArr = new Password[4];
        for (int i2 = 0; i2 < 4; i2++) {
            passwordArr[i2] = new Password();
        }
        this.passwords = passwordArr;
        this.mPaint = new Paint();
        this.mNightMode = NightModeHelper.isNightMode();
        this.mHandler = new PasswordHandler();
        init();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PasswordInputView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Password[] passwordArr = new Password[4];
        for (int i2 = 0; i2 < 4; i2++) {
            passwordArr[i2] = new Password();
        }
        this.passwords = passwordArr;
        this.mPaint = new Paint();
        this.mNightMode = NightModeHelper.isNightMode();
        this.mHandler = new PasswordHandler();
        init();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PasswordInputView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Password[] passwordArr = new Password[4];
        for (int i2 = 0; i2 < 4; i2++) {
            passwordArr[i2] = new Password();
        }
        this.passwords = passwordArr;
        this.mPaint = new Paint();
        this.mNightMode = NightModeHelper.isNightMode();
        this.mHandler = new PasswordHandler();
        init();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PasswordInputView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Password[] passwordArr = new Password[4];
        for (int i2 = 0; i2 < 4; i2++) {
            passwordArr[i2] = new Password();
        }
        this.passwords = passwordArr;
        this.mPaint = new Paint();
        this.mNightMode = NightModeHelper.isNightMode();
        this.mHandler = new PasswordHandler();
        init();
    }

    private final void init() {
        setBackground((Drawable) null);
        setCursorVisible(false);
        setInputType(2);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setTextSize(PASSWORD_TEXT_SIZE);
        this.mPaint.setTextAlign(Paint.Align.CENTER);
        setLayerType(1, (Paint) null);
        reset();
        addTextChangedListener(new PasswordInputView$init$1(this));
    }

    public final void reset() {
        setText("");
        this.passwords[0].setStyle(1);
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessage(1);
        showSoftInput();
    }

    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(params);
        if (params != null) {
            int totalHeight = params.height;
            int length = this.passwords.length;
            for (int i2 = 0; i2 < length; i2++) {
                Password password = this.passwords[i2];
                RectF bgLocation = password.getBgLocation();
                RectF cursorLocation = password.getCursorLocation();
                Point hidePasswordLocation = password.getHidePasswordLocation();
                Point passwordTextLocation = password.getPasswordTextLocation();
                float f2 = PASSWORD_SHADOW_SIZE;
                bgLocation.top = f2;
                float f3 = PASSWORD_BG_SIZE;
                bgLocation.bottom = f2 + f3;
                bgLocation.left = ((PASSWORD_INTERVAL + f3) * ((float) i2)) + f2;
                bgLocation.right = this.passwords[i2].getBgLocation().left + f3;
                float f4 = PASSWORD_CURSOR_HEIGHT;
                float f5 = (float) 2;
                cursorLocation.top = (((float) totalHeight) - f4) / f5;
                float f6 = bgLocation.left;
                float f7 = PASSWORD_CURSOR_WIDTH;
                cursorLocation.left = f6 + ((f3 - f7) / f5);
                cursorLocation.bottom = cursorLocation.top + f4;
                cursorLocation.right = cursorLocation.left + f7;
                hidePasswordLocation.x = (int) ((bgLocation.left + bgLocation.right) / f5);
                hidePasswordLocation.y = (int) ((bgLocation.top + bgLocation.bottom) / f5);
                passwordTextLocation.x = (int) ((bgLocation.left + bgLocation.right) / f5);
                Paint.FontMetrics fontMetrics = this.mPaint.getFontMetrics();
                Intrinsics.checkNotNullExpressionValue(fontMetrics, "mPaint.fontMetrics");
                passwordTextLocation.y = (int) (((float) ((int) ((bgLocation.top + bgLocation.bottom) / f5))) + (((fontMetrics.bottom - fontMetrics.top) / f5) - fontMetrics.bottom));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        for (Password password : this.passwords) {
            drawItem(canvas, password);
        }
    }

    private final void drawItem(Canvas canvas, Password password) {
        switch (password.getStyle()) {
            case 0:
                this.mPaint.setColor(getResources().getColor(R.color.GC12));
                if (canvas != null) {
                    RectF bgLocation = password.getBgLocation();
                    float f2 = PASSWORD_BG_RADIUS;
                    canvas.drawRoundRect(bgLocation, f2, f2, this.mPaint);
                    return;
                }
                return;
            case 1:
                this.mPaint.setColor(getResources().getColor(com.baidu.searchbox.settings.teenager.R.color.BC164));
                if (!this.mNightMode) {
                    this.mPaint.setShadowLayer(PASSWORD_SHADOW_SIZE, 0.0f, 0.0f, getResources().getColor(com.baidu.searchbox.settings.teenager.R.color.password_bg_shadow_inputing));
                }
                if (canvas != null) {
                    RectF bgLocation2 = password.getBgLocation();
                    float f3 = PASSWORD_BG_RADIUS;
                    canvas.drawRoundRect(bgLocation2, f3, f3, this.mPaint);
                }
                this.mPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                if (password.getCursorVisible()) {
                    this.mPaint.setColor(getResources().getColor(R.color.GC77));
                    if (canvas != null) {
                        canvas.drawRect(password.getCursorLocation(), this.mPaint);
                        return;
                    }
                    return;
                }
                return;
            case 2:
                this.mPaint.setColor(getResources().getColor(R.color.GC51));
                this.mPaint.setShadowLayer(PASSWORD_SHADOW_SIZE, 0.0f, 0.0f, getResources().getColor(com.baidu.searchbox.settings.teenager.R.color.password_bg_shadow_inputed));
                if (canvas != null) {
                    RectF bgLocation3 = password.getBgLocation();
                    float f4 = PASSWORD_BG_RADIUS;
                    canvas.drawRoundRect(bgLocation3, f4, f4, this.mPaint);
                }
                this.mPaint.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                if (password.isHide()) {
                    this.mPaint.setColor(getResources().getColor(R.color.GC67));
                    if (canvas != null) {
                        canvas.drawCircle((float) password.getHidePasswordLocation().x, (float) password.getHidePasswordLocation().y, PASSWORD_HIDE_CIRCLE, this.mPaint);
                        return;
                    }
                    return;
                }
                this.mPaint.setColor(getResources().getColor(R.color.GC6));
                if (canvas != null) {
                    canvas.drawText(String.valueOf(password.getText()), (float) password.getPasswordTextLocation().x, (float) password.getPasswordTextLocation().y, this.mPaint);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void showSoftInput() {
        this.mHandler.sendEmptyMessageDelayed(2, 100);
    }

    public final void release() {
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001a\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/settings/teenager/view/PasswordInputView$Password;", "", "()V", "bgLocation", "Landroid/graphics/RectF;", "getBgLocation", "()Landroid/graphics/RectF;", "setBgLocation", "(Landroid/graphics/RectF;)V", "cursorLocation", "getCursorLocation", "setCursorLocation", "cursorVisible", "", "getCursorVisible", "()Z", "setCursorVisible", "(Z)V", "hidePasswordLocation", "Landroid/graphics/Point;", "getHidePasswordLocation", "()Landroid/graphics/Point;", "setHidePasswordLocation", "(Landroid/graphics/Point;)V", "isHide", "setHide", "passwordTextLocation", "getPasswordTextLocation", "setPasswordTextLocation", "style", "", "getStyle", "()I", "setStyle", "(I)V", "text", "", "getText", "()Ljava/lang/Character;", "setText", "(Ljava/lang/Character;)V", "Ljava/lang/Character;", "lib-settings-teenager_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PasswordInputView.kt */
    public static final class Password {
        private RectF bgLocation = new RectF();
        private RectF cursorLocation = new RectF();
        private boolean cursorVisible;
        private Point hidePasswordLocation = new Point();
        private boolean isHide;
        private Point passwordTextLocation = new Point();
        private int style;
        private Character text;

        public final RectF getBgLocation() {
            return this.bgLocation;
        }

        public final void setBgLocation(RectF rectF) {
            Intrinsics.checkNotNullParameter(rectF, "<set-?>");
            this.bgLocation = rectF;
        }

        public final RectF getCursorLocation() {
            return this.cursorLocation;
        }

        public final void setCursorLocation(RectF rectF) {
            Intrinsics.checkNotNullParameter(rectF, "<set-?>");
            this.cursorLocation = rectF;
        }

        public final Point getHidePasswordLocation() {
            return this.hidePasswordLocation;
        }

        public final void setHidePasswordLocation(Point point) {
            Intrinsics.checkNotNullParameter(point, "<set-?>");
            this.hidePasswordLocation = point;
        }

        public final Point getPasswordTextLocation() {
            return this.passwordTextLocation;
        }

        public final void setPasswordTextLocation(Point point) {
            Intrinsics.checkNotNullParameter(point, "<set-?>");
            this.passwordTextLocation = point;
        }

        public final Character getText() {
            return this.text;
        }

        public final void setText(Character ch) {
            this.text = ch;
        }

        public final int getStyle() {
            return this.style;
        }

        public final void setStyle(int i2) {
            this.style = i2;
        }

        public final boolean getCursorVisible() {
            return this.cursorVisible;
        }

        public final void setCursorVisible(boolean z) {
            this.cursorVisible = z;
        }

        public final boolean isHide() {
            return this.isHide;
        }

        public final void setHide(boolean z) {
            this.isHide = z;
        }
    }
}
