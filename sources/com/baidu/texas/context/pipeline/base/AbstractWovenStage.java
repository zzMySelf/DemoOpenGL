package com.baidu.texas.context.pipeline.base;

import com.baidu.texas.context.pipeline.Assignment;
import com.baidu.texas.context.pipeline.Chain;
import com.baidu.texas.context.pipeline.PipelineContext;
import com.baidu.texas.context.pipeline.Stage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractWovenStage implements Stage, Assignment {
    private List<Assignment> mAfterWeavers;
    private List<Assignment> mBeforeWeavers;
    private final Iterable<Weaver> mWeavers;

    public interface Weaver {
        void afterRun(PipelineContext pipelineContext);

        boolean beforeRun(PipelineContext pipelineContext);
    }

    public abstract void run(PipelineContext pipelineContext);

    public AbstractWovenStage() {
        this(Collections.emptyList());
    }

    public AbstractWovenStage(Iterable<Weaver> weavers) {
        this.mWeavers = weavers;
    }

    public AbstractWovenStage doFirst(Assignment assignment) {
        List<Assignment> beforeWeavers = this.mBeforeWeavers;
        if (beforeWeavers == null) {
            beforeWeavers = new ArrayList<>();
            this.mBeforeWeavers = beforeWeavers;
        }
        beforeWeavers.add(0, assignment);
        return this;
    }

    public AbstractWovenStage doLast(Assignment assignment) {
        List<Assignment> afterWeavers = this.mAfterWeavers;
        if (afterWeavers == null) {
            afterWeavers = new ArrayList<>();
            this.mAfterWeavers = afterWeavers;
        }
        afterWeavers.add(assignment);
        return this;
    }

    public void run(Chain chain, PipelineContext pipelineContext) {
        dispatchBeforeWeavers(pipelineContext);
        boolean needFilter = false;
        Iterator<Weaver> it = this.mWeavers.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().beforeRun(pipelineContext)) {
                    needFilter = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!needFilter) {
            run(pipelineContext);
            for (Weaver weaver : this.mWeavers) {
                weaver.afterRun(pipelineContext);
            }
        }
        chain.proceed(pipelineContext);
        dispatchAfterWeavers(pipelineContext);
    }

    /* access modifiers changed from: protected */
    public final void dispatchBeforeWeavers(PipelineContext pipelineContext) {
        List<Assignment> beforeWeavers = this.mBeforeWeavers;
        if (beforeWeavers != null) {
            for (Assignment weaver : beforeWeavers) {
                weaver.run(pipelineContext);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void dispatchAfterWeavers(PipelineContext pipelineContext) {
        List<Assignment> afterWeavers = this.mAfterWeavers;
        if (afterWeavers != null) {
            for (Assignment weaver : afterWeavers) {
                weaver.run(pipelineContext);
            }
        }
    }
}
