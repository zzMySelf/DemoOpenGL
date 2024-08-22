package com.baidu.searchbox.weather.repo;

import com.baidu.searchbox.location.LocationInfo;
import com.baidu.searchbox.weather.GetConfigParam;
import com.baidu.searchbox.weather.LocationConfigService;
import com.baidu.searchbox.weather.LocationConfigServiceKt;
import com.baidu.searchbox.weather.WeatherLocationConfig;
import com.baidu.searchbox.weather.model.CityManageData;
import com.baidu.searchbox.weather.model.DataSource;
import com.baidu.searchbox.weather.model.SummaryData;
import com.baidu.searchbox.weather.model.WeatherException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rx.Observable;
import rx.Observer;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\"\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013J&\u0010\u0014\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0000\u0012\u00020\n0\u0016H\u0002J&\u0010\u0017\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0000\u0012\u00020\n0\u0016H\u0002J$\u0010\u0018\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0005J\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0002J\u0016\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005J\"\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020#0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0002J\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f*\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0002J\u0016\u0010%\u001a\u00020\u0013*\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0005H\u0002J\f\u0010'\u001a\u00020\n*\u00020\nH\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/baidu/searchbox/weather/repo/CityManageRepo;", "", "()V", "weatherCache", "", "Lcom/baidu/searchbox/weather/WeatherLocationConfig;", "Lcom/baidu/searchbox/weather/repo/CacheEntry;", "addToCache", "", "data", "Lcom/baidu/searchbox/weather/model/CityManageData;", "buildReqParams", "", "", "configs", "", "getCityManageData", "Lrx/Observable;", "refreshLocation", "", "loadFromCache", "observer", "Lrx/Observer;", "loadFromServer", "merge", "now", "", "removeCity", "config", "serverSource", "Lrx/Single;", "swapCity", "src", "dst", "weatherCacheOf", "Lcom/baidu/searchbox/weather/model/SummaryData;", "filterNeedRequest", "isIdentical", "other", "putCacheInEmptySlot", "lib-weather-landing_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CityManageRepo.kt */
public final class CityManageRepo {
    public static final CityManageRepo INSTANCE = new CityManageRepo();
    private static final Map<WeatherLocationConfig, CacheEntry> weatherCache = new LinkedHashMap();

    private CityManageRepo() {
    }

    public final void removeCity(WeatherLocationConfig config) {
        LocationConfigService locationConfigService;
        Intrinsics.checkNotNullParameter(config, "config");
        if (config.isManualLocMode() && (locationConfigService = LocationConfigServiceKt.locationConfigService()) != null) {
            locationConfigService.removeConfig(config);
        }
    }

    public final boolean swapCity(WeatherLocationConfig src, WeatherLocationConfig dst) {
        LocationConfigService locationConfigService;
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        if (src.isAutoLocMode() || dst.isAutoLocMode() || (locationConfigService = LocationConfigServiceKt.locationConfigService()) == null) {
            return false;
        }
        return locationConfigService.swapConfig(src, dst);
    }

    public static /* synthetic */ Observable getCityManageData$default(CityManageRepo cityManageRepo, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        return cityManageRepo.getCityManageData(z);
    }

    public final Observable<CityManageData> getCityManageData(boolean refreshLocation) {
        Observable<CityManageData> create = Observable.create(new CityManageRepo$$ExternalSyntheticLambda1(refreshLocation));
        Intrinsics.checkNotNullExpressionValue(create, "create { subscriber ->\n …viceNotFound())\n        }");
        return create;
    }

    /* access modifiers changed from: private */
    /* renamed from: getCityManageData$lambda-1  reason: not valid java name */
    public static final void m7570getCityManageData$lambda1(boolean $refreshLocation, Subscriber subscriber) {
        LocationConfigService $this$getCityManageData_u24lambda_u2d1_u24lambda_u2d0 = LocationConfigServiceKt.locationConfigService();
        if ($this$getCityManageData_u24lambda_u2d1_u24lambda_u2d0 != null) {
            $this$getCityManageData_u24lambda_u2d1_u24lambda_u2d0.getConfigData(new GetConfigParam($refreshLocation, false, 2, (DefaultConstructorMarker) null), new CityManageRepo$getCityManageData$1$1$1(subscriber));
        } else {
            subscriber.onError(WeatherException.serviceNotFound());
        }
    }

