package com.baidu.swan.games.engine;

import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.swan.apps.engine.AiBaseV8Engine;
import com.baidu.swan.apps.engine.console.V8ConsoleLogcatImpl;
import com.baidu.swan.apps.engine.console.V8JSExceptionLogcatImpl;
import com.baidu.swan.apps.engine.load.V8EngineLoadingPolicy;
import com.baidu.swan.games.binding.V8GlobalObject;
import com.baidu.swan.games.binding.open.V8OpenObject;

public class SwanGameV8Engine extends AiBaseV8Engine {
    public SwanGameV8Engine(String id, V8EngineLoadingPolicy loadingPolicy, V8ThreadDelegatePolicy delegatePolicy) {
        super(id, loadingPolicy, delegatePolicy);
        if (this.mV8Engine != null) {
            this.mV8Engine.setWorkerFactoryDelegate(new V8Engine.WorkerFactory() {
                public V8Engine onCreateWorker() {
                    SwanGameWorker worker = new SwanGameWorker(SwanGameV8Engine.this.getInitBasePath());
                    worker.setMainPackageBasePath();
                    worker.addConsoleListener(new V8ConsoleLogcatImpl(worker));
                    worker.setJSExceptionDelegate(new V8JSExceptionLogcatImpl(worker));
                    return worker.getEngine();
                }
            });
        }
    }

    public EventTarget createGlobalObject() {
        return new V8GlobalObject(this);
    }

    public EventTarget createOpenObject() {
        return new V8OpenObject(this);
    }

    public int getInvokeSourceType() {
        return 1;
    }
}
