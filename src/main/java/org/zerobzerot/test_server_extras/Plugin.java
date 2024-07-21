package org.zerobzerot.test_server_extras;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

public final class Plugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    private static @NotNull ItemStack makeFishingRod() {
        ItemStack stack = new ItemStack(Material.FISHING_ROD, 1);
        stack.addEnchantment(Enchantment.LURE, 3);
        stack.addEnchantment(Enchantment.LUCK_OF_THE_SEA, 3);
        stack.addEnchantment(Enchantment.UNBREAKING, 3);
        stack.addEnchantment(Enchantment.MENDING, 1);
        stack.addEnchantment(Enchantment.VANISHING_CURSE, 1);
        return stack;
    }

    private static @NotNull ItemStack makeFlintSteel() {
        ItemStack stack = new ItemStack(Material.FLINT_AND_STEEL, 1);
        stack.addEnchantment(Enchantment.UNBREAKING, 3);
        stack.addEnchantment(Enchantment.MENDING, 1);
        stack.addEnchantment(Enchantment.VANISHING_CURSE, 1);
        return stack;
    }

    private static @NotNull ItemStack makeHoe() {
        ItemStack stack = new ItemStack(Material.NETHERITE_HOE, 1);
        stack.addEnchantment(Enchantment.EFFICIENCY, 5);
        stack.addEnchantment(Enchantment.FORTUNE, 3);
        stack.addEnchantment(Enchantment.UNBREAKING, 3);
        stack.addEnchantment(Enchantment.SILK_TOUCH, 1);
        stack.addEnchantment(Enchantment.MENDING, 1);
        stack.addEnchantment(Enchantment.VANISHING_CURSE, 1);
        return stack;
    }

    private static @NotNull ItemStack makeEnchantedBook() {
        ItemStack stack = new ItemStack(Material.ENCHANTED_BOOK, 1);
        var rand = ThreadLocalRandom.current().nextInt(0, 16 + 1);
        switch (rand) {
            case 0 -> stack.addEnchantment(Enchantment.MENDING, 1);
            case 1 -> stack.addEnchantment(Enchantment.UNBREAKING, 3);
            case 2 -> stack.addEnchantment(Enchantment.EFFICIENCY, 5);
            case 3 -> stack.addEnchantment(Enchantment.PROTECTION, 4);
            case 4 -> stack.addEnchantment(Enchantment.BLAST_PROTECTION, 4);
            case 5 -> stack.addEnchantment(Enchantment.DEPTH_STRIDER, 3);
            case 6 -> stack.addEnchantment(Enchantment.FLAME, 1);
            case 7 -> stack.addEnchantment(Enchantment.FORTUNE, 3);
            case 8 -> stack.addEnchantment(Enchantment.INFINITY, 1);
            case 9 -> stack.addEnchantment(Enchantment.SHARPNESS, 5);
            case 10 -> stack.addEnchantment(Enchantment.SILK_TOUCH, 1);
            case 11 -> stack.addEnchantment(Enchantment.SWEEPING_EDGE, 3);
            case 12 -> stack.addEnchantment(Enchantment.THORNS, 3);
            case 13 -> stack.addEnchantment(Enchantment.RESPIRATION, 3);
            case 14 -> stack.addEnchantment(Enchantment.RIPTIDE, 3);
            case 15 -> stack.addEnchantment(Enchantment.LOYALTY, 3);
            case 16 -> stack.addEnchantment(Enchantment.POWER, 5);
        }
        return stack;
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent ev) {

        if (ThreadLocalRandom.current().nextBoolean())
            ev.getPlayer().getInventory().addItem(
                    new ItemStack(Material.OAK_LOG,
                            ThreadLocalRandom.current().nextInt(1, 4)));

        if (ThreadLocalRandom.current().nextBoolean())
            ev.getPlayer().getInventory().addItem(
                    new ItemStack(Material.IRON_BLOCK,
                            ThreadLocalRandom.current().nextInt(1, 2)));

        if (ThreadLocalRandom.current().nextBoolean())
            ev.getPlayer().getInventory().addItem(
                    new ItemStack(Material.COAL_BLOCK,
                            ThreadLocalRandom.current().nextInt(1, 2)));

        if (ThreadLocalRandom.current().nextInt(0, 4 + 1) == 0)
            ev.getPlayer().getInventory().addItem(
                    new ItemStack(Material.OBSIDIAN,
                            ThreadLocalRandom.current().nextInt(1, 8 + 1)));

        if (ThreadLocalRandom.current().nextInt(0, 4 + 1) == 0)
            ev.getPlayer().getInventory().addItem(
                    new ItemStack(Material.QUARTZ_BLOCK,
                            ThreadLocalRandom.current().nextInt(1, 8 + 1)));

        var rand = ThreadLocalRandom.current().nextInt(0, 3);
        var count = ThreadLocalRandom.current().nextInt(6, 12);
        switch (rand) {
            case 0 -> ev.getPlayer().getInventory().addItem(
                    new ItemStack(Material.COOKED_BEEF, count));
            case 1 -> ev.getPlayer().getInventory().addItem(
                    new ItemStack(Material.PORKCHOP, count));
            case 2 -> ev.getPlayer().getInventory().addItem(
                    new ItemStack(Material.GOLDEN_CARROT, count));
        }

    }

    @EventHandler
    public void onPlayerAdvancementDone(PlayerAdvancementDoneEvent ev) {
        ev.getPlayer().giveExp(ThreadLocalRandom.current().nextInt(10, 42 + 1), true);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent ev) {
        if (ev.getEntity().getType() == EntityType.PLAYER) return;
        if (!ev.getEntity().hasAI()) return;
        var rand = ThreadLocalRandom.current().nextInt(0, 100);
        switch (rand) {
            case 0, 1, 2 -> ev.getDrops().add(new ItemStack(Material.ENDER_CHEST, 4));
            case 3 -> ev.getDrops().add(new ItemStack(Material.END_CRYSTAL, 4));
            case 4 -> ev.getDrops().add(new ItemStack(Material.SHULKER_SHELL, 2));
            case 5 -> ev.getDrops().add(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1));
            case 6, 7 -> ev.getDrops().add(new ItemStack(Material.TOTEM_OF_UNDYING, 1));
            case 8 -> ev.getDrops().add(makeFishingRod());
            case 9 -> ev.getDrops().add(makeFlintSteel());
            case 10 -> ev.getDrops().add(makeHoe());
            case 11, 12, 13 -> ev.getDrops().add(makeEnchantedBook());
            case 14, 15 -> ev.getDrops().add(new ItemStack(Material.DIAMOND_BLOCK, 1));
            case 16, 17 -> ev.getDrops().add(new ItemStack(Material.NETHERITE_SCRAP, 2));
        }
    }

}
