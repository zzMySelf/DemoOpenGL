package com.otaliastudios.cameraview.internal;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.CameraLogger;
import fe.vvv.qw.xxx.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DeviceEncoders {

    /* renamed from: rg  reason: collision with root package name */
    public static final CameraLogger f6749rg = CameraLogger.qw(DeviceEncoders.class.getSimpleName());
    @VisibleForTesting

    /* renamed from: th  reason: collision with root package name */
    public static boolean f6750th = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: ad  reason: collision with root package name */
    public final MediaCodecInfo f6751ad;

    /* renamed from: de  reason: collision with root package name */
    public final MediaCodecInfo.VideoCapabilities f6752de;

    /* renamed from: fe  reason: collision with root package name */
    public final MediaCodecInfo.AudioCapabilities f6753fe;
    public final MediaCodecInfo qw;

    public class AudioException extends RuntimeException {
        public /* synthetic */ AudioException(DeviceEncoders deviceEncoders, String str, qw qwVar) {
            this(str);
        }

        public AudioException(@NonNull String str) {
            super(str);
        }
    }

    public class VideoException extends RuntimeException {
        public /* synthetic */ VideoException(DeviceEncoders deviceEncoders, String str, qw qwVar) {
            this(str);
        }

        public VideoException(@NonNull String str) {
            super(str);
        }
    }

    public class qw implements Comparator<MediaCodecInfo> {
        public qw() {
        }

        /* renamed from: qw */
        public int compare(MediaCodecInfo mediaCodecInfo, MediaCodecInfo mediaCodecInfo2) {
            return Boolean.compare(DeviceEncoders.this.i(mediaCodecInfo2.getName()), DeviceEncoders.this.i(mediaCodecInfo.getName()));
        }
    }

    @SuppressLint({"NewApi"})
    public DeviceEncoders(int i2, @NonNull String str, @NonNull String str2, int i3, int i4) {
        if (f6750th) {
            List<MediaCodecInfo> de2 = de();
            MediaCodecInfo qw2 = qw(de2, str, i2, i3);
            this.qw = qw2;
            f6749rg.de("Enabled. Found video encoder:", qw2.getName());
            MediaCodecInfo qw3 = qw(de2, str2, i2, i4);
            this.f6751ad = qw3;
            f6749rg.de("Enabled. Found audio encoder:", qw3.getName());
            this.f6752de = this.qw.getCapabilitiesForType(str).getVideoCapabilities();
            this.f6753fe = this.f6751ad.getCapabilitiesForType(str2).getAudioCapabilities();
            return;
        }
        this.qw = null;
        this.f6751ad = null;
        this.f6752de = null;
        this.f6753fe = null;
        f6749rg.de("Disabled.");
    }

    @SuppressLint({"NewApi"})
    @Nullable
    public String ad() {
        MediaCodecInfo mediaCodecInfo = this.f6751ad;
        if (mediaCodecInfo != null) {
            return mediaCodecInfo.getName();
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    @VisibleForTesting
    @NonNull
    public List<MediaCodecInfo> de() {
        ArrayList arrayList = new ArrayList();
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
            if (mediaCodecInfo.isEncoder()) {
                arrayList.add(mediaCodecInfo);
            }
        }
        return arrayList;
    }

    @SuppressLint({"NewApi"})
    public int fe(int i2) {
        if (!f6750th) {
            return i2;
        }
        int intValue = this.f6753fe.getBitrateRange().clamp(Integer.valueOf(i2)).intValue();
        f6749rg.de("getSupportedAudioBitRate -", "inputRate:", Integer.valueOf(i2), "adjustedRate:", Integer.valueOf(intValue));
        return intValue;
    }

    @VisibleForTesting
    @SuppressLint({"NewApi"})
    public boolean i(@NonNull String str) {
        String lowerCase = str.toLowerCase();
        return !(lowerCase.startsWith("omx.google.") || lowerCase.startsWith("c2.android.") || (!lowerCase.startsWith("omx.") && !lowerCase.startsWith("c2.")));
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0054 A[SYNTHETIC, Splitter:B:25:0x0054] */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o(@androidx.annotation.NonNull java.lang.String r3, int r4, int r5, int r6) {
        /*
            r2 = this;
            android.media.MediaCodecInfo r0 = r2.f6751ad
            if (r0 == 0) goto L_0x0058
            r0 = 0
            android.media.MediaFormat r3 = android.media.MediaFormat.createAudioFormat(r3, r5, r6)     // Catch:{ Exception -> 0x0033, all -> 0x0031 }
            r5 = 2
            if (r6 != r5) goto L_0x000f
            r5 = 12
            goto L_0x0011
        L_0x000f:
            r5 = 16
        L_0x0011:
            java.lang.String r6 = "channel-mask"
            r3.setInteger(r6, r5)     // Catch:{ Exception -> 0x0033, all -> 0x0031 }
            java.lang.String r5 = "bitrate"
            r3.setInteger(r5, r4)     // Catch:{ Exception -> 0x0033, all -> 0x0031 }
            android.media.MediaCodecInfo r4 = r2.f6751ad     // Catch:{ Exception -> 0x0033, all -> 0x0031 }
            java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x0033, all -> 0x0031 }
            android.media.MediaCodec r4 = android.media.MediaCodec.createByCodecName(r4)     // Catch:{ Exception -> 0x0033, all -> 0x0031 }
            r5 = 1
            r4.configure(r3, r0, r0, r5)     // Catch:{ Exception -> 0x002f }
            if (r4 == 0) goto L_0x0058
            r4.release()     // Catch:{ Exception -> 0x0058 }
            goto L_0x0058
        L_0x002f:
            r3 = move-exception
            goto L_0x0035
        L_0x0031:
            r3 = move-exception
            goto L_0x0052
        L_0x0033:
            r3 = move-exception
            r4 = r0
        L_0x0035:
            com.otaliastudios.cameraview.internal.DeviceEncoders$AudioException r5 = new com.otaliastudios.cameraview.internal.DeviceEncoders$AudioException     // Catch:{ all -> 0x0050 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0050 }
            r6.<init>()     // Catch:{ all -> 0x0050 }
            java.lang.String r1 = "Failed to configure video audio: "
            r6.append(r1)     // Catch:{ all -> 0x0050 }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x0050 }
            r6.append(r3)     // Catch:{ all -> 0x0050 }
            java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x0050 }
            r5.<init>(r2, r3, r0)     // Catch:{ all -> 0x0050 }
            throw r5     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r3 = move-exception
            r0 = r4
        L_0x0052:
            if (r0 == 0) goto L_0x0057
            r0.release()     // Catch:{ Exception -> 0x0057 }
        L_0x0057:
            throw r3
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.internal.DeviceEncoders.o(java.lang.String, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061 A[SYNTHETIC, Splitter:B:20:0x0061] */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void pf(@androidx.annotation.NonNull java.lang.String r3, @androidx.annotation.NonNull fe.vvv.qw.xxx.ad r4, int r5, int r6) {
        /*
            r2 = this;
            android.media.MediaCodecInfo r0 = r2.qw
            if (r0 == 0) goto L_0x0065
            r0 = 0
            int r1 = r4.rg()     // Catch:{ Exception -> 0x0040, all -> 0x003e }
            int r4 = r4.fe()     // Catch:{ Exception -> 0x0040, all -> 0x003e }
            android.media.MediaFormat r3 = android.media.MediaFormat.createVideoFormat(r3, r1, r4)     // Catch:{ Exception -> 0x0040, all -> 0x003e }
            java.lang.String r4 = "color-format"
            r1 = 2130708361(0x7f000789, float:1.701803E38)
            r3.setInteger(r4, r1)     // Catch:{ Exception -> 0x0040, all -> 0x003e }
            java.lang.String r4 = "bitrate"
            r3.setInteger(r4, r6)     // Catch:{ Exception -> 0x0040, all -> 0x003e }
            java.lang.String r4 = "frame-rate"
            r3.setInteger(r4, r5)     // Catch:{ Exception -> 0x0040, all -> 0x003e }
            java.lang.String r4 = "i-frame-interval"
            r5 = 1
            r3.setInteger(r4, r5)     // Catch:{ Exception -> 0x0040, all -> 0x003e }
            android.media.MediaCodecInfo r4 = r2.qw     // Catch:{ Exception -> 0x0040, all -> 0x003e }
            java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x0040, all -> 0x003e }
            android.media.MediaCodec r4 = android.media.MediaCodec.createByCodecName(r4)     // Catch:{ Exception -> 0x0040, all -> 0x003e }
            r4.configure(r3, r0, r0, r5)     // Catch:{ Exception -> 0x003c }
            if (r4 == 0) goto L_0x0065
            r4.release()     // Catch:{ Exception -> 0x0065 }
            goto L_0x0065
        L_0x003c:
            r3 = move-exception
            goto L_0x0042
        L_0x003e:
            r3 = move-exception
            goto L_0x005f
        L_0x0040:
            r3 = move-exception
            r4 = r0
        L_0x0042:
            com.otaliastudios.cameraview.internal.DeviceEncoders$VideoException r5 = new com.otaliastudios.cameraview.internal.DeviceEncoders$VideoException     // Catch:{ all -> 0x005d }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r6.<init>()     // Catch:{ all -> 0x005d }
            java.lang.String r1 = "Failed to configure video codec: "
            r6.append(r1)     // Catch:{ all -> 0x005d }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x005d }
            r6.append(r3)     // Catch:{ all -> 0x005d }
            java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x005d }
            r5.<init>(r2, r3, r0)     // Catch:{ all -> 0x005d }
            throw r5     // Catch:{ all -> 0x005d }
        L_0x005d:
            r3 = move-exception
            r0 = r4
        L_0x005f:
            if (r0 == 0) goto L_0x0064
            r0.release()     // Catch:{ Exception -> 0x0064 }
        L_0x0064:
            throw r3
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.internal.DeviceEncoders.pf(java.lang.String, fe.vvv.qw.xxx.ad, int, int):void");
    }

    @SuppressLint({"NewApi"})
    @VisibleForTesting
    @NonNull
    public MediaCodecInfo qw(@NonNull List<MediaCodecInfo> list, @NonNull String str, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        Iterator<MediaCodecInfo> it = list.iterator();
        while (true) {
            int i4 = 0;
            if (!it.hasNext()) {
                break;
            }
            MediaCodecInfo next = it.next();
            String[] supportedTypes = next.getSupportedTypes();
            int length = supportedTypes.length;
            while (true) {
                if (i4 >= length) {
                    break;
                } else if (supportedTypes[i4].equalsIgnoreCase(str)) {
                    arrayList.add(next);
                    break;
                } else {
                    i4++;
                }
            }
        }
        f6749rg.de("findDeviceEncoder -", "type:", str, "encoders:", Integer.valueOf(arrayList.size()));
        if (i2 == 1) {
            Collections.sort(arrayList, new qw());
        }
        if (arrayList.size() >= i3 + 1) {
            return (MediaCodecInfo) arrayList.get(i3);
        }
        throw new RuntimeException("No encoders for type:" + str);
    }

    @SuppressLint({"NewApi"})
    public int rg(int i2) {
        if (!f6750th) {
            return i2;
        }
        int intValue = this.f6752de.getBitrateRange().clamp(Integer.valueOf(i2)).intValue();
        f6749rg.de("getSupportedVideoBitRate -", "inputRate:", Integer.valueOf(i2), "adjustedRate:", Integer.valueOf(intValue));
        return intValue;
    }

    @SuppressLint({"NewApi"})
    public int th(@NonNull ad adVar, int i2) {
        if (!f6750th) {
            return i2;
        }
        int doubleValue = (int) this.f6752de.getSupportedFrameRatesFor(adVar.rg(), adVar.fe()).clamp(Double.valueOf((double) i2)).doubleValue();
        f6749rg.de("getSupportedVideoFrameRate -", "inputRate:", Integer.valueOf(i2), "adjustedRate:", Integer.valueOf(doubleValue));
        return doubleValue;
    }

    @SuppressLint({"NewApi"})
    @Nullable
    public String uk() {
        MediaCodecInfo mediaCodecInfo = this.qw;
        if (mediaCodecInfo != null) {
            return mediaCodecInfo.getName();
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    @NonNull
    public ad yj(@NonNull ad adVar) {
        if (!f6750th) {
            return adVar;
        }
        int rg2 = adVar.rg();
        int fe2 = adVar.fe();
        double d = ((double) rg2) / ((double) fe2);
        f6749rg.de("getSupportedVideoSize - started. width:", Integer.valueOf(rg2), "height:", Integer.valueOf(fe2));
        if (this.f6752de.getSupportedWidths().getUpper().intValue() < rg2) {
            rg2 = this.f6752de.getSupportedWidths().getUpper().intValue();
            fe2 = (int) Math.round(((double) rg2) / d);
            f6749rg.de("getSupportedVideoSize - exceeds maxWidth! width:", Integer.valueOf(rg2), "height:", Integer.valueOf(fe2));
        }
        if (this.f6752de.getSupportedHeights().getUpper().intValue() < fe2) {
            fe2 = this.f6752de.getSupportedHeights().getUpper().intValue();
            rg2 = (int) Math.round(((double) fe2) * d);
            f6749rg.de("getSupportedVideoSize - exceeds maxHeight! width:", Integer.valueOf(rg2), "height:", Integer.valueOf(fe2));
        }
        while (rg2 % this.f6752de.getWidthAlignment() != 0) {
            rg2--;
        }
        while (fe2 % this.f6752de.getHeightAlignment() != 0) {
            fe2--;
        }
        f6749rg.de("getSupportedVideoSize - aligned. width:", Integer.valueOf(rg2), "height:", Integer.valueOf(fe2));
        if (!this.f6752de.getSupportedWidths().contains(Integer.valueOf(rg2))) {
            throw new VideoException(this, "Width not supported after adjustment. Desired:" + rg2 + " Range:" + this.f6752de.getSupportedWidths(), (qw) null);
        } else if (this.f6752de.getSupportedHeights().contains(Integer.valueOf(fe2))) {
            try {
                if (!this.f6752de.getSupportedHeightsFor(rg2).contains(Integer.valueOf(fe2))) {
                    int intValue = this.f6752de.getSupportedWidths().getLower().intValue();
                    int widthAlignment = this.f6752de.getWidthAlignment();
                    int i2 = rg2;
                    while (i2 >= intValue) {
                        i2 -= 32;
                        while (i2 % widthAlignment != 0) {
                            i2--;
                        }
                        int round = (int) Math.round(((double) i2) / d);
                        if (this.f6752de.getSupportedHeightsFor(i2).contains(Integer.valueOf(round))) {
                            f6749rg.i("getSupportedVideoSize - restarting with smaller size.");
                            return yj(new ad(i2, round));
                        }
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
            if (this.f6752de.isSizeSupported(rg2, fe2)) {
                return new ad(rg2, fe2);
            }
            throw new VideoException(this, "Size not supported for unknown reason. Might be an aspect ratio issue. Desired size:" + new ad(rg2, fe2), (qw) null);
        } else {
            throw new VideoException(this, "Height not supported after adjustment. Desired:" + fe2 + " Range:" + this.f6752de.getSupportedHeights(), (qw) null);
        }
    }
}
