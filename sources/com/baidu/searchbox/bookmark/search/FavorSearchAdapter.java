package com.baidu.searchbox.bookmark.search;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.util.time.DateTimeUtil;
import com.baidu.searchbox.bookmark.BookmarkUBC;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.favor.R;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.favor.model.TplEnum;
import com.baidu.searchbox.favor.util.FavorExtraUtilsKt;
import com.baidu.searchbox.favor.util.FavorList;
import com.baidu.searchbox.userassetsaggr.container.template.ITemplate;
import com.baidu.searchbox.userassetsaggr.container.template.TemplateCreatorKt;
import com.baidu.searchbox.userassetsaggr.container.template.TemplateEnum;
import com.baidu.searchbox.userassetsaggr.container.template.TemplateEnumKt;
import com.baidu.searchbox.userassetsaggr.container.template.TemplateModel;
import java.util.HashMap;
import java.util.Map;

public class FavorSearchAdapter extends RecyclerView.Adapter<FavorHolder> {
    private Context mContext;
    private FavorList mData;
    private String mKeyWord;
    /* access modifiers changed from: private */
    public OnItemClickListener mListener;
    private Map<String, TemplateEnum> tplMapping = new HashMap(32);

    interface OnItemClickListener {
        void onItemClick(int i2, FavorModel favorModel, String str);

        void onItemLongClick(int i2, View view2, FavorModel favorModel, TemplateModel templateModel);
    }

    public FavorSearchAdapter(Context context, OnItemClickListener listener) {
        this.mContext = context;
        this.mListener = listener;
        initTplMappingRelation();
    }

    private void initTplMappingRelation() {
        this.tplMapping.put("common_text", TemplateEnum.COMMON_TEXT);
        this.tplMapping.put("common_image", TemplateEnum.COMMON_IMAGE);
        this.tplMapping.put("common_atlas", TemplateEnum.COMMON_ATLAS);
        this.tplMapping.put("common_video", TemplateEnum.COMMON_VIDEO);
        this.tplMapping.put("common_collection", TemplateEnum.COMMON_COLLECTION);
        this.tplMapping.put("common_live", TemplateEnum.COMMON_LIVE);
        this.tplMapping.put("common_audio", TemplateEnum.COMMON_AUDIO);
        this.tplMapping.put("common_ad", TemplateEnum.COMMON_AD);
        this.tplMapping.put("common_repost", TemplateEnum.COMMON_REPOST);
        this.tplMapping.put("common_product", TemplateEnum.COMMON_PRODUCT);
        this.tplMapping.put("common_swan", TemplateEnum.COMMON_SWAN);
        this.tplMapping.put("common_web", TemplateEnum.COMMON_WEB);
        this.tplMapping.put("common_qa_q", TemplateEnum.COMMON_QA_Q);
        this.tplMapping.put("common_wenku", TemplateEnum.COMMON_WENKU);
        this.tplMapping.put("feed_text", TemplateEnum.FEED_TEXT);
        this.tplMapping.put("feed_image", TemplateEnum.FEED_IMAGE);
        this.tplMapping.put("feed_atlas", TemplateEnum.FEED_ATLAS);
        this.tplMapping.put("feed_video", TemplateEnum.FEED_VIDEO);
        this.tplMapping.put("feed_minivideo", TemplateEnum.FEED_VIDEO);
        this.tplMapping.put("feed_live", TemplateEnum.FEED_LIVE);
        this.tplMapping.put("feed_collection", TemplateEnum.FEED_COLLECTION);
        this.tplMapping.put("feed_playlet", TemplateEnum.FEED_PLYLET);
        this.tplMapping.put(TplEnum.TPL_FEED_AUDIO, TemplateEnum.FEED_AUDIO);
        this.tplMapping.put("feed_ad", TemplateEnum.FEED_AD);
        this.tplMapping.put("activity_text", TemplateEnum.DYNAMIC_TEXT);
        this.tplMapping.put("activity_image", TemplateEnum.DYNAMIC_IMAGE);
        this.tplMapping.put("activity_atlas", TemplateEnum.DYNAMIC_ATLAS);
        this.tplMapping.put("activity_video", TemplateEnum.DYNAMIC_VIDEO);
        this.tplMapping.put("activity_repost", TemplateEnum.DYNAMIC_REPOST);
        this.tplMapping.put("mars_text", TemplateEnum.SWAN_TEXT);
        this.tplMapping.put("mars_image", TemplateEnum.SWAN_IMAGE);
        this.tplMapping.put("mars_atlas", TemplateEnum.SWAN_ATLAS);
        this.tplMapping.put("mars_video", TemplateEnum.SWAN_VIDEO);
        this.tplMapping.put("mars_live", TemplateEnum.SWAN_LIVE);
        this.tplMapping.put("mars_sale", TemplateEnum.SWAN_SALE);
        this.tplMapping.put("qa_question_text", TemplateEnum.QA_Q_TEXT);
        this.tplMapping.put("qa_answer_text", TemplateEnum.QA_A_TEXT);
        this.tplMapping.put("qa_question_image", TemplateEnum.QA_Q_IMAGE);
        this.tplMapping.put("search_text_name", TemplateEnum.SEARCH_TEXT);
        this.tplMapping.put("search_text_url", TemplateEnum.SEARCH_TEXT);
        this.tplMapping.put("search_web_film", TemplateEnum.WEB_FILM);
        this.tplMapping.put("search_video", TemplateEnum.FEED_VIDEO);
        this.tplMapping.put("search_minivideo", TemplateEnum.FEED_VIDEO);
        this.tplMapping.put("mercury_default", TemplateEnum.MGAME_DEFAULT);
        this.tplMapping.put("product", TemplateEnum.PRODUCT);
        this.tplMapping.put(TplEnum.TPL_SEARCH_VIDEO_COLLECTION, TemplateEnum.SEARCH_VIDEO_COLLECTION);
        this.tplMapping.put(TplEnum.TPL_SEARCH_VIDEO_PLAYLET, TemplateEnum.SEARCH_VIDEO_PLAYLET);
        this.tplMapping.put(TplEnum.TPL_WENKU_IMAGE, TemplateEnum.WENKU_IMAGE);
        this.tplMapping.put("search_web_video", TemplateEnum.COMMON_VIDEO);
    }

