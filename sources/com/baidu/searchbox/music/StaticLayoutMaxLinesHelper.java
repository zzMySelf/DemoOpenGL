package com.baidu.searchbox.music;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.feed.tts.core.TTSRuntime;
import java.lang.reflect.Constructor;

public class StaticLayoutMaxLinesHelper {
    private static final boolean DEBUG = TTSRuntime.DEBUG;
    private static final String TAG = "StaticLayoutMaxLines";
    private static final String TEXT_DIRS_CLASS_NAME = "android.text.TextDirectionHeuristics";
    private static final String TEXT_DIRS_FIELD_NAME_FIRSTSTRONG_LTR = "FIRSTSTRONG_LTR";
    private static final String TEXT_DIR_CLASS_NAME = "android.text.TextDirectionHeuristic";
    private static Constructor<StaticLayout> sConstructor;
    private static Object[] sConstructorArgs;
    private static boolean sInitialized;
    private static Object sTextDir;

    private static synchronized void ensureInitialized() {
        Class cls;
        Class<StaticLayoutMaxLinesHelper> cls2 = StaticLayoutMaxLinesHelper.class;
        synchronized (cls2) {
            if (!sInitialized) {
                try {
                    if (Build.VERSION.SDK_INT >= 18) {
                        cls = TextDirectionHeuristic.class;
                        sTextDir = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                    } else {
                        ClassLoader loader = cls2.getClassLoader();
                        Class<?> textDirClass = loader.loadClass(TEXT_DIR_CLASS_NAME);
                        Class<?> textDirsClass = loader.loadClass(TEXT_DIRS_CLASS_NAME);
                        sTextDir = textDirsClass.getField(TEXT_DIRS_FIELD_NAME_FIRSTSTRONG_LTR).get(textDirsClass);
                        cls = textDirClass;
                    }
                    Class[] clsArr = {CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, cls, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE};
                    Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(clsArr);
                    sConstructor = declaredConstructor;
                    declaredConstructor.setAccessible(true);
                    sConstructorArgs = new Object[clsArr.length];
                    sInitialized = true;
                } catch (NoSuchMethodException e2) {
                    if (DEBUG) {
                        Log.e(TAG, "StaticLayout constructor with max lines not found.", e2);
                    }
                    sInitialized = true;
                } catch (ClassNotFoundException e3) {
                    if (DEBUG) {
                        Log.e(TAG, "TextDirectionHeuristic class not found.", e3);
                    }
                    sInitialized = true;
                } catch (NoSuchFieldException e4) {
                    if (DEBUG) {
                        Log.e(TAG, "TextDirectionHeuristics.FIRSTSTRONG_LTR not found.", e4);
                    }
                    sInitialized = true;
                } catch (IllegalAccessException e5) {
                    try {
                        if (DEBUG) {
                            Log.e(TAG, "TextDirectionHeuristics.FIRSTSTRONG_LTR not accessible.", e5);
                        }
                        sInitialized = true;
                    } catch (Throwable th2) {
                        sInitialized = true;
                        throw th2;
                    }
                }
            }
        }
    }

    public static synchronized StaticLayout create(CharSequence source, int bufstart, int bufend, TextPaint paint, int outerWidth, Layout.Alignment align, float spacingMult, float spacingAdd, boolean includePad, TextUtils.TruncateAt ellipsize, int ellipsisWidth, int maxLines) {
        StaticLayout newInstance;
        synchronized (StaticLayoutMaxLinesHelper.class) {
            ensureInitialized();
            try {
                Object[] objArr = sConstructorArgs;
                objArr[0] = source;
                objArr[1] = Integer.valueOf(bufstart);
                sConstructorArgs[2] = Integer.valueOf(bufend);
                Object[] objArr2 = sConstructorArgs;
                objArr2[3] = paint;
                objArr2[4] = Integer.valueOf(outerWidth);
                Object[] objArr3 = sConstructorArgs;
                objArr3[5] = align;
                objArr3[6] = sTextDir;
                objArr3[7] = Float.valueOf(spacingMult);
                sConstructorArgs[8] = Float.valueOf(spacingAdd);
                sConstructorArgs[9] = Boolean.valueOf(includePad);
                Object[] objArr4 = sConstructorArgs;
                objArr4[10] = ellipsize;
                objArr4[11] = Integer.valueOf(ellipsisWidth);
                sConstructorArgs[12] = Integer.valueOf(maxLines);
                newInstance = sConstructor.newInstance(sConstructorArgs);
            } catch (Exception e2) {
                if (DEBUG) {
                    Log.e(TAG, "Error creating StaticLayout with max lines: " + e2);
                }
                return new StaticLayout(source, bufstart, bufend, paint, outerWidth, align, spacingMult, spacingAdd, includePad, ellipsize, ellipsisWidth);
            }
        }
        return newInstance;
    }
}
