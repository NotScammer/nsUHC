package xyz.notscammer.nsuhc;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Statics {
    public static boolean isStarted = false, isShrinking = true;
    public static int border = 1000, secondsElapsed = 0;
    public static String borderCords(){
        return border + " x " + border;
    }
    public static List<Player> playerList = new ArrayList<Player>();
}
