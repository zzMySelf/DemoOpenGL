package com.baidu.searchbox.openwidget.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@StableApi
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 %2\u00020\u0001:\u0001%B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/openwidget/model/OpenWidgetInstance;", "Landroid/os/Parcelable;", "id", "", "info", "Lcom/baidu/searchbox/openwidget/model/OpenWidgetInfo;", "config", "Lcom/baidu/searchbox/openwidget/model/OpenWidgetConfig;", "touch", "Lcom/baidu/searchbox/openwidget/model/OpenWidgetTouch;", "(ILcom/baidu/searchbox/openwidget/model/OpenWidgetInfo;Lcom/baidu/searchbox/openwidget/model/OpenWidgetConfig;Lcom/baidu/searchbox/openwidget/model/OpenWidgetTouch;)V", "getConfig", "()Lcom/baidu/searchbox/openwidget/model/OpenWidgetConfig;", "getId", "()I", "getInfo", "()Lcom/baidu/searchbox/openwidget/model/OpenWidgetInfo;", "getTouch", "()Lcom/baidu/searchbox/openwidget/model/OpenWidgetTouch;", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "lib-openwidget-interfaces_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OpenWidgetInstance.kt */
public final class OpenWidgetInstance implements Parcelable {
    public static final Parcelable.Creator<OpenWidgetInstance> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final OpenWidgetConfig config;
    private final int id;
    private final OpenWidgetInfo info;
    private final OpenWidgetTouch touch;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OpenWidgetInstance.kt */
    public static final class Creator implements Parcelable.Creator<OpenWidgetInstance> {
        public final OpenWidgetInstance createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OpenWidgetInstance(parcel.readInt(), OpenWidgetInfo.CREATOR.createFromParcel(parcel), OpenWidgetConfig.CREATOR.createFromParcel(parcel), OpenWidgetTouch.CREATOR.createFromParcel(parcel));
        }

