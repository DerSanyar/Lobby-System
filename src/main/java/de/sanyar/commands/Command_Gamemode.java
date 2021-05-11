package de.sanyar.commands;

import de.sanyar.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_Gamemode implements CommandExecutor {
    private final Main plugin;

    public Command_Gamemode(Main plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("gamemode").setExecutor(this);


    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        final Player player = (Player) cs;

        if(cmd.getName().equalsIgnoreCase("gamemode"))
            if(player.hasPermission("lobby.gamemode")){
                if(args.length == 0){
                    player.sendMessage(plugin.getUsagePrefix()+"/gamemode 0/1/2/3 [player]");
                }else if (args.length == 1){
                    switch (args[0]){
                        case "0":
                            if(player.hasPermission("lobby.gamemode.0"))
                                player.setGameMode(GameMode.SURVIVAL);
                            player.sendMessage(plugin.getPrefix()+"§2Du bist nun im §c"+player.getGameMode()+"§2");
                            break;
                        case "1":
                            if(player.hasPermission("lobby.gamemode.1"))
                                player.setGameMode(GameMode.CREATIVE);
                            player.sendMessage(plugin.getPrefix()+"§2Du bist nun im §c"+player.getGameMode()+"§2");
                            break;
                        case "2":
                            if(player.hasPermission("lobby.gamemode.2"))
                                player.setGameMode(GameMode.ADVENTURE);
                            player.sendMessage(plugin.getPrefix()+"§2Du bist nun im §c"+player.getGameMode()+"§2");
                            break;
                        case "3":
                            if(player.hasPermission("lobby.gamemode.3"))
                                player.setGameMode(GameMode.SPECTATOR);
                            player.sendMessage(plugin.getPrefix()+"§2Du bist nun im §c"+player.getGameMode()+"§2");
                            break;
                        default:
                            player.sendMessage(plugin.getPrefix()+"/gamemode 0/1/2/3 [player]");
                    }
                }else if(args.length == 2) {
                    final Player target = Bukkit.getPlayerExact(args[1]);
                    switch (args[0]) {
                        case "0":
                            if (player.hasPermission("lobby.gamemode.target.0"))
                                target.setGameMode(GameMode.SURVIVAL);
                            player.sendMessage(plugin.getPrefix() + "§a"+target.getName()+"§2 ist nun im §c"+target.getGameMode().toString());
                            target.sendMessage(plugin.getPrefix()+"§2Du bist nun im §c"+target.getGameMode().toString()+"§2");
                            break;
                        case "1":
                            if (player.hasPermission("lobby.gamemode.target.1"))
                                target.setGameMode(GameMode.CREATIVE);
                            player.sendMessage(plugin.getPrefix() + "§a"+target.getName()+"§2 ist nun im §c"+target.getGameMode().toString());
                            target.sendMessage(plugin.getPrefix()+"§2Du bist nun im §c"+target.getGameMode().toString()+"§2");
                            break;
                        case "2":
                            if (player.hasPermission("lobby.gamemode.target.2"))
                                target.setGameMode(GameMode.ADVENTURE);
                            player.sendMessage(plugin.getPrefix() + "§a"+target.getName()+"§2 ist nun im §c"+target.getGameMode().toString());
                            target.sendMessage(plugin.getPrefix()+"§2Du bist nun im §c"+target.getGameMode().toString()+"§2");
                            break;
                        case "3":
                            if (player.hasPermission("lobby.gamemode.target.3"))
                                target.setGameMode(GameMode.SPECTATOR);
                            player.sendMessage(plugin.getPrefix() + "§a"+target.getName()+"§2 ist nun im §c"+target.getGameMode().toString());
                            target.sendMessage(plugin.getPrefix()+"§2Du bist nun im §c"+target.getGameMode().toString()+"§2");
                            break;
                        default:
                            player.sendMessage(plugin.getUsagePrefix() + "/gamemode 0/1/2/3 [player]");
                    }
                }else{
                    player.sendMessage(plugin.getUsagePrefix() + "/gamemode 0/1/2/3 [player]");
                }
            }else{
                player.sendMessage(plugin.getNoPerm());
            }


        return false;
    }
}
