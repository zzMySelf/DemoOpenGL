package com.baidu.searchbox.gamecore.config.data.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006$"}, d2 = {"Lcom/baidu/searchbox/gamecore/config/data/model/GameCommonConfigData;", "", "guide", "Lcom/baidu/searchbox/gamecore/config/data/model/GameGuideData;", "gameguide", "Lcom/baidu/searchbox/gamecore/config/data/model/GameGuideDialogData;", "floatlayer", "Lcom/baidu/searchbox/gamecore/config/data/model/GameCenterFloatBallData;", "topfloatlayer", "(Lcom/baidu/searchbox/gamecore/config/data/model/GameGuideData;Lcom/baidu/searchbox/gamecore/config/data/model/GameGuideDialogData;Lcom/baidu/searchbox/gamecore/config/data/model/GameCenterFloatBallData;Lcom/baidu/searchbox/gamecore/config/data/model/GameCenterFloatBallData;)V", "getFloatlayer", "()Lcom/baidu/searchbox/gamecore/config/data/model/GameCenterFloatBallData;", "setFloatlayer", "(Lcom/baidu/searchbox/gamecore/config/data/model/GameCenterFloatBallData;)V", "getGameguide", "()Lcom/baidu/searchbox/gamecore/config/data/model/GameGuideDialogData;", "setGameguide", "(Lcom/baidu/searchbox/gamecore/config/data/model/GameGuideDialogData;)V", "getGuide", "()Lcom/baidu/searchbox/gamecore/config/data/model/GameGuideData;", "setGuide", "(Lcom/baidu/searchbox/gamecore/config/data/model/GameGuideData;)V", "getTopfloatlayer", "setTopfloatlayer", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-game-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameCommonConfigData.kt */
public final class GameCommonConfigData {
    @SerializedName("oldgamecenter_floatwindow")
    private GameCenterFloatBallData floatlayer;
    @SerializedName("screen_animation")
    private GameGuideDialogData gameguide;
    @SerializedName("oldgamecenter_guidewindow")
    private GameGuideData guide;
    @SerializedName("oldgamecenter_topfloatwindow")
    private GameCenterFloatBallData topfloatlayer;

    public static /* synthetic */ GameCommonConfigData copy$default(GameCommonConfigData gameCommonConfigData, GameGuideData gameGuideData, GameGuideDialogData gameGuideDialogData, GameCenterFloatBallData gameCenterFloatBallData, GameCenterFloatBallData gameCenterFloatBallData2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            gameGuideData = gameCommonConfigData.guide;
        }
        if ((i2 & 2) != 0) {
            gameGuideDialogData = gameCommonConfigData.gameguide;
        }
        if ((i2 & 4) != 0) {
            gameCenterFloatBallData = gameCommonConfigData.floatlayer;
        }
        if ((i2 & 8) != 0) {
            gameCenterFloatBallData2 = gameCommonConfigData.topfloatlayer;
        }
        return gameCommonConfigData.copy(gameGuideData, gameGuideDialogData, gameCenterFloatBallData, gameCenterFloatBallData2);
    }

    public final GameGuideData component1() {
        return this.guide;
    }

    public final GameGuideDialogData component2() {
        return this.gameguide;
    }

    public final GameCenterFloatBallData component3() {
        return this.floatlayer;
    }

    public final GameCenterFloatBallData component4() {
        return this.topfloatlayer;
    }

    public final GameCommonConfigData copy(GameGuideData gameGuideData, GameGuideDialogData gameGuideDialogData, GameCenterFloatBallData gameCenterFloatBallData, GameCenterFloatBallData gameCenterFloatBallData2) {
        return new GameCommonConfigData(gameGuideData, gameGuideDialogData, gameCenterFloatBallData, gameCenterFloatBallData2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameCommonConfigData)) {
            return false;
        }
        GameCommonConfigData gameCommonConfigData = (GameCommonConfigData) obj;
        return Intrinsics.areEqual((Object) this.guide, (Object) gameCommonConfigData.guide) && Intrinsics.areEqual((Object) this.gameguide, (Object) gameCommonConfigData.gameguide) && Intrinsics.areEqual((Object) this.floatlayer, (Object) gameCommonConfigData.floatlayer) && Intrinsics.areEqual((Object) this.topfloatlayer, (Object) gameCommonConfigData.topfloatlayer);
    }

    public int hashCode() {
        GameGuideData gameGuideData = this.guide;
        int i2 = 0;
        int hashCode = (gameGuideData == null ? 0 : gameGuideData.hashCode()) * 31;
        GameGuideDialogData gameGuideDialogData = this.gameguide;
        int hashCode2 = (hashCode + (gameGuideDialogData == null ? 0 : gameGuideDialogData.hashCode())) * 31;
        GameCenterFloatBallData gameCenterFloatBallData = this.floatlayer;
        int hashCode3 = (hashCode2 + (gameCenterFloatBallData == null ? 0 : gameCenterFloatBallData.hashCode())) * 31;
        GameCenterFloatBallData gameCenterFloatBallData2 = this.topfloatlayer;
        if (gameCenterFloatBallData2 != null) {
            i2 = gameCenterFloatBallData2.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        return "GameCommonConfigData(guide=" + this.guide + ", gameguide=" + this.gameguide + ", floatlayer=" + this.floatlayer + ", topfloatlayer=" + this.topfloatlayer + ')';
    }

    public GameCommonConfigData(GameGuideData guide2, GameGuideDialogData gameguide2, GameCenterFloatBallData floatlayer2, GameCenterFloatBallData topfloatlayer2) {
        this.guide = guide2;
        this.gameguide = gameguide2;
        this.floatlayer = floatlayer2;
        this.topfloatlayer = topfloatlayer2;
    }

    public final GameGuideData getGuide() {
        return this.guide;
    }

    public final void setGuide(GameGuideData gameGuideData) {
        this.guide = gameGuideData;
    }

    public final GameGuideDialogData getGameguide() {
        return this.gameguide;
    }

    public final void setGameguide(GameGuideDialogData gameGuideDialogData) {
        this.gameguide = gameGuideDialogData;
    }

    public final GameCenterFloatBallData getFloatlayer() {
        return this.floatlayer;
    }

    public final void setFloatlayer(GameCenterFloatBallData gameCenterFloatBallData) {
        this.floatlayer = gameCenterFloatBallData;
    }

    public final GameCenterFloatBallData getTopfloatlayer() {
        return this.topfloatlayer;
    }

    public final void setTopfloatlayer(GameCenterFloatBallData gameCenterFloatBallData) {
        this.topfloatlayer = gameCenterFloatBallData;
    }
}
