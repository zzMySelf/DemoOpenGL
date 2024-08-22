package fe.ggg.ad.qw.de.fe;

import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.mars.united.core.os.bluetooth.vo.BluetoothInfo;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class fe {
    public static final boolean ad(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT < 23 || (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0);
    }

    public static final boolean de(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    @Nullable
    public static final BluetoothInfo qw(@NotNull ScanResult scanResult) {
        Intrinsics.checkNotNullParameter(scanResult, "<this>");
        ScanRecord scanRecord = scanResult.getScanRecord();
        String deviceName = scanRecord == null ? null : scanRecord.getDeviceName();
        if (deviceName == null) {
            deviceName = scanResult.getDevice().getName();
        }
        int rssi = scanResult.getRssi();
        long currentTimeMillis = System.currentTimeMillis();
        if (deviceName != null) {
            return new BluetoothInfo(deviceName, rssi, currentTimeMillis);
        }
        return null;
    }
}
