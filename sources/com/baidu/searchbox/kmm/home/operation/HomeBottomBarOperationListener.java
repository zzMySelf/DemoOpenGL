package com.baidu.searchbox.kmm.home.operation;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&Jd\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062D\u0010\b\u001a@\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012!\u0012\u001f\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012H&¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/kmm/home/operation/HomeBottomBarOperationListener;", "", "onAllOperationOffline", "", "onDismiss", "operation", "Lcom/baidu/searchbox/kmm/home/operation/HomeOperationItemModel;", "onOperationTryShow", "showCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSucceed", "", "", "ubcDict", "dismissCallback", "Lkotlin/Function0;", "com.baidu.searchbox.kmm.business.home"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeBottomBarDataChangeListener.kt */
public interface HomeBottomBarOperationListener {
    void onAllOperationOffline();

    void onDismiss(HomeOperationItemModel homeOperationItemModel);

    void onOperationTryShow(HomeOperationItemModel homeOperationItemModel, Function2<? super Boolean, ? super Map<String, ? extends Object>, Unit> function2, Function0<Unit> function0);
}
