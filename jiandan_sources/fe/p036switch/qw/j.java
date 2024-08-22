package fe.p036switch.qw;

import com.baidu.sapi2.utils.SapiUtils;
import com.idlefish.flutterboost.Messages;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import java.util.HashMap;
import java.util.Map;

/* renamed from: fe.switch.qw.j  reason: invalid package */
/* compiled from: Messages */
public final /* synthetic */ class j {
    public static /* synthetic */ void ad(Messages.NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            nativeRouterApi.fe(Messages.qw.qw((Map) obj));
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            hashMap.put(SapiUtils.KEY_QR_LOGIN_ERROR, Messages.ad(e));
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void de(Messages.NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            nativeRouterApi.ad(Messages.qw.qw((Map) obj));
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            hashMap.put(SapiUtils.KEY_QR_LOGIN_ERROR, Messages.ad(e));
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void fe(Messages.NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            nativeRouterApi.qw(Messages.qw.qw((Map) obj), new aaa(hashMap, reply));
        } catch (Error | RuntimeException e) {
            hashMap.put(SapiUtils.KEY_QR_LOGIN_ERROR, Messages.ad(e));
            reply.reply(hashMap);
        }
    }

    public static /* synthetic */ void qw(Map map, BasicMessageChannel.Reply reply, Void voidR) {
        map.put("result", (Object) null);
        reply.reply(map);
    }

    public static /* synthetic */ void rg(Messages.NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("result", nativeRouterApi.th().ad());
        } catch (Error | RuntimeException e) {
            hashMap.put(SapiUtils.KEY_QR_LOGIN_ERROR, Messages.ad(e));
        }
        reply.reply(hashMap);
    }

    public static /* synthetic */ void th(Messages.NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            nativeRouterApi.rg(Messages.ad.qw((Map) obj));
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            hashMap.put(SapiUtils.KEY_QR_LOGIN_ERROR, Messages.ad(e));
        }
        reply.reply(hashMap);
    }

    public static void uk(BinaryMessenger binaryMessenger, Messages.NativeRouterApi nativeRouterApi) {
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.pushNativeRoute", new StandardMessageCodec());
        if (nativeRouterApi != null) {
            basicMessageChannel.setMessageHandler(new a(nativeRouterApi));
        } else {
            basicMessageChannel.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.pushFlutterRoute", new StandardMessageCodec());
        if (nativeRouterApi != null) {
            basicMessageChannel2.setMessageHandler(new qqq(nativeRouterApi));
        } else {
            basicMessageChannel2.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.popRoute", new StandardMessageCodec());
        if (nativeRouterApi != null) {
            basicMessageChannel3.setMessageHandler(new tt(nativeRouterApi));
        } else {
            basicMessageChannel3.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.getStackFromHost", new StandardMessageCodec());
        if (nativeRouterApi != null) {
            basicMessageChannel4.setMessageHandler(new b(nativeRouterApi));
        } else {
            basicMessageChannel4.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.saveStackToHost", new StandardMessageCodec());
        if (nativeRouterApi != null) {
            basicMessageChannel5.setMessageHandler(new eee(nativeRouterApi));
        } else {
            basicMessageChannel5.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.NativeRouterApi.sendEventToNative", new StandardMessageCodec());
        if (nativeRouterApi != null) {
            basicMessageChannel6.setMessageHandler(new rrr(nativeRouterApi));
        } else {
            basicMessageChannel6.setMessageHandler((BasicMessageChannel.MessageHandler) null);
        }
    }

    public static /* synthetic */ void yj(Messages.NativeRouterApi nativeRouterApi, Object obj, BasicMessageChannel.Reply reply) {
        HashMap hashMap = new HashMap();
        try {
            nativeRouterApi.de(Messages.qw.qw((Map) obj));
            hashMap.put("result", (Object) null);
        } catch (Error | RuntimeException e) {
            hashMap.put(SapiUtils.KEY_QR_LOGIN_ERROR, Messages.ad(e));
        }
        reply.reply(hashMap);
    }
}
