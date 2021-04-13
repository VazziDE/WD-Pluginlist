package de.vazzi;

import dev.waterdog.ProxyServer;
import dev.waterdog.command.Command;
import dev.waterdog.command.CommandSender;
import dev.waterdog.command.CommandSettings;
import dev.waterdog.plugin.Plugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PluginsCommand extends Command {

    public PluginsCommand() {
        super("wdplugins", CommandSettings.builder()
                .setDescription("Show all Proxy Plugins")
                .setUsageMessage("wdplugins")
                .setPermission("waterdog.command.plugins")
                .build());
    }

    @Override
    public boolean onExecute(CommandSender sender, String alias, String[] args) {
        List<String> pluginmap = new ArrayList<>();
        Collection<Plugin> installedplugins = ProxyServer.getInstance().getPluginManager().getPlugins();
        for (Plugin p : installedplugins) {
            pluginmap.add(checkPlugin(p));
        }
        sender.sendMessage("§eWaterdogPE Plugins [" +  installedplugins.size() + "]: " + String.join("§7, ", pluginmap));
        return true;
    }


    private String checkPlugin(Plugin targetplugin){
        //Return Infos about Plugin to display the plugin
        if(targetplugin.isEnabled()){
            return "§a" + targetplugin.getName() + " : " + targetplugin.getDescription().getVersion() + " by " + targetplugin.getDescription().getAuthor();
        }
        return "§c" + targetplugin.getName() + " : " + targetplugin.getDescription().getVersion() + " by " + targetplugin.getDescription().getAuthor();
    }
}