    /* access modifiers changed from: private */
    public final void loadFromCache(List<? extends WeatherLocationConfig> configs, Observer<? super CityManageData> observer) {
        CityManageData cityManageData = new CityManageData(configs);
        CityManageData $this$loadFromCache_u24lambda_u2d2 = cityManageData;
        $this$loadFromCache_u24lambda_u2d2.setWeathers(INSTANCE.weatherCacheOf(configs));
        $this$loadFromCache_u24lambda_u2d2.setSource(DataSource.CACHE);
        observer.onNext(cityManageData);
    }

    private final Map<WeatherLocationConfig, SummaryData> weatherCacheOf(List<? extends WeatherLocationConfig> configs) {
        Map linkedHashMap = new LinkedHashMap();
        Map $this$weatherCacheOf_u24lambda_u2d5 = linkedHashMap;
        for (WeatherLocationConfig it : configs) {
            CacheEntry $this$weatherCacheOf_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3 = weatherCache.get(it);
            if ($this$weatherCacheOf_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3 != null) {
                $this$weatherCacheOf_u24lambda_u2d5.put(it, $this$weatherCacheOf_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3.getData());
            }
        }
        return linkedHashMap;
    }

    /* access modifiers changed from: private */
    public final void loadFromServer(List<? extends WeatherLocationConfig> configs, Observer<? super CityManageData> observer) {
        Iterable<List> $this$map$iv = CollectionsKt.chunked(filterNeedRequest(configs), 5);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (List it : $this$map$iv) {
            destination$iv$iv.add(INSTANCE.serverSource(it));
        }
        List serverSources = (List) destination$iv$iv;
        if (serverSources.isEmpty()) {
            CityManageData cityManageData = new CityManageData(configs);
            CityManageData $this$loadFromServer_u24lambda_u2d7 = cityManageData;
            INSTANCE.putCacheInEmptySlot($this$loadFromServer_u24lambda_u2d7);
            $this$loadFromServer_u24lambda_u2d7.setSource(DataSource.SERVER);
            observer.onNext(cityManageData);
            observer.onCompleted();
            return;
        }
        Single.zip(serverSources, new CityManageRepo$$ExternalSyntheticLambda2(configs)).observeOn(AndroidSchedulers.mainThread()).subscribe(new CityManageRepo$$ExternalSyntheticLambda3(observer), new CityManageRepo$$ExternalSyntheticLambda4(observer));
    }

    /* access modifiers changed from: private */
    /* renamed from: loadFromServer$lambda-8  reason: not valid java name */
    public static final CityManageData m7572loadFromServer$lambda8(List $configs, Object[] results) {
        Intrinsics.checkNotNullParameter($configs, "$configs");
        CityManageRepo cityManageRepo = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(results, "results");
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : results) {
            if (element$iv$iv instanceof CityManageData) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return cityManageRepo.merge($configs, (List) destination$iv$iv);
    }

    /* access modifiers changed from: private */
    /* renamed from: loadFromServer$lambda-9  reason: not valid java name */
    public static final void m7573loadFromServer$lambda9(Observer $observer, CityManageData it) {
        Intrinsics.checkNotNullParameter($observer, "$observer");
        $observer.onNext(it);
        $observer.onCompleted();
    }

    /* access modifiers changed from: private */
    /* renamed from: loadFromServer$lambda-10  reason: not valid java name */
    public static final void m7571loadFromServer$lambda10(Observer $observer, Throwable it) {
        Intrinsics.checkNotNullParameter($observer, "$observer");
        $observer.onError(it);
    }

    private final CityManageData merge(List<? extends WeatherLocationConfig> configs, List<CityManageData> data) {
        CityManageData cityManageData = new CityManageData(configs);
        CityManageData $this$merge_u24lambda_u2d13 = cityManageData;
        Map linkedHashMap = new LinkedHashMap();
        Map $this$merge_u24lambda_u2d13_u24lambda_u2d12 = linkedHashMap;
        for (CityManageData it : data) {
            $this$merge_u24lambda_u2d13_u24lambda_u2d12.putAll(it.getWeathers());
        }
        $this$merge_u24lambda_u2d13.setWeathers(linkedHashMap);
        $this$merge_u24lambda_u2d13.setSource(DataSource.SERVER);
        INSTANCE.putCacheInEmptySlot($this$merge_u24lambda_u2d13);
        return cityManageData;
    }

