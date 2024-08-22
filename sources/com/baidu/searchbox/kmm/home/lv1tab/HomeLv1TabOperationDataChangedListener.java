package com.baidu.searchbox.kmm.home.lv1tab;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J~\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2H\b\u0002\u0010\u000b\u001aB\u0012\u0013\u0012\u00110\b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0013H&¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/kmm/home/lv1tab/HomeLv1TabOperationDataChangedListener;", "", "onAllOperationOffline", "", "onDataChanged", "tabId", "", "isShow", "", "operationInfo", "Lcom/baidu/searchbox/kmm/home/lv1tab/HomeLv1TabOperationModel;", "showCallback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSucceed", "", "ubcDict", "dismissCallback", "Lkotlin/Function0;", "com.baidu.searchbox.kmm.business.home"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeLv1TabOperationDataChangedListener.kt */
public interface HomeLv1TabOperationDataChangedListener {
    void onAllOperationOffline();

    void onDataChanged(String str, boolean z, HomeLv1TabOperationModel homeLv1TabOperationModel, Function2<? super Boolean, ? super Map<String, ? extends Object>, Unit> function2, Function0<Unit> function0);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HomeLv1TabOperationDataChangedListener.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void onDataChanged$default(HomeLv1TabOperationDataChangedListener homeLv1TabOperationDataChangedListener, String str, boolean z, HomeLv1TabOperationModel homeLv1TabOperationModel, Function2 function2, Function0 function0, int i2, Object obj) {
            Function2 function22;
            Function0 function02;
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    function22 = null;
                } else {
                    function22 = function2;
                }
                if ((i2 & 16) != 0) {
                    function02 = null;
                } else {
                    function02 = function0;
                }
                homeLv1TabOperationDataChangedListener.onDataChanged(str, z, homeLv1TabOperationModel, function22, function02);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDataChanged");
        }
    }
}
