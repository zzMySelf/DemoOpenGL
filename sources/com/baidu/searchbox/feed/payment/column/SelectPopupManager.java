package com.baidu.searchbox.feed.payment.column;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.android.ext.widget.PopupWindow;
import com.baidu.searchbox.feed.payment.R;
import com.baidu.searchbox.feed.payment.column.SelectPicker;
import com.baidu.searchbox.skin.NightModeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0016J\u0016\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0006J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/feed/payment/column/SelectPopupManager;", "Landroid/view/View$OnClickListener;", "()V", "mCloseBtn", "Landroid/widget/TextView;", "mContent", "Landroid/view/View;", "mDivider", "mMask", "mPicker", "Lcom/baidu/searchbox/feed/payment/column/SelectPicker;", "mPopupWindow", "Lcom/baidu/android/ext/widget/PopupWindow;", "mTitle", "navigation", "closePanel", "", "getPickerView", "context", "Landroid/content/Context;", "initPopupPicker", "onClick", "v", "popupPicker", "anchorView", "setResultListener", "callback", "Lcom/baidu/searchbox/feed/payment/column/SelectPicker$PickerCallBack;", "setTracksCount", "count", "", "updateUI", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectPopupManager.kt */
public final class SelectPopupManager implements View.OnClickListener {
    private TextView mCloseBtn;
    private View mContent;
    private View mDivider;
    private View mMask;
    private SelectPicker mPicker;
    private PopupWindow mPopupWindow;
    private TextView mTitle;
    private View navigation;

    public final void popupPicker(Context context, View anchorView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        PopupWindow it = this.mPopupWindow;
        if (it != null) {
            it.showAtLocation(anchorView, 80, 0, 0);
            updateUI(context);
            SelectPicker selectPicker = this.mPicker;
            if (selectPicker != null) {
                selectPicker.initCurrentPickedValue();
            }
        }
    }

    public final void setTracksCount(int count) {
        SelectPicker selectPicker = this.mPicker;
        if (selectPicker != null) {
            selectPicker.setTracksCount(count);
        }
    }

    public final void setResultListener(SelectPicker.PickerCallBack callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        SelectPicker selectPicker = this.mPicker;
        if (selectPicker != null) {
            selectPicker.setOnPickListener(callback);
        }
    }

    public final void initPopupPicker(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PopupWindow it = new PopupWindow(context);
        this.mPopupWindow = it;
        it.setContentView(getPickerView(context));
        it.setHeight(-1);
        it.setWidth(-1);
        it.setClippingEnabled(false);
        it.setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.tracks_picker_bg)));
        it.setOutsideTouchable(true);
        it.setFocusable(true);
        it.update();
    }

    private final View getPickerView(Context context) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.feed_tracks_popup, (ViewGroup) null);
        this.mContent = rootView.findViewById(R.id.content);
        this.mCloseBtn = (TextView) rootView.findViewById(R.id.close_button);
        this.mPicker = (SelectPicker) rootView.findViewById(R.id.picker_track);
        this.mMask = rootView.findViewById(R.id.empty_view);
        this.mTitle = (TextView) rootView.findViewById(R.id.picker_title);
        this.mDivider = rootView.findViewById(R.id.divider_above_close);
        this.navigation = rootView.findViewById(R.id.fake_navigation_bar);
        TextView textView = this.mCloseBtn;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        View view2 = this.mMask;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        if (Build.VERSION.SDK_INT > 29) {
            View view3 = this.navigation;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            int color = NightModeHelper.isNightMode() ? R.color.feed_pay_panel_bar : R.color.white_fff;
            View view4 = this.navigation;
            if (view4 != null) {
                view4.setBackground(ContextCompat.getDrawable(context, color));
            }
        }
        updateUI(context);
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return rootView;
    }

    private final void updateUI(Context context) {
        Resources res = context.getResources();
        View view2 = this.mContent;
        if (view2 != null) {
            view2.setBackground(res.getDrawable(R.drawable.feed_tracks_picker_bg_normal));
        }
        TextView textView = this.mCloseBtn;
        if (textView != null) {
            textView.setTextColor(res.getColor(R.color.tracks_picker_close_color));
        }
        TextView textView2 = this.mTitle;
        if (textView2 != null) {
            textView2.setTextColor(res.getColor(R.color.tracks_picker_close_color));
        }
        View view3 = this.mDivider;
        if (view3 != null) {
            view3.setBackgroundColor(res.getColor(R.color.tracks_picker_border));
        }
    }

    public void onClick(View v) {
        if (v != null) {
            View view2 = v;
            if (v.getId() == R.id.close_button || v.getId() == R.id.empty_view) {
                closePanel();
            }
        }
    }

    public final void closePanel() {
        PopupWindow popupWindow = this.mPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }
}
