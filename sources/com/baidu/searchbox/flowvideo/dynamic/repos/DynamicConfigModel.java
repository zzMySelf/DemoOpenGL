package com.baidu.searchbox.flowvideo.dynamic.repos;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B_\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/flowvideo/dynamic/repos/DynamicConfigModel;", "", "clearModel", "Lcom/baidu/searchbox/flowvideo/dynamic/repos/DynamicClearScreenModel;", "imgShowTimeModel", "Lcom/baidu/searchbox/flowvideo/dynamic/repos/ImgShowTimeModel;", "menu", "Lcom/baidu/searchbox/flowvideo/dynamic/repos/DynamicMenuConfigModel;", "backgroundColor", "", "textLabel", "loop", "maxTitleLine", "", "musicNoText", "(Lcom/baidu/searchbox/flowvideo/dynamic/repos/DynamicClearScreenModel;Lcom/baidu/searchbox/flowvideo/dynamic/repos/ImgShowTimeModel;Lcom/baidu/searchbox/flowvideo/dynamic/repos/DynamicMenuConfigModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getBackgroundColor", "()Ljava/lang/String;", "getClearModel", "()Lcom/baidu/searchbox/flowvideo/dynamic/repos/DynamicClearScreenModel;", "getImgShowTimeModel", "()Lcom/baidu/searchbox/flowvideo/dynamic/repos/ImgShowTimeModel;", "getLoop", "getMaxTitleLine", "()I", "getMenu", "()Lcom/baidu/searchbox/flowvideo/dynamic/repos/DynamicMenuConfigModel;", "getMusicNoText", "getTextLabel", "isForceLoop", "", "isHideMusic", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicDetailModel.kt */
public final class DynamicConfigModel {
    private final String backgroundColor;
    private final DynamicClearScreenModel clearModel;
    private final ImgShowTimeModel imgShowTimeModel;
    private final String loop;
    private final int maxTitleLine;
    private final DynamicMenuConfigModel menu;
    private final String musicNoText;
    private final String textLabel;

    public DynamicConfigModel() {
        this((DynamicClearScreenModel) null, (ImgShowTimeModel) null, (DynamicMenuConfigModel) null, (String) null, (String) null, (String) null, 0, (String) null, 255, (DefaultConstructorMarker) null);
    }

    public DynamicConfigModel(DynamicClearScreenModel clearModel2, ImgShowTimeModel imgShowTimeModel2, DynamicMenuConfigModel menu2, String backgroundColor2, String textLabel2, String loop2, int maxTitleLine2, String musicNoText2) {
        Intrinsics.checkNotNullParameter(loop2, "loop");
        Intrinsics.checkNotNullParameter(musicNoText2, "musicNoText");
        this.clearModel = clearModel2;
        this.imgShowTimeModel = imgShowTimeModel2;
        this.menu = menu2;
        this.backgroundColor = backgroundColor2;
        this.textLabel = textLabel2;
        this.loop = loop2;
        this.maxTitleLine = maxTitleLine2;
        this.musicNoText = musicNoText2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DynamicConfigModel(DynamicClearScreenModel dynamicClearScreenModel, ImgShowTimeModel imgShowTimeModel2, DynamicMenuConfigModel dynamicMenuConfigModel, String str, String str2, String str3, int i2, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : dynamicClearScreenModel, (i3 & 2) != 0 ? null : imgShowTimeModel2, (i3 & 4) != 0 ? null : dynamicMenuConfigModel, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? "" : str3, (i3 & 64) != 0 ? 0 : i2, (i3 & 128) != 0 ? "" : str4);
    }

    public final DynamicClearScreenModel getClearModel() {
        return this.clearModel;
    }

    public final ImgShowTimeModel getImgShowTimeModel() {
        return this.imgShowTimeModel;
    }

    public final DynamicMenuConfigModel getMenu() {
        return this.menu;
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getTextLabel() {
        return this.textLabel;
    }

    public final String getLoop() {
        return this.loop;
    }

    public final int getMaxTitleLine() {
        return this.maxTitleLine;
    }

    public final String getMusicNoText() {
        return this.musicNoText;
    }

    public final boolean isForceLoop() {
        return Intrinsics.areEqual((Object) this.loop, (Object) "1");
    }

    public final boolean isHideMusic() {
        return Intrinsics.areEqual((Object) this.musicNoText, (Object) "1");
    }
}
