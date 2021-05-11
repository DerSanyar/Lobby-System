package de.sanyar.commands;

import de.sanyar.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Spawn implements CommandExecutor {

    private Main plugin;

    public Command_Spawn(Main plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("spawn").setExecutor(this);
    }

    private Location spawn;

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        final Player player = (Player) cs;
        spawn = new Location(Bukkit.getWorld(player.getWorld().getName()),
                plugin.getConfig().getDouble("Spawn.x"), plugin.getConfig().getDouble("Spawn.y"), plugin.getConfig().getDouble("Spawn.z"));

        if(cmd.getName().equalsIgnoreCase("spawn")){
            if(args.length == 0){
                player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);
                player.teleport(spawn);
            }else
                player.sendMessage(plugin.getUsagePrefix()+"/spawn");

        }

        return false;
    }
}
