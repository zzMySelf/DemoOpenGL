package com.google.common.html;

import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import kotlin.text.Typography;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

@GwtCompatible
public final class HtmlEscapers {
    public static final Escaper HTML_ESCAPER = Escapers.builder().addEscape('\"', "&quot;").addEscape(ExtendedMessageFormat.QUOTE, "&#39;").addEscape(Typography.amp, "&amp;").addEscape(Typography.less, "&lt;").addEscape(Typography.greater, "&gt;").build();

    public static Escaper htmlEscaper() {
        return HTML_ESCAPER;
    }
}
