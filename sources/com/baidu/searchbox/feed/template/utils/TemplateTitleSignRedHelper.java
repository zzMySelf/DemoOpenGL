package com.baidu.searchbox.feed.template.utils;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.util.SparseIntArray;
import com.baidu.searchbox.config.AppConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/searchbox/feed/template/utils/TemplateTitleSignRedHelper;", "", "()V", "Companion", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TemplateTitleSignRedHelper.kt */
public final class TemplateTitleSignRedHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LABEL_START = "<searchHotSpot>";
    private static final String LABEL_STOP = "</searchHotSpot>";
    private static final String TAG = "TitleSignRedHelper";

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\"\u0010\u0011\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0013\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/feed/template/utils/TemplateTitleSignRedHelper$Companion;", "", "()V", "LABEL_START", "", "LABEL_STOP", "TAG", "handleTitleStyle", "", "spannableString", "Landroid/text/SpannableString;", "label", "labelColor", "", "isBold", "", "(Landroid/text/SpannableString;Ljava/lang/String;ILjava/lang/Boolean;)V", "titleSignRed", "signRedLabel", "color", "lib-feed-template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TemplateTitleSignRedHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void titleSignRed(SpannableString spannableString, String signRedLabel, int color) {
            if (spannableString != null) {
                CharSequence charSequence = signRedLabel;
                if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                    int start = StringsKt.indexOf$default((CharSequence) signRedLabel, TemplateTitleSignRedHelper.LABEL_START, 0, false, 4, (Object) null);
                    List<String> labels = new ArrayList<>();
                    while (start >= 0) {
                        int start2 = start + TemplateTitleSignRedHelper.LABEL_START.length();
                        int stop = StringsKt.indexOf$default((CharSequence) signRedLabel, TemplateTitleSignRedHelper.LABEL_STOP, start2, false, 4, (Object) null);
                        if (stop >= 0 && stop >= start2) {
                            String substring = signRedLabel.substring(start2, stop);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                            labels.add(substring);
                            start = StringsKt.indexOf$default((CharSequence) signRedLabel, TemplateTitleSignRedHelper.LABEL_START, start2, false, 4, (Object) null);
                        } else {
                            return;
                        }
                    }
                    if (labels.size() > 0) {
                        for (String lab : labels) {
                            if (StringsKt.contains$default((CharSequence) spannableString, (CharSequence) lab, false, 2, (Object) null)) {
                                int startLocation = StringsKt.indexOf$default((CharSequence) spannableString, lab, 0, false, 6, (Object) null);
                                spannableString.setSpan(new ForegroundColorSpan(color), startLocation, lab.length() + startLocation, 17);
                            }
                        }
                    }
                }
            }
        }

        public final void handleTitleStyle(SpannableString spannableString, String label, int labelColor, Boolean isBold) {
            SpannableString spannableString2 = spannableString;
            String str = label;
            if (spannableString2 != null) {
                CharSequence charSequence = str;
                if (charSequence == null || StringsKt.isBlank(charSequence)) {
                    int i2 = labelColor;
                    Boolean bool = isBold;
                    return;
                }
                String adjustLabelString = StringsKt.replace$default(StringsKt.replace$default(label, TemplateTitleSignRedHelper.LABEL_START, "", false, 4, (Object) null), TemplateTitleSignRedHelper.LABEL_STOP, "", false, 4, (Object) null);
                String spannableString3 = spannableString.toString();
                Intrinsics.checkNotNullExpressionValue(spannableString3, "spannableString.toString()");
                if (Intrinsics.areEqual((Object) adjustLabelString, (Object) StringsKt.replace$default(spannableString3, "prefix", "", false, 4, (Object) null))) {
                    SparseIntArray rawSparseArray = new SparseIntArray();
                    int start = StringsKt.indexOf$default((CharSequence) str, TemplateTitleSignRedHelper.LABEL_START, 0, false, 4, (Object) null);
                    while (start >= 0) {
                        int start2 = start + TemplateTitleSignRedHelper.LABEL_START.length();
                        int stop = StringsKt.indexOf$default((CharSequence) str, TemplateTitleSignRedHelper.LABEL_STOP, start2, false, 4, (Object) null);
                        if (stop >= 0 && stop > start2) {
                            rawSparseArray.append(start2, stop - start2);
                            start = StringsKt.indexOf$default((CharSequence) str, TemplateTitleSignRedHelper.LABEL_START, start2, false, 4, (Object) null);
                        } else {
                            return;
                        }
                    }
                    if (rawSparseArray.size() > 0) {
                        Ref.IntRef titleRealStart = new Ref.IntRef();
                        if (StringsKt.startsWith$default((CharSequence) spannableString2, (CharSequence) "prefix", false, 2, (Object) null)) {
                            titleRealStart.element += 6;
                        }
                        SparseIntArray adjustedSparseArray = new SparseIntArray(rawSparseArray.size());
                        TemplateTitleSignRedHelperKt.forEachIndexed(rawSparseArray, new TemplateTitleSignRedHelper$Companion$handleTitleStyle$1(adjustedSparseArray, titleRealStart));
                        rawSparseArray.clear();
                        TemplateTitleSignRedHelperKt.forEachIndexed(adjustedSparseArray, new TemplateTitleSignRedHelper$Companion$handleTitleStyle$2(spannableString2, labelColor, isBold));
                    }
                } else if (AppConfig.isDebug()) {
                    Log.e(TemplateTitleSignRedHelper.TAG, " spannableString and label do not match: \n                            spannableString=" + spannableString2 + ",\n                            label= " + str + ",\n                            adjustLabelString= " + adjustLabelString + "\n                            ");
                }
            } else {
                int i3 = labelColor;
                Boolean bool2 = isBold;
            }
        }
    }
}
