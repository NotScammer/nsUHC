package xyz.notscammer.nsuhc;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

import java.util.ArrayList;

public class GoldenHead {
    static Recipe getGoldenHeadRecipe(){
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);

        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwner("LegendaryJulien");
        meta.setDisplayName(ChatColor.YELLOW + "Golden Head");

        ArrayList<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Right click to use it");
        meta.setLore(lore);
        item.setItemMeta(meta);

        ShapedRecipe recipe = new ShapedRecipe(item);
        recipe.shape("$$$","$#$","$$$");
        recipe.setIngredient('$',Material.GOLD_INGOT);
        recipe.setIngredient('#',Material.PLAYER_HEAD);

        return recipe;
    }
}
