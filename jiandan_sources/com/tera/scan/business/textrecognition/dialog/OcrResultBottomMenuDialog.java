package com.tera.scan.business.textrecognition.dialog;

import android.view.View;
import android.widget.TextView;
import com.baidu.aiscan.R;
import com.tera.scan.business.core.ui.dialog.ScanBaseBottomDialogFragment;
import com.tera.scan.vip.model.PrivilegeType;
import com.tera.scan.vip.util.VipRightsManager;
import fe.mmm.qw.p030switch.rg.qw;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J,\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/tera/scan/business/textrecognition/dialog/OcrResultBottomMenuDialog;", "Lcom/tera/scan/business/core/ui/dialog/ScanBaseBottomDialogFragment;", "Landroid/view/View$OnClickListener;", "()V", "onMenuItemClickListener", "Lcom/tera/scan/business/textrecognition/dialog/OcrResultBottomMenuDialog$OnMenuItemClickListener;", "getOnMenuItemClickListener", "()Lcom/tera/scan/business/textrecognition/dialog/OcrResultBottomMenuDialog$OnMenuItemClickListener;", "setOnMenuItemClickListener", "(Lcom/tera/scan/business/textrecognition/dialog/OcrResultBottomMenuDialog$OnMenuItemClickListener;)V", "getLayoutId", "", "initItem", "", "type", "", "itemView", "Lcom/tera/scan/business/textrecognition/dialog/OcrResultMenuItemView;", "icon", "str", "initView", "view", "Landroid/view/View;", "onClick", "v", "OnMenuItemClickListener", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OcrResultBottomMenuDialog extends ScanBaseBottomDialogFragment implements View.OnClickListener {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Nullable
    public OnMenuItemClickListener onMenuItemClickListener;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/tera/scan/business/textrecognition/dialog/OcrResultBottomMenuDialog$OnMenuItemClickListener;", "", "onCopyClick", "", "onEditClick", "onExportClick", "onToWordClick", "onTranslateClick", "business-text-recongition_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnMenuItemClickListener {
        void onCopyClick();

        void onEditClick();

        void onExportClick();

        void onToWordClick();

        void onTranslateClick();
    }

    private final void initItem(String str, OcrResultMenuItemView ocrResultMenuItemView, int i2, int i3) {
        if (ocrResultMenuItemView != null) {
            ocrResultMenuItemView.setMenuIcon(i2);
        }
        if (ocrResultMenuItemView != null) {
            ocrResultMenuItemView.setMenuText(i3);
        }
        boolean z = true;
        if (str == null || str.length() == 0) {
            if (ocrResultMenuItemView != null) {
                ocrResultMenuItemView.setFreeTimesAndVisible(0, false);
            }
            if (ocrResultMenuItemView != null) {
                ocrResultMenuItemView.setRightTopVipStatusVisible(false);
            }
        } else {
            int rg2 = VipRightsManager.qw.rg(str);
            if (qw.qw().qw()) {
                if (ocrResultMenuItemView != null) {
                    ocrResultMenuItemView.setFreeTimesAndVisible(rg2, false);
                }
                if (ocrResultMenuItemView != null) {
                    ocrResultMenuItemView.setRightTopVipStatusVisible(true);
                }
            } else {
                if (ocrResultMenuItemView != null) {
                    ocrResultMenuItemView.setFreeTimesAndVisible(rg2, rg2 > 0);
                }
                if (ocrResultMenuItemView != null) {
                    if (rg2 > 0) {
                        z = false;
                    }
                    ocrResultMenuItemView.setRightTopVipStatusVisible(z);
                }
            }
        }
        if (ocrResultMenuItemView != null) {
            ocrResultMenuItemView.setOnClickListener(this);
        }
    }

    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m747initView$lambda0(OcrResultBottomMenuDialog ocrResultBottomMenuDialog, View view) {
        Intrinsics.checkNotNullParameter(ocrResultBottomMenuDialog, "this$0");
        ocrResultBottomMenuDialog.dismiss();
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i2) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i2)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public int getLayoutId() {
        return R.layout.dialog_ocr_result_bottom_menu;
    }

    @Nullable
    public final OnMenuItemClickListener getOnMenuItemClickListener() {
        return this.onMenuItemClickListener;
    }

    public void initView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        initItem(PrivilegeType.imageAiTranslate.getValue(), (OcrResultMenuItemView) _$_findCachedViewById(R.id.ormiv_translate), R.drawable.icon_ai_translate, R.string.translate);
        initItem(PrivilegeType.imageToWord.getValue(), (OcrResultMenuItemView) _$_findCachedViewById(R.id.ormiv_to_word), R.drawable.icon_to_word, R.string.to_word_tab);
        initItem((String) null, (OcrResultMenuItemView) _$_findCachedViewById(R.id.ormiv_edit), R.drawable.ic_image2text_proofread, R.string.image2text_operation_proofread);
        initItem((String) null, (OcrResultMenuItemView) _$_findCachedViewById(R.id.ormiv_copy), R.drawable.ic_image2text_copy, R.string.image2text_operation_copy);
        initItem((String) null, (OcrResultMenuItemView) _$_findCachedViewById(R.id.ormiv_export), R.drawable.ic_image2text_export, R.string.image2text_operation_export_doc);
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_dialog_cancel);
        if (textView != null) {
            textView.setOnClickListener(new fe.mmm.qw.rg.de.vvv.qw(this));
        }
    }

    public void onClick(@Nullable View view) {
        OnMenuItemClickListener onMenuItemClickListener2;
        dismiss();
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.ormiv_translate) {
            OnMenuItemClickListener onMenuItemClickListener3 = this.onMenuItemClickListener;
            if (onMenuItemClickListener3 != null) {
                onMenuItemClickListener3.onTranslateClick();
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.ormiv_to_word) {
            OnMenuItemClickListener onMenuItemClickListener4 = this.onMenuItemClickListener;
            if (onMenuItemClickListener4 != null) {
                onMenuItemClickListener4.onToWordClick();
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.ormiv_edit) {
            OnMenuItemClickListener onMenuItemClickListener5 = this.onMenuItemClickListener;
            if (onMenuItemClickListener5 != null) {
                onMenuItemClickListener5.onEditClick();
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.ormiv_copy) {
            OnMenuItemClickListener onMenuItemClickListener6 = this.onMenuItemClickListener;
            if (onMenuItemClickListener6 != null) {
                onMenuItemClickListener6.onCopyClick();
            }
        } else if (valueOf != null && valueOf.intValue() == R.id.ormiv_export && (onMenuItemClickListener2 = this.onMenuItemClickListener) != null) {
            onMenuItemClickListener2.onExportClick();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void setOnMenuItemClickListener(@Nullable OnMenuItemClickListener onMenuItemClickListener2) {
        this.onMenuItemClickListener = onMenuItemClickListener2;
    }
}
