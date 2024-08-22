package com.baidu.searchbox.weather.repo;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.weather.ioc.IWeatherRenderStat;
import com.baidu.searchbox.weather.model.DataSource;
import com.baidu.searchbox.weather.model.WeatherModel;
import com.baidu.searchbox.weather.model.WeatherModelComposer;
import com.baidu.searchbox.weather.model.WeatherParser;
import com.baidu.searchbox.weather.repo.WeatherCache;
import com.baidu.searchbox.weather.util.DateUtil;
import com.baidu.searchbox.weather.util.WeatherAbUtilsKt;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Response;
import okhttp3.internal.http.HttpDate;
import org.json.JSONObject;
import rx.Observable;
import rx.Observer;
import rx.Single;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subjects.ReplaySubject;
import rx.subscriptions.CompositeSubscription;

public class WeatherRepository {
    private static final long CACHE_DURATION = 1080000;
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String TAG = "WeatherRepository";
    private static volatile WeatherRepository sInstance;
    private final Map<WeatherRequest, ReplaySubject<WeatherModel>> activePreloads = new HashMap();
    private final CompositeSubscription clearCacheSubscription = new CompositeSubscription();
    private boolean hasLocationPermission;
    private final Map<WeatherRequest, WeatherModel> memoryCache = new HashMap();

    private WeatherRepository() {
    }

    public static WeatherRepository getInstance() {
        if (sInstance == null) {
            synchronized (WeatherRepository.class) {
                if (sInstance == null) {
                    sInstance = new WeatherRepository();
                }
            }
        }
        return sInstance;
    }

    public boolean hasLocationPermission() {
        return this.hasLocationPermission;
    }

    public void setHasLocationPermission(boolean hasLocationPermission2) {
        this.hasLocationPermission = hasLocationPermission2;
    }

    public void preloadWeatherModel(WeatherRequest request) {
        ReplaySubject<WeatherModel> replay = ReplaySubject.create();
        this.activePreloads.put(request, replay);
        requestWeatherForecast(request, replay, true);
    }

    public Observable<WeatherModel> getWeatherModelAllowPreload(WeatherRequest request, boolean isEnableCache) {
        ReplaySubject<WeatherModel> observable = this.activePreloads.remove(request);
        if (observable != null) {
            if (DEBUG) {
                Log.i(TAG, "[preload hit]active=" + this.activePreloads.keySet() + "\n,request=" + request + ",enableCache=" + isEnableCache);
            }
            return observable;
        }
        if (DEBUG) {
            Log.i(TAG, "[preload miss]active=" + this.activePreloads.keySet() + "\n,request=" + request + ",enableCache=" + isEnableCache);
        }
        return getWeatherModel(request, isEnableCache);
    }

    public Observable<WeatherModel> getWeatherModel(final WeatherRequest request, final boolean isEnableCache) {
        this.clearCacheSubscription.clear();
        WeatherModel model = this.memoryCache.get(request);
        if (!isEnableCache || model == null) {
            return Observable.create(new Observable.OnSubscribe<WeatherModel>() {
                public void call(Subscriber<? super WeatherModel> subscriber) {
                    if (isEnableCache) {
                        WeatherRepository.this.loadFromWeatherCache(request, subscriber);
                    }
                    WeatherRepository.this.requestWeatherForecast(request, subscriber, false);
                }
            });
        }
        model.setDataSource(DataSource.CACHE);
        return Single.just(model).toObservable();
    }

    public void setMemoryCache(WeatherRequest request, WeatherModel model) {
        this.memoryCache.put(request, model);
    }

    public void clearMemoryCache() {
        this.memoryCache.clear();
    }

    /* access modifiers changed from: private */
    public void loadFromWeatherCache(final WeatherRequest request, final Observer<? super WeatherModel> observer) {
        ExecutorUtilsExt.postOnElastic(new Runnable() {
            public void run() {
                WeatherCache.Entry entry = WeatherCache.getInstance().queryCache(request);
                if (entry != null && !TextUtils.isEmpty(entry.data) && Math.abs(DateUtil.serverTimeMillis() - entry.timestamp) < WeatherRepository.CACHE_DURATION) {
                    try {
                        WeatherModel model = WeatherModelComposer.redressModel(WeatherParser.parse(new JSONObject(entry.data), entry.timestamp));
                        if (model != null) {
                            model.setDataSource(DataSource.CACHE);
                            observer.onNext(model);
                        }
                    } catch (Throwable t) {
                        if (WeatherRepository.DEBUG) {
                            t.printStackTrace();
                        }
                    }
                }
            }
        }, "QueryWeatherLandingDataFromCache", 1);
    }

