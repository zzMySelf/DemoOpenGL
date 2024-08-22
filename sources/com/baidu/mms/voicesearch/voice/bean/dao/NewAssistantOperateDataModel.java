package com.baidu.mms.voicesearch.voice.bean.dao;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B'\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005¢\u0006\u0002\u0010\u0006J!\u0010\t\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005HÆ\u0003J+\u0010\n\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R.\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/baidu/mms/voicesearch/voice/bean/dao/NewAssistantOperateDataModel;", "", "resArray", "Ljava/util/ArrayList;", "Lcom/baidu/mms/voicesearch/voice/bean/dao/NewAssistantOperateDataItem;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getResArray", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-speech-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VoiceImmersionResModel.kt */
public final class NewAssistantOperateDataModel {
    @SerializedName("voice_panel_operate_list")
    private final ArrayList<NewAssistantOperateDataItem> resArray;

    public NewAssistantOperateDataModel() {
        this((ArrayList) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ NewAssistantOperateDataModel copy$default(NewAssistantOperateDataModel newAssistantOperateDataModel, ArrayList<NewAssistantOperateDataItem> arrayList, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = newAssistantOperateDataModel.resArray;
        }
        return newAssistantOperateDataModel.copy(arrayList);
    }

    public final ArrayList<NewAssistantOperateDataItem> component1() {
        return this.resArray;
    }

    public final NewAssistantOperateDataModel copy(ArrayList<NewAssistantOperateDataItem> arrayList) {
        return new NewAssistantOperateDataModel(arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NewAssistantOperateDataModel) && Intrinsics.areEqual((Object) this.resArray, (Object) ((NewAssistantOperateDataModel) obj).resArray);
    }

    public int hashCode() {
        ArrayList<NewAssistantOperateDataItem> arrayList = this.resArray;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.hashCode();
    }

    public String toString() {
        return "NewAssistantOperateDataModel(resArray=" + this.resArray + ')';
    }

    public NewAssistantOperateDataModel(ArrayList<NewAssistantOperateDataItem> resArray2) {
        this.resArray = resArray2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NewAssistantOperateDataModel(ArrayList arrayList, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : arrayList);
    }

    public final ArrayList<NewAssistantOperateDataItem> getResArray() {
        return this.resArray;
    }
}
