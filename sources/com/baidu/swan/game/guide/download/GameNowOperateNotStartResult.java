package com.baidu.swan.game.guide.download;

import com.baidu.swan.game.guide.model.OperateResult;

class GameNowOperateNotStartResult extends OperateResult {
    private static final int STATUS_OK = 0;

    public GameNowOperateNotStartResult(String result) {
        super("onFail", 0, result);
    }
}
