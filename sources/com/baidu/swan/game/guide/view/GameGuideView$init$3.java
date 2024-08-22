package com.baidu.swan.game.guide.view;

import com.baidu.swan.game.guide.R;
import com.baidu.swan.game.guide.view.GameGuideProgressView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"com/baidu/swan/game/guide/view/GameGuideView$init$3", "Lcom/baidu/swan/game/guide/view/GameGuideProgressView$OnGameTimeProgressListener;", "onProcessStop", "", "onProgressEnd", "onProgressStart", "currentProgress", "", "onProgressing", "lib-swan-game-guide_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameGuideView.kt */
public final class GameGuideView$init$3 implements GameGuideProgressView.OnGameTimeProgressListener {
    final /* synthetic */ GameGuideView this$0;

    GameGuideView$init$3(GameGuideView $receiver) {
        this.this$0 = $receiver;
    }

    public void onProgressStart(float currentProgress) {
        this.this$0.reviseViewLayout(currentProgress);
    }

    public void onProgressing(float currentProgress) {
        this.this$0.reviseViewLayout(currentProgress);
    }

    public void onProgressEnd() {
        if (this.this$0.isOnTiming && (this.this$0.currentStatus == 0 || this.this$0.currentStatus == 1)) {
            ((GameGuideProgressView) this.this$0._$_findCachedViewById(R.id.progress_view)).startProcess(0.0f);
        }
        this.this$0.updateWhenOneProgressEnd();
    }

    public void onProcessStop() {
    }
}
