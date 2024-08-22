package com.baidu.browser.menu.longpress;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0002\u0010\u000eJ\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/baidu/browser/menu/longpress/ShowSelectionTextTask;", "Ljava/lang/Runnable;", "helper", "Lcom/baidu/browser/menu/longpress/SearchLongPressMenuHelper;", "top", "", "bottom", "left", "right", "text", "", "relativePosition", "", "physicalPixels", "(Lcom/baidu/browser/menu/longpress/SearchLongPressMenuHelper;IIIILjava/lang/String;ZZ)V", "getText", "()Ljava/lang/String;", "run", "", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShowSelectionTextTask.kt */
public final class ShowSelectionTextTask implements Runnable {
    private final int bottom;
    private final SearchLongPressMenuHelper helper;
    private final int left;
    private final boolean physicalPixels;
    private final boolean relativePosition;
    private final int right;
    private final String text;
    private final int top;

    public ShowSelectionTextTask(SearchLongPressMenuHelper helper2, int top2, int bottom2, int left2, int right2, String text2, boolean relativePosition2, boolean physicalPixels2) {
        Intrinsics.checkNotNullParameter(helper2, "helper");
        Intrinsics.checkNotNullParameter(text2, "text");
        this.helper = helper2;
        this.top = top2;
        this.bottom = bottom2;
        this.left = left2;
        this.right = right2;
        this.text = text2;
        this.relativePosition = relativePosition2;
        this.physicalPixels = physicalPixels2;
    }

    public final String getText() {
        return this.text;
    }

    public void run() {
        this.helper.showSelectionTextMenuInt(this.top, this.bottom, this.left, this.right, this.text, this.relativePosition, this.physicalPixels);
    }
}
