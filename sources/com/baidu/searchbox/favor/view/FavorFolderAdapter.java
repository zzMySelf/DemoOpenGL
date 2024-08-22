package com.baidu.searchbox.favor.view;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.favor.R;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.favor.model.FavorPanelModel;
import com.baidu.searchbox.favor.model.FavorPanelScene;
import com.baidu.searchbox.favor.model.FavorPanelSource;
import com.baidu.searchbox.favor.util.FavorFolderPanelUtils;
import com.baidu.searchbox.ui.BdBaseImageView;
import com.baidu.searchbox.userassetsaggr.container.ubc.UserAssetsAggrUbc;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000256B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u000eH\u0016J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00152\u0006\u0010#\u001a\u00020\u0015H\u0002J\u0010\u0010$\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0015H\u0002J\u0018\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u000eH\u0016J\u0018\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000eH\u0016J\u0010\u0010,\u001a\u00020 2\b\u0010-\u001a\u0004\u0018\u00010\u0005J\u0010\u0010.\u001a\u00020 2\b\u0010-\u001a\u0004\u0018\u00010\fJ\u0010\u0010/\u001a\u00020 2\b\u00100\u001a\u0004\u0018\u00010\nJ\u0018\u00101\u001a\u00020 2\u0010\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u000103J\u0018\u00104\u001a\u00020 2\u0006\u0010&\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\u000eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001c\u0010\u001d¨\u00067"}, d2 = {"Lcom/baidu/searchbox/favor/view/FavorFolderAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/searchbox/favor/view/FavorFolderAdapter$ViewHolder;", "()V", "favorModel", "Lcom/baidu/searchbox/favor/data/FavorModel;", "hasClicked", "", "hasRecommend", "itemListener", "Lcom/baidu/searchbox/favor/view/FavorFolderAdapter$FolderItemListener;", "panelModel", "Lcom/baidu/searchbox/favor/model/FavorPanelModel;", "selectedPosition", "", "getSelectedPosition", "()I", "setSelectedPosition", "(I)V", "ubcShowList", "", "", "getUbcShowList", "()Ljava/util/Set;", "ubcShowList$delegate", "Lkotlin/Lazy;", "userFolderList", "", "getUserFolderList", "()Ljava/util/List;", "userFolderList$delegate", "addRecommendItem", "", "getItemCount", "getUbcExt", "folderTitle", "moveToFolder", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setFavorModel", "model", "setFavorPanelModel", "setFolderItemListener", "listener", "setUserFolderData", "list", "", "updatePadding", "FolderItemListener", "ViewHolder", "lib-favor_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FavorFolderAdapter.kt */
public final class FavorFolderAdapter extends RecyclerView.Adapter<ViewHolder> {
    private FavorModel favorModel;
    private boolean hasClicked;
    private boolean hasRecommend;
    /* access modifiers changed from: private */
    public FolderItemListener itemListener;
    private FavorPanelModel panelModel;
    private int selectedPosition = -1;
    private final Lazy ubcShowList$delegate = LazyKt.lazy(FavorFolderAdapter$ubcShowList$2.INSTANCE);
    private final Lazy userFolderList$delegate = LazyKt.lazy(FavorFolderAdapter$userFolderList$2.INSTANCE);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/favor/view/FavorFolderAdapter$FolderItemListener;", "", "onMoveFolder", "", "folderTitle", "", "lib-favor_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FavorFolderAdapter.kt */
    public interface FolderItemListener {
        void onMoveFolder(String str);
    }

    private final List<String> getUserFolderList() {
        return (List) this.userFolderList$delegate.getValue();
    }

    public final int getSelectedPosition() {
        return this.selectedPosition;
    }

    public final void setSelectedPosition(int i2) {
        this.selectedPosition = i2;
    }

