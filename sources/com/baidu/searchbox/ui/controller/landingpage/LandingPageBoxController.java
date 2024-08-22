package com.baidu.searchbox.ui.controller.landingpage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.searchbox.home.search.boxinterface.landingpage.BusinessStatInfo;
import com.baidu.searchbox.home.search.boxinterface.landingpage.ILandingPageBoxController;
import com.baidu.searchbox.home.search.boxinterface.landingpage.ILandingPageBoxInterface;
import com.baidu.searchbox.home.search.ioc.IHomeInputBox;
import com.baidu.searchbox.inputbox.util.HintUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\r\u0010%\u001a\u00020\u001eH\u0001¢\u0006\u0002\b&J\b\u0010'\u001a\u00020\u001eH\u0016J\u0012\u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010*\u001a\u00020\u001e2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0018\u0010-\u001a\u00020\u001e2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dH\u0016J\u0012\u0010/\u001a\u00020\u001e2\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010/\u001a\u00020\u001e2\b\u00100\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u00010\u0005H\u0016J\u0015\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u000204H\u0001¢\u0006\u0002\b5J\u0010\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\tH\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00068"}, d2 = {"Lcom/baidu/searchbox/ui/controller/landingpage/LandingPageBoxController;", "Lcom/baidu/searchbox/home/search/boxinterface/landingpage/ILandingPageBoxController;", "context", "Landroid/content/Context;", "type", "", "channel", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "businessStatInfo", "Lcom/baidu/searchbox/home/search/boxinterface/landingpage/BusinessStatInfo;", "getBusinessStatInfo$lib_home_search_release", "()Lcom/baidu/searchbox/home/search/boxinterface/landingpage/BusinessStatInfo;", "setBusinessStatInfo$lib_home_search_release", "(Lcom/baidu/searchbox/home/search/boxinterface/landingpage/BusinessStatInfo;)V", "getContext", "()Landroid/content/Context;", "<set-?>", "Lcom/baidu/searchbox/ui/controller/landingpage/QueryInfo;", "curQueryInfo", "getCurQueryInfo$lib_home_search_release", "()Lcom/baidu/searchbox/ui/controller/landingpage/QueryInfo;", "jumpCmd", "landingPageBoxView", "Lcom/baidu/searchbox/ui/controller/landingpage/LandingPageSearchBoxView;", "getLandingPageBoxView", "()Lcom/baidu/searchbox/ui/controller/landingpage/LandingPageSearchBoxView;", "landingPageBoxView$delegate", "Lkotlin/Lazy;", "onBoxClickListener", "Lkotlin/Function0;", "", "searchbox", "Lcom/baidu/searchbox/home/search/boxinterface/landingpage/ILandingPageBoxInterface;", "getSearchbox", "()Lcom/baidu/searchbox/home/search/boxinterface/landingpage/ILandingPageBoxInterface;", "setSearchbox", "(Lcom/baidu/searchbox/home/search/boxinterface/landingpage/ILandingPageBoxInterface;)V", "jumpToHisSug", "jumpToHisSug$lib_home_search_release", "setDefaultQuery", "setJumpCmd", "cmdStr", "setLeftIconClickListener", "listener", "Landroid/view/View$OnClickListener;", "setOnBoxClickListener", "onClick", "setQuery", "query", "sa", "setSearchBoxClickEvent", "boxView", "Landroid/view/View;", "setSearchBoxClickEvent$lib_home_search_release", "setStatInfo", "statInfo", "lib-home-search_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandingPageBoxController.kt */
public class LandingPageBoxController implements ILandingPageBoxController {
    private BusinessStatInfo businessStatInfo;
    private final String channel;
    private final Context context;
    private QueryInfo curQueryInfo;
    private String jumpCmd;
    private final Lazy landingPageBoxView$delegate = LazyKt.lazy(new LandingPageBoxController$landingPageBoxView$2(this));
    private Function0<Unit> onBoxClickListener;

    /* renamed from: searchbox  reason: collision with root package name */
    private ILandingPageBoxInterface f2838searchbox;

