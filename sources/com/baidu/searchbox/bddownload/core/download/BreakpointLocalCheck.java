package com.baidu.searchbox.bddownload.core.download;

import android.net.Uri;
import com.baidu.searchbox.bddownload.BdDownload;
import com.baidu.searchbox.bddownload.DownloadTask;
import com.baidu.searchbox.bddownload.core.Util;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import com.baidu.searchbox.bddownload.core.cause.ResumeFailedCause;
import java.io.File;

public class BreakpointLocalCheck {
    private boolean dirty;
    boolean fileExist;
    private final BreakpointInfo info;
    boolean infoRight;
    boolean outputStreamSupport;
    private final long responseInstanceLength;
    private final DownloadTask task;

    public BreakpointLocalCheck(DownloadTask task2, BreakpointInfo info2, long responseInstanceLength2) {
        this.task = task2;
        this.info = info2;
        this.responseInstanceLength = responseInstanceLength2;
    }

    public boolean isDirty() {
        return this.dirty;
    }

    public ResumeFailedCause getCauseOrThrow() {
        if (!this.infoRight) {
            return ResumeFailedCause.INFO_DIRTY;
        }
        if (!this.fileExist) {
            return ResumeFailedCause.FILE_NOT_EXIST;
        }
        if (!this.outputStreamSupport) {
            return ResumeFailedCause.OUTPUT_STREAM_NOT_SUPPORT;
        }
        throw new IllegalStateException("No cause find with dirty: " + this.dirty);
    }

    public boolean isInfoRightToResume() {
        int blockCount = this.info.getBlockCount();
        if (blockCount <= 0 || this.info.isChunked() || this.info.getFile() == null) {
            return false;
        }
        if (!this.info.getFile().equals(this.task.getFile()) || this.info.getFile().length() > this.info.getTotalLength()) {
            return false;
        }
        if (this.responseInstanceLength > 0 && this.info.getTotalLength() != this.responseInstanceLength) {
            return false;
        }
        for (int i2 = 0; i2 < blockCount; i2++) {
            if (this.info.getBlock(i2).getContentLength() <= 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isOutputStreamSupportResume() {
        if (BdDownload.with().outputStreamFactory().supportSeek()) {
            return true;
        }
        if (this.info.getBlockCount() == 1 && !BdDownload.with().processFileStrategy().isPreAllocateLength(this.task)) {
            return true;
        }
        return false;
    }

    public boolean isFileExistToResume() {
        Uri uri = this.task.getUri();
        if (!Util.isUriContentScheme(uri)) {
            File file = this.task.getFile();
            if (file == null || !file.exists()) {
                return false;
            }
            return true;
        } else if (Util.getSizeFromContentUri(uri) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void check() {
        this.fileExist = isFileExistToResume();
        this.infoRight = isInfoRightToResume();
        boolean isOutputStreamSupportResume = isOutputStreamSupportResume();
        this.outputStreamSupport = isOutputStreamSupportResume;
        this.dirty = !this.infoRight || !this.fileExist || !isOutputStreamSupportResume;
    }

    public String toString() {
        return "fileExist[" + this.fileExist + "] infoRight[" + this.infoRight + "] outputStreamSupport[" + this.outputStreamSupport + "] " + super.toString();
    }
}