    private final Set<String> getUbcShowList() {
        return (Set) this.ubcShowList$delegate.getValue();
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/favor/view/FavorFolderAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "folderIcon", "Lcom/baidu/searchbox/ui/BdBaseImageView;", "getFolderIcon", "()Lcom/baidu/searchbox/ui/BdBaseImageView;", "folderTittle", "Landroid/widget/TextView;", "getFolderTittle", "()Landroid/widget/TextView;", "recommendFolderTag", "getRecommendFolderTag", "selectedIcon", "getSelectedIcon", "onFontSizeChanged", "", "updateIconState", "isSelected", "", "updateTheme", "lib-favor_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FavorFolderAdapter.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final BdBaseImageView folderIcon;
        private final TextView folderTittle;
        private final TextView recommendFolderTag;
        private final BdBaseImageView selectedIcon;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.folderIcon = (BdBaseImageView) itemView.findViewById(R.id.favor_folder_item_icon);
            this.folderTittle = (TextView) itemView.findViewById(R.id.favor_folder_item_title);
            this.recommendFolderTag = (TextView) itemView.findViewById(R.id.favor_folder_item_recommend_tag);
            this.selectedIcon = (BdBaseImageView) itemView.findViewById(R.id.favor_folder_item_selected_icon);
        }

        public final BdBaseImageView getFolderIcon() {
            return this.folderIcon;
        }

        public final TextView getFolderTittle() {
            return this.folderTittle;
        }

        public final TextView getRecommendFolderTag() {
            return this.recommendFolderTag;
        }

        public final BdBaseImageView getSelectedIcon() {
            return this.selectedIcon;
        }

        public final void updateIconState(boolean isSelected) {
            if (isSelected) {
                BdBaseImageView bdBaseImageView = this.selectedIcon;
                if (bdBaseImageView != null) {
                    bdBaseImageView.setVisibility(0);
                    return;
                }
                return;
            }
            BdBaseImageView bdBaseImageView2 = this.selectedIcon;
            if (bdBaseImageView2 != null) {
                bdBaseImageView2.setVisibility(8);
            }
        }

