package com.baidu.easyab.filewriter;

import com.baidu.abtest.debug.AbTestMockManager;
import com.baidu.easyab.datawriter.BaseDataWriter;
import com.baidu.easyab.datawriter.JSONDataWriter;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import java.io.File;

public class JSONFileWriter extends BaseFileWriter {
    private static final String AB_FILE_PATH = "abjson";

    public BaseDataWriter getDataWriter() {
        return new JSONDataWriter();
    }

    public String getBaseDir() {
        if (!AppConfig.isDebug() || !AbTestMockManager.getMockSwitch() || !AbTestMockManager.hasMockFile()) {
            return AppRuntime.getAppContext().getApplicationInfo().dataDir + File.separator + "abjson";
        }
        return AbTestMockManager.getMockFileDir().getAbsolutePath();
    }

    public void writeFile(String fileName, String data) {
        String baseDir = getBaseDir();
        File baseDirFile = new File(baseDir);
        if (!baseDirFile.exists()) {
            baseDirFile.mkdirs();
        }
        getDataWriter().writeData(baseDir + File.separator + fileName, data);
    }

    public String readFile(String fileName) {
        String baseDir = getBaseDir();
        if (!new File(baseDir).exists()) {
            return null;
        }
        return getDataWriter().readData(baseDir + File.separator + fileName);
    }
}
