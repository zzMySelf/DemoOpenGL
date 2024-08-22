package com.tera.scan.main.importfile.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.baidu.aiscan.R;
import com.google.common.net.MediaType;
import com.tera.scan.record.model.ScanRecordExportFile;
import fe.mmm.qw.xxx.uk.ggg.ad;
import fe.mmm.qw.xxx.uk.ggg.fe;
import fe.mmm.qw.xxx.when.de;
import i.qw.Cif;
import i.qw.o;
import i.qw.u;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 >2\u00020\u0001:\u0001>B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JD\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001b2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u001bJ\r\u0010*\u001a\u00020'H\u0000¢\u0006\u0002\b+J\"\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\"2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020'2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0018\u00101\u001a\u00020'2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u00102\u001a\u00020'J\u0015\u00103\u001a\u00020'2\u0006\u00104\u001a\u00020\fH\u0000¢\u0006\u0002\b5J7\u00106\u001a\u00020'2\u0010\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u000109\u0018\u0001082\u000e\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090$2\u0006\u0010;\u001a\u00020<H\u0002¢\u0006\u0002\u0010=R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006?"}, d2 = {"Lcom/tera/scan/main/importfile/viewmodel/ImportDocFileViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_fileListLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tera/scan/main/importfile/data/ImportFile;", "_importResultLiveData", "Lcom/tera/scan/main/importfile/viewmodel/ImportResult;", "_isSelectModeLiveData", "", "_loadingLiveData", "fileListLiveData", "Landroidx/lifecycle/LiveData;", "getFileListLiveData", "()Landroidx/lifecycle/LiveData;", "importResultLiveData", "getImportResultLiveData", "isAllSelectLiveData", "isSelectModeLiveData", "loadingLiveData", "getLoadingLiveData", "reqFileType", "", "reqMaxFileCount", "", "selectedCountLiveData", "getSelectedCountLiveData", "assembleImportResult", "insertResultIsSuccess", "allCount", "copyFileResultPair", "Lkotlin/Pair;", "importFinalList", "", "Lcom/tera/scan/record/model/ScanRecordExportFile;", "changeAllSelectState", "", "changeItemSelectState", "position", "clearSelectedFileList", "clearSelectedFileList$app_main_aiscanConfigRelease", "copyFileToImportDir", "fileList", "getLocalDocFileList", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importSelectFiles", "initConfig", "loadAllDocFile", "setIsSelectMode", "isSelectMode", "setIsSelectMode$app_main_aiscanConfigRelease", "traversalFile", "files", "", "Ljava/io/File;", "docList", "documentFileFilter", "Lcom/tera/scan/main/importfile/filter/DocumentFileFilter;", "([Ljava/io/File;Ljava/util/List;Lcom/tera/scan/main/importfile/filter/DocumentFileFilter;)V", "Companion", "app-main_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImportDocFileViewModel extends AndroidViewModel {
    @NotNull
    public static final qw Companion = new qw((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final MutableLiveData<Boolean> f6975ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public final LiveData<Boolean> f6976de;
    @NotNull

    /* renamed from: fe  reason: collision with root package name */
    public final MutableLiveData<List<fe.mmm.qw.xxx.uk.when.qw>> f6977fe;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final LiveData<Boolean> f6978i;
    @Nullable

    /* renamed from: if  reason: not valid java name */
    public String f287if;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    public final MutableLiveData<fe> f6979o;
    @NotNull

    /* renamed from: pf  reason: collision with root package name */
    public final LiveData<fe> f6980pf;
    @NotNull
    public final Application qw;
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public final LiveData<List<fe.mmm.qw.xxx.uk.when.qw>> f6981rg;

    /* renamed from: switch  reason: not valid java name */
    public int f288switch = 99;
    @NotNull

    /* renamed from: th  reason: collision with root package name */
    public final LiveData<Integer> f6982th;
    @NotNull

    /* renamed from: uk  reason: collision with root package name */
    public final LiveData<Boolean> f6983uk;
    @NotNull

    /* renamed from: yj  reason: collision with root package name */
    public final MutableLiveData<Boolean> f6984yj;

    public static final class qw {
        public qw() {
        }

        public /* synthetic */ qw(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImportDocFileViewModel(@NotNull Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, MediaType.APPLICATION_TYPE);
        this.qw = application;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(Boolean.FALSE);
        this.f6975ad = mutableLiveData;
        this.f6976de = mutableLiveData;
        MutableLiveData<List<fe.mmm.qw.xxx.uk.when.qw>> mutableLiveData2 = new MutableLiveData<>();
        this.f6977fe = mutableLiveData2;
        this.f6981rg = mutableLiveData2;
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(this.f6977fe, new fe.mmm.qw.xxx.uk.ggg.qw(mediatorLiveData, this));
        this.f6982th = mediatorLiveData;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(Boolean.TRUE);
        this.f6984yj = mutableLiveData3;
        this.f6983uk = mutableLiveData3;
        MediatorLiveData mediatorLiveData2 = new MediatorLiveData();
        mediatorLiveData2.addSource(this.f6977fe, new ad(this, mediatorLiveData2));
        this.f6978i = mediatorLiveData2;
        MutableLiveData<fe> mutableLiveData4 = new MutableLiveData<>();
        this.f6979o = mutableLiveData4;
        this.f6980pf = mutableLiveData4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        if (r2 != false) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void fe(com.tera.scan.main.importfile.viewmodel.ImportDocFileViewModel r2, androidx.lifecycle.MediatorLiveData r3, java.util.List r4) {
        /*
            java.lang.String r4 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            java.lang.String r4 = "$this_apply"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            androidx.lifecycle.MutableLiveData<java.util.List<fe.mmm.qw.xxx.uk.when.qw>> r2 = r2.f6977fe
            java.lang.Object r2 = r2.getValue()
            java.util.List r2 = (java.util.List) r2
            r4 = 1
            if (r2 == 0) goto L_0x001a
            boolean r0 = r2.isEmpty()
            goto L_0x001b
        L_0x001a:
            r0 = 1
        L_0x001b:
            r1 = 0
            if (r0 != 0) goto L_0x0046
            if (r2 == 0) goto L_0x0042
            boolean r0 = r2 instanceof java.util.Collection
            if (r0 == 0) goto L_0x002c
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x002c
        L_0x002a:
            r2 = 1
            goto L_0x0043
        L_0x002c:
            java.util.Iterator r2 = r2.iterator()
        L_0x0030:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x002a
            java.lang.Object r0 = r2.next()
            fe.mmm.qw.xxx.uk.when.qw r0 = (fe.mmm.qw.xxx.uk.when.qw) r0
            boolean r0 = r0.rg()
            if (r0 != 0) goto L_0x0030
        L_0x0042:
            r2 = 0
        L_0x0043:
            if (r2 == 0) goto L_0x0046
            goto L_0x0047
        L_0x0046:
            r4 = 0
        L_0x0047:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r4)
            r3.setValue(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.main.importfile.viewmodel.ImportDocFileViewModel.fe(com.tera.scan.main.importfile.viewmodel.ImportDocFileViewModel, androidx.lifecycle.MediatorLiveData, java.util.List):void");
    }

    public static final void rg(MediatorLiveData mediatorLiveData, ImportDocFileViewModel importDocFileViewModel, List list) {
        Intrinsics.checkNotNullParameter(mediatorLiveData, "$this_apply");
        Intrinsics.checkNotNullParameter(importDocFileViewModel, "this$0");
        List<fe.mmm.qw.xxx.uk.when.qw> value = importDocFileViewModel.f6977fe.getValue();
        int i2 = 0;
        if (value != null && (!(value instanceof Collection) || !value.isEmpty())) {
            for (fe.mmm.qw.xxx.uk.when.qw rg2 : value) {
                if (rg2.rg() && (i2 = i2 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        mediatorLiveData.setValue(Integer.valueOf(i2));
    }

    public final Pair<Integer, Integer> ad(List<ScanRecordExportFile> list) {
        String qw2 = de.qw.qw(this.qw);
        Iterator<ScanRecordExportFile> it = list.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            ScanRecordExportFile next = it.next();
            String str = "";
            if (fe.mmm.qw.o.qw.qw.ad.ad.rg(next.getLocalPath())) {
                fe.mmm.qw.aaa.qw.qw qwVar = fe.mmm.qw.aaa.qw.qw.qw;
                Application application = this.qw;
                String localPath = next.getLocalPath();
                if (localPath == null) {
                    localPath = str;
                }
                if (qwVar.qw(application, localPath)) {
                    i3++;
                    it.remove();
                }
            }
            File file = new File(qw2, next.getFileName());
            String localPath2 = next.getLocalPath();
            if (localPath2 != null) {
                str = localPath2;
            }
            if (fe.mmm.qw.j.xxx.ad.qw(new File(str), file)) {
                next.setLocalPath(file.getAbsolutePath());
                i2++;
            } else {
                it.remove();
            }
        }
        return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final void changeAllSelectState() {
        Integer value = this.f6982th.getValue();
        int i2 = 0;
        if (value == null) {
            value = 0;
        }
        int intValue = value.intValue();
        List value2 = this.f6977fe.getValue();
        boolean z = true;
        if (!(1 <= intValue && intValue < (value2 != null ? value2.size() : 0)) && intValue != 0) {
            z = false;
        }
        if (intValue < this.f288switch) {
            List value3 = this.f6977fe.getValue();
            if (value3 != null) {
                i2 = value3.size();
            }
            if (z && i2 >= this.f288switch) {
                return;
            }
        } else if (z) {
            return;
        }
        MutableLiveData<List<fe.mmm.qw.xxx.uk.when.qw>> mutableLiveData = this.f6977fe;
        List<fe.mmm.qw.xxx.uk.when.qw> value4 = mutableLiveData.getValue();
        if (value4 != null) {
            for (fe.mmm.qw.xxx.uk.when.qw th2 : value4) {
                th2.th(z);
            }
        } else {
            value4 = null;
        }
        mutableLiveData.setValue(value4);
    }

    public final void changeItemSelectState(int i2) {
        int i3;
        List<fe.mmm.qw.xxx.uk.when.qw> value = this.f6977fe.getValue();
        if (value != null) {
            boolean z = false;
            if (!(value instanceof Collection) || !value.isEmpty()) {
                i3 = 0;
                for (fe.mmm.qw.xxx.uk.when.qw rg2 : value) {
                    if (rg2.rg() && (i3 = i3 + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
            } else {
                i3 = 0;
            }
            if (i3 >= this.f288switch) {
                if (!(i2 >= 0 && i2 < value.size()) || !((fe.mmm.qw.xxx.uk.when.qw) value.get(i2)).rg()) {
                    return;
                }
            }
            if (i2 >= 0 && i2 < value.size()) {
                z = true;
            }
            if (z) {
                fe.mmm.qw.xxx.uk.when.qw qwVar = (fe.mmm.qw.xxx.uk.when.qw) value.get(i2);
                qwVar.th(!qwVar.rg());
            }
            this.f6977fe.setValue(value);
            setIsSelectMode$app_main_aiscanConfigRelease(true);
        }
    }

    public final void clearSelectedFileList$app_main_aiscanConfigRelease() {
        MutableLiveData<List<fe.mmm.qw.xxx.uk.when.qw>> mutableLiveData = this.f6977fe;
        List<fe.mmm.qw.xxx.uk.when.qw> value = mutableLiveData.getValue();
        if (value != null) {
            for (fe.mmm.qw.xxx.uk.when.qw th2 : value) {
                th2.th(false);
            }
        } else {
            value = null;
        }
        mutableLiveData.setValue(value);
    }

    public final Object de(Continuation<? super List<fe.mmm.qw.xxx.uk.when.qw>> continuation) {
        return o.yj(u.ad(), new ImportDocFileViewModel$getLocalDocFileList$2(this, (Continuation<? super ImportDocFileViewModel$getLocalDocFileList$2>) null), continuation);
    }

    @NotNull
    public final LiveData<List<fe.mmm.qw.xxx.uk.when.qw>> getFileListLiveData() {
        return this.f6981rg;
    }

    @NotNull
    public final LiveData<fe> getImportResultLiveData() {
        return this.f6980pf;
    }

    @NotNull
    public final LiveData<Boolean> getLoadingLiveData() {
        return this.f6976de;
    }

    @NotNull
    public final LiveData<Integer> getSelectedCountLiveData() {
        return this.f6982th;
    }

    public final void importSelectFiles(@Nullable String str) {
        List value = this.f6977fe.getValue();
        if (value != null) {
            Job unused = Cif.fe(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ImportDocFileViewModel$importSelectFiles$1$1(value, this, str, (Continuation<? super ImportDocFileViewModel$importSelectFiles$1$1>) null), 3, (Object) null);
        }
    }

    public final void initConfig(@Nullable String str, int i2) {
        this.f287if = str;
        this.f288switch = i2;
    }

    @NotNull
    public final LiveData<Boolean> isAllSelectLiveData() {
        return this.f6978i;
    }

    @NotNull
    public final LiveData<Boolean> isSelectModeLiveData() {
        return this.f6983uk;
    }

    public final void loadAllDocFile() {
        Job unused = Cif.fe(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ImportDocFileViewModel$loadAllDocFile$1(this, (Continuation<? super ImportDocFileViewModel$loadAllDocFile$1>) null), 3, (Object) null);
    }

    public final fe qw(boolean z, int i2, Pair<Integer, Integer> pair, List<ScanRecordExportFile> list, String str) {
        int i3 = i2;
        fe feVar = new fe();
        String str2 = "SysFile_Fail";
        if (z) {
            if (i3 == 1 && pair.getSecond().intValue() == 1) {
                feVar.m1009if(this.qw.getString(R.string.import_single_file_damage));
                feVar.uk(false);
            } else if (i3 == pair.getFirst().intValue()) {
                feVar.m1009if(this.qw.getString(R.string.import_files_success));
                feVar.uk(true);
                if (i3 == 1) {
                    ScanRecordExportFile scanRecordExportFile = (ScanRecordExportFile) CollectionsKt___CollectionsKt.first(list);
                    if (fe.mmm.qw.o.qw.qw.ad.ad.rg(scanRecordExportFile.getLocalPath())) {
                        feVar.i(true);
                        feVar.yj(scanRecordExportFile.getLocalPath());
                        feVar.pf(CollectionsKt__CollectionsJVMKt.listOf(scanRecordExportFile));
                    }
                }
            } else if (pair.getFirst().intValue() > 1) {
                feVar.m1009if(this.qw.getString(R.string.import_files_partial_damage, new Object[]{String.valueOf(pair.getFirst().intValue()), String.valueOf(pair.getSecond().intValue())}));
                feVar.uk(true);
            } else if (pair.getFirst().intValue() == 1) {
                feVar.m1009if(this.qw.getString(R.string.import_files_success));
                feVar.uk(true);
                ScanRecordExportFile scanRecordExportFile2 = (ScanRecordExportFile) CollectionsKt___CollectionsKt.first(list);
                if (fe.mmm.qw.o.qw.qw.ad.ad.rg(scanRecordExportFile2.getLocalPath())) {
                    feVar.i(true);
                    feVar.yj(scanRecordExportFile2.getLocalPath());
                    feVar.pf(CollectionsKt__CollectionsJVMKt.listOf(scanRecordExportFile2));
                }
            } else {
                feVar.m1009if(this.qw.getString(R.string.import_files_fail));
                feVar.uk(true);
            }
            str2 = "SysFile_Suc";
        } else {
            feVar.m1009if(this.qw.getString(R.string.import_files_fail));
            feVar.uk(true);
        }
        fe.mmm.qw.xxx.pf.qw.ad(str2, (String) null, (String) null, (Map) null, 14, (Object) null);
        if (!(str == null || str.length() == 0)) {
            feVar.i(false);
            feVar.uk(true);
            if (z) {
                feVar.pf(list);
                feVar.o(true);
            }
        }
        return feVar;
    }

    public final void setIsSelectMode$app_main_aiscanConfigRelease(boolean z) {
        fe.mmm.qw.th.qw.th.p031switch.ad.de(this.f6984yj, Boolean.valueOf(z));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000a, code lost:
        if ((r7.length == 0) != false) goto L_0x000c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void th(java.io.File[] r7, java.util.List<java.io.File> r8, fe.mmm.qw.xxx.uk.ppp.qw r9) {
        /*
            r6 = this;
            r0 = 0
            r1 = 1
            if (r7 == 0) goto L_0x000c
            int r2 = r7.length
            if (r2 != 0) goto L_0x0009
            r2 = 1
            goto L_0x000a
        L_0x0009:
            r2 = 0
        L_0x000a:
            if (r2 == 0) goto L_0x000d
        L_0x000c:
            r0 = 1
        L_0x000d:
            if (r0 == 0) goto L_0x0010
            return
        L_0x0010:
            java.util.Iterator r7 = kotlin.jvm.internal.ArrayIteratorKt.iterator(r7)
        L_0x0014:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x006e
            java.lang.Object r0 = r7.next()
            java.io.File r0 = (java.io.File) r0
            if (r0 != 0) goto L_0x0023
            goto L_0x0014
        L_0x0023:
            boolean r1 = r0.isHidden()
            if (r1 != 0) goto L_0x0014
            java.lang.String r1 = r0.getName()
            java.lang.String r2 = "file.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r3 = "getDefault()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.String r1 = r1.toLowerCase(r2)
            java.lang.String r2 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r2 = "android"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x004d
            goto L_0x0014
        L_0x004d:
            boolean r1 = r0.isDirectory()
            if (r1 == 0) goto L_0x0060
            java.io.File[] r0 = r0.listFiles(r9)
            java.lang.String r1 = "file.listFiles(documentFileFilter)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r6.th(r0, r8, r9)
            goto L_0x0014
        L_0x0060:
            long r1 = r0.length()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0014
            r8.add(r0)
            goto L_0x0014
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.main.importfile.viewmodel.ImportDocFileViewModel.th(java.io.File[], java.util.List, fe.mmm.qw.xxx.uk.ppp.qw):void");
    }
}
