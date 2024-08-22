package com.tera.scan.main.view;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.aiscan.R;
import com.bumptech.glide.request.transition.Transition;
import com.tera.scan.ui.view.helper.UITextViewHelper;
import com.tera.scan.ui.view.widget.UITextView;
import com.tera.scan.vip.network.BusinessGuideViewModel;
import com.tera.scan.vip.network.model.PrivilegeInfoData;
import com.tera.scan.vip.network.model.RightsInfoData;
import com.tera.scan.vip.network.model.UserCardInfoResponse;
import com.tera.scan.vip.network.model.UserGuideData;
import fe.mmm.qw.k.fe.ad;
import fe.mmm.qw.xxx.ppp.fe;
import fe.rg.qw.rg;
import fe.rg.qw.when.fe.th;
import java.text.DecimalFormat;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0006\u0010\u0015\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/tera/scan/main/view/UserCenterCardScene;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "container", "Landroid/view/ViewGroup;", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewGroup;)V", "data", "Lcom/tera/scan/vip/network/model/UserCardInfoResponse;", "initCardContent", "", "view", "Landroid/view/View;", "initPrivilege", "isNotShowUserCard", "", "priceShow", "", "nowPrice", "", "setUserCardSize", "show", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserCenterCardScene {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final ViewGroup f6998ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public UserCardInfoResponse f6999de;
    @NotNull
    public final FragmentActivity qw;

    public static final class qw extends th<Bitmap> {

        /* renamed from: uk  reason: collision with root package name */
        public final /* synthetic */ ImageView f7000uk;

        public qw(ImageView imageView) {
            this.f7000uk = imageView;
        }

        public void de(@Nullable Drawable drawable) {
            super.de(drawable);
            int i2 = ad.qw.qw() ? R.drawable.icon_svip_user_title : R.drawable.icon_user_title_limit;
            ImageView imageView = this.f7000uk;
            if (imageView != null) {
                imageView.setImageResource(i2);
            }
        }

        /* renamed from: uk */
        public void rg(@NotNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
            Intrinsics.checkNotNullParameter(bitmap, "p0");
            ImageView imageView = this.f7000uk;
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }

    public UserCenterCardScene(@NotNull FragmentActivity fragmentActivity, @NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(viewGroup, "container");
        this.qw = fragmentActivity;
        this.f6998ad = viewGroup;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r2 = r2.getGuideData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void fe(com.tera.scan.main.view.UserCenterCardScene r1, android.view.View r2) {
        /*
            java.lang.String r2 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            com.tera.scan.vip.network.model.UserCardInfoResponse r2 = r1.f6999de
            if (r2 == 0) goto L_0x0014
            com.tera.scan.vip.network.model.UserGuideData r2 = r2.getGuideData()
            if (r2 == 0) goto L_0x0014
            java.lang.String r2 = r2.getButtonUrl()
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            androidx.fragment.app.FragmentActivity r1 = r1.qw
            java.lang.String r0 = "personal_center"
            fe.mmm.qw.k.i.ad.de(r1, r2, r0)
            fe.mmm.qw.k.ad.fe()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.main.view.UserCenterCardScene.fe(com.tera.scan.main.view.UserCenterCardScene, android.view.View):void");
    }

    public static final void o(UserCenterCardScene userCenterCardScene, View view, UserCardInfoResponse userCardInfoResponse) {
        Intrinsics.checkNotNullParameter(userCenterCardScene, "this$0");
        if (userCardInfoResponse != null) {
            userCenterCardScene.f6999de = userCardInfoResponse;
            if (!userCenterCardScene.th()) {
                userCenterCardScene.de(view);
                userCenterCardScene.rg(view);
                userCenterCardScene.f6998ad.addView(view);
                fe.mmm.qw.th.qw.rg.fe.de.qw.fe(userCenterCardScene.f6998ad);
            }
        }
    }

    public final void de(View view) {
        CharSequence charSequence;
        UserGuideData guideData;
        UserGuideData guideData2;
        UserGuideData guideData3;
        CharSequence charSequence2;
        RightsInfoData rightsInfo;
        RightsInfoData rightsInfo2;
        UserGuideData guideData4;
        Long price;
        UITextViewHelper helper;
        UITextViewHelper helper2;
        String str = null;
        ImageView imageView = view != null ? (ImageView) view.findViewById(R.id.bg_root) : null;
        ImageView imageView2 = view != null ? (ImageView) view.findViewById(R.id.iv_title) : null;
        TextView textView = view != null ? (TextView) view.findViewById(R.id.tv_price) : null;
        TextView textView2 = view != null ? (TextView) view.findViewById(R.id.tv_price_left) : null;
        TextView textView3 = view != null ? (TextView) view.findViewById(R.id.tv_privilege) : null;
        UITextView uITextView = view != null ? (UITextView) view.findViewById(R.id.tv_enter) : null;
        ImageView imageView3 = view != null ? (ImageView) view.findViewById(R.id.iv_bg_bottom) : null;
        ImageView imageView4 = view != null ? (ImageView) view.findViewById(R.id.iv_right) : null;
        if (ad.qw.qw()) {
            if (imageView != null) {
                imageView.setBackgroundResource(R.drawable.bg_svip_user_card);
            }
            if (textView3 != null) {
                textView3.setTextColor(this.qw.getResources().getColor(R.color.white_80p_transparent));
            }
            if (uITextView != null) {
                uITextView.setTextColor(this.qw.getResources().getColor(R.color.accent_color));
            }
            if (!(uITextView == null || (helper2 = uITextView.getHelper()) == null)) {
                int[] intArray = this.qw.getResources().getIntArray(R.array.bg_user_card);
                Intrinsics.checkNotNullExpressionValue(intArray, "activity.resources.getIn…ray(R.array.bg_user_card)");
                helper2.c(intArray);
            }
            if (imageView3 != null) {
                imageView3.setImageResource(R.drawable.bg_svip_user_bottom_card);
            }
            if (imageView4 != null) {
                imageView4.setImageResource(R.drawable.icon_svip_user_right);
            }
        } else {
            if (imageView != null) {
                imageView.setBackgroundResource(R.drawable.bg_user_card);
            }
            if (textView3 != null) {
                textView3.setTextColor(this.qw.getResources().getColor(R.color.accent_color));
            }
            if (uITextView != null) {
                uITextView.setTextColor(this.qw.getResources().getColor(R.color.secondary_accent_color));
            }
            if (!(uITextView == null || (helper = uITextView.getHelper()) == null)) {
                helper.b(this.qw.getResources().getColor(R.color.color_black));
            }
            if (imageView3 != null) {
                imageView3.setImageResource(R.drawable.bg_user_bottom_card);
            }
            if (imageView4 != null) {
                imageView4.setImageResource(R.drawable.icon_user_right);
            }
        }
        UserCardInfoResponse userCardInfoResponse = this.f6999de;
        String yj2 = yj((userCardInfoResponse == null || (guideData4 = userCardInfoResponse.getGuideData()) == null || (price = guideData4.getPrice()) == null) ? 0 : price.longValue());
        boolean z = true;
        if (!ad.qw.qw()) {
            if (yj2.length() > 0) {
                if (textView != null) {
                    textView.setVisibility(0);
                }
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                if (textView != null) {
                    textView.setText(yj2);
                }
            }
        }
        if (textView3 != null) {
            UserCardInfoResponse userCardInfoResponse2 = this.f6999de;
            String title = (userCardInfoResponse2 == null || (rightsInfo2 = userCardInfoResponse2.getRightsInfo()) == null) ? null : rightsInfo2.getTitle();
            if (title == null || title.length() == 0) {
                charSequence2 = this.qw.getResources().getText(R.string.user_card_privilege_text);
            } else {
                UserCardInfoResponse userCardInfoResponse3 = this.f6999de;
                charSequence2 = (userCardInfoResponse3 == null || (rightsInfo = userCardInfoResponse3.getRightsInfo()) == null) ? null : rightsInfo.getTitle();
            }
            textView3.setText(charSequence2);
        }
        if (ad.qw.qw()) {
            charSequence = this.qw.getResources().getText(R.string.user_card_svip_button_text);
        } else {
            charSequence = this.qw.getResources().getText(R.string.user_card_button_text);
        }
        Intrinsics.checkNotNullExpressionValue(charSequence, "if (VipInit.isVip())\n   …ng.user_card_button_text)");
        if (uITextView != null) {
            UserCardInfoResponse userCardInfoResponse4 = this.f6999de;
            String buttonText = (userCardInfoResponse4 == null || (guideData3 = userCardInfoResponse4.getGuideData()) == null) ? null : guideData3.getButtonText();
            if (!(buttonText == null || buttonText.length() == 0)) {
                z = false;
            }
            if (!z) {
                UserCardInfoResponse userCardInfoResponse5 = this.f6999de;
                charSequence = (userCardInfoResponse5 == null || (guideData2 = userCardInfoResponse5.getGuideData()) == null) ? null : guideData2.getButtonText();
            }
            uITextView.setText(charSequence);
        }
        rg<Bitmap> i2 = fe.rg.qw.ad.qqq(this.qw).i();
        UserCardInfoResponse userCardInfoResponse6 = this.f6999de;
        if (!(userCardInfoResponse6 == null || (guideData = userCardInfoResponse6.getGuideData()) == null)) {
            str = guideData.getIcon();
        }
        i2.nn(str);
        i2.o(new qw(imageView2));
        if (view != null) {
            view.setOnClickListener(new fe(this));
        }
    }

    public final void i() {
        View inflate = LayoutInflater.from(this.qw).inflate(R.layout.layout_user_center, (ViewGroup) null, false);
        ((BusinessGuideViewModel) new ViewModelProvider(this.qw).get(BusinessGuideViewModel.class)).getUserCardInfo(this.qw).observe(this.qw, new fe.mmm.qw.xxx.ppp.qw(this, inflate));
        this.f6998ad.getViewTreeObserver().addOnGlobalLayoutListener(new UserCenterCardScene$show$2(this, inflate));
        fe.mmm.qw.k.ad.rg();
    }

    public final void rg(View view) {
        RightsInfoData rightsInfo;
        String str = null;
        ImageView imageView = view != null ? (ImageView) view.findViewById(R.id.list_privilege) : null;
        if (imageView != null) {
            fe.rg.qw.th qqq = fe.rg.qw.ad.qqq(this.qw);
            UserCardInfoResponse userCardInfoResponse = this.f6999de;
            if (!(userCardInfoResponse == null || (rightsInfo = userCardInfoResponse.getRightsInfo()) == null)) {
                str = rightsInfo.getListIconUrl();
            }
            qqq.vvv(str).m317switch(imageView);
        }
    }

    public final boolean th() {
        RightsInfoData rightsInfo;
        List<PrivilegeInfoData> subCardList;
        RightsInfoData rightsInfo2;
        UserGuideData guideData;
        UserCardInfoResponse userCardInfoResponse = this.f6999de;
        List<PrivilegeInfoData> list = null;
        if ((userCardInfoResponse != null ? userCardInfoResponse.getGuideData() : null) != null) {
            UserCardInfoResponse userCardInfoResponse2 = this.f6999de;
            if (((userCardInfoResponse2 == null || (guideData = userCardInfoResponse2.getGuideData()) == null) ? null : guideData.getIcon()) != null) {
                UserCardInfoResponse userCardInfoResponse3 = this.f6999de;
                if ((userCardInfoResponse3 != null ? userCardInfoResponse3.getRightsInfo() : null) != null) {
                    UserCardInfoResponse userCardInfoResponse4 = this.f6999de;
                    if (!(userCardInfoResponse4 == null || (rightsInfo2 = userCardInfoResponse4.getRightsInfo()) == null)) {
                        list = rightsInfo2.getSubCardList();
                    }
                    if (list != null) {
                        UserCardInfoResponse userCardInfoResponse5 = this.f6999de;
                        return ((userCardInfoResponse5 == null || (rightsInfo = userCardInfoResponse5.getRightsInfo()) == null || (subCardList = rightsInfo.getSubCardList()) == null) ? -1 : subCardList.size()) <= 0;
                    }
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r7v9, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void uk(android.view.View r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L_0x000d
            r1 = 2131361998(0x7f0a00ce, float:1.8343764E38)
            android.view.View r1 = r7.findViewById(r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            goto L_0x000e
        L_0x000d:
            r1 = r0
        L_0x000e:
            if (r7 == 0) goto L_0x001a
            r2 = 2131362676(0x7f0a0374, float:1.834514E38)
            android.view.View r2 = r7.findViewById(r2)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            goto L_0x001b
        L_0x001a:
            r2 = r0
        L_0x001b:
            if (r7 == 0) goto L_0x0027
            r3 = 2131362611(0x7f0a0333, float:1.8345007E38)
            android.view.View r3 = r7.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            goto L_0x0028
        L_0x0027:
            r3 = r0
        L_0x0028:
            if (r7 == 0) goto L_0x0034
            r0 = 2131362795(0x7f0a03eb, float:1.834538E38)
            android.view.View r7 = r7.findViewById(r0)
            r0 = r7
            android.widget.ImageView r0 = (android.widget.ImageView) r0
        L_0x0034:
            android.view.ViewGroup r7 = r6.f6998ad
            int r7 = r7.getWidth()
            androidx.fragment.app.FragmentActivity r4 = r6.qw
            r5 = 1101004800(0x41a00000, float:20.0)
            int r4 = fe.mmm.qw.p030switch.th.de.ad.qw.qw(r4, r5)
            int r7 = r7 - r4
            if (r1 == 0) goto L_0x0055
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
            if (r1 == 0) goto L_0x0055
            r1.width = r7
            float r4 = (float) r7
            r5 = 1074329027(0x4008f5c3, float:2.14)
            float r4 = r4 / r5
            int r4 = (int) r4
            r1.height = r4
        L_0x0055:
            androidx.fragment.app.FragmentActivity r1 = r6.qw
            r4 = 1086324736(0x40c00000, float:6.0)
            int r1 = fe.mmm.qw.p030switch.th.de.ad.qw.qw(r1, r4)
            int r7 = r7 - r1
            if (r3 == 0) goto L_0x0070
            android.view.ViewGroup$LayoutParams r1 = r3.getLayoutParams()
            if (r1 == 0) goto L_0x0070
            r1.width = r7
            float r3 = (float) r7
            r4 = 1082927350(0x408c28f6, float:4.38)
            float r3 = r3 / r4
            int r3 = (int) r3
            r1.height = r3
        L_0x0070:
            androidx.fragment.app.FragmentActivity r1 = r6.qw
            r3 = 1103101952(0x41c00000, float:24.0)
            int r1 = fe.mmm.qw.p030switch.th.de.ad.qw.qw(r1, r3)
            int r1 = r7 - r1
            if (r0 == 0) goto L_0x008c
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            if (r0 == 0) goto L_0x008c
            r0.width = r1
            float r7 = (float) r7
            r1 = 1085905306(0x40b9999a, float:5.8)
            float r7 = r7 / r1
            int r7 = (int) r7
            r0.height = r7
        L_0x008c:
            if (r2 == 0) goto L_0x00af
            android.view.ViewGroup$LayoutParams r7 = r2.getLayoutParams()
            if (r7 == 0) goto L_0x00af
            fe.mmm.qw.k.fe.ad r0 = fe.mmm.qw.k.fe.ad.qw
            boolean r0 = r0.qw()
            if (r0 == 0) goto L_0x00a5
            androidx.fragment.app.FragmentActivity r0 = r6.qw
            r1 = 1121714176(0x42dc0000, float:110.0)
            int r0 = fe.mmm.qw.p030switch.th.de.ad.qw.qw(r0, r1)
            goto L_0x00ad
        L_0x00a5:
            androidx.fragment.app.FragmentActivity r0 = r6.qw
            r1 = 1119092736(0x42b40000, float:90.0)
            int r0 = fe.mmm.qw.p030switch.th.de.ad.qw.qw(r0, r1)
        L_0x00ad:
            r7.width = r0
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.main.view.UserCenterCardScene.uk(android.view.View):void");
    }

    public final String yj(long j) {
        try {
            Result.Companion companion = Result.Companion;
            String format = new DecimalFormat("#.##").format((((double) j) * 1.0d) / ((double) 100));
            Intrinsics.checkNotNullExpressionValue(format, "formatter.format(nowPric….0 / PRICE_TO_SHOW_RATIO)");
            return format;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Object r4 = Result.m1155constructorimpl(ResultKt.createFailure(th2));
            if (Result.m1161isFailureimpl(r4)) {
                r4 = "";
            }
            return (String) r4;
        }
    }
}
