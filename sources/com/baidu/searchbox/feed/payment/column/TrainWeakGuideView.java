package com.baidu.searchbox.feed.payment.column;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.feed.styles.R;
import com.baidu.searchbox.feed.template.FeedDraweeView;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0003J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J*\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0002R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/feed/payment/column/TrainWeakGuideView;", "Landroid/widget/PopupWindow;", "Lcom/baidu/searchbox/skin/callback/NightModeChangeListener;", "context", "Landroid/content/Context;", "authorIcon", "", "tips", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "getAuthorIcon", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "rootView", "Landroid/view/ViewGroup;", "getTips", "initView", "", "onNightModeChanged", "isNightModel", "", "showAtLocation", "parent", "Landroid/view/View;", "gravity", "", "x", "y", "updateUi", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TrainWeakGuideView.kt */
public final class TrainWeakGuideView extends PopupWindow implements NightModeChangeListener {
    private final String authorIcon;
    private final Context context;
    private ViewGroup rootView;
    private final String tips;

    public final Context getContext() {
        return this.context;
    }

    public final String getAuthorIcon() {
        return this.authorIcon;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TrainWeakGuideView(Context context2, String authorIcon2, String tips2) {
        super(context2);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(tips2, "tips");
        this.context = context2;
        this.authorIcon = authorIcon2;
        this.tips = tips2;
        initView();
        setWidth(-2);
        setHeight(-2);
        setFocusable(false);
        setOutsideTouchable(false);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    public final String getTips() {
        return this.tips;
    }

    /* JADX WARNING: type inference failed for: r1v5, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initView() {
        /*
            r4 = this;
            android.content.Context r0 = r4.context
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = com.baidu.searchbox.feed.payment.column.R.layout.feed_train_weak_guide
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r2)
            boolean r1 = r0 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x0014
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x0015
        L_0x0014:
            r0 = r2
        L_0x0015:
            r4.rootView = r0
            android.view.View r0 = (android.view.View) r0
            r4.setContentView(r0)
            android.view.ViewGroup r0 = r4.rootView
            if (r0 == 0) goto L_0x0029
            int r1 = com.baidu.searchbox.feed.payment.column.R.id.author_image
            android.view.View r0 = r0.findViewById(r1)
            com.baidu.searchbox.feed.template.FeedDraweeView r0 = (com.baidu.searchbox.feed.template.FeedDraweeView) r0
            goto L_0x002a
        L_0x0029:
            r0 = r2
        L_0x002a:
            if (r0 == 0) goto L_0x0037
            android.content.Context r1 = r4.context
            int r3 = com.baidu.searchbox.feed.payment.column.R.drawable.feed_train_author_header
            android.graphics.drawable.Drawable r1 = androidx.core.content.ContextCompat.getDrawable(r1, r3)
            r0.setPlaceHolderWithCenterCrop(r1)
        L_0x0037:
            if (r0 == 0) goto L_0x003e
            java.lang.String r1 = r4.authorIcon
            r0.loadImageWithoutModel(r1)
        L_0x003e:
            android.view.ViewGroup r1 = r4.rootView
            if (r1 == 0) goto L_0x004b
            int r2 = com.baidu.searchbox.feed.payment.column.R.id.tips_text
            android.view.View r1 = r1.findViewById(r2)
            r2 = r1
            android.widget.TextView r2 = (android.widget.TextView) r2
        L_0x004b:
            if (r2 != 0) goto L_0x004e
            goto L_0x0055
        L_0x004e:
            java.lang.String r1 = r4.tips
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2.setText(r1)
        L_0x0055:
            r4.updateUi()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.column.TrainWeakGuideView.initView():void");
    }

    private final void updateUi() {
        ImageView imageView;
        FeedDraweeView feedDraweeView;
        TextView textView;
        LinearLayout linearLayout;
        ViewGroup viewGroup = this.rootView;
        if (!(viewGroup == null || (linearLayout = (LinearLayout) viewGroup.findViewById(R.id.content_view)) == null)) {
            linearLayout.setBackgroundResource(R.drawable.feed_train_weak_guide_background);
        }
        ViewGroup viewGroup2 = this.rootView;
        if (!(viewGroup2 == null || (textView = (TextView) viewGroup2.findViewById(R.id.tips_text)) == null)) {
            textView.setTextColor(ContextCompat.getColor(this.context, R.color.FC208));
        }
        ViewGroup viewGroup3 = this.rootView;
        if (!(viewGroup3 == null || (feedDraweeView = (FeedDraweeView) viewGroup3.findViewById(R.id.author_image)) == null)) {
            feedDraweeView.setBackgroundResource(R.drawable.feed_train_weak_guide_author_background);
        }
        ViewGroup viewGroup4 = this.rootView;
        if (viewGroup4 != null && (imageView = (ImageView) viewGroup4.findViewById(R.id.arrow_image)) != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.feed_train_weak_guide_arrow));
        }
    }

    public void showAtLocation(View parent, int gravity, int x, int y) {
        ViewGroup viewGroup;
        super.showAtLocation(parent, gravity, x, y);
        if (isShowing() && (viewGroup = this.rootView) != null) {
            viewGroup.postDelayed(new TrainWeakGuideView$$ExternalSyntheticLambda0(this), 5000);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showAtLocation$lambda-0  reason: not valid java name */
    public static final void m19004showAtLocation$lambda0(TrainWeakGuideView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isShowing()) {
            this$0.dismiss();
        }
    }

    public void onNightModeChanged(boolean isNightModel) {
        updateUi();
    }
}
