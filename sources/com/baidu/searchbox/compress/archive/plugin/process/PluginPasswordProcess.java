package com.baidu.searchbox.compress.archive.plugin.process;

import android.util.Log;
import com.baidu.searchbox.comporess.plugin.inter.ArchiveWrapper;
import com.baidu.searchbox.compress.archive.IArchiveProgressListener;
import com.baidu.searchbox.compress.archive.impl.BdArchiveImpl;
import com.baidu.searchbox.compress.archive.interact.PasswordInteract;
import com.baidu.searchbox.compress.archive.process.AbstractProcess;
import com.baidu.searchbox.compress.archive.process.NotifyErrorProcess;
import com.baidu.searchbox.compress.archive.utils.BdArchiveConsts;
import com.baidu.searchbox.config.AppConfig;

public class PluginPasswordProcess extends AbstractProcess {
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = PluginPasswordProcess.class.getSimpleName();
    /* access modifiers changed from: private */
    public ArchiveWrapper archiveWrapper;
    private PasswordInteract interact = new PasswordInteract(this.interactListener);
    private PasswordInteract.IResultListener interactListener = new PasswordInteract.IResultListener() {
        public void onCommit(String password) {
            if (PluginPasswordProcess.this.archive != null) {
                PluginPasswordProcess.this.archive.setPassword(password);
            }
            PluginPasswordProcess.this.notifyInteractFinished();
        }

        public void onCancel() {
            if (PluginPasswordProcess.this.archive != null) {
                PluginPasswordProcess.this.archive.setPassword("");
            }
            PluginPasswordProcess.this.notifyInteractCanceled();
        }

        public boolean requirePwdVerify(String password) {
            if (PluginPasswordProcess.this.archiveWrapper != null) {
                return PluginPasswordProcess.this.archiveWrapper.verifyPassword(password);
            }
            return true;
        }
    };

    public PluginPasswordProcess(BdArchiveImpl archive, ArchiveWrapper archiveWrapper2) {
        this.archive = archive;
        this.archiveWrapper = archiveWrapper2;
    }

    public void process() {
        this.archive.updateState(IArchiveProgressListener.ArchiveState.CHECKING);
        ArchiveWrapper archiveWrapper2 = this.archiveWrapper;
        if (archiveWrapper2 == null || !archiveWrapper2.isValid()) {
            if (DEBUG) {
                Log.d(TAG, "archive wrapper init failed!!!");
            }
            setErrorProcessor(new NotifyErrorProcess(this.archive, BdArchiveConsts.ErrorCode.DEC_INVALID));
            return;
        }
        this.archive.setPwdVerifyInProcess(true);
        if (!this.archiveWrapper.isEncrypted()) {
            this.interact.skip();
        } else if (!this.interact.isFinished()) {
            this.archive.requestPassword(this.interact);
        }
    }

    public boolean isNeedInteract() {
        ArchiveWrapper archiveWrapper2 = this.archiveWrapper;
        return archiveWrapper2 != null && archiveWrapper2.isValid() && this.archiveWrapper.isEncrypted();
    }

    public boolean isInteractFinished() {
        return this.interact.isFinished();
    }
}
