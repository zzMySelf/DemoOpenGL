package com.baidu.searchbox.imagesearch.host.entry;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.browser.BrowserType;
import com.baidu.launch.stats.LaunchStatsUtils;
import com.baidu.nps.stub.context.ContextHolderImpl;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.searchbox.imagesearch.ImageSearchManager;
import com.baidu.searchbox.imagesearch.common.common.ImageSearchABTestUtils;
import com.baidu.searchbox.imagesearch.common.common.ImageSearchCommonUtilsKt;
import com.baidu.searchbox.imagesearch.common.param.UnitedSchemeParams;
import com.baidu.searchbox.imagesearch.constants.ImageSearchConstantsCompat;
import com.baidu.searchbox.imagesearch.host.entry.ai.edit.IImageAIEditCallback;
import com.baidu.searchbox.imagesearch.host.entry.ai.edit.ImageAIEditParams;
import com.baidu.searchbox.imagesearch.host.entry.ai.edit.ImageAIEditRepository;
import com.baidu.searchbox.imagesearch.host.entry.base.ImageSearchBaseResult;
import com.baidu.searchbox.imagesearch.host.entry.bean.ImageSearchHistoryItem;
import com.baidu.searchbox.imagesearch.host.entry.callback.IImageSearchBaseCallback;
import com.baidu.searchbox.imagesearch.host.entry.callback.IImageSearchCacheSizeCallback;
import com.baidu.searchbox.imagesearch.host.entry.callback.IImageSearchClearCacheCallback;
import com.baidu.searchbox.imagesearch.host.entry.callback.IImageSearchDelHistoryCallback;
import com.baidu.searchbox.imagesearch.host.entry.callback.IImageSearchDirectRegCallback;
import com.baidu.searchbox.imagesearch.host.entry.callback.IImageSearchGetHistoryCallback;
import com.baidu.searchbox.imagesearch.host.entry.callback.IImageSearchGetSubCategoryCallback;
import com.baidu.searchbox.imagesearch.host.entry.callback.IImageSearchTextCallback;
import com.baidu.searchbox.imagesearch.host.entry.callback.IImageSearchUpdateHistoryCallback;
import com.baidu.searchbox.imagesearch.host.entry.constants.ImageSearchConstants;
import com.baidu.searchbox.imagesearch.host.entry.constants.ImageSearchIntentKeys;
import com.baidu.searchbox.imagesearch.host.entry.imagecall.ImageSearchCall;
import com.baidu.searchbox.imagesearch.host.entry.imagecall.ImageSearchCallFailureInfo;
import com.baidu.searchbox.imagesearch.host.entry.params.ChatSearchInvokeEntryParams;
import com.baidu.searchbox.imagesearch.host.entry.params.DelImageSearchHistoryParams;
import com.baidu.searchbox.imagesearch.host.entry.params.DiskCacheParams;
import com.baidu.searchbox.imagesearch.host.entry.params.GetImageSearchHistoryParams;
import com.baidu.searchbox.imagesearch.host.entry.params.GetSubCategoryParams;
import com.baidu.searchbox.imagesearch.host.entry.params.ImageSearchBaseParams;
import com.baidu.searchbox.imagesearch.host.entry.params.ImageSearchHalfScreenParams;
import com.baidu.searchbox.imagesearch.host.entry.params.ImageSearchLogParams;
import com.baidu.searchbox.imagesearch.host.entry.params.ImageSearchParams;
import com.baidu.searchbox.imagesearch.host.entry.params.ImageTextSearchParams;
import com.baidu.searchbox.imagesearch.host.entry.params.SwanInvokeParams;
import com.baidu.searchbox.imagesearch.host.entry.params.UpdateImageSearchHistoryParams;
import com.baidu.searchbox.imagesearch.host.entry.params.WordCommandInvokeParams;
import com.baidu.searchbox.imagesearch.host.entry.result.ClearCacheRealResult;
import com.baidu.searchbox.imagesearch.host.entry.result.DeleteHistoryRealResult;
import com.baidu.searchbox.imagesearch.host.entry.result.DirectRegImgRealResult;
import com.baidu.searchbox.imagesearch.host.entry.result.GetCacheSizeRealResult;
import com.baidu.searchbox.imagesearch.host.entry.result.GetHistoryRealResult;
import com.baidu.searchbox.imagesearch.host.entry.result.GetSubCategoryRealResult;
import com.baidu.searchbox.imagesearch.host.entry.result.ImageSearchRealResult;
import com.baidu.searchbox.imagesearch.host.entry.result.ImageSearchTextRealResult;
import com.baidu.searchbox.imagesearch.host.entry.result.UpdateHistoryRealResult;
import com.baidu.searchbox.imagesearch.host.entry.shortcut.ImageSearchShortCutManager;
import com.baidu.searchbox.imagesearch.host.entry.status.ImageSearchRealStatus;
import com.baidu.searchbox.imagesearch.host.entry.utils.ImageSearchUtils;
import com.baidu.searchbox.imagesearch.host.invoke.impl.ImageSearchPluginInvoker;
import com.baidu.searchbox.imagesearch.plugin.IImageSearchPlugin;
import com.baidu.searchbox.imagesearch.plugin.callback.ClearCacheCallback;
import com.baidu.searchbox.imagesearch.plugin.callback.DecodeBarcodeCallback;
import com.baidu.searchbox.imagesearch.plugin.callback.DirectRegImgCallback;
import com.baidu.searchbox.imagesearch.plugin.callback.GetCacheSizeCallback;
import com.baidu.searchbox.imagesearch.plugin.callback.GetSubCategoryCallback;
import com.baidu.searchbox.imagesearch.plugin.callback.ImageSearchCallback;
import com.baidu.searchbox.imagesearch.plugin.callback.ImageTextSearchCallback;
import com.baidu.searchbox.imagesearch.plugin.direct.ImageSearchDirect;
import com.baidu.searchbox.imagesearch.plugin.result.ClearCacheResult;
import com.baidu.searchbox.imagesearch.plugin.result.DecodeBarcodeResult;
import com.baidu.searchbox.imagesearch.plugin.result.DirectRegImgResult;
import com.baidu.searchbox.imagesearch.plugin.result.GetCacheSizeResult;
import com.baidu.searchbox.imagesearch.plugin.result.GetSubCategoryResult;
import com.baidu.searchbox.imagesearch.plugin.result.ImageSearchResult;
import com.baidu.searchbox.imagesearch.plugin.result.ImageTextSearchResult;
import com.baidu.searchbox.imagesearch.plugin.status.ImageSearchStatus;
import com.baidu.searchbox.imagesearch.plugin.status.ImageTextSearchStatus;
import com.baidu.searchbox.imagesearch.storage.IBarcodeDBManagerService;
import com.baidu.searchbox.imagesearch.storage.db.history.BarcodeHistoryModel;
import com.baidu.searchbox.imagesearch.storage.db.history.IBarcodeHistoryTableManager;
import com.baidu.searchbox.launch.IdleLaunchTask;
import com.baidu.searchbox.launch.SmartLaunchController;
import com.baidu.searchbox.search.pyramid.SearchBrowserInterface;
import com.baidu.searchbox.util.BaiduIdentityManager;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class ImageSearchInvokePluginHelper implements IImageSearchInvokePlugin {
    private static final String KEY_IMAGE_SEARCH_INVOKE_TIME = "key_image_search_invoke_time";
    private static final String TAG = "ImageSearchInvPlgImpl";

    public void imageSearchForSwan(Context context, SwanInvokeParams params, IImageSearchBaseCallback callback) {
        if (params != null) {
            Intent intent = new Intent();
            intent.setAction("com.baidu.searchbox.action.mini_app");
            intent.putExtra("category", params.extCategory);
            intent.putExtra("miniCustomData", params.miniCustomData);
            getImageSearchParams(intent);
            final Context context2 = context;
            final Intent intent2 = intent;
            final ImageSearchCallback createCallBack = ImageSearchUtils.createCallBack(callback);
            final IImageSearchBaseCallback iImageSearchBaseCallback = callback;
            ImageSearchUtils.invokeImageSearchCall(new ImageSearchCall() {
                public void onImageSearch(IImageSearchPlugin plugin) {
                    ImageSearchInvokePluginHelper.this.recodeInvokeImageSearchCameraTime();
                    plugin.imageSearch(context2, intent2, createCallBack);
                }

                public void onImageSearchFailure(ImageSearchCallFailureInfo info) {
                    if (iImageSearchBaseCallback != null) {
                        ImageSearchBaseResult imageSearchBaseResult = new ImageSearchBaseResult();
                        imageSearchBaseResult.setTransparentResult(ImageSearchCallFailureInfo.toJson(info));
                        iImageSearchBaseCallback.onResult(ImageSearchCallFailureInfo.infoToStatus(info), imageSearchBaseResult);
                    }
                }
            });
        }
    }

    public void imageSearchForLockScreen(Context context, Intent intent, IImageSearchBaseCallback callback) {
        getImageSearchParams(intent);
        final Context context2 = context;
        final Intent intent2 = intent;
        final ImageSearchCallback createCallBack = ImageSearchUtils.createCallBack(callback);
        final IImageSearchBaseCallback iImageSearchBaseCallback = callback;
        ImageSearchUtils.invokeImageSearchCall(new ImageSearchCall() {
            public void onImageSearch(IImageSearchPlugin plugin) {
                ImageSearchInvokePluginHelper.this.recodeInvokeImageSearchCameraTime();
                plugin.imageSearch(context2, intent2, createCallBack);
            }

            public void onImageSearchFailure(ImageSearchCallFailureInfo info) {
                IImageSearchBaseCallback iImageSearchBaseCallback = iImageSearchBaseCallback;
                if (iImageSearchBaseCallback != null) {
                    iImageSearchBaseCallback.onResult(-1, new ImageSearchBaseResult());
                }
            }
        });
    }

    public void imageSearchForQRCode(Context context, Intent intent, IImageSearchBaseCallback callback) {
        getImageSearchParams(intent);
        final Intent intent2 = intent;
        final Context context2 = context;
        final ImageSearchCallback createCallBack = ImageSearchUtils.createCallBack(callback);
        final IImageSearchBaseCallback iImageSearchBaseCallback = callback;
        ImageSearchUtils.invokeImageSearchCall(new ImageSearchCall() {
            public void onImageSearch(IImageSearchPlugin plugin) {
                String uriTransformed;
                String uri = intent2.getStringExtra("image_uri");
                if (!(uri == null || !uri.startsWith("content://com.google.android.apps.photos") || (uriTransformed = plugin.saveToImageSearchCache(context2, uri, "google_photo_cache.jpg")) == null)) {
                    intent2.putExtra("image_uri", uriTransformed);
                }
                ImageSearchInvokePluginHelper.this.recodeInvokeImageSearchCameraTime();
                plugin.imageSearch(context2, intent2, createCallBack);
            }

            public void onImageSearchFailure(ImageSearchCallFailureInfo info) {
                IImageSearchBaseCallback iImageSearchBaseCallback = iImageSearchBaseCallback;
                if (iImageSearchBaseCallback != null) {
                    iImageSearchBaseCallback.onResult(-1, new ImageSearchBaseResult());
                }
            }
        });
        String action = intent.getAction();
        if (!"com.baidu.searchbox.action.take_picture".equals(action) && !"com.baidu.searchbox.action.crop_picture".equals(action)) {
            addShortCut();
        }
    }

    public void decodeBarCodeForWordCommand(WordCommandInvokeParams params, final IImageSearchBaseCallback callback) {
        if (params != null) {
            final Intent intent = new Intent();
            intent.setData(params.pathUri);
            intent.putExtra("from", params.from);
            getImageSearchParams(intent);
            final DecodeBarcodeCallback decodeBarcodeCallback = createDecodeBarcodeCallback(callback);
            ImageSearchUtils.invokeImageSearchCall(new ImageSearchCall() {
                public void onImageSearch(IImageSearchPlugin plugin) {
                    plugin.decodeBarcode(intent, decodeBarcodeCallback);
                }

                public void onImageSearchFailure(ImageSearchCallFailureInfo info) {
                    IImageSearchBaseCallback iImageSearchBaseCallback = callback;
                    if (iImageSearchBaseCallback != null) {
                        iImageSearchBaseCallback.onResult(-1, new ImageSearchBaseResult());
                    }
                }
            });
        }
    }

    public void getImageSearchHistory(GetImageSearchHistoryParams params, IImageSearchGetHistoryCallback callback) {
        IImageSearchGetHistoryCallback iImageSearchGetHistoryCallback = callback;
        if (params != null && iImageSearchGetHistoryCallback != null) {
            int hisCount = params.getHisCount();
            if (hisCount <= 0) {
                iImageSearchGetHistoryCallback.onResult(0, new GetHistoryRealResult());
                return;
            }
            IBarcodeDBManagerService service = (IBarcodeDBManagerService) ServiceManager.getService(IBarcodeDBManagerService.SERVICE_REFERENCE);
            if (service == null) {
                iImageSearchGetHistoryCallback.onResult(0, new GetHistoryRealResult());
                return;
            }
            IBarcodeHistoryTableManager historyTableManager = service.getHistoryTableManager(ContextHolderImpl.getApplicationContext());
            List<BarcodeHistoryModel> models = historyTableManager.query("image_command not like ? ", new String[]{"%'face'%"}, hisCount, BarcodeHistoryModel.class);
            if (models != null) {
                List<ImageSearchHistoryItem> hisItems = new ArrayList<>();
                List<String> commands = new ArrayList<>();
                List<BarcodeHistoryModel> delModels = new ArrayList<>();
                for (BarcodeHistoryModel info : models) {
                    if (info != null) {
                        String key = info.getImageKeyPath() + "_" + info.getDisplayName();
                        if (commands.contains(key)) {
                            delModels.add(info);
                        } else {
                            hisItems.add(new ImageSearchHistoryItem(info.getId(), info.getType(), info.getSubType(), info.getContent(), info.getThumbUrl(true), info.getImageCommand(), info.getLastUpdateTime(), info.getDisplayName()));
                            commands.add(key);
                        }
                    }
                }
                commands.clear();
                if (delModels.size() > 0) {
                    historyTableManager.delete(delModels, false);
                }
                delModels.clear();
                GetHistoryRealResult realResult = new GetHistoryRealResult();
                realResult.setHistory(hisItems);
                iImageSearchGetHistoryCallback.onResult(0, realResult);
                return;
            }
            iImageSearchGetHistoryCallback.onResult(0, new GetHistoryRealResult());
        }
    }

    public void deleteImageSearchHistory(DelImageSearchHistoryParams params, IImageSearchDelHistoryCallback callback) {
        if (params != null) {
            boolean isDeleteAll = params.getIsDeleteAll();
            IBarcodeDBManagerService service = (IBarcodeDBManagerService) ServiceManager.getService(IBarcodeDBManagerService.SERVICE_REFERENCE);
            if (service == null) {
                callback.onResult(0, new DeleteHistoryRealResult());
                return;
            }
            IBarcodeHistoryTableManager historyTableManager = service.getHistoryTableManager(ContextHolderImpl.getApplicationContext());
            if (isDeleteAll) {
                historyTableManager.deleteAll(true);
            } else {
                historyTableManager.delete(params.getHisId(), true);
            }
            if (callback != null) {
                callback.onResult(0, new DeleteHistoryRealResult());
            }
        }
    }

    public void updateImgSearchHistory(UpdateImageSearchHistoryParams params, IImageSearchUpdateHistoryCallback callback) {
        if (params != null) {
            IBarcodeDBManagerService service = (IBarcodeDBManagerService) ServiceManager.getService(IBarcodeDBManagerService.SERVICE_REFERENCE);
            if (service == null) {
                callback.onResult(0, new UpdateHistoryRealResult());
                return;
            }
            IBarcodeHistoryTableManager historyTableManager = service.getHistoryTableManager(ContextHolderImpl.getApplicationContext());
            long id = params.getSuggestionId();
            List<BarcodeHistoryModel> models = historyTableManager.query("image_command not like ? ", new String[]{"%'face'%"}, 20, BarcodeHistoryModel.class);
            if (models != null) {
                Iterator<BarcodeHistoryModel> it = models.iterator();
                while (true) {
                    if (it.hasNext()) {
                        BarcodeHistoryModel model = it.next();
                        if (model != null && model.getId() == id) {
                            model.setLastUpdateTime(System.currentTimeMillis());
                            historyTableManager.update(model, true);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (callback != null) {
                callback.onResult(0, new UpdateHistoryRealResult());
            }
        }
    }

    public void imageBarcodeResult(ImageSearchParams params, final IImageSearchBaseCallback callback) {
        final Intent intent = new Intent();
        intent.putExtra("invokeAction", params.getInvokeAction());
        intent.putExtra("from", params.getFrom());
        intent.putExtra("result", params.getResult());
        intent.putExtra("referer", params.getReferer());
        getImageSearchParams(intent);
        ImageSearchUtils.invokeImageSearchCall(new ImageSearchCall() {
            public void onImageSearch(IImageSearchPlugin plugin) {
                plugin.viewBarcodeResult(intent);
            }

            public void onImageSearchFailure(ImageSearchCallFailureInfo info) {
                IImageSearchBaseCallback iImageSearchBaseCallback = callback;
                if (iImageSearchBaseCallback != null) {
                    iImageSearchBaseCallback.onResult(-1, (ImageSearchBaseResult) null);
                }
            }
        });
    }

    public void uploadImageSearchApiLog(ImageSearchLogParams params, final IImageSearchBaseCallback callback) {
        final Intent intent = new Intent();
        intent.putExtra("invokeAction", params.getInvokeAction());
        intent.putExtra("from", params.getFrom());
        intent.putExtra("result", params.getResult());
        intent.putExtra("referer", params.getReferer());
        intent.putExtra(ImageSearchIntentKeys.EXTRA_RESULT_SHOW_STATUS, params.getResultShowStatus());
        getImageSearchParams(intent);
        ImageSearchUtils.invokeImageSearchCall(new ImageSearchCall() {
            public void onImageSearch(IImageSearchPlugin plugin) {
                plugin.viewBarcodeResult(intent);
            }

            public void onImageSearchFailure(ImageSearchCallFailureInfo info) {
                IImageSearchBaseCallback iImageSearchBaseCallback = callback;
                if (iImageSearchBaseCallback != null) {
                    iImageSearchBaseCallback.onResult(-1, (ImageSearchBaseResult) null);
                }
            }
        });
    }

    public void directRecognizeImage(ImageSearchParams params, IImageSearchDirectRegCallback callback) {
        if (params != null) {
            final Intent intent = new Intent();
            intent.setData(params.getImagePathUri());
            intent.putExtra("category", params.getExtCategory());
            intent.putExtra("result", params.getResult());
            intent.putExtra("referer", params.getReferer());
            intent.putExtra("from", params.getFrom());
            getImageSearchParams(intent);
            final SoftReference<IImageSearchDirectRegCallback> callbackRef = new SoftReference<>(callback);
            ImageSearchUtils.invokeImageSearchCall(new ImageSearchCall() {
                public void onImageSearch(IImageSearchPlugin plugin) {
                    plugin.directRecognizeImage(intent, new DirectRegImgCallback() {
                        public void onResult(int resultCode, DirectRegImgResult result) {
                            IImageSearchDirectRegCallback directRegCallback = (IImageSearchDirectRegCallback) callbackRef.get();
                            if (directRegCallback != null) {
                                DirectRegImgRealResult baseResult = new DirectRegImgRealResult();
                                baseResult.setFrom(result.getFrom());
                                baseResult.setImageSearchId(result.getImageSearchId());
                                baseResult.setImgUri(result.getImgUri());
                                baseResult.setShowLogUploaded(result.getShowLogUploaded());
                                baseResult.setNeedShowLog(result.getNeedShowLog());
                                baseResult.setBarcodeResult(result.getBarcodeResult());
                                baseResult.setImageResult(result.getImageResult());
                                baseResult.setTransparentResult(result.getTransparentResult());
                                baseResult.setCategoryResult(result.getCategoryResult());
                                directRegCallback.onResult(resultCode, baseResult);
                            }
                        }
                    });
                }

                public void onImageSearchFailure(ImageSearchCallFailureInfo info) {
                    IImageSearchDirectRegCallback directRegCallback = (IImageSearchDirectRegCallback) callbackRef.get();
                    if (directRegCallback != null) {
                        directRegCallback.onResult(-1, (DirectRegImgRealResult) null);
                    }
                }
            });
        }
    }

    public void decodeBarcode(ImageSearchParams params, IImageSearchBaseCallback callback) {
    }

    public void imageTextSearch(ImageTextSearchParams params, IImageSearchTextCallback callback) {
        if (params != null) {
            final Intent intent = new Intent();
            intent.putExtra(ImageSearchIntentKeys.EXTRA_IMAGE_SEARCH_URL, params.getImageSearchResultUrl());
            intent.putExtra(ImageSearchIntentKeys.EXTRA_TEXT_SEARCH_VALUE, params.getTextSearchValue());
            intent.putExtra(ImageSearchIntentKeys.EXTRA_CANCEL_IMAGE_TEXT_SEARCH, params.isCancel());
            final SoftReference<IImageSearchTextCallback> callbackRef = new SoftReference<>(callback);
            ImageSearchUtils.invokeImageSearchCall(new ImageSearchCall() {
                public void onImageSearch(IImageSearchPlugin plugin) {
                    plugin.imageTextSearch(intent, new ImageTextSearchCallback() {
                        public void onResult(int resultCode, ImageTextSearchResult result) {
                            IImageSearchTextCallback textCallback = (IImageSearchTextCallback) callbackRef.get();
                            if (textCallback != null) {
                                ImageSearchTextRealResult realResult = new ImageSearchTextRealResult();
                                realResult.setBarcodeResult(result.getBarcodeResult());
                                realResult.setImageResult(result.getImageResult());
                                realResult.setTransparentResult(result.getTransparentResult());
                                textCallback.onResult(resultCode, realResult);
                            }
                        }

                        public void onStatusChanged(ImageTextSearchStatus status) {
                            IImageSearchTextCallback textCallback = (IImageSearchTextCallback) callbackRef.get();
                            if (textCallback != null) {
                                ImageSearchRealStatus realStatus = new ImageSearchRealStatus();
                                realStatus.setCurState(status.getCurState());
                                textCallback.onStatusChanged(realStatus);
                            }
                        }
                    });
                }

                public void onImageSearchFailure(ImageSearchCallFailureInfo info) {
                    IImageSearchTextCallback textCallback = (IImageSearchTextCallback) callbackRef.get();
                    if (textCallback != null) {
                        textCallback.onResult(-1, (ImageSearchTextRealResult) null);
                    }
                }
            });
        }
    }

    public void calculateCacheSize(DiskCacheParams params, IImageSearchCacheSizeCallback callback) {
        if (params != null) {
            final Intent intent = new Intent();
            intent.putExtra(ImageSearchIntentKeys.EXTRA_DISKCACHE_AUTO_CLEAN, params.isAutoClean());
            intent.putExtra(ImageSearchIntentKeys.EXTRA_DISKCACHE_ONLY_LENS, params.isOnlyLens());
            intent.putExtra(ImageSearchIntentKeys.EXTRA_DISKCACHE_CLEAN, params.isCleanOperation());
            intent.putExtra(ImageSearchIntentKeys.EXTRA_DISKCACHE_CALCULATE, params.isCalculateOperation());
            final SoftReference<IImageSearchCacheSizeCallback> callbackRef = new SoftReference<>(callback);
            ImageSearchUtils.invokeImageSearchCall(new ImageSearchCall() {
                public void onImageSearch(IImageSearchPlugin plugin) {
                    plugin.getCacheSize(intent, new GetCacheSizeCallback() {
                        public void onResult(int resultCode, GetCacheSizeResult result) {
                            IImageSearchCacheSizeCallback cacheSizeCallback = (IImageSearchCacheSizeCallback) callbackRef.get();
                            if (cacheSizeCallback != null) {
                                GetCacheSizeRealResult realResult = new GetCacheSizeRealResult();
                                realResult.cacheSize = result.getCacheSize();
                                cacheSizeCallback.onResult(resultCode, realResult);
                            }
                        }
                    });
                }

                public void onImageSearchFailure(ImageSearchCallFailureInfo info) {
                    IImageSearchCacheSizeCallback cacheSizeCallback = (IImageSearchCacheSizeCallback) callbackRef.get();
                    if (cacheSizeCallback != null) {
                        cacheSizeCallback.onResult(-1, new GetCacheSizeRealResult());
                    }
                }
            });
        }
    }

    public void clearCache(DiskCacheParams params, final IImageSearchClearCacheCallback callback) {
        if (params != null) {
            final Intent intent = new Intent();
            intent.putExtra(ImageSearchIntentKeys.EXTRA_DISKCACHE_AUTO_CLEAN, params.isAutoClean());
            intent.putExtra(ImageSearchIntentKeys.EXTRA_DISKCACHE_ONLY_LENS, params.isOnlyLens());
            intent.putExtra(ImageSearchIntentKeys.EXTRA_DISKCACHE_CLEAN, params.isCleanOperation());
            intent.putExtra(ImageSearchIntentKeys.EXTRA_DISKCACHE_CALCULATE, params.isCalculateOperation());
            ImageSearchUtils.invokeImageSearchCall(new ImageSearchCall() {
                public void onImageSearch(IImageSearchPlugin plugin) {
                    plugin.clearCache(intent, new ClearCacheCallback() {
                        public void onResult(int resultCode, ClearCacheResult result) {
                            if (callback != null) {
                                callback.onResult(resultCode, new ClearCacheRealResult());
                            }
                        }
                    });
                }

                public void onImageSearchFailure(ImageSearchCallFailureInfo info) {
                    IImageSearchClearCacheCallback iImageSearchClearCacheCallback = callback;
                    if (iImageSearchClearCacheCallback != null) {
                        iImageSearchClearCacheCallback.onResult(-1, (ClearCacheRealResult) null);
                    }
                }
            });
        }
    }

    public void imageSearch(ImageSearchBaseParams params, IImageSearchBaseCallback callback) {
    }

    public void openHalfScreenResult(final Context context, ImageSearchHalfScreenParams halfScreenParams) {
        if (halfScreenParams != null) {
            try {
                if (!ImageSearchABTestUtils.INSTANCE.getOpenHalfSwitch()) {
                    openBrowser(context, halfScreenParams);
                    return;
                }
                final Intent intent = new Intent();
                intent.setAction(ImageSearchConstants.ACTION_IMAGE_SEARCH_HALF_MODE);
                intent.putExtra("from", halfScreenParams.getFrom());
                intent.putExtra("imageSearch_type", halfScreenParams.getCategory().toUpperCase(Locale.US));
                intent.putExtra("imageSearch_mode", halfScreenParams.getCategory().toUpperCase(Locale.US));
                intent.putExtra(ImageSearchIntentKeys.EXTRA_HALF_SCREEN_URL, halfScreenParams.getHalfResultUrl());
                intent.putExtra(ImageSearchIntentKeys.EXTRA_HALF_SCREEN_HOME_BACK, halfScreenParams.getHomeBackVisible());
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("url", halfScreenParams.getImageUri());
                if (!TextUtils.isEmpty(halfScreenParams.getIntentCategory())) {
                    jsonObject.put("intent_category", halfScreenParams.getIntentCategory());
                }
                if (!TextUtils.isEmpty(halfScreenParams.getSceneCategory())) {
                    jsonObject.put("scene_category", halfScreenParams.getSceneCategory());
                }
                intent.putExtra("option", jsonObject.toString());
                getImageSearchParams(intent);
                ImageSearchUtils.invokeImageSearchCall(new ImageSearchCall() {
                    public void onImageSearch(IImageSearchPlugin plugin) {
                        plugin.imageSearch(context, intent, new ImageSearchCallback() {
                            public void onResult(int resultCode, ImageSearchResult result) {
                            }

                            public void onStatusChanged(ImageSearchStatus status) {
                            }

                            public void onDirect(ImageSearchDirect direct) {
                            }
                        });
                    }

                    public void onImageSearchFailure(ImageSearchCallFailureInfo info) {
                    }
                });
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public void handleUnitedScheme(final UnitedSchemeParams params, final IImageSearchBaseCallback callback) {
        ImageSearchUtils.invokeImageSearchCall(new ImageSearchCall() {
            public void onImageSearch(IImageSearchPlugin plugin) {
                if (plugin != null) {
                    plugin.handleUnitedScheme(params);
                }
                IImageSearchBaseCallback iImageSearchBaseCallback = callback;
                if (iImageSearchBaseCallback != null) {
                    iImageSearchBaseCallback.onResult(0, new ImageSearchBaseResult());
                }
            }

            public void onImageSearchFailure(ImageSearchCallFailureInfo info) {
                IImageSearchBaseCallback iImageSearchBaseCallback = callback;
                if (iImageSearchBaseCallback != null) {
                    iImageSearchBaseCallback.onResult(-1, new ImageSearchBaseResult());
                }
            }
        });
    }

    public void preparePluginBundle() {
        SmartLaunchController.register(new IdleLaunchTask() {
            public void execute() {
                ImageSearchPluginInvoker.getInstance().preparePluginBundle();
            }
        });
    }

    private void addShortCut() {
        ImageSearchShortCutManager.getInstance().addShortCut(AppRuntime.getAppContext());
    }

    private static void getImageSearchParams(Intent intent) {
        intent.putExtra("User-Agent", BaiduIdentityManager.getInstance(AppRuntime.getAppContext()).processUserAgent(ImageSearchCommonUtilsKt.getBdOriginUserAgent(), BrowserType.MAIN));
        if (!intent.hasExtra(ImageSearchConstantsCompat.GRAPH_INVOKE_TIMESTAMP)) {
            intent.putExtra(ImageSearchConstantsCompat.GRAPH_INVOKE_TIMESTAMP, System.currentTimeMillis());
        }
        if (!intent.hasExtra(ImageSearchConstantsCompat.GRAPH_PLUGIN_AVAILABLE_FLAG)) {
            intent.putExtra(ImageSearchConstantsCompat.GRAPH_PLUGIN_AVAILABLE_FLAG, ImageSearchPluginInvoker.getInstance().isAvailable());
        }
        intent.putExtra(ImageSearchConstantsCompat.APPLICATION_LAUNCH_TIMESTAMP, LaunchStatsUtils.getAppCreateTime());
        intent.putExtra(ImageSearchConstantsCompat.APPLICATION_LAUNCH_TYPE, LaunchStatsUtils.getLaunchTypeDetail());
        intent.putExtra(ImageSearchConstantsCompat.HOME_PAGE_RENDER_TIMESTAMP, LaunchStatsUtils.getHomePageFirstRenderEndTime());
    }

    public static DecodeBarcodeCallback createDecodeBarcodeCallback(final IImageSearchBaseCallback baseCallback) {
        if (baseCallback == null) {
            return null;
        }
        return new DecodeBarcodeCallback() {
            public void onResult(int resultCode, DecodeBarcodeResult decodeResult) {
                if (decodeResult != null) {
                    ImageSearchRealResult result = new ImageSearchRealResult();
                    result.setBarcodeResult(decodeResult.getBarcodeResult());
                    result.setTransparentResult(decodeResult.getTransparentResult());
                    result.setImageResult(decodeResult.getImageResult());
                    IImageSearchBaseCallback.this.onResult(resultCode, (ImageSearchBaseResult) result);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void recodeInvokeImageSearchCameraTime() {
        DefaultSharedPrefsWrapper.getInstance().putLong(KEY_IMAGE_SEARCH_INVOKE_TIME, System.currentTimeMillis());
    }

    private void openBrowser(Context context, ImageSearchHalfScreenParams halfScreenParams) {
        if (context != null && halfScreenParams != null) {
            Bundle extras = new Bundle();
            String url = ImageSearchManager.jointSearchImgUrl(halfScreenParams.getImageUri());
            String from = halfScreenParams.getFrom();
            boolean fromSwan = false;
            if (!TextUtils.isEmpty(from) && from.startsWith("swan")) {
                fromSwan = true;
            }
            extras.putBoolean("EXTRA_URL_FROM_HOME", false);
            extras.putString("key_url", url);
            extras.putBoolean("EXTRA_URL_NEW_WINDOW", true);
            extras.putBoolean("EXTRA_URL_FROM_SWAN", fromSwan);
            SearchBrowserInterface searchBrowser = (SearchBrowserInterface) ServiceManager.getService(SearchBrowserInterface.SERVICE_REFERENCE);
            if (searchBrowser != null) {
                searchBrowser.startBrowser(context, extras);
            }
        }
    }

    public String base64ToToken(final String imageBase64, final IImageSearchBaseCallback handleBase64ToTokenCallback) {
        ImageSearchUtils.invokeImageSearchCall(new ImageSearchCall() {
            public void onImageSearch(IImageSearchPlugin plugin) {
                if (plugin != null) {
                    String token = plugin.base64ToToken(imageBase64);
                    JSONObject tokenJson = new JSONObject();
                    try {
                        tokenJson.put("token", token);
                        ImageSearchBaseResult imageSearchBaseResult = new ImageSearchBaseResult();
                        imageSearchBaseResult.setTransparentResult(tokenJson.toString());
                        handleBase64ToTokenCallback.onResult(0, imageSearchBaseResult);
                    } catch (Exception e2) {
                        handleBase64ToTokenCallback.onResult(-1, new ImageSearchBaseResult());
                    }
                }
            }

            public void onImageSearchFailure(ImageSearchCallFailureInfo info) {
                handleBase64ToTokenCallback.onResult(-1, new ImageSearchBaseResult());
            }
        });
        return null;
    }

    public String uploadResizeImage(Context context, String uri, String scene, int maxLength, IImageSearchBaseCallback handleUploadResizeImage) {
        final Context context2 = context;
        final String str = uri;
        final String str2 = scene;
        final int i2 = maxLength;
        final ImageSearchCallback createCallBack = ImageSearchUtils.createCallBack(handleUploadResizeImage);
        final IImageSearchBaseCallback iImageSearchBaseCallback = handleUploadResizeImage;
        ImageSearchUtils.invokeImageSearchCall(new ImageSearchCall() {
            public void onImageSearch(IImageSearchPlugin plugin) {
                if (plugin != null) {
                    plugin.uploadResizeImage(context2, str, str2, i2, createCallBack);
                }
            }

            public void onImageSearchFailure(ImageSearchCallFailureInfo info) {
                iImageSearchBaseCallback.onResult(-1, new ImageSearchBaseResult());
            }
        });
        return null;
    }

    public boolean isPluginAvailable() {
        return ImageSearchPluginInvoker.getInstance().isAvailable();
    }

    public String getPluginActivityClassName() {
        return "com.baidu.searchbox.godeye.CodeScannerActivity";
    }

    public void openChatSearchCamera(final Context context, ChatSearchInvokeEntryParams param) {
        if (param != null) {
            final Intent intent = new Intent();
            intent.setAction(ImageSearchConstants.ACTION_CHAT_SEARCH_MODE);
            intent.putExtra("from", param.getInvokeSource());
            intent.putExtra(ImageSearchIntentKeys.EXTRA_IMAGESEARCH_TAKE_PHOTO_PATH, param.getTakePhotoFileDirPath());
            getImageSearchParams(intent);
            ImageSearchUtils.invokeImageSearchCall(new ImageSearchCall() {
                public void onImageSearch(IImageSearchPlugin plugin) {
                    ImageSearchInvokePluginHelper.this.recodeInvokeImageSearchCameraTime();
                    plugin.imageSearch(context, intent, new EmptyImageSearchCallback());
                }

                public void onImageSearchFailure(ImageSearchCallFailureInfo info) {
                }
            });
        }
    }

    public void openImageEditActivity(final Activity activity, final JSONObject object) {
        ImageSearchUtils.invokeImageSearchCall(new ImageSearchCall() {
            public void onImageSearch(IImageSearchPlugin plugin) {
                plugin.openImageEditActivity(activity, object);
            }

            public void onImageSearchFailure(ImageSearchCallFailureInfo info) {
            }
        });
    }

    public void launchForTakePicture(Activity activity, String source, IImageSearchBaseCallback callback) {
        if (activity != null) {
            Intent intent = new Intent();
            intent.setAction("com.baidu.searchbox.action.take_picture");
            if (!TextUtils.isEmpty(source)) {
                intent.putExtra("from", source);
            }
            imageSearchForQRCode(activity, intent, callback);
        }
    }

    public void launchForCropPicture(Activity activity, String source, Uri uri, String key, String url, boolean fixedAspectRatio, int aspectRatioX, int aspectRatioY, IImageSearchBaseCallback callback) {
        if (activity != null) {
            if (!TextUtils.isEmpty(key) || !TextUtils.isEmpty(url) || uri != null) {
                Intent intent = new Intent();
                intent.setAction("com.baidu.searchbox.action.crop_picture");
                if (!TextUtils.isEmpty(source)) {
                    intent.putExtra("from", source);
                }
                if (uri != null) {
                    intent.setData(uri);
                }
                if (!TextUtils.isEmpty(key)) {
                    intent.putExtra("key", key);
                }
                if (!TextUtils.isEmpty(url)) {
                    intent.putExtra("url", url);
                }
                intent.putExtra(ImageSearchIntentKeys.EXTRA_FIXED_ASPECT_RATIO, fixedAspectRatio);
                intent.putExtra(ImageSearchIntentKeys.EXTRA_ASPECT_RATIO_X, aspectRatioX);
                intent.putExtra(ImageSearchIntentKeys.EXTRA_ASPECT_RATIO_Y, aspectRatioY);
                imageSearchForQRCode(activity, intent, callback);
            }
        }
    }

    public void imageAIEdit(Context context, ImageAIEditParams params, IImageAIEditCallback callback) {
        new ImageAIEditRepository().imageAIEdit(context, params, callback);
    }

    public void getSubCategoryList(GetSubCategoryParams categoryParams, IImageSearchGetSubCategoryCallback callback) {
        if (categoryParams != null && !TextUtils.isEmpty(categoryParams.getCategoryType())) {
            final Intent intent = new Intent();
            intent.putExtra("imageSearch_type", categoryParams.getCategoryType());
            if (!TextUtils.isEmpty(categoryParams.getFrom())) {
                intent.putExtra("from", categoryParams.getFrom());
            }
            getImageSearchParams(intent);
            final SoftReference<IImageSearchGetSubCategoryCallback> callbackRef = new SoftReference<>(callback);
            ImageSearchUtils.invokeImageSearchCall(new ImageSearchCall() {
                public void onImageSearch(IImageSearchPlugin plugin) {
                    plugin.getSubCategoryList(intent, new GetSubCategoryCallback() {
                        public void onResult(int resultCode, GetSubCategoryResult result) {
                            if (callbackRef.get() != null && result != null) {
                                ((IImageSearchGetSubCategoryCallback) callbackRef.get()).onResult(resultCode, new GetSubCategoryRealResult(result.getCategoryType(), result.getCategoryName(), result.getSubCategoryList()));
                            }
                        }
                    });
                }

                public void onImageSearchFailure(ImageSearchCallFailureInfo info) {
                    if (callbackRef.get() != null) {
                        ((IImageSearchGetSubCategoryCallback) callbackRef.get()).onResult(-1, new GetSubCategoryRealResult());
                    }
                }
            });
        }
    }
}
