package com.baidu.swan.card.render.engine;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.swan.card.render.engine.load.V8EngineLoadingPolicy;

public final class V8EngineFactory {
    public static SwanCardBaseV8Engine prepareEngine(V8EngineModel model, V8EngineLoadingPolicy policy, V8ThreadDelegatePolicy delegatePolicy) {
        SwanCardBaseV8Engine engine = createEngine(model, policy, delegatePolicy);
        engine.initEngine();
        return engine;
    }

    private static SwanCardBaseV8Engine createEngine(V8EngineModel model, V8EngineLoadingPolicy policy, V8ThreadDelegatePolicy delegatePolicy) {
        V8EngineProvider provider = new SwanAppV8EngineProviderFactory().getEngineProvider(model);
        SwanCardBaseV8Engine engine = provider.createEngine(model.getID(), policy, delegatePolicy);
        engine.setUserAgent(provider.getUserAgent());
        return engine;
    }
}
