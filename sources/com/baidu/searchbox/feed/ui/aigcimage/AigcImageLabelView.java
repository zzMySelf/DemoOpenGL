package com.baidu.searchbox.feed.ui.aigcimage;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.feed.model.AigcImageLabelData;
import com.baidu.searchbox.feed.ui.R;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.unitedscheme.BaseRouter;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001&B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001c\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\b\b\u0001\u0010\u001b\u001a\u00020\bH\u0003J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u000e\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u001dJ\u0006\u0010$\u001a\u00020\u001dJ\u001a\u0010%\u001a\u00020\u001d2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/baidu/searchbox/feed/ui/aigcimage/AigcImageLabelView;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "aigcImageLabelData", "Lcom/baidu/searchbox/feed/model/AigcImageLabelData;", "aigcImageLabelListener", "Lcom/baidu/searchbox/feed/ui/aigcimage/AigcImageLabelView$AigcImageLabelListener;", "getAigcImageLabelListener", "()Lcom/baidu/searchbox/feed/ui/aigcimage/AigcImageLabelView$AigcImageLabelListener;", "setAigcImageLabelListener", "(Lcom/baidu/searchbox/feed/ui/aigcimage/AigcImageLabelView$AigcImageLabelListener;)V", "labelIcon", "Lcom/facebook/drawee/view/SimpleDraweeView;", "labelNext", "labelText", "Landroid/widget/TextView;", "nid", "", "getColorValue", "colorStr", "defaultValueRes", "onClick", "", "v", "Landroid/view/View;", "onFeedNightModeChanged", "isNightMode", "", "onFontSizeChanged", "showAigcImageLabel", "update", "AigcImageLabelListener", "lib-feed-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AigcImageLabelView.kt */
public final class AigcImageLabelView extends LinearLayout implements View.OnClickListener {
    private AigcImageLabelData aigcImageLabelData;
    private AigcImageLabelListener aigcImageLabelListener;
    private final SimpleDraweeView labelIcon;
    private final SimpleDraweeView labelNext;
    private final TextView labelText;
    private String nid;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/feed/ui/aigcimage/AigcImageLabelView$AigcImageLabelListener;", "", "onClick", "", "nid", "", "aigcImageLabelData", "Lcom/baidu/searchbox/feed/model/AigcImageLabelData;", "onShow", "lib-feed-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AigcImageLabelView.kt */
    public interface AigcImageLabelListener {
        void onClick(String str, AigcImageLabelData aigcImageLabelData);

