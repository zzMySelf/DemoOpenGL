package com.temp.searchbox.v8engine;

import android.webkit.JavascriptInterface;
import com.baidu.fsg.base.a;
import com.temp.searchbox.v8engine.event.JSEvent;

class BindingBenchmark {
    private final V8Engine mEngine;

    private static class JavaObject {
        @V8JavascriptField
        public double mDouble = 123.456789d;
        @V8JavascriptField
        public int mInt;
        @V8JavascriptField
        public JSEvent mJSEvent = new JSEvent(a.f11536g);
        @V8JavascriptField
        public Object mObject = new Object();
        @V8JavascriptField
        public String mString = "123.456789ABCDEF";

        @JavascriptInterface
        public void function(int i2, double d2, String str, Object o, JSEvent e2) {
        }

        public JavaObject(int i2) {
            this.mInt = i2;
        }
    }

    public BindingBenchmark(V8Engine v8Engine) {
        this.mEngine = v8Engine;
    }

    @JavascriptInterface
    public void testVoid() {
    }

    @JavascriptInterface
    public void testInt(int value) {
    }

    @JavascriptInterface
    public void testDouble(double value) {
    }

    @JavascriptInterface
    public void testString(String value) {
    }

    @JavascriptInterface
    public void testObject(JsObject value) {
        value.release();
    }

    @JavascriptInterface
    public void testArrayBuffer(JsArrayBuffer value) {
    }

    @JavascriptInterface
    public void testFunction(JsFunction value) {
        value.release();
    }

    @JavascriptInterface
    public long invokeJsFunctionVoid(JsFunction func, long count) {
        if (func == null || count <= 0) {
            return 0;
        }
        func.setReleaseMode(false);
        long startTime = System.currentTimeMillis();
        for (long i2 = 0; i2 < count; i2++) {
            func.call();
        }
        long elpasedTime = System.currentTimeMillis() - startTime;
        func.release();
        return elpasedTime;
    }

    @JavascriptInterface
    public long invokeJsFunctionInt(JsFunction func, long count) {
        if (func == null || count <= 0) {
            return 0;
        }
        func.setReleaseMode(false);
        long startTime = System.currentTimeMillis();
        for (long i2 = 0; i2 < count; i2++) {
            func.call(count);
        }
        long elpasedTime = System.currentTimeMillis() - startTime;
        func.release();
        return elpasedTime;
    }

    @JavascriptInterface
    public long invokeJsFunctionString(JsFunction func, long count) {
        if (func == null || count <= 0) {
            return 0;
        }
        String[] values = new String[1000];
        for (int i2 = 0; i2 < values.length; i2++) {
            values[i2] = i2 + "";
        }
        func.setReleaseMode(false);
        long startTime = System.currentTimeMillis();
        for (long i3 = 0; i3 < count; i3++) {
            func.call(values[(int) (count % ((long) values.length))]);
        }
        long elpasedTime = System.currentTimeMillis() - startTime;
        func.release();
        return elpasedTime;
    }

    @JavascriptInterface
    public long invokeJsFunctionObject(JsFunction func, long count) {
        if (func == null || count <= 0) {
            return 0;
        }
        Object[] values = new Object[1000];
        for (int i2 = 0; i2 < values.length; i2++) {
            values[i2] = new JavaObject(i2);
        }
        func.setReleaseMode(false);
        long startTime = System.currentTimeMillis();
        for (long i3 = 0; i3 < count; i3++) {
            func.call(values[(int) (count % ((long) values.length))]);
        }
        long elpasedTime = System.currentTimeMillis() - startTime;
        func.release();
        return elpasedTime;
    }

    @JavascriptInterface
    public long invokeJsFunctionArrayBuffer(JsFunction func, long count) {
        if (func == null || count <= 0) {
            return 0;
        }
        Object[] values = new Object[1000];
        for (int i2 = 0; i2 < values.length; i2++) {
            values[i2] = new JsArrayBuffer(new byte[(i2 + 1)], i2 + 1);
        }
        func.setReleaseMode(false);
        long startTime = System.currentTimeMillis();
        for (long i3 = 0; i3 < count; i3++) {
            func.call(values[(int) (count % ((long) values.length))]);
        }
        long elpasedTime = System.currentTimeMillis() - startTime;
        func.release();
        return elpasedTime;
    }

    @JavascriptInterface
    public long invokeAddJavascriptInterface(long count) {
        long elpasedTime = 0;
        if (count > 0) {
            long startTime = System.currentTimeMillis();
            for (long i2 = 0; i2 < count; i2++) {
                this.mEngine.addJavascriptInterface(new JavaObject((int) i2), "jsi_" + i2);
            }
            elpasedTime = System.currentTimeMillis() - startTime;
            for (long i3 = 0; i3 < count; i3++) {
                this.mEngine.removeJavascriptInterface("jsi_" + i3);
            }
        }
        return elpasedTime;
    }

    @JavascriptInterface
    public long invokeRemoveJavascriptInterface(long totalCount) {
        if (totalCount <= 0) {
            return 0;
        }
        for (long i2 = 0; i2 < totalCount; i2++) {
            this.mEngine.addJavascriptInterface(new JavaObject((int) i2), "jsi_" + i2);
        }
        long startTime = System.currentTimeMillis();
        for (long i3 = 0; i3 < totalCount; i3++) {
            this.mEngine.removeJavascriptInterface("jsi_" + i3);
        }
        return System.currentTimeMillis() - startTime;
    }
}
