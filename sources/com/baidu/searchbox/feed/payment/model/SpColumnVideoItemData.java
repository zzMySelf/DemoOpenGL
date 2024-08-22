package com.baidu.searchbox.feed.payment.model;

import com.baidu.searchbox.feed.model.FeedBaseModel;
import com.baidu.searchbox.feed.parser.ValidationResult;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/feed/payment/model/SpColumnVideoItemData;", "Lcom/baidu/searchbox/feed/payment/model/SpColumnBaseItemData;", "()V", "duration", "", "playCount", "isValidate", "Lcom/baidu/searchbox/feed/parser/ValidationResult;", "context", "Lcom/baidu/searchbox/feed/model/FeedBaseModel;", "Companion", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SpColumnListData.kt */
public final class SpColumnVideoItemData extends SpColumnBaseItemData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @SerializedName("duration")
    public String duration = "";
    @SerializedName("play_num")
    public String playCount = "";

    @JvmStatic
    public static final String makeTestJson() {
        return Companion.makeTestJson();
    }

    public ValidationResult isValidate(FeedBaseModel context) {
        boolean y;
        Intrinsics.checkNotNullParameter(context, "context");
        String str = context.state;
        Integer num = null;
        String state = str != null ? StringsKt.trim((CharSequence) str).toString() : null;
        boolean x = Intrinsics.areEqual((Object) state, (Object) "0");
        boolean z = true;
        if (ArraysKt.contains((T[]) SpColumnListDataKt.getVALID_STATES(), state)) {
            CharSequence charSequence = this.theCmd;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                String str2 = this.playCount;
                if ((str2 != null ? StringsKt.toLongOrNull(str2) : null) != null) {
                    String str3 = this.duration;
                    if (str3 != null) {
                        num = StringsKt.toIntOrNull(str3);
                    }
                    if (num != null) {
                        y = true;
                        if (!x && !y) {
                            z = false;
                        }
                        ValidationResult from = ValidationResult.from(z);
                        Intrinsics.checkNotNullExpressionValue(from, "from(x || y)");
                        return from;
                    }
                }
            }
        }
        y = false;
        z = false;
        ValidationResult from2 = ValidationResult.from(z);
        Intrinsics.checkNotNullExpressionValue(from2, "from(x || y)");
        return from2;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/feed/payment/model/SpColumnVideoItemData$Companion;", "", "()V", "makeTestJson", "", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SpColumnListData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final String makeTestJson() {
            return "";
        }
    }
}
