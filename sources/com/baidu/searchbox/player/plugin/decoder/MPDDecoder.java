package com.baidu.searchbox.player.plugin.decoder;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.player.model.StringArrayBundle;
import com.baidu.searchbox.player.plugin.model.MPDModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/player/plugin/decoder/MPDDecoder;", "", "()V", "MPD_DECODER_VERSION", "", "extDecoder", "", "Lcom/baidu/searchbox/player/plugin/decoder/MPDExtDecoder;", "videoDecoderRepresentationFilter", "Lcom/baidu/searchbox/player/plugin/decoder/RepresentationFilter;", "getVideoDecoderRepresentationFilter", "()Lcom/baidu/searchbox/player/plugin/decoder/RepresentationFilter;", "setVideoDecoderRepresentationFilter", "(Lcom/baidu/searchbox/player/plugin/decoder/RepresentationFilter;)V", "checkVersionValid", "", "version", "convertMPDModelToClarityUrl", "Lorg/json/JSONArray;", "model", "Lcom/baidu/searchbox/player/plugin/model/MPDModel;", "convertMPDToClarityUrl", "singleResponse", "", "decodeSingleResponse", "response", "mpd-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MPDDecoder.kt */
public final class MPDDecoder {
    public static final MPDDecoder INSTANCE = new MPDDecoder();
    private static final int MPD_DECODER_VERSION = 0;
    private static final List<MPDExtDecoder<? extends Object>> extDecoder = CollectionsKt.listOf(new VideoDecoder(), new PreviewDecoder());
    private static RepresentationFilter videoDecoderRepresentationFilter;

    private MPDDecoder() {
    }

    public final RepresentationFilter getVideoDecoderRepresentationFilter() {
        return videoDecoderRepresentationFilter;
    }

    public final void setVideoDecoderRepresentationFilter(RepresentationFilter representationFilter) {
        videoDecoderRepresentationFilter = representationFilter;
    }

    @StableApi
    public final MPDModel decodeSingleResponse(String response) {
        Object decodeData;
        StringArrayBundle extData;
        String str = response;
        if (str == null) {
            return null;
        }
        MPDModel mPDModel = null;
        try {
            JSONObject $this$decodeSingleResponse_u24lambda_u2d1 = new JSONObject(str);
            int version = $this$decodeSingleResponse_u24lambda_u2d1.optInt("version", -1);
            if (!INSTANCE.checkVersionValid(version)) {
                return null;
            }
            JSONObject responseObj = $this$decodeSingleResponse_u24lambda_u2d1;
            mPDModel = new MPDModel(version, $this$decodeSingleResponse_u24lambda_u2d1.optString("mode"));
            for (MPDExtDecoder decoder : extDecoder) {
                if (decoder instanceof VideoDecoder) {
                    ((VideoDecoder) decoder).setVideoRepresentationFilter(videoDecoderRepresentationFilter);
                }
                JSONObject data = responseObj.optJSONObject(decoder.getProtocol().toString());
                if (!(data == null || (decodeData = decoder.decode(data)) == null || (extData = mPDModel.getExtData()) == null)) {
                    extData.putExtra(decoder.getProtocol().toString(), decodeData);
                }
            }
            return mPDModel;
        } catch (Exception e2) {
        }
    }

    @StableApi
    @JvmStatic
    public static final JSONArray convertMPDToClarityUrl(String singleResponse) {
        return convertMPDModelToClarityUrl(INSTANCE.decodeSingleResponse(singleResponse));
    }

    @JvmStatic
    public static final JSONArray convertMPDModelToClarityUrl(MPDModel model) {
        if (model == null) {
            return null;
        }
        JSONArray clarityUrlList = new JSONArray();
        VideoDecoderKt.convertVideo(model, clarityUrlList);
        return clarityUrlList;
    }

    public final boolean checkVersionValid(int version) {
        return version == 0;
    }
}
