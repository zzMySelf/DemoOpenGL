package com.huawei.multimedia.audiokit.interfaces;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import com.huawei.multimedia.audiokit.utils.LogUtils;

public class EnhancedDeviceInfo {
    private static final int BLUETOOTH_A2DP_FB_RECORDING = 10005;
    private static final int BLUETOOTH_KARAOKE_SUPPORTED = 10006;
    private static final int DEVICE_TYPE_DEFAULT_VALUE = -1;
    private static final Object LOCK_ISFULLBAND_RECORD_SUPPORTED = new Object();
    private static final Object LOCK_ISKARAOKE_SUPPORTED = new Object();
    private static final String TAG = "HwAudioKit.EnhancedDeviceInfo";
    private static BluetoothAdapter mBluetoothAdapter;
    private static BluetoothDevice mBluetoothDevice;
    private AudioManager mAudioManager = null;
    private Context mContext = null;
    private int mDeviceType = -1;

    public EnhancedDeviceInfo(Context context, int deviceType) {
        this.mContext = context;
        this.mDeviceType = deviceType;
    }

    public boolean isFullbandRecordSupported() {
        boolean isFbRecordSupported;
        synchronized (LOCK_ISFULLBAND_RECORD_SUPPORTED) {
            isFbRecordSupported = false;
            switch (this.mDeviceType) {
                case 3:
                case 11:
                case 22:
                    isFbRecordSupported = true;
                    break;
                case 4:
                    isFbRecordSupported = false;
                    break;
                case 8:
                    createAudioManager();
                    isFbRecordSupported = getBluetoothFeatureEnable(this.mAudioManager, 10005);
                    break;
            }
            LogUtils.info(TAG, "mDeviceType=" + this.mDeviceType + ",isFbRecordSupported=" + isFbRecordSupported);
        }
        return isFbRecordSupported;
    }

    public boolean isKaraokeSupported() {
        boolean isDeviceSupported;
        synchronized (LOCK_ISKARAOKE_SUPPORTED) {
            isDeviceSupported = false;
            switch (this.mDeviceType) {
                case 3:
                case 4:
                case 11:
                case 22:
                    isDeviceSupported = true;
                    break;
                case 8:
                    createAudioManager();
                    isDeviceSupported = getBluetoothFeatureEnable(this.mAudioManager, 10005) && getBluetoothFeatureEnable(this.mAudioManager, 10006);
                    break;
            }
            LogUtils.info(TAG, "mDeviceType=" + this.mDeviceType + ",isDeviceSupported=" + isDeviceSupported);
        }
        return isDeviceSupported;
    }

