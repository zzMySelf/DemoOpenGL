package com.baidu.searchbox.feed.payment.combinationbuy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.feed.payment.FeedpayKt;
import com.baidu.searchbox.feed.payment.column.R;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/feed/payment/combinationbuy/CbHeaderFacet;", "Lcom/baidu/searchbox/feed/payment/combinationbuy/CbFacet;", "cbContext", "Lcom/baidu/searchbox/feed/payment/combinationbuy/CombinationBuyContext;", "(Lcom/baidu/searchbox/feed/payment/combinationbuy/CombinationBuyContext;)V", "authorImg", "Lcom/facebook/drawee/view/SimpleDraweeView;", "authorThanks", "Landroid/widget/TextView;", "bgImage", "data", "Lcom/baidu/searchbox/feed/payment/combinationbuy/CombinationBuyResponseData;", "rootView", "Landroid/view/View;", "titleIcon", "Landroid/widget/ImageView;", "titleText", "createView", "onModelReceived", "", "setEnabled", "enabled", "", "updateUi", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CbHeaderFacet.kt */
public final class CbHeaderFacet extends CbFacet {
    private SimpleDraweeView authorImg;
    private TextView authorThanks;
    private SimpleDraweeView bgImage;
    private final CombinationBuyContext cbContext;
    private CombinationBuyResponseData data;
    private View rootView;
    private ImageView titleIcon;
    private TextView titleText;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CbHeaderFacet(CombinationBuyContext cbContext2) {
        super(cbContext2);
        Intrinsics.checkNotNullParameter(cbContext2, "cbContext");
        this.cbContext = cbContext2;
    }

