package com.baidu.swan.apps.component.abscomponents.textview;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.baidu.swan.apps.component.abscomponents.textview.SwanAppTextViewComponentModel;
import com.baidu.swan.apps.component.abscomponents.view.SwanAppViewComponent;
import com.baidu.swan.apps.component.diff.DiffResult;
import com.baidu.swan.apps.console.SwanAppLog;

public abstract class SwanAppTextViewComponent<V extends TextView, M extends SwanAppTextViewComponentModel> extends SwanAppViewComponent<V, M> {
    private static final String FONT_WEIGHT_BOLD = "bold";
    private static final String FONT_WEIGHT_NORMAL = "normal";
    private static final String LINE_BREAK_ALL = "break-all";
    private static final String LINE_BREAK_CLIP = "clip";
    private static final String LINE_BREAK_ELLIPSIS = "ellipsis";
    private static final String LINE_BREAK_STRING = "string";
    private static final String LINE_BREAK_WORD = "break-word";
    private static final String TAG = "Component-TextView";
    private static final String TEXT_ALIGN_CENTER = "center";
    private static final String TEXT_ALIGN_LEFT = "left";
    private static final String TEXT_ALIGN_RIGHT = "right";
    private static final String WHITE_SPACE_NORMAL = "normal";
    private static final String WHITE_SPACE_NOWRAP = "nowrap";

    public SwanAppTextViewComponent(Context context, M model) {
        super(context, model);
    }

    /* access modifiers changed from: protected */
    public DiffResult diff(M oldModel, M newModel) {
        DiffResult diffResult = super.diff(oldModel, newModel);
        if (!TextUtils.equals(oldModel.text, newModel.text)) {
            diffResult.markDiff(6);
        }
        return diffResult;
    }

    /* access modifiers changed from: protected */
    public void render(V view2, M model, DiffResult diffResult) {
        super.render(view2, model, diffResult);
        if (diffResult.hasDiff(6)) {
            renderText(view2, model);
        }
        if (diffResult.hasDiff(4)) {
            renderTextStyle(view2, model);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: android.text.SpannableStringBuilder} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void renderText(V r9, M r10) {
        /*
            r8 = this;
            boolean r0 = DEBUG
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "Component-TextView"
            java.lang.String r1 = "renderText"
            android.util.Log.d(r0, r1)
        L_0x000c:
            java.lang.String r0 = r10.text
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x001c
            int r0 = r10.lineHeight
            if (r0 < 0) goto L_0x001c
            r0 = r1
            goto L_0x001d
        L_0x001c:
            r0 = r2
        L_0x001d:
            java.lang.String r3 = r10.text
            if (r0 == 0) goto L_0x0037
            android.text.SpannableStringBuilder r4 = new android.text.SpannableStringBuilder
            r4.<init>(r3)
            com.baidu.swan.apps.component.abscomponents.textview.AdjustLineHeightSpan r5 = new com.baidu.swan.apps.component.abscomponents.textview.AdjustLineHeightSpan
            int r6 = r10.lineHeight
            r5.<init>(r6)
            int r6 = r3.length()
            r7 = 33
            r4.setSpan(r5, r2, r6, r7)
            r3 = r4
        L_0x0037:
            if (r0 != 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r1 = r2
        L_0x003b:
            r9.setIncludeFontPadding(r1)
            r9.setText(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.apps.component.abscomponents.textview.SwanAppTextViewComponent.renderText(android.widget.TextView, com.baidu.swan.apps.component.abscomponents.textview.SwanAppTextViewComponentModel):void");
    }

    private void renderTextStyle(V view2, M model) {
        if (model.styleData != null) {
            if (DEBUG) {
                Log.d(TAG, "renderTextStyle");
            }
            if (model.isValidTextColor) {
                view2.setTextColor(model.textColor);
            }
            float fontSize = (float) model.fontSize;
            if (fontSize > 0.0f) {
                view2.setTextSize(1, fontSize);
            }
            renderTextStyleTextAlign(view2, model);
            renderTextStyleFontWeight(view2, model);
            String str = model.whiteSpace;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1039745817:
                    if (str.equals("normal")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1039592053:
                    if (str.equals(WHITE_SPACE_NOWRAP)) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    view2.setSingleLine(false);
                    break;
                case 1:
                    view2.setSingleLine(true);
                    break;
            }
            if (LINE_BREAK_ELLIPSIS.equals(model.lineBreak)) {
                view2.setEllipsize(TextUtils.TruncateAt.END);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void renderTextStyleTextAlign(V view2, M model) {
        renderTextStyleTextAlign(view2, model, 48);
    }

    /* access modifiers changed from: protected */
    public final void renderTextStyleTextAlign(V view2, M model, int verticalGravity) {
        int textGravity;
        if (model.styleData != null) {
            if (DEBUG) {
                Log.d(TAG, "renderTextStyleTextAlign");
            }
            int textGravity2 = verticalGravity;
            String str = model.textAlign;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals("center")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3317767:
                    if (str.equals("left")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 108511772:
                    if (str.equals("right")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    textGravity = textGravity2 | GravityCompat.START;
                    break;
                case 1:
                    textGravity = textGravity2 | GravityCompat.END;
                    break;
                case 2:
                    textGravity = textGravity2 | 1;
                    break;
                default:
                    SwanAppLog.w(TAG, "invalid text align: " + model.textAlign);
                    textGravity = textGravity2 | GravityCompat.START;
                    break;
            }
            view2.setGravity(textGravity);
        }
    }

    /* access modifiers changed from: protected */
    public void renderTextStyleFontWeight(V view2, M model) {
        if (model.styleData != null) {
            if (DEBUG) {
                Log.d(TAG, "renderTextStyleFontWeight");
            }
            String str = model.fontWeight;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1039745817:
                    if (str.equals("normal")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3029637:
                    if (str.equals("bold")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    view2.setTypeface(Typeface.SANS_SERIF, 0);
                    return;
                case 1:
                    view2.setTypeface(Typeface.SANS_SERIF, 1);
                    return;
                default:
                    SwanAppLog.w(TAG, "invalid font weight : " + model.fontWeight);
                    view2.setTypeface(Typeface.SANS_SERIF, 0);
                    return;
            }
        }
    }
}
