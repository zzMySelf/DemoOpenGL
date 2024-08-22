package com.baidu.searchbox.logsystem.logsys;

import java.io.File;

public class LogFile {
    public boolean mCanDelete = true;
    public File mFile;
    public boolean mNecessary = false;

    public LogFile(File file, boolean canDelete) {
        this.mFile = file;
        this.mCanDelete = canDelete;
    }

    public LogFile(File file, boolean canDelete, boolean necessary) {
        this.mFile = file;
        this.mCanDelete = canDelete;
        this.mNecessary = necessary;
    }

    public LogFile(File file) {
        this.mFile = file;
    }

    public static void init() {
    }

    public String toString() {
        return this.mFile.getAbsolutePath() + "," + this.mCanDelete + "," + this.mNecessary;
    }
}
