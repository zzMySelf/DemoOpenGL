package org.intellij.lang.annotations;

public class PrintFormatPattern {
    @Language("RegExp")
    public static final String ARG_INDEX = "(?:\\d+\\$)?";
    @Language("RegExp")
    public static final String CONVERSION = "(?:[tT])?(?:[a-zA-Z%])";
    @Language("RegExp")
    public static final String FLAGS = "(?:[-#+ 0,(<]*)?";
    @Language("RegExp")
    public static final String PRECISION = "(?:\\.\\d+)?";
    @Language("RegExp")
    public static final String PRINT_FORMAT = "(?:[^%]|%%|(?:%(?:\\d+\\$)?(?:[-#+ 0,(<]*)?(?:\\d+)?(?:\\.\\d+)?(?:[tT])?(?:[a-zA-Z%])))*";
    @Language("RegExp")
    public static final String TEXT = "[^%]|%%";
    @Language("RegExp")
    public static final String WIDTH = "(?:\\d+)?";
}
