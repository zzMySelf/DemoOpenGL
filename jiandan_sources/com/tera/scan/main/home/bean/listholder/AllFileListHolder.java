package com.tera.scan.main.home.bean.listholder;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.lifecycle.LiveData;
import com.baidu.aiscan.R;
import com.baidu.android.common.others.IStringUtil;
import com.tera.scan.business.textrecognition.PreViewActivity;
import com.tera.scan.doc.preview.document.ui.view.DocumentViewerActivity;
import com.tera.scan.flutter.component.provider.FlutterYouthProvider;
import com.tera.scan.main.home.BaseViewHolder;
import com.tera.scan.main.home.bean.recordwrapper.RecordWrapper;
import com.tera.scan.main.viewmodel.MainActivityViewModel;
import com.tera.scan.record.model.ScanRecord;
import com.tera.scan.record.model.ScanRecordExportFile;
import com.tera.scan.record.model.ScanRecordFile;
import fe.rg.qw.th;
import i.qw.o;
import i.qw.u;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bH\u0016J\u0018\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J)\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010 J'\u0010!\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0002J\u001c\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(2\n\u0010)\u001a\u0006\u0012\u0002\b\u00030*H\u0002J\u001c\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-2\n\u0010.\u001a\u0006\u0012\u0002\b\u00030*H\u0016J\u0010\u0010/\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fH\u0016\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"Lcom/tera/scan/main/home/bean/listholder/AllFileListHolder;", "Lcom/tera/scan/main/home/bean/listholder/BaseMainListHolder;", "Lcom/tera/scan/main/home/bean/recordwrapper/AllFileRecordWrapper;", "viewModel", "Lcom/tera/scan/main/viewmodel/MainActivityViewModel;", "(Lcom/tera/scan/main/viewmodel/MainActivityViewModel;)V", "getAvailableNewPath", "", "oldPath", "name", "getIconResIdByName", "", "fileName", "getList", "", "getListHolderType", "getListLiveData", "Landroidx/lifecycle/LiveData;", "getNameFromPath", "path", "onItemClick", "", "activity", "Landroid/app/Activity;", "position", "openFile", "scanRecordExportFile", "Lcom/tera/scan/record/model/ScanRecordExportFile;", "reNameItem", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeItems", "list", "(Landroid/content/Context;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renameLocalFileName", "newPath", "setIconType", "imageView", "Landroid/widget/ImageView;", "record", "Lcom/tera/scan/main/home/bean/recordwrapper/RecordWrapper;", "setLeftIcon", "holder", "Lcom/tera/scan/main/home/BaseViewHolder;", "recordData", "shareFile", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class AllFileListHolder extends fe.mmm.qw.xxx.yj.g.qw.qw<fe.mmm.qw.xxx.yj.g.ad.qw> {

    public static final class ad<T> implements Comparator {
        public final int compare(T t, T t2) {
            return ComparisonsKt__ComparisonsKt.compareValues(((fe.mmm.qw.xxx.yj.g.ad.qw) t).getFileName(), ((fe.mmm.qw.xxx.yj.g.ad.qw) t2).getFileName());
        }
    }

    public static final class de<T> implements Comparator {
        public final int compare(T t, T t2) {
            return ComparisonsKt__ComparisonsKt.compareValues(((fe.mmm.qw.xxx.yj.g.ad.qw) t2).ad(), ((fe.mmm.qw.xxx.yj.g.ad.qw) t).ad());
        }
    }

    public static final class fe<T> implements Comparator {
        public final int compare(T t, T t2) {
            return ComparisonsKt__ComparisonsKt.compareValues(((fe.mmm.qw.xxx.yj.g.ad.qw) t2).getFileName(), ((fe.mmm.qw.xxx.yj.g.ad.qw) t).getFileName());
        }
    }

    public static final class qw<T> implements Comparator {
        public final int compare(T t, T t2) {
            return ComparisonsKt__ComparisonsKt.compareValues(((fe.mmm.qw.xxx.yj.g.ad.qw) t).ad(), ((fe.mmm.qw.xxx.yj.g.ad.qw) t2).ad());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AllFileListHolder(@NotNull MainActivityViewModel mainActivityViewModel) {
        super(mainActivityViewModel);
        Intrinsics.checkNotNullParameter(mainActivityViewModel, "viewModel");
    }

    public final void a(ImageView imageView, RecordWrapper<?> recordWrapper) {
        String icon = recordWrapper.getIcon();
        String str = "";
        if (icon == null) {
            icon = str;
        }
        if (new File(icon).exists()) {
            fe.rg.qw.ad.mmm(i().getApplication()).ppp(new File(icon)).m317switch(imageView);
            return;
        }
        th mmm = fe.rg.qw.ad.mmm(i().getApplication());
        String fileName = recordWrapper.getFileName();
        if (fileName != null) {
            str = fileName;
        }
        mmm.ggg(Integer.valueOf(mmm(str))).m317switch(imageView);
    }

    public final String aaa(String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            String substring = str.substring(StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, "/", 0, false, 6, (Object) null) + 1, str.length());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            obj = Result.m1155constructorimpl(substring);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1155constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m1161isFailureimpl(obj)) {
            obj = null;
        }
        String str2 = (String) obj;
        return str2 == null ? "" : str2;
    }

    @NotNull
    public List<fe.mmm.qw.xxx.yj.g.ad.qw> de() {
        List value = i().getAllFileLiveData().getValue();
        if (value == null) {
            value = CollectionsKt__CollectionsKt.emptyList();
        }
        Integer value2 = i().getSortTypeLiveData().getValue();
        Integer value3 = i().getSortOrderLiveData().getValue();
        if (value2 != null && value2.intValue() == 0) {
            if (value3 != null && value3.intValue() == 1) {
                return CollectionsKt___CollectionsKt.sortedWith(value, new de());
            }
            return CollectionsKt___CollectionsKt.sortedWith(value, new qw());
        } else if (value3 != null && value3.intValue() == 1) {
            return CollectionsKt___CollectionsKt.sortedWith(value, new fe());
        } else {
            return CollectionsKt___CollectionsKt.sortedWith(value, new ad());
        }
    }

    public int fe() {
        return 1;
    }

    @Nullable
    /* renamed from: if  reason: not valid java name */
    public Object m805if(@NotNull Context context, @NotNull List<Integer> list, @NotNull Continuation<? super Boolean> continuation) {
        return o.yj(u.ad(), new AllFileListHolder$removeItems$2(this, list, context, (Continuation<? super AllFileListHolder$removeItems$2>) null), continuation);
    }

    public final int mmm(String str) {
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        if (StringsKt__StringsJVMKt.endsWith$default(lowerCase, ".pdf", false, 2, (Object) null) || StringsKt__StringsJVMKt.endsWith$default(lowerCase, ".pdfx", false, 2, (Object) null)) {
            return R.drawable.icon_main_pdf;
        }
        if (StringsKt__StringsJVMKt.endsWith$default(lowerCase, ".xls", false, 2, (Object) null) || StringsKt__StringsJVMKt.endsWith$default(lowerCase, ".xlsx", false, 2, (Object) null)) {
            return R.drawable.icon_main_exls;
        }
        return (StringsKt__StringsJVMKt.endsWith$default(lowerCase, ".doc", false, 2, (Object) null) || StringsKt__StringsJVMKt.endsWith$default(lowerCase, ".docx", false, 2, (Object) null)) ? R.drawable.icon_main_doc : R.drawable.icon_main_txt;
    }

    public final String nn(String str, String str2) {
        String str3;
        String sb;
        int lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) str2, IStringUtil.CURRENT_PATH, 0, false, 6, (Object) null);
        int i2 = 0;
        do {
            if (i2 == 0) {
                str3 = str2;
            } else if (lastIndexOf$default < 0) {
                str3 = str2 + '(' + i2 + ')';
            } else {
                StringBuilder sb2 = new StringBuilder();
                String substring = str2.substring(0, lastIndexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                sb2.append(substring);
                sb2.append('(');
                sb2.append(i2);
                sb2.append(')');
                String substring2 = str2.substring(lastIndexOf$default, str2.length());
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                sb2.append(substring2);
                str3 = sb2.toString();
            }
            StringBuilder sb3 = new StringBuilder();
            String substring3 = str.substring(0, StringsKt__StringsKt.lastIndexOf$default((CharSequence) str, "/", 0, false, 6, (Object) null));
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
            sb3.append(substring3);
            sb3.append('/');
            sb3.append(str3);
            sb = sb3.toString();
            i2++;
        } while (new File(sb).exists());
        return sb;
    }

    public void o(@NotNull Activity activity, int i2) {
        Intrinsics.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Object data = de().get(i2).getData();
        if (data instanceof ScanRecordExportFile) {
            ScanRecordExportFile scanRecordExportFile = (ScanRecordExportFile) data;
            if (scanRecordExportFile.getLocalPath() != null) {
                qqq(activity, scanRecordExportFile);
            }
        } else if (data instanceof ScanRecord) {
            new FlutterYouthProvider().openScanRecordDetail(activity, ((ScanRecord) data).getRecordId());
        }
    }

    @Nullable
    public Object pf(@NotNull Context context, int i2, @NotNull String str, @NotNull Continuation<? super Boolean> continuation) {
        return o.yj(u.ad(), new AllFileListHolder$reNameItem$2(this, i2, str, context, (Continuation<? super AllFileListHolder$reNameItem$2>) null), continuation);
    }

    public void ppp(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (yj() != 0) {
            ArrayList arrayList = new ArrayList();
            List<fe.mmm.qw.xxx.yj.g.ad.qw> de2 = de();
            for (Number intValue : uk()) {
                Object data = de2.get(intValue.intValue()).getData();
                String str = "";
                if (data instanceof ScanRecordExportFile) {
                    String localPath = ((ScanRecordExportFile) data).getLocalPath();
                    if (localPath != null) {
                        str = localPath;
                    }
                    arrayList.add(str);
                } else if (data instanceof ScanRecord) {
                    List<ScanRecordFile> pictureList = ((ScanRecord) data).getPictureList();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(pictureList, 10));
                    for (ScanRecordFile localPath2 : pictureList) {
                        String localPath3 = localPath2.getLocalPath();
                        if (localPath3 == null) {
                            localPath3 = str;
                        }
                        arrayList2.add(Boolean.valueOf(arrayList.add(localPath3)));
                    }
                }
            }
            fe.mmm.qw.rg.qw.de.ad.ad.qw.ad(context, arrayList);
            fe.mmm.qw.ggg.qw.qw.qw("ts_files_share", CollectionsKt__CollectionsJVMKt.listOf(String.valueOf(arrayList.size())));
        }
    }

    public final void qqq(Activity activity, ScanRecordExportFile scanRecordExportFile) {
        String localPath = scanRecordExportFile.getLocalPath();
        if (localPath == null) {
            localPath = "";
        }
        String str = localPath;
        if (fe.mmm.qw.o.qw.qw.ad.ad.rg(str) || fe.mmm.qw.o.qw.qw.ad.ad.ad(str)) {
            activity.startActivity(DocumentViewerActivity.getStartIntent(activity.getApplicationContext(), str, scanRecordExportFile, "", -1, 0, ""));
        } else if (fe.mmm.qw.o.qw.qw.ad.ad.yj(str)) {
            activity.startActivity(PreViewActivity.Companion.qw(activity, str));
        } else {
            Toast.makeText(ad(), ad().getString(R.string.unsupported_file_type), 0).show();
        }
    }

    @NotNull
    public LiveData<List<fe.mmm.qw.xxx.yj.g.ad.qw>> rg() {
        return i().getAllFileLiveData();
    }

    public final boolean tt(String str, String str2) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return file.renameTo(new File(str2));
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void when(@NotNull BaseViewHolder baseViewHolder, @NotNull RecordWrapper<?> recordWrapper) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(recordWrapper, "recordData");
        ImageView imageView = (ImageView) baseViewHolder.findViewWithId(R.id.iv_style_icon);
        View findViewWithId = baseViewHolder.findViewWithId(R.id.round_icon_container);
        ImageView imageView2 = (ImageView) baseViewHolder.findViewWithId(R.id.iv_style_icon_round);
        Object data = recordWrapper.getData();
        if (data instanceof ScanRecordExportFile) {
            if (imageView != null) {
                fe.mmm.qw.th.qw.rg.fe.de.qw.fe(imageView);
            }
            if (findViewWithId != null) {
                fe.mmm.qw.th.qw.rg.fe.de.qw.qw(findViewWithId);
            }
            if (imageView != null) {
                imageView.setVisibility(0);
                a(imageView, recordWrapper);
            }
        } else if (data instanceof ScanRecord) {
            if (imageView != null) {
                fe.mmm.qw.th.qw.rg.fe.de.qw.qw(imageView);
            }
            if (findViewWithId != null) {
                fe.mmm.qw.th.qw.rg.fe.de.qw.fe(findViewWithId);
            }
            if (findViewWithId != null && imageView2 != null) {
                findViewWithId.setVisibility(0);
                fe.rg.qw.ad.mmm(ad()).vvv(recordWrapper.getIcon()).m317switch(imageView2);
            }
        }
    }
}
