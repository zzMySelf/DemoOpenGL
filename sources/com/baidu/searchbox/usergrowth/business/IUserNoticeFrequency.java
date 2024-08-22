package com.baidu.searchbox.usergrowth.business;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J*\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0012H&¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/usergrowth/business/IUserNoticeFrequency;", "", "checkUserNoticeShowFrequency", "", "type", "", "subType", "completeUserNoticeDisplay", "", "showListener", "Lcom/baidu/searchbox/usergrowth/business/IUserNoticeShowListener;", "getNoticeShowHomePriority", "", "syncUserNoticeDisplayListData", "transfer", "syncListener", "Lcom/baidu/searchbox/usergrowth/business/INoticeSyncDisplayListListener;", "syncUserNoticeFrequencyData", "Lcom/baidu/searchbox/usergrowth/business/INoticeSyncFrequencyDataListener;", "Companion", "lib-usergrowth-business-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IUserNoticeFrequency.kt */
public interface IUserNoticeFrequency {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String NAME = "frequencyControl";
    public static final String NAME_SPACE = "userNotice";

    boolean checkUserNoticeShowFrequency(long j2, long j3);

    void completeUserNoticeDisplay(long j2, long j3, IUserNoticeShowListener iUserNoticeShowListener);

    float getNoticeShowHomePriority(long j2, long j3);

    void syncUserNoticeDisplayListData(boolean z, INoticeSyncDisplayListListener iNoticeSyncDisplayListListener);

    void syncUserNoticeFrequencyData(long j2, long j3, boolean z, INoticeSyncFrequencyDataListener iNoticeSyncFrequencyDataListener);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/usergrowth/business/IUserNoticeFrequency$Companion;", "", "()V", "NAME", "", "NAME_SPACE", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "setSERVICE_REFERENCE", "(Lcom/baidu/pyramid/runtime/service/ServiceReference;)V", "getOrNull", "Lcom/baidu/searchbox/usergrowth/business/IUserNoticeFrequency;", "getGetOrNull", "()Lcom/baidu/searchbox/usergrowth/business/IUserNoticeFrequency;", "lib-usergrowth-business-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IUserNoticeFrequency.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String NAME = "frequencyControl";
        public static final String NAME_SPACE = "userNotice";
        private static ServiceReference SERVICE_REFERENCE;
        private static final IUserNoticeFrequency getOrNull;

        private Companion() {
        }

        static {
            ServiceReference serviceReference = new ServiceReference("userNotice", "frequencyControl");
            SERVICE_REFERENCE = serviceReference;
            getOrNull = (IUserNoticeFrequency) ServiceManager.getService(serviceReference);
        }

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }

        public final void setSERVICE_REFERENCE(ServiceReference serviceReference) {
            Intrinsics.checkNotNullParameter(serviceReference, "<set-?>");
            SERVICE_REFERENCE = serviceReference;
        }

        public final IUserNoticeFrequency getGetOrNull() {
            return getOrNull;
        }
    }
}
