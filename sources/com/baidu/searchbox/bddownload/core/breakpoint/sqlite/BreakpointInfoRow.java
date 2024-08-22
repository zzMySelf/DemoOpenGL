package com.baidu.searchbox.bddownload.core.breakpoint.sqlite;

import android.database.Cursor;
import com.baidu.searchbox.bddownload.core.breakpoint.BreakpointInfo;
import java.io.File;

public class BreakpointInfoRow {
    private final boolean chunked;
    private final String etag;
    private final String filename;
    private final int id;
    private String mimeType;
    private final String parentPath;
    private final boolean taskOnlyProvidedParentPath;
    private final String url;

    public BreakpointInfoRow(Cursor cursor) {
        this.id = cursor.getInt(cursor.getColumnIndex("id"));
        this.url = cursor.getString(cursor.getColumnIndex("url"));
        this.etag = cursor.getString(cursor.getColumnIndex("etag"));
        this.parentPath = cursor.getString(cursor.getColumnIndex("parent_path"));
        this.filename = cursor.getString(cursor.getColumnIndex("filename"));
        boolean z = false;
        this.taskOnlyProvidedParentPath = cursor.getInt(cursor.getColumnIndex(BreakpointSQLiteKey.TASK_ONLY_PARENT_PATH)) == 1;
        this.chunked = cursor.getInt(cursor.getColumnIndex("chunked")) == 1 ? true : z;
        this.mimeType = cursor.getString(cursor.getColumnIndex(BreakpointSQLiteKey.MIME_TYPE));
    }

    public int getId() {
        return this.id;
    }

    public String getUrl() {
        return this.url;
    }

    public String getEtag() {
        return this.etag;
    }

    public String getParentPath() {
        return this.parentPath;
    }

    public String getFilename() {
        return this.filename;
    }

    public boolean isTaskOnlyProvidedParentPath() {
        return this.taskOnlyProvidedParentPath;
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public BreakpointInfo toInfo() {
        BreakpointInfo info = new BreakpointInfo(this.id, this.url, new File(this.parentPath), this.filename, this.taskOnlyProvidedParentPath);
        info.setEtag(this.etag);
        info.setChunked(this.chunked);
        info.setMimeType(this.mimeType);
        return info;
    }
}
