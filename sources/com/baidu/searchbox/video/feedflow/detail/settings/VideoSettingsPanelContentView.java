package com.baidu.searchbox.video.feedflow.detail.settings;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.MenuListItemDecoration;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.adapter.IMoreBottomListener;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.adapter.MoreBottomAdapter;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.adapter.MoreBottomAdapterKt;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.model.MoreMenuBottomItemModel;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.model.MoreSmartPlayModel;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.view.ISmartPlayViewListener;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.view.SmartPlayOptimizedView;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.view.SmartPlayView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0007J \u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020'H\u0007J\u0016\u0010(\u001a\u00020 2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020 J\u0010\u0010,\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0007H\u0007J\u000e\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020\u0007J\u0006\u0010/\u001a\u00020 R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/settings/VideoSettingsPanelContentView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomAdapter", "Lcom/baidu/searchbox/video/feedflow/detail/longpressmore/adapter/MoreBottomAdapter;", "iMoreVideoSettingViewListener", "Lcom/baidu/searchbox/video/feedflow/detail/settings/IMoreVideoSettingViewListener;", "getIMoreVideoSettingViewListener", "()Lcom/baidu/searchbox/video/feedflow/detail/settings/IMoreVideoSettingViewListener;", "setIMoreVideoSettingViewListener", "(Lcom/baidu/searchbox/video/feedflow/detail/settings/IMoreVideoSettingViewListener;)V", "listItemDecoration", "Lcom/baidu/searchbox/video/feedflow/detail/longpressmore/MenuListItemDecoration;", "getListItemDecoration", "()Lcom/baidu/searchbox/video/feedflow/detail/longpressmore/MenuListItemDecoration;", "listItemDecoration$delegate", "Lkotlin/Lazy;", "optimizedSmartPlayView", "Lcom/baidu/searchbox/video/feedflow/detail/longpressmore/view/SmartPlayOptimizedView;", "rvBottom", "Landroidx/recyclerview/widget/RecyclerView;", "smartPlayView", "Lcom/baidu/searchbox/video/feedflow/detail/longpressmore/view/SmartPlayView;", "svContainer", "Landroidx/core/widget/NestedScrollView;", "bindData", "", "model", "Lcom/baidu/searchbox/video/feedflow/detail/settings/VideoSettingsOptionPanelModel;", "insertItemInBottomAdapter", "itemType", "lastItemType", "itemModel", "Lcom/baidu/searchbox/video/feedflow/detail/longpressmore/model/MoreMenuBottomItemModel;", "refreshBottomItemView", "checked", "", "release", "removeItemInBottomAdapter", "scrollToPositionInBottom", "position", "updateSkin", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoSettingsPanelContentView.kt */
public final class VideoSettingsPanelContentView extends LinearLayout {
    private final MoreBottomAdapter bottomAdapter;
    private IMoreVideoSettingViewListener iMoreVideoSettingViewListener;
    private final Lazy listItemDecoration$delegate;
    private final SmartPlayOptimizedView optimizedSmartPlayView;
    private final RecyclerView rvBottom;
    private final SmartPlayView smartPlayView;
    private final NestedScrollView svContainer;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VideoSettingsPanelContentView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VideoSettingsPanelContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoSettingsPanelContentView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoSettingsPanelContentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.listItemDecoration$delegate = BdPlayerUtils.lazyNone(new VideoSettingsPanelContentView$listItemDecoration$2(context));
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.video_flow_settings_option_panel_layout, this);
        View findViewById = findViewById(R.id.sv_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.sv_container)");
        this.svContainer = (NestedScrollView) findViewById;
        View findViewById2 = findViewById(R.id.rv_bottom);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.rv_bottom)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.rvBottom = recyclerView;
        View findViewById3 = findViewById(R.id.smart_play_set);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.smart_play_set)");
        SmartPlayView smartPlayView2 = (SmartPlayView) findViewById3;
        this.smartPlayView = smartPlayView2;
        View findViewById4 = findViewById(R.id.smart_play_optimized_set);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.smart_play_optimized_set)");
        SmartPlayOptimizedView smartPlayOptimizedView = (SmartPlayOptimizedView) findViewById4;
        this.optimizedSmartPlayView = smartPlayOptimizedView;
        smartPlayOptimizedView.setVisibility(8);
        smartPlayView2.setVisibility(8);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        MoreBottomAdapter moreBottomAdapter = new MoreBottomAdapter(new ArrayList());
        this.bottomAdapter = moreBottomAdapter;
        moreBottomAdapter.setIMoreBottomListener(new IMoreBottomListener(this) {
            final /* synthetic */ VideoSettingsPanelContentView this$0;

            {
                this.this$0 = $receiver;
            }

            public void onBottomItemCheckChanged(int itemType, boolean checked) {
                IMoreVideoSettingViewListener iMoreVideoSettingViewListener = this.this$0.getIMoreVideoSettingViewListener();
                if (iMoreVideoSettingViewListener != null) {
                    iMoreVideoSettingViewListener.onBottomItemCheckChanged(itemType, checked);
                }
            }

            public void onBottomItemClicked(int itemType) {
                IMoreVideoSettingViewListener iMoreVideoSettingViewListener = this.this$0.getIMoreVideoSettingViewListener();
                if (iMoreVideoSettingViewListener != null) {
                    iMoreVideoSettingViewListener.onBottomItemClicked(itemType);
                }
            }
        });
        smartPlayView2.setISmartPlayViewListener(new ISmartPlayViewListener(this) {
            final /* synthetic */ VideoSettingsPanelContentView this$0;

            {
                this.this$0 = $receiver;
            }

            public void onSmartPlayViewClickChanged(int clickBeforePosition, int clickPosition) {
                IMoreVideoSettingViewListener iMoreVideoSettingViewListener = this.this$0.getIMoreVideoSettingViewListener();
                if (iMoreVideoSettingViewListener != null) {
                    iMoreVideoSettingViewListener.onSmartPlayViewClickChanged(clickBeforePosition, clickPosition);
                }
            }
        });
        smartPlayOptimizedView.setISmartPlayViewListener(new ISmartPlayViewListener(this) {
            final /* synthetic */ VideoSettingsPanelContentView this$0;

            {
                this.this$0 = $receiver;
            }

            public void onSmartPlayViewClickChanged(int clickBeforePosition, int clickPosition) {
                IMoreVideoSettingViewListener iMoreVideoSettingViewListener = this.this$0.getIMoreVideoSettingViewListener();
                if (iMoreVideoSettingViewListener != null) {
                    iMoreVideoSettingViewListener.onSmartPlayViewClickChanged(clickBeforePosition, clickPosition);
                }
            }
        });
        recyclerView.setAdapter(moreBottomAdapter);
        recyclerView.addItemDecoration(getListItemDecoration());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public final IMoreVideoSettingViewListener getIMoreVideoSettingViewListener() {
        return this.iMoreVideoSettingViewListener;
    }

    public final void setIMoreVideoSettingViewListener(IMoreVideoSettingViewListener iMoreVideoSettingViewListener2) {
        this.iMoreVideoSettingViewListener = iMoreVideoSettingViewListener2;
    }

    private final MenuListItemDecoration getListItemDecoration() {
        return (MenuListItemDecoration) this.listItemDecoration$delegate.getValue();
    }

    public final void bindData(VideoSettingsOptionPanelModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        MoreSmartPlayModel smartPlayData = model.getSmartPlayData();
        boolean z = true;
        if (smartPlayData == null || !smartPlayData.getOptimizeSwitch()) {
            z = false;
        }
        if (z) {
            this.optimizedSmartPlayView.resetSliders();
            this.optimizedSmartPlayView.bindData(model.getSmartPlayData());
        } else {
            this.optimizedSmartPlayView.setVisibility(8);
            this.smartPlayView.resetSliders();
            this.smartPlayView.bindData(model.getSmartPlayData());
        }
        this.bottomAdapter.getData().clear();
        List<MoreMenuBottomItemModel> data = this.bottomAdapter.getData();
        List<MoreMenuBottomItemModel> bottomData = model.getBottomData();
        if (bottomData == null) {
            bottomData = CollectionsKt.emptyList();
        }
        data.addAll(bottomData);
        this.bottomAdapter.notifyDataSetChanged();
    }

    public final void refreshBottomItemView(int itemType, boolean checked) {
        this.bottomAdapter.refreshItemView(itemType, checked);
    }

    public final void updateSkin() {
        getListItemDecoration().updateNight();
        this.smartPlayView.updateSkin(false);
        this.optimizedSmartPlayView.updateSkin(true);
    }

    public final void release() {
        this.iMoreVideoSettingViewListener = null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.baidu.searchbox.video.feedflow.detail.longpressmore.model.MoreMenuBottomItemModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.baidu.searchbox.video.feedflow.detail.longpressmore.model.MoreMenuBottomItemModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.baidu.searchbox.video.feedflow.detail.longpressmore.model.MoreMenuBottomItemModel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.baidu.searchbox.video.feedflow.detail.longpressmore.model.MoreMenuBottomItemModel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int insertItemInBottomAdapter(int r9, int r10, com.baidu.searchbox.video.feedflow.detail.longpressmore.model.MoreMenuBottomItemModel r11) {
        /*
            r8 = this;
            java.lang.String r0 = "itemModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            com.baidu.searchbox.video.feedflow.detail.longpressmore.adapter.MoreBottomAdapter r0 = r8.bottomAdapter
            java.util.List r0 = r0.getData()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0011:
            boolean r1 = r0.hasNext()
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x002e
            java.lang.Object r1 = r0.next()
            r5 = r1
            com.baidu.searchbox.video.feedflow.detail.longpressmore.model.MoreMenuBottomItemModel r5 = (com.baidu.searchbox.video.feedflow.detail.longpressmore.model.MoreMenuBottomItemModel) r5
            r6 = 0
            int r7 = r5.getItemType()
            if (r7 != r9) goto L_0x002a
            r5 = r4
            goto L_0x002b
        L_0x002a:
            r5 = r2
        L_0x002b:
            if (r5 == 0) goto L_0x0011
            goto L_0x002f
        L_0x002e:
            r1 = r3
        L_0x002f:
            if (r1 == 0) goto L_0x0033
            r0 = -1
            return r0
        L_0x0033:
            com.baidu.searchbox.video.feedflow.detail.longpressmore.adapter.MoreBottomAdapter r0 = r8.bottomAdapter
            java.util.List r0 = r0.getData()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x003f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0059
            java.lang.Object r1 = r0.next()
            r5 = r1
            com.baidu.searchbox.video.feedflow.detail.longpressmore.model.MoreMenuBottomItemModel r5 = (com.baidu.searchbox.video.feedflow.detail.longpressmore.model.MoreMenuBottomItemModel) r5
            r6 = 0
            int r7 = r5.getItemType()
            if (r7 != r10) goto L_0x0055
            r5 = r4
            goto L_0x0056
        L_0x0055:
            r5 = r2
        L_0x0056:
            if (r5 == 0) goto L_0x003f
            r3 = r1
        L_0x0059:
            r0 = r3
            com.baidu.searchbox.video.feedflow.detail.longpressmore.model.MoreMenuBottomItemModel r0 = (com.baidu.searchbox.video.feedflow.detail.longpressmore.model.MoreMenuBottomItemModel) r0
            com.baidu.searchbox.video.feedflow.detail.longpressmore.adapter.MoreBottomAdapter r1 = r8.bottomAdapter
            java.util.List r1 = r1.getData()
            int r1 = kotlin.collections.CollectionsKt.indexOf(r1, r0)
            com.baidu.searchbox.video.feedflow.detail.longpressmore.adapter.MoreBottomAdapter r2 = r8.bottomAdapter
            int r3 = r1 + 1
            com.baidu.searchbox.video.feedflow.detail.longpressmore.adapter.MoreBottomAdapterKt.addDataAndNotify(r2, r3, r11)
            int r2 = r1 + 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.settings.VideoSettingsPanelContentView.insertItemInBottomAdapter(int, int, com.baidu.searchbox.video.feedflow.detail.longpressmore.model.MoreMenuBottomItemModel):int");
    }

    public final void removeItemInBottomAdapter(int itemType) {
        Object obj;
        boolean z;
        Iterator it = this.bottomAdapter.getData().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((MoreMenuBottomItemModel) obj).getItemType() == itemType) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        MoreMenuBottomItemModel itemModel = (MoreMenuBottomItemModel) obj;
        if (itemModel != null) {
            MoreBottomAdapterKt.removeDataAndNotify(this.bottomAdapter, itemModel);
        }
    }

    public final void scrollToPositionInBottom(int position) {
        RecyclerView.LayoutManager layoutManager = this.rvBottom.getLayoutManager();
        if (layoutManager != null) {
            View view2 = ((LinearLayoutManager) layoutManager).findViewByPosition(position);
            if (view2 != null) {
                Rect rvBottomRect = new Rect();
                this.rvBottom.getLocalVisibleRect(rvBottomRect);
                int showHeight = rvBottomRect.height();
                if (view2.getY() + ((float) view2.getHeight()) > ((float) showHeight)) {
                    this.svContainer.scrollBy(0, (int) ((view2.getY() + ((float) view2.getHeight())) - ((float) showHeight)));
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    }
}
