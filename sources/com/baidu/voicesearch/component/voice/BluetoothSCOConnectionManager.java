package com.baidu.voicesearch.component.voice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.baidu.voicesearch.component.utils.TakeSampleUtil;
import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001,B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010%\u001a\u00020\u001eJ\u0006\u0010&\u001a\u00020\u001eJ\u0006\u0010'\u001a\u00020\u001eJ\u0006\u0010(\u001a\u00020\u001eJ\u0006\u0010)\u001a\u00020\u001eJ\u0006\u0010*\u001a\u00020+R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 XD¢\u0006\u0002\n\u0000R$\u0010!\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00048F@FX\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010$¨\u0006-"}, d2 = {"Lcom/baidu/voicesearch/component/voice/BluetoothSCOConnectionManager;", "", "()V", "SCO_AUDIO_STATE_CONNECTED", "", "getSCO_AUDIO_STATE_CONNECTED", "()I", "SCO_AUDIO_STATE_CONNECTING", "getSCO_AUDIO_STATE_CONNECTING", "SCO_AUDIO_STATE_DISCONNECTED", "getSCO_AUDIO_STATE_DISCONNECTED", "SCO_AUDIO_STATE_ERROR", "getSCO_AUDIO_STATE_ERROR", "SCO_AUDIO_STATE_UNKNOW", "getSCO_AUDIO_STATE_UNKNOW", "TAG", "", "kotlin.jvm.PlatformType", "mAudioManager", "Landroid/media/AudioManager;", "mSCOAuiodState", "mScoBroadcastReceiver", "Lcom/baidu/voicesearch/component/voice/BluetoothSCOConnectionManager$BluetoothSCOBroadcastReceiver;", "mStartCondition", "Ljava/util/concurrent/locks/Condition;", "mStartLock", "Ljava/util/concurrent/locks/Lock;", "mStopCondition", "mStopLock", "registerSCOReceiverAvailable", "", "sTimeout", "", "scoAuiodState", "getScoAuiodState", "setScoAuiodState", "(I)V", "hasBluetoothLinked", "hasEarphoneLinked", "hasWiredHeadsetLinked", "isAllowedToUseBluetoothMic", "startBluetoothSco", "stopSCO", "", "BluetoothSCOBroadcastReceiver", "lib-speech-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BluetoothSCOConnectionManager.kt */
public final class BluetoothSCOConnectionManager {
    public static final BluetoothSCOConnectionManager INSTANCE;
    private static final int SCO_AUDIO_STATE_CONNECTED = 1;
    private static final int SCO_AUDIO_STATE_CONNECTING = 2;
    private static final int SCO_AUDIO_STATE_DISCONNECTED = 0;
    private static final int SCO_AUDIO_STATE_ERROR = -1;
    private static final int SCO_AUDIO_STATE_UNKNOW = 3;
    /* access modifiers changed from: private */
    public static final String TAG = BluetoothSCOConnectionManager.class.getSimpleName();
    private static AudioManager mAudioManager;
    private static int mSCOAuiodState = 3;
    private static BluetoothSCOBroadcastReceiver mScoBroadcastReceiver = new BluetoothSCOBroadcastReceiver();
    /* access modifiers changed from: private */
    public static Condition mStartCondition;
    /* access modifiers changed from: private */
    public static Lock mStartLock = new ReentrantLock();
    /* access modifiers changed from: private */
    public static Condition mStopCondition;
    /* access modifiers changed from: private */
    public static Lock mStopLock = new ReentrantLock();
    private static boolean registerSCOReceiverAvailable;
    private static final long sTimeout = 3000;

    private BluetoothSCOConnectionManager() {
    }

