package com.mars.kotlin.database.shard;

import android.net.Uri;
import com.alipay.sdk.m.s.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/mars/kotlin/database/shard/ShardUri;", "", "key", "Landroid/net/Uri;", "invoke", "(Ljava/lang/String;)Landroid/net/Uri;", "uriString", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "database_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class ShardUri {
    public final String uriString;

    public ShardUri(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "uriString");
        this.uriString = str;
    }

    @NotNull
    public final Uri invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        String str2 = "?";
        if (StringsKt__StringsKt.contains$default((CharSequence) this.uriString, (CharSequence) str2, false, 2, (Object) null)) {
            str2 = a.n;
        }
        Uri parse = Uri.parse(this.uriString + str2 + (Uri.encode(ShardUriKt.SHARD_KEY) + "=" + Uri.encode(str)));
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(\"$uriString$term$queryString\")");
        return parse;
    }
}
