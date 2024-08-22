package com.baidu.searchbox.video.feedflow.detail.followtag;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.feed.detail.arch.ext.CommonState;
import com.baidu.searchbox.feed.detail.arch.ext.NestedAction;
import com.baidu.searchbox.feed.detail.arch.ext.NetAction;
import com.baidu.searchbox.feed.detail.frame.AbsState;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.Reducer;
import com.baidu.searchbox.flowvideo.detail.repos.ExclusiveLabelModel;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailAuthorFollowInfoModel;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailAuthorModel;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailConfigModel;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel;
import com.baidu.searchbox.flowvideo.detail.repos.FlowDetailReminderInfoModel;
import com.baidu.searchbox.player.utils.BdPlayerUtils;
import com.baidu.searchbox.video.detail.business.VideoBizUtilsKt;
import com.baidu.searchbox.video.feedflow.config.AbConfig;
import com.baidu.searchbox.video.feedflow.detail.author.AuthorAction;
import com.baidu.searchbox.video.feedflow.detail.followguide.FollowGuideTextResponse;
import com.baidu.searchbox.video.feedflow.detail.intelligentrecommend.IntelligentRecommendEntranceHiddenAction;
import com.baidu.searchbox.video.feedflow.detail.intelligentrecommend.IntelligentRecommendEntranceShowAction;
import com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerError;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerStart;
import com.baidu.searchbox.video.feedflow.detail.videopk.VideoPkAction;
import com.baidu.searchbox.video.feedflow.flow.flowstyle.LandscapeFlowSwitchKt;
import com.baidu.searchbox.video.feedflow.flow.list.ItemModel;
import com.baidu.searchbox.video.feedflow.flow.list.ItemTypeManifestKt;
import com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus;
import com.baidu.searchbox.video.feedflow.flow.list.VideoItemModel;
import com.baidu.searchbox.video.feedflow.tab.FlowTabState;
import com.baidu.searchbox.video.feedflow.ubc.UBC6150;
import com.baidu.searchbox.video.feedflow.ubc.UBCManifestKt;
import com.baidu.searchbox.video.feedflow.ubc.VideoFlowUBCHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001c\u0010\u000b\u001a\u00020\u00052\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/followtag/FollowTagReducer;", "Lcom/baidu/searchbox/feed/detail/frame/Reducer;", "Lcom/baidu/searchbox/feed/detail/arch/ext/CommonState;", "()V", "initFollowedAndFollowGuideTagVisibleControl", "", "state", "bean", "Lcom/baidu/searchbox/flowvideo/detail/repos/FlowDetailModel;", "isAttentionTab", "", "onSuccess", "action", "Lcom/baidu/searchbox/feed/detail/arch/ext/NetAction$Success;", "reduce", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FollowTagReducer.kt */
public class FollowTagReducer implements Reducer<CommonState> {
    public CommonState reduce(CommonState state, Action action) {
        FollowTagState $this$reduce_u24lambda_u2d10;
        FollowTagState $this$reduce_u24lambda_u2d9;
        CommonState commonState = state;
        Action action2 = action;
        Intrinsics.checkNotNullParameter(commonState, "state");
        Intrinsics.checkNotNullParameter(action2, "action");
        if (action2 instanceof NetAction.Success) {
            onSuccess((NetAction.Success) action2, commonState);
        } else {
            MutableLiveData<Boolean> mutableLiveData = null;
            boolean z = false;
            boolean followTag = true;
            if (action2 instanceof AuthorAction.OnFollowStateChangedAction) {
                FollowTagState $this$reduce_u24lambda_u2d0 = (FollowTagState) commonState.select(FollowTagState.class);
                if ($this$reduce_u24lambda_u2d0 != null) {
                    boolean newFollowStatus = ((AuthorAction.OnFollowStateChangedAction) action2).isFollow() && !isAttentionTab(state);
                    if (Intrinsics.areEqual((Object) $this$reduce_u24lambda_u2d0.getShowFollowedTag().getValue(), (Object) false) && newFollowStatus && $this$reduce_u24lambda_u2d0.isBottomBarGuideLinkTagShowing()) {
                        ItemModel itemModel = (ItemModel) state.select(ItemModel.class);
                        RunTimeStatus runTimeStatus = itemModel != null ? itemModel.getRunTimeStatus() : null;
                        if (runTimeStatus != null) {
                            runTimeStatus.setHasShowBottomBarGuideLinkTag(true);
                        }
                    }
                    FollowTagState followTagState = (FollowTagState) commonState.select(FollowTagState.class);
                    if (followTagState != null) {
                        mutableLiveData = followTagState.getShowFollowedTag();
                    }
                    if (mutableLiveData != null) {
                        if (newFollowStatus) {
                            FollowTagState followTagState2 = (FollowTagState) state.select(FollowTagState.class);
                            if (!(followTagState2 != null && followTagState2.isFlowVideoGrType())) {
                                z = true;
                            }
                        }
                        mutableLiveData.setValue(Boolean.valueOf(z));
                    }
                }
            } else if (action2 instanceof AuthorAction.OnFollowDataBindAction) {
                FollowTagState $this$reduce_u24lambda_u2d1 = (FollowTagState) state.select(FollowTagState.class);
                if ($this$reduce_u24lambda_u2d1 != null) {
                    if (!((AuthorAction.OnFollowDataBindAction) action2).isFollow() || isAttentionTab(state) || $this$reduce_u24lambda_u2d1.isFlowVideoGrType()) {
                        followTag = false;
                    }
                    if (followTag) {
                        $this$reduce_u24lambda_u2d1.setRelatedTagShowing(false);
                    }
                    MutableLiveData<Boolean> showFollowedTag = $this$reduce_u24lambda_u2d1.getShowFollowedTag();
                    if (showFollowedTag != null) {
                        showFollowedTag.setValue(Boolean.valueOf(followTag));
                    }
                }
            } else if (action2 instanceof NestedAction.OnBindData) {
                FollowTagState $this$reduce_u24lambda_u2d2 = (FollowTagState) commonState.select(FollowTagState.class);
                if ($this$reduce_u24lambda_u2d2 != null) {
                    $this$reduce_u24lambda_u2d2.reset();
                }
            } else if (action2 instanceof InvokeFollowTagVisibilityChangeAction) {
                FollowTagState $this$reduce_u24lambda_u2d3 = (FollowTagState) state.select(FollowTagState.class);
                if ($this$reduce_u24lambda_u2d3 != null) {
                    $this$reduce_u24lambda_u2d3.changeVisible(((InvokeFollowTagVisibilityChangeAction) action2).isVisible(), ((InvokeFollowTagVisibilityChangeAction) action2).getNeedAnim());
                }
            } else if (action2 instanceof LongPressSpeedAnim) {
                FollowTagState $this$reduce_u24lambda_u2d4 = (FollowTagState) commonState.select(FollowTagState.class);
                if ($this$reduce_u24lambda_u2d4 != null) {
                    if (((LongPressSpeedAnim) action2).isStart()) {
                        $this$reduce_u24lambda_u2d4.changeVisible(false, true);
                    } else if (!((LongPressSpeedAnim) action2).isStart()) {
                        $this$reduce_u24lambda_u2d4.changeVisible(true, true);
                    }
                }
            } else if (action2 instanceof PlayerError) {
                FollowTagState followTagState3 = (FollowTagState) commonState.select(FollowTagState.class);
                if (followTagState3 != null) {
                    FollowTagState.changeVisible$default(followTagState3, false, false, 2, (Object) null);
                }
            } else if (action2 instanceof PlayerStart) {
                FollowTagState $this$reduce_u24lambda_u2d5 = (FollowTagState) commonState.select(FollowTagState.class);
                if ($this$reduce_u24lambda_u2d5 != null && ((PlayerStart) action2).isFromError() && !LandscapeFlowSwitchKt.isLandscapeFlowMode((AbsState) commonState) && $this$reduce_u24lambda_u2d5.getShowFollowedTag().getValue() != null) {
                    FollowTagState.changeVisible$default($this$reduce_u24lambda_u2d5, true, false, 2, (Object) null);
                }
            } else if (action2 instanceof FollowGuideTextResponse) {
                FollowTagState $this$reduce_u24lambda_u2d6 = (FollowTagState) state.select(FollowTagState.class);
                if ($this$reduce_u24lambda_u2d6 != null) {
                    if (((FollowGuideTextResponse) action2).getModel() != null) {
                        $this$reduce_u24lambda_u2d6.setGuideModel(((FollowGuideTextResponse) action2).getModel());
                    }
                    $this$reduce_u24lambda_u2d6.setFollowGuideVisible(((FollowGuideTextResponse) action2).isVisible());
                }
            } else if (action2 instanceof OnRecommendTagVisibleChange) {
                FollowTagState followTagState4 = (FollowTagState) state.select(FollowTagState.class);
                if (followTagState4 != null) {
                    followTagState4.setShowingRecommend(((OnRecommendTagVisibleChange) action2).isVisible());
                }
            } else if (action2 instanceof OnRecommendReasonTagVisibleChange) {
                FollowTagState followTagState5 = (FollowTagState) state.select(FollowTagState.class);
                if (followTagState5 != null) {
                    followTagState5.setShowingRecommendReasonTag(((OnRecommendReasonTagVisibleChange) action2).isVisible());
                }
            } else if (action2 instanceof OnFollowUpdateShow) {
                VideoFlowUBCHelper.uploadPageElementUbc$default(VideoFlowUBCHelper.INSTANCE, commonState, "show", UBC6150.Value.VALUR_UPDATE_AUTHORS, (String) null, (String) null, (String) null, (JSONObject) null, (ItemModel) null, false, UBCManifestKt.UBC_ID_6151, 504, (Object) null);
            } else if (action2 instanceof OnFollowUpdateClicked) {
                VideoFlowUBCHelper.uploadPageElementUbc$default(VideoFlowUBCHelper.INSTANCE, commonState, "click", UBC6150.Value.VALUR_UPDATE_AUTHORS, (String) null, (String) null, (String) null, (JSONObject) null, (ItemModel) null, false, UBCManifestKt.UBC_ID_6150, 504, (Object) null);
            } else if (action2 instanceof VideoPkAction.OnVideoPkShownAction) {
                FollowTagState $this$reduce_u24lambda_u2d7 = (FollowTagState) state.select(FollowTagState.class);
                if ($this$reduce_u24lambda_u2d7 != null) {
                    $this$reduce_u24lambda_u2d7.changeVisible(false, true);
                }
            } else if (action2 instanceof VideoPkAction.OnVideoPkHiddenAction) {
                FollowTagState $this$reduce_u24lambda_u2d8 = (FollowTagState) state.select(FollowTagState.class);
                if ($this$reduce_u24lambda_u2d8 != null) {
                    $this$reduce_u24lambda_u2d8.changeVisible(true, true);
                }
            } else if (action2 instanceof IntelligentRecommendEntranceShowAction) {
                if (!((IntelligentRecommendEntranceShowAction) action2).isBottom() && ($this$reduce_u24lambda_u2d9 = (FollowTagState) state.select(FollowTagState.class)) != null) {
                    $this$reduce_u24lambda_u2d9.changeVisible(false, true);
                }
            } else if ((action2 instanceof IntelligentRecommendEntranceHiddenAction) && !((IntelligentRecommendEntranceHiddenAction) action2).isBottom() && ($this$reduce_u24lambda_u2d10 = (FollowTagState) state.select(FollowTagState.class)) != null) {
                $this$reduce_u24lambda_u2d10.changeVisible(true, true);
            }
        }
        return commonState;
    }

