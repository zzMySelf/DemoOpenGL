package com.itextpdf.text;

import java.util.EventListener;

public interface ElementListener extends EventListener {
    boolean ad(Element element) throws DocumentException;
}
