package com.sdk.base.api;

import android.view.View;
import com.sdk.y.g;
import java.io.Serializable;

public interface OnCustomViewListener extends Serializable {
    void onClick(View view, g gVar);
}
