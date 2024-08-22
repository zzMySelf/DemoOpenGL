package com.baidu.searchbox.kmm.bdtask.entity;

import android.text.SpannableString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003J%\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u000bHÖ\u0001R\u0019\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/kmm/bdtask/entity/TimerGuideResponseInfo;", "", "type", "Lcom/baidu/searchbox/kmm/bdtask/entity/TimerGuideType;", "content", "Landroid/text/SpannableString;", "Lcom/baidu/searchbox/kmm/foundation/utils/richtext/KRichText;", "(Lcom/baidu/searchbox/kmm/bdtask/entity/TimerGuideType;Landroid/text/SpannableString;)V", "getContent", "()Landroid/text/SpannableString;", "doneMinute", "", "getDoneMinute", "()Ljava/lang/String;", "setDoneMinute", "(Ljava/lang/String;)V", "getType", "()Lcom/baidu/searchbox/kmm/bdtask/entity/TimerGuideType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com.baidu.searchbox.kmm.business.bdtask"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TimerGuideResponseInfo.kt */
public final class TimerGuideResponseInfo {
    private final SpannableString content;
    private String doneMinute;
    private final TimerGuideType type;

    public static /* synthetic */ TimerGuideResponseInfo copy$default(TimerGuideResponseInfo timerGuideResponseInfo, TimerGuideType timerGuideType, SpannableString spannableString, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            timerGuideType = timerGuideResponseInfo.type;
        }
        if ((i2 & 2) != 0) {
            spannableString = timerGuideResponseInfo.content;
        }
        return timerGuideResponseInfo.copy(timerGuideType, spannableString);
    }

    public final TimerGuideType component1() {
        return this.type;
    }

    public final SpannableString component2() {
        return this.content;
    }

    public final TimerGuideResponseInfo copy(TimerGuideType timerGuideType, SpannableString spannableString) {
        Intrinsics.checkNotNullParameter(timerGuideType, "type");
        return new TimerGuideResponseInfo(timerGuideType, spannableString);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimerGuideResponseInfo)) {
            return false;
        }
        TimerGuideResponseInfo timerGuideResponseInfo = (TimerGuideResponseInfo) obj;
        return this.type == timerGuideResponseInfo.type && Intrinsics.areEqual((Object) this.content, (Object) timerGuideResponseInfo.content);
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        SpannableString spannableString = this.content;
        return hashCode + (spannableString == null ? 0 : spannableString.hashCode());
    }

    public String toString() {
        return "TimerGuideResponseInfo(type=" + this.type + ", content=" + this.content + ')';
    }

    public TimerGuideResponseInfo(TimerGuideType type2, SpannableString content2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        this.type = type2;
        this.content = content2;
    }

    public final TimerGuideType getType() {
        return this.type;
    }

    public final SpannableString getContent() {
        return this.content;
    }

    public final String getDoneMinute() {
        return this.doneMinute;
    }

    public final void setDoneMinute(String str) {
        this.doneMinute = str;
    }
}
