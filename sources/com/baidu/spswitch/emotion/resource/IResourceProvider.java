package com.baidu.spswitch.emotion.resource;

import java.io.File;

public interface IResourceProvider {
    String getEmotionConfigContent();

    File getEmotionIconResFile(String str);

    File getEmotionSoundFile();

    File getResourceBaseFile();

    void loadResource();
}
