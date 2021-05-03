package de.vazzi;


import dev.waterdog.waterdogpe.plugin.Plugin;

public class Pluginlist extends Plugin {

    @Override
    public void onEnable() {
        //register Command
        getProxy().getCommandMap().registerCommand(new PluginsCommand());
    }

}
