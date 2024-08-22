package com.yy.open.deviceidentifiertest;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class LoadLibraryUtils {
    public static boolean loadLibrary(Context context, String libName) {
        try {
            System.loadLibrary(libName);
            return true;
        } catch (UnsatisfiedLinkError e2) {
            return load(context, libName, context.getClassLoader());
        }
    }

    public static boolean load(Context context, String libName, ClassLoader classLoader) {
        File nativePathFile = new File(context.getApplicationInfo().nativeLibraryDir);
        String libPath = null;
        if ("armeabi-v7a".equals(Build.CPU_ABI)) {
            File libFilev7a = new File(nativePathFile, "lib" + libName + "-v7a.so");
            if (libFilev7a.exists()) {
                File libFileRecover = new File(context.getDir("lib_v7a", 0), "lib" + libName + ".so");
                if (!libFileRecover.exists() || libFilev7a.length() != libFileRecover.length()) {
                    copy(libFilev7a, libFileRecover);
                }
                if (libFileRecover.exists() && libFileRecover.length() == libFilev7a.length()) {
                    libPath = libFileRecover.getAbsolutePath();
                }
            }
        }
        if (libPath == null) {
            File libFile = new File(nativePathFile, "lib" + libName + ".so");
            if (libFile.exists()) {
                libPath = libFile.getAbsolutePath();
            }
        }
        if ((libPath != null && load(libPath, classLoader)) || loadLibrary(libName, classLoader)) {
            return true;
        }
        ZipFile apkZipFile = null;
        try {
            File libFile2 = new File(context.getDir("lib_ext", 0), "lib" + libName + ".so");
            ZipFile apkZipFile2 = new ZipFile(new File(context.getApplicationInfo().sourceDir));
            if (!copy(apkZipFile2, libName, libFile2) || libFile2.length() <= 0 || !load(libFile2.getAbsolutePath(), classLoader)) {
                apkZipFile2.close();
                return false;
            }
            try {
                apkZipFile2.close();
            } catch (Throwable th2) {
            }
            return true;
        } catch (Throwable th3) {
        }
    }

    private static boolean load(String libPath, ClassLoader classLoader) {
        try {
            Runtime rt = Runtime.getRuntime();
            Method method = rt.getClass().getDeclaredMethod("load", new Class[]{String.class, ClassLoader.class});
            method.setAccessible(true);
            method.invoke(rt, new Object[]{libPath, classLoader});
            return true;
        } catch (InvocationTargetException e2) {
            return false;
        } catch (Throwable th2) {
            return false;
        }
    }

    private static boolean loadLibrary(String libName, ClassLoader classLoader) {
        try {
            Runtime rt = Runtime.getRuntime();
            Method method = rt.getClass().getDeclaredMethod("loadLibrary", new Class[]{String.class, ClassLoader.class});
            method.setAccessible(true);
            method.invoke(rt, new Object[]{libName, classLoader});
            return true;
        } catch (InvocationTargetException e2) {
            return false;
        } catch (Throwable th2) {
            return false;
        }
    }

    private static void copy(File oldfile, File newFile) {
        InputStream is = null;
        FileOutputStream os = null;
        try {
            if (newFile.exists()) {
                newFile.delete();
            }
            if (oldfile.exists()) {
                byte[] buffer = new byte[2048];
                is = new FileInputStream(oldfile);
                os = new FileOutputStream(newFile);
                while (true) {
                    int read = is.read(buffer);
                    int byteread = read;
                    if (read == -1) {
                        break;
                    }
                    os.write(buffer, 0, byteread);
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e2) {
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e3) {
                }
            }
        } catch (Exception e4) {
            newFile.delete();
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e5) {
                }
            }
            if (os != null) {
                os.close();
            }
        } catch (Throwable th2) {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e6) {
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e7) {
                }
            }
            throw th2;
        }
    }

    private static boolean copy(ZipFile apkZipFile, String libName, File saveFile) {
        ZipEntry libEntry = null;
        if ("armeabi-v7a".equals(Build.CPU_ABI) && (libEntry = apkZipFile.getEntry("lib/armeabi-v7a/lib" + libName + ".so")) == null) {
            libEntry = apkZipFile.getEntry("lib/armeabi/lib" + libName + "-v7a.so");
        }
        if (libEntry == null) {
            libEntry = apkZipFile.getEntry("lib/armeabi/lib" + libName + ".so");
        }
        if (libEntry == null) {
            return false;
        }
        if (libEntry.getSize() == saveFile.length()) {
            return true;
        }
        if (saveFile.exists()) {
            saveFile.delete();
        }
        InputStream is = null;
        FileOutputStream os = null;
        try {
            InputStream is2 = apkZipFile.getInputStream(libEntry);
            FileOutputStream os2 = new FileOutputStream(saveFile);
            byte[] buffer = new byte[2048];
            while (true) {
                int read = is2.read(buffer);
                int byteread = read;
                if (read == -1) {
                    break;
                }
                os2.write(buffer, 0, byteread);
            }
            if (is2 != null) {
                try {
                    is2.close();
                } catch (Exception e2) {
                }
            }
            try {
                os2.close();
            } catch (Exception e3) {
            }
            return true;
        } catch (Throwable th2) {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e4) {
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e5) {
                }
            }
            return false;
        }
    }
}
