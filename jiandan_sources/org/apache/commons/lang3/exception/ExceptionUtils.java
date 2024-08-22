package org.apache.commons.lang3.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

public class ExceptionUtils {
    public static final String[] CAUSE_METHOD_NAMES = {"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};
    public static final String WRAPPED_MARKER = " [wrapped] ";

    @Deprecated
    public static Throwable getCause(Throwable th2) {
        return getCause(th2, (String[]) null);
    }

    public static Throwable getCauseUsingMethodName(Throwable th2, String str) {
        Method method;
        try {
            method = th2.getClass().getMethod(str, new Class[0]);
        } catch (NoSuchMethodException | SecurityException unused) {
            method = null;
        }
        if (method != null && Throwable.class.isAssignableFrom(method.getReturnType())) {
            try {
                return (Throwable) method.invoke(th2, new Object[0]);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
            }
        }
        return null;
    }

    @Deprecated
    public static String[] getDefaultCauseMethodNames() {
        return (String[]) ArrayUtils.clone((T[]) CAUSE_METHOD_NAMES);
    }

    public static String getMessage(Throwable th2) {
        if (th2 == null) {
            return "";
        }
        String shortClassName = ClassUtils.getShortClassName(th2, (String) null);
        String message = th2.getMessage();
        return shortClassName + ": " + StringUtils.defaultString(message);
    }

    public static Throwable getRootCause(Throwable th2) {
        List<Throwable> throwableList = getThrowableList(th2);
        if (throwableList.size() < 2) {
            return null;
        }
        return throwableList.get(throwableList.size() - 1);
    }

    public static String getRootCauseMessage(Throwable th2) {
        Throwable rootCause = getRootCause(th2);
        if (rootCause != null) {
            th2 = rootCause;
        }
        return getMessage(th2);
    }

    public static String[] getRootCauseStackTrace(Throwable th2) {
        List<String> list;
        if (th2 == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        Throwable[] throwables = getThrowables(th2);
        int length = throwables.length;
        ArrayList arrayList = new ArrayList();
        int i2 = length - 1;
        List<String> stackFrameList = getStackFrameList(throwables[i2]);
        while (true) {
            length--;
            if (length < 0) {
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            if (length != 0) {
                list = getStackFrameList(throwables[length - 1]);
                removeCommonFrames(stackFrameList, list);
            } else {
                list = stackFrameList;
            }
            if (length == i2) {
                arrayList.add(throwables[length].toString());
            } else {
                arrayList.add(WRAPPED_MARKER + throwables[length].toString());
            }
            for (int i3 = 0; i3 < stackFrameList.size(); i3++) {
                arrayList.add(stackFrameList.get(i3));
            }
            stackFrameList = list;
        }
    }

    public static List<String> getStackFrameList(Throwable th2) {
        StringTokenizer stringTokenizer = new StringTokenizer(getStackTrace(th2), SystemUtils.LINE_SEPARATOR);
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf("at");
            if (indexOf != -1 && nextToken.substring(0, indexOf).trim().isEmpty()) {
                z = true;
                arrayList.add(nextToken);
            } else if (z) {
                break;
            }
        }
        return arrayList;
    }

    public static String[] getStackFrames(Throwable th2) {
        if (th2 == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        return getStackFrames(getStackTrace(th2));
    }

    public static String getStackTrace(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter, true));
        return stringWriter.getBuffer().toString();
    }

    public static int getThrowableCount(Throwable th2) {
        return getThrowableList(th2).size();
    }

    public static List<Throwable> getThrowableList(Throwable th2) {
        ArrayList arrayList = new ArrayList();
        while (th2 != null && !arrayList.contains(th2)) {
            arrayList.add(th2);
            th2 = getCause(th2);
        }
        return arrayList;
    }

    public static Throwable[] getThrowables(Throwable th2) {
        List<Throwable> throwableList = getThrowableList(th2);
        return (Throwable[]) throwableList.toArray(new Throwable[throwableList.size()]);
    }

    public static boolean hasCause(Throwable th2, Class<? extends Throwable> cls) {
        if (th2 instanceof UndeclaredThrowableException) {
            th2 = th2.getCause();
        }
        return cls.isInstance(th2);
    }

    public static int indexOf(Throwable th2, Class<?> cls, int i2, boolean z) {
        if (!(th2 == null || cls == null)) {
            if (i2 < 0) {
                i2 = 0;
            }
            Throwable[] throwables = getThrowables(th2);
            if (i2 >= throwables.length) {
                return -1;
            }
            if (z) {
                while (i2 < throwables.length) {
                    if (cls.isAssignableFrom(throwables[i2].getClass())) {
                        return i2;
                    }
                    i2++;
                }
            } else {
                while (i2 < throwables.length) {
                    if (cls.equals(throwables[i2].getClass())) {
                        return i2;
                    }
                    i2++;
                }
            }
        }
        return -1;
    }

    public static int indexOfThrowable(Throwable th2, Class<?> cls) {
        return indexOf(th2, cls, 0, false);
    }

    public static int indexOfType(Throwable th2, Class<?> cls) {
        return indexOf(th2, cls, 0, true);
    }

    public static void printRootCauseStackTrace(Throwable th2) {
        printRootCauseStackTrace(th2, System.err);
    }

    public static void removeCommonFrames(List<String> list, List<String> list2) {
        if (list == null || list2 == null) {
            throw new IllegalArgumentException("The List must not be null");
        }
        int size = list.size() - 1;
        int size2 = list2.size() - 1;
        while (size >= 0 && size2 >= 0) {
            if (list.get(size).equals(list2.get(size2))) {
                list.remove(size);
            }
            size--;
            size2--;
        }
    }

    public static <R> R rethrow(Throwable th2) {
        return typeErasure(th2);
    }

    public static <R, T extends Throwable> R typeErasure(Throwable th2) throws Throwable {
        throw th2;
    }

    public static <R> R wrapAndThrow(Throwable th2) {
        if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        } else if (th2 instanceof Error) {
            throw ((Error) th2);
        } else {
            throw new UndeclaredThrowableException(th2);
        }
    }

