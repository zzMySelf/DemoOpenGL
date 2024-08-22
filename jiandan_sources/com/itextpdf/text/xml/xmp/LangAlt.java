package com.itextpdf.text.xml.xmp;

import fe.when.ad.g.qw;
import java.util.Enumeration;
import java.util.Properties;

@Deprecated
public class LangAlt extends Properties {
    public static final String DEFAULT = "x-default";
    public static final long serialVersionUID = 4396971487200843099L;

    public LangAlt(String str) {
        addLanguage(DEFAULT, str);
    }

    public void addLanguage(String str, String str2) {
        setProperty(str, qw.qw(str2, false));
    }

    public void process(StringBuffer stringBuffer, Object obj) {
        stringBuffer.append("<rdf:li xml:lang=\"");
        stringBuffer.append(obj);
        stringBuffer.append("\" >");
        stringBuffer.append(get(obj));
        stringBuffer.append("</rdf:li>");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<rdf:Alt>");
        Enumeration<?> propertyNames = propertyNames();
        while (propertyNames.hasMoreElements()) {
            process(stringBuffer, propertyNames.nextElement());
        }
        stringBuffer.append("</rdf:Alt>");
        return stringBuffer.toString();
    }

    public LangAlt() {
    }
}
