package com.baidu.searchbox.sport.page.chatroom.comp.welcome;

import android.app.Application;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.nacomp.mvvm.impl.BaseViewModel;
import com.baidu.searchbox.nacomp.util.UniqueId;
import com.baidu.searchbox.sport.page.chatroom.model.ChatRoomWelcomeContentModel;
import com.baidu.searchbox.sport.page.chatroom.model.ChatRoomWelcomeShowModel;
import com.baidu.searchbox.sport.page.chatroom.model.SportChatModelFactory;
import com.baidu.searchbox.sport.page.chatroom.repo.SportChatExtRepo;
import com.baidu.searchbox.sport.page.chatroom.repo.SportChatRoomRepo;
import com.baidu.searchbox.sport.utils.LoginUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rx.subscriptions.CompositeSubscription;

@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u000e\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0014J4\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u00162\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\u00162\b\u0010$\u001a\u0004\u0018\u00010%J$\u0010&\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u00162\b\u0010#\u001a\u0004\u0018\u00010\u00162\u0006\u0010\"\u001a\u00020\fH\u0002J\b\u0010'\u001a\u00020\u001dH\u0002J\u001a\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\fH\u0002J\u0012\u0010,\u001a\u00020\u001d2\b\u0010-\u001a\u0004\u0018\u00010*H\u0002J\b\u0010.\u001a\u00020\u001dH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014¨\u0006/"}, d2 = {"Lcom/baidu/searchbox/sport/page/chatroom/comp/welcome/ChatRoomWelcomeMsgVM;", "Lcom/baidu/searchbox/nacomp/mvvm/impl/BaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "chatRepo", "Lcom/baidu/searchbox/sport/page/chatroom/repo/SportChatRoomRepo;", "currentMsgShowTime", "", "enterRoomSubscription", "Lrx/subscriptions/CompositeSubscription;", "isFirstEnterChatRoom", "", "mTimerHandle", "com/baidu/searchbox/sport/page/chatroom/comp/welcome/ChatRoomWelcomeMsgVM$mTimerHandle$1", "Lcom/baidu/searchbox/sport/page/chatroom/comp/welcome/ChatRoomWelcomeMsgVM$mTimerHandle$1;", "showMsg", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/sport/page/chatroom/model/ChatRoomWelcomeShowModel;", "getShowMsg$lib_search_sport_release", "()Landroidx/lifecycle/MutableLiveData;", "welPrefix", "", "getWelPrefix$lib_search_sport_release", "welSuffix", "getWelSuffix$lib_search_sport_release", "welUserName", "getWelUserName$lib_search_sport_release", "observeUserEnterRoom", "", "onCleared", "registerWelcomeMsgChannel", "matchId", "roomId", "isOlympic", "league", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "reportUserEnter", "sendWelcomeMsg", "showWelComeMsg", "msgContent", "Lcom/baidu/searchbox/sport/page/chatroom/model/ChatRoomWelcomeContentModel;", "showAnimation", "startMsgLoop", "content", "startRecordTime", "lib-search-sport_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatRoomWelcomeMsgVM.kt */
public final class ChatRoomWelcomeMsgVM extends BaseViewModel {
    private SportChatRoomRepo chatRepo;
    private long currentMsgShowTime;
    private final CompositeSubscription enterRoomSubscription = new CompositeSubscription();
    private boolean isFirstEnterChatRoom = true;
    /* access modifiers changed from: private */
    public ChatRoomWelcomeMsgVM$mTimerHandle$1 mTimerHandle = new ChatRoomWelcomeMsgVM$mTimerHandle$1(this, Looper.getMainLooper());
    private final MutableLiveData<ChatRoomWelcomeShowModel> showMsg = new MutableLiveData<>();
    private final MutableLiveData<String> welPrefix = new MutableLiveData<>();
    private final MutableLiveData<String> welSuffix = new MutableLiveData<>();
    private final MutableLiveData<String> welUserName = new MutableLiveData<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatRoomWelcomeMsgVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final MutableLiveData<ChatRoomWelcomeShowModel> getShowMsg$lib_search_sport_release() {
        return this.showMsg;
    }

    public final MutableLiveData<String> getWelPrefix$lib_search_sport_release() {
        return this.welPrefix;
    }

    public final MutableLiveData<String> getWelUserName$lib_search_sport_release() {
        return this.welUserName;
    }

    public final MutableLiveData<String> getWelSuffix$lib_search_sport_release() {
        return this.welSuffix;
    }