        public final void updateTheme() {
            Context context = this.itemView.getContext();
            if (context != null) {
                TextView textView = this.folderTittle;
                if (textView != null) {
                    textView.setTextColor(ContextCompat.getColor(context, com.baidu.android.common.ui.style.R.color.GC1));
                }
                TextView textView2 = this.folderTittle;
                if (textView2 != null) {
                    textView2.setTypeface(Typeface.DEFAULT_BOLD);
                }
                TextView textView3 = this.recommendFolderTag;
                if (textView3 != null) {
                    textView3.setTextColor(ContextCompat.getColor(context, com.baidu.android.common.ui.style.R.color.GC7));
                }
                TextView textView4 = this.recommendFolderTag;
                if (textView4 != null) {
                    textView4.setBackground(ContextCompat.getDrawable(context, R.drawable.favor_folder_panel_recommend_tag_bg));
                }
                TextView textView5 = this.recommendFolderTag;
                Drawable background = textView5 != null ? textView5.getBackground() : null;
                if (background != null) {
                    background.setAlpha(128);
                }
                BdBaseImageView bdBaseImageView = this.selectedIcon;
                if (bdBaseImageView != null) {
                    bdBaseImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.favor_folder_selected));
                }
            }
        }

        public final void onFontSizeChanged() {
            TextView textView = this.folderTittle;
            if (textView != null) {
                FontSizeTextViewExtKt.setScaledSizeRes$default(textView, 1, com.baidu.android.common.ui.style.R.dimen.dimen_ui_15, 0, 4, (Object) null);
            }
            BdBaseImageView bdBaseImageView = this.folderIcon;
            if (bdBaseImageView != null) {
                FontSizeViewExtKt.setScaledSizeRes$default(bdBaseImageView, 1, com.baidu.android.common.ui.style.R.dimen.dimen_ui_26, com.baidu.android.common.ui.style.R.dimen.dimen_ui_26, 0, 8, (Object) null);
            }
            BdBaseImageView bdBaseImageView2 = this.selectedIcon;
            if (bdBaseImageView2 != null) {
                FontSizeViewExtKt.setScaledSizeRes$default(bdBaseImageView2, 1, com.baidu.android.common.ui.style.R.dimen.dimen_ui_12, com.baidu.android.common.ui.style.R.dimen.dimen_ui_8, 0, 8, (Object) null);
            }
            TextView textView2 = this.recommendFolderTag;
            if (textView2 != null) {
                textView2.setTextSize(FontSizeHelper.getScaledSize(1, 10.0f));
            }
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.favor_folder_panel_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(view2, "view");
        return new ViewHolder(view2);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        FavorPanelScene scene;
        FavorPanelSource source;
        Intrinsics.checkNotNullParameter(holder, "holder");
        String folderTitle = (String) CollectionsKt.getOrNull(getUserFolderList(), position);
        if (folderTitle != null) {
            holder.updateTheme();
            holder.onFontSizeChanged();
            updatePadding(holder, position);
            CharSequence charSequence = folderTitle;
            FavorModel favorModel2 = this.favorModel;
            String str = null;
            boolean z = false;
            if (TextUtils.equals(charSequence, favorModel2 != null ? favorModel2.parent : null)) {
                BdBaseImageView selectedIcon = holder.getSelectedIcon();
                if (selectedIcon != null) {
                    selectedIcon.setVisibility(0);
                }
            } else {
                BdBaseImageView selectedIcon2 = holder.getSelectedIcon();
                if (selectedIcon2 != null) {
                    selectedIcon2.setVisibility(8);
                }
            }
            BdBaseImageView folderIcon = holder.getFolderIcon();
            Context context = folderIcon != null ? folderIcon.getContext() : null;
            if (context != null) {
                if (position != 0 || !this.hasRecommend) {
                    TextView recommendFolderTag = holder.getRecommendFolderTag();
                    if (recommendFolderTag != null) {
                        recommendFolderTag.setVisibility(8);
                    }
                    holder.getFolderIcon().setImageDrawable(ContextCompat.getDrawable(context, R.drawable.favor_folder_user));
                } else {
                    TextView recommendFolderTag2 = holder.getRecommendFolderTag();
                    if (recommendFolderTag2 != null) {
                        recommendFolderTag2.setVisibility(0);
                    }
                    holder.getFolderIcon().setImageDrawable(ContextCompat.getDrawable(context, R.drawable.favor_folder_recommend));
                }
                holder.itemView.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.favor_panel_item_bg_selector));
                TextView folderTittle = holder.getFolderTittle();
                if (folderTittle != null) {
                    folderTittle.setText(folderTitle);
                }
                CharSequence charSequence2 = folderTitle;
                FavorModel favorModel3 = this.favorModel;
                if ((TextUtils.equals(charSequence2, favorModel3 != null ? favorModel3.parent : null) && !this.hasClicked) || position == this.selectedPosition) {
                    z = true;
                }
                boolean isSelected = z;
                if (isSelected) {
                    this.selectedPosition = position;
                }
                holder.updateIconState(isSelected);
                holder.itemView.setOnClickListener(new FavorFolderAdapter$$ExternalSyntheticLambda0(this, folderTitle, position));
                if (!getUbcShowList().contains(folderTitle)) {
                    String ext = getUbcExt(folderTitle);
                    FavorPanelModel favorPanelModel = this.panelModel;
                    String source2 = (favorPanelModel == null || (source = favorPanelModel.getSource()) == null) ? null : source.getSource();
                    FavorPanelModel favorPanelModel2 = this.panelModel;
                    if (!(favorPanelModel2 == null || (scene = favorPanelModel2.getScene()) == null)) {
                        str = scene.getScene();
                    }
                    UserAssetsAggrUbc.event(source2, "show", str, "", UserAssetsAggrUbc.VALUE_ADD_FOLDER, ext);
                    getUbcShowList().add(folderTitle);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
        r1 = r1.getSource();
     */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m18375onBindViewHolder$lambda0(com.baidu.searchbox.favor.view.FavorFolderAdapter r8, java.lang.String r9, int r10, android.view.View r11) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "$folderTitle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = r8.getUbcExt(r9)
            com.baidu.searchbox.favor.model.FavorPanelModel r1 = r8.panelModel
            r7 = 0
            if (r1 == 0) goto L_0x001f
            com.baidu.searchbox.favor.model.FavorPanelSource r1 = r1.getSource()
            if (r1 == 0) goto L_0x001f
            java.lang.String r1 = r1.getSource()
            goto L_0x0020
        L_0x001f:
            r1 = r7
        L_0x0020:
            com.baidu.searchbox.favor.model.FavorPanelModel r2 = r8.panelModel
            if (r2 == 0) goto L_0x0030
            com.baidu.searchbox.favor.model.FavorPanelScene r2 = r2.getScene()
            if (r2 == 0) goto L_0x0030
            java.lang.String r2 = r2.getScene()
            r3 = r2
            goto L_0x0031
        L_0x0030:
            r3 = r7
        L_0x0031:
            java.lang.String r2 = "click"
            java.lang.String r4 = ""
            java.lang.String r5 = "add_folder"
            r6 = r0
            com.baidu.searchbox.userassetsaggr.container.ubc.UserAssetsAggrUbc.event(r1, r2, r3, r4, r5, r6)
            r1 = 1
            r8.hasClicked = r1
            int r1 = r8.selectedPosition
            r8.selectedPosition = r10
            r8.notifyItemChanged(r1)
            int r2 = r8.selectedPosition
            r8.notifyItemChanged(r2)
            com.baidu.searchbox.favor.data.FavorModel r2 = r8.favorModel
            if (r2 == 0) goto L_0x0050
            java.lang.String r7 = r2.parent
        L_0x0050:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r2 = r9
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.equals(r7, r2)
            if (r2 == 0) goto L_0x0073
            boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r2 == 0) goto L_0x0069
            java.lang.String r2 = "FavorFolderAdapter"
            java.lang.String r3 = "点击相同文件夹: "
            android.util.Log.d(r2, r3)
        L_0x0069:
            com.baidu.searchbox.favor.view.FavorFolderAdapter$FolderItemListener r2 = r8.itemListener
            if (r2 == 0) goto L_0x0072
            java.lang.String r3 = ""
            r2.onMoveFolder(r3)
        L_0x0072:
            return
        L_0x0073:
            boolean r2 = r8.hasRecommend
            if (r2 == 0) goto L_0x0086
            if (r10 != 0) goto L_0x0086
            com.baidu.searchbox.favor.util.FavorFolderPanelUtils r2 = com.baidu.searchbox.favor.util.FavorFolderPanelUtils.INSTANCE
            com.baidu.searchbox.favor.view.FavorFolderAdapter$onBindViewHolder$1$1 r3 = new com.baidu.searchbox.favor.view.FavorFolderAdapter$onBindViewHolder$1$1
            r3.<init>(r8, r9)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r2.submit(r9, r3)
            return
        L_0x0086:
            r8.moveToFolder(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.favor.view.FavorFolderAdapter.m18375onBindViewHolder$lambda0(com.baidu.searchbox.favor.view.FavorFolderAdapter, java.lang.String, int, android.view.View):void");
    }

    private final void updatePadding(ViewHolder holder, int position) {
        float paddingDp;
        int paddingPxTop = DeviceUtils.ScreenInfo.dp2px(holder.itemView.getContext(), 11.0f);
        int paddingPxBottom = DeviceUtils.ScreenInfo.dp2px(holder.itemView.getContext(), 11.0f);
        if (getItemCount() == 1) {
            paddingDp = 2.0f;
        } else {
            paddingDp = 5.0f;
        }
        int paddingPx = DeviceUtils.ScreenInfo.dp2px(holder.itemView.getContext(), paddingDp);
        int paddingTop = paddingPxTop;
        int paddingBottom = paddingPxBottom;
        int paddingLeft = holder.itemView.getPaddingLeft();
        int paddingRight = holder.itemView.getPaddingRight();
        if (position == 0) {
            paddingTop = paddingPxTop + paddingPx;
        }
        if (position == getItemCount() - 1) {
            paddingBottom = paddingPxBottom + paddingPx;
        }
        holder.itemView.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    /* access modifiers changed from: private */
    public final void moveToFolder(String folderTitle) {
        FavorFolderPanelUtils.INSTANCE.updateSelectedFavorsDirAsync(this.favorModel, folderTitle, new FavorFolderAdapter$moveToFolder$1(this, folderTitle));
    }

    private final String getUbcExt(String folderTitle) {
        JSONObject extJson;
        try {
            FavorPanelModel favorPanelModel = this.panelModel;
            JSONObject ext = favorPanelModel != null ? favorPanelModel.getUbcExt() : null;
            if (ext != null) {
                extJson = new JSONObject(ext.toString());
            } else {
                extJson = new JSONObject();
            }
            FavorPanelModel favorPanelModel2 = this.panelModel;
            if (TextUtils.equals(favorPanelModel2 != null ? favorPanelModel2.getRecommendFolder() : null, folderTitle)) {
                extJson.put(UserAssetsAggrUbc.EXT_KEY_IS_RECOMMEND_FOLDER, "1");
            } else {
                extJson.put(UserAssetsAggrUbc.EXT_KEY_IS_RECOMMEND_FOLDER, "0");
            }
            extJson.put(UserAssetsAggrUbc.EXT_KEY_FOLD_NAME, folderTitle);
            return extJson.toString();
        } catch (Exception e2) {
            if (AppConfig.isDebug()) {
                Log.d("FavorFolderAdapter", "getUbcExt: " + e2);
            }
            return null;
        }
    }

    public int getItemCount() {
        return getUserFolderList().size();
    }

    public final void setUserFolderData(List<String> list) {
        getUserFolderList().clear();
        if (list != null) {
            List<String> list2 = list;
            getUserFolderList().addAll(list);
        }
        addRecommendItem();
    }

    public final void setFavorPanelModel(FavorPanelModel model) {
        this.panelModel = model;
    }

    public final void setFavorModel(FavorModel model) {
        this.favorModel = model;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void addRecommendItem() {
        /*
            r5 = this;
            com.baidu.searchbox.favor.model.FavorPanelModel r0 = r5.panelModel
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001b
            java.lang.String r0 = r0.getRecommendFolder()
            if (r0 == 0) goto L_0x001b
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0016
            r0 = r1
            goto L_0x0017
        L_0x0016:
            r0 = r2
        L_0x0017:
            if (r0 != r1) goto L_0x001b
            r0 = r1
            goto L_0x001c
        L_0x001b:
            r0 = r2
        L_0x001c:
            if (r0 == 0) goto L_0x0056
            java.util.List r0 = r5.getUserFolderList()
            com.baidu.searchbox.favor.data.FavorModel r3 = r5.favorModel
            r4 = 0
            if (r3 == 0) goto L_0x002a
            java.lang.String r3 = r3.parent
            goto L_0x002b
        L_0x002a:
            r3 = r4
        L_0x002b:
            boolean r0 = r0.contains(r3)
            if (r0 != 0) goto L_0x0056
            java.util.List r0 = r5.getUserFolderList()
            com.baidu.searchbox.favor.model.FavorPanelModel r3 = r5.panelModel
            if (r3 == 0) goto L_0x003e
            java.lang.String r3 = r3.getRecommendFolder()
            goto L_0x003f
        L_0x003e:
            r3 = r4
        L_0x003f:
            boolean r0 = r0.contains(r3)
            if (r0 != 0) goto L_0x0056
            java.util.List r0 = r5.getUserFolderList()
            com.baidu.searchbox.favor.model.FavorPanelModel r3 = r5.panelModel
            if (r3 == 0) goto L_0x0051
            java.lang.String r4 = r3.getRecommendFolder()
        L_0x0051:
            r0.add(r2, r4)
            r5.hasRecommend = r1
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.favor.view.FavorFolderAdapter.addRecommendItem():void");
    }

    public final void setFolderItemListener(FolderItemListener listener) {
        this.itemListener = listener;
    }
}
