package com.baidu.searchbox.player.kernel;

public class EmptyKernelFactory implements IKernelFactory {
    public AbsVideoKernel create(String type) {
        return new EmptyKernel();
    }
}
