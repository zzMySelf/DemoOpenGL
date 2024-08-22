package com.baidu.searchbox.aipersonal.activity;

import androidx.appcompat.widget.LinearLayoutCompat;
import com.baidu.searchbox.personalcenter.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/appcompat/widget/LinearLayoutCompat;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalAiCommonManagerActivity.kt */
final class PersonalAiCommonManagerActivity$mLlRoot$2 extends Lambda implements Function0<LinearLayoutCompat> {
    final /* synthetic */ PersonalAiCommonManagerActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalAiCommonManagerActivity$mLlRoot$2(PersonalAiCommonManagerActivity personalAiCommonManagerActivity) {
        super(0);
        this.this$0 = personalAiCommonManagerActivity;
    }

    public final LinearLayoutCompat invoke() {
        return (LinearLayoutCompat) this.this$0.findViewById(R.id.cl_root);
    }
}
