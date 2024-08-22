package fe.mmm.qw.f.fe.ad;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.baidu.aiscan.R;
import com.tera.scan.ui.widget.titlebar.ICommonTitleBarClickListener;

public class ad extends qw {

    /* renamed from: fe  reason: collision with root package name */
    public ViewGroup f7802fe;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f7803i;

    /* renamed from: if  reason: not valid java name */
    public TextView f333if;

    /* renamed from: o  reason: collision with root package name */
    public ImageView f7804o;

    /* renamed from: pf  reason: collision with root package name */
    public ImageButton f7805pf;

    /* renamed from: rg  reason: collision with root package name */
    public ViewGroup f7806rg;

    /* renamed from: switch  reason: not valid java name */
    public ICommonTitleBarClickListener f334switch;

    /* renamed from: th  reason: collision with root package name */
    public TextView f7807th;

    /* renamed from: uk  reason: collision with root package name */
    public Button f7808uk;

    /* renamed from: yj  reason: collision with root package name */
    public Button f7809yj;

    /* renamed from: fe.mmm.qw.f.fe.ad.ad$ad  reason: collision with other inner class name */
    public class C0279ad implements View.OnClickListener {
        public C0279ad() {
        }

        public void onClick(View view) {
            ICommonTitleBarClickListener iCommonTitleBarClickListener = ad.this.f334switch;
            if (iCommonTitleBarClickListener != null) {
                iCommonTitleBarClickListener.onBackButtonClicked();
            }
        }
    }

    public class de implements View.OnClickListener {
        public de() {
        }

        public void onClick(View view) {
            ICommonTitleBarClickListener iCommonTitleBarClickListener = ad.this.f334switch;
            if (iCommonTitleBarClickListener != null) {
                iCommonTitleBarClickListener.onRightButtonClicked(view);
            }
        }
    }

    public class qw implements View.OnClickListener {
        public qw() {
        }

        public void onClick(View view) {
            ad.this.f7804o.setVisibility(8);
            ICommonTitleBarClickListener iCommonTitleBarClickListener = ad.this.f334switch;
            if (iCommonTitleBarClickListener != null) {
                iCommonTitleBarClickListener.onRightButtonClicked(view);
            }
        }
    }

    public ad(Activity activity) {
        super(activity);
    }

    public void aaa(ICommonTitleBarClickListener iCommonTitleBarClickListener) {
        this.f334switch = iCommonTitleBarClickListener;
    }

    public void ad() {
        this.qw.clear();
        this.f7808uk = null;
        this.f7809yj = null;
        this.f7803i = null;
        this.f7806rg = null;
        this.f334switch = null;
        this.f7802fe = null;
    }

    public void ddd(String str) {
        xxx(true);
        Button button = this.f7809yj;
        if (button != null) {
            try {
                button.setTextColor(Color.parseColor(str));
            } catch (Exception unused) {
                fe.mmm.qw.i.qw.rg("BaseTitleBar", "Unknown color");
            }
        }
    }

    public ViewGroup fe() {
        return this.f7802fe;
    }

    public void ggg(boolean z) {
        ImageView imageView = this.f7804o;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void i(Drawable drawable) {
        ImageView imageView = this.f7803i;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.f7803i.setImageDrawable(drawable);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m968if(@ColorInt int i2) {
        this.f7806rg.setBackgroundColor(i2);
    }

    public void mmm(int i2) {
        qqq(i2);
    }

    public void nn(boolean z) {
        ViewGroup viewGroup = this.f7802fe;
        if (viewGroup != null) {
            if (z) {
                viewGroup.setVisibility(0);
            } else {
                viewGroup.setVisibility(8);
            }
        }
    }

    public void o(boolean z) {
        ImageView imageView = this.f7803i;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void pf(int i2) {
        this.f7806rg.setBackgroundColor(fe.mmm.qw.d.de.de.when().i(i2));
    }

    public void ppp(@DrawableRes int i2) {
        ImageButton imageButton = this.f7805pf;
        if (imageButton != null) {
            imageButton.setVisibility(0);
            this.f7805pf.setBackgroundResource(i2);
        }
    }

    public final void qqq(int i2) {
        ViewGroup viewGroup = this.f7806rg;
        if (viewGroup != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.getLayoutParams();
            layoutParams.topMargin = i2;
            this.f7806rg.setLayoutParams(layoutParams);
        }
    }

    public void rg() {
        ViewStub viewStub = (ViewStub) de(R.id.viewstub_general_title);
        if (viewStub != null) {
            viewStub.setLayoutResource(R.layout.title_bar_general);
            viewStub.inflate();
            this.f7802fe = (ViewGroup) de(R.id.title_bar_general_root_view);
            uk();
        }
    }

    /* renamed from: switch  reason: not valid java name */
    public void m969switch(int i2) {
        TextView textView = this.f333if;
        if (textView != null) {
            textView.setText(i2);
        }
    }

    public void uk() {
        this.f7806rg = (ViewGroup) de(R.id.title_bar_root_view);
        this.f7807th = (TextView) de(R.id.title_text);
        this.f333if = (TextView) de(R.id.middle_title_text);
        this.f7808uk = (Button) de(R.id.left_place_holder);
        ImageView imageView = (ImageView) de(R.id.right_button_tag);
        this.f7804o = imageView;
        imageView.setVisibility(8);
        Button button = (Button) de(R.id.right_button);
        this.f7809yj = button;
        button.setOnClickListener(new qw());
        xxx(false);
        ImageView imageView2 = (ImageView) de(R.id.left_button);
        this.f7803i = imageView2;
        imageView2.setOnClickListener(new C0279ad());
        ImageButton imageButton = (ImageButton) de(R.id.right_menu_button);
        this.f7805pf = imageButton;
        imageButton.setOnClickListener(new de());
    }

    public void vvv(String str) {
        xxx(true);
        Button button = this.f7809yj;
        if (button != null) {
            button.setText(str);
            this.f7809yj.setTextColor(fe.mmm.qw.d.de.de.when().i(R.color.text_content_color));
        }
        Button button2 = this.f7808uk;
        if (button2 != null) {
            button2.setText(str);
        }
    }

    public void when(String str) {
        TextView textView = this.f333if;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void xxx(boolean z) {
        Button button = this.f7809yj;
        if (button != null) {
            button.setVisibility(z ? 0 : 4);
        }
        ImageView imageView = this.f7804o;
        if (imageView != null) {
            imageView.setVisibility(imageView.getVisibility());
        }
    }

    public TextView yj() {
        return this.f333if;
    }
}
