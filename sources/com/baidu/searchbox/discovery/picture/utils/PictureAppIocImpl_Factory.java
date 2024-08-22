package com.baidu.searchbox.discovery.picture.utils;

public class PictureAppIocImpl_Factory {
    private static volatile PictureAppIocImpl instance;

    private PictureAppIocImpl_Factory() {
    }

    public static synchronized PictureAppIocImpl get() {
        PictureAppIocImpl pictureAppIocImpl;
        synchronized (PictureAppIocImpl_Factory.class) {
            if (instance == null) {
                instance = new PictureAppIocImpl();
            }
            pictureAppIocImpl = instance;
        }
        return pictureAppIocImpl;
    }
}
