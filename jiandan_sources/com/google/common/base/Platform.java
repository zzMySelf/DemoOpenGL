package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible(emulated = true)
public final class Platform {
    public static final String GWT_RPC_PROPERTY_NAME = "guava.gwt.emergency_reenable_rpc";
    public static final Logger logger = Logger.getLogger(Platform.class.getName());
    public static final PatternCompiler patternCompiler = loadPatternCompiler();

    public static final class JdkPatternCompiler implements PatternCompiler {
        public JdkPatternCompiler() {
        }

        public CommonPattern compile(String str) {
            return new JdkPattern(Pattern.compile(str));
        }

        public boolean isPcreLike() {
            return true;
        }
    }

    public static void checkGwtRpcEnabled() {
        if (!Boolean.parseBoolean(System.getProperty("guava.gwt.emergency_reenable_rpc", "true"))) {
            throw new UnsupportedOperationException(Strings.lenientFormat("We are removing GWT-RPC support for Guava types. You can temporarily reenable support by setting the system property %s to true. For more about system properties, see %s. For more about Guava's GWT-RPC support, see %s.", "guava.gwt.emergency_reenable_rpc", "https://stackoverflow.com/q/5189914/28465", "https://groups.google.com/d/msg/guava-announce/zHZTFg7YF3o/rQNnwdHeEwAJ"));
        }
    }

    public static CommonPattern compilePattern(String str) {
        Preconditions.checkNotNull(str);
        return patternCompiler.compile(str);
    }

    public static String emptyToNull(@NullableDecl String str) {
        if (stringIsNullOrEmpty(str)) {
            return null;
        }
        return str;
    }

    public static String formatCompact4Digits(double d) {
        return String.format(Locale.ROOT, "%.4g", new Object[]{Double.valueOf(d)});
    }

    public static <T extends Enum<T>> Optional<T> getEnumIfPresent(Class<T> cls, String str) {
        WeakReference weakReference = Enums.getEnumConstants(cls).get(str);
        return weakReference == null ? Optional.absent() : Optional.of(cls.cast(weakReference.get()));
    }

    public static PatternCompiler loadPatternCompiler() {
        return new JdkPatternCompiler();
    }

    public static void logPatternCompilerError(ServiceConfigurationError serviceConfigurationError) {
        logger.log(Level.WARNING, "Error loading regex compiler, falling back to next option", serviceConfigurationError);
    }

    public static String nullToEmpty(@NullableDecl String str) {
        return str == null ? "" : str;
    }

    public static boolean patternCompilerIsPcreLike() {
        return patternCompiler.isPcreLike();
    }

    public static CharMatcher precomputeCharMatcher(CharMatcher charMatcher) {
        return charMatcher.precomputedInternal();
    }

    public static boolean stringIsNullOrEmpty(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }

    public static long systemNanoTime() {
        return System.nanoTime();
    }
}
