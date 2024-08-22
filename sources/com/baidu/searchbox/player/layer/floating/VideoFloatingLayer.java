package com.baidu.searchbox.player.layer.floating;

import com.baidu.searchbox.floating.layer.SimpleFloatingControlLayer;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/player/layer/floating/VideoFloatingLayer;", "Lcom/baidu/searchbox/floating/layer/SimpleFloatingControlLayer;", "()V", "addBackElement", "", "addCloseElement", "addErrorElement", "addRePlayElement", "lib-player-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFloatingLayer.kt */
public class VideoFloatingLayer extends SimpleFloatingControlLayer {
    /* access modifiers changed from: protected */
    public void addCloseElement() {
        FloatingCloseElement $this$addCloseElement_u24lambda_u2d0 = new FloatingCloseElement();
        addElement($this$addCloseElement_u24lambda_u2d0);
        setCloseElement($this$addCloseElement_u24lambda_u2d0);
    }

    /* access modifiers changed from: protected */
    public void addBackElement() {
        FloatingBackElement $this$addBackElement_u24lambda_u2d1 = new FloatingBackElement();
        addElement($this$addBackElement_u24lambda_u2d1);
        setBackElement($this$addBackElement_u24lambda_u2d1);
    }

    /* access modifiers changed from: protected */
    public void addRePlayElement() {
        FloatingRePlayElement $this$addRePlayElement_u24lambda_u2d2 = new FloatingRePlayElement();
        addElement($this$addRePlayElement_u24lambda_u2d2);
        setRePlayElement($this$addRePlayElement_u24lambda_u2d2);
    }

    /* access modifiers changed from: protected */
    public void addErrorElement() {
        FloatingErrorElement $this$addErrorElement_u24lambda_u2d3 = new FloatingErrorElement();
        addElement($this$addErrorElement_u24lambda_u2d3);
        setErrorElement($this$addErrorElement_u24lambda_u2d3);
    }
}
