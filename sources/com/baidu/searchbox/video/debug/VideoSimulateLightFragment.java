package com.baidu.searchbox.video.debug;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.flowvideo.simulate.FirstOptionModel;
import com.baidu.searchbox.flowvideo.simulate.SecondOptionModel;
import com.baidu.searchbox.flowvideo.simulate.VideoSimulateCUIDRepository;
import com.baidu.searchbox.player.utils.ViewUtil;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\fH\u0002J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/video/debug/VideoSimulateLightFragment;", "Landroidx/fragment/app/Fragment;", "firstOptionList", "", "Lcom/baidu/searchbox/flowvideo/simulate/FirstOptionModel;", "(Ljava/util/List;)V", "firstOptionAdapter", "Lcom/baidu/searchbox/video/debug/FirstOptionAdapter;", "firstRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "indexView", "secondOptionAdapter", "Lcom/baidu/searchbox/video/debug/SecondOptionAdapter;", "secondOptionsList", "", "Lcom/baidu/searchbox/flowvideo/simulate/SecondOptionModel;", "secondRecyclerView", "getFirstOptionAdapter", "getRightData", "id", "", "getSecondOptionAdapter", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "resetOption", "", "isResetResult", "", "setIndexView", "position", "", "video-debug_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoSimulateActivity.kt */
public final class VideoSimulateLightFragment extends Fragment {
    private FirstOptionAdapter firstOptionAdapter;
    /* access modifiers changed from: private */
    public final List<FirstOptionModel> firstOptionList;
    private RecyclerView firstRecyclerView;
    private RecyclerView indexView;
    /* access modifiers changed from: private */
    public SecondOptionAdapter secondOptionAdapter;
    /* access modifiers changed from: private */
    public List<SecondOptionModel> secondOptionsList;
    private RecyclerView secondRecyclerView;