    public final void registerWelcomeMsgChannel(String matchId, long roomId, boolean isOlympic, String league, UniqueId token) {
        if (matchId != null && this.isFirstEnterChatRoom) {
            if (this.chatRepo == null) {
                SportChatRoomRepo of = SportChatRoomRepo.of(matchId, roomId, isOlympic);
                this.chatRepo = of;
                if (token != null) {
                    UniqueId it = token;
                    if (of != null) {
                        of.setToken(it);
                    }
                }
            }
            observeUserEnterRoom();
            sendWelcomeMsg();
            this.isFirstEnterChatRoom = false;
            if (league != null) {
                reportUserEnter(matchId, league, isOlympic);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r1 = r1.onUserEnterRoom();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void observeUserEnterRoom() {
        /*
            r3 = this;
            com.baidu.searchbox.sport.page.chatroom.repo.SportChatRoomRepo r0 = r3.chatRepo
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            rx.subscriptions.CompositeSubscription r0 = r3.enterRoomSubscription
            r0.clear()
            rx.subscriptions.CompositeSubscription r0 = r3.enterRoomSubscription
            com.baidu.searchbox.sport.page.chatroom.repo.SportChatRoomRepo r1 = r3.chatRepo
            if (r1 == 0) goto L_0x0022
            rx.Observable r1 = r1.onUserEnterRoom()
            if (r1 == 0) goto L_0x0022
            com.baidu.searchbox.sport.page.chatroom.comp.welcome.ChatRoomWelcomeMsgVM$observeUserEnterRoom$1 r2 = new com.baidu.searchbox.sport.page.chatroom.comp.welcome.ChatRoomWelcomeMsgVM$observeUserEnterRoom$1
            r2.<init>(r3)
            rx.functions.Action1 r2 = (rx.functions.Action1) r2
            rx.Subscription r1 = r1.subscribe(r2)
            goto L_0x0023
        L_0x0022:
            r1 = 0
        L_0x0023:
            r0.add(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.sport.page.chatroom.comp.welcome.ChatRoomWelcomeMsgVM.observeUserEnterRoom():void");
    }

    /* access modifiers changed from: private */
    public final void showWelComeMsg(ChatRoomWelcomeContentModel msgContent, boolean showAnimation) {
        this.currentMsgShowTime = System.currentTimeMillis();
        MutableLiveData<String> mutableLiveData = this.welPrefix;
        String str = null;
        if (mutableLiveData != null) {
            mutableLiveData.setValue(msgContent != null ? msgContent.getPrefix() : null);
        }
        MutableLiveData<String> mutableLiveData2 = this.welUserName;
        if (mutableLiveData2 != null) {
            mutableLiveData2.setValue(msgContent != null ? msgContent.getUserName() : null);
        }
        MutableLiveData<String> mutableLiveData3 = this.welSuffix;
        if (mutableLiveData3 != null) {
            if (msgContent != null) {
                str = msgContent.getSuffix();
            }
            mutableLiveData3.setValue(str);
        }
        MutableLiveData<ChatRoomWelcomeShowModel> mutableLiveData4 = this.showMsg;
        if (mutableLiveData4 != null) {
            mutableLiveData4.setValue(new ChatRoomWelcomeShowModel(true, showAnimation));
        }
        startRecordTime();
    }

    /* access modifiers changed from: private */
    public final void startMsgLoop(ChatRoomWelcomeContentModel content) {
        long time = 0;
        if (System.currentTimeMillis() - this.currentMsgShowTime < 1000) {
            time = 1000 - (System.currentTimeMillis() - this.currentMsgShowTime);
        }
        Message message = Message.obtain();
        message.what = 2;
        message.obj = content;
        this.mTimerHandle.sendMessageDelayed(message, time);
    }

    private final void startRecordTime() {
        ChatRoomWelcomeMsgVM$mTimerHandle$1 chatRoomWelcomeMsgVM$mTimerHandle$1 = this.mTimerHandle;
        if (chatRoomWelcomeMsgVM$mTimerHandle$1 != null) {
            chatRoomWelcomeMsgVM$mTimerHandle$1.removeMessages(1);
        }
        Message message = Message.obtain();
        if (message != null) {
            message.what = 1;
        }
        ChatRoomWelcomeMsgVM$mTimerHandle$1 chatRoomWelcomeMsgVM$mTimerHandle$12 = this.mTimerHandle;
        if (chatRoomWelcomeMsgVM$mTimerHandle$12 != null) {
            chatRoomWelcomeMsgVM$mTimerHandle$12.sendMessageDelayed(message, 3000);
        }
    }

    private final void sendWelcomeMsg() {
        if (LoginUtils.isLogin() && this.isFirstEnterChatRoom) {
            if (AppConfig.isDebug()) {
                Log.d(ChatRoomWelcomeMsgVMKt.TAG_WEL, "开始发送欢迎语消息，加上墙");
            }
            SportChatRoomRepo sportChatRoomRepo = this.chatRepo;
            if (sportChatRoomRepo != null) {
                sportChatRoomRepo.sendWelcomeMsg(SportChatModelFactory.buildWelcomeMsg());
            }
        }
    }

    private final void reportUserEnter(String matchId, String league, boolean isOlympic) {
        if (matchId != null && league != null) {
            this.enterRoomSubscription.add(new SportChatExtRepo(matchId, isOlympic).reportUserEnter(matchId, league).subscribe(new ChatRoomWelcomeMsgVM$reportUserEnter$1()));
        }
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.enterRoomSubscription.unsubscribe();
        SportChatRoomRepo sportChatRoomRepo = this.chatRepo;
        if (sportChatRoomRepo != null) {
            sportChatRoomRepo.release();
        }
        this.isFirstEnterChatRoom = true;
        this.mTimerHandle.removeCallbacksAndMessages((Object) null);
        this.currentMsgShowTime = 0;
    }
}
