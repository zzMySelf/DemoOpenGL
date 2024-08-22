package com.baidu.searchbox.userassetsaggr.container.recyclebin;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.userassetsaggr.container.R;
import com.baidu.searchbox.userassetsaggr.container.ubc.UserAssetsRecycleBinUbc;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001b\u001a\u00020\u0013J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u001dH\u0002R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/userassetsaggr/container/recyclebin/DeleteDialogWithRecycleBinContentView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "partMessage", "getPartMessage", "()Ljava/lang/String;", "setPartMessage", "(Ljava/lang/String;)V", "showSelectPrefix", "", "getShowSelectPrefix", "()Z", "setShowSelectPrefix", "(Z)V", "ubcPage", "getUbcPage", "setUbcPage", "getIsSelectedRecycleBin", "initView", "", "onFontSizeChanged", "onNightModeChanged", "reverseCheckedState", "updateMessageText", "lib-favorHis-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeleteDialogWithRecycleBinContentView.kt */
public final class DeleteDialogWithRecycleBinContentView extends FrameLayout {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private String partMessage;
    private boolean showSelectPrefix;
    private String ubcPage;

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

    public final String getPartMessage() {
        return this.partMessage;
    }

    public final void setPartMessage(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.partMessage = value;
        updateMessageText();
    }

    public final boolean getShowSelectPrefix() {
        return this.showSelectPrefix;
    }

    public final void setShowSelectPrefix(boolean z) {
        this.showSelectPrefix = z;
    }

    public final String getUbcPage() {
        return this.ubcPage;
    }

