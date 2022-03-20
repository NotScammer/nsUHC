package xyz.notscammer.nsuhc;

import org.bukkit.scheduler.BukkitRunnable;

public class BorderTimer extends BukkitRunnable {
    NsUHC plugin;

    public BorderTimer(NsUHC plugin){
        this.plugin = plugin;
    }
    @Override
    public void run(){
    if(Statics.isStarted){
        Start.shrinkBorder();
    }
    Statics.secondsElapsed++;
 }
}
