package com.baidu.searchbox.player.layer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import com.baidu.searchbox.player.slot.ISlot;
import com.baidu.searchbox.player.utils.LayerUtil;
import com.baidu.titan.sdk.common.TitanConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u000e\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\fJ&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u000e\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f2\u0006\u0010\u0011\u001a\u00020\u0007J&\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u000e\u0010\u0010\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f2\u0006\u0010\u0013\u001a\u00020\u000bJ\u0018\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000bJ\b\u0010\u0019\u001a\u00020\u000eH\u0016J\"\u0010\u001a\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u0017R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\f0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/player/layer/VulcanLayerContainer;", "Lcom/baidu/searchbox/player/layer/LayerContainer;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vulcanLayerMap", "Landroidx/collection/SimpleArrayMap;", "Lcom/baidu/searchbox/player/slot/ISlot;", "Lcom/baidu/searchbox/player/layer/ElementLayer;", "addVulcanLayer", "", "layerId", "layer", "index", "addVulcanLayerAboveToTarget", "targetId", "detachLayer", "Lcom/baidu/searchbox/player/layer/AbsLayer;", "isUnregister", "", "getVulcanLayer", "release", "removeVulcanLayer", "business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VulcanLayerContainer.kt */
public final class VulcanLayerContainer extends LayerContainer {
    public Map<Integer, View> _$_findViewCache;
    private final SimpleArrayMap<ISlot, ElementLayer<?, ?>> vulcanLayerMap;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VulcanLayerContainer(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VulcanLayerContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

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
    public VulcanLayerContainer(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.vulcanLayerMap = new SimpleArrayMap<>();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VulcanLayerContainer(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final void addVulcanLayer(ISlot layerId, ElementLayer<?, ?> layer) {
        Intrinsics.checkNotNullParameter(layerId, "layerId");
        Intrinsics.checkNotNullParameter(layer, "layer");
        if (addLayer(layer, getContainerParams())) {
            this.vulcanLayerMap.put(layerId, layer);
        }
    }

    public final void addVulcanLayer(ISlot layerId, ElementLayer<?, ?> layer, int index) {
        Intrinsics.checkNotNullParameter(layerId, "layerId");
        Intrinsics.checkNotNullParameter(layer, "layer");
        if (!getLayerList().contains(layer) && index < getLayerList().size()) {
            layer.setLayerContainer(this);
            if (!layer.isInitialized()) {
                layer.initLayer();
            }
            layer.attachMessenger(getBindPlayer().getMessenger());
            getLayerList().add(index, layer);
            addView(layer.getContentView(), index, getContainerParams());
            this.vulcanLayerMap.put(layerId, layer);
        }
    }

    public final void addVulcanLayerAboveToTarget(ISlot layerId, ElementLayer<?, ?> layer, ISlot targetId) {
        int targetIndex;
        Intrinsics.checkNotNullParameter(layerId, "layerId");
        Intrinsics.checkNotNullParameter(layer, "layer");
        Intrinsics.checkNotNullParameter(targetId, TitanConstant.PatchInfoConstant.KEY_TARGET_ID);
        int targetIndex2 = LayerUtil.layerIndexOf(this, targetId);
        if (targetIndex2 == -1) {
            targetIndex = getLayerList().size();
        } else {
            targetIndex = targetIndex2 + 1;
        }
        addVulcanLayer(layerId, layer, targetIndex);
    }

    public static /* synthetic */ ElementLayer removeVulcanLayer$default(VulcanLayerContainer vulcanLayerContainer, ISlot iSlot, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return vulcanLayerContainer.removeVulcanLayer(iSlot, z);
    }

    public final ElementLayer<?, ?> removeVulcanLayer(ISlot layerId, boolean isUnregister) {
        Intrinsics.checkNotNullParameter(layerId, "layerId");
        ElementLayer it = this.vulcanLayerMap.remove(layerId);
        if (it == null) {
            return null;
        }
        super.detachLayer((AbsLayer) it, isUnregister);
        return it;
    }

    public final ElementLayer<?, ?> getVulcanLayer(ISlot layerId) {
        Intrinsics.checkNotNullParameter(layerId, "layerId");
        return this.vulcanLayerMap.get(layerId);
    }

    public void detachLayer(AbsLayer layer, boolean isUnregister) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        super.detachLayer(layer, isUnregister);
        if (layer instanceof ElementLayer) {
            SimpleArrayMap<ISlot, ElementLayer<?, ?>> simpleArrayMap = this.vulcanLayerMap;
            simpleArrayMap.remove(LayerUtil.getLayerId(simpleArrayMap, (ElementLayer) layer));
        }
    }

    public void release() {
        super.release();
        this.vulcanLayerMap.clear();
    }
}
