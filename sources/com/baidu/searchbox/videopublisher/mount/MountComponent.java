package com.baidu.searchbox.videopublisher.mount;

import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.feed.detail.livedata.LiveDataComponent;
import com.baidu.searchbox.ugc.model.MountModel;
import com.baidu.searchbox.ugc.model.UgcMountData;
import com.baidu.searchbox.ugc.model.UgcMountDataKt;
import com.baidu.searchbox.ugc.mount.MountData;
import com.baidu.searchbox.ugc.mount.MountDataCaaBack;
import com.baidu.searchbox.ugc.mount.MountList;
import com.baidu.searchbox.ugc.mount.MountListActivity;
import com.baidu.searchbox.ugc.utils.GsonManager;
import com.baidu.searchbox.videopublisher.PublishModel;
import com.baidu.searchbox.videopublisher.PublisherCoreState;
import com.baidu.searchbox.videopublisher.draft.DraftState;
import com.baidu.searchbox.videopublisher.publish.PublishState;
import com.google.gson.Gson;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/videopublisher/mount/MountComponent;", "Lcom/baidu/searchbox/feed/detail/livedata/LiveDataComponent;", "Landroid/view/View$OnClickListener;", "Lcom/baidu/searchbox/ugc/mount/MountDataCaaBack;", "()V", "isMountLoading", "", "mountView", "Lcom/baidu/searchbox/videopublisher/mount/MountView;", "getMountView", "()Lcom/baidu/searchbox/videopublisher/mount/MountView;", "mountView$delegate", "Lkotlin/Lazy;", "ugcMountData", "Lcom/baidu/searchbox/ugc/model/UgcMountData;", "createView", "Landroid/view/View;", "initMountView", "onAttachToManager", "", "onClick", "v", "onMountData", "mountData", "Lcom/baidu/searchbox/ugc/mount/MountData;", "lib-publisher-video_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MountComponent.kt */
public final class MountComponent extends LiveDataComponent implements View.OnClickListener, MountDataCaaBack {
    private boolean isMountLoading;
    private final Lazy mountView$delegate = LazyKt.lazy(new MountComponent$mountView$2(this));
    private UgcMountData ugcMountData;

    private final MountView getMountView() {
        return (MountView) this.mountView$delegate.getValue();
    }

    public View createView() {
        return getMountView();
    }

