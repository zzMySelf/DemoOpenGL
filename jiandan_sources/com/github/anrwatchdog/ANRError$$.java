package com.github.anrwatchdog;

import com.github.anrwatchdog.ANRError;
import java.io.Serializable;
import java.util.LinkedHashMap;

public class ANRError$$ implements Serializable {
    public final String _name;
    public final LinkedHashMap<Long, StackTraceElement[]> _stackMap;
    public final StackTraceElement[] _stackTrace;

    public class _Thread extends Throwable {
        public /* synthetic */ _Thread(ANRError$$ aNRError$$, _Thread _thread, ANRError.qw qwVar) {
            this(_thread);
        }

        public Throwable fillInStackTrace() {
            setStackTrace(ANRError$$.this._stackTrace);
            return this;
        }

        public LinkedHashMap<Long, StackTraceElement[]> getStackMap() {
            return ANRError$$.this._stackMap;
        }

        public _Thread(_Thread _thread) {
            super(ANRError$$.this._name, _thread);
        }
    }

    public /* synthetic */ ANRError$$(String str, LinkedHashMap linkedHashMap, ANRError.qw qwVar) {
        this(str, (LinkedHashMap<Long, StackTraceElement[]>) linkedHashMap);
    }

    public /* synthetic */ ANRError$$(String str, StackTraceElement[] stackTraceElementArr, ANRError.qw qwVar) {
        this(str, stackTraceElementArr);
    }

    public ANRError$$(String str, StackTraceElement[] stackTraceElementArr) {
        this._name = str;
        this._stackTrace = stackTraceElementArr;
        LinkedHashMap<Long, StackTraceElement[]> linkedHashMap = new LinkedHashMap<>();
        this._stackMap = linkedHashMap;
        linkedHashMap.put(Long.valueOf(System.currentTimeMillis()), this._stackTrace);
    }

    public ANRError$$(String str, LinkedHashMap<Long, StackTraceElement[]> linkedHashMap) {
        this._name = str;
        this._stackTrace = (StackTraceElement[]) linkedHashMap.entrySet().iterator().next().getValue();
        this._stackMap = linkedHashMap;
    }
}
