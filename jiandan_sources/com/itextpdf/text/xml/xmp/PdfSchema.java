package com.itextpdf.text.xml.xmp;

import fe.when.ad.b;

@Deprecated
public class PdfSchema extends XmpSchema {
    public static final String DEFAULT_XPATH_ID = "pdf";
    public static final String DEFAULT_XPATH_URI = "http://ns.adobe.com/pdf/1.3/";
    public static final String KEYWORDS = "pdf:Keywords";
    public static final String PRODUCER = "pdf:Producer";
    public static final String VERSION = "pdf:PDFVersion";
    public static final long serialVersionUID = -1541148669123992185L;

    public PdfSchema() {
        super("xmlns:pdf=\"http://ns.adobe.com/pdf/1.3/\"");
        addProducer(b.qw().fe());
    }

    public void addKeywords(String str) {
        setProperty(KEYWORDS, str);
    }

    public void addProducer(String str) {
        setProperty(PRODUCER, str);
    }

    public void addVersion(String str) {
        setProperty(VERSION, str);
    }
}
