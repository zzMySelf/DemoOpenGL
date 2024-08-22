package com.baidu.searchbox.sport.page.web;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.sport.model.OlympicFilterTabModel;
import com.heytap.mcssdk.constant.IntentConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/sport/page/web/OlympicCalendarWebViewModel;", "Lcom/baidu/searchbox/sport/page/web/AbsSportWebViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "calendarMsgJson", "Landroidx/lifecycle/MutableLiveData;", "Lorg/json/JSONObject;", "getCalendarMsgJson", "()Landroidx/lifecycle/MutableLiveData;", "setData", "", "data", "Lcom/baidu/searchbox/sport/model/OlympicFilterTabModel;", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OlympicCalendarWebViewModel.kt */
public final class OlympicCalendarWebViewModel extends AbsSportWebViewModel {
    private final MutableLiveData<JSONObject> calendarMsgJson = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OlympicCalendarWebViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final MutableLiveData<JSONObject> getCalendarMsgJson() {
        return this.calendarMsgJson;
    }

    public final void setData(OlympicFilterTabModel data) {
        Object obj;
        if (data != null) {
            try {
                Result.Companion companion = Result.Companion;
                MutableLiveData<JSONObject> mutableLiveData = this.calendarMsgJson;
                JSONObject jSONObject = new JSONObject();
                JSONObject $this$setData_u24lambda_u2d2_u24lambda_u2d1 = jSONObject;
                $this$setData_u24lambda_u2d2_u24lambda_u2d1.put("beginDate", data.getBeginDate());
                $this$setData_u24lambda_u2d2_u24lambda_u2d1.put(IntentConstant.END_DATE, data.getEndDate());
                $this$setData_u24lambda_u2d2_u24lambda_u2d1.put("selectDate", data.getSelectDate());
                $this$setData_u24lambda_u2d2_u24lambda_u2d1.put("labels", data.getDateArray());
                Map it = data.getIconMap();
                $this$setData_u24lambda_u2d2_u24lambda_u2d1.put("iconMap", it != null ? new JSONObject(it) : null);
                mutableLiveData.setValue(jSONObject);
                obj = Result.m8971constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable it2 = Result.m8974exceptionOrNullimpl(obj);
            if (it2 != null && OlympicCalendarWebViewModelKt.DEBUG) {
                Log.d("OlympicCalendarWebVM", "error: " + it2.getMessage());
            }
        }
    }
}
