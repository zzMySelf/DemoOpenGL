package com.yy.mediaframework.inteligence.common;

public class ResolutionModifyNotFoundException extends Exception {
    public ResolutionModifyNotFoundException(int width, int height, int codeRate) {
        super("Not found config " + width + "x" + height + ", codeRate:" + codeRate);
    }
}
