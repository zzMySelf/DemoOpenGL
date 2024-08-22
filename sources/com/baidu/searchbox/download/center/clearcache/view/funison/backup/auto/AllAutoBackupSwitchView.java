package com.baidu.searchbox.download.center.clearcache.view.funison.backup.auto;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.clearcache.business.R;
import com.baidu.searchbox.download.center.clearcache.view.funison.backup.auto.AbsAutoBackupSwitchView;
import com.baidu.searchbox.download.center.ui.autobackup.NetDiskOptionWrapper;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/backup/auto/AllAutoBackupSwitchView;", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/backup/auto/AbsAutoBackupSwitchView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getIconDrawable", "Landroid/graphics/drawable/Drawable;", "getSubtitle", "", "getSwitchButtonOffStateBackground", "getSwitchButtonOffStateText", "getSwitchButtonOffStateTextColor", "getSwitchType", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/backup/auto/AbsAutoBackupSwitchView$AutoBackupSwitchType;", "getTitle", "onSwitchButtonClicked", "", "updateUIForSwitchState", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AllAutoBackupSwitchView.kt */
public final class AllAutoBackupSwitchView extends AbsAutoBackupSwitchView {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AllAutoBackupSwitchView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        updateUIForSwitchState();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AllAutoBackupSwitchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        updateUIForSwitchState();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AllAutoBackupSwitchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        updateUIForSwitchState();
    }

    public void updateUIForSwitchState() {
        setMAutoBackupSwitch(NetDiskOptionWrapper.INSTANCE.getSwitchStateAutoBackup());
    }

    public Drawable getIconDrawable() {
        return ContextCompat.getDrawable(getContext(), R.drawable.clear_cache_auto_backup_icon_all);
    }

    public String getTitle() {
        String string = getContext().getString(R.string.clear_cache_auto_backup_switch_title_all);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…_backup_switch_title_all)");
        return string;
    }

    public String getSubtitle() {
        String string = getContext().getString(R.string.clear_cache_auto_backup_switch_subtitle);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…o_backup_switch_subtitle)");
        return string;
    }

    public String getSwitchButtonOffStateText() {
        String string = getResources().getString(R.string.clear_cache_auto_backup_open);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…r_cache_auto_backup_open)");
        return string;
    }

    public int getSwitchButtonOffStateTextColor() {
        return ContextCompat.getColor(getContext(), R.color.BC136);
    }

    public Drawable getSwitchButtonOffStateBackground() {
        return ContextCompat.getDrawable(getContext(), R.drawable.clear_cache_auto_backup_switch_off_common_bg);
    }

    public void onSwitchButtonClicked() {
        gotoAutoBackupSettingPage();
    }

    /* access modifiers changed from: protected */
    public AbsAutoBackupSwitchView.AutoBackupSwitchType getSwitchType() {
        return AbsAutoBackupSwitchView.AutoBackupSwitchType.ALL;
    }
}