    public final void setUbcPage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ubcPage = str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeleteDialogWithRecycleBinContentView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.partMessage = "";
        this.showSelectPrefix = true;
        this.ubcPage = "";
        initView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeleteDialogWithRecycleBinContentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.partMessage = "";
        this.showSelectPrefix = true;
        this.ubcPage = "";
        initView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeleteDialogWithRecycleBinContentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.partMessage = "";
        this.showSelectPrefix = true;
        this.ubcPage = "";
        initView();
    }

    public final boolean getIsSelectedRecycleBin() {
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.recycleBinDeleteDialogCheckBoxView);
        if (imageView != null) {
            return imageView.isSelected();
        }
        return false;
    }

    private final void initView() {
        removeAllViews();
        LayoutInflater.from(getContext()).inflate(R.layout.recycle_bin_delete_dialog, this, true);
        onNightModeChanged();
        onFontSizeChanged();
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.recycleBinDeleteDialogCheckBoxView);
        if (imageView != null) {
            imageView.setSelected(true);
        }
        ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.recycleBinDeleteDialogCheckBoxView);
        if (imageView2 != null) {
            imageView2.setOnClickListener(new DeleteDialogWithRecycleBinContentView$$ExternalSyntheticLambda0(this));
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.recycleBinDeleteDialogCheckTextView);
        if (textView != null) {
            textView.setOnClickListener(new DeleteDialogWithRecycleBinContentView$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m4655initView$lambda0(DeleteDialogWithRecycleBinContentView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.reverseCheckedState();
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-1  reason: not valid java name */
    public static final void m4656initView$lambda1(DeleteDialogWithRecycleBinContentView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.reverseCheckedState();
    }

    private final void reverseCheckedState() {
        String ubcValue;
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.recycleBinDeleteDialogCheckBoxView);
        if (imageView != null) {
            boolean checkedState = imageView.isSelected();
            if (checkedState) {
                ubcValue = UserAssetsRecycleBinUbc.VALUE_VALUE_PITCH_ON;
            } else {
                ubcValue = UserAssetsRecycleBinUbc.VALUE_VALUE_PITCH_OFF;
            }
            UserAssetsRecycleBinUbc.INSTANCE.doRecycleBinDialogUbc(ubcValue, this.ubcPage);
            ImageView imageView2 = (ImageView) _$_findCachedViewById(R.id.recycleBinDeleteDialogCheckBoxView);
            if (imageView2 != null) {
                imageView2.setSelected(!checkedState);
            }
            updateMessageText();
        }
    }

    private final void updateMessageText() {
        String messageStrong;
        String messageText;
        int messageStrongColor;
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.recycleBinDeleteDialogCheckBoxView);
        boolean isSelectedRecycleBin = imageView != null ? imageView.isSelected() : false;
        if (isSelectedRecycleBin) {
            messageStrong = getResources().getString(R.string.user_assets_favorhis_recycle_delete_message_strong_checked);
        } else {
            messageStrong = getResources().getString(R.string.user_assets_favorhis_recycle_delete_message_strong_unchecked);
        }
        Intrinsics.checkNotNullExpressionValue(messageStrong, "if (isSelectedRecycleBin…rong_unchecked)\n        }");
        if (isSelectedRecycleBin) {
            if (this.showSelectPrefix) {
                messageText = getResources().getString(R.string.user_assets_favorhis_recycle_delete_message_checked, new Object[]{this.partMessage, messageStrong});
            } else {
                messageText = getResources().getString(R.string.user_assets_favorhis_recycle_delete_message_checked_without_select, new Object[]{messageStrong});
            }
        } else if (this.showSelectPrefix) {
            messageText = getResources().getString(R.string.user_assets_favorhis_recycle_delete_message_unchecked, new Object[]{this.partMessage, messageStrong});
        } else {
            messageText = getResources().getString(R.string.user_assets_favorhis_recycle_delete_message_unchecked_without_select, new Object[]{messageStrong});
        }
        Intrinsics.checkNotNullExpressionValue(messageText, "if (isSelectedRecycleBin…)\n            }\n        }");
        SpannableString messageSpannable = new SpannableString(messageText);
        try {
            int strongMessageStartIndex = StringsKt.indexOf$default((CharSequence) messageSpannable, messageStrong, 0, false, 6, (Object) null);
            int strongMessageEndIndexExclusive = messageStrong.length() + strongMessageStartIndex;
            if (strongMessageStartIndex > -1 && strongMessageEndIndexExclusive < messageText.length()) {
                if (isSelectedRecycleBin) {
                    messageStrongColor = ContextCompat.getColor(getContext(), com.baidu.android.common.ui.style.R.color.GC4);
                } else {
                    messageStrongColor = ContextCompat.getColor(getContext(), com.baidu.android.common.ui.style.R.color.GC8);
                }
                messageSpannable.setSpan(new ForegroundColorSpan(messageStrongColor), strongMessageStartIndex, strongMessageEndIndexExclusive, 17);
            }
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.recycleBinDeleteDialogMessageTextView);
        if (textView != null) {
            textView.setTextColor(ContextCompat.getColor(getContext(), com.baidu.android.common.ui.style.R.color.GC4));
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.recycleBinDeleteDialogMessageTextView);
        if (textView2 != null) {
            textView2.setText(messageSpannable);
        }
    }

    private final void onNightModeChanged() {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.recycleBinDeleteDialogRootView);
        if (constraintLayout != null) {
            constraintLayout.setBackgroundColor(ContextCompat.getColor(getContext(), com.baidu.android.common.ui.style.R.color.GC10));
        }
        TextView textView = (TextView) _$_findCachedViewById(R.id.recycleBinDeleteDialogTitleView);
        if (textView != null) {
            textView.setTextColor(ContextCompat.getColor(getContext(), com.baidu.android.common.ui.style.R.color.GC1));
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.recycleBinDeleteDialogCheckBoxView);
        if (imageView != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.user_assets_item_select_selector));
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.recycleBinDeleteDialogCheckTextView);
        if (textView2 != null) {
            textView2.setTextColor(ContextCompat.getColor(getContext(), com.baidu.android.common.ui.style.R.color.GC4));
        }
        updateMessageText();
    }

    private final void onFontSizeChanged() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.recycleBinDeleteDialogTitleView);
        if (textView != null) {
            FontSizeTextViewExtKt.setScaledSizeRes$default(textView, 0, R.dimen.user_assets_delete_recycle_dialog_title_text_size, 0, 4, (Object) null);
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.recycleBinDeleteDialogCheckBoxView);
        if (imageView != null) {
            FontSizeViewExtKt.setScaledSizeRes$default(imageView, 0, R.dimen.user_assets_delete_recycle_dialog_checkbox_size, R.dimen.user_assets_delete_recycle_dialog_checkbox_size, 0, 8, (Object) null);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.recycleBinDeleteDialogCheckTextView);
        if (textView2 != null) {
            FontSizeTextViewExtKt.setScaledSizeRes$default(textView2, 0, R.dimen.user_assets_delete_recycle_dialog_msg_text_size, 0, 4, (Object) null);
        }
        TextView textView3 = (TextView) _$_findCachedViewById(R.id.recycleBinDeleteDialogMessageTextView);
        if (textView3 != null) {
            FontSizeTextViewExtKt.setScaledSizeRes$default(textView3, 0, R.dimen.user_assets_delete_recycle_dialog_msg_text_size, 0, 4, (Object) null);
        }
    }
}
