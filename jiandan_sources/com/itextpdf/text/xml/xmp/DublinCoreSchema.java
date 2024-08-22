package com.itextpdf.text.xml.xmp;

import com.baidu.android.util.io.DocumentOpenUtil;

@Deprecated
public class DublinCoreSchema extends XmpSchema {
    public static final String CONTRIBUTOR = "dc:contributor";
    public static final String COVERAGE = "dc:coverage";
    public static final String CREATOR = "dc:creator";
    public static final String DATE = "dc:date";
    public static final String DEFAULT_XPATH_ID = "dc";
    public static final String DEFAULT_XPATH_URI = "http://purl.org/dc/elements/1.1/";
    public static final String DESCRIPTION = "dc:description";
    public static final String FORMAT = "dc:format";
    public static final String IDENTIFIER = "dc:identifier";
    public static final String LANGUAGE = "dc:language";
    public static final String PUBLISHER = "dc:publisher";
    public static final String RELATION = "dc:relation";
    public static final String RIGHTS = "dc:rights";
    public static final String SOURCE = "dc:source";
    public static final String SUBJECT = "dc:subject";
    public static final String TITLE = "dc:title";
    public static final String TYPE = "dc:type";
    public static final long serialVersionUID = -4551741356374797330L;

    public DublinCoreSchema() {
        super("xmlns:dc=\"http://purl.org/dc/elements/1.1/\"");
        setProperty(FORMAT, DocumentOpenUtil.PDF_TYPE);
    }

    public void addAuthor(String str) {
        XmpArray xmpArray = new XmpArray(XmpArray.ORDERED);
        xmpArray.add(str);
        setProperty(CREATOR, xmpArray);
    }

    public void addDescription(String str) {
        XmpArray xmpArray = new XmpArray(XmpArray.ALTERNATIVE);
        xmpArray.add(str);
        setProperty(DESCRIPTION, xmpArray);
    }

    public void addPublisher(String str) {
        XmpArray xmpArray = new XmpArray(XmpArray.ORDERED);
        xmpArray.add(str);
        setProperty(PUBLISHER, xmpArray);
    }

    public void addSubject(String str) {
        XmpArray xmpArray = new XmpArray(XmpArray.UNORDERED);
        xmpArray.add(str);
        setProperty(SUBJECT, xmpArray);
    }

    public void addTitle(String str) {
        XmpArray xmpArray = new XmpArray(XmpArray.ALTERNATIVE);
        xmpArray.add(str);
        setProperty(TITLE, xmpArray);
    }

    public void addAuthor(String[] strArr) {
        XmpArray xmpArray = new XmpArray(XmpArray.ORDERED);
        for (String add : strArr) {
            xmpArray.add(add);
        }
        setProperty(CREATOR, xmpArray);
    }

    public void addDescription(LangAlt langAlt) {
        setProperty(DESCRIPTION, langAlt);
    }

    public void addPublisher(String[] strArr) {
        XmpArray xmpArray = new XmpArray(XmpArray.ORDERED);
        for (String add : strArr) {
            xmpArray.add(add);
        }
        setProperty(PUBLISHER, xmpArray);
    }

    public void addSubject(String[] strArr) {
        XmpArray xmpArray = new XmpArray(XmpArray.UNORDERED);
        for (String add : strArr) {
            xmpArray.add(add);
        }
        setProperty(SUBJECT, xmpArray);
    }

    public void addTitle(LangAlt langAlt) {
        setProperty(TITLE, langAlt);
    }
}
