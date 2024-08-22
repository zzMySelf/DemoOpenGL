package com.baidu.nadcore.sp;

import com.baidu.perf.safemode.config.Config;
import com.baidu.pyramid.runtime.service.ServiceReference;

public interface ISpFactory {
    public static final ISpFactory DEFAULT = new Impl();
    public static final ServiceReference SERVICE_REFERENCE = new ServiceReference("nad.core", Config.FilePath.TYPE_SP);

    SafeSpWrapper newInstance();

    SafeSpWrapper newInstance(String str);

    public static class Impl implements ISpFactory {
        public SafeSpWrapper newInstance() {
            return new SharedPrefsWrapper();
        }

        public SafeSpWrapper newInstance(String name) {
            return new SharedPrefsWrapper(name);
        }
    }
}
