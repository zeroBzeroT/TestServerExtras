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

    private static @NotNull ItemStack makeFlintSteel() {
        ItemStack stack = new ItemStack(Material.FLINT_AND_STEEL, 1);
        stack.addEnchantment(Enchantment.UNBREAKING, 3);
        stack.addEnchantment(Enchantment.MENDING, 1);
        stack.addEnchantment(Enchantment.VANISHING_CURSE, 1);
        return stack;
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent ev) {
        if (ThreadLocalRandom.current().nextBoolean())
            ev.getPlayer().getInventory().addItem(new ItemStack(Material.OAK_LOG,
                    ThreadLocalRandom.current().nextInt(1, 16 + 1)));
        if (ThreadLocalRandom.current().nextBoolean())
            ev.getPlayer().getInventory().addItem(new ItemStack(Material.IRON_INGOT,
                    ThreadLocalRandom.current().nextInt(1, 8 + 1)));
        if (ThreadLocalRandom.current().nextBoolean())
            ev.getPlayer().getInventory().addItem(new ItemStack(Material.OBSIDIAN,
                    ThreadLocalRandom.current().nextInt(1, 4 + 1)));
        if (ThreadLocalRandom.current().nextBoolean())
            ev.getPlayer().getInventory().addItem(new ItemStack(Material.GLOWSTONE,
                    ThreadLocalRandom.current().nextInt(1, 4 + 1)));
        if (ThreadLocalRandom.current().nextBoolean())
            ev.getPlayer().getInventory().addItem(new ItemStack(Material.QUARTZ_BLOCK,
                    ThreadLocalRandom.current().nextInt(1, 4 + 1)));
        if (ThreadLocalRandom.current().nextBoolean())
            ev.getPlayer().getInventory().addItem(new ItemStack(Material.COAL_BLOCK,
                    ThreadLocalRandom.current().nextInt(1, 4 + 1)));
        if (ThreadLocalRandom.current().nextBoolean())
            ev.getPlayer().getInventory().addItem(new ItemStack(Material.END_CRYSTAL,
                    ThreadLocalRandom.current().nextInt(1, 4 + 1)));
        if (ThreadLocalRandom.current().nextBoolean())
            ev.getPlayer().getInventory().addItem(new ItemStack(Material.DIAMOND,
                    ThreadLocalRandom.current().nextInt(1, 2 + 1)));
        if (ThreadLocalRandom.current().nextBoolean())
            ev.getPlayer().getInventory().addItem(new ItemStack(Material.SHULKER_SHELL,
                    ThreadLocalRandom.current().nextInt(1, 2 + 1)));

        ev.getPlayer().getInventory().addItem(new ItemStack(Material.COOKED_BEEF,
                ThreadLocalRandom.current().nextInt(4, 16 + 1)));
        ev.getPlayer().getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT,
                ThreadLocalRandom.current().nextInt(4, 16 + 1)));
        ev.getPlayer().getInventory().addItem(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE,
                ThreadLocalRandom.current().nextInt(1, 4 + 1)));
    }

    @EventHandler
    public void onPlayerAdvancementDone(PlayerAdvancementDoneEvent ev) {
        ev.getPlayer().giveExpLevels(ThreadLocalRandom.current().nextInt(20, 50));
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent ev) {
        if (ev.getEntity().getType() == EntityType.PLAYER) return;
        if (!ev.getEntity().hasAI()) return;

        var rand = ThreadLocalRandom.current().nextInt(0, 100);
        switch (rand) {
            case 0:
                ev.getDrops().add(new ItemStack(Material.COOKED_BEEF, 16));
                break;
            case 1:
                ev.getDrops().add(new ItemStack(Material.GOLDEN_CARROT, 16));
                break;
            case 2:
                ev.getDrops().add(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 4));
                break;
            case 10:
                ev.getDrops().add(new ItemStack(Material.OBSIDIAN, 16));
                break;
            case 21:
                ev.getDrops().add(new ItemStack(Material.DIAMOND, 3));
                break;
            case 22:
                ev.getDrops().add(new ItemStack(Material.NETHERITE_SCRAP, 1));
                break;
            case 98:
                ev.getDrops().add(makeFlintSteel());
                break;
            case 99:
                ev.getDrops().add(makeHoe());
                break;
        }
    }

}
