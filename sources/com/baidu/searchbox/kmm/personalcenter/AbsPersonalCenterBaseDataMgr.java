package com.baidu.searchbox.kmm.personalcenter;

import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel;
import com.baidu.searchbox.kmm.personalcenter.entities.constants.ThemesConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nRC\u0010\u000b\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\u0005¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0005\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R7\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\b\"\u0004\b\u001d\u0010\nRL\u0010\u001e\u001a4\u0012\u0013\u0012\u00110 ¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/baidu/searchbox/kmm/personalcenter/AbsPersonalCenterBaseDataMgr;", "", "()V", "getNovelLocalDataCallback", "Lkotlin/Function0;", "", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabItemModel;", "getGetNovelLocalDataCallback", "()Lkotlin/jvm/functions/Function0;", "setGetNovelLocalDataCallback", "(Lkotlin/jvm/functions/Function0;)V", "getSmartCardLocalDataCallback", "Lkotlin/Function1;", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabModel;", "Lkotlin/ParameterName;", "name", "recommendGroupsList", "getGetSmartCardLocalDataCallback", "()Lkotlin/jvm/functions/Function1;", "setGetSmartCardLocalDataCallback", "(Lkotlin/jvm/functions/Function1;)V", "getToThemeCallback", "", "itemId", "Lcom/baidu/searchbox/kmm/personalcenter/entities/constants/ThemesConstants;", "getGetToThemeCallback", "setGetToThemeCallback", "isThemesAvailableCallback", "", "setThemesAvailableCallback", "switchItemIsNullCheckCallback", "Lkotlin/Function2;", "", "switchOemConfig", "switchId", "getSwitchItemIsNullCheckCallback", "()Lkotlin/jvm/functions/Function2;", "setSwitchItemIsNullCheckCallback", "(Lkotlin/jvm/functions/Function2;)V", "com.baidu.searchbox.kmm.business.personalcenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalCenterBaseDataMgr.kt */
public abstract class AbsPersonalCenterBaseDataMgr {
    private Function0<? extends List<? extends PersonalCenterTabItemModel>> getNovelLocalDataCallback;
    private Function1<? super List<PersonalCenterTabModel>, ? extends List<PersonalCenterTabModel>> getSmartCardLocalDataCallback;
    private Function1<? super String, ? extends ThemesConstants> getToThemeCallback;
    private Function0<Boolean> isThemesAvailableCallback;
    private Function2<? super Integer, ? super String, Boolean> switchItemIsNullCheckCallback;

    public final Function2<Integer, String, Boolean> getSwitchItemIsNullCheckCallback() {
        return this.switchItemIsNullCheckCallback;
    }

    public final void setSwitchItemIsNullCheckCallback(Function2<? super Integer, ? super String, Boolean> function2) {
        this.switchItemIsNullCheckCallback = function2;
    }

    public final Function1<String, ThemesConstants> getGetToThemeCallback() {
        return this.getToThemeCallback;
    }

    public final void setGetToThemeCallback(Function1<? super String, ? extends ThemesConstants> function1) {
        this.getToThemeCallback = function1;
    }

    public final Function0<Boolean> isThemesAvailableCallback() {
        return this.isThemesAvailableCallback;
    }

    public final void setThemesAvailableCallback(Function0<Boolean> function0) {
        this.isThemesAvailableCallback = function0;
    }

    public final Function0<List<PersonalCenterTabItemModel>> getGetNovelLocalDataCallback() {
        return this.getNovelLocalDataCallback;
    }

    public final void setGetNovelLocalDataCallback(Function0<? extends List<? extends PersonalCenterTabItemModel>> function0) {
        this.getNovelLocalDataCallback = function0;
    }

    public final Function1<List<PersonalCenterTabModel>, List<PersonalCenterTabModel>> getGetSmartCardLocalDataCallback() {
        return this.getSmartCardLocalDataCallback;
    }

    public final void setGetSmartCardLocalDataCallback(Function1<? super List<PersonalCenterTabModel>, ? extends List<PersonalCenterTabModel>> function1) {
        this.getSmartCardLocalDataCallback = function1;
    }
}
