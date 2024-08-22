package com.baidu.swan.apps.core.prefetch.utils;

import java.io.File;

public class AppConfigFileModel {
    public File appConfigRootDir;
    public boolean isInDependentPkg;
    public String subRootPath;

    public boolean isValid() {
        return this.appConfigRootDir != null;
    }
}
