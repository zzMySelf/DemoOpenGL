package com.baidu.nps.runtime.fix;

import android.content.Context;
import com.baidu.nps.runtime.classloader.NPSClassloader;
import com.baidu.nps.utils.ReflectUtils;
import com.baidu.swan.apps.statistic.SwanAppPageFlowEventRecorder;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassLoaderAndroidS {
    public static NPSClassloader createClassLoader(String dexPath, String optimizedDirectory, String libraryPath, Context context) {
        NPSClassloader tmp = new NPSClassloader(dexPath, optimizedDirectory, libraryPath, context);
        try {
            NPSClassloader main = new NPSClassloader("", "", libraryPath, context);
            shareClassLoaderL(main, tmp);
            return main;
        } catch (Throwable e2) {
            e2.printStackTrace();
            return tmp;
        }
    }

    private static ClassLoader shareClassLoaderL(NPSClassloader mainClassLoader, NPSClassloader subClassLoader) throws IllegalAccessException {
        Field pathList = ReflectUtils.getField(NPSClassloader.class, SwanAppPageFlowEventRecorder.KEY_PATH_LIST);
        Object mainPathListVal = pathList.get(mainClassLoader);
        Field dexElements = ReflectUtils.getField(mainPathListVal.getClass(), "dexElements");
        Field nativeLibDirs = ReflectUtils.getField(mainPathListVal.getClass(), "nativeLibraryDirectories");
        Object[] mainDexElementsVal = (Object[]) dexElements.get(mainPathListVal);
        List<File> mainNativeLibDirsVal = (List) nativeLibDirs.get(mainPathListVal);
        Object subPathListVal = pathList.get(subClassLoader);
        dexElements.set(mainPathListVal, concatElements(mainDexElementsVal.getClass().getComponentType(), mainDexElementsVal, (Object[]) dexElements.get(subPathListVal)));
        mainNativeLibDirsVal.addAll((List) nativeLibDirs.get(subPathListVal));
        nativeLibDirs.set(mainPathListVal, mainNativeLibDirsVal);
        mergeNativeLibraryM(mainPathListVal, subPathListVal);
        return mainClassLoader;
    }

    private static void mergeNativeLibraryM(Object mainPathListVal, Object subPathListVal) throws IllegalAccessException {
        Field nativeLibPath = ReflectUtils.getField(mainPathListVal.getClass(), "nativeLibraryPathElements");
        nativeLibPath.set(mainPathListVal, deduplicateExpandFieldArray((Object[]) nativeLibPath.get(mainPathListVal), (Object[]) nativeLibPath.get(subPathListVal)));
    }

    private static Object[] deduplicateExpandFieldArray(Object[] original, Object[] extraElements) throws IllegalArgumentException {
        List mergedList = new ArrayList(Arrays.asList(original));
        for (Object item : extraElements) {
            if (!mergedList.contains(item)) {
                mergedList.add(item);
            }
        }
        Object[] combined = (Object[]) Array.newInstance(original.getClass().getComponentType(), mergedList.size());
        for (int index = 0; index < combined.length; index++) {
            combined[index] = mergedList.get(index);
        }
        return combined;
    }

    private static <T> T[] concatElements(Class<T> componentType, Object[] inputA, Object[] inputB) {
        T[] output = (Object[]) Array.newInstance(componentType, inputA.length + inputB.length);
        System.arraycopy(inputA, 0, output, 0, inputA.length);
        System.arraycopy(inputB, 0, output, inputA.length, inputB.length);
        return output;
    }
}
