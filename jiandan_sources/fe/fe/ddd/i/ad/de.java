package fe.fe.ddd.i.ad;

import com.baidu.pyramid.runtime.multiprocess.IPCServiceManager;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.searchbox.common.security.IDeviceInfoService;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class de {
    @Nullable

    /* renamed from: ad  reason: collision with root package name */
    public static IDeviceInfoService f1455ad;
    @NotNull
    public static final qw qw = new qw((DefaultConstructorMarker) null);

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final IDeviceInfoService qw() {
            if (de.f1455ad == null) {
                synchronized (DeviceInfoManager.class) {
                    if (de.f1455ad == null) {
                        qw qwVar = de.qw;
                        de.f1455ad = IDeviceInfoService.Stub.asInterface(IPCServiceManager.th("device_info", true));
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            return de.f1455ad;
        }
    }
}