    public LandingPageBoxController(Context context2, String type, String channel2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        this.context = context2;
        this.channel = channel2;
        LandingPageSearchBoxView $this$searchbox_u24lambda_u2d0 = new LandingPageSearchBoxView(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        $this$searchbox_u24lambda_u2d0.setBoxType$lib_home_search_release(type);
        $this$searchbox_u24lambda_u2d0.setBoxChannel$lib_home_search_release(channel2);
        $this$searchbox_u24lambda_u2d0.setBoxConfig$lib_home_search_release(channel2, type);
        $this$searchbox_u24lambda_u2d0.onNightModeChanged();
        setSearchBoxClickEvent$lib_home_search_release($this$searchbox_u24lambda_u2d0);
        this.f2838searchbox = $this$searchbox_u24lambda_u2d0;
    }

    public final Context getContext() {
        return this.context;
    }

    public ILandingPageBoxInterface getSearchbox() {
        return this.f2838searchbox;
    }

    public void setSearchbox(ILandingPageBoxInterface iLandingPageBoxInterface) {
        Intrinsics.checkNotNullParameter(iLandingPageBoxInterface, "<set-?>");
        this.f2838searchbox = iLandingPageBoxInterface;
    }

    private final LandingPageSearchBoxView getLandingPageBoxView() {
        return (LandingPageSearchBoxView) this.landingPageBoxView$delegate.getValue();
    }

    public final BusinessStatInfo getBusinessStatInfo$lib_home_search_release() {
        return this.businessStatInfo;
    }

    public final void setBusinessStatInfo$lib_home_search_release(BusinessStatInfo businessStatInfo2) {
        this.businessStatInfo = businessStatInfo2;
    }

    public final QueryInfo getCurQueryInfo$lib_home_search_release() {
        return this.curQueryInfo;
    }

    public final void setSearchBoxClickEvent$lib_home_search_release(View boxView) {
        Intrinsics.checkNotNullParameter(boxView, "boxView");
        boxView.setOnClickListener(new LandingPageBoxController$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setSearchBoxClickEvent$lambda-1  reason: not valid java name */
    public static final void m4556setSearchBoxClickEvent$lambda1(LandingPageBoxController this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.jumpToHisSug$lib_home_search_release();
        StatUtilsKt.onBoxClick$default(this$0.businessStatInfo, this$0.curQueryInfo, (String) null, 4, (Object) null);
        Function0<Unit> function0 = this$0.onBoxClickListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void jumpToHisSug$lib_home_search_release() {
        String $this$jumpToHisSug_u24lambda_u2d2 = this.jumpCmd;
        if ($this$jumpToHisSug_u24lambda_u2d2 != null) {
            if ($this$jumpToHisSug_u24lambda_u2d2.length() > 0) {
                IHomeInputBox.Impl.get().invokeCommand(this.context, $this$jumpToHisSug_u24lambda_u2d2);
            }
        }
    }

    public void setDefaultQuery() {
        String query = HintUtils.getLandingPageBoxHint();
        Intrinsics.checkNotNullExpressionValue(query, "getLandingPageBoxHint()");
        LandingPageSearchBoxView landingPageBoxView = getLandingPageBoxView();
        if (landingPageBoxView != null) {
            landingPageBoxView.setQueryAndTag$lib_home_search_release(query, (String) null);
        }
        this.curQueryInfo = new QueryInfo(query, true, (String) null);
    }

    public void setJumpCmd(String cmdStr) {
        this.jumpCmd = cmdStr;
    }

    public void setQuery(String query) {
        setQuery(query, (String) null);
    }

    public void setQuery(String query, String sa) {
        LandingPageSearchBoxView landingPageBoxView = getLandingPageBoxView();
        if (landingPageBoxView != null) {
            landingPageBoxView.setQueryAndTag$lib_home_search_release(query, sa);
        }
        CharSequence charSequence = query;
        if (!(charSequence == null || charSequence.length() == 0)) {
            QueryInfo $this$setQuery_u24lambda_u2d3 = new QueryInfo(query, false, sa);
            StatUtilsKt.onBoxQueryShow(this.businessStatInfo, $this$setQuery_u24lambda_u2d3);
            this.curQueryInfo = $this$setQuery_u24lambda_u2d3;
        }
    }

    public void setStatInfo(BusinessStatInfo statInfo) {
        Intrinsics.checkNotNullParameter(statInfo, "statInfo");
        this.businessStatInfo = statInfo;
    }

    public void setOnBoxClickListener(Function0<Unit> onClick) {
        this.onBoxClickListener = onClick;
    }

    public void setLeftIconClickListener(View.OnClickListener listener) {
        LandingPageSearchBoxView landingPageBoxView = getLandingPageBoxView();
        if (landingPageBoxView != null) {
            landingPageBoxView.setLeftIconClickListener$lib_home_search_release(listener);
        }
    }
}