    /* access modifiers changed from: private */
    public final MountView initMountView() {
        MountView mountView = new MountView(getContext(), (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        MountView $this$initMountView_u24lambda_u2d0 = mountView;
        $this$initMountView_u24lambda_u2d0.setOnClickListener(this);
        $this$initMountView_u24lambda_u2d0.setVisibility(8);
        return mountView;
    }

    public void onClick(View v) {
        MountModel it;
        if (Intrinsics.areEqual((Object) v, (Object) getMountView())) {
            UgcMountData ugcMountData2 = this.ugcMountData;
            boolean z = false;
            if (ugcMountData2 != null && !ugcMountData2.getMountHasMore()) {
                z = true;
            }
            if (!z) {
                Intent intent = new Intent();
                UgcMountData ugcMountData3 = this.ugcMountData;
                if (ugcMountData3 != null) {
                    UgcMountData ugcMountData4 = ugcMountData3;
                    intent.putExtra(UgcMountDataKt.UGC_MOUNT_DATA, ugcMountData3);
                }
                UgcMountData ugcMountData5 = this.ugcMountData;
                if (!(ugcMountData5 == null || (it = ugcMountData5.getMountModel()) == null)) {
                    intent.putExtra(UgcMountDataKt.UGC_MOUNT_ID, it.getMountId());
                }
                MountListActivity.Companion.startActivity(getContext(), intent, 1001);
            }
        }
    }

    public void onAttachToManager() {
        DraftState $this$onAttachToManager_u24lambda_u2d17;
        PublishState $this$onAttachToManager_u24lambda_u2d12;
        MountState $this$onAttachToManager_u24lambda_u2d7;
        super.onAttachToManager();
        Store<AbsState> store = getStore();
        if (!(store == null || ($this$onAttachToManager_u24lambda_u2d7 = (MountState) store.subscribe((Class<T>) MountState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d7.getMountData().observe(this, new MountComponent$$ExternalSyntheticLambda0(this));
            $this$onAttachToManager_u24lambda_u2d7.getPlaceMount().observe(this, new MountComponent$$ExternalSyntheticLambda1(this));
        }
        Store<AbsState> store2 = getStore();
        if (!(store2 == null || ($this$onAttachToManager_u24lambda_u2d12 = (PublishState) store2.subscribe((Class<T>) PublishState.class)) == null)) {
            $this$onAttachToManager_u24lambda_u2d12.getCollect().observe(this, new MountComponent$$ExternalSyntheticLambda2(this));
        }
        Store<AbsState> store3 = getStore();
        if (store3 != null && ($this$onAttachToManager_u24lambda_u2d17 = (DraftState) store3.subscribe((Class<T>) DraftState.class)) != null) {
            $this$onAttachToManager_u24lambda_u2d17.getOperation().observe(this, new MountComponent$$ExternalSyntheticLambda3(this));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        if ((r2 == null || r2.isEmpty()) != false) goto L_0x0028;
     */
    /* renamed from: onAttachToManager$lambda-7$lambda-4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m7268onAttachToManager$lambda7$lambda4(com.baidu.searchbox.videopublisher.mount.MountComponent r5, com.baidu.searchbox.ugc.model.UgcMountData r6) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            if (r6 == 0) goto L_0x0042
            r0 = r6
            r1 = 0
            r5.ugcMountData = r0
            java.util.List r2 = r0.getMountList()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0028
            java.util.List r2 = r0.getMountList()
            java.util.Collection r2 = (java.util.Collection) r2
            if (r2 == 0) goto L_0x0025
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0023
            goto L_0x0025
        L_0x0023:
            r2 = r4
            goto L_0x0026
        L_0x0025:
            r2 = r3
        L_0x0026:
            if (r2 == 0) goto L_0x0039
        L_0x0028:
            boolean r2 = r5.isMountLoading
            if (r2 != 0) goto L_0x0039
            r5.isMountLoading = r3
            java.lang.String r2 = r0.getTaskId()
            r3 = r5
            com.baidu.searchbox.ugc.mount.MountDataCaaBack r3 = (com.baidu.searchbox.ugc.mount.MountDataCaaBack) r3
            com.baidu.searchbox.ugc.mount.UgcMountReposKt.loadMountServerData(r2, r3)
            goto L_0x0040
        L_0x0039:
            com.baidu.searchbox.videopublisher.mount.MountView r2 = r5.getMountView()
            r2.setVisibility(r4)
        L_0x0040:
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.videopublisher.mount.MountComponent.m7268onAttachToManager$lambda7$lambda4(com.baidu.searchbox.videopublisher.mount.MountComponent, com.baidu.searchbox.ugc.model.UgcMountData):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-7$lambda-6  reason: not valid java name */
    public static final void m7269onAttachToManager$lambda7$lambda6(MountComponent this$0, MountModel it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (it != null) {
            MountModel it2 = it;
            UgcMountData ugcMountData2 = this$0.ugcMountData;
            if (ugcMountData2 != null) {
                ugcMountData2.setMountModel(it2);
            }
            MountView mountView = this$0.getMountView();
            String str = it2.getTitle() + " | " + it2.getDesc();
            UgcMountData ugcMountData3 = this$0.ugcMountData;
            mountView.showSelectedMount(str, ugcMountData3 != null ? ugcMountData3.getMountHasMore() : false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttachToManager$lambda-12$lambda-11  reason: not valid java name */
    public static final void m7266onAttachToManager$lambda12$lambda11(MountComponent this$0, Unit it) {
        AbsState state;
        PublisherCoreState publisherCoreState;
        PublishModel $this$onAttachToManager_u24lambda_u2d12_u24lambda_u2d11_u24lambda_u2d10;
        UgcMountData ugcMountData2;
        MountModel mountModel;
        Object it2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Store<AbsState> store = this$0.getStore();
        if (store != null && (state = store.getState()) != null && (publisherCoreState = (PublisherCoreState) state.select(PublisherCoreState.class)) != null && ($this$onAttachToManager_u24lambda_u2d12_u24lambda_u2d11_u24lambda_u2d10 = publisherCoreState.getPublishModel()) != null && (ugcMountData2 = this$0.ugcMountData) != null && (mountModel = ugcMountData2.getMountModel()) != null && (it2 = mountModel.getStorage()) != null) {
            Gson gson = GsonManager.INSTANCE.gson();
            ArrayList $this$onAttachToManager_u24lambda_u2d12_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9_u24lambda_u2d8 = new ArrayList();
            $this$onAttachToManager_u24lambda_u2d12_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9_u24lambda_u2d8.add(it2);
            Unit unit = Unit.INSTANCE;
            $this$onAttachToManager_u24lambda_u2d12_u24lambda_u2d11_u24lambda_u2d10.setMountList(gson.toJson((Object) $this$onAttachToManager_u24lambda_u2d12_u24lambda_u2d11_u24lambda_u2d10_u24lambda_u2d9_u24lambda_u2d8));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007e, code lost:
        r6 = r6.getMountModel();
     */
    /* renamed from: onAttachToManager$lambda-17$lambda-16  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m7267onAttachToManager$lambda17$lambda16(com.baidu.searchbox.videopublisher.mount.MountComponent r8, java.lang.Integer r9) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            if (r9 != 0) goto L_0x000a
            goto L_0x0039
        L_0x000a:
            int r0 = r9.intValue()
            r1 = 1
            if (r0 != r1) goto L_0x0039
            com.baidu.searchbox.ugc.model.UgcMountData r0 = r8.ugcMountData
            if (r0 == 0) goto L_0x0037
            r1 = 0
            com.baidu.searchbox.feed.detail.frame.Store r2 = r8.getStore()
            if (r2 == 0) goto L_0x0037
            com.baidu.searchbox.feed.detail.frame.State r2 = r2.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r2 = (com.baidu.searchbox.feed.detail.frame.AbsState) r2
            if (r2 == 0) goto L_0x0037
            java.lang.Class<com.baidu.searchbox.videopublisher.PublisherCoreState> r3 = com.baidu.searchbox.videopublisher.PublisherCoreState.class
            java.lang.Object r2 = r2.select(r3)
            com.baidu.searchbox.videopublisher.PublisherCoreState r2 = (com.baidu.searchbox.videopublisher.PublisherCoreState) r2
            if (r2 == 0) goto L_0x0037
            com.baidu.searchbox.ugc.draft.VideoDraftModel r2 = r2.getDraftModel()
            if (r2 == 0) goto L_0x0037
            r2.collect(r0)
        L_0x0037:
            goto L_0x00c0
        L_0x0039:
            r0 = 3
            if (r9 != 0) goto L_0x003e
            goto L_0x00c0
        L_0x003e:
            int r1 = r9.intValue()
            if (r1 != r0) goto L_0x00c0
            com.baidu.searchbox.feed.detail.frame.Store r0 = r8.getStore()
            if (r0 == 0) goto L_0x00c0
            com.baidu.searchbox.feed.detail.frame.State r0 = r0.getState()
            com.baidu.searchbox.feed.detail.frame.AbsState r0 = (com.baidu.searchbox.feed.detail.frame.AbsState) r0
            if (r0 == 0) goto L_0x00c0
            java.lang.Class<com.baidu.searchbox.videopublisher.PublisherCoreState> r1 = com.baidu.searchbox.videopublisher.PublisherCoreState.class
            java.lang.Object r0 = r0.select(r1)
            com.baidu.searchbox.videopublisher.PublisherCoreState r0 = (com.baidu.searchbox.videopublisher.PublisherCoreState) r0
            if (r0 == 0) goto L_0x00c0
            com.baidu.searchbox.ugc.draft.VideoDraftModel r0 = r0.getDraftModel()
            if (r0 == 0) goto L_0x00c0
            r1 = 0
            java.lang.Class<com.baidu.searchbox.ugc.model.UgcMountData> r2 = com.baidu.searchbox.ugc.model.UgcMountData.class
            java.lang.Object r2 = r0.restore(r2)
            com.baidu.searchbox.ugc.model.UgcMountData r2 = (com.baidu.searchbox.ugc.model.UgcMountData) r2
            if (r2 == 0) goto L_0x00c0
            r3 = 0
            r8.ugcMountData = r2
            com.baidu.searchbox.videopublisher.mount.MountView r4 = r8.getMountView()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            com.baidu.searchbox.ugc.model.UgcMountData r6 = r8.ugcMountData
            r7 = 0
            if (r6 == 0) goto L_0x0089
            com.baidu.searchbox.ugc.model.MountModel r6 = r6.getMountModel()
            if (r6 == 0) goto L_0x0089
            java.lang.String r6 = r6.getTitle()
            goto L_0x008a
        L_0x0089:
            r6 = r7
        L_0x008a:
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r6 = " | "
            java.lang.StringBuilder r5 = r5.append(r6)
            com.baidu.searchbox.ugc.model.UgcMountData r6 = r8.ugcMountData
            if (r6 == 0) goto L_0x00a2
            com.baidu.searchbox.ugc.model.MountModel r6 = r6.getMountModel()
            if (r6 == 0) goto L_0x00a2
            java.lang.String r7 = r6.getDesc()
        L_0x00a2:
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.String r5 = r5.toString()
            com.baidu.searchbox.ugc.model.UgcMountData r6 = r8.ugcMountData
            r7 = 0
            if (r6 == 0) goto L_0x00b4
            boolean r6 = r6.getMountHasMore()
            goto L_0x00b5
        L_0x00b4:
            r6 = r7
        L_0x00b5:
            r4.showSelectedMount(r5, r6)
            com.baidu.searchbox.videopublisher.mount.MountView r4 = r8.getMountView()
            r4.setVisibility(r7)
        L_0x00c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.videopublisher.mount.MountComponent.m7267onAttachToManager$lambda17$lambda16(com.baidu.searchbox.videopublisher.mount.MountComponent, java.lang.Integer):void");
    }

    public void onMountData(MountData mountData) {
        MountList data;
        ArrayList it;
        this.isMountLoading = false;
        if (mountData != null && (data = mountData.getData()) != null && (it = data.getMountList()) != null) {
            if (it.isEmpty()) {
                UgcMountData ugcMountData2 = this.ugcMountData;
                if (ugcMountData2 != null) {
                    ugcMountData2.setMountHasMore(false);
                    return;
                }
                return;
            }
            UgcMountData ugcMountData3 = this.ugcMountData;
            if (ugcMountData3 != null) {
                boolean z = true;
                if (it.size() <= 1) {
                    z = false;
                }
                ugcMountData3.setMountHasMore(z);
            }
            UgcMountData ugcMountData4 = this.ugcMountData;
            if (ugcMountData4 != null) {
                ugcMountData4.setMountList(it);
            }
            UgcMountData ugcMountData5 = this.ugcMountData;
            if (ugcMountData5 != null) {
                ugcMountData5.setMountModel(it.get(0));
            }
            MountView mountView = getMountView();
            StringBuilder sb = new StringBuilder();
            MountModel mountModel = it.get(0);
            String str = null;
            StringBuilder append = sb.append(mountModel != null ? mountModel.getTitle() : null).append(" | ");
            MountModel mountModel2 = it.get(0);
            if (mountModel2 != null) {
                str = mountModel2.getDesc();
            }
            String sb2 = append.append(str).toString();
            UgcMountData ugcMountData6 = this.ugcMountData;
            mountView.showSelectedMount(sb2, ugcMountData6 != null ? ugcMountData6.getMountHasMore() : false);
            getMountView().setVisibility(0);
        }
    }
}
