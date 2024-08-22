package com.baidu.texas.context.pipeline;

public interface Assignment {
    public static final Assignment EMPTY = new Assignment() {
        public void run(PipelineContext pipelineContext) {
        }
    };

    void run(PipelineContext pipelineContext);
}
