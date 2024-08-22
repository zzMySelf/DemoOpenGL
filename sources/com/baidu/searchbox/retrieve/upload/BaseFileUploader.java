package com.baidu.searchbox.retrieve.upload;

import com.baidu.voyager.impl.net.ResponseEntity;
import java.io.File;

public abstract class BaseFileUploader {
    public abstract ResponseEntity uploadSync(String str, String str2, File file);
}