    public static boolean getBluetoothFBEnable(AudioManager audioManager) {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        AudioDeviceInfo[] devices = new AudioDeviceInfo[0];
        if (audioManager != null) {
            devices = audioManager.getDevices(2);
        }
        for (AudioDeviceInfo device : devices) {
            if (device.getType() == 8) {
                mBluetoothDevice = mBluetoothAdapter.getRemoteDevice(device.getAddress());
            }
        }
        if (mBluetoothDevice == null) {
            return false;
        }
        return isBluetoothFBRecording();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isBluetoothFBRecording() {
        /*
            java.lang.String r0 = "HwAudioKit.EnhancedDeviceInfo"
            r1 = 0
            java.lang.Class<android.bluetooth.BluetoothDevice> r2 = android.bluetooth.BluetoothDevice.class
            java.lang.String r3 = "getMetadata"
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            r7 = 0
            r5[r7] = r6     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            java.lang.reflect.Method r3 = r2.getMethod(r3, r5)     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            android.bluetooth.BluetoothDevice r5 = mBluetoothDevice     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            r8 = 10005(0x2715, float:1.402E-41)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            r6[r7] = r8     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            java.lang.Object r5 = r3.invoke(r5, r6)     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            boolean r6 = r5 instanceof byte[]     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            if (r6 == 0) goto L_0x005b
            r6 = r5
            byte[] r6 = (byte[]) r6     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            byte[] r6 = (byte[]) r6     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            int r8 = r6.length     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            if (r8 <= 0) goto L_0x005b
            byte r8 = r6[r7]     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            if (r8 != 0) goto L_0x0034
            r4 = r7
        L_0x0034:
            r1 = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            r4.<init>()     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            java.lang.String r8 = "isBluetoothFBRecording byteArray[0]="
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            byte r7 = r6[r7]     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            java.lang.String r4 = r4.toString()     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            com.huawei.multimedia.audiokit.utils.LogUtils.info(r0, r4)     // Catch:{ NoSuchMethodException -> 0x0055, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x004e }
            goto L_0x005b
        L_0x004e:
            r2 = move-exception
            java.lang.String r3 = "isBluetoothFBRecording Exception"
            com.huawei.multimedia.audiokit.utils.LogUtils.error(r0, r3)
            goto L_0x005c
        L_0x0055:
            r2 = move-exception
            java.lang.String r3 = "No Such Method getMetadata"
            com.huawei.multimedia.audiokit.utils.LogUtils.error(r0, r3)
        L_0x005b:
        L_0x005c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.multimedia.audiokit.interfaces.EnhancedDeviceInfo.isBluetoothFBRecording():boolean");
    }

    private static boolean getBluetoothFeatureEnable(AudioManager audioManager, int bluetoothFlag) {
        LogUtils.info(TAG, "getBluetoothFBEnable bluetoothFlag=" + bluetoothFlag);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        AudioDeviceInfo[] devices = new AudioDeviceInfo[0];
        if (audioManager != null) {
            devices = audioManager.getDevices(2);
        }
        for (AudioDeviceInfo device : devices) {
            if (device.getType() == 8) {
                mBluetoothDevice = mBluetoothAdapter.getRemoteDevice(device.getAddress());
            }
        }
        if (mBluetoothDevice == null) {
            return false;
        }
        return isBluetoothFeatureSupport(bluetoothFlag);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isBluetoothFeatureSupport(int r9) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "isBluetoothFBRecording bluetoothFlag="
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r9)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "HwAudioKit.EnhancedDeviceInfo"
            com.huawei.multimedia.audiokit.utils.LogUtils.info(r1, r0)
            r0 = 0
            java.lang.Class<android.bluetooth.BluetoothDevice> r2 = android.bluetooth.BluetoothDevice.class
            java.lang.String r3 = "getMetadata"
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            r7 = 0
            r5[r7] = r6     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            java.lang.reflect.Method r3 = r2.getMethod(r3, r5)     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            android.bluetooth.BluetoothDevice r5 = mBluetoothDevice     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            r6[r7] = r8     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            java.lang.Object r5 = r3.invoke(r5, r6)     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            boolean r6 = r5 instanceof byte[]     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            if (r6 == 0) goto L_0x006f
            r6 = r5
            byte[] r6 = (byte[]) r6     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            byte[] r6 = (byte[]) r6     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            int r8 = r6.length     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            if (r8 <= 0) goto L_0x006f
            byte r8 = r6[r7]     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            if (r8 != 0) goto L_0x0048
            r4 = r7
        L_0x0048:
            r0 = r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            r4.<init>()     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            java.lang.String r8 = "isBluetoothFBRecording byteArray[0]="
            java.lang.StringBuilder r4 = r4.append(r8)     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            byte r7 = r6[r7]     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            java.lang.StringBuilder r4 = r4.append(r7)     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            java.lang.String r4 = r4.toString()     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            com.huawei.multimedia.audiokit.utils.LogUtils.info(r1, r4)     // Catch:{ NoSuchMethodException -> 0x0069, IllegalAccessException | IllegalArgumentException | InvocationTargetException -> 0x0062 }
            goto L_0x006f
        L_0x0062:
            r2 = move-exception
            java.lang.String r3 = "isBluetoothFBRecording Exception"
            com.huawei.multimedia.audiokit.utils.LogUtils.error(r1, r3)
            goto L_0x0070
        L_0x0069:
            r2 = move-exception
            java.lang.String r3 = "No Such Method getMetadata"
            com.huawei.multimedia.audiokit.utils.LogUtils.error(r1, r3)
        L_0x006f:
        L_0x0070:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.multimedia.audiokit.interfaces.EnhancedDeviceInfo.isBluetoothFeatureSupport(int):boolean");
    }

    private void createAudioManager() {
        if (this.mAudioManager == null) {
            Object systemService = this.mContext.getSystemService("audio");
            if (systemService instanceof AudioManager) {
                this.mAudioManager = (AudioManager) systemService;
            }
        }
    }
}
