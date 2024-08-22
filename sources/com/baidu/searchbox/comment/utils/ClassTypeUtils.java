package com.baidu.searchbox.comment.utils;

import android.util.Log;
import com.baidu.chatsearch.aisearch.resultpage.toolbar.discovery.span.RhetoricalTagUtilKt;
import com.baidu.searchbox.comment.BaseHolder;
import com.baidu.searchbox.comment.definition.ICommentView;
import com.baidu.searchbox.config.AppConfig;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ClassTypeUtils {
    public static final int ARGUTYPE_DATA_TYPE = 0;
    private static final boolean DEBUG = AppConfig.isDebug();
    private static final Class HOLDER_CLASS = BaseHolder.class;
    private static String TAG = "ClassTypeUtils";
    private static final boolean THROW_EXCEPTION = true;
    private static final Class VIEW_CLASS = ICommentView.class;

    public static boolean isEqual(Object baseObj, boolean baseObjIsView, int baseObjArguType, Class<?> targetObjClass) {
        return isEqual(getActualTypeArguments(baseObj, baseObjIsView, baseObjArguType), targetObjClass);
    }

    public static boolean isEqual(Class<?> baseObjArguClass, Class<?> targetObjClass) {
        if (baseObjArguClass == null || targetObjClass == null) {
            if (DEBUG) {
                Log.e(TAG, "not equal, one of params is null, stack:" + Log.getStackTraceString(new Exception()));
            }
            return false;
        } else if (DEBUG && baseObjArguClass != targetObjClass) {
            Log.e(TAG, "not equal, [" + baseObjArguClass + "] and [" + targetObjClass + "], stack:" + Log.getStackTraceString(new Exception()));
            throw new IllegalStateException("not equal, [" + baseObjArguClass + "] and [" + targetObjClass + RhetoricalTagUtilKt.TAG_END_SYMBOL);
        } else if (baseObjArguClass == targetObjClass) {
            return true;
        } else {
            return false;
        }
    }

    public static Class<?> getActualTypeArguments(Object obj, boolean searchView, int arguType) {
        if (obj == null) {
            return null;
        }
        Class clazz = obj.getClass();
        Type[] typeArr = null;
        if (searchView) {
            Class clazzTmp = clazz;
            boolean hasTarget = false;
            while (clazzTmp != Object.class) {
                Type[] interTypeArr = clazzTmp.getGenericInterfaces();
                if (interTypeArr == null || interTypeArr.length <= 0) {
                    clazzTmp = clazzTmp.getSuperclass();
                } else {
                    int length = interTypeArr.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        Type interType = interTypeArr[i2];
                        if (interType instanceof ParameterizedType) {
                            ParameterizedType type = (ParameterizedType) interType;
                            if (type.getRawType() == VIEW_CLASS) {
                                typeArr = type.getActualTypeArguments();
                                if (typeArr == null || typeArr.length <= arguType) {
                                    typeArr = null;
                                }
                                hasTarget = true;
                            }
                        }
                        i2++;
                    }
                    if (hasTarget) {
                        break;
                    }
                    clazzTmp = clazzTmp.getSuperclass();
                }
            }
            if (clazzTmp == Object.class) {
                typeArr = null;
            }
        } else {
            Class clazzTmp2 = clazz;
            while (clazzTmp2 != Object.class && clazzTmp2.getSuperclass() != HOLDER_CLASS) {
                clazzTmp2 = clazzTmp2.getSuperclass();
            }
            if (clazzTmp2 != Object.class) {
                typeArr = ((ParameterizedType) clazzTmp2.getGenericSuperclass()).getActualTypeArguments();
                if (typeArr == null || typeArr.length <= arguType) {
                    typeArr = null;
                }
            } else {
                typeArr = null;
            }
        }
        if (typeArr != null && (typeArr[arguType] instanceof Class)) {
            return (Class) typeArr[arguType];
        }
        return null;
    }
}