    private final CityManageData putCacheInEmptySlot(CityManageData $this$putCacheInEmptySlot) {
        SummaryData it;
        Map cache = weatherCacheOf($this$putCacheInEmptySlot.getLocations());
        Map result = MapsKt.toMutableMap($this$putCacheInEmptySlot.getWeathers());
        for (WeatherLocationConfig loc : $this$putCacheInEmptySlot.getLocations()) {
            if (!result.containsKey(loc) && (it = cache.get(loc)) != null) {
                SummaryData put = result.put(loc, it);
            }
        }
        $this$putCacheInEmptySlot.setWeathers(result);
        return $this$putCacheInEmptySlot;
    }

    private final Single<CityManageData> serverSource(List<? extends WeatherLocationConfig> configs) {
        Single<CityManageData> create = Single.create(new CityManageRepo$$ExternalSyntheticLambda0(configs));
        Intrinsics.checkNotNullExpressionValue(create, "create { subscriber ->\n …\n            })\n        }");
        return create;
    }

    /* access modifiers changed from: private */
    /* renamed from: serverSource$lambda-16  reason: not valid java name */
    public static final void m7574serverSource$lambda16(List $configs, SingleSubscriber subscriber) {
        Intrinsics.checkNotNullParameter($configs, "$configs");
        CityManageRepoKt.createGetRequest(RequestConfigsKt.getWeatherBaseUrl(), INSTANCE.buildReqParams($configs)).executeAsyncOnUIBack(new CityManageRepo$serverSource$1$1($configs, subscriber));
    }