    private final boolean isAttentionTab(CommonState state) {
        FlowTabState flowTabState = (FlowTabState) state.select(FlowTabState.class);
        return flowTabState != null && flowTabState.isAttentionTab();
    }

    /* access modifiers changed from: protected */
    public void onSuccess(NetAction.Success<?> action, CommonState state) {
        FollowTagState followTagState;
        FollowTagState $this$onSuccess_u24lambda_u2d12_u24lambda_u2d11;
        FlowDetailAuthorFollowInfoModel followInfo;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(state, "state");
        Object data = action.getData();
        FlowDetailReminderInfoModel flowDetailReminderInfoModel = null;
        FlowDetailModel bean = data instanceof FlowDetailModel ? (FlowDetailModel) data : null;
        if (!(bean == null || ($this$onSuccess_u24lambda_u2d12_u24lambda_u2d11 = (FollowTagState) state.select(FollowTagState.class)) == null)) {
            AbConfig abConfig = (AbConfig) state.select(AbConfig.class);
            boolean z = false;
            if (abConfig != null && abConfig.isSimilarCollectionEnable()) {
                ItemModel itemModel = (ItemModel) state.select(ItemModel.class);
                if (BdPlayerUtils.orFalse(itemModel != null ? Boolean.valueOf(ItemTypeManifestKt.isSimilarCollectionItem((ItemModel<?>) itemModel)) : null) && !bean.isOffLineVideo()) {
                    $this$onSuccess_u24lambda_u2d12_u24lambda_u2d11.getTagContent().setValue(bean.getTagContent());
                }
            }
            MutableLiveData<String> bottomBarGuideLinkTag = $this$onSuccess_u24lambda_u2d12_u24lambda_u2d11.getBottomBarGuideLinkTag();
            ItemModel itemModel2 = (ItemModel) state.select(ItemModel.class);
            Object data2 = itemModel2 != null ? itemModel2.getData() : null;
            VideoItemModel videoItemModel = data2 instanceof VideoItemModel ? (VideoItemModel) data2 : null;
            bottomBarGuideLinkTag.setValue(videoItemModel != null ? videoItemModel.getBottomBarGuideLinkTag() : null);
            ItemModel itemModel3 = (ItemModel) state.select(ItemModel.class);
            Object data3 = itemModel3 != null ? itemModel3.getData() : null;
            VideoItemModel videoItemModel2 = data3 instanceof VideoItemModel ? (VideoItemModel) data3 : null;
            $this$onSuccess_u24lambda_u2d12_u24lambda_u2d11.setFlowVideoGrType(videoItemModel2 != null && videoItemModel2.getFlowVideoGrType() == 1);
            MutableLiveData<Boolean> hasExclusiveTag = $this$onSuccess_u24lambda_u2d12_u24lambda_u2d11.getHasExclusiveTag();
            ExclusiveLabelModel exclusiveLabel = bean.getExclusiveLabel();
            CharSequence title = exclusiveLabel != null ? exclusiveLabel.getTitle() : null;
            hasExclusiveTag.setValue(Boolean.valueOf(!(title == null || StringsKt.isBlank(title)) && !bean.isOffLineVideo()));
            FlowDetailAuthorModel author = bean.getAuthor();
            if (!BdPlayerUtils.orFalse((author == null || (followInfo = author.getFollowInfo()) == null) ? null : Boolean.valueOf(followInfo.isFollow()))) {
                ItemModel itemModel4 = (ItemModel) state.select(ItemModel.class);
                if (!(itemModel4 != null && ItemTypeManifestKt.isSimilarCollectionItem((ItemModel<?>) itemModel4))) {
                    $this$onSuccess_u24lambda_u2d12_u24lambda_u2d11.getTagContent().setValue(bean.getTagContent());
                }
            }
            initFollowedAndFollowGuideTagVisibleControl(state, bean);
            $this$onSuccess_u24lambda_u2d12_u24lambda_u2d11.setReminderInfoModel(bean.getReminderInfo());
            if (VideoBizUtilsKt.isFromHotFlow(UBCManifestKt.getPage(state))) {
                FlowDetailConfigModel conf = bean.getConf();
                CharSequence recommendReason = conf != null ? conf.getRecommendReason() : null;
                if (recommendReason == null || recommendReason.length() == 0) {
                    z = true;
                }
                $this$onSuccess_u24lambda_u2d12_u24lambda_u2d11.setShowingRecommendReasonTag(!z);
                FlowDetailConfigModel conf2 = bean.getConf();
                $this$onSuccess_u24lambda_u2d12_u24lambda_u2d11.setRecommendReasonTag(conf2 != null ? conf2.getRecommendReason() : null);
            } else {
                $this$onSuccess_u24lambda_u2d12_u24lambda_u2d11.setShowingRecommendReasonTag(false);
            }
        }
        FollowTagState followTagState2 = (FollowTagState) state.select(FollowTagState.class);
        if (followTagState2 != null) {
            flowDetailReminderInfoModel = followTagState2.getFollowUpdateModel();
        }
        if (flowDetailReminderInfoModel != null && (followTagState = (FollowTagState) state.select(FollowTagState.class)) != null) {
            followTagState.setCanShowFollowUpdate(true);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r0 = r0.getLabelMountPolicy();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ad, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) (r9 == null || (r9 = r9.getLabelMountPolicy()) == null) ? null : r9.getBannerLabelExclusionSwitch(), (java.lang.Object) "1") != false) goto L_0x00af;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initFollowedAndFollowGuideTagVisibleControl(com.baidu.searchbox.feed.detail.arch.ext.CommonState r12, com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel r13) {
        /*
            r11 = this;
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailConfigModel r0 = r13.getConf()
            r1 = 0
            if (r0 == 0) goto L_0x0012
            com.baidu.searchbox.flowvideo.detail.repos.LabelMountPolicyModel r0 = r0.getLabelMountPolicy()
            if (r0 == 0) goto L_0x0012
            com.baidu.searchbox.flowvideo.detail.repos.LabelMountPolicyFollowModel r0 = r0.getFollowRelated()
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            r2 = 0
            r3 = r12
            r4 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.detail.followtag.FollowTagState> r5 = com.baidu.searchbox.video.feedflow.detail.followtag.FollowTagState.class
            java.lang.Object r3 = r3.select(r5)
            com.baidu.searchbox.video.feedflow.detail.followtag.FollowTagState r3 = (com.baidu.searchbox.video.feedflow.detail.followtag.FollowTagState) r3
            if (r3 == 0) goto L_0x00db
            r4 = 0
            if (r0 == 0) goto L_0x0028
            java.lang.String r5 = r0.getPolicyType()
            goto L_0x0029
        L_0x0028:
            r5 = r1
        L_0x0029:
            java.lang.String r6 = "1"
            r7 = 0
            r8 = 1
            if (r5 == 0) goto L_0x0077
            int r9 = r5.hashCode()
            switch(r9) {
                case 48: goto L_0x0069;
                case 49: goto L_0x005d;
                case 50: goto L_0x0037;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0077
        L_0x0037:
            java.lang.String r9 = "2"
            boolean r5 = r5.equals(r9)
            if (r5 != 0) goto L_0x0040
            goto L_0x0077
        L_0x0040:
            r3.setDisableFollowedTag(r8)
            kotlin.ranges.IntRange r5 = new kotlin.ranges.IntRange
            r9 = 100
            r5.<init>(r8, r9)
            kotlin.random.Random$Default r9 = kotlin.random.Random.Default
            kotlin.random.Random r9 = (kotlin.random.Random) r9
            int r5 = kotlin.ranges.RangesKt.random((kotlin.ranges.IntRange) r5, (kotlin.random.Random) r9)
            int r9 = r0.getRecomTagShowFrequency()
            if (r5 <= r9) goto L_0x005a
            r5 = r8
            goto L_0x005b
        L_0x005a:
            r5 = r7
        L_0x005b:
            r2 = r5
            goto L_0x007b
        L_0x005d:
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x0064
            goto L_0x0077
        L_0x0064:
            r3.setDisableFollowedTag(r7)
            r2 = 1
            goto L_0x007b
        L_0x0069:
            java.lang.String r9 = "0"
            boolean r5 = r5.equals(r9)
            if (r5 != 0) goto L_0x0072
            goto L_0x0077
        L_0x0072:
            r3.setDisableFollowedTag(r8)
            r2 = 1
            goto L_0x007b
        L_0x0077:
            r3.setDisableFollowedTag(r7)
            r2 = 0
        L_0x007b:
            r5 = r12
            r9 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r10 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r5 = r5.select(r10)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r5 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r5
            if (r5 == 0) goto L_0x0092
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r5 = r5.getRunTimeStatus()
            if (r5 == 0) goto L_0x0092
            java.lang.Boolean r5 = r5.isDisableFollowGuideTag()
            goto L_0x0093
        L_0x0092:
            r5 = r1
        L_0x0093:
            if (r5 != 0) goto L_0x00d2
            if (r2 != 0) goto L_0x00af
            com.baidu.searchbox.flowvideo.detail.repos.FlowDetailConfigModel r9 = r13.getConf()
            if (r9 == 0) goto L_0x00a8
            com.baidu.searchbox.flowvideo.detail.repos.LabelMountPolicyModel r9 = r9.getLabelMountPolicy()
            if (r9 == 0) goto L_0x00a8
            java.lang.String r9 = r9.getBannerLabelExclusionSwitch()
            goto L_0x00a9
        L_0x00a8:
            r9 = r1
        L_0x00a9:
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r6)
            if (r6 == 0) goto L_0x00b0
        L_0x00af:
            r7 = r8
        L_0x00b0:
            r3.setDisableFollowGuideTag(r7)
            r6 = r12
            r7 = 0
            java.lang.Class<com.baidu.searchbox.video.feedflow.flow.list.ItemModel> r8 = com.baidu.searchbox.video.feedflow.flow.list.ItemModel.class
            java.lang.Object r6 = r6.select(r8)
            com.baidu.searchbox.video.feedflow.flow.list.ItemModel r6 = (com.baidu.searchbox.video.feedflow.flow.list.ItemModel) r6
            if (r6 == 0) goto L_0x00c3
            com.baidu.searchbox.video.feedflow.flow.list.RunTimeStatus r1 = r6.getRunTimeStatus()
        L_0x00c3:
            if (r1 != 0) goto L_0x00c6
            goto L_0x00d9
        L_0x00c6:
            boolean r6 = r3.isDisableFollowGuideTag()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r1.setDisableFollowGuideTag(r6)
            goto L_0x00d9
        L_0x00d2:
            boolean r1 = r5.booleanValue()
            r3.setDisableFollowGuideTag(r1)
        L_0x00d9:
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.followtag.FollowTagReducer.initFollowedAndFollowGuideTagVisibleControl(com.baidu.searchbox.feed.detail.arch.ext.CommonState, com.baidu.searchbox.flowvideo.detail.repos.FlowDetailModel):void");
    }
}
