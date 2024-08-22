package com.baidu.growthsystem.business.common.tone;

import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import com.baidu.growthsystem.business.common.tone.download.DownloadExtKt;
import com.baidu.growthsystem.business.common.utils.VibrateUtilKt;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000fJ.\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000f2\b\b\u0002\u0010\u0019\u001a\u00020\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u0016\u001a\u00020\u000fJ\u0006\u0010\u001c\u001a\u00020\u000bJ\u0006\u0010\u001d\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/baidu/growthsystem/business/common/tone/CashCollectionToneManager;", "", "()V", "TAG", "", "TONE_DIR_NAME", "TONE_DOWNLOAD_PATH", "TONE_FILE_NAME", "TONE_ZIP_FILE_NAME", "downloadParentDir", "delFile", "", "file", "Ljava/io/File;", "ensureDirectoryExist", "", "dir", "getFileParentPath", "getFilePath", "getFileZipPath", "getPromptToneFile", "playPromptTone", "isRingtonePlay", "playPromptToneAndVibrate", "promptTone", "vibrate", "duration", "", "prefetchDownloadTone", "release", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CashCollectionToneManager.kt */
public final class CashCollectionToneManager {
    public static final CashCollectionToneManager INSTANCE = new CashCollectionToneManager();
    private static final String TAG = "CashCollection";
    private static final String TONE_DIR_NAME = "doduo_prompt_tone";
    private static final String TONE_DOWNLOAD_PATH = "https://b.bdstatic.com/searchbox/image/gcp/20220525/1435144135.zip";
    private static final String TONE_FILE_NAME = "cash_collection.mp3";
    private static final String TONE_ZIP_FILE_NAME = "cash_collection.zip";
    private static final String downloadParentDir = DownloadExtKt.getRootFileStoragePath();

    private CashCollectionToneManager() {
    }

    public static /* synthetic */ void playPromptTone$default(CashCollectionToneManager cashCollectionToneManager, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        cashCollectionToneManager.playPromptTone(z);
    }

    public final void playPromptTone(boolean isRingtonePlay) {
        Object obj;
        File it = getPromptToneFile();
        if (it != null) {
            try {
                Result.Companion companion = Result.Companion;
                Unit unit = null;
                if (isRingtonePlay) {
                    Ringtone ringtone = RingtoneManager.getRingtone(AppRuntime.getAppContext(), Uri.fromFile(it));
                    if (ringtone != null) {
                        ringtone.play();
                        unit = Unit.INSTANCE;
                    }
                } else {
                    MediaPalyerHelper.INSTANCE.playSound(it.getAbsolutePath(), (MediaPlayer.OnCompletionListener) null);
                    unit = Unit.INSTANCE;
                }
                obj = Result.m8971constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            Result.m8970boximpl(obj);
            return;
        }
        prefetchDownloadTone();
    }

    public static /* synthetic */ void playPromptToneAndVibrate$default(CashCollectionToneManager cashCollectionToneManager, boolean z, boolean z2, long j2, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        if ((i2 & 4) != 0) {
            j2 = 30;
        }
        if ((i2 & 8) != 0) {
            z3 = false;
        }
        cashCollectionToneManager.playPromptToneAndVibrate(z, z2, j2, z3);
    }

    public final void playPromptToneAndVibrate(boolean promptTone, boolean vibrate, long duration, boolean isRingtonePlay) {
        if (promptTone) {
            File file = getPromptToneFile();
            if (file == null) {
                prefetchDownloadTone();
            } else {
                try {
                    Result.Companion companion = Result.Companion;
                    Unit unit = null;
                    if (isRingtonePlay) {
                        Ringtone ringtone = RingtoneManager.getRingtone(AppRuntime.getAppContext(), Uri.fromFile(file));
                        if (ringtone != null) {
                            ringtone.play();
                            unit = Unit.INSTANCE;
                        }
                    } else {
                        MediaPalyerHelper.INSTANCE.playSound(file.getAbsolutePath(), (MediaPlayer.OnCompletionListener) null);
                        unit = Unit.INSTANCE;
                    }
                    Result.m8971constructorimpl(unit);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m8971constructorimpl(ResultKt.createFailure(th2));
                }
            }
        }
        if (vibrate) {
            VibrateUtilKt.vibrateStart(duration);
        }
    }

    public final void prefetchDownloadTone() {
        try {
            Result.Companion companion = Result.Companion;
            if (!new File(INSTANCE.getFilePath()).exists()) {
                ExecutorUtilsExt.postOnElastic(new CashCollectionToneManager$$ExternalSyntheticLambda0(), "task_doduo_prompt_tone", 1);
            }
            Result.m8971constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m8971constructorimpl(ResultKt.createFailure(th2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: prefetchDownloadTone$lambda-4$lambda-3  reason: not valid java name */
    public static final void m13617prefetchDownloadTone$lambda4$lambda3() {
        CashCollectionToneManager cashCollectionToneManager = INSTANCE;
        String fileZipPath = cashCollectionToneManager.getFileZipPath();
        String fileParentPath = cashCollectionToneManager.getFileParentPath();
        cashCollectionToneManager.ensureDirectoryExist(new File(fileParentPath));
        DownloadExtKt.downloadFile$default(TONE_DOWNLOAD_PATH, fileParentPath, TONE_ZIP_FILE_NAME, 0, new CashCollectionToneManager$prefetchDownloadTone$1$1$1(fileZipPath, fileParentPath), 8, (Object) null);
    }

    public final void release() {
        MediaPalyerHelper.INSTANCE.release();
    }

    private final File getPromptToneFile() {
        File toneFile = new File(getFilePath());
        if (toneFile.exists()) {
            return toneFile;
        }
        return null;
    }

    private final String getFilePath() {
        return downloadParentDir + "/doduo_prompt_tone/cash_collection.mp3";
    }

    private final String getFileZipPath() {
        return downloadParentDir + "/doduo_prompt_tone/cash_collection.zip";
    }

    private final String getFileParentPath() {
        return downloadParentDir + "/doduo_prompt_tone";
    }

    private final boolean ensureDirectoryExist(File dir) {
        if (dir == null) {
            return false;
        }
        CashCollectionToneManager cashCollectionToneManager = this;
        if (dir.exists()) {
            return true;
        }
        try {
            dir.mkdirs();
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public final void delFile(File file) {
        if (file.isFile() && file.exists()) {
            try {
                file.delete();
            } catch (Exception e2) {
                if (AppConfig.isDebug()) {
                    e2.printStackTrace();
                }
            }
        }
    }
}
