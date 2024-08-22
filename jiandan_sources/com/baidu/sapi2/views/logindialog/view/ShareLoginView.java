package com.baidu.sapi2.views.logindialog.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.aiscan.R;
import com.baidu.cloudsdk.common.imgloader.AsyncImageLoader;
import com.baidu.cloudsdk.common.imgloader.ImageManager;
import com.baidu.sapi2.CoreViewRouter;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.shell.listener.WebAuthListener;
import com.baidu.sapi2.shell.result.WebAuthResult;
import com.baidu.sapi2.views.logindialog.bean.QuickLoginResult;
import com.baidu.sapi2.views.logindialog.enums.QuickLoginType;
import com.baidu.sapi2.views.logindialog.interf.ILoginConfirmCallback;
import java.text.MessageFormat;

public class ShareLoginView extends RelativeLayout {
    public static final String j = "quick_login";
    public Context a;
    public Activity b;
    public View c;
    public ImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public ShareStorage.StorageModel h;

    /* renamed from: i  reason: collision with root package name */
    public ILoginConfirmCallback f986i;

    public class a implements View.OnClickListener {

        /* renamed from: com.baidu.sapi2.views.logindialog.view.ShareLoginView$a$a  reason: collision with other inner class name */
        public class C0045a implements Runnable {

            /* renamed from: com.baidu.sapi2.views.logindialog.view.ShareLoginView$a$a$a  reason: collision with other inner class name */
            public class C0046a extends WebAuthListener {
                public final /* synthetic */ long a;

                public C0046a(long j) {
                    this.a = j;
                }

                public void onFailure(WebAuthResult webAuthResult) {
                    if (ShareLoginView.this.f986i != null) {
                        com.baidu.sapi2.views.logindialog.utils.a.a("share_login", System.currentTimeMillis() - this.a, webAuthResult.getResultCode(), webAuthResult.getResultMsg());
                        QuickLoginResult quickLoginResult = new QuickLoginResult();
                        quickLoginResult.setResultCode(webAuthResult.getResultCode());
                        quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
                        quickLoginResult.mLoginType = QuickLoginType.SHARE;
                        ShareLoginView.this.f986i.onFailure(quickLoginResult);
                    }
                }

                public void onSuccess(WebAuthResult webAuthResult) {
                    if (ShareLoginView.this.f986i != null) {
                        com.baidu.sapi2.views.logindialog.utils.a.a("share_login", System.currentTimeMillis() - this.a, webAuthResult.getResultCode(), webAuthResult.getResultMsg());
                        QuickLoginResult quickLoginResult = new QuickLoginResult();
                        quickLoginResult.setResultCode(webAuthResult.getResultCode());
                        quickLoginResult.setResultMsg(webAuthResult.getResultMsg());
                        quickLoginResult.mLoginType = QuickLoginType.SHARE;
                        ShareLoginView.this.f986i.onSuccess(quickLoginResult);
                    }
                }
            }

            public C0045a() {
            }

            public void run() {
                CoreViewRouter.getInstance().invokeV2ShareLogin(ShareLoginView.this.b, ShareLoginView.this.h, (WebAuthListener) new C0046a(System.currentTimeMillis()), "quick_login");
            }
        }

        public a() {
        }

        public void onClick(View view) {
            if (ShareLoginView.this.b != null && ShareLoginView.this.h != null && ShareLoginView.this.f986i != null) {
                ShareLoginView.this.f986i.onPostLogin(false, new C0045a());
            }
        }
    }

    public class b implements AsyncImageLoader.IAsyncImageLoaderListener {
        public b() {
        }

        public void onComplete(Bitmap bitmap) {
            ShareLoginView.this.d.setImageBitmap(bitmap);
        }
    }

    public ShareLoginView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TextView getTvButton() {
        return this.g;
    }

    public ShareLoginView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b() {
        LayoutInflater.from(this.a).inflate(R.layout.layout_sapi_dialog_quick_login_share, this);
        this.c = findViewById(R.id.sapi_sdk_view_share_login_shade);
        this.d = (ImageView) findViewById(R.id.sapi_sdk_civ_share_portrait);
        this.e = (TextView) findViewById(R.id.sapi_sdk_civ_share_displayname);
        this.f = (TextView) findViewById(R.id.sapi_sdk_civ_share_subtitle);
        this.g = (TextView) findViewById(R.id.sapi_sdk_tv_share_button);
        a aVar = new a();
        this.c.setOnClickListener(aVar);
        this.g.setOnClickListener(aVar);
    }

    private void c() {
        if (this.h != null && this.a != null) {
            ImageManager.getInstance().loadImage(this.a, Uri.parse(this.h.url), new b());
            this.e.setText(this.h.displayname);
            this.f.setText(MessageFormat.format("{0}使用中，可直接登录", new Object[]{this.h.app}));
        }
    }

    public void a(Activity activity, ShareStorage.StorageModel storageModel, ILoginConfirmCallback iLoginConfirmCallback) {
        this.b = activity;
        this.h = storageModel;
        this.f986i = iLoginConfirmCallback;
        c();
    }

    public ShareLoginView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = context;
        b();
    }

    public void a() {
        this.e.setTextColor(Color.parseColor("#CCFFFFFF"));
        this.f.setTextColor(Color.parseColor("#80FFFFFF"));
        this.c.setBackgroundDrawable(this.a.getResources().getDrawable(R.drawable.pass_quick_login_dialog_share_bg_dark));
    }
}
