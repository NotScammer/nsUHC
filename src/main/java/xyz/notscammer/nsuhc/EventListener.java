package xyz.notscammer.nsuhc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;


public class EventListener implements Listener {

    @EventHandler
    void playerDeathVoid(PlayerDeathEvent e){
        if(Statics.playerList.contains(e.getEntity())){
            Statics.playerList.remove(e.getEntity());
            e.getEntity().setGameMode(GameMode.SPECTATOR);
            Bukkit.broadcastMessage(e.getEntity().getName() + " has been eliminated!");
            if(Statics.playerList.size() > 1){
                Bukkit.broadcastMessage("Only " +  Statics.playerList.size()  + " players remaining!");
        }
    if(Statics.playerList.size() == 1){
        Player pl = (Player) Statics.playerList.toArray()[0];
        Bukkit.broadcastMessage(ChatColor.GREEN + pl.getName() + " has won the uhc!");
            }
        }
    }
}
