package rg.qw;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class ggg {
    public final Executor qw = Executors.newSingleThreadExecutor();

    public interface ad {
        void qw(SharedPreferences sharedPreferences);
    }

    public static class qw implements Callable<SharedPreferences> {

        /* renamed from: ad  reason: collision with root package name */
        public final Context f10436ad;

        /* renamed from: th  reason: collision with root package name */
        public final String f10437th;

        /* renamed from: yj  reason: collision with root package name */
        public final ad f10438yj;

        public qw(Context context, String str, ad adVar) {
            this.f10436ad = context;
            this.f10437th = str;
            this.f10438yj = adVar;
        }

        /* renamed from: qw */
        public SharedPreferences call() {
            SharedPreferences sharedPreferences = this.f10436ad.getSharedPreferences(this.f10437th, 0);
            ad adVar = this.f10438yj;
            if (adVar != null) {
                adVar.qw(sharedPreferences);
            }
            return sharedPreferences;
        }
    }

    public Future<SharedPreferences> qw(Context context, String str, ad adVar) {
        FutureTask futureTask = new FutureTask(new qw(context, str, adVar));
        this.qw.execute(futureTask);
        return futureTask;
    }
}
