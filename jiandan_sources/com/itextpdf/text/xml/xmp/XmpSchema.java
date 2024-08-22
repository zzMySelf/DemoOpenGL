package com.itextpdf.text.xml.xmp;

import fe.when.ad.g.qw;
import java.util.Enumeration;
import java.util.Properties;
import kotlin.text.Typography;

@Deprecated
public abstract class XmpSchema extends Properties {
    public static final long serialVersionUID = -176374295948945272L;
    public String xmlns;

    public XmpSchema(String str) {
        this.xmlns = str;
    }

    public static String escape(String str) {
        return qw.qw(str, false);
    }

    public Object addProperty(String str, String str2) {
        return setProperty(str, str2);
    }

    public String getXmlns() {
        return this.xmlns;
    }

    public void process(StringBuffer stringBuffer, Object obj) {
        stringBuffer.append(Typography.less);
        stringBuffer.append(obj);
        stringBuffer.append(Typography.greater);
        stringBuffer.append(get(obj));
        stringBuffer.append("</");
        stringBuffer.append(obj);
        stringBuffer.append(Typography.greater);
    }

    public Object setProperty(String str, String str2) {
        return super.setProperty(str, qw.qw(str2, false));
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration<?> propertyNames = propertyNames();
        while (propertyNames.hasMoreElements()) {
            process(stringBuffer, propertyNames.nextElement());
        }
        return stringBuffer.toString();
    }

    public Object setProperty(String str, XmpArray xmpArray) {
        return super.setProperty(str, xmpArray.toString());
    }

    public Object setProperty(String str, LangAlt langAlt) {
        return super.setProperty(str, langAlt.toString());
    }
}