    @Deprecated
    public static Throwable getCause(Throwable th2, String[] strArr) {
        Throwable causeUsingMethodName;
        if (th2 == null) {
            return null;
        }
        if (strArr == null) {
            Throwable cause = th2.getCause();
            if (cause != null) {
                return cause;
            }
            strArr = CAUSE_METHOD_NAMES;
        }
        for (String str : strArr) {
            if (str != null && (causeUsingMethodName = getCauseUsingMethodName(th2, str)) != null) {
                return causeUsingMethodName;
            }
        }
        return null;
    }

    public static int indexOfThrowable(Throwable th2, Class<?> cls, int i2) {
        return indexOf(th2, cls, i2, false);
    }

    public static int indexOfType(Throwable th2, Class<?> cls, int i2) {
        return indexOf(th2, cls, i2, true);
    }

    public static void printRootCauseStackTrace(Throwable th2, PrintStream printStream) {
        if (th2 != null) {
            if (printStream != null) {
                for (String println : getRootCauseStackTrace(th2)) {
                    printStream.println(println);
                }
                printStream.flush();
                return;
            }
            throw new IllegalArgumentException("The PrintStream must not be null");
        }
    }

    public static String[] getStackFrames(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, SystemUtils.LINE_SEPARATOR);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static void printRootCauseStackTrace(Throwable th2, PrintWriter printWriter) {
        if (th2 != null) {
            if (printWriter != null) {
                for (String println : getRootCauseStackTrace(th2)) {
                    printWriter.println(println);
                }
                printWriter.flush();
                return;
            }
            throw new IllegalArgumentException("The PrintWriter must not be null");
        }
    }
}
