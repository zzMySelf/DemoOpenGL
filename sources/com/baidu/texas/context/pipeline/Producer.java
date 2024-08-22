package com.baidu.texas.context.pipeline;

public interface Producer<T> extends PipelineUnit<Consumer<T>> {
    void run(Consumer<T> consumer, PipelineContext pipelineContext);
}
