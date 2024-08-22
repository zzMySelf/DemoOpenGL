package com.baidu.nadcore.dazzle.utils;

import com.baidu.pyramid.runtime.service.ServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/baidu/nadcore/dazzle/utils/NadDazzleRuntime;", "", "()V", "Companion", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NadDazzleRuntime.kt */
public final class NadDazzleRuntime {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static INadDazzleFontSizeManager fontSizeManager;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/baidu/nadcore/dazzle/utils/NadDazzleRuntime$Companion;", "", "()V", "fontSizeManager", "Lcom/baidu/nadcore/dazzle/utils/INadDazzleFontSizeManager;", "getFontSizeManager", "nadcore-lib-business"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NadDazzleRuntime.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final INadDazzleFontSizeManager getFontSizeManager() {
            if (NadDazzleRuntime.fontSizeManager == null) {
                synchronized (NadDazzleRuntime.class) {
                    Companion companion = NadDazzleRuntime.Companion;
                    Object service = ServiceManager.getService(INadDazzleFontSizeManager.Companion.getSERVICE_REFERENCE());
                    INadDazzleFontSizeManager iNadDazzleFontSizeManager = service instanceof INadDazzleFontSizeManager ? (INadDazzleFontSizeManager) service : null;
                    if (iNadDazzleFontSizeManager == null) {
                        iNadDazzleFontSizeManager = INadDazzleFontSizeManager.Companion.getEMPTY();
                    }
                    NadDazzleRuntime.fontSizeManager = iNadDazzleFontSizeManager;
                    Unit unit = Unit.INSTANCE;
                }
            }
            INadDazzleFontSizeManager access$getFontSizeManager$cp = NadDazzleRuntime.fontSizeManager;
            return access$getFontSizeManager$cp == null ? INadDazzleFontSizeManager.Companion.getEMPTY() : access$getFontSizeManager$cp;
        }
    }
}
