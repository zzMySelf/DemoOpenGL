package fe.fe.when.qw.qw;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.baidu.netdisk.trade.pay._;
import com.baidu.netdisk.trade.pay.channel.ChannelMode;
import com.baidu.netdisk.trade.pay.channel._____;
import com.baidu.netdisk.trade.pay.finishpay.OnFinishPay;
import com.baidu.netdisk.trade.pay.polymer.PolymerMode;
import com.baidu.netdisk.trade.pay.polymer.__;
import com.baidu.wallet.api.BaiduWallet;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.api.ILocationCallback;
import com.baidu.wallet.api.ILoginBackListener;
import com.baidu.wallet.api.IWalletListener;
import com.baidu.wallet.lightapp.base.datamodel.LightAppLocationModel;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import fe.fe.when.qw.qw.th.i;
import fe.fe.when.qw.qw.yj.ad;
import fe.fe.when.qw.qw.yj.de;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class rg implements OnFinishPay {
    public final /* synthetic */ fe.fe.when.qw.qw.yj.qw qw = fe.fe.when.qw.qw.yj.qw.qw;

    public static final class qw implements IWalletListener {

        /* renamed from: ad  reason: collision with root package name */
        public final /* synthetic */ Context f3181ad;

        /* renamed from: th  reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f3182th;

        public qw(Context context, Function0<Unit> function0) {
            this.f3181ad = context;
            this.f3182th = function0;
        }

        public boolean callShare(@Nullable Activity activity, @Nullable Map<String, String> map, @Nullable ILightappInvokerCallback iLightappInvokerCallback) {
            return false;
        }

        public boolean getCurrentLocation(@Nullable ILocationCallback iLocationCallback) {
            LightAppLocationModel lightAppLocationModel = new LightAppLocationModel();
            lightAppLocationModel.result = 0;
            LightAppLocationModel.Coords coords = new LightAppLocationModel.Coords();
            lightAppLocationModel.coords = coords;
            coords.accuracy = 10.0f;
            coords.latitude = -9999.0d;
            coords.longitude = -9999.0d;
            if (iLocationCallback == null) {
                return true;
            }
            iLocationCallback.onReceiveLocation(lightAppLocationModel);
            return true;
        }

        @NotNull
        public Set<String> getMethodList() {
            return new LinkedHashSet();
        }

        public void lightappInvoke(@Nullable Context context, @Nullable String str, @Nullable ILightappInvokerCallback iLightappInvokerCallback) {
        }

        public void login(@NotNull ILoginBackListener iLoginBackListener) {
            Intrinsics.checkNotNullParameter(iLoginBackListener, "p0");
            Function0<Unit> function0 = this.f3182th;
            if (function0 != null) {
                function0.invoke();
            }
        }

        public boolean startPage(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "p0");
            BaiduWallet.getInstance().openH5Module(this.f3181ad, str, false);
            return true;
        }
    }

    public static /* synthetic */ LiveData fe(rg rgVar, Context context, String str, _ _2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            _2 = null;
        }
        return rgVar.qw(context, str, _2);
    }

    public final LiveData<ad> ad(Context context, String str, __ __, _ _2) {
        fe.fe.when.qw.qw.yj.qw.qw.fe();
        MutableLiveData mutableLiveData = new MutableLiveData();
        if (str == null || str.length() == 0) {
            de.qw(mutableLiveData);
        } else if (__ == null) {
            de.de(mutableLiveData);
        } else {
            __.qw(context, str, mutableLiveData, _2);
        }
        return mutableLiveData;
    }

    @NotNull
    public final LiveData<ad> de(@NotNull FragmentActivity fragmentActivity, int i2, @Nullable String str, @Nullable _ _2) {
        Intrinsics.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        fe.fe.when.qw.qw.yj.qw.qw.fe();
        MutableLiveData mutableLiveData = new MutableLiveData();
        ChannelMode qw2 = fe.fe.when.qw.qw.fe.qw.qw(i2);
        if (qw2 != null) {
            if (!(str == null || str.length() == 0)) {
                _____ qw3 = new i().qw(qw2);
                if (qw3 == null) {
                    de.de(mutableLiveData);
                } else {
                    fe.fe.when.qw.qw.yj.qw.qw.qw(qw3);
                    qw3.qw(fragmentActivity, str, mutableLiveData, _2);
                }
                return mutableLiveData;
            }
        }
        de.qw(mutableLiveData);
        return mutableLiveData;
    }

    @NotNull
    public final LiveData<ad> qw(@NotNull Context context, @Nullable String str, @Nullable _ _2) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ad(context, str, new fe.fe.when.qw.qw.i.rg().qw(PolymerMode.BaiduWallet), _2);
    }

    public final void rg(@NotNull Context context, @Nullable String str, @Nullable Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        BaiduWallet.getInstance().initWallet(new qw(context, function0), context, str);
    }

    public void th(@NotNull Context context, @Nullable Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.qw.ad(context, intent);
    }

    public void yj(@NotNull Context context, @Nullable BaseResp baseResp) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.qw.de(context, baseResp);
    }
}
