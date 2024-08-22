package com.baidu.assistant.model.data;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/baidu/assistant/model/data/ModelInitConfig;", "", "furniture", "", "awatar", "cameraPosition", "scenePositoon", "bgColor", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAwatar", "()Ljava/lang/String;", "getBgColor", "getCameraPosition", "getFurniture", "getScenePositoon", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "lib-model-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModelData.kt */
public final class ModelInitConfig {
    private final String awatar;
    private final String bgColor;
    private final String cameraPosition;
    private final String furniture;
    private final String scenePositoon;

    public static /* synthetic */ ModelInitConfig copy$default(ModelInitConfig modelInitConfig, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = modelInitConfig.furniture;
        }
        if ((i2 & 2) != 0) {
            str2 = modelInitConfig.awatar;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = modelInitConfig.cameraPosition;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = modelInitConfig.scenePositoon;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = modelInitConfig.bgColor;
        }
        return modelInitConfig.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.furniture;
    }

    public final String component2() {
        return this.awatar;
    }

    public final String component3() {
        return this.cameraPosition;
    }

    public final String component4() {
        return this.scenePositoon;
    }

    public final String component5() {
        return this.bgColor;
    }

    public final ModelInitConfig copy(String str, String str2, String str3, String str4, String str5) {
        return new ModelInitConfig(str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ModelInitConfig)) {
            return false;
        }
        ModelInitConfig modelInitConfig = (ModelInitConfig) obj;
        return Intrinsics.areEqual((Object) this.furniture, (Object) modelInitConfig.furniture) && Intrinsics.areEqual((Object) this.awatar, (Object) modelInitConfig.awatar) && Intrinsics.areEqual((Object) this.cameraPosition, (Object) modelInitConfig.cameraPosition) && Intrinsics.areEqual((Object) this.scenePositoon, (Object) modelInitConfig.scenePositoon) && Intrinsics.areEqual((Object) this.bgColor, (Object) modelInitConfig.bgColor);
    }

    public int hashCode() {
        String str = this.furniture;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.awatar;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.cameraPosition;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.scenePositoon;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.bgColor;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return hashCode4 + i2;
    }

    public String toString() {
        return "ModelInitConfig(furniture=" + this.furniture + ", awatar=" + this.awatar + ", cameraPosition=" + this.cameraPosition + ", scenePositoon=" + this.scenePositoon + ", bgColor=" + this.bgColor + ')';
    }

    public ModelInitConfig(String furniture2, String awatar2, String cameraPosition2, String scenePositoon2, String bgColor2) {
        this.furniture = furniture2;
        this.awatar = awatar2;
        this.cameraPosition = cameraPosition2;
        this.scenePositoon = scenePositoon2;
        this.bgColor = bgColor2;
    }

    public final String getFurniture() {
        return this.furniture;
    }

    public final String getAwatar() {
        return this.awatar;
    }

    public final String getCameraPosition() {
        return this.cameraPosition;
    }

    public final String getScenePositoon() {
        return this.scenePositoon;
    }

    public final String getBgColor() {
        return this.bgColor;
    }
}
