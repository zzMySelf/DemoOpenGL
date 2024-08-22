package com.github.barteksc.pdfviewer.exception;

public class PageRenderingException extends Exception {
    public final int page;

    public PageRenderingException(int i2, Throwable th2) {
        super(th2);
        this.page = i2;
    }

    public int getPage() {
        return this.page;
    }
}
