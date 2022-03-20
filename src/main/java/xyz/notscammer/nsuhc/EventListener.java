package xyz.notscammer.nsuhc;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;


public class EventListener implements Listener {

    @EventHandler
    void playerDeathVoid(PlayerDeathEvent e){
        if(Statics.playerList.contains(e.getEntity())){
            Statics.playerList.remove(e.getEntity());
            //f
            //TODO: drop player head
            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) playerHead.getItemMeta();
            meta.setOwner(e.getEntity().getName());
            meta.setDisplayName(e.getEntity().getName()+ "'s head");
            playerHead.setItemMeta(meta);
            e.getEntity().getWorld().dropItem(e.getEntity().getLocation(),playerHead);
            //f
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

    //TODO: right click to use golden head
}
