package com.baidu.swan.games.network.download;

import com.baidu.searchbox.v8engine.V8JavascriptField;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class DownloadProgressData {
    @V8JavascriptField
    public int progress;
    @V8JavascriptField
    public long totalBytesExpectedToWrite;
    @V8JavascriptField
    public long totalBytesWritten;

    public DownloadProgressData(int progress2, long totalBytesExpectedToWrite2, long totalBytesWritten2) {
        this.progress = progress2;
        this.totalBytesExpectedToWrite = totalBytesExpectedToWrite2;
        this.totalBytesWritten = totalBytesWritten2;
    }

    public String toString() {
        return "TaskProgressData{progress=" + this.progress + ", totalBytesExpectedToWrite=" + this.totalBytesExpectedToWrite + ", totalBytesWritten=" + this.totalBytesWritten + AbstractJsonLexerKt.END_OBJ;
    }
}
