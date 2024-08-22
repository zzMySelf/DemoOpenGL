package com.itextpdf.text.pdf.hyphenation;

import com.baidu.android.common.others.lang.StringUtil;
import java.io.Serializable;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class Hyphen implements Serializable {
    public static final long serialVersionUID = -7666138517324763063L;
    public String noBreak;
    public String postBreak;
    public String preBreak;

    public Hyphen(String str, String str2, String str3) {
        this.preBreak = str;
        this.noBreak = str2;
        this.postBreak = str3;
    }

    public String toString() {
        String str;
        if (this.noBreak == null && this.postBreak == null && (str = this.preBreak) != null && str.equals("-")) {
            return "-";
        }
        StringBuffer stringBuffer = new StringBuffer(StringUtil.ARRAY_START);
        stringBuffer.append(this.preBreak);
        stringBuffer.append("}{");
        stringBuffer.append(this.postBreak);
        stringBuffer.append("}{");
        stringBuffer.append(this.noBreak);
        stringBuffer.append(ExtendedMessageFormat.END_FE);
        return stringBuffer.toString();
    }

    public Hyphen(String str) {
        this.preBreak = str;
        this.noBreak = null;
        this.postBreak = null;
    }
}
