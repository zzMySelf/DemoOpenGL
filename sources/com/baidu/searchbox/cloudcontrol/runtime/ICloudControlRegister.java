package com.baidu.searchbox.cloudcontrol.runtime;

import com.baidu.searchbox.cloudcontrol.processor.DataProcessors;

public interface ICloudControlRegister {
    void registerAllProcessors(DataProcessors dataProcessors);
}
