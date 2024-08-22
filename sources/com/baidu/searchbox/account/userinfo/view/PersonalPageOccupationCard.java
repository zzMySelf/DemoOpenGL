package com.baidu.searchbox.account.userinfo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.account.userinfo.R;
import com.baidu.searchbox.account.userinfo.data.PersonalPageUserEntity;
import com.baidu.searchbox.account.userinfo.utils.PersonalPageExtensionsKt;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u001a\u001a\u00020\u0015R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/account/userinfo/view/PersonalPageOccupationCard;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOccupationLayout", "Landroid/view/View;", "mOccupationName", "Landroid/widget/TextView;", "mOccupationRightIcon", "Landroid/widget/ImageView;", "mOccupationRightText", "mOccupationSubTitle", "mOccupationTitle", "onFontSizeChanged", "", "updateDoctorInfo", "userEntity", "Lcom/baidu/searchbox/account/userinfo/data/PersonalPageUserEntity;", "updateLawyerInfo", "updateTheme", "lib-userinfo_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageOccupationCard.kt */
public final class PersonalPageOccupationCard extends FrameLayout {
    public Map<Integer, View> _$_findViewCache;
    private final View mOccupationLayout;
    private final TextView mOccupationName;
    private final ImageView mOccupationRightIcon;
    private final TextView mOccupationRightText;
    private final TextView mOccupationSubTitle;
    private final TextView mOccupationTitle;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PersonalPageOccupationCard(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PersonalPageOccupationCard(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersonalPageOccupationCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        View.inflate(context, R.layout.personal_page_business_occupation_layout, this);
        View findViewById = findViewById(R.id.occupation_card_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.occupation_card_layout)");
        this.mOccupationLayout = findViewById;
        View findViewById2 = findViewById(R.id.occupation_name);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.occupation_name)");
        this.mOccupationName = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.occupation_right_text);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.occupation_right_text)");
        this.mOccupationRightText = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.occupation_right_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.occupation_right_icon)");
        this.mOccupationRightIcon = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.occupation_title);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.occupation_title)");
        this.mOccupationTitle = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.occupation_sub_title);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.occupation_sub_title)");
        this.mOccupationSubTitle = (TextView) findViewById6;
        onFontSizeChanged();
    }

    public final void updateLawyerInfo(PersonalPageUserEntity userEntity) {
        Intrinsics.checkNotNullParameter(userEntity, "userEntity");
        this.mOccupationName.setText(userEntity.getLawyerTitle());
        this.mOccupationTitle.setText(getResources().getString(R.string.laywer_title, new Object[]{userEntity.getLawyerFirm()}));
        this.mOccupationSubTitle.setText(getResources().getString(R.string.lawyer_sub_title, new Object[]{userEntity.getLawyerDomain()}));
    }

    public final void updateDoctorInfo(PersonalPageUserEntity userEntity) {
        Intrinsics.checkNotNullParameter(userEntity, "userEntity");
        this.mOccupationName.setText(userEntity.getDoctorCardTitle());
        this.mOccupationTitle.setText(getResources().getString(R.string.doctor_title, new Object[]{userEntity.getDoctorTitle()}));
        this.mOccupationSubTitle.setText(getResources().getString(R.string.doctor_sub_title, new Object[]{userEntity.getDoctorSubTitle()}));
    }

    public final void updateTheme() {
        this.mOccupationName.setTextColor(ContextCompat.getColor(getContext(), com.baidu.android.common.ui.style.R.color.GC1));
        this.mOccupationRightText.setTextColor(ContextCompat.getColor(getContext(), com.baidu.android.common.ui.style.R.color.GC4));
        this.mOccupationRightIcon.setImageResource(R.drawable.arrow_icon);
        this.mOccupationTitle.setTextColor(ContextCompat.getColor(getContext(), com.baidu.android.common.ui.style.R.color.GC1));
        this.mOccupationSubTitle.setTextColor(ContextCompat.getColor(getContext(), com.baidu.android.common.ui.style.R.color.GC1));
    }

    public final void onFontSizeChanged() {
        FontSizeViewExtKt.setScaledSize$default(this.mOccupationRightIcon, 0, PersonalPageExtensionsKt.dp2px(16), PersonalPageExtensionsKt.dp2px(16), 0, 8, (Object) null);
        FontSizeTextViewExtKt.setScaledSize$default(this.mOccupationName, 0, 1, 13.0f, 0, 8, (Object) null);
        FontSizeTextViewExtKt.setScaledSize$default(this.mOccupationRightText, 0, 1, 11.0f, 0, 8, (Object) null);
        FontSizeTextViewExtKt.setScaledSize$default(this.mOccupationTitle, 0, 1, 12.0f, 0, 8, (Object) null);
        FontSizeTextViewExtKt.setScaledSize$default(this.mOccupationSubTitle, 0, 1, 12.0f, 0, 8, (Object) null);
    }
}
