package com.baidu.searchbox.openwidget.render.exception;

import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/openwidget/render/exception/RenderBlankException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lcom/baidu/searchbox/NoProGuard;", "color", "", "(I)V", "getColor", "()I", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RenderBlankException.kt */
public final class RenderBlankException extends Exception implements NoProGuard {
    private final int color;

    public final int getColor() {
        return this.color;
    }

    public RenderBlankException(int color2) {
        super("blank color=" + color2);
        this.color = color2;
    }
}
