package com.baidu.searchbox.bdprecyclebin.business.core;

import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.bdprecyclebin.business.core.cleardata.regular.RecycleBinRegularClearDataHelper;
import com.baidu.searchbox.bdprecyclebin.face.IRecycleBinFace;
import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/bdprecyclebin/business/core/RecycleBinFaceImpl;", "Lcom/baidu/searchbox/bdprecyclebin/face/IRecycleBinFace;", "()V", "isHasAddedRecycleBin", "", "isHasClickedRecycleBinRedPoint", "isHasShowedRecycleBinBubble", "recordHasAddedRecycleBin", "", "recordHasClickedRecycleBinRedPoint", "recordHasShowedRecycleBinBubble", "recordOperation", "type", "", "shouldShowOperationType", "triggerRegularClear", "Companion", "lib-bdprecyclebin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecycleBinFaceImpl.kt */
public final class RecycleBinFaceImpl implements IRecycleBinFace {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String SP_KEY_HAS_ADDED_RECYCLE_BIN = "hasAddedRecycleBin";
    private static final String SP_KEY_HAS_CLICKED_RED_POINT = "hasClickedRecycleBinRedPoint";
    private static final String SP_KEY_HAS_SHOW_BUBBLE = "hasShowRecycleBinBubble";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/bdprecyclebin/business/core/RecycleBinFaceImpl$Companion;", "", "()V", "SP_KEY_HAS_ADDED_RECYCLE_BIN", "", "SP_KEY_HAS_CLICKED_RED_POINT", "SP_KEY_HAS_SHOW_BUBBLE", "lib-bdprecyclebin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RecycleBinFaceImpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void recordHasAddedRecycleBin() {
        try {
            PreferenceUtils.setBoolean(SP_KEY_HAS_ADDED_RECYCLE_BIN, true);
        } catch (Exception exception) {
            if (AppConfig.isDebug()) {
                exception.printStackTrace();
            }
        }
    }

    public boolean shouldShowOperationType(int type) {
        if (type == 0) {
            if (!isHasAddedRecycleBin() || isHasClickedRecycleBinRedPoint()) {
                return false;
            }
            return true;
        } else if (1 != type || isHasClickedRecycleBinRedPoint() || isHasShowedRecycleBinBubble()) {
            return false;
        } else {
            return true;
        }
    }

    public void recordOperation(int type) {
        if (type == 0) {
            recordHasClickedRecycleBinRedPoint();
        } else if (1 == type) {
            recordHasShowedRecycleBinBubble();
        }
    }

    public void triggerRegularClear() {
        RecycleBinRegularClearDataHelper.INSTANCE.triggerRegularDataClear();
    }

    private final boolean isHasAddedRecycleBin() {
        try {
            return PreferenceUtils.getBoolean(SP_KEY_HAS_ADDED_RECYCLE_BIN, false);
        } catch (Exception exception) {
            if (!AppConfig.isDebug()) {
                return false;
            }
            exception.printStackTrace();
            return false;
        }
    }

    private final void recordHasClickedRecycleBinRedPoint() {
        try {
            PreferenceUtils.setBoolean(SP_KEY_HAS_CLICKED_RED_POINT, true);
        } catch (Exception exception) {
            if (AppConfig.isDebug()) {
                exception.printStackTrace();
            }
        }
    }

    private final boolean isHasClickedRecycleBinRedPoint() {
        try {
            return PreferenceUtils.getBoolean(SP_KEY_HAS_CLICKED_RED_POINT, false);
        } catch (Exception exception) {
            if (!AppConfig.isDebug()) {
                return false;
            }
            exception.printStackTrace();
            return false;
        }
    }

    private final void recordHasShowedRecycleBinBubble() {
        try {
            PreferenceUtils.setBoolean(SP_KEY_HAS_SHOW_BUBBLE, true);
        } catch (Exception exception) {
            if (AppConfig.isDebug()) {
                exception.printStackTrace();
            }
        }
    }

    private final boolean isHasShowedRecycleBinBubble() {
        try {
            return PreferenceUtils.getBoolean(SP_KEY_HAS_SHOW_BUBBLE, false);
        } catch (Exception exception) {
            if (!AppConfig.isDebug()) {
                return false;
            }
            exception.printStackTrace();
            return false;
        }
    }
}
