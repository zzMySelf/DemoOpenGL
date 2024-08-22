package com.tera.scan.scanner.ocr.control;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.aiscan.R;
import com.tera.scan.scanner.ocr.adapter.ScanIdCardsGuideAdapter;
import com.tera.scan.scanner.ocr.control.IOCRTakePhotoControl;
import com.tera.scan.scanner.ocr.model.ScanIdCardsModel;
import com.tera.scan.ui.view.layout.UIConstraintLayout;
import com.tera.scan.ui.view.widget.UIButton;
import com.tera.scan.ui.view.widget.UIImageView;
import fe.mmm.qw.th.qw.th.yj;
import fe.vvv.qw.o.qw;
import fe.vvv.qw.xxx.ad;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B:\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\u0002\u0010\fJ\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0003H\u0002J\"\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u000bH\u0016J\u0010\u0010'\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u0003H\u0016J \u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0016J\u0016\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201J\u0010\u0010-\u001a\u00020\u000b2\u0006\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020\u000bH\u0016J\b\u00105\u001a\u00020\u000bH\u0002J\b\u00106\u001a\u00020\u000bH\u0016J\u0010\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u0005H\u0002R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/tera/scan/scanner/ocr/control/ScanIdCardsGuideControl;", "Lcom/tera/scan/scanner/ocr/control/IOCRTakePhotoControl;", "activity", "Landroid/app/Activity;", "currentCategory", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "category", "", "(Landroid/app/Activity;ILkotlin/jvm/functions/Function1;)V", "bottomRecyclerView", "Landroid/view/View;", "btnStart", "Lcom/tera/scan/ui/view/widget/UIButton;", "getCurrentCategory$scanner_aiscanConfigRelease", "()I", "setCurrentCategory$scanner_aiscanConfigRelease", "(I)V", "ivGuideImage", "Lcom/tera/scan/ui/view/widget/UIImageView;", "mGuideAdapter", "Lcom/tera/scan/scanner/ocr/adapter/ScanIdCardsGuideAdapter;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "rlGuideContainer", "Lcom/tera/scan/ui/view/layout/UIConstraintLayout;", "takePhotoButtonView", "tvGuideAlbum", "initAdapter", "view", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "onInitView", "onPicturePreview", "frame", "Lcom/otaliastudios/cameraview/frame/Frame;", "cameraViewWidth", "cameraViewHeight", "onPictureTake", "bitmap", "Landroid/graphics/Bitmap;", "outPutPath", "", "pic", "Ljava/io/File;", "onSelect", "onStartScan", "onUnSelect", "updateSelectScanType", "selectPosition", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScanIdCardsGuideControl implements IOCRTakePhotoControl {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Function1<Integer, Unit> f7242ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public UIConstraintLayout f7243de;
    @Nullable

    /* renamed from: fe  reason: collision with root package name */
    public RecyclerView f7244fe;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public View f7245i;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public ScanIdCardsGuideAdapter f7246o;
    public int qw;
    @Nullable

    /* renamed from: rg  reason: collision with root package name */
    public UIImageView f7247rg;
    @Nullable

    /* renamed from: th  reason: collision with root package name */
    public UIButton f7248th;
    @Nullable

    /* renamed from: uk  reason: collision with root package name */
    public View f7249uk;
    @Nullable

    /* renamed from: yj  reason: collision with root package name */
    public View f7250yj;

    public ScanIdCardsGuideControl(@NotNull Activity activity, int i2, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.qw = i2;
        this.f7242ad = function1;
        m904if(activity);
    }

    public void ad() {
        UIConstraintLayout uIConstraintLayout = this.f7243de;
        if (uIConstraintLayout != null) {
            uIConstraintLayout.setVisibility(0);
        }
        if (this.qw == -1) {
            ppp(0);
        }
        View view = this.f7250yj;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.f7249uk;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        View view3 = this.f7249uk;
        if (view3 != null) {
            view3.setAlpha(0.4f);
        }
        View view4 = this.f7249uk;
        if (view4 != null) {
            view4.setEnabled(false);
        }
        View view5 = this.f7245i;
        if (view5 != null) {
            view5.setAlpha(0.4f);
        }
    }

    public void de() {
        UIConstraintLayout uIConstraintLayout = this.f7243de;
        if (uIConstraintLayout != null) {
            uIConstraintLayout.setVisibility(8);
        }
        View view = this.f7249uk;
        if (view != null) {
            view.setEnabled(true);
        }
        View view2 = this.f7249uk;
        if (view2 != null) {
            view2.setAlpha(1.0f);
        }
    }

    public void fe(@NotNull ad adVar) {
        IOCRTakePhotoControl.qw.ad(this, adVar);
    }

    /* renamed from: if  reason: not valid java name */
    public void m904if(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "view");
        this.f7243de = (UIConstraintLayout) activity.findViewById(R.id.rl_scan_id_card_guide_container);
        this.f7244fe = (RecyclerView) activity.findViewById(R.id.recycler_scan_id_card_guide);
        this.f7247rg = (UIImageView) activity.findViewById(R.id.iv_scan_id_cards_guide_background);
        this.f7248th = (UIButton) activity.findViewById(R.id.btn_make_it_now);
        this.f7249uk = activity.findViewById(R.id.take_photo_button);
        this.f7250yj = activity.findViewById(R.id.ocr_bottom_recyclerview);
        this.f7245i = activity.findViewById(R.id.tv_scan_id_cards_guide_album);
        UIButton uIButton = this.f7248th;
        if (uIButton != null) {
            yj.de(uIButton, 0, new ScanIdCardsGuideControl$onInitView$1(this), 1, (Object) null);
        }
        pf(activity);
    }

    public final int o() {
        return this.qw;
    }

    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
    }

    public void onDestroy() {
    }

    public void onResume() {
        IOCRTakePhotoControl.qw.de(this);
    }

    public void onStop() {
        IOCRTakePhotoControl.qw.fe(this);
    }

    public final void pf(Activity activity) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ScanIdCardsModel(1, R.drawable.icon_scan_id_cards_guide_card, Integer.valueOf(R.string.id_card_tab)));
        arrayList.add(new ScanIdCardsModel(6, R.drawable.icon_scan_id_cards_guide_passport, Integer.valueOf(R.string.id_card_tab_type_passport)));
        arrayList.add(new ScanIdCardsModel(2, R.drawable.icon_scan_id_cards_guide_bank, Integer.valueOf(R.string.id_card_tab_type_others)));
        if (!arrayList.isEmpty()) {
            this.f7246o = new ScanIdCardsGuideAdapter(activity, arrayList, 0, 4, (DefaultConstructorMarker) null);
            RecyclerView recyclerView = this.f7244fe;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(activity, 0, false));
            }
            RecyclerView recyclerView2 = this.f7244fe;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(this.f7246o);
            }
        }
        ScanIdCardsGuideAdapter scanIdCardsGuideAdapter = this.f7246o;
        if (scanIdCardsGuideAdapter != null) {
            scanIdCardsGuideAdapter.setMItemClickListener(new ScanIdCardsGuideControl$initAdapter$1(this));
        }
    }

    public final void ppp(int i2) {
        List<ScanIdCardsModel> allData;
        ScanIdCardsGuideAdapter scanIdCardsGuideAdapter = this.f7246o;
        if (scanIdCardsGuideAdapter != null && (allData = scanIdCardsGuideAdapter.getAllData()) != null) {
            int i3 = 1;
            if ((!allData.isEmpty()) && allData.size() > i2) {
                ScanIdCardsModel scanIdCardsModel = allData.get(i2);
                Integer category = scanIdCardsModel.getCategory();
                if (category != null) {
                    i3 = category.intValue();
                }
                this.qw = i3;
                UIImageView uIImageView = this.f7247rg;
                if (uIImageView != null) {
                    uIImageView.setImageResource(scanIdCardsModel.getBigImageRes());
                }
            }
        }
    }

    public void qw(@NotNull qw qwVar, int i2, int i3) {
        Intrinsics.checkNotNullParameter(qwVar, "frame");
    }

    /* renamed from: switch  reason: not valid java name */
    public final void m905switch(@NotNull Bitmap bitmap, @NotNull String str) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(str, "outPutPath");
    }

    public void th(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "pic");
    }

    public void uk() {
        IOCRTakePhotoControl.qw.qw(this);
    }

    public final void when() {
        this.f7242ad.invoke(Integer.valueOf(this.qw));
    }

    @NotNull
    public List<String> yj() {
        return IOCRTakePhotoControl.qw.rg(this);
    }
}
