package de.vazzi;

import dev.waterdog.plugin.Plugin;
import de.vazzi.PluginsCommand;

public class Pluginlist extends Plugin {

    @Override
    public void onEnable() {
        //register Command
        this.getProxy().getCommandMap().registerCommand("wdplugins", new PluginsCommand());
    }

}
