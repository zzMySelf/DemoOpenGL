package com.tera.scan.main.ui.settingitems;

import com.tera.scan.main.view.SettingItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\f"}, d2 = {"Lcom/tera/scan/main/ui/settingitems/ISettingItem;", "", "init", "", "item", "Lcom/tera/scan/main/view/SettingItemView;", "name", "", "onDestroy", "onPause", "onResume", "tips", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ISettingItem {

    public static final class qw {
        public static void ad(@NotNull ISettingItem iSettingItem) {
        }

        public static void de(@NotNull ISettingItem iSettingItem) {
        }

        @Nullable
        public static String fe(@NotNull ISettingItem iSettingItem) {
            return null;
        }

        public static void qw(@NotNull ISettingItem iSettingItem) {
        }
    }

    @NotNull
    String name();

    void onDestroy();

    void onPause();

    void onResume();

    @Nullable
    String rg();

    void th(@NotNull SettingItemView settingItemView);
}
