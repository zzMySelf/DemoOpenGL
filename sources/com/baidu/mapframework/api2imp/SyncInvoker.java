package com.baidu.mapframework.api2imp;

import com.baidu.platform.comapi.ContextHolder;
import com.baidu.searchbox.plugin.api.HostInvokeCallback;
import com.baidu.searchbox.plugin.api.PluginInvoker;
import java.util.concurrent.CountDownLatch;

public class SyncInvoker {
    /* access modifiers changed from: private */
    public Thread callbackThread;
    /* access modifiers changed from: private */
    public Thread calledThread;

    public Result invoke(int managerID, String methodName, Class<?>[] parameterTypes, Object[] parameters, String from) {
        boolean isSelf = ContextHolder.getApplicationContext().getPackageName().startsWith("com.baidu.baidumaps.");
        final Result rs = new Result();
        this.calledThread = Thread.currentThread();
        final CountDownLatch latch = new CountDownLatch(1);
        try {
            PluginInvoker.invokeHost(managerID, methodName, parameterTypes, parameters, from, new HostInvokeCallback() {
                public void onResult(int i2, Object o) {
                    SyncInvoker.this.callbackThread = Thread.currentThread();
                    rs.f14788i = i2;
                    rs.o = o;
                    if (SyncInvoker.this.callbackThread != SyncInvoker.this.calledThread) {
                        latch.countDown();
                    }
                }
            });
            if (!isSelf && this.calledThread != this.callbackThread) {
                latch.await();
            }
        } catch (Throwable e2) {
            rs.t = e2;
        }
        return rs;
    }

    public static class Result {

        /* renamed from: i  reason: collision with root package name */
        public int f14788i;
        public Object o;
        public Throwable t;

        public boolean isValid() {
            return this.t == null;
        }

        public int getInt(int defaultValue) {
            int rs = defaultValue;
            if (this.t != null) {
                return rs;
            }
            try {
                return ((Integer) this.o).intValue();
            } catch (Exception e2) {
                return rs;
            }
        }

        public long getLong(long defaultValue) {
            long rs = defaultValue;
            if (this.t != null) {
                return rs;
            }
            try {
                return ((Long) this.o).longValue();
            } catch (Exception e2) {
                return rs;
            }
        }

        public boolean getBoolean(boolean defaultValue) {
            boolean rs = defaultValue;
            if (this.t != null) {
                return rs;
            }
            try {
                return ((Boolean) this.o).booleanValue();
            } catch (Exception e2) {
                return rs;
            }
        }

        public byte getByte(byte defaultValue) {
            byte rs = defaultValue;
            if (this.t != null) {
                return rs;
            }
            try {
                return ((Byte) this.o).byteValue();
            } catch (Exception e2) {
                return rs;
            }
        }

        public char getChar(char defaultValue) {
            char rs = defaultValue;
            if (this.t != null) {
                return rs;
            }
            try {
                return ((Character) this.o).charValue();
            } catch (Exception e2) {
                return rs;
            }
        }

        public short getShort(short defaultValue) {
            short rs = defaultValue;
            if (this.t != null) {
                return rs;
            }
            try {
                return ((Short) this.o).shortValue();
            } catch (Exception e2) {
                return rs;
            }
        }

        public float getFloat(float defaultValue) {
            float rs = defaultValue;
            if (this.t != null) {
                return rs;
            }
            try {
                return ((Float) this.o).floatValue();
            } catch (Exception e2) {
                return rs;
            }
        }

        public double getDouble(double defaultValue) {
            double rs = defaultValue;
            if (this.t != null) {
                return rs;
            }
            try {
                return ((Double) this.o).doubleValue();
            } catch (Exception e2) {
                return rs;
            }
        }

        public String getString(String defaultValue) {
            String rs = defaultValue;
            if (this.t != null) {
                return rs;
            }
            try {
                return (String) this.o;
            } catch (Exception e2) {
                return rs;
            }
        }

        public <T> T get(T defaultValue) {
            Object obj = this.o;
            if (obj == null || !obj.getClass().isInstance(defaultValue)) {
                return defaultValue;
            }
            return this.o;
        }
    }
}
