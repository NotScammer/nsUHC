package xyz.notscammer.nsuhc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;


public final class NsUHC extends JavaPlugin {

    static String prefix = "[nsUHC]";

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
        System.out.println(prefix + " has been enabled, thanks for using!");
        getCommand("uhc").setExecutor(new UhcCommand());
        BukkitTask timer = new BorderTimer(this).runTaskTimer(this,0L,40L);
        Bukkit.getServer().addRecipe(GoldenHead.getGoldenHeadRecipe());
    }

    @Override
    public void onDisable() {
        System.out.println(prefix + " has been disabled!");
    }
}
