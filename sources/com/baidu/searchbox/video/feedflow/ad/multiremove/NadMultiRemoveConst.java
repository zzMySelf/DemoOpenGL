package com.baidu.searchbox.video.feedflow.ad.multiremove;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/multiremove/NadMultiRemoveConst;", "", "()V", "RemoveFromType", "RemoveReasonType", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadMultiRemoveConst.kt */
public final class NadMultiRemoveConst {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/multiremove/NadMultiRemoveConst$RemoveFromType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "NAD", "ESHOP", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NadMultiRemoveConst.kt */
    public enum RemoveFromType {
        NAD("nad"),
        ESHOP("eshop");
        
        private final String type;

        private RemoveFromType(String type2) {
            this.type = type2;
        }

        public final String getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/ad/multiremove/NadMultiRemoveConst$RemoveReasonType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "MARKET_SENSE_GOV", "ESHOP_FREQUENCY_CONTROL", "flowvideo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NadMultiRemoveConst.kt */
    public enum RemoveReasonType {
        MARKET_SENSE_GOV("1"),
        ESHOP_FREQUENCY_CONTROL("2");
        
        private final String type;

        private RemoveReasonType(String type2) {
            this.type = type2;
        }

        public final String getType() {
            return this.type;
        }
    }
}
