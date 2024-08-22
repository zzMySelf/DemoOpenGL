package com.baidu.searchbox.player.plugin;

import com.baidu.searchbox.player.BDVideoPlayer;
import java.util.ArrayList;
import java.util.Iterator;

public class PluginManager {
    private final BDVideoPlayer mPlayer;
    private final ArrayList<AbsPlugin> mPlugins = new ArrayList<>();

    public PluginManager(BDVideoPlayer player) {
        this.mPlayer = player;
    }

    public void addPlugin(AbsPlugin plugin) {
        plugin.attachMessenger(getPlayer().getMessenger());
        plugin.attachManager(this);
        this.mPlugins.add(plugin);
    }

    public void removePlugin(AbsPlugin plugin) {
        plugin.detachMessenger();
        plugin.detachManager();
        this.mPlugins.remove(plugin);
    }

    public BDVideoPlayer getPlayer() {
        return this.mPlayer;
    }

    public void release() {
        Iterator<AbsPlugin> it = this.mPlugins.iterator();
        while (it.hasNext()) {
            AbsPlugin plugin = it.next();
            plugin.detachManager();
            plugin.detachMessenger();
            plugin.onPluginRelease();
        }
        this.mPlugins.clear();
    }
}