    /* access modifiers changed from: private */
    public void saveWeatherToCache(WeatherRequest request, String data, long timestamp) {
        if (!TextUtils.isEmpty(data) && timestamp > 0) {
            final WeatherRequest weatherRequest = request;
            final String str = data;
            final long j2 = timestamp;
            ExecutorUtilsExt.postOnElastic(new Runnable() {
                public void run() {
                    WeatherCache.getInstance().saveCache(weatherRequest, str, j2);
                }
            }, "SaveWeatherLandingDataToCache", 3);
        }
    }

    /* access modifiers changed from: private */
    public void requestWeatherForecast(WeatherRequest request, Observer<? super WeatherModel> observer, boolean isPrefetch) {
        if (request.isUpdateTrace()) {
            IWeatherRenderStat.Companion.getImpl().updateStatistic("weather", "requestStart");
        }
        HttpRequest httpReq = request.toHttpRequest();
        if (DEBUG) {
            Log.d(TAG, "[requestWeatherForecast] request=" + httpReq.getOkRequest().toString());
        }
        final WeatherRequest weatherRequest = request;
        final HttpRequest httpRequest = httpReq;
        final boolean z = isPrefetch;
        final Observer<? super WeatherModel> observer2 = observer;
        httpReq.executeAsyncOnUIBack(new ResponseCallback<WeatherModel>() {
            public WeatherModel parseResponse(Response response, int i2) throws Exception {
                if (response == null || !response.isSuccessful() || response.body() == null) {
                    return null;
                }
                WeatherRepository.this.syncTime(response);
                String data = response.body().string();
                long timestamp = DateUtil.serverTimeMillis();
                WeatherModel model = WeatherModelComposer.redressModel(WeatherParser.parse(new JSONObject(data), timestamp));
                if (!(model == null || model.getRealtimeData() == null)) {
                    WeatherRepository.this.saveWeatherToCache(weatherRequest, data, timestamp);
                }
                return model;
            }

            public void onSuccess(WeatherModel model, int status) {
                WeatherRepository.this.statTraceId(weatherRequest, httpRequest);
                if (weatherRequest.isUpdateTrace()) {
                    IWeatherRenderStat.Companion.getImpl().updateStatistic("weather", "requestEnd");
                }
                model.setDataSource(z ? DataSource.PREFETCH : DataSource.SERVER);
                observer2.onNext(model);
                observer2.onCompleted();
            }

            public void onFail(Exception e2) {
                WeatherRepository.this.statTraceId(weatherRequest, httpRequest);
                if (weatherRequest.isUpdateTrace()) {
                    IWeatherRenderStat.Companion.getImpl().updateStatistic("weather", "requestEnd");
                }
                if (WeatherAbUtilsKt.getUseCacheOnNetErr()) {
                    WeatherModel model = WeatherRepository.this.getWeatherCache(weatherRequest);
                    if (model != null) {
                        observer2.onNext(model);
                        observer2.onCompleted();
                        return;
                    }
                    observer2.onError(e2);
                    return;
                }
                observer2.onError(e2);
            }
        });
    }

    /* access modifiers changed from: private */
    public WeatherModel getWeatherCache(WeatherRequest request) {
        WeatherCache.Entry entry = WeatherCache.getInstance().queryCache(request);
        if (entry == null || TextUtils.isEmpty(entry.data) || Math.abs(DateUtil.serverTimeMillis() - entry.timestamp) >= CACHE_DURATION) {
            return null;
        }
        try {
            WeatherModel model = WeatherModelComposer.redressModel(WeatherParser.parse(new JSONObject(entry.data), entry.timestamp));
            if (model != null) {
                model.setDataSource(DataSource.CACHE);
            }
            return model;
        } catch (Throwable t) {
            if (DEBUG) {
                t.printStackTrace();
            }
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void statTraceId(WeatherRequest weatherRequest, HttpRequest req) {
        try {
            Map<String, String> traceIdMap = new HashMap<>();
            traceIdMap.put("t1", req.getBdTraceId());
            if (weatherRequest.isUpdateTrace()) {
                IWeatherRenderStat.Companion.getImpl().updateStatistic("weather", "traceIds", new JSONObject(traceIdMap).toString());
            }
        } catch (Throwable t) {
            if (DEBUG) {
                t.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void syncTime(Response response) {
        Date date;
        try {
            String dateStr = response.header("Date");
            if (!TextUtils.isEmpty(dateStr) && (date = HttpDate.parse(dateStr)) != null && date.getTime() > 0) {
                DateUtil.setServerTime(date.getTime());
            }
        } catch (Throwable t) {
            if (DEBUG) {
                t.printStackTrace();
            }
        }
    }

    public void dispose() {
        clearMemoryCache();
        this.activePreloads.clear();
        this.clearCacheSubscription.clear();
        this.clearCacheSubscription.add(Single.just(1).delay(60, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).subscribe(new Action1<Integer>() {
            public void call(Integer integer) {
                WeatherCache.getInstance().close();
            }
        }, new Action1<Throwable>() {
            public void call(Throwable throwable) {
                WeatherCache.getInstance().close();
            }
        }));
    }
}
