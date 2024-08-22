package com.itextpdf.text;

import fe.when.ad.fe;
import java.util.List;

public interface Element {
    List<fe> getChunks();

    boolean isContent();

    boolean isNestable();

    boolean process(ElementListener elementListener);

    int type();
}
