package com.baidu.searchbox.player.data;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/player/data/NativeStringProvider;", "Lcom/baidu/searchbox/player/data/IBigStringProvider;", "()V", "byteBuffer", "Ljava/nio/ByteBuffer;", "getData", "", "initByte", "str", "setData", "", "content", "bdvideoplayer-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IBigStringProvider.kt */
public final class NativeStringProvider implements IBigStringProvider {
    private ByteBuffer byteBuffer;

    public String getData() {
        String str;
        ByteBuffer $this$getData_u24lambda_u2d1 = this.byteBuffer;
        if ($this$getData_u24lambda_u2d1 == null) {
            return null;
        }
        synchronized ($this$getData_u24lambda_u2d1) {
            $this$getData_u24lambda_u2d1.rewind();
            byte[] byteArray = new byte[$this$getData_u24lambda_u2d1.limit()];
            $this$getData_u24lambda_u2d1.get(byteArray);
            str = new String(byteArray, Charsets.UTF_8);
        }
        return str;
    }

    public void setData(String content) {
        this.byteBuffer = initByte(content);
    }

    private final ByteBuffer initByte(String str) {
        if (str == null) {
            return null;
        }
        String str2 = str;
        byte[] stringBytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(stringBytes, "this as java.lang.String).getBytes(charset)");
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(stringBytes.length);
        ByteBuffer $this$initByte_u24lambda_u2d3_u24lambda_u2d2 = allocateDirect;
        $this$initByte_u24lambda_u2d3_u24lambda_u2d2.put(stringBytes);
        $this$initByte_u24lambda_u2d3_u24lambda_u2d2.flip();
        return allocateDirect;
    }
}
