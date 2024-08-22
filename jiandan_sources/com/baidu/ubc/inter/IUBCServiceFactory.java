package com.baidu.ubc.inter;

import com.baidu.ubc.IUBCABTest;
import com.baidu.ubc.IUBCContext;
import com.baidu.ubc.IUBCUploader;

public interface IUBCServiceFactory {
    IUBCContext ad();

    IIPCService de();

    IUBCABTest fe();

    IAppConfigService qw();

    IUBCUploader rg();

    IExternalService th();

    IUBCLogIdSpService yj();
}
