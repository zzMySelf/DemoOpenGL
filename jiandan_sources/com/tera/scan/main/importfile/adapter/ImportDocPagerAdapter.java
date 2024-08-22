package com.tera.scan.main.importfile.adapter;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.tera.scan.framework.BaseActivity;
import com.tera.scan.main.importfile.ImportDocListFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/tera/scan/main/importfile/adapter/ImportDocPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "activity", "Lcom/tera/scan/framework/BaseActivity;", "fragments", "", "Lcom/tera/scan/main/importfile/ImportDocListFragment;", "(Lcom/tera/scan/framework/BaseActivity;Ljava/util/List;)V", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItemCount", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImportDocPagerAdapter extends FragmentStateAdapter {
    @NotNull
    public final List<ImportDocListFragment> qw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImportDocPagerAdapter(@NotNull BaseActivity baseActivity, @NotNull List<ImportDocListFragment> list) {
        super((FragmentActivity) baseActivity);
        Intrinsics.checkNotNullParameter(baseActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(list, "fragments");
        this.qw = list;
    }

    @NotNull
    public Fragment createFragment(int i2) {
        return this.qw.get(i2);
    }

    public int getItemCount() {
        return this.qw.size();
    }
}