        void onShow(String str, AigcImageLabelData aigcImageLabelData);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AigcImageLabelView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AigcImageLabelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AigcImageLabelView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AigcImageLabelView(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.feed_aigc_image_label_layout, this, true);
        View findViewById = findViewById(R.id.aigc_image_label_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.aigc_image_label_icon)");
        this.labelIcon = (SimpleDraweeView) findViewById;
        View findViewById2 = findViewById(R.id.aigc_image_label_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.aigc_image_label_text)");
        this.labelText = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.aigc_image_label_next);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.aigc_image_label_next)");
        this.labelNext = (SimpleDraweeView) findViewById3;
        setOrientation(0);
        setGravity(16);
        int horizontalPadding = getResources().getDimensionPixelOffset(com.baidu.searchbox.feed.styles.R.dimen.F_M_W_X052);
        int verticalPadding = getResources().getDimensionPixelOffset(com.baidu.searchbox.feed.styles.R.dimen.F_M_H_X069);
        setPadding(horizontalPadding, verticalPadding, horizontalPadding, verticalPadding);
        setOnClickListener(this);
    }

    public final AigcImageLabelListener getAigcImageLabelListener() {
        return this.aigcImageLabelListener;
    }

    public final void setAigcImageLabelListener(AigcImageLabelListener aigcImageLabelListener2) {
        this.aigcImageLabelListener = aigcImageLabelListener2;
    }

    public final void update(AigcImageLabelData aigcImageLabelData2, String nid2) {
        this.aigcImageLabelData = aigcImageLabelData2;
        this.nid = nid2;
        if (aigcImageLabelData2 != null) {
            CharSequence text = aigcImageLabelData2.getText();
            boolean z = true;
            if (!(text == null || text.length() == 0)) {
                CharSequence cmd = aigcImageLabelData2.getCmd();
                if (!(cmd == null || cmd.length() == 0)) {
                    z = false;
                }
                if (!z) {
                    setVisibility(0);
                    this.labelText.setText(aigcImageLabelData2.getText());
                    onFontSizeChanged();
                    onFeedNightModeChanged(NightModeHelper.isNightMode());
                    showAigcImageLabel();
                    return;
                }
            }
        }
        setVisibility(8);
    }

    public final void showAigcImageLabel() {
        AigcImageLabelListener aigcImageLabelListener2;
        AigcImageLabelData aigcImageLabelData2 = this.aigcImageLabelData;
        if (aigcImageLabelData2 != null && (aigcImageLabelListener2 = this.aigcImageLabelListener) != null) {
            aigcImageLabelListener2.onShow(this.nid, aigcImageLabelData2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0168  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onFeedNightModeChanged(boolean r13) {
        /*
            r12 = this;
            com.baidu.searchbox.feed.model.AigcImageLabelData r0 = r12.aigcImageLabelData
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
            r0.<init>()
            android.graphics.drawable.GradientDrawable$Orientation r1 = android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT
            r0.setOrientation(r1)
            r1 = 0
            if (r13 == 0) goto L_0x0023
            com.baidu.searchbox.feed.model.AigcImageLabelData r2 = r12.aigcImageLabelData
            if (r2 == 0) goto L_0x001b
            java.lang.String r2 = r2.getBgColorStartNight()
            goto L_0x001c
        L_0x001b:
            r2 = r1
        L_0x001c:
            int r3 = com.baidu.searchbox.feed.styles.R.color.FC154
            int r2 = r12.getColorValue(r2, r3)
            goto L_0x0033
        L_0x0023:
            com.baidu.searchbox.feed.model.AigcImageLabelData r2 = r12.aigcImageLabelData
            if (r2 == 0) goto L_0x002c
            java.lang.String r2 = r2.getBgColorStart()
            goto L_0x002d
        L_0x002c:
            r2 = r1
        L_0x002d:
            int r3 = com.baidu.searchbox.feed.styles.R.color.FC154
            int r2 = r12.getColorValue(r2, r3)
        L_0x0033:
            if (r13 == 0) goto L_0x0048
            com.baidu.searchbox.feed.model.AigcImageLabelData r3 = r12.aigcImageLabelData
            if (r3 == 0) goto L_0x0040
            java.lang.String r3 = r3.getBgColorEndNight()
            goto L_0x0041
        L_0x0040:
            r3 = r1
        L_0x0041:
            int r4 = com.baidu.searchbox.feed.styles.R.color.FC154
            int r3 = r12.getColorValue(r3, r4)
            goto L_0x0058
        L_0x0048:
            com.baidu.searchbox.feed.model.AigcImageLabelData r3 = r12.aigcImageLabelData
            if (r3 == 0) goto L_0x0051
            java.lang.String r3 = r3.getBgColorEnd()
            goto L_0x0052
        L_0x0051:
            r3 = r1
        L_0x0052:
            int r4 = com.baidu.searchbox.feed.styles.R.color.FC154
            int r3 = r12.getColorValue(r3, r4)
        L_0x0058:
            r4 = 2
            int[] r5 = new int[r4]
            r6 = 0
            r5[r6] = r2
            r7 = 1
            r5[r7] = r3
            r0.setColors(r5)
            int r5 = com.baidu.searchbox.feed.core.R.dimen.dimens_14dp
            int r5 = com.baidu.searchbox.config.FontSizeHelper.getScaledSizeRes(r4, r5, r4)
            float r5 = (float) r5
            r8 = 8
            float[] r8 = new float[r8]
            r8[r6] = r5
            r8[r7] = r5
            r8[r4] = r5
            r4 = 3
            r8[r4] = r5
            r4 = 4
            r8[r4] = r5
            r4 = 5
            r8[r4] = r5
            r4 = 6
            r8[r4] = r5
            r4 = 7
            r8[r4] = r5
            r0.setCornerRadii(r8)
            r4 = r0
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4
            r12.setBackground(r4)
            com.baidu.searchbox.feed.model.AigcImageLabelData r4 = r12.aigcImageLabelData
            if (r13 == 0) goto L_0x009d
            if (r4 == 0) goto L_0x00a4
            java.lang.String r4 = r4.getIconNight()
            goto L_0x00a5
        L_0x009d:
            if (r4 == 0) goto L_0x00a4
            java.lang.String r4 = r4.getIcon()
            goto L_0x00a5
        L_0x00a4:
            r4 = r1
        L_0x00a5:
            r8 = r4
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x00b3
            int r8 = r8.length()
            if (r8 != 0) goto L_0x00b1
            goto L_0x00b3
        L_0x00b1:
            r8 = r6
            goto L_0x00b4
        L_0x00b3:
            r8 = r7
        L_0x00b4:
            java.lang.String r9 = "newDraweeControllerBuild…\n                .build()"
            if (r8 != 0) goto L_0x00ea
            android.net.Uri r8 = android.net.Uri.parse(r4)
            com.facebook.imagepipeline.request.ImageRequestBuilder r8 = com.facebook.imagepipeline.request.ImageRequestBuilder.newBuilderWithSource(r8)
            com.facebook.imagepipeline.request.ImageRequest r8 = r8.build()
            com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder r10 = com.facebook.drawee.backends.pipeline.Fresco.newDraweeControllerBuilder()
            com.facebook.drawee.controller.AbstractDraweeControllerBuilder r10 = r10.setImageRequest(r8)
            com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder r10 = (com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder) r10
            com.facebook.drawee.view.SimpleDraweeView r11 = r12.labelIcon
            com.facebook.drawee.interfaces.DraweeController r11 = r11.getController()
            com.facebook.drawee.controller.AbstractDraweeControllerBuilder r10 = r10.setOldController((com.facebook.drawee.interfaces.DraweeController) r11)
            com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder r10 = (com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder) r10
            com.facebook.drawee.controller.AbstractDraweeController r10 = r10.build()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r9)
            com.facebook.drawee.interfaces.DraweeController r10 = (com.facebook.drawee.interfaces.DraweeController) r10
            com.facebook.drawee.view.SimpleDraweeView r11 = r12.labelIcon
            r11.setController(r10)
        L_0x00ea:
            if (r13 == 0) goto L_0x00fd
            com.baidu.searchbox.feed.model.AigcImageLabelData r8 = r12.aigcImageLabelData
            if (r8 == 0) goto L_0x00f5
            java.lang.String r8 = r8.getTextColorNight()
            goto L_0x00f6
        L_0x00f5:
            r8 = r1
        L_0x00f6:
            int r10 = com.baidu.searchbox.feed.styles.R.color.FC1
            int r8 = r12.getColorValue(r8, r10)
            goto L_0x010d
        L_0x00fd:
            com.baidu.searchbox.feed.model.AigcImageLabelData r8 = r12.aigcImageLabelData
            if (r8 == 0) goto L_0x0106
            java.lang.String r8 = r8.getTextColor()
            goto L_0x0107
        L_0x0106:
            r8 = r1
        L_0x0107:
            int r10 = com.baidu.searchbox.feed.styles.R.color.FC1
            int r8 = r12.getColorValue(r8, r10)
        L_0x010d:
            android.widget.TextView r10 = r12.labelText
            r10.setTextColor(r8)
            if (r13 == 0) goto L_0x011f
            com.baidu.searchbox.feed.model.AigcImageLabelData r10 = r12.aigcImageLabelData
            if (r10 == 0) goto L_0x0127
            java.lang.String r1 = r10.getArrowUrlNight()
            goto L_0x0127
        L_0x011f:
            com.baidu.searchbox.feed.model.AigcImageLabelData r10 = r12.aigcImageLabelData
            if (r10 == 0) goto L_0x0127
            java.lang.String r1 = r10.getArrowUrl()
        L_0x0127:
            r10 = r1
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            if (r10 == 0) goto L_0x0133
            int r10 = r10.length()
            if (r10 != 0) goto L_0x0134
        L_0x0133:
            r6 = r7
        L_0x0134:
            if (r6 != 0) goto L_0x0168
            android.net.Uri r6 = android.net.Uri.parse(r1)
            com.facebook.imagepipeline.request.ImageRequestBuilder r6 = com.facebook.imagepipeline.request.ImageRequestBuilder.newBuilderWithSource(r6)
            com.facebook.imagepipeline.request.ImageRequest r6 = r6.build()
            com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder r7 = com.facebook.drawee.backends.pipeline.Fresco.newDraweeControllerBuilder()
            com.facebook.drawee.controller.AbstractDraweeControllerBuilder r7 = r7.setImageRequest(r6)
            com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder r7 = (com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder) r7
            com.facebook.drawee.view.SimpleDraweeView r10 = r12.labelNext
            com.facebook.drawee.interfaces.DraweeController r10 = r10.getController()
            com.facebook.drawee.controller.AbstractDraweeControllerBuilder r7 = r7.setOldController((com.facebook.drawee.interfaces.DraweeController) r10)
            com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder r7 = (com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder) r7
            com.facebook.drawee.controller.AbstractDraweeController r7 = r7.build()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r9)
            com.facebook.drawee.interfaces.DraweeController r7 = (com.facebook.drawee.interfaces.DraweeController) r7
            com.facebook.drawee.view.SimpleDraweeView r9 = r12.labelNext
            r9.setController(r7)
            goto L_0x016f
        L_0x0168:
            com.facebook.drawee.view.SimpleDraweeView r6 = r12.labelNext
            int r7 = com.baidu.searchbox.feed.ui.R.drawable.feed_aigc_image_next_icon
            r6.setActualImageResource(r7)
        L_0x016f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.ui.aigcimage.AigcImageLabelView.onFeedNightModeChanged(boolean):void");
    }

    public final void onFontSizeChanged() {
        FontSizeViewExtKt.setScaledSizeRes$default(this.labelIcon, 0, com.baidu.searchbox.feed.core.R.dimen.dimens_14dp, com.baidu.searchbox.feed.core.R.dimen.dimens_14dp, 0, 8, (Object) null);
        FontSizeTextViewExtKt.setScaledSizeRes$default(this.labelText, 0, com.baidu.searchbox.feed.styles.R.dimen.F_T_X013, 0, 4, (Object) null);
        FontSizeViewExtKt.setScaledSizeRes$default(this.labelNext, 0, com.baidu.searchbox.feed.core.R.dimen.dimens_3dp, com.baidu.searchbox.feed.core.R.dimen.dimens_5dp, 0, 8, (Object) null);
    }

    private final int getColorValue(String colorStr, int defaultValueRes) {
        Integer num;
        int defaultValue = ContextCompat.getColor(getContext(), defaultValueRes);
        CharSequence charSequence = colorStr;
        if (charSequence == null || charSequence.length() == 0) {
            return defaultValue;
        }
        try {
            Result.Companion companion = Result.Companion;
            AigcImageLabelView aigcImageLabelView = this;
            num = Result.m8971constructorimpl(Integer.valueOf(Color.parseColor(colorStr)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            num = Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
        Integer valueOf = Integer.valueOf(defaultValue);
        if (Result.m8977isFailureimpl(num)) {
            num = valueOf;
        }
        return ((Number) num).intValue();
    }

    public void onClick(View v) {
        AigcImageLabelData $this$onClick_u24lambda_u2d1 = this.aigcImageLabelData;
        if ($this$onClick_u24lambda_u2d1 != null) {
            CharSequence cmd = $this$onClick_u24lambda_u2d1.getCmd();
            if (!(cmd == null || cmd.length() == 0)) {
                BaseRouter.invoke(getContext(), $this$onClick_u24lambda_u2d1.getCmd());
            }
            AigcImageLabelListener aigcImageLabelListener2 = this.aigcImageLabelListener;
            if (aigcImageLabelListener2 != null) {
                aigcImageLabelListener2.onClick(this.nid, this.aigcImageLabelData);
            }
        }
    }
}
