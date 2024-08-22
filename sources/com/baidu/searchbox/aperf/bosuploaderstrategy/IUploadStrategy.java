package com.baidu.searchbox.aperf.bosuploaderstrategy;

import java.io.File;
import java.util.List;

public interface IUploadStrategy {
    void reUpload();

    void upload(List<File> list, String str, String str2, IUploadListener iUploadListener);
}