        public final OpenWidgetInstance[] newArray(int i2) {
            return new OpenWidgetInstance[i2];
        }
    }

    public static /* synthetic */ OpenWidgetInstance copy$default(OpenWidgetInstance openWidgetInstance, int i2, OpenWidgetInfo openWidgetInfo, OpenWidgetConfig openWidgetConfig, OpenWidgetTouch openWidgetTouch, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = openWidgetInstance.id;
        }
        if ((i3 & 2) != 0) {
            openWidgetInfo = openWidgetInstance.info;
        }
        if ((i3 & 4) != 0) {
            openWidgetConfig = openWidgetInstance.config;
        }
        if ((i3 & 8) != 0) {
            openWidgetTouch = openWidgetInstance.touch;
        }
        return openWidgetInstance.copy(i2, openWidgetInfo, openWidgetConfig, openWidgetTouch);
    }

    public final int component1() {
        return this.id;
    }

    public final OpenWidgetInfo component2() {
        return this.info;
    }

    public final OpenWidgetConfig component3() {
        return this.config;
    }

    public final OpenWidgetTouch component4() {
        return this.touch;
    }

    public final OpenWidgetInstance copy(int i2, OpenWidgetInfo openWidgetInfo, OpenWidgetConfig openWidgetConfig, OpenWidgetTouch openWidgetTouch) {
        Intrinsics.checkNotNullParameter(openWidgetInfo, "info");
        Intrinsics.checkNotNullParameter(openWidgetConfig, "config");
        Intrinsics.checkNotNullParameter(openWidgetTouch, "touch");
        return new OpenWidgetInstance(i2, openWidgetInfo, openWidgetConfig, openWidgetTouch);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OpenWidgetInstance)) {
            return false;
        }
        OpenWidgetInstance openWidgetInstance = (OpenWidgetInstance) obj;
        return this.id == openWidgetInstance.id && Intrinsics.areEqual((Object) this.info, (Object) openWidgetInstance.info) && Intrinsics.areEqual((Object) this.config, (Object) openWidgetInstance.config) && Intrinsics.areEqual((Object) this.touch, (Object) openWidgetInstance.touch);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.id) * 31) + this.info.hashCode()) * 31) + this.config.hashCode()) * 31) + this.touch.hashCode();
    }

    public String toString() {
        return "OpenWidgetInstance(id=" + this.id + ", info=" + this.info + ", config=" + this.config + ", touch=" + this.touch + ')';
    }

    public void writeToParcel(Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.id);
        this.info.writeToParcel(parcel, i2);
        this.config.writeToParcel(parcel, i2);
        this.touch.writeToParcel(parcel, i2);
    }

    public OpenWidgetInstance(int id2, OpenWidgetInfo info2, OpenWidgetConfig config2, OpenWidgetTouch touch2) {
        Intrinsics.checkNotNullParameter(info2, "info");
        Intrinsics.checkNotNullParameter(config2, "config");
        Intrinsics.checkNotNullParameter(touch2, "touch");
        this.id = id2;
        this.info = info2;
        this.config = config2;
        this.touch = touch2;
    }

    public final int getId() {
        return this.id;
    }

    public final OpenWidgetInfo getInfo() {
        return this.info;
    }

    public final OpenWidgetConfig getConfig() {
        return this.config;
    }

    public final OpenWidgetTouch getTouch() {
        return this.touch;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tJ\n\u0010\n\u001a\u00020\u0006*\u00020\u0004J\n\u0010\u000b\u001a\u00020\t*\u00020\u0004¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/openwidget/model/OpenWidgetInstance$Companion;", "", "()V", "fromJson", "Lcom/baidu/searchbox/openwidget/model/OpenWidgetInstance;", "json", "Lorg/json/JSONObject;", "fromJsonStr", "jsonString", "", "toJson", "toJsonStr", "lib-openwidget-interfaces_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OpenWidgetInstance.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OpenWidgetInstance fromJsonStr(String jsonString) {
            Object obj;
            if (jsonString == null) {
                return null;
            }
            try {
                Result.Companion companion = Result.Companion;
                Companion companion2 = this;
                obj = Result.m8971constructorimpl(new JSONObject(jsonString));
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.Companion;
                obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m8977isFailureimpl(obj)) {
                obj = null;
            }
            JSONObject json = (JSONObject) obj;
            if (json == null) {
                return null;
            }
            return fromJson(json);
        }

        public final OpenWidgetInstance fromJson(JSONObject json) {
            if (json == null) {
                return null;
            }
            int id = json.optInt("id", -1);
            OpenWidgetInfo info = OpenWidgetInfo.Companion.fromJson(json.optJSONObject("info"));
            OpenWidgetConfig config = OpenWidgetConfig.Companion.fromJson(json.optJSONObject("config"));
            JSONObject $this$fromJson_u24lambda_u2d1 = json.optJSONObject("touch");
            OpenWidgetTouch touch = $this$fromJson_u24lambda_u2d1 != null ? OpenWidgetTouch.Companion.fromJson($this$fromJson_u24lambda_u2d1) : null;
            if (id != -1 && info != null && config != null && touch != null) {
                return new OpenWidgetInstance(id, info, config, touch);
            }
            OpenWidgetInstance openWidgetInstance = null;
            return null;
        }

        public final String toJsonStr(OpenWidgetInstance $this$toJsonStr) {
            Intrinsics.checkNotNullParameter($this$toJsonStr, "<this>");
            String jSONObject = toJson($this$toJsonStr).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "toJson().toString()");
            return jSONObject;
        }

        public final JSONObject toJson(OpenWidgetInstance $this$toJson) {
            Intrinsics.checkNotNullParameter($this$toJson, "<this>");
            JSONObject jSONObject = new JSONObject();
            JSONObject $this$toJson_u24lambda_u2d2 = jSONObject;
            $this$toJson_u24lambda_u2d2.put("id", $this$toJson.getId());
            $this$toJson_u24lambda_u2d2.put("info", OpenWidgetInfo.Companion.toJson($this$toJson.getInfo()));
            $this$toJson_u24lambda_u2d2.put("config", OpenWidgetConfig.Companion.toJson($this$toJson.getConfig()));
            $this$toJson_u24lambda_u2d2.put("touch", OpenWidgetTouch.Companion.toJson($this$toJson.getTouch()));
            return jSONObject;
        }
    }
}
