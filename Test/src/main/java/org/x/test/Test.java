package org.x.test;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.util.Random;

public final class Test extends JavaPlugin implements Listener {

    private final Random random = new Random();

    @Override
    public void onEnable() {
        this.getLogger().info("");
        this.getLogger().info(" Plugin enabled");
        this.getLogger().info(" Thanks for using my plugin!");
        this.getLogger().info("");
        getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        this.getLogger().info("");
        this.getLogger().info(" Plugin disabled");
        this.getLogger().info(" Thanks for using my plugin!");
        this.getLogger().info("");
    }

    @EventHandler
    public void blockBreak(final BlockBreakEvent event) {
        Player p = event.getPlayer();
        final Block block = event.getBlock();
        final Material item = p.getItemInHand().getType();
        final Material breakBlockName = event.getBlock().getType();
        if (breakBlockName.toString().contains("ORE")) {
            String pickaxeType = "";
            if (item == Material.WOODEN_PICKAXE) {
                pickaxeType = "drewnianym";
            } else if (item == Material.STONE_PICKAXE) {
                pickaxeType = "kamiennym";
            } else if (item == Material.IRON_PICKAXE) {
                pickaxeType = "zelaznym";
            } else if (item == Material.GOLDEN_PICKAXE) {
                pickaxeType = "zlotym";
            } else if (item == Material.DIAMOND_PICKAXE) {
                pickaxeType = "diamentowym";
            } else if (item == Material.NETHERITE_PICKAXE) {
                pickaxeType = "netherytowym";
            }
            if (!pickaxeType.isEmpty()) {
                int minlvl = 1;
                int maxlvl = 5;
                int levelsAmount = random.nextInt((maxlvl - minlvl) + 1);
                p.sendMessage(ChatColor.GRAY + "Pomyślnie wykopano " + ChatColor.DARK_GRAY + breakBlockName.toString().replace("_", " ") + ChatColor.GRAY + " kilofem " + pickaxeType + "! Otrzymałeś za to: " + ChatColor.DARK_GRAY + levelsAmount + "xp");
                p.giveExp(levelsAmount);
            }
        }
    }
}




