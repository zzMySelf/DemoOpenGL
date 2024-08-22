package com.baidu.searchbox.dynamicpublisher.location;

import com.baidu.searchbox.dynamicpublisher.location.LocationAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.ugc.location.LocationView;
import com.baidu.ugc.position.model.LocationModel;
import com.baidu.ugc.position.model.PoiModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u000b\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\r\u0010\u0002R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0018j\b\u0012\u0004\u0012\u00020\u0016`\u0019X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001a\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001b\u0010\b¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/location/LocationComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "()V", "isLocated", "", "isLocatedByUser", "isShownPlacePoi", "isSupportLocationModify", "()Z", "isSupportLocationModify$delegate", "Lkotlin/Lazy;", "locGuideType", "", "getLocGuideType$annotations", "locationModel", "Lcom/baidu/ugc/position/model/LocationModel;", "locationView", "Lcom/baidu/searchbox/ugc/location/LocationView;", "getLocationView", "()Lcom/baidu/searchbox/ugc/location/LocationView;", "locationView$delegate", "poiModel", "Lcom/baidu/ugc/position/model/PoiModel;", "recommendPoiList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "secondEdit", "getSecondEdit", "secondEdit$delegate", "createView", "onAttachToManager", "", "refreshLoc", "selectedLoc", "Lcom/baidu/searchbox/dynamicpublisher/location/SelectedLocModel;", "showLocGuideIfNeed", "showRecommendLoc", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LocationComponent.kt */
public final class LocationComponent extends LiveDataComponent {
    /* access modifiers changed from: private */
    public boolean isLocated;
    /* access modifiers changed from: private */
    public boolean isLocatedByUser;
    /* access modifiers changed from: private */
    public boolean isShownPlacePoi;
    private final Lazy isSupportLocationModify$delegate = LazyKt.lazy(new LocationComponent$isSupportLocationModify$2(this));
    private int locGuideType;
    private LocationModel locationModel;
    private final Lazy locationView$delegate = LazyKt.lazy(new LocationComponent$locationView$2(this));
    /* access modifiers changed from: private */
    public PoiModel poiModel;
    /* access modifiers changed from: private */
    public final ArrayList<PoiModel> recommendPoiList = new ArrayList<>();
    private final Lazy secondEdit$delegate = LazyKt.lazy(new LocationComponent$secondEdit$2(this));

    @LocGuideType
    private static /* synthetic */ void getLocGuideType$annotations() {
    }

    /* access modifiers changed from: private */
    public final boolean getSecondEdit() {
        return ((Boolean) this.secondEdit$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    public final boolean isSupportLocationModify() {
        return ((Boolean) this.isSupportLocationModify$delegate.getValue()).booleanValue();
    }

    private final LocationView getLocationView() {
        return (LocationView) this.locationView$delegate.getValue();
    }

    public LocationView createView() {
        return getLocationView();
    }

    public void onAttachToManager() {
        LocationState $this$onAttachToManager_u24lambda_u2d8;
        super.onAttachToManager();
        Store<AbsState> store = getStore();
        if (store != null && ($this$onAttachToManager_u24lambda_u2d8 = (LocationState) store.subscribe((Class<T>) LocationState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d8.getHideLocationView().observe(this, new LocationComponent$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d8.getSelectedLocModel().observe(this, new LocationComponent$$ExternalSyntheticLambda1(this));
            $this$onAttachToManager_u24lambda_u2d8.getRecommendPoiList().observe(this, new LocationComponent$$ExternalSyntheticLambda2(this));
            $this$onAttachToManager_u24lambda_u2d8.getPlacePoiModel().observe(this, new LocationComponent$$ExternalSyntheticLambda3(this));
            $this$onAttachToManager_u24lambda_u2d8.getGuideType().observe(this, new LocationComponent$$ExternalSyntheticLambda4(this));
            $this$onAttachToManager_u24lambda_u2d8.getCollection().observe(this, new LocationComponent$$ExternalSyntheticLambda5(this));
            $this$onAttachToManager_u24lambda_u2d8.getRestoration().observe(this, new LocationComponent$$ExternalSyntheticLambda6(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8$lambda-0  reason: not valid java name */
    public static final void m18121onAttachToManager$lambda8$lambda0(LocationComponent this$0, Boolean isHideLocationView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LocationView locationView = this$0.getLocationView();
        Intrinsics.checkNotNullExpressionValue(isHideLocationView, "isHideLocationView");
        locationView.setVisibility(isHideLocationView.booleanValue() ? 8 : 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8$lambda-1  reason: not valid java name */
    public static final void m18122onAttachToManager$lambda8$lambda1(LocationComponent this$0, SelectedLocModel selectedLoc) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.refreshLoc(selectedLoc);
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8$lambda-3  reason: not valid java name */
    public static final void m18123onAttachToManager$lambda8$lambda3(LocationComponent this$0, ArrayList poiList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.recommendPoiList.clear();
        Collection collection = poiList;
        if (collection == null || collection.isEmpty()) {
            this$0.getLocationView().hideRecommendLoc();
            this$0.showLocGuideIfNeed();
            return;
        }
        Iterator it = poiList.iterator();
        while (it.hasNext()) {
            this$0.recommendPoiList.add((PoiModel) it.next());
        }
        this$0.showRecommendLoc();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8$lambda-4  reason: not valid java name */
    public static final void m18124onAttachToManager$lambda8$lambda4(LocationComponent this$0, PoiModel poi) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (poi != null) {
            boolean z = true;
            this$0.isLocated = true;
            this$0.isShownPlacePoi = true;
            this$0.poiModel = poi;
            LocationView locationView = this$0.getLocationView();
            if (!this$0.getSecondEdit() && !this$0.isSupportLocationModify()) {
                z = false;
            }
            locationView.showDefaultLoc(poi, z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8$lambda-5  reason: not valid java name */
    public static final void m18125onAttachToManager$lambda8$lambda5(LocationComponent this$0, Integer type) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(type, "type");
        this$0.locGuideType = type.intValue();
        this$0.showLocGuideIfNeed();
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8$lambda-6  reason: not valid java name */
    public static final void m18126onAttachToManager$lambda8$lambda6(LocationComponent this$0, Unit it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Store<AbsState> store = this$0.getStore();
        if (store != null) {
            store.dispatch(new LocationAction.SendData(new SelectedLocModel(this$0.locationModel, this$0.poiModel)));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-8$lambda-7  reason: not valid java name */
    public static final void m18127onAttachToManager$lambda8$lambda7(LocationComponent this$0, SelectedLocModel selectedLoc) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.refreshLoc(selectedLoc);
    }

    private final void refreshLoc(SelectedLocModel selectedLoc) {
        if (selectedLoc != null && selectedLoc.getLocationModel() != null && selectedLoc.getPoiModel() != null) {
            if (selectedLoc.getPoiModel().type == 1) {
                this.isLocated = false;
                showLocGuideIfNeed();
                return;
            }
            this.isLocated = true;
            this.locationModel = selectedLoc.getLocationModel();
            this.poiModel = selectedLoc.getPoiModel();
            LocationView.showLocDetail$default(getLocationView(), this.poiModel, false, 2, (Object) null);
        }
    }

    private final void showRecommendLoc() {
        Collection collection = this.recommendPoiList;
        if (!(collection == null || collection.isEmpty())) {
            getLocationView().showRecommendLoc(this.recommendPoiList);
            Store<AbsState> store = getStore();
            if (store != null) {
                store.dispatch(LocationAction.RecommendPoiShown.INSTANCE);
            }
            if (!this.isLocatedByUser) {
                LocationModel locationModel2 = new LocationModel();
                LocationModel $this$showRecommendLoc_u24lambda_u2d9 = locationModel2;
                $this$showRecommendLoc_u24lambda_u2d9.city = this.recommendPoiList.get(0).city;
                $this$showRecommendLoc_u24lambda_u2d9.latitude = this.recommendPoiList.get(0).latitude;
                $this$showRecommendLoc_u24lambda_u2d9.longitude = this.recommendPoiList.get(0).longitude;
                $this$showRecommendLoc_u24lambda_u2d9.poiName = this.recommendPoiList.get(0).name;
                this.locationModel = locationModel2;
                this.poiModel = this.recommendPoiList.get(0);
                getLocationView().showLocDetail(this.poiModel, true);
            }
        }
    }

    private final void showLocGuideIfNeed() {
        if (!this.isLocated) {
            this.locationModel = null;
            this.poiModel = null;
            getLocationView().hideLocDetail();
            if (this.locGuideType == 0) {
                getLocationView().showCurrentLocGuide();
            } else {
                getLocationView().showCaptureLocGuide();
            }
        }
    }
}
