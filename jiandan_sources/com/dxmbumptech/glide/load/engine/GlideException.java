package com.dxmbumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.dxmbumptech.glide.load.DataSource;
import com.dxmbumptech.glide.load.Key;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GlideException extends Exception {
    public static final StackTraceElement[] EMPTY_ELEMENTS = new StackTraceElement[0];
    public static final long serialVersionUID = 1;
    public final List<Throwable> causes;
    public Class<?> dataClass;
    public DataSource dataSource;
    public String detailMessage;
    @Nullable
    public Exception exception;
    public Key key;

    public GlideException(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    private void addRootCauses(Throwable th2, List<Throwable> list) {
        if (th2 instanceof GlideException) {
            for (Throwable addRootCauses : ((GlideException) th2).getCauses()) {
                addRootCauses(addRootCauses, list);
            }
            return;
        }
        list.add(th2);
    }

    public static void appendCauses(List<Throwable> list, Appendable appendable) {
        try {
            appendCausesWrapped(list, appendable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void appendCausesWrapped(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            appendable.append("Cause (").append(String.valueOf(i3)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th2 = list.get(i2);
            if (th2 instanceof GlideException) {
                ((GlideException) th2).printStackTrace(appendable);
            } else {
                appendExceptionMessage(th2, appendable);
            }
            i2 = i3;
        }
    }

    public static void appendExceptionMessage(Throwable th2, Appendable appendable) {
        try {
            appendable.append(th2.getClass().toString()).append(": ").append(th2.getMessage()).append(10);
        } catch (IOException unused) {
            throw new RuntimeException(th2);
        }
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public List<Throwable> getCauses() {
        return this.causes;
    }

    public String getMessage() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.detailMessage);
        String str3 = "";
        if (this.dataClass != null) {
            str = StringUtil.ARRAY_ELEMENT_SEPARATOR + this.dataClass;
        } else {
            str = str3;
        }
        sb.append(str);
        if (this.dataSource != null) {
            str2 = StringUtil.ARRAY_ELEMENT_SEPARATOR + this.dataSource;
        } else {
            str2 = str3;
        }
        sb.append(str2);
        if (this.key != null) {
            str3 = StringUtil.ARRAY_ELEMENT_SEPARATOR + this.key;
        }
        sb.append(str3);
        List<Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return sb.toString();
        }
        if (rootCauses.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(rootCauses.size());
            sb.append(" root causes:");
        }
        for (Throwable next : rootCauses) {
            sb.append(10);
            sb.append(next.getClass().getName());
            sb.append('(');
            sb.append(next.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Nullable
    public Exception getOrigin() {
        return this.exception;
    }

    public List<Throwable> getRootCauses() {
        ArrayList arrayList = new ArrayList();
        addRootCauses(this, arrayList);
        return arrayList;
    }

    public void logRootCauses(String str) {
        List<Throwable> rootCauses = getRootCauses();
        int size = rootCauses.size();
        int i2 = 0;
        while (i2 < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i3 = i2 + 1;
            sb.append(i3);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            sb.toString();
            Throwable th2 = rootCauses.get(i2);
            i2 = i3;
        }
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void setLoggingDetails(Key key2, DataSource dataSource2) {
        setLoggingDetails(key2, dataSource2, (Class<?>) null);
    }

    public void setOrigin(@Nullable Exception exc) {
        this.exception = exc;
    }

    public GlideException(String str, Throwable th2) {
        this(str, (List<Throwable>) Collections.singletonList(th2));
    }

    public void printStackTrace(PrintStream printStream) {
        printStackTrace((Appendable) printStream);
    }

    public void setLoggingDetails(Key key2, DataSource dataSource2, Class<?> cls) {
        this.key = key2;
        this.dataSource = dataSource2;
        this.dataClass = cls;
    }

    public GlideException(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = list;
    }

    public void printStackTrace(PrintWriter printWriter) {
        printStackTrace((Appendable) printWriter);
    }

    private void printStackTrace(Appendable appendable) {
        appendExceptionMessage(this, appendable);
        appendCauses(getCauses(), new qw(appendable));
    }

    public static final class qw implements Appendable {

        /* renamed from: ad  reason: collision with root package name */
        public final Appendable f3851ad;

        /* renamed from: th  reason: collision with root package name */
        public boolean f3852th = true;

        public qw(Appendable appendable) {
            this.f3851ad = appendable;
        }

        public Appendable append(char c) throws IOException {
            boolean z = false;
            if (this.f3852th) {
                this.f3852th = false;
                this.f3851ad.append("  ");
            }
            if (c == 10) {
                z = true;
            }
            this.f3852th = z;
            this.f3851ad.append(c);
            return this;
        }

        @NonNull
        public final CharSequence qw(@Nullable CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        public Appendable append(@Nullable CharSequence charSequence) throws IOException {
            CharSequence qw = qw(charSequence);
            append(qw, 0, qw.length());
            return this;
        }

        public Appendable append(@Nullable CharSequence charSequence, int i2, int i3) throws IOException {
            CharSequence qw = qw(charSequence);
            boolean z = false;
            if (this.f3852th) {
                this.f3852th = false;
                this.f3851ad.append("  ");
            }
            if (qw.length() > 0 && qw.charAt(i3 - 1) == 10) {
                z = true;
            }
            this.f3852th = z;
            this.f3851ad.append(qw, i2, i3);
            return this;
        }
    }
}
