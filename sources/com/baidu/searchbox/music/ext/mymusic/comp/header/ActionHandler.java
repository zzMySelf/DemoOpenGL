package com.baidu.searchbox.music.ext.mymusic.comp.header;

import android.content.Context;
import android.util.Log;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.music.ext.album.dialog.CreateEditableAlbumDialog;
import com.baidu.searchbox.music.ext.mymusic.event.ChangeListEvent;
import com.baidu.searchbox.music.ext.scheme.BaseExtSchemeActionKt;
import com.baidu.searchbox.music.ext.statistic.MusicExtStatService;
import com.baidu.searchbox.music.ext.statistic.MusicExtStats;
import com.baidu.searchbox.music.ext.tpls.model.ChangeListAction;
import com.baidu.searchbox.music.ext.tpls.model.CreateAlbumAction;
import com.baidu.searchbox.music.ext.tpls.model.LoadSchemeAction;
import com.baidu.searchbox.music.ext.tpls.model.TplAction;
import com.baidu.searchbox.music.ext.utils.StringExtKt;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004\u000b\f\r\u000eB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/music/ext/mymusic/comp/header/ActionHandler;", "", "context", "Landroid/content/Context;", "viewModel", "Lcom/baidu/searchbox/music/ext/mymusic/comp/header/HeaderViewModel;", "(Landroid/content/Context;Lcom/baidu/searchbox/music/ext/mymusic/comp/header/HeaderViewModel;)V", "handle", "", "action", "Lcom/baidu/searchbox/music/ext/tpls/model/TplAction;", "ChangeListActionHandler", "CreateAlbumActionHandler", "IActionHandler", "LoadSchemeActionHandler", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActionHandler.kt */
public final class ActionHandler {
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final HeaderViewModel viewModel;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bb\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/music/ext/mymusic/comp/header/ActionHandler$IActionHandler;", "A", "Lcom/baidu/searchbox/music/ext/tpls/model/TplAction;", "", "handleAction", "", "action", "(Lcom/baidu/searchbox/music/ext/tpls/model/TplAction;)V", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ActionHandler.kt */
    private interface IActionHandler<A extends TplAction> {
        void handleAction(A a2);
    }

    public ActionHandler(Context context2, HeaderViewModel viewModel2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(viewModel2, "viewModel");
        this.context = context2;
        this.viewModel = viewModel2;
    }

