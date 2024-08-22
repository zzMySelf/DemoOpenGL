package com.baidu.searchbox.video.feedflow.common;

import com.baidu.searchbox.feed.detail.arch.ext.OnComponentManagerSwitch;
import com.baidu.searchbox.feed.detail.arch.ext.OnItemStartFling;
import com.baidu.searchbox.feed.detail.ext.common.ExcAction;
import com.baidu.searchbox.feed.detail.ext.common.UserVisibleHint;
import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.feed.detail.frame.ActionTransferInterceptor;
import com.baidu.searchbox.video.component.audiofocus.OnAudioFocusChangeAction;
import com.baidu.searchbox.video.component.audiofocus.RequestAudioFocusAction;
import com.baidu.searchbox.video.component.autoplay.AutoPlayAction;
import com.baidu.searchbox.video.component.comment.AICommentAction;
import com.baidu.searchbox.video.component.comment.CommonCommentAction;
import com.baidu.searchbox.video.component.datachannel.DataChannelAction;
import com.baidu.searchbox.video.component.history.CommonHistoryAction;
import com.baidu.searchbox.video.component.router.RouterAction;
import com.baidu.searchbox.video.component.share.SharePanelVisibleChangeAction;
import com.baidu.searchbox.video.component.share.ShareSuccessAction;
import com.baidu.searchbox.video.component.talos.dialog.TalosDialogAction;
import com.baidu.searchbox.video.component.talos.item.TalosItemAction;
import com.baidu.searchbox.video.component.toast.ToastAction;
import com.baidu.searchbox.video.feedflow.clearscreen.ClearScreenBottomAction;
import com.baidu.searchbox.video.feedflow.clearscreen.ClearScreenNewAction;
import com.baidu.searchbox.video.feedflow.clearscreen.ClearScreenNewCollectionAction;
import com.baidu.searchbox.video.feedflow.detail.CompressionEndAction;
import com.baidu.searchbox.video.feedflow.detail.CompressionStartAction;
import com.baidu.searchbox.video.feedflow.detail.DetailItemDetachFromScreen;
import com.baidu.searchbox.video.feedflow.detail.DetailItemSelected;
import com.baidu.searchbox.video.feedflow.detail.DetailModelDispatchSuccess;
import com.baidu.searchbox.video.feedflow.detail.OnVideoDetachFromScreen;
import com.baidu.searchbox.video.feedflow.detail.UpdateDetailDataSuccess;
import com.baidu.searchbox.video.feedflow.detail.aicharacterbarrage.AiCharacterBarrageAction;
import com.baidu.searchbox.video.feedflow.detail.air.AirPlayIconClick;
import com.baidu.searchbox.video.feedflow.detail.air.AirPlayStatusChange;
import com.baidu.searchbox.video.feedflow.detail.attitude.AttitudeAction;
import com.baidu.searchbox.video.feedflow.detail.audit.ShowAuditPanelAction;
import com.baidu.searchbox.video.feedflow.detail.author.AuthorAction;
import com.baidu.searchbox.video.feedflow.detail.autoplay.OnAutoplaySwitchStateChanged;
import com.baidu.searchbox.video.feedflow.detail.autoplay.OnChannelAIPlayGuideClickAction;
import com.baidu.searchbox.video.feedflow.detail.autoplay.OnShowAutoPlayTip;
import com.baidu.searchbox.video.feedflow.detail.banner.BannerAction;
import com.baidu.searchbox.video.feedflow.detail.banner.freq.TryCalculateBannerDismissFreqAction;
import com.baidu.searchbox.video.feedflow.detail.banner.goods.AutoPopupBigBannerItemClickAction;
import com.baidu.searchbox.video.feedflow.detail.banner.goods.OnGoodsBigBannerHiddenAction;
import com.baidu.searchbox.video.feedflow.detail.banner.videolabel.VideoLabelPanelAction;
import com.baidu.searchbox.video.feedflow.detail.barrage.BarrageDisableAction;
import com.baidu.searchbox.video.feedflow.detail.barrage.BarrageLoginSendAction;
import com.baidu.searchbox.video.feedflow.detail.barrage.BarrageOpenAction;
import com.baidu.searchbox.video.feedflow.detail.barrage.BarrageSuccessAction;
import com.baidu.searchbox.video.feedflow.detail.barragesetting.ClickBarrageSettingEntryAction;
import com.baidu.searchbox.video.feedflow.detail.barragesetting.OnDismissBarrageSettingPanelAction;
import com.baidu.searchbox.video.feedflow.detail.barragesetting.OnShowBarrageSettingEntryAction;
import com.baidu.searchbox.video.feedflow.detail.batch.BatchCardAction;
import com.baidu.searchbox.video.feedflow.detail.bottom.BottomBarReducerAdapterAction;
import com.baidu.searchbox.video.feedflow.detail.bottom.statistic.BottomBarBackClickedAction;
import com.baidu.searchbox.video.feedflow.detail.bottom.statistic.BottomBarCommentClickedAction;
import com.baidu.searchbox.video.feedflow.detail.bottom.statistic.BottomBarEmojiClickedAction;
import com.baidu.searchbox.video.feedflow.detail.bottomassess.BottomAssessAction;
import com.baidu.searchbox.video.feedflow.detail.challenge.PublishChallenge;
import com.baidu.searchbox.video.feedflow.detail.challenge.toastandretry.TransChallengeAction;
import com.baidu.searchbox.video.feedflow.detail.changequery.ChangeQueryAction;
import com.baidu.searchbox.video.feedflow.detail.chat.ChatroomAction;
import com.baidu.searchbox.video.feedflow.detail.claritypanel.ClaritySwitchAction;
import com.baidu.searchbox.video.feedflow.detail.collectionPosterList.CollectionPosterListAction;
import com.baidu.searchbox.video.feedflow.detail.collectioncontinueplay.CollectionContinueDataUpdate;
import com.baidu.searchbox.video.feedflow.detail.collectioncontinueplay.OnCollContinuePlayNextRenderSuccess;
import com.baidu.searchbox.video.feedflow.detail.collectioncontinueplay.UpdateCollectionNextData;
import com.baidu.searchbox.video.feedflow.detail.collectonselectset.CollectionSelectSetsAction;
import com.baidu.searchbox.video.feedflow.detail.collectonselectset.ScrollToCollectionSetsAdErrorAction;
import com.baidu.searchbox.video.feedflow.detail.columnpanel.PadColumnPanelVisibleChangedAction;
import com.baidu.searchbox.video.feedflow.detail.combopraise.ComboPraiseAction;
import com.baidu.searchbox.video.feedflow.detail.combopraise.InvokeComboPraise;
import com.baidu.searchbox.video.feedflow.detail.comment.BindBottomCommentData;
import com.baidu.searchbox.video.feedflow.detail.comment.BottomCommentIconClickAction;
import com.baidu.searchbox.video.feedflow.detail.comment.CommentCountChangeAction;
import com.baidu.searchbox.video.feedflow.detail.comment.CommentDraftChangeAction;
import com.baidu.searchbox.video.feedflow.detail.comment.emojipanel.CommentEmojiPanelHide;
import com.baidu.searchbox.video.feedflow.detail.copyurl.OnCopyUrlSuccess;
import com.baidu.searchbox.video.feedflow.detail.defaultcombopraise.DefaultComboPraiseAction;
import com.baidu.searchbox.video.feedflow.detail.detainmentguide.ChannelDetainmentAction;
import com.baidu.searchbox.video.feedflow.detail.detainmentguide.DetainmentGuideShowAction;
import com.baidu.searchbox.video.feedflow.detail.detainmentguide.DetainmentLeavePageAction;
import com.baidu.searchbox.video.feedflow.detail.detainmentguide.DetainmentLeaveUpdateExitTimeAction;
import com.baidu.searchbox.video.feedflow.detail.dislike.DislikeNewPanelVisibleChangedAction;
import com.baidu.searchbox.video.feedflow.detail.diversion.TabDiversionAction;
import com.baidu.searchbox.video.feedflow.detail.dynamic.carouselpic.OnCarouselPicDoubleTap;
import com.baidu.searchbox.video.feedflow.detail.dynamic.carouselpic.OnCarouselPicMultipleGestureEnd;
import com.baidu.searchbox.video.feedflow.detail.dynamic.carouselpic.OnCarouselPicScaleEnd;
import com.baidu.searchbox.video.feedflow.detail.dynamic.carouselpic.OnCarouselPicTwoFingerPressEnd;
import com.baidu.searchbox.video.feedflow.detail.dynamic.carouselprogressbar.OnCarouselProgressBarStateChanged;
import com.baidu.searchbox.video.feedflow.detail.dynamic.longpicbtn.OnLongPicBtnClick;
import com.baidu.searchbox.video.feedflow.detail.dynamic.music.DynamicBgmActionManifest;
import com.baidu.searchbox.video.feedflow.detail.entertransition.OnPlayerReuseTransitionAnimEnd;
import com.baidu.searchbox.video.feedflow.detail.error.NetErrorRetryAction;
import com.baidu.searchbox.video.feedflow.detail.error.NetErrorVisibleChanged;
import com.baidu.searchbox.video.feedflow.detail.favor.BindBottomFavorDataAction;
import com.baidu.searchbox.video.feedflow.detail.favor.BindBottomFavorDynamicDataAction;
import com.baidu.searchbox.video.feedflow.detail.favor.BottomFavorIconClickAction;
import com.baidu.searchbox.video.feedflow.detail.favor.BottomFavorIconLongClickAction;
import com.baidu.searchbox.video.feedflow.detail.favor.CollectionFavorTransUpdateAction;
import com.baidu.searchbox.video.feedflow.detail.favor.CollectionFavorUpdateAction;
import com.baidu.searchbox.video.feedflow.detail.favor.FavorBackAction;
import com.baidu.searchbox.video.feedflow.detail.favor.FavorStateChangeAction;
import com.baidu.searchbox.video.feedflow.detail.favor.FavorViewStatusChangeAction;
import com.baidu.searchbox.video.feedflow.detail.favor.OnFavorStatusChangeByUser;
import com.baidu.searchbox.video.feedflow.detail.favor.QueryFavorAction;
import com.baidu.searchbox.video.feedflow.detail.favorbottomtoast.ShowFavorBottomToastAction;
import com.baidu.searchbox.video.feedflow.detail.floating.goback.OnFloatingBtnSelectedAndPageCloseAction;
import com.baidu.searchbox.video.feedflow.detail.floating.goback.OnSlideReleaseFloatingBtnSelectedAction;
import com.baidu.searchbox.video.feedflow.detail.fullplay.UploadFullPlayBtnShowStatisticInClearScreen;
import com.baidu.searchbox.video.feedflow.detail.gesture.ClickScrollToTargetPosition;
import com.baidu.searchbox.video.feedflow.detail.gesture.DynamicScrollLeftSlide;
import com.baidu.searchbox.video.feedflow.detail.gesture.GraphicGenreScrollLeftSlide;
import com.baidu.searchbox.video.feedflow.detail.gesture.ScrollLeftSlide;
import com.baidu.searchbox.video.feedflow.detail.guesslike.GuessLikeAction;
import com.baidu.searchbox.video.feedflow.detail.guide.ShowScaleGestureGuideAction;
import com.baidu.searchbox.video.feedflow.detail.homebar.ChannelBarTabClick;
import com.baidu.searchbox.video.feedflow.detail.interest.InterestAction;
import com.baidu.searchbox.video.feedflow.detail.interestinsert.RemoveInterestAction;
import com.baidu.searchbox.video.feedflow.detail.itemduration.GuessLikeVideoItemDurationAction;
import com.baidu.searchbox.video.feedflow.detail.itemduration.VideoItemDurationAction;
import com.baidu.searchbox.video.feedflow.detail.landscapefold.LandscapeFoldAction;
import com.baidu.searchbox.video.feedflow.detail.landscapelistpanel.LandscapeListPanelItemClickAction;
import com.baidu.searchbox.video.feedflow.detail.landscapenextguide.OnLandNextGuideClicked;
import com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelItemClickAction;
import com.baidu.searchbox.video.feedflow.detail.listpanel.ListPanelVisibleChangeAction;
import com.baidu.searchbox.video.feedflow.detail.liveactivity.LiveActivityHide;
import com.baidu.searchbox.video.feedflow.detail.livereal.LiveRealContainerAction;
import com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.LongPressMenuItemClickAction;
import com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.MoreMenuNewPanelVisibleChangedAction;
import com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.ShowLongPressNewGuide;
import com.baidu.searchbox.video.feedflow.detail.longpressmenu.LongPressMenuItemAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmenu.OnHideLongPressMenuAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmenu.OnShowLongPressMenuAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.ChangeLongPressMoreBarrageSwitchAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.LongPressMoreAIPlayClickAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.LongPressMoreAirPlayClickAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.LongPressMoreAutoPlayChangedAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.LongPressMoreClearScreenClickAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.LongPressMoreCollectionSubscribeChangedAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.LongPressMoreFastModeClickedAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.LongPressMoreListenVideoClick;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.LongPressMoreMirrorChangedAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.LongPressMoreMuteChangedAction;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.LongPressMoreSpeedClickAction;
import com.baidu.searchbox.video.feedflow.detail.longpressspeed.LongPressSpeedAnim;
import com.baidu.searchbox.video.feedflow.detail.more.AirPlayMenuBtnClick;
import com.baidu.searchbox.video.feedflow.detail.more.AutoplayNextBtnClick;
import com.baidu.searchbox.video.feedflow.detail.more.ClarityBtnClick;
import com.baidu.searchbox.video.feedflow.detail.more.ClearScreenBtnClick;
import com.baidu.searchbox.video.feedflow.detail.more.CollectSubscribeBtnClick;
import com.baidu.searchbox.video.feedflow.detail.more.CopyUrlAction;
import com.baidu.searchbox.video.feedflow.detail.more.DownloadBtnClick;
import com.baidu.searchbox.video.feedflow.detail.more.FloatingMenuBtnClick;
import com.baidu.searchbox.video.feedflow.detail.more.GoHomeAction;
import com.baidu.searchbox.video.feedflow.detail.more.HotCommentBtnClickAction;
import com.baidu.searchbox.video.feedflow.detail.more.MenuFavorAction;
import com.baidu.searchbox.video.feedflow.detail.more.MenuShareClickAction;
import com.baidu.searchbox.video.feedflow.detail.more.MirrorBtnClick;
import com.baidu.searchbox.video.feedflow.detail.more.MoreClickAction;
import com.baidu.searchbox.video.feedflow.detail.more.OnMorePanelVisibleChange;
import com.baidu.searchbox.video.feedflow.detail.more.OnSubscribeStateChange;
import com.baidu.searchbox.video.feedflow.detail.more.RefreshVulcanMoreTipVisibility;
import com.baidu.searchbox.video.feedflow.detail.more.ReportAction;
import com.baidu.searchbox.video.feedflow.detail.more.SpeedBtnClick;
import com.baidu.searchbox.video.feedflow.detail.more.UninterestedClickAction;
import com.baidu.searchbox.video.feedflow.detail.more.UpdateMoreStateConfig;
import com.baidu.searchbox.video.feedflow.detail.more.VideoSettingsMenuBtnClick;
import com.baidu.searchbox.video.feedflow.detail.moveup.MoveUpAnimSwitchAction;
import com.baidu.searchbox.video.feedflow.detail.mute.ChangePageMuteMode;
import com.baidu.searchbox.video.feedflow.detail.nextbigcard.NextBigCardAction;
import com.baidu.searchbox.video.feedflow.detail.nextcontent.OnNextContentTipClicked;
import com.baidu.searchbox.video.feedflow.detail.nextcontent.RecommendNextContentDetailSuccess;
import com.baidu.searchbox.video.feedflow.detail.nextcontent.StoreGenTitleInfo;
import com.baidu.searchbox.video.feedflow.detail.nextcontent.data.NextDataTransAction;
import com.baidu.searchbox.video.feedflow.detail.night.NightModeChanged;
import com.baidu.searchbox.video.feedflow.detail.ocrsummary.OcrSummaryAction;
import com.baidu.searchbox.video.feedflow.detail.offline.OfflineVisibleChanged;
import com.baidu.searchbox.video.feedflow.detail.offline.OnOfflineNotActive;
import com.baidu.searchbox.video.feedflow.detail.offline.OnOfflineTimerTaskCompleted;
import com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTripleAnimatorEndAction;
import com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTripleAnimatorStartAction;
import com.baidu.searchbox.video.feedflow.detail.onekeytriple.OneKeyTripleUpdatePraiseAction;
import com.baidu.searchbox.video.feedflow.detail.oneton.OnOneToNHiddenAction;
import com.baidu.searchbox.video.feedflow.detail.oneton.OnOneToNShownAction;
import com.baidu.searchbox.video.feedflow.detail.payment.paymentdetailspanel.PaymentDetailPanelAction;
import com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ResetCollectionPanelData;
import com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayGuideShowAction;
import com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayPaymentLoginSuccess;
import com.baidu.searchbox.video.feedflow.detail.payment.shortplay.ShortPlayVideoAction;
import com.baidu.searchbox.video.feedflow.detail.payment.shortplay.WatchAdCompleteAction;
import com.baidu.searchbox.video.feedflow.detail.payment.shortplay.autounlockall.ShortPlayAutoUnlockAllAction;
import com.baidu.searchbox.video.feedflow.detail.payment.shortplay.autounlockall.ShortPlayAutoUnlockAllUpdateDataAction;
import com.baidu.searchbox.video.feedflow.detail.payment.shortplay.shortplaypaypanel.InvokeShortPlayPayPanel;
import com.baidu.searchbox.video.feedflow.detail.payment.subscribe.SubscribeLastFrameReplayClickAction;
import com.baidu.searchbox.video.feedflow.detail.payment.subscribe.SubscribeLastFrameShownAction;
import com.baidu.searchbox.video.feedflow.detail.paymentSubscribe.OnFollowPaymentSubscribePanelHide;
import com.baidu.searchbox.video.feedflow.detail.paymentSubscribe.OnFollowPaymentSubscribePanelShow;
import com.baidu.searchbox.video.feedflow.detail.personalizedcontent.InsertModelByPersonal;
import com.baidu.searchbox.video.feedflow.detail.personalizedtips.AcceptListDataAction;
import com.baidu.searchbox.video.feedflow.detail.personalizedtips.RefuseListDataAndToastAction;
import com.baidu.searchbox.video.feedflow.detail.pinch.NotSupportGestureComponentVisibilityAction;
import com.baidu.searchbox.video.feedflow.detail.pinch.PinchSummaryClickAction;
import com.baidu.searchbox.video.feedflow.detail.pinch.PinchSummaryGuideAction;
import com.baidu.searchbox.video.feedflow.detail.player.AirPlayComplete;
import com.baidu.searchbox.video.feedflow.detail.player.BackFromAutoModeFloating;
import com.baidu.searchbox.video.feedflow.detail.player.BackFromFloating;
import com.baidu.searchbox.video.feedflow.detail.player.DisEnableSensor;
import com.baidu.searchbox.video.feedflow.detail.player.FirstJumpPlayerFirstFrame;
import com.baidu.searchbox.video.feedflow.detail.player.HideFloatingBadgeAction;
import com.baidu.searchbox.video.feedflow.detail.player.OnDownloadBegin;
import com.baidu.searchbox.video.feedflow.detail.player.OnFloatViewVisibleChangeAction;
import com.baidu.searchbox.video.feedflow.detail.player.OnIntelligentFillScreenStatusChange;
import com.baidu.searchbox.video.feedflow.detail.player.OnKernelPivotResetAction;
import com.baidu.searchbox.video.feedflow.detail.player.OnLandCommentEmojiClick;
import com.baidu.searchbox.video.feedflow.detail.player.OnLandCommentInputClick;
import com.baidu.searchbox.video.feedflow.detail.player.OnLoadingEnd;
import com.baidu.searchbox.video.feedflow.detail.player.OnLoadingStart;
import com.baidu.searchbox.video.feedflow.detail.player.OnMuteStateChange;
import com.baidu.searchbox.video.feedflow.detail.player.OnPlayerFloatingBtnClickedAction;
import com.baidu.searchbox.video.feedflow.detail.player.OnPlayerPreRenderSuccess;
import com.baidu.searchbox.video.feedflow.detail.player.OnPlayerSetDataSource;
import com.baidu.searchbox.video.feedflow.detail.player.OnPlayerSpeedChanged;
import com.baidu.searchbox.video.feedflow.detail.player.OnRetainDialogVisibleChangeAction;
import com.baidu.searchbox.video.feedflow.detail.player.OnVulcanAIPlayClicked;
import com.baidu.searchbox.video.feedflow.detail.player.OnVulcanAutoplayClicked;
import com.baidu.searchbox.video.feedflow.detail.player.OnVulcanMoreTipChanged;
import com.baidu.searchbox.video.feedflow.detail.player.OnVulcanThreeDivideGuideClickedAction;
import com.baidu.searchbox.video.feedflow.detail.player.OnVulcanThreeDivideGuideVisibleChangedAction;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerAirPlayLayerVisibleChanged;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerBarrageButtonClick;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerClarityChanged;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerClipCompleteAction;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerComplete;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerEnterTransitionAnimAction;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerError;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerFirstFrame;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerFuncPanelVisibleChanged;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerHeadsetConnectChanged;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerLoop;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerMutePropertyChanged;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerOrientationChanged;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerPause;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerPauseFormUser;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerResume;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerResumeFormUser;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerResumeFromCovered;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerScaleGestureAction;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerSeekBarStart;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerSpeedChanged;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerStart;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerStatusChangedAction;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerStop;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerTouchBeginGestureAction;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerTouchEndGestureAction;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerTriggerStartAction;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerVolumeChangedAction;
import com.baidu.searchbox.video.feedflow.detail.player.PlayerVulcanAirPlayBtnClick;
import com.baidu.searchbox.video.feedflow.detail.player.ResetMirrorAction;
import com.baidu.searchbox.video.feedflow.detail.player.UpdatePlayerUbcContentAction;
import com.baidu.searchbox.video.feedflow.detail.player.VideoDownloadSuccess;
import com.baidu.searchbox.video.feedflow.detail.praise.BindBottomPraiseData;
import com.baidu.searchbox.video.feedflow.detail.praise.BottomPraiseButtonClickAction;
import com.baidu.searchbox.video.feedflow.detail.praise.BottomPraiseStatusChangeAction;
import com.baidu.searchbox.video.feedflow.detail.praise.PraiseStatusChangeAction;
import com.baidu.searchbox.video.feedflow.detail.praise.PraiseViewStatusChangeAction;
import com.baidu.searchbox.video.feedflow.detail.praise.UpdateOtherVideoPraiseAction;
import com.baidu.searchbox.video.feedflow.detail.praise.UpdateOtherVideoPraiseTransAction;
import com.baidu.searchbox.video.feedflow.detail.praisemaskguide.ShowDoubleClickPraiseMaskGuideAction;
import com.baidu.searchbox.video.feedflow.detail.queryspecial.OnItemClickAction;
import com.baidu.searchbox.video.feedflow.detail.queryspecial.QueryWordFetchCanceledAction;
import com.baidu.searchbox.video.feedflow.detail.recommend.InsertRelatedVideoToNextPositionAction;
import com.baidu.searchbox.video.feedflow.detail.recommend.OnRelatedRecommendPanelHideToInterceptAction;
import com.baidu.searchbox.video.feedflow.detail.recommendcontent.action.RecommendContentPanelAction;
import com.baidu.searchbox.video.feedflow.detail.relatedpreview.RelatedPreviewPanelAction;
import com.baidu.searchbox.video.feedflow.detail.relatedsearch.RelatedSearchPanelAction;
import com.baidu.searchbox.video.feedflow.detail.report.ReportClickedAction;
import com.baidu.searchbox.video.feedflow.detail.scrollnext.ScrollToNextAndRemoveAction;
import com.baidu.searchbox.video.feedflow.detail.seamlessplay.InvokeSeamlessTCUpLog;
import com.baidu.searchbox.video.feedflow.detail.seamlessplay.OnSeamlessPlayEnd;
import com.baidu.searchbox.video.feedflow.detail.seamlessplay.SeamlessPlayChange;
import com.baidu.searchbox.video.feedflow.detail.search.ImageSearchTakeSnapshot;
import com.baidu.searchbox.video.feedflow.detail.search.OnSearchBoxStyleChangeActon;
import com.baidu.searchbox.video.feedflow.detail.search.SearchButtonClickAction;
import com.baidu.searchbox.video.feedflow.detail.search.SearchTxtViewClickAction;
import com.baidu.searchbox.video.feedflow.detail.search.TopBarSearchClickedAction;
import com.baidu.searchbox.video.feedflow.detail.searchrecommenddata.SearchRecommendDataAction;
import com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.FirstJumpSwitchTipConfigChanged;
import com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.OnLandSwitchTipChange;
import com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.OnOutSideStartAutoPlay;
import com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.OnSwitchBgClick;
import com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.OnSwitchTipCancel;
import com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.OnSwitchTipClicked;
import com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.OnSwitchTipTimerComplete;
import com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.OnVerticalSwitchTipHide;
import com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.OnVerticalSwitchTipShow;
import com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.OnVerticalSwitchTipShowForStatistic;
import com.baidu.searchbox.video.feedflow.detail.secondjumpswitch.SecondJumpLeaveChanelVideo;
import com.baidu.searchbox.video.feedflow.detail.seekbar.SeekBarAwakeAction;
import com.baidu.searchbox.video.feedflow.detail.seekbar.UserDragSeekBarEnd;
import com.baidu.searchbox.video.feedflow.detail.seekbar.UserDragSeekBarStart;
import com.baidu.searchbox.video.feedflow.detail.settings.VideoSettingsAIPlayClickedAction;
import com.baidu.searchbox.video.feedflow.detail.settings.VideoSettingsAutoPlayChangedAction;
import com.baidu.searchbox.video.feedflow.detail.settings.VideoSettingsFastModeClickedAction;
import com.baidu.searchbox.video.feedflow.detail.settings.VideoSettingsMuteChangedAction;
import com.baidu.searchbox.video.feedflow.detail.share.BindBottomShareDataAction;
import com.baidu.searchbox.video.feedflow.detail.share.BottomShareBtnClickAction;
import com.baidu.searchbox.video.feedflow.detail.share.ShareClickUninterestedAction;
import com.baidu.searchbox.video.feedflow.detail.speed.SpeedPanelOnlyCurVideoSwitchAction;
import com.baidu.searchbox.video.feedflow.detail.speed.SpeedPanelSwitchAction;
import com.baidu.searchbox.video.feedflow.detail.speedout.OnSpeedOutClickedAction;
import com.baidu.searchbox.video.feedflow.detail.speedout.RefreshOutSpeedAction;
import com.baidu.searchbox.video.feedflow.detail.subscribe.SubscribeDialogClickAction;
import com.baidu.searchbox.video.feedflow.detail.summary.SummaryAuthorNicknameAction;
import com.baidu.searchbox.video.feedflow.detail.summary.SummaryFoldAction;
import com.baidu.searchbox.video.feedflow.detail.summary.SummaryFullScreenFoldAnimationEndAction;
import com.baidu.searchbox.video.feedflow.detail.summary.SummaryFullScreenUnFoldAnimationStartAction;
import com.baidu.searchbox.video.feedflow.detail.tabguide.InnerHideTabBubbleGuide;
import com.baidu.searchbox.video.feedflow.detail.talosassessbig.AssessBigTalosAction;
import com.baidu.searchbox.video.feedflow.detail.talosassessbig.common.AssessmentCardAction;
import com.baidu.searchbox.video.feedflow.detail.talosgoodspanel.TalosPanelAction;
import com.baidu.searchbox.video.feedflow.detail.toast.HideTipAction;
import com.baidu.searchbox.video.feedflow.detail.toast.OnTipBtnClickAction;
import com.baidu.searchbox.video.feedflow.detail.toast.ShowSimpleToast;
import com.baidu.searchbox.video.feedflow.detail.toast.ShowTipAction;
import com.baidu.searchbox.video.feedflow.detail.toast.TipShownAction;
import com.baidu.searchbox.video.feedflow.detail.toast.UpdateTipAction;
import com.baidu.searchbox.video.feedflow.detail.ttsguide.HideTTSToastHideInnerAction;
import com.baidu.searchbox.video.feedflow.detail.ttsguide.TryShowTTSToastAction;
import com.baidu.searchbox.video.feedflow.detail.uninterested.UninterestedAction;
import com.baidu.searchbox.video.feedflow.detail.uninterested.UninterestedClickedAction;
import com.baidu.searchbox.video.feedflow.detail.uninterested.UninterestedShowAction;
import com.baidu.searchbox.video.feedflow.detail.videoedit.VideoDeleteAction;
import com.baidu.searchbox.video.feedflow.detail.videoedit.VideoEditAction;
import com.baidu.searchbox.video.feedflow.detail.videosummary.VideoSummaryListFoldAction;
import com.baidu.searchbox.video.feedflow.detail.voice.VoicePanelAction;
import com.baidu.searchbox.video.feedflow.detail.windowmovingup.WindowMovingUpAction;
import com.baidu.searchbox.video.feedflow.flow.assessment.AssessmentCardTimerComplete;
import com.baidu.searchbox.video.feedflow.flow.attention.guide.AttentionToRecGuideAction;
import com.baidu.searchbox.video.feedflow.flow.authorhome.followarouse.ShowAuthorHomeVideoAuthorFollowButtonGuide;
import com.baidu.searchbox.video.feedflow.flow.authorhome.followarouse.ShowAuthorHomeVideoFollowGuide;
import com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorkDoubleClickAction;
import com.baidu.searchbox.video.feedflow.flow.authorworks.AuthorWorksScrollLeftSlide;
import com.baidu.searchbox.video.feedflow.flow.authorworks.OnAuthorWorkPlayBtnClick;
import com.baidu.searchbox.video.feedflow.flow.authorworks.OnAuthorWorkSpeedBtnClick;
import com.baidu.searchbox.video.feedflow.flow.authorworks.OnAuthorWorksEnterHomePage;
import com.baidu.searchbox.video.feedflow.flow.authorworks.OnAuthorWorksStatusChange;
import com.baidu.searchbox.video.feedflow.flow.autoplay.OnAutoplaySwitchChanged;
import com.baidu.searchbox.video.feedflow.flow.baikepanel.BaikePanelAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.AIPlaySwitchClick;
import com.baidu.searchbox.video.feedflow.flow.bottom.AiCommentBubbleGuideAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.AutoPlaySwitchClick;
import com.baidu.searchbox.video.feedflow.flow.bottom.AutoPlaySwitchGuideShowOrHide;
import com.baidu.searchbox.video.feedflow.flow.bottom.AutoPlaySwitchShowAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.BarrageIconEntranceClickAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.BindBottomInteractDataAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarAIPlayGuideShow;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarBarrageIconClickedAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarBarrageInputClickAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarBarrageInputEmojiClickAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarBarrageInputShowAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarBarragePresetTextShowAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarBarrageSendButtonClickAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarBarrageSendButtonShowAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarHeightChange;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarLoopPlayGuideShow;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomBarrageGuideShowAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.BottomNextRecommendCloseBtnClick;
import com.baidu.searchbox.video.feedflow.flow.bottom.HideGuideByOpt;
import com.baidu.searchbox.video.feedflow.flow.bottom.InvokeHideAutoPlayBottomGuide;
import com.baidu.searchbox.video.feedflow.flow.bottom.NextDetailModelDispatchSuccess;
import com.baidu.searchbox.video.feedflow.flow.bottom.OnBarrageButtonClickAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.OnEmojiClickAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.OnToolBarItemListUpdate;
import com.baidu.searchbox.video.feedflow.flow.bottom.RecommendNextEntryClickAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.RecommendNextEntryShowAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.RecommendNextHalfShowAction;
import com.baidu.searchbox.video.feedflow.flow.bottom.UpdateLandCommentText;
import com.baidu.searchbox.video.feedflow.flow.bottom.UpdatePresetInputIndex;
import com.baidu.searchbox.video.feedflow.flow.bottom.barrageinputbar.BarrageInputBarIconClickAction;
import com.baidu.searchbox.video.feedflow.flow.cache.FlowSaveCacheAction;
import com.baidu.searchbox.video.feedflow.flow.coldlaunch.UpdateColdLaunchRestoreScheme;
import com.baidu.searchbox.video.feedflow.flow.collection.CollectionPanelAction;
import com.baidu.searchbox.video.feedflow.flow.collection.collectionrecord.RecordCollectionAction;
import com.baidu.searchbox.video.feedflow.flow.collection.collectionrecord.SyncCollectionIdAction;
import com.baidu.searchbox.video.feedflow.flow.collection.collectionrecord.SyncLastCollectionAction;
import com.baidu.searchbox.video.feedflow.flow.collection.landscapehomemiddle.LandscapeHomeMiddlePanelAction;
import com.baidu.searchbox.video.feedflow.flow.collection.landscaperelatedrecommend.LandscapeRelatedRecommendPanelAction;
import com.baidu.searchbox.video.feedflow.flow.comonlistpanel.VideoLabelPanelVisibleChangedAction;
import com.baidu.searchbox.video.feedflow.flow.empty.FlowEmptyClickAction;
import com.baidu.searchbox.video.feedflow.flow.extlog.OnAutoplayModify;
import com.baidu.searchbox.video.feedflow.flow.extlog.OnPlayModeModify;
import com.baidu.searchbox.video.feedflow.flow.extlog.OnRecommendModify;
import com.baidu.searchbox.video.feedflow.flow.extlog.OnWindowMovingUpModify;
import com.baidu.searchbox.video.feedflow.flow.fastslide.FastSlideAction;
import com.baidu.searchbox.video.feedflow.flow.fontsize.FontSizeChangedAction;
import com.baidu.searchbox.video.feedflow.flow.globalmuteguide.ChangeGlobalMuteVisibleWithAnimAction;
import com.baidu.searchbox.video.feedflow.flow.guide.OnPortraitOrLandscapeScrollUpGuideVisibleChangedAction;
import com.baidu.searchbox.video.feedflow.flow.guide.ScrollUpGuideLeaveChanelVideo;
import com.baidu.searchbox.video.feedflow.flow.guide.SevenDayUnScrollUpStartGuideAction;
import com.baidu.searchbox.video.feedflow.flow.guidemanager.GuideShown;
import com.baidu.searchbox.video.feedflow.flow.guidemanager.ProgressGuideShow;
import com.baidu.searchbox.video.feedflow.flow.intelligentfillscreen.UpdateItemIntelligentFillScreenStatus;
import com.baidu.searchbox.video.feedflow.flow.launchpanel.OnLaunchSettingPanelClickSetAction;
import com.baidu.searchbox.video.feedflow.flow.launchpanel.OnLaunchSettingPanelHideAction;
import com.baidu.searchbox.video.feedflow.flow.launchpanel.OnLaunchSettingPanelShowAction;
import com.baidu.searchbox.video.feedflow.flow.list.ActivityAnimation;
import com.baidu.searchbox.video.feedflow.flow.list.ClearAllData;
import com.baidu.searchbox.video.feedflow.flow.list.ClearListDataAfterCurrent;
import com.baidu.searchbox.video.feedflow.flow.list.ClearListDataAfterCurrentSync;
import com.baidu.searchbox.video.feedflow.flow.list.ClearListDataRetainCurrentAction;
import com.baidu.searchbox.video.feedflow.flow.list.CollectionRequestListData;
import com.baidu.searchbox.video.feedflow.flow.list.ConfigurationChangedAction;
import com.baidu.searchbox.video.feedflow.flow.list.DispatchTouchDownEvent;
import com.baidu.searchbox.video.feedflow.flow.list.DispatchTouchUpEvent;
import com.baidu.searchbox.video.feedflow.flow.list.FlowDetailDataUpdate;
import com.baidu.searchbox.video.feedflow.flow.list.FlowListViewDragRelease;
import com.baidu.searchbox.video.feedflow.flow.list.FlowListViewTranslationChanged;
import com.baidu.searchbox.video.feedflow.flow.list.FlowRequestWithInterestTags;
import com.baidu.searchbox.video.feedflow.flow.list.FoldScreenExpandOrientationChanged;
import com.baidu.searchbox.video.feedflow.flow.list.FoldScreenFoldStateChanged;
import com.baidu.searchbox.video.feedflow.flow.list.FoldScreenSizeChanged;
import com.baidu.searchbox.video.feedflow.flow.list.IAdFlowAction;
import com.baidu.searchbox.video.feedflow.flow.list.InsertGuessLikeItemAction;
import com.baidu.searchbox.video.feedflow.flow.list.InsertPersonalizedItemAction;
import com.baidu.searchbox.video.feedflow.flow.list.InsertQuerySpecialCardItemAction;
import com.baidu.searchbox.video.feedflow.flow.list.InsertSimilarCollectionVideoAction;
import com.baidu.searchbox.video.feedflow.flow.list.ListDataChanged;
import com.baidu.searchbox.video.feedflow.flow.list.ListRefreshCompleteAction;
import com.baidu.searchbox.video.feedflow.flow.list.ListRefreshCompleteUpdateItemUIAction;
import com.baidu.searchbox.video.feedflow.flow.list.ListRequestFail;
import com.baidu.searchbox.video.feedflow.flow.list.ListRequestSuccess;
import com.baidu.searchbox.video.feedflow.flow.list.MultiWindowModeChanged;
import com.baidu.searchbox.video.feedflow.flow.list.OnCurItemUpdated;
import com.baidu.searchbox.video.feedflow.flow.list.OnFlowNestedPageSelectedBeforeToTab;
import com.baidu.searchbox.video.feedflow.flow.list.OnFlowRequestAction;
import com.baidu.searchbox.video.feedflow.flow.list.OnFlowResponseAction;
import com.baidu.searchbox.video.feedflow.flow.list.OnFlowResponseForItemAction;
import com.baidu.searchbox.video.feedflow.flow.list.OnItemRemoveCompleteAction;
import com.baidu.searchbox.video.feedflow.flow.list.OnPanelSlideCloseAction;
import com.baidu.searchbox.video.feedflow.flow.list.OnPanelSlideStartAction;
import com.baidu.searchbox.video.feedflow.flow.list.OnRelatedVideoItemInsertedAction;
import com.baidu.searchbox.video.feedflow.flow.list.OnRequestActionConsumer;
import com.baidu.searchbox.video.feedflow.flow.list.OnSizeChangedInMultiWindowMode;
import com.baidu.searchbox.video.feedflow.flow.list.RefreshClarityList;
import com.baidu.searchbox.video.feedflow.flow.list.RefreshItemByPositionAction;
import com.baidu.searchbox.video.feedflow.flow.list.RemoveItemAction;
import com.baidu.searchbox.video.feedflow.flow.list.RemoveNotDisplayItemsAction;
import com.baidu.searchbox.video.feedflow.flow.list.RetryRequestListDataAction;
import com.baidu.searchbox.video.feedflow.flow.list.ScrollStateChanged;
import com.baidu.searchbox.video.feedflow.flow.list.ScrollToNextAfterReplaceList;
import com.baidu.searchbox.video.feedflow.flow.list.ScrollToPositionAction;
import com.baidu.searchbox.video.feedflow.flow.list.SmoothScrollAction;
import com.baidu.searchbox.video.feedflow.flow.list.UpdateFlowStyle;
import com.baidu.searchbox.video.feedflow.flow.list.UpdateLayoutAction;
import com.baidu.searchbox.video.feedflow.flow.list.UpdateSingleDataAction;
import com.baidu.searchbox.video.feedflow.flow.list.UpdateSingleDataBySameNidAction;
import com.baidu.searchbox.video.feedflow.flow.list.VideoViewCoveredChanged;
import com.baidu.searchbox.video.feedflow.flow.list.VideoViewCoveredDetail;
import com.baidu.searchbox.video.feedflow.flow.list.WindowFocusChanged;
import com.baidu.searchbox.video.feedflow.flow.listenvideo.ListenVideoClick;
import com.baidu.searchbox.video.feedflow.flow.more.MoreFlowAction;
import com.baidu.searchbox.video.feedflow.flow.offline.OfflineFlowAction;
import com.baidu.searchbox.video.feedflow.flow.offlinecache.FlowOfflineCacheAction;
import com.baidu.searchbox.video.feedflow.flow.payment.pay.PayAction;
import com.baidu.searchbox.video.feedflow.flow.playmode.PlayModeAction;
import com.baidu.searchbox.video.feedflow.flow.pullrefresh.PullRefreshAction;
import com.baidu.searchbox.video.feedflow.flow.search.SearchMarkFlowAction;
import com.baidu.searchbox.video.feedflow.flow.shortplaypanel.ShortPlayPanelAction;
import com.baidu.searchbox.video.feedflow.flow.showclick.ItemShowAction;
import com.baidu.searchbox.video.feedflow.flow.showclick.UploadShowClickAction;
import com.baidu.searchbox.video.feedflow.flow.slide.LeftSlideAction;
import com.baidu.searchbox.video.feedflow.flow.slide.PageScaleAction;
import com.baidu.searchbox.video.feedflow.flow.swan.HalfScreenViewSwanAction;
import com.baidu.searchbox.video.feedflow.flow.sync.eventbus.EventBusAction;
import com.baidu.searchbox.video.feedflow.flow.sync.linkage.LinkageAction;
import com.baidu.searchbox.video.feedflow.flow.task.FlowTaskAction;
import com.baidu.searchbox.video.feedflow.flow.topexpand.entrance.TopEntranceAction;
import com.baidu.searchbox.video.feedflow.flow.topexpand.expandable.TopExpandableAction;
import com.baidu.searchbox.video.feedflow.pushlinkage.VideoItemContainerAction;
import com.baidu.searchbox.video.feedflow.tab.SearchOnTabSelected;
import com.baidu.searchbox.video.feedflow.tab.TabComponentAction;
import com.baidu.searchbox.video.feedflow.tab.back.DragAnimationStart;
import com.baidu.searchbox.video.feedflow.tab.back.SearchOnKeyPressedBack;
import com.baidu.searchbox.video.feedflow.tab.back.SearchSlideBack;
import com.baidu.searchbox.video.feedflow.tab.publish.PublishEnterEnable;
import com.baidu.searchbox.video.feedflow.tab.quickSlide.QuickSlideStateChange;
import com.baidu.searchbox.video.feedflow.tab.talosbind.OnTalosPanelVisibleChange;
import com.baidu.searchbox.video.feedflow.tab.theater.top.TheaterTopContainerAction;
import com.baidu.searchbox.video.feedflow.tab.wealth.OnWealthTaskDialogStatusChange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/common/VideoFlowActionInterceptor;", "Lcom/baidu/searchbox/feed/detail/frame/ActionTransferInterceptor;", "()V", "accept", "", "action", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "deliver", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoFlowActionInterceptor.kt */
public class VideoFlowActionInterceptor extends ActionTransferInterceptor {
    public boolean accept(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof MoreClickAction) {
            return true;
        }
        if (action instanceof MenuShareClickAction) {
            return true;
        }
        if (action instanceof CopyUrlAction) {
            return true;
        }
        if (action instanceof ReportAction) {
            return true;
        }
        if (action instanceof GoHomeAction) {
            return true;
        }
        if (action instanceof MenuFavorAction) {
            return true;
        }
        if (action instanceof DownloadBtnClick) {
            return true;
        }
        if (action instanceof UninterestedClickAction) {
            return true;
        }
        if (action instanceof ClarityBtnClick) {
            return true;
        }
        if (action instanceof AutoplayNextBtnClick) {
            return true;
        }
        if (action instanceof SpeedBtnClick) {
            return true;
        }
        if (action instanceof OnMorePanelVisibleChange) {
            return true;
        }
        if (action instanceof ClearScreenBtnClick) {
            return true;
        }
        if (action instanceof CollectSubscribeBtnClick) {
            return true;
        }
        if (action instanceof MirrorBtnClick) {
            return true;
        }
        if (action instanceof TopBarSearchClickedAction) {
            return true;
        }
        if (action instanceof SearchTxtViewClickAction) {
            return true;
        }
        if (action instanceof SearchButtonClickAction) {
            return true;
        }
        if (action instanceof ListRequestSuccess) {
            return true;
        }
        if (action instanceof ListRequestFail) {
            return true;
        }
        if (action instanceof ListRefreshCompleteAction) {
            return true;
        }
        if (action instanceof ListDataChanged) {
            return true;
        }
        if (action instanceof BottomBarCommentClickedAction) {
            return true;
        }
        if (action instanceof BottomBarEmojiClickedAction) {
            return true;
        }
        if (action instanceof BottomBarBackClickedAction) {
            return true;
        }
        if (action instanceof AutoPlayAction.AutoPlayNextFail) {
            return true;
        }
        if (action instanceof OnAutoplaySwitchChanged) {
            return true;
        }
        if (action instanceof OnTipBtnClickAction) {
            return true;
        }
        if (action instanceof OnAutoplayModify) {
            return true;
        }
        if (action instanceof OnRecommendModify) {
            return true;
        }
        if (action instanceof OnWindowMovingUpModify) {
            return true;
        }
        if (action instanceof OnPlayModeModify) {
            return true;
        }
        if (action instanceof SearchOnTabSelected) {
            return true;
        }
        if (action instanceof TipShownAction) {
            return true;
        }
        if (action instanceof GuideShown) {
            return true;
        }
        if (action instanceof RefreshVulcanMoreTipVisibility) {
            return true;
        }
        if (action instanceof NextDataTransAction) {
            return true;
        }
        if (action instanceof AutoPlayAction.OnAutoTimerComplete) {
            return true;
        }
        if (action instanceof BottomBarAIPlayGuideShow) {
            return true;
        }
        if (action instanceof BottomBarLoopPlayGuideShow) {
            return true;
        }
        if (action instanceof FontSizeChangedAction) {
            return true;
        }
        if (action instanceof BottomBarHeightChange) {
            return true;
        }
        if (action instanceof ActivityAnimation) {
            return true;
        }
        if (action instanceof WindowFocusChanged) {
            return true;
        }
        if (action instanceof ScrollStateChanged) {
            return true;
        }
        if (action instanceof EventBusAction) {
            return true;
        }
        if (action instanceof UpdateFlowStyle) {
            return true;
        }
        if (action instanceof VideoViewCoveredChanged) {
            return true;
        }
        if (action instanceof VideoViewCoveredDetail) {
            return true;
        }
        if (action instanceof IAdFlowAction) {
            return true;
        }
        if (action instanceof ItemShowAction) {
            return true;
        }
        if (action instanceof LeftSlideAction) {
            return true;
        }
        if (action instanceof NightModeChanged) {
            return true;
        }
        if (action instanceof PayAction.PayPanelResult) {
            return true;
        }
        if (action instanceof PayAction.PaySuccess) {
            return true;
        }
        if (action instanceof DataChannelAction.SyncOuterAction) {
            return true;
        }
        if (action instanceof RefreshClarityList) {
            return true;
        }
        if (action instanceof FoldScreenFoldStateChanged) {
            return true;
        }
        if (action instanceof FoldScreenExpandOrientationChanged) {
            return true;
        }
        if (action instanceof FoldScreenSizeChanged) {
            return true;
        }
        if ((action instanceof PadColumnPanelVisibleChangedAction) || (action instanceof CollectionPanelAction.CollectionPanelVisibleChangedAction) || (action instanceof BaikePanelAction.CollectionPanelVisibleChangedAction) || (action instanceof ShortPlayPanelAction.ShortPlayPanelVisibleChangedAction)) {
            return false;
        }
        if (action instanceof LandscapeHomeMiddlePanelAction.PanelVisibleChangedAction) {
            return true;
        }
        if (action instanceof LandscapeRelatedRecommendPanelAction.PanelVisibleChangedAction) {
            return true;
        }
        if (action instanceof CollectionPanelAction.QueryCollectionFavorAction) {
            return true;
        }
        if (action instanceof ShortPlayPanelAction.QueryShortPlayFavorAction) {
            return true;
        }
        if (action instanceof CollectionPanelAction.CollectionFavorShowAction) {
            return true;
        }
        if (action instanceof CollectionPanelAction.CollectionFavorClickAction) {
            return true;
        }
        if (action instanceof ShortPlayPanelAction.ShortPlayFavorClickAction) {
            return true;
        }
        if (action instanceof LeftSlideAction.DrawerOpenedAction) {
            return true;
        }
        if (action instanceof LeftSlideAction.DrawerClosedAction) {
            return true;
        }
        if (action instanceof OnAudioFocusChangeAction) {
            return true;
        }
        if (action instanceof DispatchTouchDownEvent) {
            return true;
        }
        if (action instanceof DispatchTouchUpEvent) {
            return true;
        }
        if (action instanceof FlowListViewTranslationChanged) {
            return true;
        }
        if (action instanceof FlowListViewDragRelease) {
            return true;
        }
        if (action instanceof AirPlayMenuBtnClick) {
            return true;
        }
        if (action instanceof AirPlayIconClick) {
            return true;
        }
        if (action instanceof FlowOfflineCacheAction.BufferBlockAction) {
            return true;
        }
        if (action instanceof FlowOfflineCacheAction.InsertCacheDataAction) {
            return true;
        }
        if (action instanceof HideFloatingBadgeAction) {
            return true;
        }
        if (action instanceof FlowDetailDataUpdate) {
            return true;
        }
        if (action instanceof SyncLastCollectionAction) {
            return true;
        }
        if (action instanceof OnPortraitOrLandscapeScrollUpGuideVisibleChangedAction) {
            return true;
        }
        if (action instanceof UpdateItemIntelligentFillScreenStatus) {
            return true;
        }
        if (action instanceof AuthorAction.SyncOutFollowStatus) {
            return true;
        }
        if (action instanceof OnPanelSlideStartAction) {
            return true;
        }
        if (action instanceof OnPanelSlideCloseAction) {
            return true;
        }
        if (action instanceof BottomBarBarrageIconClickedAction) {
            return true;
        }
        if (action instanceof HotCommentBtnClickAction) {
            return true;
        }
        if (action instanceof BatchCardAction.ShowScrollGuideAction) {
            return true;
        }
        if (action instanceof TabComponentAction.OnTabScrollStateChanged) {
            return true;
        }
        if (action instanceof TabComponentAction.UpdateCurrentTabInfo) {
            return true;
        }
        if (action instanceof TabComponentAction.OnTabSelectedAction) {
            return true;
        }
        if (action instanceof AutoPlaySwitchClick) {
            return true;
        }
        if (action instanceof AIPlaySwitchClick) {
            return true;
        }
        if (action instanceof PlayModeAction.OnPlayModeChanged) {
            return true;
        }
        if (action instanceof AutoPlaySwitchShowAction) {
            return true;
        }
        if (action instanceof FloatingMenuBtnClick) {
            return true;
        }
        if (action instanceof OnSlideReleaseFloatingBtnSelectedAction) {
            return true;
        }
        if (action instanceof OnFloatingBtnSelectedAndPageCloseAction) {
            return true;
        }
        if (action instanceof UserVisibleHint) {
            return true;
        }
        if (action instanceof ClearAllData) {
            return true;
        }
        if (action instanceof TabComponentAction.TryShowBubble) {
            return true;
        }
        if (action instanceof PullRefreshAction.OnUserStartPull) {
            return true;
        }
        if (action instanceof PullRefreshAction.OnRefreshStartForItem) {
            return true;
        }
        if (action instanceof PullRefreshAction.OnRefreshCompleteForItem) {
            return true;
        }
        if (action instanceof PullRefreshAction.OnRefreshSuccess) {
            return true;
        }
        if (action instanceof TopExpandableAction.ExpandStart) {
            return true;
        }
        if (action instanceof TopExpandableAction.CollapseStart) {
            return true;
        }
        if (action instanceof MultiWindowModeChanged) {
            return true;
        }
        if (action instanceof OnSizeChangedInMultiWindowMode) {
            return true;
        }
        if (action instanceof UpdateIntentData) {
            return true;
        }
        if (action instanceof VideoItemContainerAction.DetachFromScreen) {
            return true;
        }
        if (action instanceof VideoSettingsMenuBtnClick) {
            return true;
        }
        if (action instanceof VideoLabelPanelVisibleChangedAction) {
            return true;
        }
        if (action instanceof HalfScreenViewSwanAction.Load) {
            return true;
        }
        if (action instanceof HalfScreenViewSwanAction.OnHideAnim) {
            return true;
        }
        if (action instanceof HalfScreenViewSwanAction.OnHalfScreen) {
            return true;
        }
        if (action instanceof HalfScreenViewSwanAction.OnFullScreen) {
            return true;
        }
        if (action instanceof HalfScreenViewSwanAction.OnScreenClose) {
            return true;
        }
        if (action instanceof PageScaleAction.OnPageScale) {
            return true;
        }
        if (action instanceof OnRelatedVideoItemInsertedAction) {
            return true;
        }
        if (action instanceof CommonCommentAction.OnBarrageResult) {
            return true;
        }
        if (action instanceof CommonCommentAction.ShowBarrageInputPanel) {
            return true;
        }
        if (action instanceof BottomBarBarrageInputShowAction) {
            return true;
        }
        if (action instanceof BottomBarBarrageInputClickAction) {
            return true;
        }
        if (action instanceof BottomBarBarrageInputEmojiClickAction) {
            return true;
        }
        if (action instanceof BottomBarBarragePresetTextShowAction) {
            return true;
        }
        if (action instanceof BottomBarBarrageSendButtonClickAction) {
            return true;
        }
        if (action instanceof BottomBarBarrageSendButtonShowAction) {
            return true;
        }
        if (action instanceof TabComponentAction.OnTabStyleUpdate) {
            return true;
        }
        if (action instanceof VoicePanelAction.OnVoicePanelVisibleChange) {
            return true;
        }
        if (action instanceof AssessBigTalosAction.AssessmentDataChannelAction) {
            return true;
        }
        if (action instanceof OnLaunchSettingPanelHideAction) {
            return true;
        }
        if (action instanceof OnLaunchSettingPanelShowAction) {
            return true;
        }
        if (action instanceof OnLaunchSettingPanelClickSetAction) {
            return true;
        }
        if (action instanceof OnSearchBoxStyleChangeActon) {
            return true;
        }
        if (action instanceof DisEnableSensor) {
            return true;
        }
        if (action instanceof GuessLikeAction.GuessLikeDataChannelAction) {
            return true;
        }
        if (action instanceof ProgressGuideShow) {
            return true;
        }
        if (action instanceof LiveRealContainerAction.LiveRealObtainActAction) {
            return true;
        }
        if (action instanceof ChannelBarTabClick) {
            return true;
        }
        if (action instanceof ChannelDetainmentAction.ChannelDetainmentRefreshAction) {
            return true;
        }
        if (action instanceof ChannelDetainmentAction.ChannelDetainmentScrollAction) {
            return true;
        }
        if (action instanceof ChannelDetainmentAction.ChannelDetainmentInsertBetterItemAction) {
            return true;
        }
        if (action instanceof TabComponentAction.OnTabReselectAction) {
            return true;
        }
        if (action instanceof ClearScreenBottomAction) {
            return true;
        }
        if (action instanceof ClearScreenNewAction.OnClearScreenChanged) {
            return true;
        }
        if (action instanceof ClearScreenNewAction.OnClearScreenInterceptAutoPlay) {
            return true;
        }
        if (action instanceof TabComponentAction.ChangeSecondaryTabPanelVisibleAction) {
            return true;
        }
        if (action instanceof RelatedSearchPanelAction.RollBackToPositionAction) {
            return true;
        }
        if (action instanceof ShowLongPressNewGuide) {
            return true;
        }
        if (action instanceof UpdateOtherVideoPraiseAction) {
            return true;
        }
        if (action instanceof OnShowBarrageSettingEntryAction) {
            return true;
        }
        if (action instanceof ClickBarrageSettingEntryAction) {
            return true;
        }
        if (action instanceof AuthorWorkDoubleClickAction) {
            return true;
        }
        if (action instanceof OnAuthorWorkPlayBtnClick) {
            return true;
        }
        if (action instanceof OnAuthorWorkSpeedBtnClick) {
            return true;
        }
        if (action instanceof OnAuthorWorksEnterHomePage) {
            return true;
        }
        if (action instanceof OnAuthorWorksStatusChange) {
            return true;
        }
        if (action instanceof RefreshOutSpeedAction) {
            return true;
        }
        if (action instanceof SecondJumpLeaveChanelVideo) {
            return true;
        }
        if (action instanceof WindowMovingUpAction.WindonMovingUpLeaveChanelVideo) {
            return true;
        }
        if (action instanceof ChannelDetainmentAction.ChannelDetainmentLeaveChanelVideo) {
            return true;
        }
        if (action instanceof ChannelDetainmentAction.ResetDetainmentNumber) {
            return true;
        }
        if (action instanceof HideGuideByOpt) {
            return true;
        }
        if (action instanceof AutoPlaySwitchGuideShowOrHide) {
            return true;
        }
        if (action instanceof DetainmentLeaveUpdateExitTimeAction) {
            return true;
        }
        if (action instanceof ShowAuthorHomeVideoAuthorFollowButtonGuide) {
            return true;
        }
        if (action instanceof ShowAuthorHomeVideoFollowGuide) {
            return true;
        }
        if (action instanceof FastSlideAction) {
            return true;
        }
        if (action instanceof OnWealthTaskDialogStatusChange) {
            return true;
        }
        if (action instanceof FlowTaskAction.OnPlayletTaskOperationDialogStatusChange) {
            return true;
        }
        if (action instanceof BottomBarrageGuideShowAction) {
            return true;
        }
        if (action instanceof FirstJumpSwitchTipConfigChanged) {
            return true;
        }
        if (action instanceof ReportClickedAction) {
            return true;
        }
        if (action instanceof QuickSlideStateChange) {
            return true;
        }
        if (action instanceof OnCurItemUpdated) {
            return true;
        }
        if (action instanceof NextDetailModelDispatchSuccess) {
            return true;
        }
        if (action instanceof ClearScreenNewAction.UpdateFullPlayerProgress) {
            return true;
        }
        if (action instanceof ClearScreenNewCollectionAction.ReplaceSingleData) {
            return true;
        }
        if (action instanceof UploadFullPlayBtnShowStatisticInClearScreen) {
            return true;
        }
        if (action instanceof WatchAdCompleteAction) {
            return true;
        }
        if (action instanceof ShortPlayAutoUnlockAllAction) {
            return true;
        }
        if (action instanceof OnTalosPanelVisibleChange) {
            return true;
        }
        if (action instanceof TransChallengeAction) {
            return true;
        }
        if (action instanceof ShowAuditPanelAction) {
            return true;
        }
        if (action instanceof VideoEditAction) {
            return true;
        }
        if (action instanceof VideoDeleteAction) {
            return true;
        }
        if (action instanceof RecommendNextEntryClickAction) {
            return true;
        }
        if (action instanceof RecommendNextEntryShowAction) {
            return true;
        }
        if (action instanceof RecommendNextHalfShowAction) {
            return true;
        }
        if (action instanceof AttitudeAction.OnAttitudeShownAction) {
            return true;
        }
        if (action instanceof AttitudeAction.OnAttitudeItemClickAction) {
            return true;
        }
        if (action instanceof ChangeQueryAction.OnChangeQueryShownAction) {
            return true;
        }
        if (action instanceof ChangeQueryAction.OnChangeQueryItemClickAction) {
            return true;
        }
        if (action instanceof SearchRecommendDataAction.RequestListData) {
            return true;
        }
        if (action instanceof RelatedSearchPanelAction.UpdatePanelHeaderData) {
            return true;
        }
        if (action instanceof DragAnimationStart) {
            return true;
        }
        if (action instanceof ImageSearchTakeSnapshot) {
            return true;
        }
        if (action instanceof ShowScaleGestureGuideAction) {
            return true;
        }
        if (action instanceof TryShowTTSToastAction) {
            return true;
        }
        if (action instanceof ShowDoubleClickPraiseMaskGuideAction) {
            return true;
        }
        if (action instanceof InvokeComboPraise) {
            return true;
        }
        if (action instanceof UpdatePlayerUbcContentAction) {
            return true;
        }
        if (action instanceof UpdateLandCommentText) {
            return true;
        }
        if (action instanceof OnPlayerReuseTransitionAnimEnd) {
            return true;
        }
        if (action instanceof BottomNextRecommendCloseBtnClick) {
            return true;
        }
        if (action instanceof ShortPlayAutoUnlockAllUpdateDataAction) {
            return true;
        }
        if (action instanceof OnToolBarItemListUpdate) {
            return true;
        }
        if (action instanceof AiCharacterBarrageAction.OnGuideShownAction) {
            return true;
        }
        if (action instanceof AiCharacterBarrageAction.OnGuideClickAction) {
            return true;
        }
        if (action instanceof AiCharacterBarrageAction.ShowGuideAction) {
            return true;
        }
        if (action instanceof TheaterTopContainerAction.ShowTheaterFirstITemComponent) {
            return true;
        }
        if (action instanceof TheaterTopContainerAction.HideTheaterFirstITemComponent) {
            return true;
        }
        if (action instanceof TalosItemAction.TalosItemDataUpdate) {
            return true;
        }
        if (action instanceof SearchSlideBack) {
            return true;
        }
        if (action instanceof SearchOnKeyPressedBack) {
            return true;
        }
        if (action instanceof RefuseListDataAndToastAction) {
            return true;
        }
        if (action instanceof AcceptListDataAction) {
            return true;
        }
        if (action instanceof OnFlowResponseForItemAction) {
            return true;
        }
        if (action instanceof ShowFavorBottomToastAction) {
            return true;
        }
        if (action instanceof TryCalculateBannerDismissFreqAction) {
            return true;
        }
        if (action instanceof InvokeShortPlayPayPanel) {
            return true;
        }
        if (action instanceof ScrollToNextAndRemoveAction) {
            return true;
        }
        if (action instanceof ScrollToNextAfterReplaceList) {
            return true;
        }
        if (action instanceof BottomCommentIconClickAction) {
            return true;
        }
        if (action instanceof BottomPraiseButtonClickAction) {
            return true;
        }
        if (action instanceof BottomFavorIconClickAction) {
            return true;
        }
        if (action instanceof BottomFavorIconLongClickAction) {
            return true;
        }
        if (action instanceof BindBottomInteractDataAction) {
            return true;
        }
        if (action instanceof BottomShareBtnClickAction) {
            return true;
        }
        if (action instanceof QueryFavorAction) {
            return true;
        }
        if (action instanceof CollectionFavorUpdateAction) {
            return true;
        }
        if (action instanceof ListRefreshCompleteUpdateItemUIAction) {
            return true;
        }
        if (action instanceof PinchSummaryGuideAction) {
            return true;
        }
        if (action instanceof ConfigurationChangedAction) {
            return true;
        }
        if (action instanceof ScrollToCollectionSetsAdErrorAction) {
            return true;
        }
        if (action instanceof OnItemRemoveCompleteAction) {
            return true;
        }
        if (action instanceof AICommentAction) {
            return true;
        }
        if (action instanceof AiCommentBubbleGuideAction) {
            return true;
        }
        if (action instanceof BarrageIconEntranceClickAction) {
            return true;
        }
        if (action instanceof ClearScreenNewAction.EnterClearScreen) {
            return true;
        }
        return false;
    }

    public boolean deliver(Action action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof OnFlowNestedPageSelectedBeforeToTab) {
            return true;
        }
        if (action instanceof MoreFlowAction) {
            return true;
        }
        if (action instanceof SummaryFullScreenUnFoldAnimationStartAction) {
            return true;
        }
        if (action instanceof SummaryFullScreenFoldAnimationEndAction) {
            return true;
        }
        if (action instanceof CommentDraftChangeAction) {
            return true;
        }
        if (action instanceof SearchMarkFlowAction.OnNetSuccess) {
            return true;
        }
        if (action instanceof SearchMarkFlowAction.OnSwitchBoxFail) {
            return true;
        }
        if (action instanceof SearchMarkFlowAction.OnStaticItemSelect) {
            return true;
        }
        if (action instanceof SearchMarkFlowAction.SearchModelData) {
            return true;
        }
        if (action instanceof SearchMarkFlowAction.SwitchVisible) {
            return true;
        }
        if (action instanceof SearchMarkFlowAction.SwitchEnable) {
            return true;
        }
        if (action instanceof UserDragSeekBarStart) {
            return true;
        }
        if (action instanceof UserDragSeekBarEnd) {
            return true;
        }
        if (action instanceof OfflineFlowAction.OnNetSuccess) {
            return true;
        }
        if (action instanceof BottomBarReducerAdapterAction) {
            return true;
        }
        if (action instanceof OnOfflineTimerTaskCompleted) {
            return true;
        }
        if (action instanceof OnOfflineNotActive) {
            return true;
        }
        if (action instanceof PlayerComplete) {
            return true;
        }
        if (action instanceof PlayerStatusChangedAction) {
            return true;
        }
        if (action instanceof PlayerLoop) {
            return true;
        }
        if (action instanceof PlayerStop) {
            return true;
        }
        if (action instanceof RecommendNextContentDetailSuccess) {
            return true;
        }
        if (action instanceof PlayerResume) {
            return true;
        }
        if (action instanceof PlayerStart) {
            return true;
        }
        if (action instanceof PlayerPause) {
            return true;
        }
        if (action instanceof PlayerClipCompleteAction) {
            return true;
        }
        if (action instanceof OnShowAutoPlayTip) {
            return true;
        }
        if (action instanceof OnVulcanAutoplayClicked) {
            return true;
        }
        if (action instanceof LongPressMoreAutoPlayChangedAction) {
            return true;
        }
        if (action instanceof VideoSettingsAutoPlayChangedAction) {
            return true;
        }
        if (action instanceof OnChannelAIPlayGuideClickAction) {
            return true;
        }
        if (action instanceof VideoSettingsAIPlayClickedAction) {
            return true;
        }
        if (action instanceof LongPressMoreAIPlayClickAction) {
            return true;
        }
        if (action instanceof OnVulcanAIPlayClicked) {
            return true;
        }
        if (action instanceof AutoPlayAction.OnPlayNext) {
            return true;
        }
        if (action instanceof OnAutoplaySwitchStateChanged) {
            return true;
        }
        if (action instanceof OnSwitchTipClicked) {
            return true;
        }
        if (action instanceof OnSwitchTipTimerComplete) {
            return true;
        }
        if (action instanceof OnSwitchTipCancel) {
            return true;
        }
        if (action instanceof OnVerticalSwitchTipHide) {
            return true;
        }
        if (action instanceof OnLandSwitchTipChange) {
            return true;
        }
        if (action instanceof OnVerticalSwitchTipShow) {
            return true;
        }
        if (action instanceof OnVerticalSwitchTipShowForStatistic) {
            return true;
        }
        if (action instanceof OnSwitchBgClick) {
            return true;
        }
        if (action instanceof DetainmentLeavePageAction) {
            return true;
        }
        if (action instanceof OnNextContentTipClicked) {
            return true;
        }
        if (action instanceof OnLandNextGuideClicked) {
            return true;
        }
        if (action instanceof OnVulcanMoreTipChanged) {
            return true;
        }
        if (action instanceof StoreGenTitleInfo) {
            return true;
        }
        if (action instanceof CollectionContinueDataUpdate) {
            return true;
        }
        if (action instanceof OnSeamlessPlayEnd) {
            return true;
        }
        if (action instanceof InvokeSeamlessTCUpLog) {
            return true;
        }
        if (action instanceof RouterAction) {
            return true;
        }
        if (action instanceof ExcAction) {
            return true;
        }
        if (action instanceof ToastAction) {
            return true;
        }
        if (action instanceof LongPressMoreClearScreenClickAction) {
            return true;
        }
        if (Intrinsics.areEqual((Object) action, (Object) LongPressMoreAirPlayClickAction.INSTANCE)) {
            return true;
        }
        if (action instanceof LinkageAction) {
            return true;
        }
        if (action instanceof WindowMovingUpAction.WindowMovingUpClickAction) {
            return true;
        }
        if (action instanceof WindowMovingUpAction.WindowMovingUpShowAction) {
            return true;
        }
        if (action instanceof WindowMovingUpAction.WindowMovingUpShowAndHideOtherViewAction) {
            return true;
        }
        if (action instanceof WindowMovingUpAction.DownAction) {
            return true;
        }
        if (action instanceof WindowMovingUpAction.ShowVideoCacheGuideGuide) {
            return true;
        }
        if (action instanceof WindowMovingUpAction.WindowMovingUpHideByClickOutside) {
            return true;
        }
        if (action instanceof PlayerOrientationChanged) {
            return true;
        }
        if (action instanceof AuthorAction.AuthorProfileCmdAction) {
            return true;
        }
        if (action instanceof AuthorAction.AvatarClickAction) {
            return true;
        }
        if (action instanceof SummaryAuthorNicknameAction) {
            return true;
        }
        if (action instanceof DataChannelAction.SyncInnerAction) {
            return true;
        }
        if (action instanceof PlayerFirstFrame) {
            return true;
        }
        if (action instanceof PlayerStart) {
            return true;
        }
        if (action instanceof PlayerError) {
            return true;
        }
        if (action instanceof FirstJumpPlayerFirstFrame) {
            return true;
        }
        if (action instanceof PlayerVolumeChangedAction) {
            return true;
        }
        if (action instanceof PlayModeAction.OnPlayModeChanged) {
            return false;
        }
        if (action instanceof PlayerClarityChanged) {
            return true;
        }
        if (action instanceof SpeedPanelOnlyCurVideoSwitchAction) {
            return true;
        }
        if (action instanceof SpeedPanelSwitchAction) {
            return true;
        }
        if (action instanceof LongPressMoreSpeedClickAction) {
            return true;
        }
        if (action instanceof OnSpeedOutClickedAction) {
            return true;
        }
        if (action instanceof RemoveItemAction) {
            return true;
        }
        if (action instanceof RemoveNotDisplayItemsAction) {
            return true;
        }
        if (action instanceof OnCarouselPicTwoFingerPressEnd) {
            return true;
        }
        if (action instanceof OnCarouselPicMultipleGestureEnd) {
            return true;
        }
        if (action instanceof OnCarouselPicScaleEnd) {
            return true;
        }
        if (action instanceof OnCarouselPicDoubleTap) {
            return true;
        }
        if (action instanceof DynamicBgmActionManifest.OnBgmStatusChangedAction) {
            return true;
        }
        if (action instanceof AssessmentCardAction.ForbidLeftSlideOpen) {
            return true;
        }
        if (action instanceof AssessmentCardAction.SwitchLeftSlideAction) {
            return true;
        }
        if (action instanceof BatchCardAction.ForbidLeftSlideOpen) {
            return true;
        }
        if (action instanceof BatchCardAction.SwitchLeftSlideAction) {
            return true;
        }
        if (action instanceof GuessLikeAction.ForbidLeftSlideOpen) {
            return true;
        }
        if (action instanceof GuessLikeAction.SwitchLeftSlideAction) {
            return true;
        }
        if (action instanceof InsertGuessLikeItemAction) {
            return true;
        }
        if (action instanceof InsertPersonalizedItemAction) {
            return true;
        }
        if (action instanceof GuessLikeAction.InsertGuessLikeVideoModel) {
            return true;
        }
        if (action instanceof InsertQuerySpecialCardItemAction) {
            return true;
        }
        if (action instanceof ShareClickUninterestedAction) {
            return true;
        }
        if (action instanceof LandscapeFoldAction.OnViewClick) {
            return true;
        }
        if (action instanceof NetErrorRetryAction) {
            return true;
        }
        if (action instanceof UpdateSingleDataAction) {
            return true;
        }
        if (action instanceof UpdateSingleDataBySameNidAction) {
            return true;
        }
        if (action instanceof RefreshItemByPositionAction) {
            return true;
        }
        if (action instanceof CollectionPanelAction.ItemClickAction) {
            return true;
        }
        if (action instanceof LandscapeHomeMiddlePanelAction.ItemClickAction) {
            return true;
        }
        if (action instanceof LandscapeRelatedRecommendPanelAction.ItemClickAction) {
            return true;
        }
        if (action instanceof LandscapeRelatedRecommendPanelAction.InsertRelatedRecommendDataAction) {
            return true;
        }
        if (action instanceof CollectionPanelAction.CollectionFavorDataAction) {
            return true;
        }
        if (action instanceof ShortPlayPanelAction.ShortPlayFavorDataAction) {
            return true;
        }
        if (action instanceof LongPressSpeedAnim) {
            return true;
        }
        if (action instanceof UpdateDetailDataSuccess) {
            return true;
        }
        if (action instanceof RequestAudioFocusAction) {
            return true;
        }
        if (action instanceof PlayerEnterTransitionAnimAction) {
            return true;
        }
        if (action instanceof ChangePageMuteMode) {
            return true;
        }
        if (action instanceof SmoothScrollAction) {
            return true;
        }
        if (action instanceof ScrollToPositionAction) {
            return true;
        }
        if (action instanceof BatchCardAction.OnBatchConsume) {
            return true;
        }
        if (action instanceof ShowTipAction) {
            return true;
        }
        if (action instanceof RemoveInterestAction) {
            return true;
        }
        if (action instanceof VideoItemDurationAction) {
            return true;
        }
        if (action instanceof GuessLikeVideoItemDurationAction) {
            return true;
        }
        if (action instanceof FlowRequestWithInterestTags) {
            return true;
        }
        if (action instanceof ClearListDataAfterCurrent) {
            return true;
        }
        if (action instanceof ClearListDataAfterCurrentSync) {
            return true;
        }
        if (action instanceof InterestAction.InterestShownAction) {
            return true;
        }
        if (action instanceof InterestAction.ForbidLeftSlideOpen) {
            return true;
        }
        if (action instanceof InterestAction.SwitchLeftSlideAction) {
            return true;
        }
        if (action instanceof PlayerVulcanAirPlayBtnClick) {
            return true;
        }
        if (action instanceof OnPlayerFloatingBtnClickedAction) {
            return true;
        }
        if (action instanceof AirPlayStatusChange) {
            return true;
        }
        if (action instanceof PlayerAirPlayLayerVisibleChanged) {
            return true;
        }
        if (action instanceof FavorBackAction) {
            return true;
        }
        if (action instanceof RecordCollectionAction) {
            return true;
        }
        if (action instanceof SyncCollectionIdAction) {
            return true;
        }
        if (action instanceof OnDownloadBegin) {
            return true;
        }
        if (action instanceof OnCopyUrlSuccess) {
            return true;
        }
        if (action instanceof OnFavorStatusChangeByUser) {
            return true;
        }
        if (action instanceof VideoDownloadSuccess) {
            return true;
        }
        if (action instanceof AirPlayComplete) {
            return true;
        }
        if (action instanceof OnSubscribeStateChange) {
            return true;
        }
        if (action instanceof SubscribeDialogClickAction) {
            return true;
        }
        if (action instanceof UpdateColdLaunchRestoreScheme) {
            return true;
        }
        if (action instanceof OnVulcanThreeDivideGuideClickedAction) {
            return true;
        }
        if (action instanceof OnVulcanThreeDivideGuideVisibleChangedAction) {
            return true;
        }
        if (action instanceof UploadShowClickAction) {
            return true;
        }
        if (action instanceof OnCollContinuePlayNextRenderSuccess) {
            return true;
        }
        if (action instanceof OnIntelligentFillScreenStatusChange) {
            return true;
        }
        if (action instanceof AuthorAction.UpdateAllItemFollowStatus) {
            return true;
        }
        if (action instanceof OnPlayerPreRenderSuccess) {
            return true;
        }
        if (action instanceof InvokeHideAutoPlayBottomGuide) {
            return true;
        }
        if (action instanceof InnerHideTabBubbleGuide) {
            return true;
        }
        if (action instanceof BarrageDisableAction) {
            return true;
        }
        if (action instanceof PlayerBarrageButtonClick) {
            return true;
        }
        if (action instanceof OnOutSideStartAutoPlay) {
            return true;
        }
        if (action instanceof AttentionToRecGuideAction.OnClick) {
            return true;
        }
        if (action instanceof FlowEmptyClickAction) {
            return true;
        }
        if (action instanceof BatchCardAction.OnExecFollow) {
            return true;
        }
        if (action instanceof CommonCommentAction.OnPanelVisibleChanged) {
            return true;
        }
        if (action instanceof PlayerSpeedChanged) {
            return true;
        }
        if (action instanceof OnPlayerSpeedChanged) {
            return true;
        }
        if (action instanceof DetailItemSelected) {
            return true;
        }
        if (action instanceof DetailItemDetachFromScreen) {
            return true;
        }
        if (action instanceof PlayerTouchBeginGestureAction) {
            return true;
        }
        if (action instanceof PlayerScaleGestureAction) {
            return true;
        }
        if (action instanceof PlayerTouchEndGestureAction) {
            return true;
        }
        if (action instanceof BatchCardAction.BatchCardDetach) {
            return true;
        }
        if (action instanceof BatchCardAction.OnCardInActive) {
            return true;
        }
        if (action instanceof BatchCardAction.OnBatchCardShow) {
            return true;
        }
        if (action instanceof BottomAssessAction.AssessmentNegativeItemClick) {
            return true;
        }
        if (action instanceof LongPressMenuItemAction) {
            return true;
        }
        if (action instanceof CollectionPosterListAction.ItemClickAction) {
            return true;
        }
        if (action instanceof CollectionSelectSetsAction.OnCollectionNextButtonClick) {
            return true;
        }
        if (action instanceof CollectionSelectSetsAction.TryInsertCollectionAdAction) {
            return true;
        }
        if (action instanceof TabComponentAction.UpdateTabScrollEnable) {
            return true;
        }
        if (action instanceof UpdateCollectionNextData) {
            return true;
        }
        if (action instanceof AssessmentCardAction.OnAssessmentRemoveAction) {
            return true;
        }
        if (action instanceof LiveRealContainerAction.LiveRealScrollToNextAndRemoveCurAction) {
            return true;
        }
        if (action instanceof LiveRealContainerAction.LiveRealOnlyScrollToNextAction) {
            return true;
        }
        if (action instanceof LiveRealContainerAction.LiveRealLiveEndAction) {
            return true;
        }
        if (action instanceof OnShowLongPressMenuAction) {
            return true;
        }
        if (action instanceof OnHideLongPressMenuAction) {
            return true;
        }
        if (action instanceof MoreMenuNewPanelVisibleChangedAction) {
            return true;
        }
        if (action instanceof DislikeNewPanelVisibleChangedAction) {
            return true;
        }
        if (action instanceof OnOneToNShownAction) {
            return true;
        }
        if (action instanceof OnOneToNHiddenAction) {
            return true;
        }
        if (action instanceof OnFollowPaymentSubscribePanelHide) {
            return true;
        }
        if (action instanceof OnFollowPaymentSubscribePanelShow) {
            return true;
        }
        if (action instanceof FlowSaveCacheAction) {
            return true;
        }
        if (action instanceof BackFromFloating) {
            return true;
        }
        if (action instanceof BackFromAutoModeFloating) {
            return true;
        }
        if (action instanceof OnRequestActionConsumer) {
            return true;
        }
        if (action instanceof PullRefreshAction.OnRefreshStart) {
            return true;
        }
        if (action instanceof PlayerSeekBarStart) {
            return true;
        }
        if (action instanceof TopEntranceAction.Click) {
            return true;
        }
        if (action instanceof PayAction.PayClickAction) {
            return true;
        }
        if (action instanceof PayAction.CancelPayment) {
            return true;
        }
        if (action instanceof VideoLabelPanelAction.ShowVideoLabelPanel) {
            return true;
        }
        if (action instanceof OfflineVisibleChanged) {
            return true;
        }
        if (action instanceof PlayerTriggerStartAction) {
            return true;
        }
        if (action instanceof PlayerMutePropertyChanged) {
            return true;
        }
        if (action instanceof OnKernelPivotResetAction) {
            return true;
        }
        if (action instanceof VideoSettingsMuteChangedAction) {
            return true;
        }
        if (action instanceof LongPressMoreMuteChangedAction) {
            return true;
        }
        if (action instanceof ListPanelVisibleChangeAction) {
            return true;
        }
        if (action instanceof TalosPanelAction.TalosPanelVisibleChangeAction) {
            return true;
        }
        if (action instanceof SubscribeLastFrameShownAction) {
            return true;
        }
        if (action instanceof SubscribeLastFrameReplayClickAction) {
            return true;
        }
        if (action instanceof DataChannelAction.SendAction) {
            return true;
        }
        if (action instanceof ChatroomAction.ShowPanel) {
            return true;
        }
        if (action instanceof ChatroomAction.HidePanel) {
            return true;
        }
        if (action instanceof ChangeGlobalMuteVisibleWithAnimAction) {
            return true;
        }
        if (action instanceof MoveUpAnimSwitchAction) {
            return true;
        }
        if (action instanceof SevenDayUnScrollUpStartGuideAction) {
            return true;
        }
        if (action instanceof OneKeyTripleAnimatorStartAction) {
            return true;
        }
        if (action instanceof OneKeyTripleAnimatorEndAction) {
            return true;
        }
        if (action instanceof OnFlowRequestAction) {
            return true;
        }
        if (action instanceof OnFlowResponseAction) {
            return true;
        }
        if (action instanceof BannerAction.BannerClickAction) {
            return true;
        }
        if (action instanceof ListPanelItemClickAction) {
            return true;
        }
        if (action instanceof LandscapeListPanelItemClickAction) {
            return true;
        }
        if (action instanceof TalosPanelAction.TalosPanelLoadHalfSwanAction) {
            return true;
        }
        if (action instanceof AutoPopupBigBannerItemClickAction) {
            return true;
        }
        if (action instanceof LongPressMoreListenVideoClick) {
            return true;
        }
        if (action instanceof SeekBarAwakeAction) {
            return true;
        }
        if (action instanceof InsertRelatedVideoToNextPositionAction) {
            return true;
        }
        if (action instanceof RelatedPreviewPanelAction.InsertPreviewVideoToNextPositionAction) {
            return true;
        }
        if (action instanceof RelatedSearchPanelAction.InsertVideoAction) {
            return true;
        }
        if (action instanceof BarrageOpenAction) {
            return true;
        }
        if (action instanceof ScrollLeftSlide) {
            return true;
        }
        if (action instanceof DynamicScrollLeftSlide) {
            return true;
        }
        if (action instanceof GraphicGenreScrollLeftSlide) {
            return true;
        }
        if (action instanceof OnVideoDetachFromScreen) {
            return true;
        }
        if (action instanceof UpdateMoreStateConfig) {
            return true;
        }
        if (action instanceof OnFloatViewVisibleChangeAction) {
            return true;
        }
        if (action instanceof OnRetainDialogVisibleChangeAction) {
            return true;
        }
        if (action instanceof BarrageLoginSendAction) {
            return true;
        }
        if (action instanceof BarrageSuccessAction) {
            return true;
        }
        if (action instanceof PadColumnPanelVisibleChangedAction) {
            return true;
        }
        if (action instanceof CollectionPanelAction.CollectionPanelVisibleChangedAction) {
            return true;
        }
        if (action instanceof BaikePanelAction.CollectionPanelVisibleChangedAction) {
            return true;
        }
        if (action instanceof ShortPlayPanelAction.ShortPlayPanelVisibleChangedAction) {
            return true;
        }
        if (action instanceof RelatedSearchPanelAction.ShowRelatedSearchPanelAction) {
            return true;
        }
        if (action instanceof RelatedSearchPanelAction.HideRelatedSearchPanelAction) {
            return true;
        }
        if (action instanceof RelatedSearchPanelAction.OnPanelStatusChangeAction) {
            return true;
        }
        if (action instanceof RelatedSearchPanelAction.ScrollToNextAction) {
            return true;
        }
        if (action instanceof OcrSummaryAction.OcrSummaryPanelShowAction) {
            return true;
        }
        if (action instanceof OcrSummaryAction.OcrSummaryPanelHideAction) {
            return true;
        }
        if (action instanceof OcrSummaryAction.OnPanelStatusChanged) {
            return true;
        }
        if (action instanceof UninterestedAction) {
            return true;
        }
        if (action instanceof UninterestedShowAction) {
            return true;
        }
        if (action instanceof UninterestedClickedAction) {
            return true;
        }
        if (action instanceof ChangeLongPressMoreBarrageSwitchAction) {
            return true;
        }
        if (action instanceof LiveRealContainerAction.RealLiveTopAndBottomBarVisibleAction) {
            return true;
        }
        if (action instanceof TabComponentAction.ChangeViewPagerOverScrollMode) {
            return true;
        }
        if (action instanceof CompressionStartAction) {
            return true;
        }
        if (action instanceof CompressionEndAction) {
            return true;
        }
        if (action instanceof OnEmojiClickAction) {
            return true;
        }
        if (action instanceof OnBarrageButtonClickAction) {
            return true;
        }
        if (action instanceof UpdatePresetInputIndex) {
            return true;
        }
        if (action instanceof TopExpandableAction.CollapseStartToFirst) {
            return true;
        }
        if (action instanceof TopExpandableAction.ExpandStartToFirst) {
            return true;
        }
        if (action instanceof ComboPraiseAction) {
            return true;
        }
        if (action instanceof DefaultComboPraiseAction) {
            return true;
        }
        if (action instanceof PlayerResumeFormUser) {
            return true;
        }
        if (action instanceof PlayerPauseFormUser) {
            return true;
        }
        if (action instanceof UpdateOtherVideoPraiseTransAction) {
            return true;
        }
        if (action instanceof LongPressMoreMirrorChangedAction) {
            return true;
        }
        if (action instanceof ClaritySwitchAction) {
            return true;
        }
        if (action instanceof ResetMirrorAction) {
            return true;
        }
        if (action instanceof LongPressMoreCollectionSubscribeChangedAction) {
            return true;
        }
        if (action instanceof PlayerResumeFromCovered) {
            return true;
        }
        if (action instanceof RetryRequestListDataAction) {
            return true;
        }
        if (action instanceof CommonHistoryAction.InsertHistory) {
            return true;
        }
        if (action instanceof DetailModelDispatchSuccess) {
            return true;
        }
        if (action instanceof OnAuthorWorksStatusChange) {
            return false;
        }
        if (action instanceof AuthorWorksScrollLeftSlide) {
            return true;
        }
        if (action instanceof UpdateTipAction) {
            return true;
        }
        if (action instanceof SeamlessPlayChange) {
            return true;
        }
        if (action instanceof PaymentDetailPanelAction.EpisodesItemClick) {
            return true;
        }
        if (action instanceof DetainmentGuideShowAction) {
            return true;
        }
        if (action instanceof ScrollUpGuideLeaveChanelVideo) {
            return true;
        }
        if (action instanceof BarrageInputBarIconClickAction) {
            return true;
        }
        if (action instanceof AssessmentCardTimerComplete) {
            return true;
        }
        if (action instanceof TabComponentAction.SelectTab) {
            return true;
        }
        if (action instanceof PlayerHeadsetConnectChanged) {
            return true;
        }
        if (action instanceof HideTipAction) {
            return true;
        }
        if (action instanceof RecommendContentPanelAction.ShowRecommendPanelAction) {
            return true;
        }
        if (action instanceof RecommendContentPanelAction.HideRecommendPanelAction) {
            return true;
        }
        if (action instanceof LiveRealContainerAction.RealLiveControlFlowVerticalScroll) {
            return true;
        }
        if (action instanceof TopExpandableAction.CollapseEnd) {
            return true;
        }
        if (action instanceof TopExpandableAction.ExpandEnd) {
            return true;
        }
        if (action instanceof TalosItemAction.SwitchLeftSlideAction) {
            return true;
        }
        if (action instanceof TalosItemAction.ForbidLeftSlideOpen) {
            return true;
        }
        if (action instanceof TalosDialogAction.OnTalosDialogVisibleChange) {
            return true;
        }
        if (action instanceof PlayerFuncPanelVisibleChanged) {
            return true;
        }
        if (action instanceof OnDismissBarrageSettingPanelAction) {
            return true;
        }
        if (action instanceof OnGoodsBigBannerHiddenAction) {
            return true;
        }
        if (action instanceof SummaryFoldAction) {
            return true;
        }
        if (action instanceof LiveActivityHide) {
            return true;
        }
        if (action instanceof VideoSummaryListFoldAction) {
            return true;
        }
        if (action instanceof OnRelatedRecommendPanelHideToInterceptAction) {
            return true;
        }
        if (action instanceof RelatedPreviewPanelAction.RelatedPreviewPanelHideInterceptAction) {
            return true;
        }
        if (action instanceof WindowMovingUpAction.OnWindowMovingUpHideToInterceptAction) {
            return true;
        }
        if (action instanceof TabDiversionAction.OnTabDiversionVisibleChange) {
            return true;
        }
        if (action instanceof CommentEmojiPanelHide) {
            return true;
        }
        if (action instanceof ShortPlayGuideShowAction) {
            return true;
        }
        if (action instanceof NextBigCardAction.NextBigCardPanelShowOrHide) {
            return true;
        }
        if (action instanceof NextBigCardAction.OnClickPanelAreaAction) {
            return true;
        }
        if (action instanceof PaymentDetailPanelAction.ShowPaymentDetailPanelAction) {
            return true;
        }
        if (action instanceof PaymentDetailPanelAction.HidePaymentDetailPanelAction) {
            return true;
        }
        if (action instanceof ClickScrollToTargetPosition) {
            return true;
        }
        if (action instanceof ListenVideoClick) {
            return true;
        }
        if (action instanceof PublishChallenge) {
            return true;
        }
        if (action instanceof HideTTSToastHideInnerAction) {
            return true;
        }
        if (action instanceof OnItemStartFling) {
            return true;
        }
        if (action instanceof VideoSettingsFastModeClickedAction) {
            return true;
        }
        if (action instanceof LongPressMoreFastModeClickedAction) {
            return true;
        }
        if (action instanceof ShortPlayPaymentLoginSuccess) {
            return true;
        }
        if (action instanceof ResetCollectionPanelData) {
            return true;
        }
        if (action instanceof OnCarouselProgressBarStateChanged) {
            return true;
        }
        if (action instanceof CollectionPanelAction.HideCollectionPanelAction) {
            return true;
        }
        if (action instanceof CollectionRequestListData) {
            return true;
        }
        if (action instanceof UpdateLayoutAction) {
            return true;
        }
        if (action instanceof OnComponentManagerSwitch) {
            return true;
        }
        if (action instanceof OnLandCommentEmojiClick) {
            return true;
        }
        if (action instanceof OnLandCommentInputClick) {
            return true;
        }
        if (action instanceof OnPlayerSetDataSource) {
            return true;
        }
        if (action instanceof LongPressMenuItemClickAction) {
            return true;
        }
        if (action instanceof InsertModelByPersonal) {
            return true;
        }
        if (action instanceof OnMuteStateChange) {
            return true;
        }
        if (action instanceof OnLoadingStart) {
            return true;
        }
        if (action instanceof OnLoadingEnd) {
            return true;
        }
        if (action instanceof AiCharacterBarrageAction.GuideShouldShowAction) {
            return true;
        }
        if (action instanceof AiCharacterBarrageAction.ToHideGuideAction) {
            return true;
        }
        if (action instanceof TheaterTopContainerAction.OnPanelExtend) {
            return true;
        }
        if (action instanceof TheaterTopContainerAction.OnPanelCollapse) {
            return true;
        }
        if (action instanceof OnItemClickAction) {
            return true;
        }
        if (action instanceof QueryWordFetchCanceledAction) {
            return true;
        }
        if (action instanceof DynamicBgmActionManifest.DynamicFirstJumpPlayerFirstFrame) {
            return true;
        }
        if (action instanceof ClearListDataRetainCurrentAction) {
            return true;
        }
        if (action instanceof ShowSimpleToast) {
            return true;
        }
        if (action instanceof InsertSimilarCollectionVideoAction) {
            return true;
        }
        if (action instanceof CommentCountChangeAction) {
            return true;
        }
        if (action instanceof CommonCommentAction.UpdateData) {
            return true;
        }
        if (action instanceof BindBottomCommentData) {
            return true;
        }
        if (action instanceof PraiseViewStatusChangeAction) {
            return true;
        }
        if (action instanceof PraiseStatusChangeAction) {
            return true;
        }
        if (action instanceof OneKeyTripleUpdatePraiseAction) {
            return true;
        }
        if (action instanceof BindBottomPraiseData) {
            return true;
        }
        if (action instanceof BottomPraiseStatusChangeAction) {
            return true;
        }
        if (action instanceof FavorViewStatusChangeAction) {
            return true;
        }
        if (action instanceof FavorStateChangeAction) {
            return true;
        }
        if (action instanceof BindBottomFavorDataAction) {
            return true;
        }
        if (action instanceof BindBottomFavorDynamicDataAction) {
            return true;
        }
        if (action instanceof NetErrorVisibleChanged) {
            return true;
        }
        if (action instanceof ShortPlayVideoAction) {
            return true;
        }
        if (action instanceof SharePanelVisibleChangeAction) {
            return true;
        }
        if (action instanceof BindBottomShareDataAction) {
            return true;
        }
        if (action instanceof ShareSuccessAction) {
            return true;
        }
        if (action instanceof CollectionFavorTransUpdateAction) {
            return true;
        }
        if (action instanceof PinchSummaryClickAction) {
            return true;
        }
        if (action instanceof NotSupportGestureComponentVisibilityAction) {
            return true;
        }
        if (action instanceof PublishEnterEnable) {
            return true;
        }
        if (action instanceof OnLongPicBtnClick) {
            return true;
        }
        return false;
    }
}
