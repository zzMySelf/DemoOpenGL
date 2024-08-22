package com.baidu.browser.explore.mutable.feature;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.util.concurrent.UiThreadUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.browser.R;
import com.baidu.browser.components.commonmenu.advancefilter.AdvanceFilterEvent;
import com.baidu.browser.components.commonmenu.advancefilter.AdvanceFilterMenu;
import com.baidu.browser.components.commonmenu.advancefilter.AdvanceFilterViewModel;
import com.baidu.browser.components.commonmenu.advancefilter.CommonMenuUbc;
import com.baidu.browser.components.commonmenu.advancefilter.TagAdvanceFilterViewModel;
import com.baidu.browser.core.util.BdViewUtils;
import com.baidu.browser.explore.GroupCardBackgroundKt;
import com.baidu.browser.explore.container.SearchBoxContainer;
import com.baidu.browser.explore.inline.view.LinkageWebView;
import com.baidu.browser.explore.loft.view.ResultPageLoftFrontView;
import com.baidu.browser.explore.mutable.IMutableContainerCallback;
import com.baidu.browser.explore.mutable.MultiTagHelperKt;
import com.baidu.browser.explore.network.NaRequestManager;
import com.baidu.browser.explore.network.SearchWifiBind4GFeature;
import com.baidu.browser.explore.tab.MultiTabContainer;
import com.baidu.browser.explore.tab.TabContainerManager;
import com.baidu.browser.explore.tab.TabHistoryManager;
import com.baidu.browser.explore.tab.na.BaseTalosTabContainer;
import com.baidu.browser.explore.tab.na.FetchNaDataRequest;
import com.baidu.browser.explore.tab.na.MultiTabComponent;
import com.baidu.browser.explore.tab.na.tag.SearchTagView;
import com.baidu.browser.explore.tab.na.tag.SearchTagViewKt;
import com.baidu.browser.explore.tab.na.tag.data.SearchTagData;
import com.baidu.browser.explore.tab.na.tag.data.SearchTagDataKt;
import com.baidu.browser.explore.tab.na.tag.data.SearchTagItem;
import com.baidu.browser.explore.tab.na.topic.TopicNaContainer;
import com.baidu.browser.explore.tab.na.utils.SearchVideoTabUtils;
import com.baidu.browser.explore.tab.webview.BaseWebViewTabContainer;
import com.baidu.browser.explore.tab.webview.MixTabContainer;
import com.baidu.browser.explore.toptip.components.searchtag.SearchTagComponent;
import com.baidu.browser.guide.ChatSearchTabGuideManager;
import com.baidu.browser.sailor.ISailorWebViewExt;
import com.baidu.browser.tablayout.SearchTabLayout;
import com.baidu.browser.tablayout.TabResourceManager;
import com.baidu.browser.tablayout.data.MoreSearchTabItem;
import com.baidu.browser.tablayout.data.MoreSearchTagItem;
import com.baidu.browser.tablayout.moretab.TabMoreLayout;
import com.baidu.browser.tabna.BaseNaTabContainer;
import com.baidu.browser.tabna.BaseTabContainer;
import com.baidu.browser.tabna.SearchTabItem;
import com.baidu.browser.tabna.model.TabContainerModel;
import com.baidu.browser.utils.SessionIdUtilKt;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.search.basic.utils.DurationManager;
import com.baidu.search.basic.utils.ResultPageABTest;
import com.baidu.search.basic.utils.SearchABTestUtils;
import com.baidu.search.core.utils.BrowserUrlUtils;
import com.baidu.search.core.utils.PreLoadBlankPageHelper;
import com.baidu.search.core.utils.SearchUrlGenerator;
import com.baidu.search.model.GroupCardParams;
import com.baidu.search.model.GroupCardParamsKt;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.browser.ForwardUtils;
import com.baidu.searchbox.browserenhanceengine.container.ContainerLifeCycleOwner;
import com.baidu.searchbox.browserenhanceengine.container.browsercontrol.GroupCardFrameLayout;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.eventmessage.FontSizeChangeMessage;
import com.baidu.searchbox.ng.browser.NgWebView;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.socialshare.BDShare;
import com.baidu.searchbox.socialshare.bean.BaiduShareContent;
import com.baidu.searchbox.ui.browsingspace.IBrowsingStatus;
import com.baidu.searchbox.ui.pulltorefresh.WebViewPullToRefreshView;
import com.baidu.searchbox.videointerface.ISearchVideoTabContainerInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010'\u001a\u00020\u0019H\u0016J\b\u0010(\u001a\u00020\u0019H\u0014J\u0012\u0010)\u001a\u00020\u00192\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J\u0012\u0010,\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010.\u001a\u00020\u00192\b\u0010/\u001a\u0004\u0018\u00010+H\u0014J\u0010\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\bH\u0002J\u0010\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0014H\u0016J\b\u00104\u001a\u00020\u0019H\u0016J\u0010\u00105\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0014H\u0002J\b\u00106\u001a\u00020\u0019H\u0016J\u001c\u00107\u001a\u0004\u0018\u00010+2\u0006\u00108\u001a\u00020\u00162\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001e\u00109\u001a\u0004\u0018\u00010\u00062\b\u0010:\u001a\u0004\u0018\u00010\u00062\b\u0010;\u001a\u0004\u0018\u00010\bH\u0016J-\u0010<\u001a\u0004\u0018\u00010\u00062\b\u0010:\u001a\u0004\u0018\u00010\u00062\b\u00101\u001a\u0004\u0018\u00010\b2\b\u0010=\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010>J\n\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u001c\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010B2\u0006\u0010*\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020\u0014H\u0014J\u0012\u0010F\u001a\u00020\u00192\b\u0010G\u001a\u0004\u0018\u00010HH\u0014J\u0012\u0010I\u001a\u00020\u00192\b\u0010G\u001a\u0004\u0018\u00010HH\u0014J\u001a\u0010J\u001a\u00020\u00192\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010K\u001a\u00020HH\u0002J\n\u0010L\u001a\u0004\u0018\u00010+H\u0002J\n\u0010M\u001a\u0004\u0018\u00010\bH\u0002J\u0014\u0010N\u001a\u0004\u0018\u00010\b2\b\u0010:\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010O\u001a\u00020\u0016H\u0016J\n\u0010P\u001a\u0004\u0018\u00010\bH\u0014J\u0010\u0010Q\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0016H\u0014J\n\u0010R\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010S\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010T\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010U\u001a\u0004\u0018\u00010\u00062\u0006\u0010V\u001a\u00020\u0014H\u0002J\u001c\u0010W\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u00010\u00062\b\u0010;\u001a\u0004\u0018\u00010\bH\u0014J\n\u0010X\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010Y\u001a\u0004\u0018\u00010+H\u0016J\n\u0010Z\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010[\u001a\u0004\u0018\u00010BH\u0014J\u0014\u0010\\\u001a\u0004\u0018\u00010+2\b\u0010:\u001a\u0004\u0018\u00010\u0006H\u0014J\n\u0010]\u001a\u0004\u0018\u00010^H\u0016J\u001e\u0010_\u001a\u0004\u0018\u00010H2\b\u0010:\u001a\u0004\u0018\u00010\u00062\b\u00101\u001a\u0004\u0018\u00010\bH\u0016J\u001e\u0010`\u001a\u0004\u0018\u00010H2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010:\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010a\u001a\u00020\u00142\b\u0010b\u001a\u0004\u0018\u00010\u00062\b\u0010c\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010d\u001a\u00020\u0019H\u0014J\u0010\u0010e\u001a\u00020\u00192\u0006\u0010f\u001a\u00020\u0014H\u0016J\b\u0010g\u001a\u00020\u0014H\u0016J\b\u0010h\u001a\u00020\u0014H\u0014J\b\u0010i\u001a\u00020\u0014H\u0014J\b\u0010j\u001a\u00020\u0014H\u0016J\b\u0010V\u001a\u00020\u0014H\u0002J$\u0010k\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010/\u001a\u0004\u0018\u00010+2\u0006\u0010l\u001a\u00020\u0014H\u0016J\b\u0010m\u001a\u00020\u0014H\u0016J\u0018\u0010n\u001a\u00020\u00192\u0006\u0010o\u001a\u00020\u00142\u0006\u0010p\u001a\u00020\u0014H\u0016J \u0010n\u001a\u00020\u00192\u0006\u0010o\u001a\u00020\u00142\u0006\u0010p\u001a\u00020\u00142\u0006\u0010q\u001a\u00020\u0014H\u0016J&\u0010r\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010\u00062\b\u0010:\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010u\u001a\u00020\u00192\b\u0010t\u001a\u0004\u0018\u00010\u0006H\u0014J\u001e\u0010v\u001a\u0004\u0018\u00010+2\b\u0010#\u001a\u0004\u0018\u00010w2\b\u0010;\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010x\u001a\u00020\u00192\b\u0010y\u001a\u0004\u0018\u00010zH\u0016J\u0018\u0010{\u001a\u00020\u00142\u0006\u0010|\u001a\u00020\u00062\u0006\u0010}\u001a\u00020\u0014H\u0016J\u0013\u0010~\u001a\u00020\u00192\t\u0010\u001a\u0005\u0018\u00010\u0001H\u0016J\u001a\u0010~\u001a\u00020\u00192\u0006\u0010|\u001a\u00020\u00062\b\u0010t\u001a\u0004\u0018\u00010\u0006H\u0016J\u0011\u0010\u0001\u001a\u00020\u00192\u0006\u0010}\u001a\u00020\u0014H\u0002J\u0013\u0010\u0001\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010wH\u0014J\u001d\u0010\u0001\u001a\u00020\u00192\t\u0010\u0001\u001a\u0004\u0018\u00010w2\u0007\u0010\u0001\u001a\u00020\u0014H\u0016J\t\u0010\u0001\u001a\u00020\u0019H\u0016J%\u0010\u0001\u001a\u00020\u00162\u0007\u0010\u0001\u001a\u00020\u00162\u0007\u0010\u0001\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0015\u0010\u0001\u001a\u00020\u00192\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u001d\u0010\u0001\u001a\u00020\u00192\b\u0010:\u001a\u0004\u0018\u00010\u00062\b\u0010;\u001a\u0004\u0018\u00010\bH\u0002J\u001b\u0010\u0001\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\b2\b\u0010:\u001a\u0004\u0018\u00010\u0006H\u0016J\u001d\u0010\u0001\u001a\u00020\u00142\b\u0010|\u001a\u0004\u0018\u00010\u00062\b\u0010t\u001a\u0004\u0018\u00010\u0006H\u0016J\t\u0010\u0001\u001a\u00020\u0019H\u0002J%\u0010\u0001\u001a\u00020\u00192\u0007\u0010\u0001\u001a\u00020\u00162\b\u0010:\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u0001\u001a\u00020\u0014H\u0014J\t\u0010\u0001\u001a\u00020\u0019H\u0016J\t\u0010\u0001\u001a\u00020\u0019H\u0016J\t\u0010\u0001\u001a\u00020\u0019H\u0002J\u001f\u0010\u0001\u001a\u00020\u00192\t\u0010\u0001\u001a\u0004\u0018\u00010+2\t\u0010\u0001\u001a\u0004\u0018\u00010+H\u0016J\u0015\u0010\u0001\u001a\u0004\u0018\u00010B2\b\u0010:\u001a\u0004\u0018\u00010\u0006H\u0002J\u0019\u0010\u0001\u001a\u00020\u00192\u0006\u0010o\u001a\u00020\u00142\u0006\u0010;\u001a\u00020\bH\u0002J\u001a\u0010\u0001\u001a\u00020\u00192\u0006\u00101\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020wH\u0002J\t\u0010\u0001\u001a\u00020\u0019H\u0002J\t\u0010 \u0001\u001a\u00020\u0019H\u0014J\t\u0010¡\u0001\u001a\u00020\u0019H\u0002J'\u0010¢\u0001\u001a\u00020\u00192\t\u0010£\u0001\u001a\u0004\u0018\u00010B2\b\u0010*\u001a\u0004\u0018\u00010D2\u0007\u0010¤\u0001\u001a\u00020\u0014H\u0002J1\u0010¥\u0001\u001a\u00020\u00192&\u0010|\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0011j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR.\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0011j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b`\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R-\u0010\u001f\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0019\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000RB\u0010$\u001a6\u0012\u0013\u0012\u00110\b¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u0019\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000¨\u0006¦\u0001"}, d2 = {"Lcom/baidu/browser/explore/mutable/feature/MultiTagsFeature;", "Lcom/baidu/browser/explore/mutable/feature/MultiTabFeature;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "WEBVIEW_MAP_KEY_ALL_TAG_PD", "", "currClickTag", "Lcom/baidu/browser/explore/tab/na/tag/data/SearchTagItem;", "getCurrClickTag", "()Lcom/baidu/browser/explore/tab/na/tag/data/SearchTagItem;", "setCurrClickTag", "(Lcom/baidu/browser/explore/tab/na/tag/data/SearchTagItem;)V", "currClickTagForFilter", "getCurrClickTagForFilter", "setCurrClickTagForFilter", "currClickTagForVsFilterMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "enableResultFeaturePullToRefresh", "", "mDisplayWidth", "", "moreClick", "Lkotlin/Function0;", "", "multiTabComponent", "Lcom/baidu/browser/explore/tab/na/MultiTabComponent;", "needShowClearBackToast", "searchTagComponent", "Lcom/baidu/browser/explore/toptip/components/searchtag/SearchTagComponent;", "tagReClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "item", "tagsClick", "Lkotlin/Function2;", "tagInfo", "backToAllTag", "beforTabSwitch", "beforeContainerShow", "tabContainer", "Lcom/baidu/browser/tabna/BaseTabContainer;", "canBackToAllTag", "container", "changeCurrentContainerTo", "newContainer", "changeTag", "tag", "clearBtnClick", "isReClick", "clearFilters", "clearVsFilter", "closeMoreTabLayout", "convertMulContainer", "index", "createContainerKeyByPd", "pd", "tagItem", "createWebviewKeyByPd", "useCurrContainertag", "(Ljava/lang/String;Lcom/baidu/browser/explore/tab/na/tag/data/SearchTagItem;Ljava/lang/Boolean;)Ljava/lang/String;", "curSearchTagView", "Lcom/baidu/browser/explore/tab/na/tag/SearchTagView;", "enablePullToRefresh", "Landroid/view/View;", "refreshableView", "Lcom/baidu/browser/explore/tab/MultiTabContainer;", "enableResultFeatureToPull", "enableSearchTagNestedScroll", "webView", "Lcom/baidu/searchbox/ng/browser/NgWebView;", "enableSearchTagNestedScrollInt", "fixWebView", "webview", "getAllNoFilterContainer", "getAllTagWithoutFilter", "getAllTagWithoutVsFilter", "getBackContainerPos", "getClickTag", "getContainerPageParamsKey", "getCurrAllTagUrl", "getCurrentFilterTitle", "getFavorUrl", "getFilterUrl", "isInAllTab", "getGroupCardKey", "getInterceptUrlForRefresh", "getPreContainerFromHistory", "getReplaceTagUrl", "getTagRootView", "getTagTabContainer", "getWeakNetWorkParent", "Landroid/view/ViewGroup;", "getWebView", "getWebviewByContainerAndPd", "handleShare", "entrance", "page", "hideDegrateErrorPage", "hideLoadingView", "isSuccess", "ifCanScrollRightByTag", "isBrowsingTab", "isFilterSelected", "isFilterTag", "isResultPageBackTab", "isFromSnapshot", "isTag2Show", "moreItemHandle", "show", "needScroll", "showAnim", "naContainerRequest", "Lcom/baidu/browser/tabna/BaseNaTabContainer;", "url", "naDegrateRefresh", "obtainContainer", "Lcom/baidu/browser/tabna/SearchTabItem;", "onFontSizeChange", "event", "Lcom/baidu/searchbox/config/eventmessage/FontSizeChangeMessage;", "onHandleMultiTab", "params", "fromProtoBuf", "onHandleNaProtoTagSearch", "data", "Lcom/baidu/browser/explore/tab/na/tag/data/SearchTagData;", "onHandleTagSearchAfterTab", "onItemClick", "onNaTabPageShow", "tabItem", "hasReportUpScreen", "onPause", "onPreMotionMoveEventOnTagMode", "dx", "dy", "consumed", "", "onResume", "intent", "Landroid/content/Intent;", "onVsTagClick", "onWebViewTagClick", "parseTabInfo", "registerAdvanceFilterEvent", "removeItemAtPosition", "pos", "fromDegrate", "removeTagInfo", "removeTagView", "resetPullToRefreshView", "scrollAutoRightEnd", "currContainer", "preContainer", "setPullToRefreshView", "showFilterLayout", "switchContainerAndRequest", "unregisterAdvanceFilterEvent", "updateMoreLayoutUI", "updateMoreLayoutUIOnTop", "updateRefreshViewTopMargin", "refreshView", "isTagShow", "updateTagAdvanceUrl", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MultiTagsFeature.kt */
public class MultiTagsFeature extends MultiTabFeature {
    private final String WEBVIEW_MAP_KEY_ALL_TAG_PD = "all";
    private SearchTagItem currClickTag;
    private SearchTagItem currClickTagForFilter;
    private HashMap<String, SearchTagItem> currClickTagForVsFilterMap;
    private boolean enableResultFeaturePullToRefresh;
    private int mDisplayWidth;
    private Function0<Unit> moreClick;
    private final MultiTabComponent multiTabComponent;
    private boolean needShowClearBackToast;
    private final SearchTagComponent searchTagComponent;
    /* access modifiers changed from: private */
    public Function1<? super SearchTagItem, Unit> tagReClick;
    /* access modifiers changed from: private */
    public Function2<? super SearchTagItem, ? super String, Unit> tagsClick;

    public MultiTagsFeature(Context context) {
        super(context);
        MultiTabComponent multiTabComponent2 = new MultiTabComponent();
        this.multiTabComponent = multiTabComponent2;
        this.searchTagComponent = new SearchTagComponent(multiTabComponent2);
        this.enableResultFeaturePullToRefresh = true;
        this.currClickTagForVsFilterMap = new HashMap<>();
        this.tagsClick = new MultiTagsFeature$tagsClick$1(this);
        this.tagReClick = new MultiTagsFeature$tagReClick$1(this);
        this.moreClick = new MultiTagsFeature$moreClick$1(this);
    }

    public final SearchTagItem getCurrClickTag() {
        return this.currClickTag;
    }

    public final void setCurrClickTag(SearchTagItem searchTagItem) {
        this.currClickTag = searchTagItem;
    }

    public final SearchTagItem getCurrClickTagForFilter() {
        return this.currClickTagForFilter;
    }

    public final void setCurrClickTagForFilter(SearchTagItem searchTagItem) {
        this.currClickTagForFilter = searchTagItem;
    }

    public ViewGroup getWeakNetWorkParent() {
        BaseTabContainer baseTabContainer = this.mCurTabContainer;
        FrameLayout frameLayout = null;
        BaseTabContainer parentContainer = baseTabContainer != null ? baseTabContainer.getParentContainer() : null;
        MultiTabContainer multiTabContainer = parentContainer instanceof MultiTabContainer ? (MultiTabContainer) parentContainer : null;
        if (multiTabContainer != null) {
            frameLayout = multiTabContainer.getRootView();
        }
        FrameLayout rootView = frameLayout;
        if (!ResultPageABTest.isFixLoading() || rootView == null || rootView.getParent() != null) {
            return super.getWeakNetWorkParent();
        }
        ViewGroup viewGroup = this.topRefreshView;
        if (viewGroup == null) {
            viewGroup = this.mResultPageLoftFrontView;
        }
        return viewGroup;
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.widget.FrameLayout$LayoutParams] */
    /* JADX WARNING: type inference failed for: r2v4, types: [androidx.constraintlayout.widget.ConstraintLayout$LayoutParams] */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.browser.tabna.BaseTabContainer convertMulContainer(int r11, com.baidu.browser.tabna.BaseTabContainer r12) {
        /*
            r10 = this;
            android.content.Context r0 = r10.getContext()
            if (r0 == 0) goto L_0x015c
            if (r12 != 0) goto L_0x000a
            goto L_0x015c
        L_0x000a:
            boolean r1 = r10.isValidPosition(r11)
            r2 = 0
            if (r1 == 0) goto L_0x002e
            com.baidu.searchbox.multitab.adapter.ContainerViewPagerAdapter r1 = r10.getContainerAdapter()
            java.util.List r1 = r1.getContainers()
            java.lang.Object r1 = r1.get(r11)
            if (r1 == 0) goto L_0x002e
            com.baidu.searchbox.multitab.adapter.ContainerViewPagerAdapter r1 = r10.getContainerAdapter()
            java.util.List r1 = r1.getContainers()
            java.lang.Object r1 = r1.get(r11)
            com.baidu.browser.tabna.BaseTabContainer r1 = (com.baidu.browser.tabna.BaseTabContainer) r1
            goto L_0x0032
        L_0x002e:
            r1 = r2
            com.baidu.browser.tabna.BaseTabContainer r1 = (com.baidu.browser.tabna.BaseTabContainer) r1
            r1 = r2
        L_0x0032:
            com.baidu.browser.tabna.BaseTabContainer r3 = r12.getParentContainer()
            boolean r3 = r3 instanceof com.baidu.browser.explore.tab.MultiTabContainer
            if (r3 == 0) goto L_0x004e
            if (r1 == 0) goto L_0x0049
            com.baidu.browser.tabna.BaseTabContainer r3 = r12.getParentContainer()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 != 0) goto L_0x0049
            r3 = r1
            goto L_0x0075
        L_0x0049:
            com.baidu.browser.tabna.BaseTabContainer r3 = r12.getParentContainer()
            goto L_0x0075
        L_0x004e:
            if (r1 == 0) goto L_0x005f
            com.baidu.searchbox.multitab.adapter.ContainerViewPagerAdapter r3 = r10.getContainerAdapter()
            java.util.List r3 = r3.getContainers()
            java.lang.Object r3 = r3.get(r11)
            com.baidu.browser.tabna.BaseTabContainer r3 = (com.baidu.browser.tabna.BaseTabContainer) r3
            goto L_0x0063
        L_0x005f:
            r3 = r2
            com.baidu.browser.tabna.BaseTabContainer r3 = (com.baidu.browser.tabna.BaseTabContainer) r3
            r3 = r2
        L_0x0063:
            if (r3 != 0) goto L_0x0075
            com.baidu.browser.explore.tab.MultiTabContainer r3 = new com.baidu.browser.explore.tab.MultiTabContainer
            com.baidu.searchbox.browserenhanceengine.container.ContainerModel r4 = r12.getContainerModel()
            com.baidu.browser.tabna.model.TabContainerModel r4 = (com.baidu.browser.tabna.model.TabContainerModel) r4
            r5 = r10
            com.baidu.browser.tabna.IResultPageTabContext r5 = (com.baidu.browser.tabna.IResultPageTabContext) r5
            r3.<init>(r0, r4, r5)
            com.baidu.browser.tabna.BaseTabContainer r3 = (com.baidu.browser.tabna.BaseTabContainer) r3
        L_0x0075:
            boolean r4 = r3 instanceof com.baidu.browser.explore.tab.MultiTabContainer
            if (r4 != 0) goto L_0x007b
            return r12
        L_0x007b:
            r12.setParentContainer(r3)
            boolean r4 = r10.isChatSearchTabContainer(r12)
            r5 = 0
            r6 = 0
            if (r4 == 0) goto L_0x0108
            com.baidu.searchbox.multitab.adapter.ContainerViewPagerAdapter r4 = r10.getContainerAdapter()
            boolean r4 = r4.getFromRestore()
            if (r4 != 0) goto L_0x0108
            com.baidu.searchbox.multitab.MultiTabManager r4 = r10.mMultiTabManager
            java.util.List r4 = r4.getTabList()
            if (r4 == 0) goto L_0x00a4
            com.baidu.searchbox.multitab.MultiTabManager r4 = r10.mMultiTabManager
            java.util.List r4 = r4.getTabList()
            int r4 = r4.size()
            if (r4 != 0) goto L_0x0108
        L_0x00a4:
            android.view.View r4 = r12.rootView()
            int r7 = r10.getMultiTabHeight()
            android.view.ViewGroup$LayoutParams r8 = r4.getLayoutParams()
            boolean r8 = r8 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r8 == 0) goto L_0x00c6
            android.view.ViewGroup$LayoutParams r8 = r4.getLayoutParams()
            boolean r9 = r8 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r9 == 0) goto L_0x00bf
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r8 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r8
            goto L_0x00c0
        L_0x00bf:
            r8 = r2
        L_0x00c0:
            if (r8 != 0) goto L_0x00c3
            goto L_0x00df
        L_0x00c3:
            r8.topMargin = r7
            goto L_0x00df
        L_0x00c6:
            android.view.ViewGroup$LayoutParams r8 = r4.getLayoutParams()
            boolean r8 = r8 instanceof android.widget.FrameLayout.LayoutParams
            if (r8 == 0) goto L_0x00df
            android.view.ViewGroup$LayoutParams r8 = r4.getLayoutParams()
            boolean r9 = r8 instanceof android.widget.FrameLayout.LayoutParams
            if (r9 == 0) goto L_0x00d9
            android.widget.FrameLayout$LayoutParams r8 = (android.widget.FrameLayout.LayoutParams) r8
            goto L_0x00da
        L_0x00d9:
            r8 = r2
        L_0x00da:
            if (r8 != 0) goto L_0x00dd
            goto L_0x00df
        L_0x00dd:
            r8.topMargin = r7
        L_0x00df:
            com.baidu.browser.explore.container.SearchBoxContainer r8 = r10.getContainer()
            if (r8 == 0) goto L_0x00e9
            android.widget.FrameLayout r2 = r8.getContainerFrameLayout()
        L_0x00e9:
            if (r2 == 0) goto L_0x00fd
            com.baidu.browser.core.util.BdViewUtils.removeFromParent(r4)
            com.baidu.browser.explore.container.SearchBoxContainer r2 = r10.getContainer()
            if (r2 == 0) goto L_0x00fd
            android.widget.FrameLayout r2 = r2.getContainerFrameLayout()
            if (r2 == 0) goto L_0x00fd
            r2.addView(r4)
        L_0x00fd:
            r10.setSearchBoxViewAlpha(r5)
            r4.setVisibility(r6)
            r2 = 1
            r10.setChatSearchFromLoadUrl(r2)
            goto L_0x015b
        L_0x0108:
            r4 = r3
            com.baidu.browser.explore.tab.MultiTabContainer r4 = (com.baidu.browser.explore.tab.MultiTabContainer) r4
            boolean r7 = r10.isFixMode()
            r4.setContainer(r12, r7)
            r4 = r3
            com.baidu.browser.explore.tab.MultiTabContainer r4 = (com.baidu.browser.explore.tab.MultiTabContainer) r4
            r4.setCurrentContainer(r12)
            boolean r4 = r10.isChatSearchTabContainer(r12)
            if (r4 == 0) goto L_0x015b
            android.view.View r4 = r12.rootView()
            if (r4 == 0) goto L_0x0158
            r7 = 0
            android.view.ViewGroup$LayoutParams r8 = r4.getLayoutParams()
            boolean r8 = r8 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r8 == 0) goto L_0x013e
            android.view.ViewGroup$LayoutParams r8 = r4.getLayoutParams()
            boolean r9 = r8 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r9 == 0) goto L_0x0138
            r2 = r8
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r2 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r2
        L_0x0138:
            if (r2 != 0) goto L_0x013b
            goto L_0x0156
        L_0x013b:
            r2.topMargin = r6
            goto L_0x0156
        L_0x013e:
            android.view.ViewGroup$LayoutParams r8 = r4.getLayoutParams()
            boolean r8 = r8 instanceof android.widget.FrameLayout.LayoutParams
            if (r8 == 0) goto L_0x0156
            android.view.ViewGroup$LayoutParams r8 = r4.getLayoutParams()
            boolean r9 = r8 instanceof android.widget.FrameLayout.LayoutParams
            if (r9 == 0) goto L_0x0151
            r2 = r8
            android.widget.FrameLayout$LayoutParams r2 = (android.widget.FrameLayout.LayoutParams) r2
        L_0x0151:
            if (r2 != 0) goto L_0x0154
            goto L_0x0156
        L_0x0154:
            r2.topMargin = r6
        L_0x0156:
        L_0x0158:
            r10.setSearchBoxViewAlpha(r5)
        L_0x015b:
            return r3
        L_0x015c:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.explore.mutable.feature.MultiTagsFeature.convertMulContainer(int, com.baidu.browser.tabna.BaseTabContainer):com.baidu.browser.tabna.BaseTabContainer");
    }

    /* access modifiers changed from: protected */
    public void beforeContainerShow(BaseTabContainer tabContainer) {
        WebViewPullToRefreshView webViewPullToRefreshView;
        Boolean isTagBack = SearchABTestUtils.isTagBack();
        Intrinsics.checkNotNullExpressionValue(isTagBack, "isTagBack()");
        if (isTagBack.booleanValue() && (this.mCurTabContainer instanceof BaseWebViewTabContainer)) {
            setWebviewStatus("pause");
            abandonEasterEgg();
        }
        super.beforeContainerShow(tabContainer);
        BaseTabContainer baseTabContainer = this.mCurTabContainer;
        MultiTabContainer multiTabContainer = null;
        ContainerLifeCycleOwner parentContainer = baseTabContainer != null ? baseTabContainer.getParentContainer() : null;
        if (parentContainer instanceof MultiTabContainer) {
            multiTabContainer = (MultiTabContainer) parentContainer;
        }
        if (multiTabContainer == null || (webViewPullToRefreshView = multiTabContainer.getRefreshView()) == null) {
            webViewPullToRefreshView = this.topRefreshView;
        }
        this.mRefreshView = webViewPullToRefreshView;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.baidu.browser.tabna.BaseTabContainer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.baidu.browser.tabna.BaseTabContainer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.baidu.browser.tabna.BaseTabContainer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: com.baidu.browser.tabna.BaseTabContainer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: com.baidu.browser.tabna.BaseTabContainer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: com.baidu.browser.tabna.BaseTabContainer} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.baidu.browser.tabna.BaseTabContainer getTagTabContainer(java.lang.String r8) {
        /*
            r7 = this;
            com.baidu.browser.tabna.BaseTabContainer r0 = r7.mCurTabContainer
            boolean r0 = r7.isTabContainer(r8, r0)
            if (r0 == 0) goto L_0x0013
            com.baidu.browser.tabna.BaseTabContainer r0 = r7.mCurTabContainer
            if (r0 == 0) goto L_0x0013
            com.baidu.browser.tabna.BaseTabContainer r0 = r7.mCurTabContainer
            com.baidu.browser.tabna.BaseTabContainer r0 = r0.getParentContainer()
            return r0
        L_0x0013:
            boolean r0 = r7.isViewPageDragging()
            if (r0 == 0) goto L_0x002a
            com.baidu.browser.tabna.BaseTabContainer r0 = r7.mCurDraggingContainer
            if (r0 == 0) goto L_0x002a
            com.baidu.browser.tabna.BaseTabContainer r0 = r7.mCurDraggingContainer
            boolean r0 = r7.isTabContainer(r8, r0)
            if (r0 == 0) goto L_0x002a
            com.baidu.browser.tabna.BaseTabContainer r0 = r7.mCurDraggingContainer
            r0.getParentContainer()
        L_0x002a:
            com.baidu.searchbox.multitab.adapter.ContainerViewPagerAdapter r0 = r7.getContainerAdapter()
            java.util.List r0 = r0.getContainers()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r1 = 0
            java.util.Iterator r2 = r0.iterator()
        L_0x0039:
            boolean r3 = r2.hasNext()
            r4 = 0
            if (r3 == 0) goto L_0x0056
            java.lang.Object r3 = r2.next()
            r5 = r3
            com.baidu.browser.tabna.BaseTabContainer r5 = (com.baidu.browser.tabna.BaseTabContainer) r5
            r6 = 0
            if (r5 == 0) goto L_0x004e
            com.baidu.browser.tabna.BaseTabContainer r4 = r5.getContainer()
        L_0x004e:
            boolean r4 = r7.isTabContainer(r8, r4)
            if (r4 == 0) goto L_0x0039
            r4 = r3
            goto L_0x0057
        L_0x0056:
        L_0x0057:
            com.baidu.browser.tabna.BaseTabContainer r4 = (com.baidu.browser.tabna.BaseTabContainer) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.explore.mutable.feature.MultiTagsFeature.getTagTabContainer(java.lang.String):com.baidu.browser.tabna.BaseTabContainer");
    }

    public void onHandleNaProtoTagSearch(SearchTagData data) {
        Context context;
        NgWebView webView;
        View refreshview;
        AdvanceFilterEvent advanceFilterEvent;
        if (data != null && (context = getContext()) != null) {
            String pd = data.getPd();
            BaseTabContainer tagTabContainer = getTagTabContainer(pd);
            HashMap<String, String> hashMap = null;
            if (tagTabContainer == null) {
                BaseTabContainer baseTabContainer = this.mCurTabContainer;
                tagTabContainer = baseTabContainer != null ? baseTabContainer.getParentContainer() : null;
            }
            BaseTabContainer curTabContainer = tagTabContainer;
            if ((curTabContainer != null ? curTabContainer.rootView() : null) != null) {
                MultiTabContainer multiTabContainer = curTabContainer instanceof MultiTabContainer ? (MultiTabContainer) curTabContainer : null;
                if (multiTabContainer != null) {
                    MultiTabContainer tabContainer = multiTabContainer;
                    SearchTabItem tabItem = tabContainer.getTabItem();
                    boolean z = false;
                    if ((tabItem != null && tabItem.isNote()) || tabContainer.getSearchTagView() == null) {
                        if (ResultPageABTest.isChatSearchTab()) {
                            SearchTabItem tabItem2 = tabContainer.getTabItem();
                            if (tabItem2 != null && tabItem2.isChatSearch()) {
                                return;
                            }
                        }
                        if (!ResultPageABTest.isMoveFilterToTab() || data.getTags().size() != 0) {
                            CharSequence charSequence = pd;
                            if (charSequence == null || charSequence.length() == 0) {
                                z = true;
                            }
                            if (z) {
                                webView = getSearchWebView();
                            } else {
                                webView = (NgWebView) getTabNgWebViewMaps().get(MultiTabFeature.createWebviewKeyByPd$default(this, pd, (SearchTagItem) null, (Boolean) null, 6, (Object) null));
                            }
                            if (webView != null && (refreshview = setPullToRefreshView(pd)) != null) {
                                updateRefreshViewTopMargin(refreshview, tabContainer, true);
                                SearchTagView searchTagView = tabContainer.getSearchTagView();
                                if (searchTagView == null) {
                                    searchTagView = new SearchTagView(context);
                                }
                                tabContainer.addTagView(searchTagView, refreshview);
                                SearchTagView it = tabContainer.getSearchTagView();
                                if (it != null) {
                                    it.setTagStatistic(new MultiTagsFeature$onHandleNaProtoTagSearch$1$1(this));
                                    it.onHandleNaProtoTagSearch(data);
                                    updateSearchTagView();
                                    updateCoordinatorScrollState();
                                    it.setTagClick(this.tagsClick);
                                    it.setTagReClick(this.tagReClick);
                                    it.setMoreClick(this.moreClick);
                                    if (isMultiTabAll(tabContainer.getContainer())) {
                                        AdvanceFilterViewModel adVanceFilterVm = getAdVanceFilterVm();
                                        if (!(adVanceFilterVm == null || (advanceFilterEvent = adVanceFilterVm.getAdvanceFilterEvent()) == null)) {
                                            hashMap = advanceFilterEvent.getParams();
                                        }
                                        updateTagAdvanceUrl(hashMap);
                                    }
                                }
                                updateTagWebView(this.scrollOffset);
                                WebViewPullToRefreshView refreshView = tabContainer.getRefreshView();
                                if (refreshView == null) {
                                    refreshView = this.topRefreshView;
                                }
                                this.mRefreshView = refreshView;
                                enableSearchTagNestedScroll(webView);
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void enableSearchTagNestedScroll(NgWebView webView) {
        if (!ResultPageABTest.isNewDoubleTab()) {
            enableSearchTagNestedScrollInt(webView);
        }
    }

    /* access modifiers changed from: protected */
    public void enableSearchTagNestedScrollInt(NgWebView webView) {
        ResultPageLoftFrontView resultPageLoftFrontView;
        CoordinatorLayout $this$enableSearchTagNestedScrollInt_u24lambda_u2d5;
        if (SearchABTestUtils.enableSearchTagNestedScroll() && (resultPageLoftFrontView = this.mResultPageLoftFrontView) != null && ($this$enableSearchTagNestedScrollInt_u24lambda_u2d5 = resultPageLoftFrontView.getCoordianatoLayout()) != null) {
            NestedScrollView nestedScrollView = (NestedScrollView) $this$enableSearchTagNestedScrollInt_u24lambda_u2d5.findViewById(R.id.search_tag_nested_scroll_helper);
            if (nestedScrollView == null) {
                nestedScrollView = new NestedScrollView($this$enableSearchTagNestedScrollInt_u24lambda_u2d5.getContext());
                NestedScrollView it = nestedScrollView;
                $this$enableSearchTagNestedScrollInt_u24lambda_u2d5.addView(it, 0);
                it.setId(R.id.search_tag_nested_scroll_helper);
                it.setLayoutParams(new CoordinatorLayout.LayoutParams(0, -1));
                it.addView(new View($this$enableSearchTagNestedScrollInt_u24lambda_u2d5.getContext()), new ViewGroup.LayoutParams(0, 0));
            }
            if (webView != null) {
                webView.addOnWebScrollToTopListener(new MultiTagsFeature$$ExternalSyntheticLambda2(this, nestedScrollView));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: enableSearchTagNestedScrollInt$lambda-5$lambda-4  reason: not valid java name */
    public static final void m12889enableSearchTagNestedScrollInt$lambda5$lambda4(MultiTagsFeature this$0, NestedScrollView $nestedScrollView, boolean isDragging, int v) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($nestedScrollView, "$nestedScrollView");
        if (!ResultPageABTest.isNewTabFrameworkOpen() || !SearchABTestUtils.isEnableResultPageFspReset()) {
            if (!isDragging) {
                $nestedScrollView.fling(v);
            }
        } else if (!isDragging && this$0.mFirstScreenPaintFinish) {
            $nestedScrollView.fling(v);
        }
    }

    private final View setPullToRefreshView(String pd) {
        NgWebView webView;
        if (ResultPageFeature.DEBUG) {
            Log.d(MultiTabFeatureKt.LOG_TAG_TWO_TAB, "setPullToRefreshView pd is " + pd);
        }
        BaseTabContainer curTabContainer = getTagTabContainer(pd);
        View bottomView = null;
        if (curTabContainer == null) {
            BaseTabContainer baseTabContainer = this.mCurTabContainer;
            curTabContainer = baseTabContainer != null ? baseTabContainer.getParentContainer() : null;
        }
        if ((curTabContainer != null ? curTabContainer.rootView() : null) == null) {
            return null;
        }
        MultiTabContainer tabContainer = curTabContainer instanceof MultiTabContainer ? (MultiTabContainer) curTabContainer : null;
        if (tabContainer == null) {
            return null;
        }
        boolean z = true;
        if (ResultPageABTest.isChatSearchTab()) {
            SearchTabItem tabItem = tabContainer.getTabItem();
            if (tabItem != null && tabItem.isChatSearch()) {
                return null;
            }
        }
        CharSequence charSequence = pd;
        if (!(charSequence == null || charSequence.length() == 0)) {
            z = false;
        }
        if (z) {
            webView = getSearchWebView();
        } else {
            webView = (NgWebView) getTabNgWebViewMaps().get(MultiTabFeature.createWebviewKeyByPd$default(this, pd, (SearchTagItem) null, (Boolean) null, 6, (Object) null));
        }
        if (webView == null) {
            return null;
        }
        if (tabContainer.getContainer() instanceof MixTabContainer) {
            BaseTabContainer container = tabContainer.getContainer();
            MixTabContainer mixTabContainer = container instanceof MixTabContainer ? (MixTabContainer) container : null;
            if (mixTabContainer != null) {
                bottomView = mixTabContainer.rootView();
            }
        } else {
            bottomView = webView;
        }
        View refreshView = enablePullToRefresh(bottomView, tabContainer);
        WebViewPullToRefreshView refreshView2 = tabContainer.getRefreshView();
        if (refreshView2 == null) {
            refreshView2 = this.topRefreshView;
        }
        this.mRefreshView = refreshView2;
        this.enableResultFeaturePullToRefresh = false;
        return refreshView;
    }

    /* access modifiers changed from: protected */
    public boolean enableResultFeatureToPull() {
        return this.enableResultFeaturePullToRefresh;
    }

    private final View enablePullToRefresh(View refreshableView, MultiTabContainer tabContainer) {
        View rootView = tabContainer.rootView();
        ViewParent viewParent = null;
        FrameLayout rootView2 = rootView instanceof FrameLayout ? (FrameLayout) rootView : null;
        if (rootView2 == null) {
            return refreshableView;
        }
        Context context = getContext();
        Resources resources = context != null ? context.getResources() : null;
        if (resources == null) {
            return rootView2;
        }
        if (refreshableView != null) {
            viewParent = refreshableView.getParent();
        }
        if (Intrinsics.areEqual((Object) viewParent, (Object) tabContainer.getRefreshView()) && tabContainer.getRefreshView() != null) {
            return tabContainer.getRefreshView();
        }
        MultiTagsFeature$enablePullToRefresh$refreshView$1 refreshView = new MultiTagsFeature$enablePullToRefresh$refreshView$1(this, tabContainer, getContext());
        if (refreshableView != null) {
            refreshableView.setId(R.id.search_tag_webview);
        }
        refreshView.setTartViewId(R.id.search_tag_webview);
        refreshView.setRefreshCompleteTipText(resources.getString(R.string.search_multi_tab_refresh_complete));
        refreshView.setLoadingViewMarginTop(DeviceUtil.ScreenInfo.dp2px(getContext(), 4.0f));
        refreshView.setTripViewBottomMargin(DeviceUtil.ScreenInfo.dp2px(getContext(), -29.0f), DeviceUtil.ScreenInfo.dp2px(getContext(), 2.0f));
        refreshView.setOnRefreshListener(new MultiTagsFeature$enablePullToRefresh$1(this));
        refreshView.setOnTargetOffsetTopListener(new MultiTagsFeature$enablePullToRefresh$2(this));
        BdViewUtils.removeFromParent(refreshableView);
        refreshView.addView(refreshableView);
        refreshView.setCurrRefreshableView(refreshableView);
        int topOffset = tabContainer.getContainerTopOffset();
        if (!(this.mCurTabContainer instanceof BaseWebViewTabContainer)) {
            FrameLayout.LayoutParams $this$enablePullToRefresh_u24lambda_u2d6 = new FrameLayout.LayoutParams(-1, -1);
            $this$enablePullToRefresh_u24lambda_u2d6.topMargin = topOffset;
            Unit unit = Unit.INSTANCE;
            rootView2.addView(refreshView, 0, $this$enablePullToRefresh_u24lambda_u2d6);
        } else {
            FrameLayout.LayoutParams $this$enablePullToRefresh_u24lambda_u2d7 = new FrameLayout.LayoutParams(-1, -1);
            $this$enablePullToRefresh_u24lambda_u2d7.topMargin = topOffset;
            Unit unit2 = Unit.INSTANCE;
            rootView2.addView(refreshView, $this$enablePullToRefresh_u24lambda_u2d7);
        }
        tabContainer.setRefreshView(refreshView);
        return refreshView;
    }

    private final void updateRefreshViewTopMargin(View refreshView, MultiTabContainer tabContainer, boolean isTagShow) {
        int i2;
        if (refreshView != null && tabContainer != null) {
            int topOffset = tabContainer.getContainerTopOffset();
            ViewGroup.LayoutParams layoutParams = refreshView.getLayoutParams();
            FrameLayout.LayoutParams $this$updateRefreshViewTopMargin_u24lambda_u2d8 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if ($this$updateRefreshViewTopMargin_u24lambda_u2d8 != null) {
                if (isTagShow) {
                    i2 = SearchTagViewKt.tagHeight() + topOffset;
                } else {
                    i2 = topOffset;
                }
                $this$updateRefreshViewTopMargin_u24lambda_u2d8.topMargin = i2;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void changeCurrentContainerTo(BaseTabContainer newContainer) {
        WebViewPullToRefreshView webViewPullToRefreshView;
        MultiTabContainer multiTabContainer = null;
        if (MultiTagHelperKt.isSwitchInFilter(getCurTabContainer(), newContainer)) {
            BaseTabContainer baseTabContainer = this.mCurTabContainer;
            BaseTabContainer parentContainer = baseTabContainer != null ? baseTabContainer.getParentContainer() : null;
            MultiTabContainer multiTabContainer2 = parentContainer instanceof MultiTabContainer ? (MultiTabContainer) parentContainer : null;
            if (multiTabContainer2 != null) {
                multiTabContainer2.saveAllTagView();
            }
            if (ResultPageFeature.DEBUG) {
                StringBuilder append = new StringBuilder().append("changeCurrentContainerTo saveAllTagView ");
                BaseTabContainer curTabContainer = getCurTabContainer();
                Log.d(MultiTagsFeatureKt.TAG_BACK_TAG, append.append(curTabContainer != null ? curTabContainer.getContainerId() : null).toString());
            }
        }
        super.changeCurrentContainerTo(newContainer);
        BaseTabContainer baseTabContainer2 = this.mCurTabContainer;
        ContainerLifeCycleOwner parentContainer2 = baseTabContainer2 != null ? baseTabContainer2.getParentContainer() : null;
        if (parentContainer2 instanceof MultiTabContainer) {
            multiTabContainer = (MultiTabContainer) parentContainer2;
        }
        if (multiTabContainer == null || (webViewPullToRefreshView = multiTabContainer.getRefreshView()) == null) {
            webViewPullToRefreshView = this.topRefreshView;
        }
        this.mRefreshView = webViewPullToRefreshView;
        if (this.mRefreshView == null) {
            return;
        }
        if ((this.mCurTabContainer instanceof BaseNaTabContainer) || (this.mCurTabContainer instanceof BaseTalosTabContainer) || isTag2Show()) {
            this.mRefreshView.setIsRefreshEnable(false);
        } else {
            this.mRefreshView.setIsRefreshEnable(true);
        }
    }

    public String getReplaceTagUrl() {
        SearchTagView curSearchTagView = curSearchTagView();
        if (curSearchTagView != null) {
            return curSearchTagView.getTagUrl();
        }
        return null;
    }

    public SearchTagView curSearchTagView() {
        BaseTabContainer baseTabContainer = this.mCurTabContainer;
        BaseTabContainer parentContainer = baseTabContainer != null ? baseTabContainer.getParentContainer() : null;
        MultiTabContainer mulContainer = parentContainer instanceof MultiTabContainer ? (MultiTabContainer) parentContainer : null;
        if (mulContainer != null) {
            return mulContainer.getSearchTagView();
        }
        BaseTabContainer baseTabContainer2 = this.mCurTabContainer;
        BaseWebViewTabContainer baseWebViewTabContainer = baseTabContainer2 instanceof BaseWebViewTabContainer ? (BaseWebViewTabContainer) baseTabContainer2 : null;
        if (baseWebViewTabContainer != null) {
            return baseWebViewTabContainer.mSearchTagView;
        }
        return null;
    }

    public boolean isTag2Show() {
        return curSearchTagView() != null;
    }

    public int onPreMotionMoveEventOnTagMode(int dx, int dy, int[] consumed) {
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        int scrollHeight = getScrollHeight();
        if (consumed.length < 2 || !isNormalBrowsingPage() || !ResultPageABTest.isImmerseSearchTag() || Math.abs(dx) >= Math.abs(dy) || scrollHeight <= 0 || !isTag2Show()) {
            return 0;
        }
        BaseTabContainer baseTabContainer = this.mCurTabContainer;
        BaseTabContainer parentContainer = baseTabContainer != null ? baseTabContainer.getParentContainer() : null;
        MultiTabContainer multiTabContainer = parentContainer instanceof MultiTabContainer ? (MultiTabContainer) parentContainer : null;
        int offset = multiTabContainer != null ? multiTabContainer.onPreMotionMoveEventOnWebMode(dx, dy, consumed) : 0;
        if (offset != 0) {
            IBrowsingStatus.DefaultImpls.updateBrowsingFraction$default(this, ((float) Math.abs(getScrollOffset())) / ((float) scrollHeight), false, 2, (Object) null);
        }
        return offset;
    }

    /* access modifiers changed from: protected */
    public void removeItemAtPosition(int pos, String pd, boolean fromDegrate) {
        TabContainerManager tabContainerManager;
        CharSequence charSequence = pd;
        if (!(charSequence == null || charSequence.length() == 0) && (tabContainerManager = this.mTabContainerManager) != null) {
            tabContainerManager.removeContainer(pd);
        }
        if (isValidPosition(pos)) {
            BaseTabContainer curContainer = getContainerAdapter().getContainers().get(pos);
            if (curContainer instanceof MultiTabContainer) {
                ((MultiTabContainer) curContainer).removeContainerView(pd);
            }
            if (!fromDegrate || !isResourceTagContainer()) {
                getContainerAdapter().getContainers().set(pos, (Object) null);
                getContainerAdapter().removeViewAtPosition(pos);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0230, code lost:
        if ((r10 ^ r11) != false) goto L_0x0235;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void changeTag(com.baidu.browser.explore.tab.na.tag.data.SearchTagItem r22) {
        /*
            r21 = this;
            r0 = r21
            r7 = r22
            java.lang.String r1 = r22.getTagKey()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            r8 = 0
            r9 = 1
            if (r1 != 0) goto L_0x0014
            r1 = r9
            goto L_0x0015
        L_0x0014:
            r1 = r8
        L_0x0015:
            if (r1 != 0) goto L_0x0284
            java.lang.String r1 = r22.getTagUrl()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0028
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0026
            goto L_0x0028
        L_0x0026:
            r1 = r8
            goto L_0x0029
        L_0x0028:
            r1 = r9
        L_0x0029:
            if (r1 == 0) goto L_0x002d
            goto L_0x0284
        L_0x002d:
            com.baidu.browser.explore.mutable.MultiTagHelperKt.hideBackToNoFilterToast()
            r0.currClickTag = r7
            r0.currClickTagForFilter = r7
            r0.disableChangeTab = r9
            com.baidu.searchbox.ui.pulltorefresh.WebViewPullToRefreshView r1 = r0.mRefreshView
            if (r1 == 0) goto L_0x0042
            int r1 = r1.getState()
            if (r1 != 0) goto L_0x0042
            r1 = r9
            goto L_0x0043
        L_0x0042:
            r1 = r8
        L_0x0043:
            if (r1 != 0) goto L_0x004c
            com.baidu.searchbox.ui.pulltorefresh.WebViewPullToRefreshView r1 = r0.mRefreshView
            if (r1 == 0) goto L_0x004c
            r1.dismissLoadingAndNoResultTip()
        L_0x004c:
            boolean r1 = com.baidu.search.basic.utils.ResultPageABTest.isNewTabFrameworkOpen()
            if (r1 != 0) goto L_0x0056
            r1 = 0
            r0.updateAnimationFraction(r1)
        L_0x0056:
            boolean r10 = r21.isCurrInMoreFilter()
            boolean r11 = r22.isInMoreFilter()
            boolean r1 = com.baidu.browser.explore.mutable.feature.ResultPageFeature.DEBUG
            java.lang.String r12 = "tagBack"
            if (r1 == 0) goto L_0x0085
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "changeTag currIsInMoreFilter is "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r10)
            java.lang.String r2 = ", targetIsInMoreFilter is "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r12, r1)
        L_0x0085:
            com.baidu.browser.tabna.BaseTabContainer r1 = r0.mCurTabContainer
            boolean r1 = r1 instanceof com.baidu.browser.explore.tab.webview.BaseWebViewTabContainer
            r1 = r1 ^ r9
            r13 = r1
            java.lang.String r1 = r22.getTagUrl()
            com.baidu.browser.tabna.SearchTabItem r14 = r0.getItemByUrl(r1)
            boolean r1 = r22.isResourceTag()
            r15 = 2
            if (r1 == 0) goto L_0x00ab
            if (r14 == 0) goto L_0x00ab
            com.baidu.browser.explore.tab.TabContainerManager r1 = r0.mTabContainerManager
            int r1 = r1.isNaTab(r14)
            if (r1 == r9) goto L_0x00a9
            if (r1 != r15) goto L_0x00a7
            goto L_0x00a9
        L_0x00a7:
            r1 = r8
            goto L_0x00ac
        L_0x00a9:
            r1 = r9
            goto L_0x00ac
        L_0x00ab:
            r1 = r8
        L_0x00ac:
            r16 = r1
            java.lang.Boolean r1 = com.baidu.search.basic.utils.SearchABTestUtils.isTagBack()
            java.lang.String r6 = "isTagBack()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
            boolean r1 = r1.booleanValue()
            r5 = 0
            if (r1 == 0) goto L_0x0189
            java.lang.String r1 = r22.getResourcePd()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x00cf
            int r1 = r1.length()
            if (r1 != 0) goto L_0x00cd
            goto L_0x00cf
        L_0x00cd:
            r1 = r8
            goto L_0x00d0
        L_0x00cf:
            r1 = r9
        L_0x00d0:
            if (r1 != 0) goto L_0x0185
            java.lang.String r1 = "note"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r2 = r14.pd
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x0185
            java.util.HashMap r1 = r21.getTabNgWebViewMaps()
            java.util.Map r1 = (java.util.Map) r1
            java.lang.String r2 = r22.getResourcePd()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r8)
            java.lang.String r2 = r0.createWebviewKeyByPd(r2, r5, r3)
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L_0x0181
            java.util.HashMap r1 = r21.getTabNgWebViewMaps()
            r4 = r1
            java.util.Map r4 = (java.util.Map) r4
            r1 = r0
            com.baidu.browser.explore.mutable.feature.MultiTabFeature r1 = (com.baidu.browser.explore.mutable.feature.MultiTabFeature) r1
            r2 = 0
            r17 = 0
            r18 = 4
            r19 = 0
            r3 = r22
            r8 = r4
            r4 = r17
            r9 = r5
            r5 = r18
            r20 = r6
            r6 = r19
            java.lang.String r1 = com.baidu.browser.explore.mutable.feature.MultiTabFeature.createWebviewKeyByPd$default(r1, r2, r3, r4, r5, r6)
            boolean r1 = r8.containsKey(r1)
            if (r1 == 0) goto L_0x01d9
            r8 = r0
            com.baidu.browser.explore.mutable.feature.MultiTabFeature r8 = (com.baidu.browser.explore.mutable.feature.MultiTabFeature) r8
            r1 = r0
            com.baidu.browser.explore.mutable.feature.MultiTabFeature r1 = (com.baidu.browser.explore.mutable.feature.MultiTabFeature) r1
            r2 = 0
            r4 = 0
            r5 = 4
            r6 = 0
            r3 = r22
            java.lang.String r1 = com.baidu.browser.explore.mutable.feature.MultiTabFeature.createWebviewKeyByPd$default(r1, r2, r3, r4, r5, r6)
            com.baidu.searchbox.ng.browser.NgWebView r8 = com.baidu.browser.explore.mutable.feature.MultiTabFeature.getWebView$default(r8, r1, r9, r15, r9)
            if (r8 == 0) goto L_0x01d9
            java.util.HashMap r1 = r21.getTabNgWebViewMaps()
            r15 = r1
            java.util.Map r15 = (java.util.Map) r15
            r1 = r0
            com.baidu.browser.explore.mutable.feature.MultiTabFeature r1 = (com.baidu.browser.explore.mutable.feature.MultiTabFeature) r1
            java.lang.String r2 = r22.getResourcePd()
            r4 = 0
            r5 = 4
            r6 = 0
            r3 = r22
            java.lang.String r1 = com.baidu.browser.explore.mutable.feature.MultiTabFeature.createWebviewKeyByPd$default(r1, r2, r3, r4, r5, r6)
            if (r1 != 0) goto L_0x0152
            java.lang.String r1 = r22.getResourcePd()
        L_0x0152:
            r15.put(r1, r8)
            boolean r1 = com.baidu.browser.explore.mutable.feature.ResultPageFeature.DEBUG
            if (r1 == 0) goto L_0x01d9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "tabNgWebViewMaps 保存 webview "
            java.lang.StringBuilder r15 = r1.append(r2)
            r1 = r0
            com.baidu.browser.explore.mutable.feature.MultiTabFeature r1 = (com.baidu.browser.explore.mutable.feature.MultiTabFeature) r1
            java.lang.String r2 = r22.getResourcePd()
            r4 = 0
            r5 = 4
            r6 = 0
            r3 = r22
            java.lang.String r1 = com.baidu.browser.explore.mutable.feature.MultiTabFeature.createWebviewKeyByPd$default(r1, r2, r3, r4, r5, r6)
            java.lang.StringBuilder r1 = r15.append(r1)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r12, r1)
            goto L_0x01d9
        L_0x0181:
            r9 = r5
            r20 = r6
            goto L_0x01d9
        L_0x0185:
            r9 = r5
            r20 = r6
            goto L_0x01d9
        L_0x0189:
            r9 = r5
            r20 = r6
            r8 = r0
            com.baidu.browser.explore.mutable.feature.MultiTabFeature r8 = (com.baidu.browser.explore.mutable.feature.MultiTabFeature) r8
            r1 = r0
            com.baidu.browser.explore.mutable.feature.MultiTabFeature r1 = (com.baidu.browser.explore.mutable.feature.MultiTabFeature) r1
            java.lang.String r2 = r22.getResourcePd()
            r4 = 0
            r5 = 4
            r6 = 0
            r3 = r22
            java.lang.String r1 = com.baidu.browser.explore.mutable.feature.MultiTabFeature.createWebviewKeyByPd$default(r1, r2, r3, r4, r5, r6)
            com.baidu.searchbox.ng.browser.NgWebView r8 = com.baidu.browser.explore.mutable.feature.MultiTabFeature.getWebView$default(r8, r1, r9, r15, r9)
            java.lang.String r1 = r22.getResourcePd()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x01b4
            int r1 = r1.length()
            if (r1 != 0) goto L_0x01b2
            goto L_0x01b4
        L_0x01b2:
            r1 = 0
            goto L_0x01b5
        L_0x01b4:
            r1 = 1
        L_0x01b5:
            if (r1 != 0) goto L_0x01d9
            if (r8 == 0) goto L_0x01d9
            java.util.HashMap r1 = r21.getTabNgWebViewMaps()
            r12 = r1
            java.util.Map r12 = (java.util.Map) r12
            r1 = r0
            com.baidu.browser.explore.mutable.feature.MultiTabFeature r1 = (com.baidu.browser.explore.mutable.feature.MultiTabFeature) r1
            java.lang.String r2 = r22.getResourcePd()
            r4 = 0
            r5 = 4
            r6 = 0
            r3 = r22
            java.lang.String r1 = com.baidu.browser.explore.mutable.feature.MultiTabFeature.createWebviewKeyByPd$default(r1, r2, r3, r4, r5, r6)
            if (r1 != 0) goto L_0x01d6
            java.lang.String r1 = r22.getResourcePd()
        L_0x01d6:
            r12.put(r1, r8)
        L_0x01d9:
            if (r14 == 0) goto L_0x01e7
            int r1 = r14.position
            r2 = -1
            if (r1 == r2) goto L_0x01e7
            com.baidu.searchbox.multitab.MultiTabManager r1 = r0.mMultiTabManager
            int r2 = r14.position
            r1.setCurrentIndex(r2, r14)
        L_0x01e7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "tag"
            java.lang.StringBuilder r1 = r1.append(r2)
            int r2 = r22.getPos()
            r3 = 1
            int r2 = r2 + r3
            java.lang.StringBuilder r1 = r1.append(r2)
            r2 = 95
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = r22.getTagKey()
            if (r2 != 0) goto L_0x020b
            java.lang.String r2 = ""
        L_0x020b:
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            if (r16 != 0) goto L_0x0217
            r8 = 1
            goto L_0x0218
        L_0x0217:
            r8 = 0
        L_0x0218:
            r0.beforeTagClick(r7, r1, r8, r11)
            if (r13 != 0) goto L_0x0233
            if (r16 != 0) goto L_0x0233
            java.lang.Boolean r1 = com.baidu.search.basic.utils.SearchABTestUtils.isTagBack()
            r2 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x023b
            r1 = r10 ^ r11
            if (r1 == 0) goto L_0x023b
            goto L_0x0235
        L_0x0233:
            r2 = r20
        L_0x0235:
            if (r14 == 0) goto L_0x023b
            r0.switchContainerAndRequest(r7, r14)
            goto L_0x025b
        L_0x023b:
            if (r14 == 0) goto L_0x0256
            com.baidu.browser.tabna.BaseTabContainer r1 = r0.mCurTabContainer
            com.baidu.browser.tabna.SearchTabItem r1 = r1.getTabItem()
            java.lang.String r1 = r1.pd
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r3 = r14.pd
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r1 = android.text.TextUtils.equals(r1, r3)
            if (r1 != 0) goto L_0x0256
            com.baidu.browser.tabna.BaseTabContainer r1 = r0.mCurTabContainer
            r1.setTabItem(r14)
        L_0x0256:
            java.lang.String r1 = r14.pd
            r0.onWebViewTagClick(r7, r1)
        L_0x025b:
            java.lang.Boolean r1 = com.baidu.search.basic.utils.SearchABTestUtils.isTagBack()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x026f
            if (r13 != 0) goto L_0x026f
            if (r16 != 0) goto L_0x026f
            r21.resetPullToRefreshView()
        L_0x026f:
            java.lang.Boolean r1 = com.baidu.search.basic.utils.SearchABTestUtils.isTagBack()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0283
            r1 = r0
            com.baidu.browser.explore.mutable.feature.MultiTabFeature r1 = (com.baidu.browser.explore.mutable.feature.MultiTabFeature) r1
            r2 = 1
            com.baidu.browser.explore.mutable.feature.MultiTabFeature.refreshEdgeMode$default(r1, r9, r2, r9)
        L_0x0283:
            return
        L_0x0284:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.explore.mutable.feature.MultiTagsFeature.changeTag(com.baidu.browser.explore.tab.na.tag.data.SearchTagItem):void");
    }

    private final void resetPullToRefreshView() {
        View bottomView;
        View currRefreshableView;
        if (ResultPageFeature.DEBUG) {
            Log.d(MultiTagsFeatureKt.TAG_BACK_TAG, "更新下拉刷新视图");
        }
        BaseTabContainer baseTabContainer = this.mCurTabContainer;
        View view2 = null;
        BaseTabContainer curTabContainer = baseTabContainer != null ? baseTabContainer.getParentContainer() : null;
        if (this.mCurTabContainer instanceof MixTabContainer) {
            BaseTabContainer baseTabContainer2 = this.mCurTabContainer;
            if (baseTabContainer2 != null) {
                bottomView = ((MixTabContainer) baseTabContainer2).rootView();
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.browser.explore.tab.webview.MixTabContainer");
            }
        } else {
            View view3 = null;
            bottomView = null;
        }
        MultiTabContainer tabContainer = curTabContainer instanceof MultiTabContainer ? (MultiTabContainer) curTabContainer : null;
        if (tabContainer != null && bottomView != null) {
            WebViewPullToRefreshView refreshView = tabContainer.getRefreshView();
            if (!Intrinsics.areEqual((Object) bottomView, (Object) refreshView != null ? refreshView.getCurrRefreshableView() : null)) {
                if (Intrinsics.areEqual((Object) (refreshView == null || (currRefreshableView = refreshView.getCurrRefreshableView()) == null) ? null : currRefreshableView.getParent(), (Object) refreshView)) {
                    if (refreshView != null) {
                        view2 = refreshView.getCurrRefreshableView();
                    }
                    BdViewUtils.removeFromParent(view2);
                }
                BdViewUtils.removeFromParent(bottomView);
                bottomView.setId(R.id.search_tag_webview);
                if (refreshView != null) {
                    refreshView.addView(bottomView);
                }
                if (refreshView != null) {
                    refreshView.setCurrRefreshableView(bottomView);
                }
            } else if (ResultPageFeature.DEBUG) {
                Log.d(MultiTagsFeatureKt.TAG_BACK_TAG, "当前已经是最新的视图，不需要更新下拉刷新视图");
            }
        }
    }

    private final void switchContainerAndRequest(SearchTagItem tag, SearchTabItem tabItem) {
        String tagUrl = tag.getTagUrl();
        if (tagUrl != null) {
            String pd = tag.getResourcePd();
            if (!SearchABTestUtils.isSearchNaTabStatistic()) {
                tabInvokeByCardStatistics(tagUrl, (SearchTabItem) null);
            }
            if (Intrinsics.areEqual((Object) "video", (Object) pd)) {
                if (SearchVideoTabUtils.INSTANCE.getIgnoreSaList().contains(BrowserUrlUtils.getParamsFromSearchUrl(tagUrl, "sa")) && this.mMultiTabManager != null) {
                    tabItem.naDegrate = 1;
                    this.mMultiTabManager.addDowngradeTab(pd);
                }
            }
            if (SearchABTestUtils.isSearchNaTabStatistic()) {
                tabInvokeByCardStatistics(tagUrl, tabItem);
            }
            boolean fetchNaData = showContainerAndRequest(tabItem, tag, tagUrl);
            if (!(this.mMultiTabManager == null || this.mMultiTabManager.getTabList().size() >= 1 || getCurTabStatistic() == null)) {
                getCurTabStatistic().setOpenSource("1");
            }
            if (!shouldNaContainerShowUrl(this.mCurTabContainer, fetchNaData, tagUrl)) {
                if (pd != null && SearchABTestUtils.getNaTabStatus(pd) > 0) {
                    String tSamp = SearchUrlGenerator.getTSamp(tagUrl, pd);
                    Intrinsics.checkNotNullExpressionValue(tSamp, "getTSamp(tagUrl, pd)");
                    tagUrl = tSamp;
                }
                tag.setTagUrl(tagUrl);
                onWebViewTagClick(tag, tabItem.pd);
            }
        }
    }

    public BaseTabContainer obtainContainer(SearchTabItem item, SearchTagItem tagItem) {
        int tabType = 0;
        if (item != null) {
            SearchTabItem searchTabItem = item;
            tabType = this.mTabContainerManager.isNaTab(item);
        }
        Boolean isTagBack = SearchABTestUtils.isTagBack();
        Intrinsics.checkNotNullExpressionValue(isTagBack, "isTagBack()");
        if (isTagBack.booleanValue() && item != null && tabType == 0) {
            boolean z = true;
            if (tagItem == null || !tagItem.isInMoreFilter()) {
                z = false;
            }
            if (z) {
                String allKey = createContainerKeyByPd(item.pd, tagItem);
                BaseTabContainer allTagContainer = this.mTabContainerManager.getContainer(allKey);
                if (allTagContainer == null) {
                    allTagContainer = this.mTabContainerManager.createWebViewTabContainer(getContext(), new TabContainerModel(item.url, 3), item, this);
                    if (allTagContainer != null) {
                        allTagContainer.setTabItem(item);
                    }
                    if (allTagContainer != null) {
                        allTagContainer.setContainerManager(getContainerManager());
                    }
                    if (allTagContainer != null) {
                        allTagContainer.changeStatus(4113);
                    }
                    this.mTabContainerManager.putContainer(allKey, allTagContainer);
                    if (ResultPageFeature.DEBUG) {
                        Log.d(MultiTagsFeatureKt.TAG_BACK_TAG, "新创建了全部筛选的容器，key是" + allKey + " allTagContainer is " + (allTagContainer != null ? allTagContainer.getContainerId() : null));
                    }
                } else {
                    this.mTabContainerManager.reEnterContainer(allTagContainer, item);
                    if (ResultPageFeature.DEBUG) {
                        Log.d(MultiTagsFeatureKt.TAG_BACK_TAG, "拿到了全部筛选的缓存容器，key是" + allKey + " allTagContainer is " + allTagContainer.getContainerId());
                    }
                }
                if (allTagContainer instanceof BaseWebViewTabContainer) {
                    ((BaseWebViewTabContainer) allTagContainer).currTag = tagItem;
                    if (ResultPageFeature.DEBUG) {
                        Log.d(MultiTagsFeatureKt.TAG_BACK_TAG, "set currTag is " + tagItem.getTagKey() + " container is " + ((BaseWebViewTabContainer) allTagContainer).getContainerId());
                    }
                }
                return allTagContainer;
            }
        }
        if (ResultPageFeature.DEBUG) {
            Log.d(MultiTagsFeatureKt.TAG_BACK_TAG, "获取非全部tab的的容器或者全部tab非筛选的容器");
        }
        return super.obtainContainer(item, tagItem);
    }

    /* access modifiers changed from: protected */
    public void naDegrateRefresh(String url) {
        super.naDegrateRefresh(url);
        if (ResultPageFeature.DEBUG) {
            Log.d(MultiTagsFeatureKt.TAG_BACK_TAG, "触发降级更新下拉刷新");
        }
        Boolean isTagBack = SearchABTestUtils.isTagBack();
        Intrinsics.checkNotNullExpressionValue(isTagBack, "isTagBack()");
        if (isTagBack.booleanValue() && !isFixMode()) {
            resetPullToRefreshView();
        }
    }

    /* access modifiers changed from: protected */
    public void hideDegrateErrorPage() {
        Handler handler;
        super.hideDegrateErrorPage();
        Boolean isTagBack = SearchABTestUtils.isTagBack();
        Intrinsics.checkNotNullExpressionValue(isTagBack, "isTagBack()");
        if (isTagBack.booleanValue() && (handler = getHandler()) != null) {
            handler.post(new MultiTagsFeature$$ExternalSyntheticLambda4(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: hideDegrateErrorPage$lambda-10  reason: not valid java name */
    public static final void m12890hideDegrateErrorPage$lambda10(MultiTagsFeature this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.tabShowErrorPage(false);
        if (ResultPageFeature.DEBUG) {
            Log.d(MultiTagsFeatureKt.TAG_BACK_TAG, "隐藏降级错误页面");
        }
    }

    /* access modifiers changed from: protected */
    public SearchTagItem getClickTag() {
        return this.currClickTag;
    }

    public void moreItemHandle(boolean show, boolean needScroll) {
        moreItemHandle(show, needScroll, true);
    }

    public void moreItemHandle(boolean show, boolean needScroll, boolean showAnim) {
        super.moreItemHandle(show, needScroll, showAnim);
        SearchTagView curSearchTagView = curSearchTagView();
        if (curSearchTagView != null) {
            curSearchTagView.showOrHideMoreLayout(show);
        }
    }

    public void closeMoreTabLayout() {
        dismissMoreLayoutGroupCard();
        TabMoreLayout moreTabLayout = getMoreTabLayout();
        if (moreTabLayout != null) {
            moreTabLayout.dismiss(false);
        }
        SearchTagView curSearchTagView = curSearchTagView();
        if (curSearchTagView != null) {
            curSearchTagView.showOrHideMoreLayout(false);
        }
    }

    /* access modifiers changed from: private */
    public final void showFilterLayout(boolean show, SearchTagItem tagItem) {
        SearchBoxContainer container;
        SearchBoxContainer container2;
        GroupCardFrameLayout groupCardLayout;
        int i2 = -1;
        GroupCardParams groupCard = getCurCardParams(-1);
        if (isGroupCardView(groupCard) && groupCard.isShowing() && (groupCardLayout = getGroupCardLayout()) != null) {
            groupCardLayout.setGroupCardViewVisible(!show, false);
        }
        if (!show) {
            dismissMoreLayoutGroupCard();
            TabMoreLayout moreTabLayout = getMoreTabLayout();
            if (moreTabLayout != null) {
                moreTabLayout.post(new MultiTagsFeature$$ExternalSyntheticLambda7(this));
                return;
            }
            return;
        }
        Context context = getContext();
        if (context != null) {
            Context context2 = context;
            if (context2.getResources() == null) {
                SearchTagItem searchTagItem = tagItem;
            } else if (this.mResultPageLoftFrontView == null) {
                SearchTagItem searchTagItem2 = tagItem;
            } else {
                if (getMoreTabLayout() == null) {
                    setMoreTabLayout(new TabMoreLayout(context2));
                }
                TabMoreLayout moreTabLayout2 = getMoreTabLayout();
                if (moreTabLayout2 != null) {
                    TabMoreLayout $this$showFilterLayout_u24lambda_u2d15 = moreTabLayout2;
                    ViewGroup.LayoutParams layoutParams = $this$showFilterLayout_u24lambda_u2d15.getLayoutParams();
                    String str = null;
                    FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
                    if (layoutParams2 == null) {
                        layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                    }
                    FrameLayout.LayoutParams moreLayoutParams = layoutParams2;
                    BdViewUtils.removeFromParent($this$showFilterLayout_u24lambda_u2d15);
                    moreLayoutParams.topMargin = this.mResultPageLoftFrontView.getTopViewHeight() + getMultiTabHeight() + ((int) this.mResultPageLoftFrontView.getY()) + SearchTagViewKt.tagHeight() + this.scrollOffset;
                    if (ResultPageABTest.isIntergenerational()) {
                        moreLayoutParams.topMargin += getSearchBoxHeight();
                    }
                    IMutableContainerCallback mutableContainerCallback = getMutableContainerCallback();
                    View rootView = (mutableContainerCallback == null || (container2 = mutableContainerCallback.getContainer()) == null) ? null : container2.rootView();
                    ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
                    if (viewGroup != null) {
                        viewGroup.addView($this$showFilterLayout_u24lambda_u2d15, moreLayoutParams);
                    }
                    boolean isGroupCardShowing = isGroupCardShowing(isNightMode());
                    boolean isRemoteDefaultParamsShowing = isRemoteDefaultParamsShowing(isNightMode());
                    if (groupCard != null) {
                        i2 = groupCard.getColorEnd();
                    }
                    $this$showFilterLayout_u24lambda_u2d15.updateRecBgColors(groupCard, isGroupCardShowing, isRemoteDefaultParamsShowing, i2, false);
                    if (groupCard.getNeedShow() && !isNightMode() && groupCard.getColorStart() != groupCard.getColorEnd() && groupCard.getPeakType() != 0) {
                        Intrinsics.checkNotNullExpressionValue(groupCard, "groupCard");
                        setShowOrHideAnimationGradient(180, groupCard, GroupCardParamsKt.generateSolidCardParams(groupCard));
                    }
                    AdvanceFilterViewModel it = getAdVanceFilterVm();
                    if (it != null) {
                        IMutableContainerCallback mutableContainerCallback2 = getMutableContainerCallback();
                        if (!(mutableContainerCallback2 == null || (container = mutableContainerCallback2.getContainer()) == null)) {
                            str = container.getCurrentPageUrl();
                        }
                        $this$showFilterLayout_u24lambda_u2d15.initFilterItems(it, str);
                    }
                    FrameLayout.LayoutParams layoutParams3 = moreLayoutParams;
                    TabMoreLayout $this$showFilterLayout_u24lambda_u2d152 = $this$showFilterLayout_u24lambda_u2d15;
                    TabMoreLayout.setTabList$default($this$showFilterLayout_u24lambda_u2d15, new ArrayList(), (String) null, true, false, 0, new MultiTagsFeature$showFilterLayout$2$2(tagItem, this, context2), 24, (Object) null);
                    $this$showFilterLayout_u24lambda_u2d152.setBgClick(new MultiTagsFeature$$ExternalSyntheticLambda8(this));
                    $this$showFilterLayout_u24lambda_u2d152.post(new MultiTagsFeature$$ExternalSyntheticLambda9($this$showFilterLayout_u24lambda_u2d152));
                    MultiTagHelperKt.hideBackToNoFilterToast();
                    ChatSearchTabGuideManager.INSTANCE.dismissBubble();
                    return;
                }
                SearchTagItem searchTagItem3 = tagItem;
                return;
            }
            if (ResultPageFeature.DEBUG) {
                throw new NullPointerException("addMoreTabLayout is null");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showFilterLayout$lambda-11  reason: not valid java name */
    public static final void m12896showFilterLayout$lambda11(MultiTagsFeature this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TabMoreLayout moreTabLayout = this$0.getMoreTabLayout();
        if (moreTabLayout != null) {
            TabMoreLayout.dismiss$default(moreTabLayout, false, 1, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: showFilterLayout$lambda-15$lambda-13  reason: not valid java name */
    public static final void m12897showFilterLayout$lambda15$lambda13(MultiTagsFeature this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.moreItemHandle(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: showFilterLayout$lambda-15$lambda-14  reason: not valid java name */
    public static final void m12898showFilterLayout$lambda15$lambda14(TabMoreLayout $this_apply) {
        Intrinsics.checkNotNullParameter($this_apply, "$this_apply");
        $this_apply.show(false);
    }

    public void updateTagAdvanceUrl(HashMap<String, String> params) {
        SearchTagView curSearchTagView;
        if (params != null && isCurrentMultiTabAll() && (curSearchTagView = curSearchTagView()) != null) {
            Set<String> paramsSet = AdvanceFilterMenu.getParamsSet();
            Intrinsics.checkNotNullExpressionValue(paramsSet, "getParamsSet()");
            curSearchTagView.updateTagAdvanceUrl(paramsSet, params);
        }
    }

    private final void updateMoreLayoutUIOnTop() {
        TabMoreLayout $this$updateMoreLayoutUIOnTop_u24lambda_u2d18;
        String str;
        Boolean bool;
        SearchTabItem searchTabItem;
        SearchBoxContainer container;
        int i2;
        List data = this.mMultiTabManager.getTabList();
        if (data != null && data.size() > tabMaxSize() && ($this$updateMoreLayoutUIOnTop_u24lambda_u2d18 = getMoreTabLayout()) != null) {
            ViewGroup.LayoutParams layoutParams = $this$updateMoreLayoutUIOnTop_u24lambda_u2d18.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            }
            FrameLayout.LayoutParams moreLayoutParams = layoutParams2;
            BdViewUtils.removeFromParent($this$updateMoreLayoutUIOnTop_u24lambda_u2d18);
            boolean z = true;
            if (ResultPageABTest.isNewTabFrameworkOpen()) {
                SearchTabLayout anchorView = this.mSearchTabLayout;
                int anchorHeight = anchorView != null ? anchorView.getHeight() : 0;
                if (anchorView == null || anchorHeight <= 0) {
                    moreLayoutParams.topMargin = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 83.0f) + DeviceUtils.ScreenInfo.getStatusBarHeight();
                } else {
                    int[] anchorPosition = new int[2];
                    anchorView.getLocationInWindow(anchorPosition);
                    moreLayoutParams.topMargin = anchorPosition[1] + anchorView.getHeight();
                }
            } else {
                View searchBoxView = getSearchBoxView();
                if (searchBoxView != null) {
                    i2 = (int) searchBoxView.getY();
                } else {
                    i2 = DeviceUtils.ScreenInfo.dp2px(AppRuntime.getAppContext(), 71.0f);
                }
                moreLayoutParams.topMargin = i2;
            }
            IMutableContainerCallback mutableContainerCallback = getMutableContainerCallback();
            View rootView = (mutableContainerCallback == null || (container = mutableContainerCallback.getContainer()) == null) ? null : container.rootView();
            ViewGroup viewGroup = rootView instanceof ViewGroup ? (ViewGroup) rootView : null;
            if (viewGroup != null) {
                viewGroup.addView($this$updateMoreLayoutUIOnTop_u24lambda_u2d18, moreLayoutParams);
            }
            List tabItems = new ArrayList();
            boolean isInAllTab = isInAllTab();
            if ((ResultPageABTest.isShowFilterAtAllTabs() && isInAllTab) || !ResultPageABTest.isShowFilterAtAllTabs()) {
                List tabList = data.subList(tabMaxSize(), data.size());
                int i3 = 0;
                int size = tabList.size();
                while (i3 < size) {
                    SearchTabItem item = tabList.get(i3);
                    Intrinsics.checkNotNullExpressionValue(item, "item");
                    SearchTagItem searchTagItem = SearchTagDataKt.createResourceTagItem(item, getQuery(), 0, 0, getUrl());
                    searchTagItem.setInMoreFilter(z);
                    searchTagItem.setModel(new MoreSearchTabItem(item));
                    tabItems.add(new MoreSearchTagItem(searchTagItem, (String) null, 2, (DefaultConstructorMarker) null));
                    i3++;
                    z = true;
                }
            }
            String filterUrl = getFilterUrl(isInAllTab);
            if (tabItems.isEmpty()) {
                CharSequence charSequence = filterUrl;
                if (charSequence == null || charSequence.length() == 0) {
                    return;
                }
            }
            BaseTabContainer baseTabContainer = this.mCurTabContainer;
            String str2 = (baseTabContainer == null || (searchTabItem = baseTabContainer.mTabItem) == null) ? null : searchTabItem.pd;
            if (str2 == null) {
                str2 = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str2, "mCurTabContainer?.mTabItem?.pd ?: \"\"");
            }
            String curPd = str2;
            if (ResultPageABTest.isShowFilterAtAllTabs()) {
                if (isInAllTab) {
                    String str3 = null;
                    str = null;
                } else {
                    str = curPd;
                }
                String pd = str;
                if (!isInAllTab) {
                    if (pd != null) {
                        bool = Boolean.valueOf(pd.length() == 0);
                    } else {
                        bool = null;
                    }
                    if (bool == null) {
                        return;
                    }
                }
                ArrayList it = new TagAdvanceFilterViewModel().getFilterList(filterUrl, pd);
                if (it != null) {
                    tabItems.addAll(it);
                }
            } else {
                ArrayList it2 = TagAdvanceFilterViewModel.getFilterList$default(new TagAdvanceFilterViewModel(), filterUrl, (String) null, 2, (Object) null);
                if (it2 != null) {
                    tabItems.addAll(it2);
                }
            }
            if (!tabItems.isEmpty()) {
                $this$updateMoreLayoutUIOnTop_u24lambda_u2d18.setTabList(tabItems, curPd, false, false, this.mScreenWidth, new MultiTagsFeature$updateMoreLayoutUIOnTop$1$3(this));
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onVsTagClick(java.lang.String r12, com.baidu.browser.explore.tab.na.tag.data.SearchTagItem r13) {
        /*
            r11 = this;
            r0 = r12
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0010
            int r0 = r0.length()
            if (r0 != 0) goto L_0x000e
            goto L_0x0010
        L_0x000e:
            r0 = r1
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            if (r0 != 0) goto L_0x00fa
            if (r13 != 0) goto L_0x0017
            goto L_0x00fa
        L_0x0017:
            java.lang.String r0 = r13.getTagUrl()
            java.util.HashMap<java.lang.String, com.baidu.browser.explore.tab.na.tag.data.SearchTagItem> r3 = r11.currClickTagForVsFilterMap
            java.lang.Object r3 = r3.get(r12)
            r9 = r3
            com.baidu.browser.explore.tab.na.tag.data.SearchTagItem r9 = (com.baidu.browser.explore.tab.na.tag.data.SearchTagItem) r9
            boolean r3 = com.baidu.searchbox.config.AppConfig.isDebug()
            r4 = 0
            if (r3 == 0) goto L_0x0064
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "垂类筛选 url="
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r5 = " tagItem.tagKey="
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.String r5 = r13.getTagKey()
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.String r5 = " currClickTagForVsFilter?.tagKey="
            java.lang.StringBuilder r3 = r3.append(r5)
            if (r9 == 0) goto L_0x0056
            java.lang.String r5 = r9.getTagKey()
            goto L_0x0057
        L_0x0056:
            r5 = r4
        L_0x0057:
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = "SearchVsFilterData"
            android.util.Log.d(r5, r3)
        L_0x0064:
            boolean r3 = com.baidu.search.basic.utils.ResultPageABTest.isShowFilterAtAllTabs()
            if (r3 == 0) goto L_0x00f9
            if (r0 == 0) goto L_0x007c
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0077
            r3 = r2
            goto L_0x0078
        L_0x0077:
            r3 = r1
        L_0x0078:
            if (r3 != r2) goto L_0x007c
            r3 = r2
            goto L_0x007d
        L_0x007c:
            r3 = r1
        L_0x007d:
            if (r3 == 0) goto L_0x00f9
            if (r9 == 0) goto L_0x0086
            java.lang.String r3 = r9.getTagKey()
            goto L_0x0087
        L_0x0086:
            r3 = r4
        L_0x0087:
            java.lang.String r5 = r13.getTagKey()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 != 0) goto L_0x00f2
            java.util.HashMap<java.lang.String, com.baidu.browser.explore.tab.na.tag.data.SearchTagItem> r3 = r11.currClickTagForVsFilterMap
            java.util.Map r3 = (java.util.Map) r3
            r3.put(r12, r13)
            com.baidu.browser.tabna.BaseTabContainer r10 = r11.mCurTabContainer
            boolean r3 = r10 instanceof com.baidu.browser.explore.tab.webview.BaseWebViewTabContainer
            if (r3 == 0) goto L_0x00e0
            boolean r1 = r13.isInMoreFilter()
            r11.beforeTagClick(r13, r4, r2, r1)
            android.content.Context r1 = r11.getContext()
            java.lang.String r1 = com.baidu.browser.explore.GroupCardBackgroundKt.getGroupCardNaWH(r1)
            com.baidu.browser.explore.network.SearchWifiBind4GFeature r3 = com.baidu.browser.explore.network.SearchWifiBind4GFeature.INSTANCE
            boolean r3 = r3.getSettingSwitchValue()
            java.lang.String r5 = com.baidu.browser.utils.SessionIdUtilKt.getSessionId()
            java.util.Map r1 = com.baidu.search.core.utils.BrowserUrlUtils.addSearchNeedHeader(r4, r1, r3, r5)
            java.lang.String r3 = "addSearchNeedHeader(null…hValue(), getSessionId())"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            boolean r3 = com.baidu.search.basic.utils.SearchABTestUtils.isEnableSearchNaProto()
            if (r3 == 0) goto L_0x00d0
            com.baidu.browser.explore.network.NaRequestManager r3 = com.baidu.browser.explore.network.NaRequestManager.INSTANCE
            r5 = 0
            r6 = 0
            r7 = 6
            r8 = 0
            r4 = r0
            com.baidu.browser.explore.network.NaRequestManager.startSearchRequest$default(r3, r4, r5, r6, r7, r8)
        L_0x00d0:
            com.baidu.searchbox.ng.browser.NgWebView r3 = r11.getWebView()
            if (r3 == 0) goto L_0x00f9
            com.baidu.browser.sailor.ISailorWebViewExt r3 = r3.getWebViewExt()
            if (r3 == 0) goto L_0x00f9
            r3.loadUrl(r0, r1, r2)
            goto L_0x00f9
        L_0x00e0:
            boolean r2 = r10 instanceof com.baidu.browser.tabna.BaseNaTabContainer
            if (r2 == 0) goto L_0x00f9
            boolean r2 = r13.isInMoreFilter()
            r11.beforeTagClick(r13, r4, r1, r2)
            r1 = r10
            com.baidu.browser.tabna.BaseNaTabContainer r1 = (com.baidu.browser.tabna.BaseNaTabContainer) r1
            r11.naContainerRequest(r1, r0, r12)
            goto L_0x00f9
        L_0x00f2:
            kotlin.jvm.functions.Function1<? super com.baidu.browser.explore.tab.na.tag.data.SearchTagItem, kotlin.Unit> r1 = r11.tagReClick
            if (r1 == 0) goto L_0x00f9
            r1.invoke(r13)
        L_0x00f9:
            return
        L_0x00fa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.explore.mutable.feature.MultiTagsFeature.onVsTagClick(java.lang.String, com.baidu.browser.explore.tab.na.tag.data.SearchTagItem):void");
    }

    private final void naContainerRequest(BaseNaTabContainer container, String url, String pd) {
        ISearchVideoTabContainerInterface videoInterface;
        if (container != null && Intrinsics.areEqual((Object) container, (Object) this.mCurTabContainer) && URLUtil.isValidUrl(url)) {
            CharSequence charSequence = pd;
            if (!(charSequence == null || charSequence.length() == 0)) {
                DurationManager tabDuration = container.getTabDuration();
                if (tabDuration != null) {
                    tabDuration.finishDuration(System.currentTimeMillis());
                }
                container.getTabDuration().startDuration();
                FetchNaDataRequest fetchNaDataRequest = new FetchNaDataRequest(getContext(), this);
                boolean canFetchNaData = fetchNaDataRequest.startRequest(url, pd);
                afterNAContainerShow(container, fetchNaDataRequest, url);
                if (TextUtils.equals(pd, "video") && (videoInterface = (ISearchVideoTabContainerInterface) ServiceManager.getService(ISearchVideoTabContainerInterface.Companion.getReference())) != null) {
                    videoInterface.updateRefreshCount(1, container);
                }
                weakNetworkDetect();
                shouldNaContainerShowUrl((BaseTabContainer) container, canFetchNaData, url);
                if (canFetchNaData) {
                    container.mLoadUrl = url;
                }
                updateNaVsFilteredSiteIfNeeded(container);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void updateMoreLayoutUI() {
        List tabItems;
        int i2;
        RecyclerView tabMoreRec;
        SearchBoxContainer container;
        if (ResultPageABTest.isMoveFilterToTab()) {
            updateMoreLayoutUIOnTop();
            return;
        }
        SearchTagView searchTagView = curSearchTagView();
        if (searchTagView != null && (tabItems = searchTagView.getMoreTags()) != null) {
            SearchTagView curSearchTagView = curSearchTagView();
            ViewGroup viewGroup = null;
            String curPd = curSearchTagView != null ? curSearchTagView.curSelectPd() : null;
            TabMoreLayout moreTabLayout = getMoreTabLayout();
            if (moreTabLayout != null) {
                TabMoreLayout $this$updateMoreLayoutUI_u24lambda_u2d19 = moreTabLayout;
                ViewGroup.LayoutParams layoutParams = $this$updateMoreLayoutUI_u24lambda_u2d19.getLayoutParams();
                FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 == null) {
                    layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                }
                FrameLayout.LayoutParams moreLayoutParams = layoutParams2;
                BdViewUtils.removeFromParent($this$updateMoreLayoutUI_u24lambda_u2d19);
                SearchTabLayout searchTabLayout = this.mSearchTabLayout;
                if (searchTabLayout != null && searchTabLayout.getVisibility() == 0) {
                    i2 = ((((this.mResultPageLoftFrontView.getTopViewHeight() + getMultiTabHeight()) + ((int) this.mResultPageLoftFrontView.getY())) + SearchTagViewKt.tagHeight()) - DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 3.0f)) + this.scrollOffset;
                } else {
                    i2 = ((this.mResultPageLoftFrontView.getTopViewHeight() + ((int) this.mResultPageLoftFrontView.getY())) + SearchTagViewKt.tagHeight()) - DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 3.0f);
                }
                moreLayoutParams.topMargin = i2;
                if (ResultPageABTest.isIntergenerational()) {
                    moreLayoutParams.topMargin += getSearchBoxHeight();
                }
                IMutableContainerCallback mutableContainerCallback = getMutableContainerCallback();
                KeyEvent.Callback rootView = (mutableContainerCallback == null || (container = mutableContainerCallback.getContainer()) == null) ? null : container.rootView();
                if (rootView instanceof ViewGroup) {
                    viewGroup = (ViewGroup) rootView;
                }
                if (viewGroup != null) {
                    viewGroup.addView($this$updateMoreLayoutUI_u24lambda_u2d19, moreLayoutParams);
                }
                if (ResultPageABTest.isTabTagMixed() && (tabMoreRec = $this$updateMoreLayoutUI_u24lambda_u2d19.getTabMoreRec()) != null) {
                    tabMoreRec.setTranslationY(-((float) DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 4.0f)));
                }
                $this$updateMoreLayoutUI_u24lambda_u2d19.setTabList(tabItems, curPd, isCurrentMultiTabAll() && !ResultPageABTest.isNewDoubleTab(), searchTagView.hasImg(), this.mScreenWidth, new MultiTagsFeature$updateMoreLayoutUI$1$1(this, searchTagView));
            }
        }
    }

    public void onNaTabPageShow(SearchTabItem tabItem, boolean hasReportUpScreen) {
        super.onNaTabPageShow(tabItem, hasReportUpScreen);
        UiThreadUtils.getMainHandler().post(new MultiTagsFeature$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onNaTabPageShow$lambda-20  reason: not valid java name */
    public static final void m12892onNaTabPageShow$lambda20(MultiTagsFeature this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hideLoadingView(true);
    }

    public void hideLoadingView(boolean isSuccess) {
        super.hideLoadingView(isSuccess);
        if (this.needShowClearBackToast) {
            MultiTagHelperKt.showBackToNoFilterToast(getContext());
            this.needShowClearBackToast = false;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onItemClick(com.baidu.browser.tabna.SearchTabItem r12) {
        /*
            r11 = this;
            if (r12 != 0) goto L_0x0003
            return
        L_0x0003:
            boolean r0 = r12.isJumpToFilter()
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x007c
            java.lang.String r0 = r12.getTagUrl()
            if (r0 == 0) goto L_0x0021
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x001c
            r0 = r2
            goto L_0x001d
        L_0x001c:
            r0 = r3
        L_0x001d:
            if (r0 != r2) goto L_0x0021
            r0 = r2
            goto L_0x0022
        L_0x0021:
            r0 = r3
        L_0x0022:
            if (r0 == 0) goto L_0x007c
            java.lang.String r0 = r11.getQuery()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            java.lang.String r5 = r11.getUrl()
            com.baidu.browser.explore.tab.na.tag.data.SearchTagItem r0 = com.baidu.browser.explore.tab.na.tag.data.SearchTagDataKt.createResourceTagItem(r12, r0, r4, r3, r5)
            r0.setCanNotShowToast(r2)
            r0.setInMoreFilter(r2)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r12.getTagUrl()
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = r12.extra
            java.lang.String r6 = ""
            if (r5 != 0) goto L_0x004e
            r5 = r6
        L_0x004e:
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r0.setTagUrl(r4)
            com.baidu.browser.tabna.BaseTabContainer r4 = r11.mCurTabContainer
            if (r4 == 0) goto L_0x0062
            com.baidu.browser.tabna.BaseTabContainer r4 = r4.getParentContainer()
            goto L_0x0063
        L_0x0062:
            r4 = r1
        L_0x0063:
            boolean r5 = r4 instanceof com.baidu.browser.explore.tab.MultiTabContainer
            if (r5 == 0) goto L_0x006a
            r1 = r4
            com.baidu.browser.explore.tab.MultiTabContainer r1 = (com.baidu.browser.explore.tab.MultiTabContainer) r1
        L_0x006a:
            if (r1 != 0) goto L_0x006d
            goto L_0x0070
        L_0x006d:
            r1.setSearchTagWillRemove(r2)
        L_0x0070:
            kotlin.jvm.functions.Function2<? super com.baidu.browser.explore.tab.na.tag.data.SearchTagItem, ? super java.lang.String, kotlin.Unit> r1 = r11.tagsClick
            if (r1 == 0) goto L_0x0077
            r1.invoke(r0, r6)
        L_0x0077:
            r11.removeTagView()
            goto L_0x0111
        L_0x007c:
            boolean r0 = r12.isResourceTab()
            r4 = 2
            if (r0 == 0) goto L_0x00b2
            com.baidu.browser.tabna.BaseTabContainer r0 = r11.mCurTabContainer
            if (r0 == 0) goto L_0x008c
            com.baidu.browser.tabna.BaseTabContainer r0 = r0.getParentContainer()
            goto L_0x008d
        L_0x008c:
            r0 = r1
        L_0x008d:
            boolean r2 = r0 instanceof com.baidu.browser.explore.tab.MultiTabContainer
            if (r2 == 0) goto L_0x0094
            com.baidu.browser.explore.tab.MultiTabContainer r0 = (com.baidu.browser.explore.tab.MultiTabContainer) r0
            goto L_0x0095
        L_0x0094:
            r0 = r1
        L_0x0095:
            if (r0 == 0) goto L_0x009c
            com.baidu.browser.explore.tab.na.tag.data.SearchTagItem r2 = r0.getResourceTagItem(r12)
            goto L_0x009d
        L_0x009c:
            r2 = r1
        L_0x009d:
            if (r2 == 0) goto L_0x00ab
            r11.mFromJumpToTab = r3
            com.baidu.browser.explore.tab.na.tag.SearchTagView r5 = r0.getSearchTagView()
            if (r5 == 0) goto L_0x0111
            com.baidu.browser.explore.tab.na.tag.SearchTagView.selectTag$default(r5, r2, r3, r4, r1)
            goto L_0x0111
        L_0x00ab:
            r5 = r11
            com.baidu.browser.explore.mutable.feature.MultiTabFeature r5 = (com.baidu.browser.explore.mutable.feature.MultiTabFeature) r5
            com.baidu.browser.explore.mutable.feature.MultiTabFeature.jumpToTab$default(r5, r12, r3, r4, r1)
            goto L_0x0111
        L_0x00b2:
            java.lang.String r0 = r12.pd
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00c1
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00bf
            goto L_0x00c1
        L_0x00bf:
            r0 = r3
            goto L_0x00c2
        L_0x00c1:
            r0 = r2
        L_0x00c2:
            if (r0 != 0) goto L_0x010b
            java.util.HashMap r0 = r11.getTabNgWebViewMaps()
            java.util.Map r0 = (java.util.Map) r0
            r5 = r11
            com.baidu.browser.explore.mutable.feature.MultiTabFeature r5 = (com.baidu.browser.explore.mutable.feature.MultiTabFeature) r5
            java.lang.String r6 = r12.pd
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            java.lang.String r5 = com.baidu.browser.explore.mutable.feature.MultiTabFeature.createWebviewKeyByPd$default(r5, r6, r7, r8, r9, r10)
            java.lang.Object r0 = r0.get(r5)
            com.baidu.searchbox.ng.browser.NgWebView r5 = r11.getSearchWebView()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r5)
            if (r0 != 0) goto L_0x010b
            java.util.HashMap r0 = r11.getTabNgWebViewMaps()
            java.util.Map r0 = (java.util.Map) r0
            r5 = r11
            com.baidu.browser.explore.mutable.feature.MultiTabFeature r5 = (com.baidu.browser.explore.mutable.feature.MultiTabFeature) r5
            java.lang.String r6 = r12.pd
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            java.lang.String r5 = com.baidu.browser.explore.mutable.feature.MultiTabFeature.createWebviewKeyByPd$default(r5, r6, r7, r8, r9, r10)
            java.lang.Object r0 = r0.get(r5)
            com.baidu.searchbox.ng.browser.NgWebView r0 = (com.baidu.searchbox.ng.browser.NgWebView) r0
            if (r0 == 0) goto L_0x010b
            r5 = 0
            int r6 = com.baidu.searchbox.ng.browser.R.id.webview_reuse_tag
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r0.setTag(r6, r2)
        L_0x010b:
            r0 = r11
            com.baidu.browser.explore.mutable.feature.MultiTabFeature r0 = (com.baidu.browser.explore.mutable.feature.MultiTabFeature) r0
            com.baidu.browser.explore.mutable.feature.MultiTabFeature.jumpToTab$default(r0, r12, r3, r4, r1)
        L_0x0111:
            r12.setJumpToFilter(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.explore.mutable.feature.MultiTagsFeature.onItemClick(com.baidu.browser.tabna.SearchTabItem):void");
    }

    public boolean onHandleMultiTab(String params, boolean fromProtoBuf) {
        SearchTabItem tabItem;
        SearchTabItem it;
        Intrinsics.checkNotNullParameter(params, "params");
        if (ResultPageFeature.DEBUG) {
            Log.v(ResultPageFeature.TAG, "MultiTagsFeature: onHandleMultiTab: " + params + " , fromProtoBuf: " + fromProtoBuf);
        }
        BaseTabContainer curTabContainer = getCurTabContainer();
        boolean isFirstResultContainer = !(curTabContainer != null ? curTabContainer.canGoBack() : true);
        if (isFirstResultContainer) {
            TabResourceManager.INSTANCE.getFirstResultContainerShowIcon().set(TabResourceManager.INSTANCE.currentResourceReady());
        }
        if (ResultPageFeature.DEBUG) {
            Log.v(ResultPageFeature.TAG, "MultiTagsFeature: isFirstResultContainer: " + isFirstResultContainer);
            Log.v(ResultPageFeature.TAG, "MultiTagsFeature: currentResourceReady: " + TabResourceManager.INSTANCE.currentResourceReady());
        }
        if (fromProtoBuf) {
            this.multiTabComponent.parseNAData(params);
        } else {
            this.multiTabComponent.parseData(params);
        }
        boolean result = false;
        String str = null;
        if (this.multiTabComponent.isValid()) {
            result = onHandleMultiTab(this.multiTabComponent.getMultiTabData(), this.multiTabComponent.getBasementInfo(), this.multiTabComponent.getMultiTabLogData());
            SearchTabItem searchTagItem = this.multiTabComponent.getSearchTabItem();
            if (searchTagItem != null && !searchTagItem.isSelected && this.searchTagComponent.getSearchTagData() == null && (it = this.multiTabComponent.getSearchTabItem()) != null) {
                updateVisitedSite((String) null, it);
            }
            onHandleTagSearchAfterTab(fromProtoBuf);
        } else if (!SearchABTestUtils.isBackTagDiff().booleanValue()) {
            useDefaultTabData();
        }
        BaseTabContainer baseTabContainer = this.mCurTabContainer;
        if (!(baseTabContainer == null || (tabItem = baseTabContainer.getTabItem()) == null)) {
            str = tabItem.pd;
        }
        setPullToRefreshView(str);
        return result;
    }

    private final void onHandleTagSearchAfterTab(boolean fromProtoBuf) {
        if (!isFixMode() && this.multiTabComponent.isShowResourceTag() && !this.searchTagComponent.getHasNonResourceTagData()) {
            if (!fromProtoBuf) {
                Boolean isBackTagDiff = SearchABTestUtils.isBackTagDiff();
                Intrinsics.checkNotNullExpressionValue(isBackTagDiff, "isBackTagDiff()");
                if (isBackTagDiff.booleanValue() || !this.mMultiTabManager.mIsUseDefaultData) {
                    this.multiTabComponent.setHasSearchTag(false);
                }
            }
            if (!this.multiTabComponent.isHasSearchTag()) {
                this.searchTagComponent.cacheParams("");
            }
            UiThreadUtils.runOnUiThread(new MultiTagsFeature$$ExternalSyntheticLambda10(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onHandleTagSearchAfterTab$lambda-23  reason: not valid java name */
    public static final void m12891onHandleTagSearchAfterTab$lambda23(MultiTagsFeature this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SearchTagComponent searchTagComponent2 = this$0.searchTagComponent;
        NgWebView webView = this$0.getWebView();
        SearchTagData searchTagData = null;
        searchTagComponent2.setUrl(webView != null ? webView.getUrl() : null);
        if (!SearchABTestUtils.isBackTagDiff().booleanValue()) {
            this$0.searchTagComponent.parseCachedParams();
            this$0.onHandleNaProtoTagSearch(this$0.searchTagComponent.getSearchTagData());
        }
        if (ResultPageABTest.isTabTagMixed()) {
            SearchTagComponent searchTagComponent3 = this$0.searchTagComponent;
            SearchTagView curSearchTagView = this$0.curSearchTagView();
            if (curSearchTagView != null) {
                searchTagData = curSearchTagView.getSearchTagData();
            }
            if (searchTagComponent3.changeResourceTagList(searchTagData, this$0.searchTagComponent.getUrl())) {
                SearchTagView curSearchTagView2 = this$0.curSearchTagView();
                if (curSearchTagView2 != null) {
                    curSearchTagView2.updateMoreTagVisibility();
                }
                SearchTagView curSearchTagView3 = this$0.curSearchTagView();
                if (curSearchTagView3 != null) {
                    curSearchTagView3.notifyUIChanged();
                    return;
                }
                return;
            }
        }
        Boolean isBackTagDiff = SearchABTestUtils.isBackTagDiff();
        Intrinsics.checkNotNullExpressionValue(isBackTagDiff, "isBackTagDiff()");
        if (isBackTagDiff.booleanValue()) {
            this$0.searchTagComponent.parseCachedParams();
            this$0.onHandleNaProtoTagSearch(this$0.searchTagComponent.getSearchTagData());
        }
    }

    public void onHandleNaProtoTagSearch(String params, String url) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.searchTagComponent.setUrl(url);
        if (this.multiTabComponent.isParsed() && Intrinsics.areEqual((Object) this.multiTabComponent.isSelectedPd(), (Object) "note")) {
            this.multiTabComponent.resetData();
        }
        if (this.multiTabComponent.isParsed()) {
            this.searchTagComponent.parseNAData(params);
            onHandleNaProtoTagSearch(this.searchTagComponent.getSearchTagData());
            return;
        }
        this.searchTagComponent.cacheParams(params);
        boolean z = true;
        this.multiTabComponent.setHasSearchTag(true);
        Boolean isBackTagDiff = SearchABTestUtils.isBackTagDiff();
        Intrinsics.checkNotNullExpressionValue(isBackTagDiff, "isBackTagDiff()");
        if (isBackTagDiff.booleanValue() && ResultPageABTest.isTabTagMixed()) {
            if (params.length() <= 0) {
                z = false;
            }
            if (z) {
                this.searchTagComponent.parseNAData(params);
                onHandleNaProtoTagSearch(this.searchTagComponent.getSearchTagData());
            }
        }
    }

    public boolean parseTabInfo(String params, String url) {
        SearchTabItem tabItem;
        boolean z = false;
        if (params == null) {
            return false;
        }
        if (url != null) {
            SearchTabItem itemByUrl = getItemByUrl(url);
            String curTabPd = null;
            String infoTabPd = itemByUrl != null ? itemByUrl.pd : null;
            BaseTabContainer baseTabContainer = this.mCurTabContainer;
            if (!(baseTabContainer == null || (tabItem = baseTabContainer.getTabItem()) == null)) {
                curTabPd = tabItem.pd;
            }
            if (!TextUtils.equals(infoTabPd, curTabPd)) {
                SearchTabItem infoTab = this.multiTabComponent.getTabItem(params, infoTabPd);
                if (infoTab != null && infoTab.isNaDegrade()) {
                    z = true;
                }
                return !z;
            }
        }
        this.multiTabComponent.parseData(params);
        if (!this.multiTabComponent.isValid() || this.multiTabComponent.isSelectedNaTabDegraded() || !this.mMultiTabManager.parseTabInfo(this.multiTabComponent.getMultiTabData(), this.multiTabComponent.getMultiTabLogData())) {
            return false;
        }
        if (!ResultPageABTest.isMoveFilterToTab()) {
            UiThreadUtils.runOnUiThread(new MultiTagsFeature$$ExternalSyntheticLambda0(this));
        }
        onHandleTagSearchAfterTab(false);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: parseTabInfo$lambda-25  reason: not valid java name */
    public static final void m12893parseTabInfo$lambda25(MultiTagsFeature this$0) {
        SearchTabItem it;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.searchTagComponent.getSearchTagData() == null && (it = this$0.multiTabComponent.getSearchTabItem()) != null) {
            this$0.updateVisitedSite((String) null, it);
        }
    }

    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getFavorUrl() {
        /*
            r4 = this;
            com.baidu.browser.tabna.BaseTabContainer r0 = r4.mCurTabContainer
            if (r0 == 0) goto L_0x0009
            com.baidu.browser.tabna.BaseTabContainer r0 = r0.getParentContainer()
            goto L_0x000a
        L_0x0009:
            r0 = 0
        L_0x000a:
            boolean r1 = r0 instanceof com.baidu.browser.explore.tab.MultiTabContainer
            if (r1 == 0) goto L_0x0044
            r1 = r0
            com.baidu.browser.explore.tab.MultiTabContainer r1 = (com.baidu.browser.explore.tab.MultiTabContainer) r1
            boolean r1 = r1.isResourceContainer()
            if (r1 == 0) goto L_0x0044
            r1 = r0
            com.baidu.browser.explore.tab.MultiTabContainer r1 = (com.baidu.browser.explore.tab.MultiTabContainer) r1
            com.baidu.browser.explore.tab.na.tag.SearchTagView r1 = r1.getSearchTagView()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0029
            boolean r1 = r1.isAllTag()
            if (r1 != r2) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r2 = r3
        L_0x002a:
            if (r2 == 0) goto L_0x0031
            java.lang.String r1 = super.getFavorUrl()
            return r1
        L_0x0031:
            com.baidu.searchbox.multitab.MultiTabManager r1 = r4.getMultiTabManager()
            com.baidu.browser.tabna.SearchTabItem r1 = r1.getCurrentItem()
            if (r1 == 0) goto L_0x003f
            java.lang.String r1 = r1.url
            if (r1 != 0) goto L_0x0043
        L_0x003f:
            java.lang.String r1 = super.getFavorUrl()
        L_0x0043:
            return r1
        L_0x0044:
            java.lang.String r1 = super.getFavorUrl()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.explore.mutable.feature.MultiTagsFeature.getFavorUrl():java.lang.String");
    }

    public boolean handleShare(String entrance, String page) {
        String url;
        BaseTabContainer baseTabContainer = this.mCurTabContainer;
        BaseTabContainer curContainer = baseTabContainer != null ? baseTabContainer.getParentContainer() : null;
        if (!(curContainer instanceof MultiTabContainer) || !((MultiTabContainer) curContainer).isResourceContainer()) {
            return super.handleShare(entrance, page);
        }
        SearchTagView searchTagView = ((MultiTabContainer) curContainer).getSearchTagView();
        if (searchTagView != null && searchTagView.isAllTag()) {
            return false;
        }
        SearchTabItem currentItem = getMultiTabManager().getCurrentItem();
        if (currentItem == null || (url = currentItem.url) == null) {
            url = this.mCurTabContainer.getHtmlUrl();
        }
        BaiduShareContent baiduShareContent = new BaiduShareContent.Builder().setTitle(getTitle()).setLinkUrl(url).setMediaType("all").setContent(BaseNaTabContainer.SHARE_CONTENT).setShareEntrance(entrance).setShareExtPage(page).create();
        if (this.mCurTabContainer instanceof TopicNaContainer) {
            baiduShareContent.setCategoryData(ForwardUtils.getScheme(baiduShareContent, (String) null));
        }
        BDShare.getInstance().share(getContext(), (View) null, baiduShareContent);
        return true;
    }

    public boolean isResultPageBackTab(BaseTabContainer tabContainer, BaseTabContainer newContainer, boolean isFromSnapshot) {
        if (tabContainer == null) {
            return false;
        }
        BaseTabContainer curContainer = tabContainer.getParentContainer();
        Boolean isTagBack = SearchABTestUtils.isTagBack();
        Intrinsics.checkNotNullExpressionValue(isTagBack, "isTagBack()");
        if (!isTagBack.booleanValue() || isFixMode() || !isFromSnapshot) {
            Object obj = null;
            if ((curContainer instanceof MultiTabContainer) && ((MultiTabContainer) curContainer).isResourceContainer()) {
                if (AppConfig.isDebug()) {
                    Log.d(ResultPageFeature.TAG, "isResultPageBackTab 返回到资源tag");
                }
                SearchTagView searchTagView = ((MultiTabContainer) curContainer).getSearchTagView();
                if (searchTagView != null) {
                    obj = searchTagView.getPd();
                }
                return TextUtils.isEmpty((CharSequence) obj);
            } else if (!ResultPageABTest.isMoveFilterToTab() || this.currClickTagForFilter == null) {
                if (SearchABTestUtils.isUgcChangeBack()) {
                    boolean isAll = isMultiTabAll(tabContainer);
                    if (!AppConfig.isDebug()) {
                        return isAll;
                    }
                    Log.d(ResultPageFeature.TAG, "isResultPageBackTab 返回到综合：" + isAll);
                    return isAll;
                }
                BaseTabContainer baseTabContainer = getContainerAdapter().getContainers().get(0);
                if (baseTabContainer != null) {
                    obj = baseTabContainer.getContainer();
                }
                return Intrinsics.areEqual((Object) tabContainer, obj);
            } else if (!AppConfig.isDebug()) {
                return true;
            } else {
                Log.d(ResultPageFeature.TAG, "isResultPageBackTab 返回到筛选面板tag");
                return true;
            }
        } else if (!MultiTagHelperKt.isSwitchOtherTab(tabContainer, newContainer)) {
            return false;
        } else {
            if (ResultPageFeature.DEBUG) {
                Log.d(MultiTagsFeatureKt.TAG_BACK_TAG, "tag回退实验下 触发了tab切换截图");
            }
            return true;
        }
    }

    public int getBackContainerPos() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public View getTagRootView() {
        BaseTabContainer parentContainer = this.mCurTabContainer.getParentContainer();
        if (parentContainer instanceof MultiTabContainer) {
            return ((MultiTabContainer) parentContainer).getRootView();
        }
        if (this.mCurTabContainer instanceof BaseWebViewTabContainer) {
            return this.mCurTabContainer.rootView();
        }
        View view2 = null;
        return null;
    }

    /* access modifiers changed from: protected */
    public String getContainerPageParamsKey(int index) {
        String pd;
        SearchTabItem tabItem;
        BaseTabContainer baseTabContainer = this.mCurTabContainer;
        SearchTagItem tag = null;
        BaseTabContainer parentContainer = baseTabContainer != null ? baseTabContainer.getParentContainer() : null;
        if (!(parentContainer instanceof MultiTabContainer) || !((MultiTabContainer) parentContainer).isResourceContainer()) {
            BaseTabContainer baseTabContainer2 = this.mCurTabContainer;
            pd = (baseTabContainer2 == null || (tabItem = baseTabContainer2.getTabItem()) == null) ? null : tabItem.pd;
        } else {
            SearchTagView searchTagView = ((MultiTabContainer) parentContainer).getSearchTagView();
            pd = searchTagView != null ? searchTagView.curSelectPd() : null;
        }
        if (this.mCurTabContainer instanceof BaseWebViewTabContainer) {
            BaseTabContainer baseTabContainer3 = this.mCurTabContainer;
            BaseWebViewTabContainer baseWebViewTabContainer = baseTabContainer3 instanceof BaseWebViewTabContainer ? (BaseWebViewTabContainer) baseTabContainer3 : null;
            if (baseWebViewTabContainer != null) {
                tag = baseWebViewTabContainer.currTag;
            }
        } else {
            tag = this.currClickTag;
        }
        return getGroupCardKey(pd, tag);
    }

    public String getInterceptUrlForRefresh() {
        SearchTabItem tabItem;
        BaseTabContainer curTabContainer = getCurTabContainer();
        boolean z = true;
        if (curTabContainer == null || (tabItem = curTabContainer.getTabItem()) == null || !tabItem.isResourceTab()) {
            z = false;
        }
        if (!z) {
            return super.getInterceptUrlForRefresh();
        }
        String str = null;
        return null;
    }

    public void onWebViewTagClick(SearchTagItem item, String pd) {
        Intrinsics.checkNotNullParameter(item, "item");
        NgWebView webView = getWebView(pd, item);
        if (webView != null) {
            if (ResultPageFeature.DEBUG) {
                Log.i(MultiTagsFeatureKt.TAG_BACK_TAG, "MultiTags Feature: onWebViewTagClick: " + item.getTagKey() + " pd is " + pd + " webView is " + Integer.valueOf(webView.hashCode()));
            }
            ISailorWebViewExt webViewExt = webView.getWebViewExt();
            if (webViewExt != null) {
                String tagUrl = item.getTagUrl();
                CharSequence charSequence = tagUrl;
                boolean z = false;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    String tagUrl2 = BrowserUrlUtils.modifyDebugSearchUrl(tagUrl);
                    Boolean isTagBack = SearchABTestUtils.isTagBack();
                    Intrinsics.checkNotNullExpressionValue(isTagBack, "isTagBack()");
                    if (isTagBack.booleanValue() && (getCurTabContainer() instanceof BaseWebViewTabContainer)) {
                        BaseTabContainer curTabContainer = getCurTabContainer();
                        BaseWebViewTabContainer baseWebViewTabContainer = curTabContainer instanceof BaseWebViewTabContainer ? (BaseWebViewTabContainer) curTabContainer : null;
                        if (baseWebViewTabContainer != null) {
                            baseWebViewTabContainer.currTag = item;
                        }
                        if (ResultPageFeature.DEBUG) {
                            StringBuilder append = new StringBuilder().append("set currTag is ").append(item.getTagKey()).append(" container is ");
                            BaseTabContainer curTabContainer2 = getCurTabContainer();
                            Log.d(MultiTagsFeatureKt.TAG_BACK_TAG, append.append(curTabContainer2 != null ? curTabContainer2.getContainerId() : null).toString());
                        }
                    }
                    fixWebView(this.mCurTabContainer, webView);
                    String currentUrl = webView.getUrl();
                    Map headers = BrowserUrlUtils.addSearchNeedHeader((Map<String, String>) null, GroupCardBackgroundKt.getGroupCardNaWH(getContext()), SearchWifiBind4GFeature.INSTANCE.getSettingSwitchValue(), SessionIdUtilKt.getSessionId());
                    Intrinsics.checkNotNullExpressionValue(headers, "addSearchNeedHeader(null…hValue(), getSessionId())");
                    if (SearchABTestUtils.isEnableSearchNaProto()) {
                        TabHistoryManager tabHistoryManager = this.mTabHistoryManager;
                        if (tabHistoryManager != null) {
                            tabHistoryManager.updateTagUrl(tagUrl2);
                        }
                        if (item.isResourceTag() || (ResultPageABTest.isMoveFilterToTab() && item.isFilterOrSort())) {
                            NaRequestManager.startSearchRequest$default(NaRequestManager.INSTANCE, tagUrl2, (HashMap) null, (String) null, 6, (Object) null);
                            webViewExt.loadUrl(tagUrl2, headers, true);
                        } else if (BrowserUrlUtils.isTabUrl(currentUrl)) {
                            String searchUrl = item.getUrl();
                            if (searchUrl == null) {
                                searchUrl = tagUrl2;
                            }
                            String searchUrl2 = BrowserUrlUtils.modifyDebugSearchUrl(searchUrl);
                            NaRequestManager.INSTANCE.startSearchRequest(tagUrl2, (HashMap<String, String>) null, searchUrl2);
                            webViewExt.loadUrl(searchUrl2, headers, true);
                        } else {
                            if (currentUrl != null) {
                                if (currentUrl.length() > 0) {
                                    z = true;
                                }
                            }
                            if (!z || PreLoadBlankPageHelper.isPreloadBlankPage(currentUrl)) {
                                NaRequestManager.startSearchRequest$default(NaRequestManager.INSTANCE, tagUrl2, (HashMap) null, (String) null, 4, (Object) null);
                                webViewExt.loadUrl(tagUrl2, headers, true);
                                return;
                            }
                            NaRequestManager.INSTANCE.startSearchRequest(tagUrl2, (HashMap<String, String>) null, currentUrl);
                            webViewExt.loadUrl(currentUrl, headers, true);
                        }
                    } else {
                        webViewExt.loadUrl(tagUrl2, headers, true);
                    }
                }
            }
        }
    }

    private final String getCurrAllTagUrl() {
        SearchTagData searchTagData;
        List<SearchTagItem> tags;
        SearchTagItem searchTagItem;
        BaseTabContainer baseTabContainer = this.mCurTabContainer;
        BaseTabContainer parentContainer = baseTabContainer != null ? baseTabContainer.getParentContainer() : null;
        MultiTabContainer multiTabContainer = parentContainer instanceof MultiTabContainer ? (MultiTabContainer) parentContainer : null;
        SearchTagView tagView = multiTabContainer != null ? multiTabContainer.getSearchTagView() : null;
        if (tagView == null || (searchTagData = tagView.getSearchTagData()) == null || (tags = searchTagData.getTags()) == null || (searchTagItem = tags.get(0)) == null) {
            return null;
        }
        return searchTagItem.getTagUrl();
    }

    private final void fixWebView(BaseTabContainer tabContainer, NgWebView webview) {
        if (tabContainer instanceof MixTabContainer) {
            LinkageWebView linkageWebView = ((MixTabContainer) tabContainer).getLinkageWebView();
            if (!Intrinsics.areEqual((Object) linkageWebView != null ? linkageWebView.getWebView() : null, (Object) webview)) {
                ((MixTabContainer) tabContainer).changeWebView(webview);
            }
        }
    }

    public void removeTagInfo() {
        BaseTabContainer baseTabContainer = null;
        if (this.mTabHistoryManager != null && isCurrentMultiTabAll() && !TextUtils.isEmpty(getReplaceTagUrl())) {
            this.mTabHistoryManager.updateTagUrl((String) null);
        }
        BaseTabContainer baseTabContainer2 = this.mCurTabContainer;
        if (baseTabContainer2 != null) {
            baseTabContainer = baseTabContainer2.getParentContainer();
        }
        if (baseTabContainer instanceof MultiTabContainer) {
            UiThreadUtils.runOnUiThread(new MultiTagsFeature$$ExternalSyntheticLambda6(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: removeTagInfo$lambda-26  reason: not valid java name */
    public static final void m12895removeTagInfo$lambda26(MultiTagsFeature this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseTabContainer baseTabContainer = this$0.mCurTabContainer;
        BaseTabContainer parentContainer = baseTabContainer != null ? baseTabContainer.getParentContainer() : null;
        if (parentContainer != null) {
            ((MultiTabContainer) parentContainer).removeTagView();
            this$0.showSearchTag();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.baidu.browser.explore.tab.MultiTabContainer");
    }

    /* access modifiers changed from: protected */
    public boolean isBrowsingTab() {
        if (!isSupportBrowsingTag(this.mCurTabContainer)) {
            return false;
        }
        return super.isBrowsingTab();
    }

    public BaseTabContainer getPreContainerFromHistory() {
        Boolean isTagBack = SearchABTestUtils.isTagBack();
        Intrinsics.checkNotNullExpressionValue(isTagBack, "isTagBack()");
        if (!isTagBack.booleanValue() || !isCurrInMoreFilter()) {
            return super.getPreContainerFromHistory();
        }
        return getAllNoFilterContainer();
    }

    public boolean ifCanScrollRightByTag() {
        Boolean isTagBack = SearchABTestUtils.isTagBack();
        Intrinsics.checkNotNullExpressionValue(isTagBack, "isTagBack()");
        return (isTagBack.booleanValue() && isCurrInMoreFilter()) || (ResultPageABTest.isMoveFilterToTab() && ResultPageABTest.isMoveFilterSupportSlideToAll());
    }

    public void scrollAutoRightEnd(BaseTabContainer currContainer, BaseTabContainer preContainer) {
        super.scrollAutoRightEnd(currContainer, preContainer);
        Boolean isTagBack = SearchABTestUtils.isTagBack();
        Intrinsics.checkNotNullExpressionValue(isTagBack, "isTagBack()");
        if (isTagBack.booleanValue() && Intrinsics.areEqual((Object) getAllNoFilterContainer(), (Object) preContainer) && MultiTagHelperKt.isContainerInFilter(currContainer)) {
            backToAllTag();
        }
    }

    public boolean canBackToAllTag(BaseTabContainer container) {
        if (!SearchABTestUtils.isTagBack().booleanValue()) {
            return false;
        }
        if (!MultiTagHelperKt.isContainerInFilter(container == null ? this.mCurTabContainer : container) || getAllNoFilterContainer() == null || MultiTagHelperKt.isContainerInFilter(getAllNoFilterContainer())) {
            return false;
        }
        return true;
    }

    private final BaseTabContainer getAllNoFilterContainer() {
        return this.mTabContainerManager.getContainer(createContainerKeyByPd((String) null, (SearchTagItem) null));
    }

    public void backToAllTag() {
        SearchTagItem tagItem;
        Handler mainHandler;
        Boolean isTagBack = SearchABTestUtils.isTagBack();
        Intrinsics.checkNotNullExpressionValue(isTagBack, "isTagBack()");
        if (isTagBack.booleanValue() && (tagItem = getAllTagWithoutFilter()) != null) {
            this.currClickTag = tagItem;
            this.currClickTagForFilter = tagItem;
            setSnapshotFilter((BitmapDrawable) null);
            SearchTabItem tabInResourceTag = getItemByUrl(tagItem.getTagUrl());
            if (!(tabInResourceTag == null || tabInResourceTag.position == -1)) {
                this.mMultiTabManager.setCurrentIndex(tabInResourceTag.position, tabInResourceTag);
            }
            if (ResultPageFeature.DEBUG) {
                Log.d(MultiTagsFeatureKt.TAG_BACK_TAG, "backToAllTag tab pd is " + (tabInResourceTag != null ? tabInResourceTag.pd : null) + ", tag is " + tagItem.getTagKey());
            }
            boolean z = false;
            showResultContainer(tabInResourceTag, tagItem, false);
            BaseTabContainer parentContainer = this.mCurTabContainer.getParentContainer();
            MultiTabContainer multiTabContainer = parentContainer instanceof MultiTabContainer ? (MultiTabContainer) parentContainer : null;
            if (multiTabContainer != null) {
                multiTabContainer.switchTagViewVisible();
            }
            BaseTabContainer baseTabContainer = this.mCurTabContainer;
            BaseTabContainer parentContainer2 = baseTabContainer != null ? baseTabContainer.getParentContainer() : null;
            MultiTabContainer multiTabContainer2 = parentContainer2 instanceof MultiTabContainer ? (MultiTabContainer) parentContainer2 : null;
            if (multiTabContainer2 != null) {
                multiTabContainer2.resetTagView();
            }
            SearchTagView curSearchTagView = curSearchTagView();
            String groupCardKey = getGroupCardKey(curSearchTagView != null ? curSearchTagView.curSelectPd() : null, tagItem);
            if (!this.mGroupCardParamsMap.containsKey(groupCardKey)) {
                hideGroupCard();
            } else {
                if (ResultPageFeature.DEBUG) {
                    Log.d(MultiTagsFeatureKt.TAG_BACK_TAG, "手势返回后重新设置通栏数据， key是 " + groupCardKey);
                }
                showGroupCard(NightModeHelper.isNightMode());
                GroupCardParams params = (GroupCardParams) this.mGroupCardParamsMap.get(groupCardKey);
                if (params != null && params.isImage()) {
                    z = true;
                }
                if (z && (mainHandler = UiThreadUtils.getMainHandler()) != null) {
                    mainHandler.post(new MultiTagsFeature$$ExternalSyntheticLambda3(this, params));
                }
            }
            resetPullToRefreshView();
            hideLoadingView(true);
            MultiTagHelperKt.showBackToNoFilterToast(getContext());
            MultiTabFeature.refreshEdgeMode$default(this, (BaseTabContainer) null, 1, (Object) null);
            updateCoordinatorScrollState();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: backToAllTag$lambda-27  reason: not valid java name */
    public static final void m12888backToAllTag$lambda27(MultiTagsFeature this$0, GroupCardParams $params) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.removeContainerBg(this$0.mCurTabContainer, $params);
    }

    /* access modifiers changed from: protected */
    public String getGroupCardKey(String pd, SearchTagItem tagItem) {
        Boolean isTagBack = SearchABTestUtils.isTagBack();
        Intrinsics.checkNotNullExpressionValue(isTagBack, "isTagBack()");
        if (isTagBack.booleanValue()) {
            String finalPd = pd;
            if (TextUtils.isEmpty(finalPd)) {
                String str = null;
                if (!TextUtils.isEmpty(tagItem != null ? tagItem.getResourcePd() : null)) {
                    if (tagItem != null) {
                        str = tagItem.getResourcePd();
                    }
                    finalPd = str;
                }
            }
            String notNullPd = getNotNullPd(finalPd);
            Intrinsics.checkNotNullExpressionValue(notNullPd, "getNotNullPd(finalPd)");
            if (!TextUtils.isEmpty(finalPd) && !TextUtils.equals("total", finalPd)) {
                return notNullPd;
            }
            boolean z = true;
            if (tagItem == null || !tagItem.isInMoreFilter()) {
                z = false;
            }
            if (z) {
                return notNullPd + "_filter";
            }
            return notNullPd;
        }
        String notNullPd2 = getNotNullPd(pd);
        Intrinsics.checkNotNullExpressionValue(notNullPd2, "{\n            getNotNullPd(pd)\n        }");
        return notNullPd2;
    }

    public NgWebView getWebView(String pd, SearchTagItem tag) {
        if (!SearchABTestUtils.isTagBack().booleanValue()) {
            return super.getWebView();
        }
        NgWebView resultNgWebView = (NgWebView) getTabNgWebViewMaps().get(MultiTabFeature.createWebviewKeyByPd$default(this, pd, tag, (Boolean) null, 4, (Object) null));
        if (resultNgWebView != null) {
            return resultNgWebView;
        }
        if (getCurTabContainer() instanceof BaseWebViewTabContainer) {
            return super.getWebView();
        }
        return null;
    }

    public NgWebView getWebviewByContainerAndPd(BaseTabContainer tabContainer, String pd) {
        if (!SearchABTestUtils.isTagBack().booleanValue()) {
            return super.getWebviewByContainerAndPd(tabContainer, pd);
        }
        if (tabContainer instanceof MixTabContainer) {
            LinkageWebView linkageWebView = ((MixTabContainer) tabContainer).getLinkageWebView();
            if (linkageWebView != null) {
                return linkageWebView.getWebView();
            }
            return null;
        } else if (tabContainer instanceof BaseWebViewTabContainer) {
            return ((BaseWebViewTabContainer) tabContainer).getCurrentNgWebView();
        } else {
            return getWebView(pd, (SearchTagItem) null);
        }
    }

    public String createWebviewKeyByPd(String pd, SearchTagItem tag, Boolean useCurrContainertag) {
        if (!SearchABTestUtils.isTagBack().booleanValue()) {
            return pd;
        }
        String resultPd = pd;
        SearchTagItem resultTag = tag;
        if (resultTag == null && Intrinsics.areEqual((Object) useCurrContainertag, (Object) true)) {
            BaseTabContainer baseTabContainer = this.mCurTabContainer;
            SearchTagItem searchTagItem = null;
            BaseWebViewTabContainer baseWebViewTabContainer = baseTabContainer instanceof BaseWebViewTabContainer ? (BaseWebViewTabContainer) baseTabContainer : null;
            if (baseWebViewTabContainer != null) {
                searchTagItem = baseWebViewTabContainer.currTag;
            }
            resultTag = searchTagItem;
        }
        if (resultTag == null || !resultTag.isInMoreFilter()) {
            return resultPd == null ? this.WEBVIEW_MAP_KEY_ALL_TAG_PD : resultPd;
        }
        return MultiTagsFeatureKt.WEBVIEW_MAP_KEY_ALL_FILTER;
    }

    public String createContainerKeyByPd(String pd, SearchTagItem tagItem) {
        if (!SearchABTestUtils.isTagBack().booleanValue()) {
            return pd;
        }
        if (tagItem == null || !tagItem.isInMoreFilter()) {
            return pd == null ? "webview" : pd;
        }
        return MultiTagsFeatureKt.CONTAINER_MAP_KEY_ALL_FILTER;
    }

    /* access modifiers changed from: protected */
    public void beforTabSwitch() {
        this.currClickTag = null;
        super.beforTabSwitch();
    }

    public void removeTagView() {
        BaseTabContainer baseTabContainer = this.mCurTabContainer;
        MultiTabContainer multiTabContainer = null;
        ContainerLifeCycleOwner parentContainer = baseTabContainer != null ? baseTabContainer.getParentContainer() : null;
        if (parentContainer instanceof MultiTabContainer) {
            multiTabContainer = (MultiTabContainer) parentContainer;
        }
        if (multiTabContainer != null) {
            multiTabContainer.removeTagView();
        }
        this.multiTabComponent.resetData();
        this.searchTagComponent.resetData();
        showSearchTag();
        View tagRootView = getTagRootView();
        if (tagRootView != null) {
            tagRootView.setTranslationY(0.0f);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isFilterSelected() {
        return getCurrentFilterTitle() != null;
    }

    public void clearBtnClick(boolean isReClick) {
        if (!ResultPageABTest.isShowFilterAtAllTabs() || isInAllTab()) {
            AdvanceFilterEvent event = new AdvanceFilterEvent(4);
            event.fromCleanBtn = true;
            event.fromReClick = isReClick;
            BdEventBus.Companion.getDefault().post(event);
            return;
        }
        clearVsFilter(isReClick);
    }

    public void clearFilters() {
        moreItemHandle(false);
        View tagRootView = getTagRootView();
        if (tagRootView != null) {
            tagRootView.setTranslationY(0.0f);
        }
        SearchTagItem searchTagItem = getAllTagWithoutFilter();
        if (searchTagItem != null) {
            SearchTagItem it = searchTagItem;
            Function2<? super SearchTagItem, ? super String, Unit> function2 = this.tagsClick;
            if (function2 != null) {
                function2.invoke(it, "");
            }
            setWeakNetworkParent(getAllNoFilterContainer(), 0);
            weakNetworkDetect();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        if ((r0.length() > 0) == true) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.mTabItem;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void clearVsFilter(boolean r5) {
        /*
            r4 = this;
            com.baidu.browser.tabna.BaseTabContainer r0 = r4.mCurTabContainer
            if (r0 == 0) goto L_0x000b
            com.baidu.browser.tabna.SearchTabItem r0 = r0.mTabItem
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r0.pd
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001f
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x001b
            r3 = r1
            goto L_0x001c
        L_0x001b:
            r3 = r2
        L_0x001c:
            if (r3 != r1) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r1 = r2
        L_0x0020:
            if (r1 == 0) goto L_0x004c
            r4.moreItemHandle(r2)
            android.view.View r1 = r4.getTagRootView()
            if (r1 != 0) goto L_0x002c
            goto L_0x0030
        L_0x002c:
            r3 = 0
            r1.setTranslationY(r3)
        L_0x0030:
            com.baidu.browser.explore.tab.na.tag.data.SearchTagItem r1 = r4.getAllTagWithoutVsFilter(r0)
            if (r1 != 0) goto L_0x0037
            return
        L_0x0037:
            r4.onVsTagClick(r0, r1)
            com.baidu.browser.tabna.BaseTabContainer r3 = r4.mCurTabContainer
            boolean r3 = r3 instanceof com.baidu.browser.tabna.BaseNaTabContainer
            if (r3 == 0) goto L_0x0043
            r4.weakNetworkDetect()
        L_0x0043:
            if (r5 != 0) goto L_0x004c
            java.lang.String r3 = r4.getCurrentFilterTitle()
            com.baidu.browser.components.commonmenu.advancefilter.CommonMenuUbc.filterCancelClick(r2, r3, r0)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.explore.mutable.feature.MultiTagsFeature.clearVsFilter(boolean):void");
    }

    private final SearchTagItem getAllTagWithoutFilter() {
        SearchTabItem allItem = this.mMultiTabManager.getSearchTabItemByTab((String) null);
        if (allItem != null) {
            return SearchTagDataKt.createResourceTagItem(allItem, getQuery(), 0, 0, getUrl());
        }
        return null;
    }

    private final SearchTagItem getAllTagWithoutVsFilter(String pd) {
        SearchTabItem allItem = this.mMultiTabManager.getSearchTabItemByTab(pd);
        if (allItem == null) {
            return null;
        }
        boolean z = false;
        SearchTagItem tagItem = SearchTagDataKt.createResourceTagItem(allItem, getQuery(), 0, 0, getUrl());
        tagItem.setFilterOrSort(true);
        tagItem.setInMoreFilter(true);
        String str = allItem.originalUrl;
        if (str != null) {
            if (str.length() > 0) {
                z = true;
            }
        }
        if (z) {
            tagItem.setTagUrl(allItem.originalUrl);
        } else {
            tagItem.setTagUrl(allItem.url);
        }
        return tagItem;
    }

    public void onResume(Intent intent) {
        super.onResume(intent);
        registerAdvanceFilterEvent();
    }

    public void onPause() {
        super.onPause();
        unregisterAdvanceFilterEvent();
        MultiTagHelperKt.hideBackToNoFilterToast();
        ChatSearchTabGuideManager.INSTANCE.dismissBubble();
    }

    private final void registerAdvanceFilterEvent() {
        unregisterAdvanceFilterEvent();
        BdEventBus.Companion.getDefault().register(this, AdvanceFilterEvent.class, 1, new MultiTagsFeature$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: registerAdvanceFilterEvent$lambda-30  reason: not valid java name */
    public static final void m12894registerAdvanceFilterEvent$lambda30(MultiTagsFeature this$0, AdvanceFilterEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "event");
        if (AppConfig.isDebug()) {
            Log.d(ResultPageFeature.TAG, "AdvanceFilterEvent ");
        }
        if (event.getEventType() == 4) {
            if (!event.fromCleanBtn) {
                CommonMenuUbc.filterCancelClick(1, this$0.getCurrentFilterTitle());
            } else if (!event.fromReClick) {
                CommonMenuUbc.filterCancelClick(0, this$0.getCurrentFilterTitle());
            }
            this$0.clearFilters();
        }
        this$0.needShowClearBackToast = true;
    }

    private final void unregisterAdvanceFilterEvent() {
        BdEventBus.Companion.getDefault().unregister(this);
    }

    public boolean isFilterTag() {
        boolean isAllTab = isMultiTabAll(this.mCurTabContainer);
        if (ResultPageABTest.isMoveFilterToTab() && isFilterSelected()) {
            return false;
        }
        SearchTagView curSearchTagView = curSearchTagView();
        return curSearchTagView != null ? curSearchTagView.isFilterTag() : isAllTab;
    }

    private final boolean isInAllTab() {
        SearchTabItem searchTabItem = this.mMultiTabManager.getSearchTabItem(this.mMultiTabManager.getCurrentIndex());
        return searchTabItem != null && searchTabItem.isSearch;
    }

    private final String getFilterUrl(boolean isInAllTab) {
        if (ResultPageABTest.isShowFilterAtAllTabs()) {
            if (!isInAllTab) {
                BaseTabContainer container = this.mCurTabContainer;
                if (!(container instanceof BaseNaTabContainer)) {
                    return getUrl();
                }
                String str = ((BaseNaTabContainer) container).mRefreshUrl;
                if (str != null) {
                    return str;
                }
                SearchTabItem tabItem = ((BaseNaTabContainer) container).getTabItem();
                if (tabItem != null) {
                    return tabItem.url;
                }
                return null;
            } else if (BrowserUrlUtils.checkSearchResultSimple(getUrl())) {
                return getUrl();
            } else {
                SearchTabItem searchTabItemByTab = this.mMultiTabManager.getSearchTabItemByTab((String) null);
                if (searchTabItemByTab != null) {
                    return searchTabItemByTab.url;
                }
                return null;
            }
        } else if (BrowserUrlUtils.checkSearchResultSimple(getUrl())) {
            return getUrl();
        } else {
            SearchTabItem searchTabItemByTab2 = this.mMultiTabManager.getSearchTabItemByTab((String) null);
            if (searchTabItemByTab2 != null) {
                return searchTabItemByTab2.url;
            }
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r2 = r2.mTabItem;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getCurrentFilterTitle() {
        /*
            r14 = this;
            com.baidu.searchbox.multitab.MultiTabManager r0 = r14.mMultiTabManager
            java.util.List r0 = r0.getTabList()
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            int r2 = r0.size()
            int r3 = r14.tabMaxSize()
            if (r2 > r3) goto L_0x0015
            return r1
        L_0x0015:
            com.baidu.browser.tabna.BaseTabContainer r2 = r14.mCurTabContainer
            if (r2 == 0) goto L_0x0020
            com.baidu.browser.tabna.SearchTabItem r2 = r2.mTabItem
            if (r2 == 0) goto L_0x0020
            java.lang.String r2 = r2.pd
            goto L_0x0021
        L_0x0020:
            r2 = r1
        L_0x0021:
            int r3 = r14.tabMaxSize()
            int r4 = r0.size()
            java.util.List r3 = r0.subList(r3, r4)
            r4 = 0
            int r5 = r3.size()
        L_0x0032:
            if (r4 >= r5) goto L_0x0050
            java.lang.Object r6 = r3.get(r4)
            com.baidu.browser.tabna.SearchTabItem r6 = (com.baidu.browser.tabna.SearchTabItem) r6
            java.lang.String r7 = r6.pd
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x004d
            com.baidu.browser.tabna.BaseTabContainer r5 = r14.mCurTabContainer
            if (r5 == 0) goto L_0x004c
            com.baidu.browser.tabna.SearchTabItem r5 = r5.mTabItem
            if (r5 == 0) goto L_0x004c
            java.lang.String r1 = r5.title
        L_0x004c:
            return r1
        L_0x004d:
            int r4 = r4 + 1
            goto L_0x0032
        L_0x0050:
            boolean r4 = r14.isInAllTab()
            java.lang.String r5 = r14.getFilterUrl(r4)
            boolean r6 = com.baidu.search.basic.utils.ResultPageABTest.isShowFilterAtAllTabs()
            if (r6 == 0) goto L_0x0067
            if (r4 == 0) goto L_0x0065
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
            r6 = r1
            goto L_0x006b
        L_0x0065:
            r6 = r2
            goto L_0x006b
        L_0x0067:
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
            r6 = r1
        L_0x006b:
            if (r4 != 0) goto L_0x0085
            if (r6 == 0) goto L_0x0081
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 != 0) goto L_0x007b
            r7 = 1
            goto L_0x007c
        L_0x007b:
            r7 = 0
        L_0x007c:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            goto L_0x0082
        L_0x0081:
            r7 = r1
        L_0x0082:
            if (r7 != 0) goto L_0x0085
            return r1
        L_0x0085:
            r7 = r5
            r8 = 0
            com.baidu.browser.components.commonmenu.advancefilter.TagAdvanceFilterViewModel r9 = new com.baidu.browser.components.commonmenu.advancefilter.TagAdvanceFilterViewModel
            r9.<init>()
            java.util.ArrayList r9 = r9.getFilterList(r7, r6)
            if (r9 == 0) goto L_0x00bb
            r10 = 0
            java.util.Iterator r11 = r9.iterator()
        L_0x0097:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x00b9
            java.lang.Object r12 = r11.next()
            com.baidu.browser.tablayout.data.MoreNormalItem r12 = (com.baidu.browser.tablayout.data.MoreNormalItem) r12
            boolean r13 = r12 instanceof com.baidu.browser.tablayout.data.MoreSearchTagItem
            if (r13 == 0) goto L_0x0097
            r13 = r12
            com.baidu.browser.tablayout.data.MoreSearchTagItem r13 = (com.baidu.browser.tablayout.data.MoreSearchTagItem) r13
            com.baidu.browser.explore.tab.na.tag.data.SearchTagItem r13 = r13.getItem()
            boolean r13 = r13.isSelected()
            if (r13 == 0) goto L_0x0097
            java.lang.String r1 = r12.getTitle()
            return r1
        L_0x00b9:
        L_0x00bb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.browser.explore.mutable.feature.MultiTagsFeature.getCurrentFilterTitle():java.lang.String");
    }

    public void onFontSizeChange(FontSizeChangeMessage event) {
        super.onFontSizeChange(event);
        BaseTabContainer curTabContainer = getTagTabContainer(getCurTabPd());
        MultiTabContainer multiTabContainer = null;
        if (curTabContainer == null) {
            BaseTabContainer baseTabContainer = this.mCurTabContainer;
            curTabContainer = baseTabContainer != null ? baseTabContainer.getParentContainer() : null;
        }
        updateRefreshViewTopMargin(this.mRefreshView, curTabContainer instanceof MultiTabContainer ? (MultiTabContainer) curTabContainer : null, isTag2Show());
        if (curTabContainer instanceof MultiTabContainer) {
            multiTabContainer = (MultiTabContainer) curTabContainer;
        }
        if (multiTabContainer != null) {
            multiTabContainer.updateCurrContainerParams(isFixMode());
        }
    }
}