    public final void handle(TplAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof CreateAlbumAction) {
            new CreateAlbumActionHandler().handleAction((CreateAlbumAction) action);
        } else if (action instanceof LoadSchemeAction) {
            new LoadSchemeActionHandler().handleAction((LoadSchemeAction) action);
        } else if (action instanceof ChangeListAction) {
            new ChangeListActionHandler().handleAction((ChangeListAction) action);
        } else if (ActionHandlerKt.DEBUG) {
            Log.d("ActionHandler", "Action类型未知:" + action.getAction$lib_music_ext_release() + ", " + action.getText$lib_music_ext_release());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/music/ext/mymusic/comp/header/ActionHandler$CreateAlbumActionHandler;", "Lcom/baidu/searchbox/music/ext/mymusic/comp/header/ActionHandler$IActionHandler;", "Lcom/baidu/searchbox/music/ext/tpls/model/CreateAlbumAction;", "(Lcom/baidu/searchbox/music/ext/mymusic/comp/header/ActionHandler;)V", "handleAction", "", "action", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ActionHandler.kt */
    private final class CreateAlbumActionHandler implements IActionHandler<CreateAlbumAction> {
        public CreateAlbumActionHandler() {
        }

        public void handleAction(CreateAlbumAction action) {
            Intrinsics.checkNotNullParameter(action, "action");
            new CreateEditableAlbumDialog(ActionHandler.this.context).show();
            HeaderViewModel $this$handleAction_u24lambda_u2d0 = ActionHandler.this.viewModel;
            MusicExtStatService of = MusicExtStats.of($this$handleAction_u24lambda_u2d0.getToken());
            if (of != null) {
                of.onMusicExtStatEvent("click", $this$handleAction_u24lambda_u2d0.getPage(), $this$handleAction_u24lambda_u2d0.getSource(), MusicExtStats.VALUE_MY_MUSIC_CREATE_SONG_LIST_CLICK_1);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/music/ext/mymusic/comp/header/ActionHandler$LoadSchemeActionHandler;", "Lcom/baidu/searchbox/music/ext/mymusic/comp/header/ActionHandler$IActionHandler;", "Lcom/baidu/searchbox/music/ext/tpls/model/LoadSchemeAction;", "(Lcom/baidu/searchbox/music/ext/mymusic/comp/header/ActionHandler;)V", "handleAction", "", "action", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ActionHandler.kt */
    private final class LoadSchemeActionHandler implements IActionHandler<LoadSchemeAction> {
        public LoadSchemeActionHandler() {
        }

        public void handleAction(LoadSchemeAction action) {
            String channelSource;
            String pathTags;
            String extJson;
            String pathTags2;
            Intrinsics.checkNotNullParameter(action, "action");
            HeaderViewModel $this$handleAction_u24lambda_u2d3 = ActionHandler.this.viewModel;
            ActionHandler actionHandler = ActionHandler.this;
            MusicExtStatService of = MusicExtStats.of($this$handleAction_u24lambda_u2d3.getToken());
            String extJson2 = "";
            if (of == null || (channelSource = of.getChannelSource()) == null) {
                channelSource = extJson2;
            }
            Intrinsics.checkNotNullExpressionValue(channelSource, "MusicExtStats.of(token)?.channelSource ?: \"\"");
            MusicExtStatService of2 = MusicExtStats.of($this$handleAction_u24lambda_u2d3.getToken());
            if (of2 == null || (pathTags2 = of2.getPathTags()) == null || (pathTags = StringExtKt.appendWithSeparator$default(pathTags2, $this$handleAction_u24lambda_u2d3.getSource(), (String) null, 2, (Object) null)) == null) {
                pathTags = $this$handleAction_u24lambda_u2d3.getSource();
            }
            MusicExtStatService of3 = MusicExtStats.of($this$handleAction_u24lambda_u2d3.getToken());
            if (!(of3 == null || (extJson = of3.getExtJson()) == null)) {
                extJson2 = extJson;
            }
            Intrinsics.checkNotNullExpressionValue(extJson2, "MusicExtStats.of(token)?.extJson ?: \"\"");
            String scheme = action.getScheme();
            ArrayList arrayList = new ArrayList();
            ArrayList $this$handleAction_u24lambda_u2d3_u24lambda_u2d0 = arrayList;
            $this$handleAction_u24lambda_u2d3_u24lambda_u2d0.add(new Pair("channelSource", channelSource));
            $this$handleAction_u24lambda_u2d3_u24lambda_u2d0.add(new Pair("pageFrom", $this$handleAction_u24lambda_u2d3.getSource()));
            $this$handleAction_u24lambda_u2d3_u24lambda_u2d0.add(new Pair(BaseExtSchemeActionKt.PARAM_KEY_PATH_TAGS, pathTags));
            $this$handleAction_u24lambda_u2d3_u24lambda_u2d0.add(new Pair("extJson", extJson2));
            SchemeRouter.invoke(actionHandler.context, StringExtKt.uriAppendParams(scheme, arrayList));
            MusicExtStatService $this$handleAction_u24lambda_u2d3_u24lambda_u2d2 = MusicExtStats.of($this$handleAction_u24lambda_u2d3.getToken());
            if ($this$handleAction_u24lambda_u2d3_u24lambda_u2d2 != null) {
                HashMap ext = new HashMap();
                HashMap $this$handleAction_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1 = ext;
                $this$handleAction_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1.put("text", action.getText$lib_music_ext_release());
                $this$handleAction_u24lambda_u2d3_u24lambda_u2d2_u24lambda_u2d1.put("action", action.getAction$lib_music_ext_release());
                $this$handleAction_u24lambda_u2d3_u24lambda_u2d2.onMusicExtStatEvent("click", $this$handleAction_u24lambda_u2d3.getPage(), $this$handleAction_u24lambda_u2d3.getSource(), "more_click", ext);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/music/ext/mymusic/comp/header/ActionHandler$ChangeListActionHandler;", "Lcom/baidu/searchbox/music/ext/mymusic/comp/header/ActionHandler$IActionHandler;", "Lcom/baidu/searchbox/music/ext/tpls/model/ChangeListAction;", "(Lcom/baidu/searchbox/music/ext/mymusic/comp/header/ActionHandler;)V", "handleAction", "", "action", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ActionHandler.kt */
    private final class ChangeListActionHandler implements IActionHandler<ChangeListAction> {
        public ChangeListActionHandler() {
        }

        public void handleAction(ChangeListAction action) {
            Intrinsics.checkNotNullParameter(action, "action");
            HeaderViewModel $this$handleAction_u24lambda_u2d1 = ActionHandler.this.viewModel;
            UniqueId it = $this$handleAction_u24lambda_u2d1.getToken();
            if (it != null) {
                BdEventBus.Companion.getDefault().post(new ChangeListEvent($this$handleAction_u24lambda_u2d1.getSource(), it));
            }
            MusicExtStatService of = MusicExtStats.of($this$handleAction_u24lambda_u2d1.getToken());
            if (of != null) {
                of.onMusicExtStatEvent("click", $this$handleAction_u24lambda_u2d1.getPage(), $this$handleAction_u24lambda_u2d1.getSource(), MusicExtStats.VALUE_RECOMMEND_REFRESH_CLICK);
            }
        }
    }
}
