package com.dxmpay.wallet.base.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import com.baidu.android.common.others.IStringUtil;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.utils.AccessibilityUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Random;

public class SafeKeyBoardPopupWindow extends PopupWindow implements View.OnClickListener {
    public Button a;
    public Button b;
    public Button c;
    public View contentView;
    public Button d;
    public Button e;
    public Button f;
    public Button g;
    public Button h;

    /* renamed from: i  reason: collision with root package name */
    public Button f4176i;
    public Button j;
    public ImageButton k;
    public th l;
    public Button mButtonX;
    public Context mContext;
    public SafeScrollView mSafeScrollView;
    public boolean miniMode;
    public SafeKeyBoardEditText mySafeEditText;

    public class ad implements View.OnTouchListener {
        public ad() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                SafeKeyBoardPopupWindow.this.d();
                return false;
            } else if (motionEvent.getAction() == 1) {
                SafeKeyBoardPopupWindow.this.c();
                return false;
            } else if (motionEvent.getAction() != 2 || SafeKeyBoardPopupWindow.this.k.isPressed()) {
                return false;
            } else {
                SafeKeyBoardPopupWindow.this.c();
                return false;
            }
        }
    }

    public class de implements View.OnClickListener {

        public class qw implements Runnable {
            public qw() {
            }

            public void run() {
                SafeKeyBoardPopupWindow.this.l.removeCallbacksAndMessages((Object) null);
            }
        }

        public de() {
        }

        public void onClick(View view) {
            SafeKeyBoardPopupWindow.this.d();
            SafeKeyBoardPopupWindow.this.k.post(new qw());
        }
    }

    public class fe implements Runnable {
        public fe() {
        }

        public void run() {
            int selectionStart = SafeKeyBoardPopupWindow.this.mySafeEditText.getSelectionStart();
            int selectionEnd = SafeKeyBoardPopupWindow.this.mySafeEditText.getSelectionEnd();
            Editable text = SafeKeyBoardPopupWindow.this.mySafeEditText.getText();
            if (selectionStart < 0) {
                return;
            }
            if (selectionStart < selectionEnd) {
                text.replace(selectionStart, selectionEnd, "", 0, 0);
            } else if (selectionStart != selectionEnd) {
                text.replace(selectionEnd, selectionStart, "", 0, 0);
            } else if (selectionStart > 0) {
                text.replace(selectionStart - 1, selectionStart, "", 0, 0);
            }
        }
    }

    public class qw implements View.OnFocusChangeListener {
        public qw(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
        }

        public void onFocusChange(View view, boolean z) {
        }
    }

    public class rg implements Runnable {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ View f4181ad;

        public rg(View view) {
            this.f4181ad = view;
        }

        public void run() {
            int selectionStart = SafeKeyBoardPopupWindow.this.mySafeEditText.getSelectionStart();
            int selectionEnd = SafeKeyBoardPopupWindow.this.mySafeEditText.getSelectionEnd();
            Editable text = SafeKeyBoardPopupWindow.this.mySafeEditText.getText();
            if (selectionStart < 0) {
                return;
            }
            if (selectionStart < selectionEnd) {
                text.replace(selectionStart, selectionEnd, this.f4181ad.getTag().toString(), 0, this.f4181ad.getTag().toString().length());
            } else if (selectionStart == selectionEnd) {
                text.replace(selectionStart, selectionStart, this.f4181ad.getTag().toString(), 0, this.f4181ad.getTag().toString().length());
            } else {
                text.replace(selectionEnd, selectionStart, this.f4181ad.getTag().toString(), 0, this.f4181ad.getTag().toString().length());
                int selectionEnd2 = SafeKeyBoardPopupWindow.this.mySafeEditText.getSelectionEnd() + this.f4181ad.getTag().toString().length();
                if (selectionEnd2 >= 0 && selectionEnd2 <= SafeKeyBoardPopupWindow.this.mySafeEditText.getText().toString().length()) {
                    Selection.setSelection(SafeKeyBoardPopupWindow.this.mySafeEditText.getEditableText(), selectionEnd2);
                }
            }
        }
    }

    public static class th extends Handler {
        public WeakReference<SafeKeyBoardPopupWindow> qw;

        public th(SafeKeyBoardPopupWindow safeKeyBoardPopupWindow) {
            this.qw = new WeakReference<>(safeKeyBoardPopupWindow);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            SafeKeyBoardPopupWindow safeKeyBoardPopupWindow = (SafeKeyBoardPopupWindow) this.qw.get();
            if (safeKeyBoardPopupWindow != null) {
                if (!TextUtils.isEmpty(safeKeyBoardPopupWindow.mySafeEditText.getText())) {
                    int selectionStart = safeKeyBoardPopupWindow.mySafeEditText.getSelectionStart();
                    int selectionEnd = safeKeyBoardPopupWindow.mySafeEditText.getSelectionEnd();
                    Editable text = safeKeyBoardPopupWindow.mySafeEditText.getText();
                    if (selectionStart >= 0) {
                        if (selectionStart < selectionEnd) {
                            text.replace(selectionStart, selectionEnd, "", 0, 0);
                        } else if (selectionStart != selectionEnd) {
                            text.replace(selectionEnd, selectionStart, "", 0, 0);
                        } else if (selectionStart > 0) {
                            text.replace(selectionStart - 1, selectionStart, "", 0, 0);
                        }
                        removeCallbacksAndMessages((Object) null);
                        sendEmptyMessageDelayed(1, 200);
                        return;
                    }
                    return;
                }
                removeCallbacksAndMessages((Object) null);
            }
        }
    }

    public SafeKeyBoardPopupWindow(Context context) {
        super(context);
        this.mContext = context;
        b();
    }

    public int getLayoutId() {
        return ResUtils.layout(this.mContext, this.miniMode ? "dxm_wallet_base_safekeyboard_popupwindow_mini" : "dxm_wallet_base_safekeyboard_popupwindow");
    }

    public int getPopupWindowHeight() {
        return this.contentView.getHeight();
    }

    public void initKeyNum(boolean z) {
        int[] a2 = a(z);
        Button button = this.j;
        button.setText("" + a2[0]);
        this.j.setTag(Integer.valueOf(a2[0]));
        Button button2 = this.a;
        button2.setText("" + a2[1]);
        this.a.setTag(Integer.valueOf(a2[1]));
        Button button3 = this.b;
        button3.setText("" + a2[2]);
        this.b.setTag(Integer.valueOf(a2[2]));
        Button button4 = this.c;
        button4.setText("" + a2[3]);
        this.c.setTag(Integer.valueOf(a2[3]));
        Button button5 = this.d;
        button5.setText("" + a2[4]);
        this.d.setTag(Integer.valueOf(a2[4]));
        Button button6 = this.e;
        button6.setText("" + a2[5]);
        this.e.setTag(Integer.valueOf(a2[5]));
        Button button7 = this.f;
        button7.setText("" + a2[6]);
        this.f.setTag(Integer.valueOf(a2[6]));
        Button button8 = this.g;
        button8.setText("" + a2[7]);
        this.g.setTag(Integer.valueOf(a2[7]));
        Button button9 = this.h;
        button9.setText("" + a2[8]);
        this.h.setTag(Integer.valueOf(a2[8]));
        Button button10 = this.f4176i;
        button10.setText("" + a2[9]);
        this.f4176i.setTag(Integer.valueOf(a2[9]));
        if (this.mySafeEditText.getUseKeyX()) {
            this.mButtonX.setEnabled(true);
            this.mButtonX.setBackgroundResource(ResUtils.drawable(this.mContext, "dxm_wallet_base_safekeyboard_numkey_selector"));
            this.mButtonX.setText("X");
            this.mButtonX.setTag("X");
        } else if (this.mySafeEditText.getUseKeyDot()) {
            this.mButtonX.setEnabled(true);
            this.mButtonX.setBackgroundResource(ResUtils.drawable(this.mContext, "dxm_wallet_base_safekeyboard_numkey_selector"));
            this.mButtonX.setText(IStringUtil.CURRENT_PATH);
            this.mButtonX.setTag(IStringUtil.CURRENT_PATH);
        } else {
            this.mButtonX.setEnabled(false);
            this.mButtonX.setText("");
            this.mButtonX.setBackgroundResource(ResUtils.drawable(this.mContext, "dxm_wallet_base_safekeyboard_delkey_selector"));
        }
    }

    public void onClick(View view) {
        if (view.getId() != ResUtils.id(this.mContext, "btn_del")) {
            new Handler().post(new rg(view));
        } else if (!TextUtils.isEmpty(this.mySafeEditText.getText())) {
            new Handler().post(new fe());
        }
    }

    public void setSafeEditTet(SafeKeyBoardEditText safeKeyBoardEditText) {
        this.mySafeEditText = safeKeyBoardEditText;
    }

    public void setScrollView(SafeScrollView safeScrollView) {
        this.mSafeScrollView = safeScrollView;
    }

    public void update() {
        SafeKeyBoardEditText safeKeyBoardEditText;
        super.update();
        if (isShowing() && (safeKeyBoardEditText = this.mySafeEditText) != null) {
            safeKeyBoardEditText.isShowLogoLockAnim();
        }
    }

    @TargetApi(24)
    private boolean a() {
        Context context;
        if (Build.VERSION.SDK_INT < 24 || (context = this.mContext) == null) {
            return false;
        }
        return ((Activity) context).isInMultiWindowMode();
    }

    private void b() {
        this.miniMode = a();
        View inflate = LayoutInflater.from(this.mContext).inflate(getLayoutId(), (ViewGroup) null);
        this.contentView = inflate;
        setContentView(inflate);
        setHeight(-2);
        setWidth(-1);
        setBackgroundDrawable(new BitmapDrawable());
        setAnimationStyle(ResUtils.style(this.mContext, "dxm_wallet_safekeyboard_popwindown_anim"));
        fe.i.ad.yj.ad.qw().fe(this);
        this.j = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn0"));
        this.a = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn1"));
        this.b = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn2"));
        this.c = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn3"));
        this.d = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn4"));
        this.e = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn5"));
        this.f = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn6"));
        this.g = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn7"));
        this.h = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn8"));
        this.f4176i = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn9"));
        this.mButtonX = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "btn_x"));
        ImageButton imageButton = (ImageButton) this.contentView.findViewById(ResUtils.id(this.mContext, "btn_del"));
        this.k = imageButton;
        AccessibilityUtils.setContentDescription(imageButton, ResUtils.getString(this.mContext, "dxm_wallet_base_delete"));
        this.j.setOnClickListener(this);
        this.a.setOnClickListener(this);
        this.b.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.f4176i.setOnClickListener(this);
        this.mButtonX.setOnClickListener(this);
        this.k.setOnFocusChangeListener(new qw(this));
        if (!AccessibilityUtils.isAccessibilityEnabled(this.mContext)) {
            this.k.setOnTouchListener(new ad());
        } else {
            this.k.setOnClickListener(new de());
        }
        setSoftInputMode(16);
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.l == null) {
            this.l = new th(this);
        }
        this.l.removeCallbacksAndMessages((Object) null);
    }

    /* access modifiers changed from: private */
    public void d() {
        if (this.l == null) {
            this.l = new th(this);
        }
        this.l.sendEmptyMessage(1);
    }

    private int[] a(boolean z) {
        int i2;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            if (i3 >= 10) {
                break;
            }
            arrayList.add(Integer.valueOf(i3));
            i3++;
        }
        int[] iArr = new int[10];
        if (z) {
            Random random = new Random();
            for (i2 = 10; i2 > 0; i2--) {
                int nextInt = random.nextInt(i2);
                iArr[10 - i2] = ((Integer) arrayList.get(nextInt)).intValue();
                arrayList.remove(nextInt);
            }
        } else {
            for (int i4 = 0; i4 < 10; i4++) {
                iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
            }
        }
        return iArr;
    }
}
