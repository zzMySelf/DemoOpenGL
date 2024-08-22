package fe.mmm.qw.xxx;

import android.app.Activity;
import android.os.ResultReceiver;
import androidx.appcompat.widget.ActivityChooserModel;
import com.tera.scan.main.MainActivity;
import com.tera.scan.main.welcome.WelcomeActivity;
import fe.mmm.qw.a.uk.rg;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public final class de {

    /* renamed from: ad  reason: collision with root package name */
    public long f8575ad;

    /* renamed from: de  reason: collision with root package name */
    public long f8576de;
    public int qw;

    public static final class ad extends rg {
        public final /* synthetic */ de ddd;
        public final /* synthetic */ Activity xxx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ad(Activity activity, de deVar) {
            super("onBroughtForeground-async");
            this.xxx = activity;
            this.ddd = deVar;
        }

        public void when() throws Exception {
            Activity activity = this.xxx;
            if (activity != null) {
                fe.mmm.qw.e.yj.qw.ad(activity.getApplicationContext()).de(fe.mmm.qw.i.qw.o(), fe.mmm.qw.de.ad.qw.qw.f7749i);
            }
            this.ddd.ad();
        }
    }

    public static final class qw extends rg {
        public qw() {
            super("sendActiveUserJob");
        }

        public void when() throws Exception {
            fe.mmm.qw.ggg.ad.ad.qw((ResultReceiver) null);
        }
    }

    public final void ad() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("imei", (Object) null);
            jSONObject.put("oaid", fe.mmm.qw.de.ad.qw.qw.f330switch);
        } catch (JSONException unused) {
            fe.mmm.qw.i.qw.rg("AppStatusManager", "app start statistics error");
        }
    }

    public final void de(Activity activity) {
        fe.mmm.qw.i.qw.ad("AppStatusManager", "onBroughtForeground");
        new qw().mmm();
        new ad(activity, this).mmm();
        if ((System.currentTimeMillis() - this.f8576de) / 1000 > 0) {
            this.f8576de = 0;
        }
    }

    public final void fe(Activity activity) {
        fe.mmm.qw.i.qw.ad("AppStatusManager", "onGoBackground");
        this.f8576de = System.currentTimeMillis();
        yj(activity);
        fe.mmm.qw.p030switch.rg.qw.qw().getBduss();
        fe.mmm.qw.p030switch.rg.qw.qw().getUid();
    }

    public final void rg(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        fe.mmm.qw.i.qw.ad("AppStatusManager", "onStart mActivitiesCount:" + this.qw + " activity: " + activity);
        if (this.qw == 0) {
            this.f8575ad = System.currentTimeMillis();
            de(activity);
        }
        this.qw++;
    }

    public final void th(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        fe.mmm.qw.i.qw.ad("AppStatusManager", "onStop mActivitiesCount:" + this.qw + "activity: " + activity);
        if (this.qw == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f8575ad;
            if (j > 0) {
                int i2 = ((int) (currentTimeMillis - j)) / 1000;
                this.f8575ad = 0;
            }
            fe(activity);
        }
    }

    public final void yj(Activity activity) {
        if (activity != null && !(activity instanceof WelcomeActivity)) {
            boolean z = activity instanceof MainActivity;
        }
    }
}
