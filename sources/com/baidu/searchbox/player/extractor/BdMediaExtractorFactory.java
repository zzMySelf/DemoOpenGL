package com.baidu.searchbox.player.extractor;

import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import com.baidu.webkit.sdk.plugin.ZeusPluginFactory;

public class BdMediaExtractorFactory implements ZeusPluginFactory {
    public String name() {
        return "media_extractor";
    }

    public ZeusPlugin create(ZeusPluginFactory.Invoker invoker) {
        return new BdMediaExtractor(invoker);
    }
}