    public VideoSimulateLightFragment(List<FirstOptionModel> firstOptionList2) {
        Intrinsics.checkNotNullParameter(firstOptionList2, "firstOptionList");
        this.firstOptionList = firstOptionList2;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view2 = inflater.inflate(R.layout.video_debug_simulate_light_fragment, container, false);
        View findViewById = view2.findViewById(R.id.first_level_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.first_level_container)");
        this.firstRecyclerView = (RecyclerView) findViewById;
        View findViewById2 = view2.findViewById(R.id.second_level_container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.second_level_container)");
        this.secondRecyclerView = (RecyclerView) findViewById2;
        View findViewById3 = view2.findViewById(R.id.index_container);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.index_container)");
        this.indexView = (RecyclerView) findViewById3;
        ((LinearLayout) view2.findViewById(R.id.main_level_container)).setLayoutParams(new LinearLayout.LayoutParams(-1, DIFactory.INSTANCE.getDisplayHeight() - ViewUtil.dp2px(240.0f)));
        ((TextView) view2.findViewById(R.id.second_commit)).setOnClickListener(new VideoSimulateLightFragment$$ExternalSyntheticLambda0(this));
        RecyclerView recyclerView = this.firstRecyclerView;
        List<SecondOptionModel> list = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstRecyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        resetOption(false);
        this.firstOptionAdapter = getFirstOptionAdapter();
        RecyclerView recyclerView2 = this.firstRecyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstRecyclerView");
            recyclerView2 = null;
        }
        FirstOptionAdapter firstOptionAdapter2 = this.firstOptionAdapter;
        if (firstOptionAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstOptionAdapter");
            firstOptionAdapter2 = null;
        }
        recyclerView2.setAdapter(firstOptionAdapter2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView3 = this.secondRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondRecyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(layoutManager);
        this.secondOptionAdapter = getSecondOptionAdapter();
        RecyclerView recyclerView4 = this.secondRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondRecyclerView");
            recyclerView4 = null;
        }
        SecondOptionAdapter secondOptionAdapter2 = this.secondOptionAdapter;
        if (secondOptionAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondOptionAdapter");
            secondOptionAdapter2 = null;
        }
        recyclerView4.setAdapter(secondOptionAdapter2);
        FirstOptionAdapter firstOptionAdapter3 = this.firstOptionAdapter;
        if (firstOptionAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("firstOptionAdapter");
            firstOptionAdapter3 = null;
        }
        firstOptionAdapter3.setData(this.firstOptionList);
        this.secondOptionsList = new ArrayList();
        SecondOptionAdapter secondOptionAdapter3 = this.secondOptionAdapter;
        if (secondOptionAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondOptionAdapter");
            secondOptionAdapter3 = null;
        }
        List<SecondOptionModel> list2 = this.secondOptionsList;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondOptionsList");
        } else {
            list = list2;
        }
        secondOptionAdapter3.setData(list);
        return view2;
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreateView$lambda-0  reason: not valid java name */
    public static final void m5304onCreateView$lambda0(VideoSimulateLightFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoSimulateCUIDRepository mRepos = DIFactory.INSTANCE.makeVideoSimulateCUIDRepos();
        HashMap params = new HashMap();
        for (FirstOptionModel firstOptionModel : this$0.firstOptionList) {
            String result = "";
            List options = firstOptionModel.getOptions();
            if (options != null && !options.isEmpty()) {
                Iterator<SecondOptionModel> it2 = options.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    SecondOptionModel secondOptionModel = it2.next();
                    if (secondOptionModel.isSelected()) {
                        result = secondOptionModel.getValue();
                        break;
                    }
                }
            } else {
                String result2 = firstOptionModel.getResult();
                if (result2 == null) {
                    result2 = "";
                }
                result = result2;
            }
            if (!StringsKt.isBlank(result)) {
                params.put(firstOptionModel.getId(), result);
            }
        }
        if (!params.isEmpty()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new VideoSimulateLightFragment$onCreateView$1$1(mRepos, params, this$0, (Continuation<? super VideoSimulateLightFragment$onCreateView$1$1>) null), 2, (Object) null);
        } else {
            Toast.makeText(this$0.getContext(), "至少选择一个选项！", 0).show();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r0 = r1.getOptions();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.baidu.searchbox.flowvideo.simulate.SecondOptionModel> getRightData(java.lang.String r6) {
        /*
            r5 = this;
            java.util.List<com.baidu.searchbox.flowvideo.simulate.FirstOptionModel> r0 = r5.firstOptionList
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0021
            java.lang.Object r1 = r0.next()
            r2 = r1
            com.baidu.searchbox.flowvideo.simulate.FirstOptionModel r2 = (com.baidu.searchbox.flowvideo.simulate.FirstOptionModel) r2
            r3 = 0
            java.lang.String r4 = r2.getId()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r6)
            if (r2 == 0) goto L_0x0008
            goto L_0x0022
        L_0x0021:
            r1 = 0
        L_0x0022:
            com.baidu.searchbox.flowvideo.simulate.FirstOptionModel r1 = (com.baidu.searchbox.flowvideo.simulate.FirstOptionModel) r1
            if (r1 == 0) goto L_0x002c
            java.util.List r0 = r1.getOptions()
            if (r0 != 0) goto L_0x0030
        L_0x002c:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0030:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.debug.VideoSimulateLightFragment.getRightData(java.lang.String):java.util.List");
    }

    static /* synthetic */ void resetOption$default(VideoSimulateLightFragment videoSimulateLightFragment, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        videoSimulateLightFragment.resetOption(z);
    }

    private final void resetOption(boolean isResetResult) {
        for (FirstOptionModel firstOption : this.firstOptionList) {
            firstOption.setSelected(false);
            if (isResetResult) {
                firstOption.setResult((String) null);
                List<SecondOptionModel> secondOptions = firstOption.getOptions();
                if (secondOptions != null) {
                    for (SecondOptionModel secondOption : secondOptions) {
                        secondOption.setSelected(false);
                    }
                }
            }
        }
    }

    private final FirstOptionAdapter getFirstOptionAdapter() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "this.requireContext()");
        return new FirstOptionAdapter(requireContext, new VideoSimulateLightFragment$getFirstOptionAdapter$1(this));
    }

    /* access modifiers changed from: private */
    public final void setIndexView(int position) {
        RecyclerView recyclerView = null;
        if (!Intrinsics.areEqual((Object) this.firstOptionList.get(position).getId(), (Object) "city") || !this.firstOptionList.get(position).isSelected()) {
            RecyclerView recyclerView2 = this.indexView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("indexView");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.setVisibility(8);
            return;
        }
        RecyclerView recyclerView3 = this.indexView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indexView");
            recyclerView3 = null;
        }
        recyclerView3.setVisibility(0);
        List indexList = new ArrayList();
        List options = this.firstOptionList.get(position).getOptions();
        if (options != null) {
            int index = 0;
            for (Object item$iv : options) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SecondOptionModel option = (SecondOptionModel) item$iv;
                if (option.isIndex()) {
                    indexList.add(new IndexModel(option.getValue(), index));
                }
                index = index$iv;
            }
        }
        RecyclerView recyclerView4 = this.indexView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indexView");
            recyclerView4 = null;
        }
        recyclerView4.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView5 = this.indexView;
        if (recyclerView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("indexView");
            recyclerView5 = null;
        }
        RecyclerView recyclerView6 = this.secondRecyclerView;
        if (recyclerView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("secondRecyclerView");
        } else {
            recyclerView = recyclerView6;
        }
        recyclerView5.setAdapter(new IndexListAdapter(indexList, recyclerView));
    }

    private final SecondOptionAdapter getSecondOptionAdapter() {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "this.requireContext()");
        return new SecondOptionAdapter(requireContext, new VideoSimulateLightFragment$getSecondOptionAdapter$1(this));
    }
}
