package xyz.notscammer.nsuhc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UhcCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            return true;
        Player p  = (Player) sender;
        if(args == null || args.length == 0){
            p.sendMessage(ChatColor.RED + NsUHC.prefix + " you need to use arguments!");
            return true;
        }
        switch (args[0]){
            case "start":
                if(p.hasPermission("nsuhc.start")){
                    if(Bukkit.getOnlinePlayers().size() > 1){
                    World world = p.getWorld();
                    Start start = new Start();
                    start.startUHC(world);
                    }
                    else{
                        p.sendMessage(ChatColor.RED + " You need more than 1 player to start the game!");
                    }
                }
                else{
                    p.sendMessage(ChatColor.RED + NsUHC.prefix + " you don't have permission!");
                    return true;
                }
                break;
            case "players":
                String sendString = "";
                for(Player ps : Statics.playerList){
                    sendString += ps.getName() + " ";
                }
                p.sendMessage(ChatColor.GREEN + "[UHC] Players left are : " + ChatColor.GRAY +sendString);
                break;
            case "border":
                p.sendMessage(ChatColor.GREEN + "The world border is : " +Statics.borderCords());
                break;
            default:
                p.sendMessage(ChatColor.RED + NsUHC.prefix + " Use a valid command!");
                break;
        }
        return true;
    }
}
