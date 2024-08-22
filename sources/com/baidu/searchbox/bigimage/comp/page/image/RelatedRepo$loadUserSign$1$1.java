package com.baidu.searchbox.bigimage.comp.page.image;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "data", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RelatedRepo.kt */
final class RelatedRepo$loadUserSign$1$1 extends Lambda implements Function1<String, Object> {
    final /* synthetic */ RelatedRepo this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RelatedRepo$loadUserSign$1$1(RelatedRepo relatedRepo) {
        super(1);
        this.this$0 = relatedRepo;
    }

    public final Object invoke(String data) {
        CharSequence charSequence = data;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            String userSign = this.this$0.parseUserSign(new JSONObject(data));
            CharSequence charSequence2 = userSign;
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = true;
            }
            if (!z) {
                return userSign;
            }
            throw new Exception("userSign is empty");
        }
        throw new Exception("data is empty");
    }
}
