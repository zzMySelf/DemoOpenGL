package com.baidu.texas.context;

public interface ProcessorRegistry extends ProcessorFinder {
    Processor[] fixupProcessorsOfAction(Object obj, Processor... processorArr);

    void registerProcessorsFor(ProcessContext processContext);
}
