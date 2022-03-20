package xyz.notscammer.nsuhc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Start {
     static World wl;

    public void startUHC(World world) {
        wl = world;
        Statics.isStarted = true;
        Statics.isShrinking = true;
        for(Player ps : Bukkit.getOnlinePlayers()){
            ps.setHealth(20);
            ps.setExp(0f);
            ps.setSaturation(10f);
            if(!Statics.playerList.contains(ps))
                Statics.playerList.add(ps);
        }
        Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "UHC is now starting!");
        wl.getWorldBorder().setSize(Statics.border*2);
        //Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "worldborder set " + (Statics.border*2));
    }
    public static void shrinkBorder(){
        if(Statics.border == 750) Bukkit.broadcastMessage("World border is now : " + Statics.borderCords());
        if(Statics.border == 500) Bukkit.broadcastMessage("World border is now : " + Statics.borderCords());
        if(Statics.border == 250) Bukkit.broadcastMessage("World border is now : " + Statics.borderCords());
        if(Statics.border == 100) Bukkit.broadcastMessage("The world border will stop shrinking");
        if(Statics.border > 100){
        wl.getWorldBorder().setSize((Statics.border-1)*2);
        //Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "worldborder set " + (Statics.border-1)*2);
        Statics.border--;
        }
        else{
            Statics.isShrinking = false;
        }
    }
}
