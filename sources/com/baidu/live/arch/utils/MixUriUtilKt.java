package com.baidu.live.arch.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0004\u001a\u0016\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0010\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u000e\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001e\u0010\n\u001a\u00020\u00012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0004\u001a \u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u001a8\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\u001c\u0010\u0011\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015\u001a8\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u00172\u001c\u0010\u0011\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u001c\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f2\u0006\u0010\r\u001a\u00020\u0001¨\u0006\u0019"}, d2 = {"addParam", "", "url", "params", "", "buildScheme", "roomId", "source", "getParams", "getParamsStr", "mapToString", "paramsJsonToMap", "", "input", "Lorg/json/JSONObject;", "setSchemeParam", "uri", "kv", "", "Lkotlin/Pair;", "isOver", "", "setUriParam", "Landroid/net/Uri;", "stringToMap", "lib-live-mini-arch_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: MixUriUtil.kt */
public final class MixUriUtilKt {
    public static final String setSchemeParam(String uri, List<Pair<String, String>> kv, boolean isOver) {
        CharSequence charSequence = uri;
        boolean z = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            Collection collection = kv;
            if (!(collection == null || collection.isEmpty())) {
                String schemeStr = uri;
                try {
                    Uri scheme = setUriParam(Uri.parse(uri), kv, isOver);
                    String str = scheme != null ? scheme.toString() : null;
                    CharSequence charSequence2 = str;
                    if (charSequence2 == null || charSequence2.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        return str;
                    }
                    return schemeStr;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return schemeStr;
                }
            }
        }
        return uri;
    }

    public static final Uri setUriParam(Uri uri, List<Pair<String, String>> kv, boolean isOver) {
        Uri uri2 = uri;
        if (uri2 != null) {
            Collection collection = kv;
            if (!(collection == null || collection.isEmpty())) {
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                Intrinsics.checkExpressionValueIsNotNull(queryParameterNames, "srcPrama");
                Set<String> params = CollectionsKt.toMutableSet(queryParameterNames);
                Uri.Builder upon = uri.buildUpon().clearQuery();
                for (Pair it : kv) {
                    if (!(((CharSequence) it.getFirst()).length() == 0)) {
                        boolean exsit = params.remove(it.getFirst());
                        if (!exsit || isOver) {
                            CharSequence charSequence = (CharSequence) it.getSecond();
                            if (!(charSequence == null || charSequence.length() == 0) || exsit) {
                                CharSequence charSequence2 = (CharSequence) it.getSecond();
                                if (!(charSequence2 == null || charSequence2.length() == 0)) {
                                    try {
                                        upon.appendQueryParameter((String) it.getFirst(), (String) it.getSecond());
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                        } else {
                            try {
                                upon.appendQueryParameter((String) it.getFirst(), uri.getQueryParameter((String) it.getFirst()));
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                }
                for (String p : params) {
                    try {
                        upon.appendQueryParameter(p, uri.getQueryParameter(p));
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                return upon.build();
            }
        }
        return uri2;
    }

    public static final String getParamsStr(String url) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        if (TextUtils.isEmpty(url)) {
            return url;
        }
        String sRet = null;
        int index = StringsKt.indexOf$default((CharSequence) url, GameCenterUtils.SCHEME_SWAN_SUFFIX, 0, false, 6, (Object) null);
        if (index > 0) {
            String substring = url.substring(index + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            sRet = substring;
        }
        return sRet != null ? sRet : "";
    }

    public static final String getParams(String url) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        if (TextUtils.isEmpty(url)) {
            return url;
        }
        String sRet = null;
        int index = StringsKt.indexOf$default((CharSequence) url, GameCenterUtils.SCHEME_SWAN_SUFFIX, 0, false, 6, (Object) null);
        if (index <= 0) {
            return sRet;
        }
        String sRet2 = url.substring(index + 1);
        Intrinsics.checkNotNullExpressionValue(sRet2, "(this as java.lang.String).substring(startIndex)");
        return sRet2;
    }

    public static final String addParam(String url, Map<String, String> params) {
        Intrinsics.checkParameterIsNotNull(url, "url");
        if (!TextUtils.isEmpty(url)) {
            String part = mapToString(params);
            if (!TextUtils.isEmpty(part)) {
                if (StringsKt.contains$default((CharSequence) url, (CharSequence) GameCenterUtils.SCHEME_SWAN_SUFFIX, false, 2, (Object) null)) {
                    return url + '&' + part;
                }
                return url + '?' + part;
            }
        }
        return url;
    }

    public static final Map<String, String> stringToMap(String input) {
        String str;
        Intrinsics.checkParameterIsNotNull(input, "input");
        Map map = new LinkedHashMap();
        if (!TextUtils.isEmpty(input)) {
            Object[] array = StringsKt.split$default((CharSequence) input, new String[]{"&"}, false, 0, 6, (Object) null).toArray(new String[0]);
            if (array != null) {
                String[] nameValuePairs = (String[]) array;
                int size = nameValuePairs.length;
                int index = 0;
                while (index < size) {
                    Object[] array2 = StringsKt.split$default((CharSequence) nameValuePairs[index], new String[]{"="}, false, 0, 6, (Object) null).toArray(new String[0]);
                    if (array2 != null) {
                        String[] nameValue = (String[]) array2;
                        try {
                            String decode = URLDecoder.decode(nameValue[0], "UTF-8");
                            Intrinsics.checkExpressionValueIsNotNull(decode, "URLDecoder.decode(nameValue[0], \"UTF-8\")");
                            if (nameValue.length > 1) {
                                str = URLDecoder.decode(nameValue[1], "UTF-8");
                            } else {
                                str = "";
                            }
                            map.put(decode, str);
                        } catch (UnsupportedEncodingException e2) {
                        }
                        index++;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        return map;
    }

    public static final String mapToString(Map<String, String> params) {
        String str;
        String str2;
        if (params == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : params.keySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            String value = params.get(key);
            if (key != null) {
                try {
                    str = URLEncoder.encode(key, "UTF-8");
                } catch (UnsupportedEncodingException e2) {
                }
            } else {
                str = "";
            }
            stringBuilder.append(str);
            stringBuilder.append("=");
            if (value != null) {
                str2 = URLEncoder.encode(value, "UTF-8");
            } else {
                str2 = "";
            }
            stringBuilder.append(str2);
        }
        String sb = stringBuilder.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb, "stringBuilder.toString()");
        return sb;
    }

    public static final String buildScheme(String roomId, String source) {
        Intrinsics.checkParameterIsNotNull(roomId, "roomId");
        Intrinsics.checkParameterIsNotNull(source, "source");
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format = String.format("{\"roomId\":\"%s\", \"source\":\"%s\"}", Arrays.copyOf(new Object[]{roomId, source}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            String format2 = String.format("baiduboxapp://v14/live/enterRoom?upgrade=0&params=%s", Arrays.copyOf(new Object[]{URLEncoder.encode(format, "UTF-8")}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
            return format2;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static final Map<String, String> paramsJsonToMap(JSONObject input) {
        if (input == null) {
            return null;
        }
        Map map = new LinkedHashMap();
        Iterator keys = input.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = input.opt(key);
            if (value instanceof String) {
                Intrinsics.checkExpressionValueIsNotNull(key, "key");
                map.put(key, value);
            } else {
                Intrinsics.checkExpressionValueIsNotNull(key, "key");
                map.put(key, value != null ? value.toString() : null);
            }
        }
        return map;
    }
}
