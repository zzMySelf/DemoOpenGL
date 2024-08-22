package io.flutter.plugin.common;

import com.alipay.sdk.m.p.e;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JSONMethodCodec implements MethodCodec {
    public static final JSONMethodCodec INSTANCE = new JSONMethodCodec();

    public Object decodeEnvelope(ByteBuffer byteBuffer) {
        try {
            Object decodeMessage = JSONMessageCodec.INSTANCE.decodeMessage(byteBuffer);
            if (decodeMessage instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) decodeMessage;
                if (jSONArray.length() == 1) {
                    return unwrapNull(jSONArray.opt(0));
                }
                if (jSONArray.length() == 3) {
                    Object obj = jSONArray.get(0);
                    Object unwrapNull = unwrapNull(jSONArray.opt(1));
                    Object unwrapNull2 = unwrapNull(jSONArray.opt(2));
                    if ((obj instanceof String) && (unwrapNull == null || (unwrapNull instanceof String))) {
                        throw new FlutterException((String) obj, (String) unwrapNull, unwrapNull2);
                    }
                }
            }
            throw new IllegalArgumentException("Invalid envelope: " + decodeMessage);
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    public MethodCall decodeMethodCall(ByteBuffer byteBuffer) {
        try {
            Object decodeMessage = JSONMessageCodec.INSTANCE.decodeMessage(byteBuffer);
            if (decodeMessage instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) decodeMessage;
                Object obj = jSONObject.get(e.s);
                Object unwrapNull = unwrapNull(jSONObject.opt("args"));
                if (obj instanceof String) {
                    return new MethodCall((String) obj, unwrapNull);
                }
            }
            throw new IllegalArgumentException("Invalid method call: " + decodeMessage);
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    public ByteBuffer encodeErrorEnvelope(String str, String str2, Object obj) {
        return JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put(str).put(JSONUtil.wrap(str2)).put(JSONUtil.wrap(obj)));
    }

    public ByteBuffer encodeErrorEnvelopeWithStacktrace(String str, String str2, Object obj, String str3) {
        return JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put(str).put(JSONUtil.wrap(str2)).put(JSONUtil.wrap(obj)).put(JSONUtil.wrap(str3)));
    }

    public ByteBuffer encodeMethodCall(MethodCall methodCall) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(e.s, methodCall.method);
            jSONObject.put("args", JSONUtil.wrap(methodCall.arguments));
            return JSONMessageCodec.INSTANCE.encodeMessage(jSONObject);
        } catch (JSONException e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    public ByteBuffer encodeSuccessEnvelope(Object obj) {
        return JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put(JSONUtil.wrap(obj)));
    }

    public Object unwrapNull(Object obj) {
        if (obj == JSONObject.NULL) {
            return null;
        }
        return obj;
    }
}