    public View createView() {
        View inflate = LayoutInflater.from(FeedpayKt.appContext()).inflate(R.layout.feed_combination_buy_header_layout, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(appContext())\n     …_buy_header_layout, null)");
        this.rootView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.bg_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.bg_image)");
        this.bgImage = (SimpleDraweeView) findViewById;
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.title_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.title_icon)");
        this.titleIcon = (ImageView) findViewById2;
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.title_text);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.title_text)");
        this.titleText = (TextView) findViewById3;
        View view4 = this.rootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.author_img);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.author_img)");
        this.authorImg = (SimpleDraweeView) findViewById4;
        View view5 = this.rootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            view5 = null;
        }
        View findViewById5 = view5.findViewById(R.id.author_thanks);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.author_thanks)");
        this.authorThanks = (TextView) findViewById5;
        updateUi();
        View view6 = this.rootView;
        if (view6 != null) {
            return view6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        return null;
    }

    public void updateUi() {
        View view2 = this.rootView;
        TextView textView = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            view2 = null;
        }
        view2.setBackground(ContextCompat.getDrawable(FeedpayKt.appContext(), R.drawable.feed_combination_buy_header_bg));
        ImageView imageView = this.titleIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleIcon");
            imageView = null;
        }
        imageView.setImageDrawable(ContextCompat.getDrawable(FeedpayKt.appContext(), R.drawable.feed_combination_buy_title_icon));
        TextView textView2 = this.titleText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleText");
            textView2 = null;
        }
        textView2.setTextColor(ContextCompat.getColor(FeedpayKt.appContext(), com.baidu.android.common.ui.style.R.color.GC6));
        TextView textView3 = this.authorThanks;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorThanks");
            textView3 = null;
        }
        textView3.setBackground(ContextCompat.getDrawable(FeedpayKt.appContext(), R.drawable.feed_combination_buy_author_thanks_bg));
        TextView textView4 = this.authorThanks;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("authorThanks");
        } else {
            textView = textView4;
        }
        textView.setTextColor(ContextCompat.getColor(FeedpayKt.appContext(), com.baidu.android.common.ui.style.R.color.GC1));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        r3 = r3.author;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onModelReceived() {
        /*
            r6 = this;
            com.baidu.searchbox.feed.payment.combinationbuy.CombinationBuyContext r0 = r6.cbContext
            com.baidu.searchbox.feed.payment.combinationbuy.CombinationBuyViewModel r0 = r0.getViewModel()
            com.baidu.searchbox.feed.payment.combinationbuy.CombinationBuyResponseData r0 = r0.getData()
            r6.data = r0
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0017
            boolean r0 = r0.isGoldenStyle()
            if (r0 != r1) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r1 = r2
        L_0x0018:
            r0 = 0
            if (r1 == 0) goto L_0x004b
            android.widget.ImageView r1 = r6.titleIcon
            if (r1 != 0) goto L_0x0026
            java.lang.String r1 = "titleIcon"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r0
        L_0x0026:
            android.content.Context r3 = com.baidu.searchbox.feed.payment.FeedpayKt.appContext()
            int r4 = com.baidu.searchbox.feed.payment.column.R.drawable.feed_combination_buy_title_golden_icon
            android.graphics.drawable.Drawable r3 = androidx.core.content.ContextCompat.getDrawable(r3, r4)
            r1.setImageDrawable(r3)
            android.widget.TextView r1 = r6.titleText
            if (r1 != 0) goto L_0x003e
            java.lang.String r1 = "titleText"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r0
        L_0x003e:
            android.content.Context r3 = com.baidu.searchbox.feed.payment.FeedpayKt.appContext()
            int r4 = com.baidu.searchbox.feed.styles.R.color.FC503
            int r3 = androidx.core.content.ContextCompat.getColor(r3, r4)
            r1.setTextColor(r3)
        L_0x004b:
            com.facebook.drawee.view.SimpleDraweeView r1 = r6.authorImg
            if (r1 != 0) goto L_0x0055
            java.lang.String r1 = "authorImg"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r0
        L_0x0055:
            com.baidu.searchbox.feed.payment.combinationbuy.CombinationBuyResponseData r3 = r6.data
            if (r3 == 0) goto L_0x0060
            com.baidu.searchbox.feed.payment.combinationbuy.Author r3 = r3.author
            if (r3 == 0) goto L_0x0060
            java.lang.String r3 = r3.avatar
            goto L_0x0061
        L_0x0060:
            r3 = r0
        L_0x0061:
            r1.setImageURI((java.lang.String) r3)
            android.widget.TextView r1 = r6.authorThanks
            if (r1 != 0) goto L_0x006e
            java.lang.String r1 = "authorThanks"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r1 = r0
        L_0x006e:
            com.baidu.searchbox.feed.payment.combinationbuy.CombinationBuyResponseData r3 = r6.data
            if (r3 == 0) goto L_0x0079
            com.baidu.searchbox.feed.payment.combinationbuy.Author r3 = r3.author
            if (r3 == 0) goto L_0x0079
            java.lang.String r3 = r3.subtitle
            goto L_0x007a
        L_0x0079:
            r3 = r0
        L_0x007a:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            com.baidu.searchbox.feed.payment.combinationbuy.CombinationBuyResponseData r1 = r6.data
            if (r1 == 0) goto L_0x00a2
            java.lang.String r1 = r1.headerImg
            if (r1 == 0) goto L_0x00a2
            r3 = 0
            com.facebook.drawee.view.SimpleDraweeView r4 = r6.bgImage
            java.lang.String r5 = "bgImage"
            if (r4 != 0) goto L_0x0092
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r4 = r0
        L_0x0092:
            r4.setImageURI((java.lang.String) r1)
            com.facebook.drawee.view.SimpleDraweeView r4 = r6.bgImage
            if (r4 != 0) goto L_0x009d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            goto L_0x009e
        L_0x009d:
            r0 = r4
        L_0x009e:
            r0.setVisibility(r2)
        L_0x00a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.combinationbuy.CbHeaderFacet.onModelReceived():void");
    }

    public void setEnabled(boolean enabled) {
    }
}
