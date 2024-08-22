package com.baidu.searchbox.personalcenter.controller;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.baidu.searchbox.config.eventmessage.HomeTabClickEvent;
import com.baidu.searchbox.newpersonalcenter.novel.PersonalNovelDataManager;
import com.baidu.searchbox.personalcenter.PersonalDataChangeCallback;
import com.baidu.searchbox.personalcenter.listener.IPersonalEventListener;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/personalcenter/controller/NovelController;", "Lcom/baidu/searchbox/personalcenter/listener/IPersonalEventListener;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "onResume", "", "lib-personal-center-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NovelController.kt */
public final class NovelController implements IPersonalEventListener {
    private final Fragment fragment;

    public NovelController(Fragment fragment2) {
        this.fragment = fragment2;
    }

    public void homeTabClickEvent(HomeTabClickEvent homeTabClickEvent) {
        IPersonalEventListener.DefaultImpls.homeTabClickEvent(this, homeTabClickEvent);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        IPersonalEventListener.DefaultImpls.onActivityCreated(this, savedInstanceState);
    }

    public void onCreate() {
        IPersonalEventListener.DefaultImpls.onCreate(this);
    }

    public void onCreateView() {
        IPersonalEventListener.DefaultImpls.onCreateView(this);
    }

    public void onDestroy() {
        IPersonalEventListener.DefaultImpls.onDestroy(this);
    }

    public void onLoginStatusChanged() {
        IPersonalEventListener.DefaultImpls.onLoginStatusChanged(this);
    }

    public void onNestedScrollStopped() {
        IPersonalEventListener.DefaultImpls.onNestedScrollStopped(this);
    }

    public void onNestedScrolling(int dy) {
        IPersonalEventListener.DefaultImpls.onNestedScrolling(this, dy);
    }

    public void onPause() {
        IPersonalEventListener.DefaultImpls.onPause(this);
    }

    public void onPersonalizedDataChanged() {
        IPersonalEventListener.DefaultImpls.onPersonalizedDataChanged(this);
    }

    public void onStop() {
        IPersonalEventListener.DefaultImpls.onStop(this);
    }

    public void onResume() {
        IPersonalEventListener.DefaultImpls.onResume(this);
        PersonalNovelDataManager.getInstance().notifyRefreshPersonalNovelList(new NovelController$$ExternalSyntheticLambda0(new WeakReference(this.fragment)));
    }

    /* access modifiers changed from: private */
    /* renamed from: onResume$lambda-0  reason: not valid java name */
    public static final void m2169onResume$lambda0(WeakReference $fragmentWR, List it) {
        Intrinsics.checkNotNullParameter($fragmentWR, "$fragmentWR");
        Object obj = $fragmentWR.get();
        PersonalDataChangeCallback personalDataChangeCallback = obj instanceof PersonalDataChangeCallback ? (PersonalDataChangeCallback) obj : null;
        if (personalDataChangeCallback != null) {
            PersonalDataChangeCallback.DefaultImpls.notifyDataChange$default(personalDataChangeCallback, false, 1, (Object) null);
        }
    }
}
