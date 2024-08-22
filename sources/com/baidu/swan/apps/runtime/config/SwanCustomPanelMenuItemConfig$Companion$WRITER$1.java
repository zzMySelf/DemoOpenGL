package com.baidu.swan.apps.runtime.config;

import com.baidu.swan.apps.io.SwanDataOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/swan/apps/runtime/config/SwanCustomPanelMenuItemConfig$Companion$WRITER$1", "Lcom/baidu/swan/apps/runtime/config/SwanConfigWriter;", "Lcom/baidu/swan/apps/runtime/config/SwanCustomPanelMenuItemConfig;", "writeObject", "", "value", "configOutputStream", "Lcom/baidu/swan/apps/io/SwanDataOutputStream;", "lib-swan-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SwanCustomPanelMenuItemConfig.kt */
public final class SwanCustomPanelMenuItemConfig$Companion$WRITER$1 extends SwanConfigWriter<SwanCustomPanelMenuItemConfig> {
    SwanCustomPanelMenuItemConfig$Companion$WRITER$1() {
    }

    public void writeObject(SwanCustomPanelMenuItemConfig value, SwanDataOutputStream configOutputStream) throws Exception {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(configOutputStream, "configOutputStream");
        configOutputStream.writeInt(value.getType());
        configOutputStream.writeInt(value.getPosition());
        configOutputStream.writeBoolean(value.isMenuConfigValid());
    }
}