    public void setData(FavorList list, String keyWord) {
        this.mData = list;
        this.mKeyWord = keyWord;
        notifyDataSetChanged();
    }

    public FavorList getData() {
        return this.mData;
    }

    public int getItemCount() {
        FavorList favorList = this.mData;
        if (favorList == null) {
            return 0;
        }
        return favorList.size();
    }

    public FavorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FavorHolder(TemplateCreatorKt.createTemplate(TemplateEnumKt.valueOf(viewType)), parent);
    }

    public void onBindViewHolder(FavorHolder holder, final int position) {
        Context context;
        final FavorModel model = this.mData.get(position);
        if (model != null) {
            TemplateModel templateModel = new TemplateModel();
            templateModel.setFromPage("search_fav");
            if (TextUtils.isEmpty(model.title) && (context = this.mContext) != null) {
                model.title = context.getResources().getString(R.string.favor_tpl_title_empty);
            }
            templateModel.setTitle(model.title);
            templateModel.setUrl(model.url);
            templateModel.setTitleKeyWord(this.mKeyWord);
            templateModel.setImage(model.img);
            templateModel.setUkey(model.uKey);
            templateModel.setExtra1(model.extra1);
            templateModel.setItemPosition(Integer.valueOf(position + 1));
            if (model.feature != null) {
                templateModel.setOriginalTitle(model.feature.originalTitle);
                String tplId = model.tplId;
                if (!TextUtils.isEmpty(tplId)) {
                    char c2 = 65535;
                    switch (tplId.hashCode()) {
                        case -2072980645:
                            if (tplId.equals("activity_atlas")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case -2065811413:
                            if (tplId.equals("activity_image")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case -2053921973:
                            if (tplId.equals("activity_video")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case -1036149667:
                            if (tplId.equals("activity_text")) {
                                c2 = 0;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                            templateModel.setSource(model.feature.username);
                            break;
                        default:
                            templateModel.setSource(model.feature.source);
                            break;
                    }
                } else {
                    templateModel.setSource(model.feature.source);
                }
                templateModel.setOriginalSource(model.feature.originalSource);
                templateModel.setImageCount(model.feature.imagecount);
                templateModel.setPrice(model.feature.price);
                templateModel.setPortrait(model.feature.portrait);
                templateModel.setUserName(model.feature.username);
                templateModel.setUserDesc(model.feature.userdesc);
                templateModel.setVipIcon(model.feature.vipicon);
                templateModel.setShowGuarantee(model.feature.isShowGuarantee);
                templateModel.setShowFeedback(model.feature.isShowFeedback);
                if (!TextUtils.isEmpty(model.feature.duration)) {
                    templateModel.setDuration(DateTimeUtil.convertSecondToHumanView(model.feature.duration));
                    templateModel.setTotalTime(model.feature.duration);
                }
                if (model.feature.productInfo != null) {
                    templateModel.setPrice(model.feature.productInfo.price);
                    templateModel.setSimilarUrl(model.feature.productInfo.similar);
                    templateModel.setSaleTag(model.feature.productInfo.saleTag);
                    templateModel.setDiscountTag(model.feature.productInfo.discountTag);
                    templateModel.setSaleStatus(model.feature.productInfo.statusTag);
                }
                if (model.feature.shopInfo != null) {
                    templateModel.setShopName(model.feature.shopInfo.name);
                    templateModel.setShopUrl(model.feature.shopInfo.shop);
                }
                if (TextUtils.equals("1", model.feature.isDeadLink)) {
                    templateModel.setDeadLink(true);
                } else {
                    templateModel.setDeadLink(false);
                }
                if (model.feature.moviesModel != null) {
                    templateModel.setFavorMoviesModel(model.feature.moviesModel);
                }
            }
            if (AppConfig.isDebug()) {
                Log.d(FavorExtraUtilsKt.FAVOR_EXTRA_UTILS_TAG, String.format("isShowGuarantee is %b", new Object[]{Boolean.valueOf(templateModel.isShowGuarantee())}));
            }
            if (templateModel.isShowGuarantee()) {
                templateModel.setBaoInfo(FavorExtraUtilsKt.getBaoInfo(model.getExtData()));
            }
            holder.template.update(templateModel);
            favorItemShow(model);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (FavorSearchAdapter.this.mListener != null) {
                        FavorModel favorModel = model;
                        FavorSearchAdapter.this.mListener.onItemClick(position + 1, favorModel, favorModel.tplId);
                    }
                }
            });
            holder.itemView.setOnLongClickListener(new FavorSearchAdapter$$ExternalSyntheticLambda0(this, position, model, templateModel));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onBindViewHolder$0$com-baidu-searchbox-bookmark-search-FavorSearchAdapter  reason: not valid java name */
    public /* synthetic */ boolean m16673lambda$onBindViewHolder$0$combaidusearchboxbookmarksearchFavorSearchAdapter(int position, FavorModel model, TemplateModel templateModel, View v) {
        OnItemClickListener onItemClickListener = this.mListener;
        if (onItemClickListener == null) {
            return true;
        }
        onItemClickListener.onItemLongClick(position, v, model, templateModel);
        return true;
    }

    public int getItemViewType(int position) {
        FavorModel model = this.mData.get(position);
        if (model == null) {
            return TemplateEnum.FEED_TEXT.ordinal();
        }
        TemplateEnum template = this.tplMapping.get(model.tplId);
        if (template != null) {
            return template.ordinal();
        }
        return TemplateEnum.FEED_TEXT.ordinal();
    }

    private void favorItemShow(FavorModel item) {
        if (item != null && !BookmarkUBC.sHasReportUbcFavorItem.contains(item.uKey)) {
            BookmarkUBC.itemEvent(item.getExtData(), "show", "search_fav", "");
            BookmarkUBC.sHasReportUbcFavorItem.add(item.uKey);
        }
    }

    static class FavorHolder extends RecyclerView.ViewHolder {
        ITemplate template;

        FavorHolder(ITemplate template2, ViewGroup parent) {
            super(template2.createView(parent));
            this.template = template2;
        }
    }
}