    static {
        BluetoothSCOConnectionManager bluetoothSCOConnectionManager = new BluetoothSCOConnectionManager();
        INSTANCE = bluetoothSCOConnectionManager;
        registerSCOReceiverAvailable = true;
        Context context = VoiceApplicationManager.getApplicationContext();
        if (mAudioManager == null && context != null) {
            Object systemService = context.getSystemService("audio");
            if (systemService != null) {
                mAudioManager = (AudioManager) systemService;
                try {
                    Intent intent = context.registerReceiver(mScoBroadcastReceiver, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
                    if (intent != null) {
                        bluetoothSCOConnectionManager.setScoAuiodState(intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1));
                    } else {
                        registerSCOReceiverAvailable = false;
                    }
                } catch (Exception e2) {
                    INSTANCE.setScoAuiodState(SCO_AUDIO_STATE_UNKNOW);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
            }
        }
    }

    public final int getSCO_AUDIO_STATE_DISCONNECTED() {
        return SCO_AUDIO_STATE_DISCONNECTED;
    }

    public final int getSCO_AUDIO_STATE_CONNECTED() {
        return SCO_AUDIO_STATE_CONNECTED;
    }

    public final int getSCO_AUDIO_STATE_CONNECTING() {
        return SCO_AUDIO_STATE_CONNECTING;
    }

    public final int getSCO_AUDIO_STATE_ERROR() {
        return SCO_AUDIO_STATE_ERROR;
    }

    public final int getSCO_AUDIO_STATE_UNKNOW() {
        return SCO_AUDIO_STATE_UNKNOW;
    }

    public final int getScoAuiodState() {
        int i2;
        synchronized (this) {
            i2 = mSCOAuiodState;
        }
        return i2;
    }

    public final void setScoAuiodState(int scoAuiodState) {
        synchronized (this) {
            mSCOAuiodState = scoAuiodState;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/voicesearch/component/voice/BluetoothSCOConnectionManager$BluetoothSCOBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "lib-speech-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BluetoothSCOConnectionManager.kt */
    private static final class BluetoothSCOBroadcastReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (intent != null) {
                BluetoothSCOConnectionManager.INSTANCE.setScoAuiodState(intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1));
                if (BluetoothSCOConnectionManager.mStartCondition != null && (BluetoothSCOConnectionManager.INSTANCE.getSCO_AUDIO_STATE_CONNECTED() == BluetoothSCOConnectionManager.INSTANCE.getScoAuiodState() || BluetoothSCOConnectionManager.INSTANCE.getSCO_AUDIO_STATE_ERROR() == BluetoothSCOConnectionManager.INSTANCE.getScoAuiodState())) {
                    BluetoothSCOConnectionManager.mStartLock.lock();
                    try {
                        Condition access$getMStartCondition$p = BluetoothSCOConnectionManager.mStartCondition;
                        Intrinsics.checkNotNull(access$getMStartCondition$p);
                        access$getMStartCondition$p.signal();
                    } finally {
                        BluetoothSCOConnectionManager.mStartLock.unlock();
                    }
                }
                if (BluetoothSCOConnectionManager.mStopCondition != null && BluetoothSCOConnectionManager.INSTANCE.getScoAuiodState() == 0) {
                    BluetoothSCOConnectionManager.mStopLock.lock();
                    try {
                        Condition access$getMStopCondition$p = BluetoothSCOConnectionManager.mStopCondition;
                        Intrinsics.checkNotNull(access$getMStopCondition$p);
                        access$getMStopCondition$p.signal();
                    } finally {
                        BluetoothSCOConnectionManager.mStopLock.unlock();
                    }
                }
            }
        }
    }

    public final boolean isAllowedToUseBluetoothMic() {
        try {
            boolean isBluetoothInputEnable = TakeSampleUtil.isBlueToothInputEnable(VoiceApplicationManager.getApplicationContext());
            boolean isInBluetoothBlacklist = TakeSampleUtil.isInBluetoothBlacklist(VoiceApplicationManager.getApplicationContext());
            if (mAudioManager == null || !isBluetoothInputEnable || isInBluetoothBlacklist || !BluetoothConnectionManager.INSTANCE.isBluetoothHeadSetLink() || !hasBluetoothLinked()) {
                return false;
            }
            return true;
        } catch (Exception e2) {
        }
        return false;
    }

    public final boolean hasEarphoneLinked() {
        return hasWiredHeadsetLinked() || hasBluetoothLinked();
    }

    public final boolean hasWiredHeadsetLinked() {
        try {
            AudioManager audioManager = mAudioManager;
            return audioManager != null && audioManager.isWiredHeadsetOn();
        } catch (Exception e2) {
        }
    }

    public final boolean hasBluetoothLinked() {
        try {
            if (BluetoothConnectionManager.INSTANCE.isBluetoothLinked()) {
                AudioManager audioManager = mAudioManager;
                if (!(audioManager != null && audioManager.isBluetoothScoAvailableOffCall()) || !registerSCOReceiverAvailable) {
                    return false;
                }
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public final boolean startBluetoothSco() {
        AudioManager audioManager;
        if (getScoAuiodState() == SCO_AUDIO_STATE_UNKNOW || (audioManager = mAudioManager) == null) {
            return false;
        }
        try {
            Intrinsics.checkNotNull(audioManager);
            audioManager.startBluetoothSco();
            mStartCondition = mStartLock.newCondition();
            mStartLock.lock();
            try {
                Date date = new Date(System.currentTimeMillis() + sTimeout);
                Condition condition = mStartCondition;
                if (condition != null) {
                    Intrinsics.checkNotNull(condition);
                    condition.awaitUntil(date);
                }
            } catch (InterruptedException e2) {
            } catch (Throwable th2) {
                mStartLock.unlock();
                throw th2;
            }
            mStartLock.unlock();
            mStartCondition = null;
            try {
                if (1 == getScoAuiodState()) {
                    AudioManager audioManager2 = mAudioManager;
                    Intrinsics.checkNotNull(audioManager2);
                    audioManager2.setBluetoothScoOn(true);
                }
                if (1 == getScoAuiodState()) {
                    return true;
                }
                return false;
            } catch (Exception e3) {
                return false;
            }
        } catch (Exception e4) {
            return false;
        }
    }

    public final void stopSCO() {
        if (mAudioManager == null) {
            return;
        }
        if (1 == getScoAuiodState() || 2 == getScoAuiodState()) {
            AudioManager audioManager = mAudioManager;
            Intrinsics.checkNotNull(audioManager);
            audioManager.setBluetoothScoOn(false);
            AudioManager audioManager2 = mAudioManager;
            Intrinsics.checkNotNull(audioManager2);
            audioManager2.stopBluetoothSco();
            mStopCondition = mStopLock.newCondition();
            mStopLock.lock();
            try {
                Date date = new Date(System.currentTimeMillis() + sTimeout);
                Condition condition = mStopCondition;
                Intrinsics.checkNotNull(condition);
                condition.awaitUntil(date);
            } catch (InterruptedException e2) {
            } catch (Throwable th2) {
                mStopLock.unlock();
                throw th2;
            }
            mStopLock.unlock();
            mStopCondition = null;
        }
    }
}
