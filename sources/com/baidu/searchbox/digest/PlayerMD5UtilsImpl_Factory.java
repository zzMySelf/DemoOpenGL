package com.baidu.searchbox.digest;

public class PlayerMD5UtilsImpl_Factory {
    private static volatile PlayerMD5UtilsImpl instance;

    private PlayerMD5UtilsImpl_Factory() {
    }

    public static synchronized PlayerMD5UtilsImpl get() {
        PlayerMD5UtilsImpl playerMD5UtilsImpl;
        synchronized (PlayerMD5UtilsImpl_Factory.class) {
            if (instance == null) {
                instance = new PlayerMD5UtilsImpl();
            }
            playerMD5UtilsImpl = instance;
        }
        return playerMD5UtilsImpl;
    }
}
