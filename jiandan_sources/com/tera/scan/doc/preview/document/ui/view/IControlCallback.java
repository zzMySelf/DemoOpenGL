package com.tera.scan.doc.preview.document.ui.view;

public interface IControlCallback {
    boolean canShowToExcel();

    boolean canShowToPPT();

    boolean canShowToPic();

    boolean canShowToWord();

    void onEnterPlay();

    void onExitPlay();

    void onPDFToExcel();

    void onPDFToPPT();

    void onPDFToPic();

    void onPDFToWord();

    void onPageChanged(int i2, int i3);

    void onSingleClick();
}
