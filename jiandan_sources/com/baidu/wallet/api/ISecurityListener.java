package com.baidu.wallet.api;

import android.util.Pair;

public interface ISecurityListener {
    Pair<Integer, Object> onCheck();
}