    private final Map<String, String> buildReqParams(List<? extends WeatherLocationConfig> configs) {
        Map linkedHashMap = new LinkedHashMap();
        Map $this$buildReqParams_u24lambda_u2d17 = linkedHashMap;
        $this$buildReqParams_u24lambda_u2d17.put("dsp", "iphone");
        $this$buildReqParams_u24lambda_u2d17.put("type", "multi");
        $this$buildReqParams_u24lambda_u2d17.put("tag", "baidu_weather_xcx");
        $this$buildReqParams_u24lambda_u2d17.put("source", "baidubox_na");
        String jSONArray = CityManageRepoKt.toJson(configs).toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray, "configs.toJson().toString()");
        $this$buildReqParams_u24lambda_u2d17.put("query", jSONArray);
        return linkedHashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0012 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<com.baidu.searchbox.weather.WeatherLocationConfig> filterNeedRequest(java.util.List<? extends com.baidu.searchbox.weather.WeatherLocationConfig> r19) {
        /*
            r18 = this;
            r0 = r19
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r1 = 0
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            r3 = r0
            r4 = 0
            java.util.Iterator r5 = r3.iterator()
        L_0x0012:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00b2
            java.lang.Object r6 = r5.next()
            r7 = r6
            com.baidu.searchbox.weather.WeatherLocationConfig r7 = (com.baidu.searchbox.weather.WeatherLocationConfig) r7
            r8 = 0
            java.lang.String r9 = r7.getCity()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r10 = 0
            r11 = 1
            if (r9 == 0) goto L_0x0033
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r9 = r10
            goto L_0x0034
        L_0x0033:
            r9 = r11
        L_0x0034:
            if (r9 != 0) goto L_0x006b
            java.lang.String r9 = r7.getCountry()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x0047
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r9 = r10
            goto L_0x0048
        L_0x0047:
            r9 = r11
        L_0x0048:
            if (r9 != 0) goto L_0x006b
            com.baidu.searchbox.weather.repo.CityManageRepo r9 = INSTANCE
            long r12 = r9.now()
            java.util.Map<com.baidu.searchbox.weather.WeatherLocationConfig, com.baidu.searchbox.weather.repo.CacheEntry> r9 = weatherCache
            java.lang.Object r9 = r9.get(r7)
            com.baidu.searchbox.weather.repo.CacheEntry r9 = (com.baidu.searchbox.weather.repo.CacheEntry) r9
            if (r9 == 0) goto L_0x005f
            long r14 = r9.getTime()
            goto L_0x0061
        L_0x005f:
            r14 = 0
        L_0x0061:
            long r12 = r12 - r14
            r14 = 300000(0x493e0, double:1.482197E-318)
            int r9 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r9 <= 0) goto L_0x006b
            r9 = r11
            goto L_0x006c
        L_0x006b:
            r9 = r10
        L_0x006c:
            boolean r12 = r7.isAutoLocMode()
            if (r12 == 0) goto L_0x00a9
            java.util.Map<com.baidu.searchbox.weather.WeatherLocationConfig, com.baidu.searchbox.weather.repo.CacheEntry> r12 = weatherCache
            java.util.Set r12 = r12.keySet()
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            r13 = 0
            java.util.Iterator r14 = r12.iterator()
        L_0x0080:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x0097
            java.lang.Object r15 = r14.next()
            r16 = r15
            com.baidu.searchbox.weather.WeatherLocationConfig r16 = (com.baidu.searchbox.weather.WeatherLocationConfig) r16
            r17 = 0
            boolean r16 = r16.isAutoLocMode()
            if (r16 == 0) goto L_0x0080
            goto L_0x0098
        L_0x0097:
            r15 = 0
        L_0x0098:
            r12 = r15
            com.baidu.searchbox.weather.WeatherLocationConfig r12 = (com.baidu.searchbox.weather.WeatherLocationConfig) r12
            if (r9 != 0) goto L_0x00a7
            com.baidu.searchbox.weather.repo.CityManageRepo r13 = INSTANCE
            boolean r13 = r13.isIdentical(r7, r12)
            if (r13 != 0) goto L_0x00a6
            goto L_0x00a7
        L_0x00a6:
            goto L_0x00aa
        L_0x00a7:
            r10 = r11
            goto L_0x00aa
        L_0x00a9:
            r10 = r9
        L_0x00aa:
            if (r10 == 0) goto L_0x0012
            r2.add(r6)
            goto L_0x0012
        L_0x00b2:
            java.util.List r2 = (java.util.List) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.weather.repo.CityManageRepo.filterNeedRequest(java.util.List):java.util.List");
    }

    private final boolean isIdentical(WeatherLocationConfig $this$isIdentical, WeatherLocationConfig other) {
        if (other == null || $this$isIdentical.isAutoLocMode() != other.isAutoLocMode()) {
            return false;
        }
        if (!$this$isIdentical.isAutoLocMode()) {
            return $this$isIdentical.equals(other);
        }
        if (!Intrinsics.areEqual((Object) $this$isIdentical.getCountry(), (Object) other.getCountry()) || !Intrinsics.areEqual((Object) $this$isIdentical.getCity(), (Object) other.getCity()) || !Intrinsics.areEqual((Object) $this$isIdentical.getDistrict(), (Object) other.getDistrict())) {
            return false;
        }
        LocationInfo myLoc = $this$isIdentical.getLocationInfo();
        LocationInfo otherLoc = $this$isIdentical.getLocationInfo();
        if (myLoc == null && otherLoc == null) {
            return true;
        }
        if (myLoc == null || otherLoc == null) {
            return false;
        }
        if (Intrinsics.areEqual((Object) myLoc, (Object) otherLoc) || (Intrinsics.areEqual((Object) myLoc.country, (Object) otherLoc.country) && Intrinsics.areEqual((Object) myLoc.province, (Object) otherLoc.province) && Intrinsics.areEqual((Object) myLoc.city, (Object) otherLoc.city) && Intrinsics.areEqual((Object) myLoc.district, (Object) otherLoc.district) && Intrinsics.areEqual((Object) myLoc.street, (Object) otherLoc.street) && Intrinsics.areEqual((Object) myLoc.town, (Object) otherLoc.town))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void addToCache(CityManageData data) {
        for (Map.Entry it : data.getWeathers().entrySet()) {
            if (((SummaryData) it.getValue()).safelyCacheable()) {
                if (((WeatherLocationConfig) it.getKey()).isAutoLocMode()) {
                    weatherCache.remove(it.getKey());
                }
                weatherCache.put(it.getKey(), new CacheEntry((SummaryData) it.getValue(), INSTANCE.now()));
            }
        }
    }

    private final long now() {
        return System.currentTimeMillis();
    }
}
