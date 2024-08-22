package com.tera.scan.flutter.plugin.caller;

import androidx.annotation.Keep;
import java.util.Map;

@Keep
public interface IImagePredictorResult {
    void predictorResult(Map<String, String> map);
}
