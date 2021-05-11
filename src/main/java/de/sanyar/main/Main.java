package de.sanyar.main;

import de.sanyar.commands.Command_Gamemode;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private String cprefix = "[Lobby-System] ",
            prefix = "§7[§eLobby§7-§6System§7] ",
            noPerm = prefix+"§cDazu hast du keine Rechte!",
            usagePrefix = prefix+"§cNutze: ";

    @Override
    public void onEnable() {
        loadConfig();

        //Commands register
        new Command_Gamemode(this);
    }

    @Override
    public void onDisable() {

    }

    private void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public String getCprefix() {
        return cprefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNoPerm() {
        return noPerm;
    }

    public String getUsagePrefix() {
        return usagePrefix;
    }
}
