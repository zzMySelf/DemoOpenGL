package com.baidu.searchbox.music.ext.comment.repo;

import com.baidu.searchbox.music.bean.Singer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/baidu/searchbox/music/bean/Singer;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MusicCommentRepo.kt */
final class MusicCommentRepo$getCommentInfo$1$1$1 extends Lambda implements Function1<Singer, CharSequence> {
    public static final MusicCommentRepo$getCommentInfo$1$1$1 INSTANCE = new MusicCommentRepo$getCommentInfo$1$1$1();

    MusicCommentRepo$getCommentInfo$1$1$1() {
        super(1);
    }

    public final CharSequence invoke(Singer it) {
        return it.getName();
    }
}
