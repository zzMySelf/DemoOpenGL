package com.baidu.searchbox.ad.ai;

import com.baidu.perf.safemode.config.Config;
import com.baidu.searchbox.ad.ai.IInfer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/ad/ai/DirectAlgorithm;", "Lcom/baidu/searchbox/ad/ai/Base;", "type", "", "comment", "indexes", "Lorg/json/JSONArray;", "algConf", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONArray;Lorg/json/JSONObject;)V", "execute", "", "raw", "internal", "name", "lib-ad-ai_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Algorithms.kt */
public final class DirectAlgorithm extends Base {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DirectAlgorithm(String type, String comment, JSONArray indexes, JSONObject algConf) {
        super(type, comment, indexes, algConf);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(indexes, "indexes");
        Intrinsics.checkNotNullParameter(algConf, "algConf");
    }

    public String name() {
        return "direct";
    }

    public double[] execute(double[] raw, double[] internal) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        Intrinsics.checkNotNullParameter(internal, Config.FilePath.TYPE_INTERNAL);
        double[] output = new double[getArguments().size()];
        int size = getArguments().size();
        for (int i2 = 0; i2 < size; i2++) {
            Argument argument = getArguments().get(i2);
            Intrinsics.checkNotNullExpressionValue(argument, "arguments[i]");
            Argument arg = argument;
            switch (arg.getType()) {
                case 0:
                    output[i2] = raw[arg.getRefIndex()];
                    break;
                case 1:
                    output[i2] = internal[arg.getRefIndex()];
                    break;
                default:
                    throw new IInfer.InferFeatureConfException("Invalid conf, Unrecognized refType " + arg.getType());
            }
        }
        return output;
    }
}
