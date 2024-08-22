package com.baidu.wallet.lightapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.apollon.utils.CheckUtils;
import com.baidu.apollon.utils.DisplayUtils;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.apollon.utils.support.ViewHelper;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.utils.ViewUtils;
import java.util.HashMap;
import java.util.Map;

public class NoNetView extends RelativeLayout implements View.OnClickListener {
    public static int ERROR_SSL_GENERAL = 5000;
    public Animation a;
    public Animation b;
    public String c = "";
    public a d;
    public TextView e;
    public TextView f;
    public int g = Integer.MIN_VALUE;
    public View h;

    /* renamed from: i  reason: collision with root package name */
    public View f3577i;
    public View j;
    public View k;
    public View l;
    public boolean m;
    public int n;

    public interface a {
        void doNetworkTomography(String str, Map<String, String> map);

        void onContinueClick(String str);

        void onReloadClick(String str);
    }

    public NoNetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
        b();
    }

    private void a() {
        this.a = ResUtils.getAnimation(getContext(), "wallet_base_slide_from_right");
        this.b = ResUtils.getAnimation(getContext(), "wallet_base_slide_to_right");
        this.a.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                NoNetView.this.setVisibility(0);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.b.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                NoNetView.this.setVisibility(8);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
    }

    private void b() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_langbridge_no_net_error_layout"), this);
        this.h = findViewById(ResUtils.id(getContext(), "rv_net_root"));
        this.f3577i = findViewById(ResUtils.id(getContext(), "wallet_image_no_net"));
        this.j = findViewById(ResUtils.id(getContext(), "reload_btn"));
        this.k = findViewById(ResUtils.id(getContext(), "network_tomography_btn"));
        this.e = (TextView) findViewById(ResUtils.id(getContext(), "failure_cause"));
        this.f = (TextView) findViewById(ResUtils.id(getContext(), "failure_cause_errcode"));
        this.l = (TextView) findViewById(ResUtils.id(getContext(), "network_continue_btn"));
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        setAlphaView(this.j);
        setAlphaView(this.k);
        setAlphaView(this.l);
    }

    private void setAlphaView(final View view) {
        if (view != null) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
                        ViewHelper.setAlpha(view, 0.5f);
                        return false;
                    }
                    ViewHelper.setAlpha(view, 1.0f);
                    return false;
                }
            });
        }
    }

    public void hide() {
        this.c = "";
        setVisibility(8);
    }

    public boolean isShowing() {
        return getVisibility() == 0;
    }

    public void notifyUrlFinish() {
        if (isShowing()) {
            setVisibility(4);
        }
    }

    public void onClick(View view) {
        a aVar;
        if (!CheckUtils.isFastDoubleClick()) {
            int id = view.getId();
            if (id == ResUtils.id(getContext(), "reload_btn")) {
                a aVar2 = this.d;
                if (aVar2 != null) {
                    aVar2.onReloadClick(this.c);
                }
            } else if (id == ResUtils.id(getContext(), "network_tomography_btn")) {
                if (this.d != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("errorCode", String.valueOf(this.g));
                    this.d.doNetworkTomography(this.c, hashMap);
                }
            } else if (id == ResUtils.id(getContext(), "network_continue_btn") && (aVar = this.d) != null) {
                aVar.onContinueClick(this.c);
            }
        }
    }

    public void setBackground(int i2) {
        View view = this.h;
        if (view != null) {
            view.setBackground(ContextCompat.getDrawable(getContext(), i2));
        }
    }

    public void setBackgroundColor(int i2) {
        View view = this.h;
        if (view != null) {
            view.setBackgroundColor(ContextCompat.getColor(getContext(), i2));
        }
    }

    public void setButtonView(boolean z) {
        ViewUtils.setVisibility(this.k, !z);
        ViewUtils.setVisibility(this.l, z);
    }

    @Deprecated
    public void setFailureCause(int i2) {
        if (this.f != null) {
            String string = ResUtils.getString(getContext(), "wallet_base_no_network_error_code");
            this.f.setText(String.format(string, new Object[]{Integer.valueOf(i2)}));
        }
        this.g = i2;
    }

    public void setMarginTop(int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
        marginLayoutParams.topMargin = i2;
        setLayoutParams(marginLayoutParams);
    }

    public void setVisibilityByContentHeight(int i2) {
        this.n = i2;
        int dip2px = DisplayUtils.dip2px(getContext(), 420.0f);
        int dip2px2 = DisplayUtils.dip2px(getContext(), 300.0f);
        int dip2px3 = DisplayUtils.dip2px(getContext(), 200.0f);
        LogUtil.d("NoNetView", "contentHeight:" + i2 + " ,displayAllHeight：" + dip2px + " ,displayMiddleHeight：" + dip2px2 + " ,displayMiddle2Height:" + dip2px3);
        if (i2 >= dip2px) {
            ViewUtils.setVisibility(this.f3577i, true);
            ViewUtils.setVisibility(this.j, true);
            setButtonView(this.m);
        } else if (i2 >= dip2px2) {
            ViewUtils.setVisibility(this.f3577i, false);
            ViewUtils.setVisibility(this.j, true);
            setButtonView(this.m);
        } else if (i2 >= dip2px3) {
            ViewUtils.setVisibility(this.f3577i, false);
            ViewUtils.setVisibility(this.j, true);
            ViewUtils.setVisibility(this.k, false);
            ViewUtils.setVisibility(this.l, false);
        } else {
            ViewUtils.setVisibility(this.f3577i, false);
            ViewUtils.setVisibility(this.j, false);
            ViewUtils.setVisibility(this.k, false);
            ViewUtils.setVisibility(this.l, false);
        }
    }

    public void show(String str, a aVar) {
        this.c = str;
        this.d = aVar;
        setVisibility(0);
    }

    public void setFailureCause(int i2, boolean z) {
        this.m = z;
        if (!(this.f == null || this.e == null)) {
            String string = ResUtils.getString(getContext(), "wallet_base_no_network_error_code");
            String string2 = ResUtils.getString(getContext(), "wallet_base_no_network_reason");
            String string3 = ResUtils.getString(getContext(), "network_ssl_hit");
            this.f.setText(String.format(string, new Object[]{Integer.valueOf(i2)}));
            if (this.m) {
                this.e.setText(string3);
            } else {
                this.e.setText(string2);
            }
            setButtonView(this.m);
            int i3 = this.n;
            if (i3 != 0) {
                setVisibilityByContentHeight(i3);
            }
        }
        this.g = i2;
    }
}
