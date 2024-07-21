package org.zerobzerot.test_server_extras;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

import static org.bukkit.entity.EntityType.BAT;

public final class Plugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    private static @NotNull ItemStack makeElytra() {
        ItemStack stack = new ItemStack(Material.ELYTRA, 1);
        stack.addEnchantment(Enchantment.UNBREAKING, 3);
        stack.addEnchantment(Enchantment.MENDING, 1);
        stack.addEnchantment(Enchantment.VANISHING_CURSE, 1);

        var meta = stack.getItemMeta();
        meta.setRarity(ItemRarity.EPIC);
        stack.setItemMeta(meta);

        return stack;
    }
    private static @NotNull ItemStack makeFishingRod() {
        ItemStack stack = new ItemStack(Material.FISHING_ROD, 1);
        stack.addEnchantment(Enchantment.UNBREAKING, 3);
        stack.addEnchantment(Enchantment.MENDING, 1);
        stack.addEnchantment(Enchantment.LURE, 3);
        stack.addEnchantment(Enchantment.LUCK_OF_THE_SEA, 3);
        stack.addEnchantment(Enchantment.VANISHING_CURSE, 1);

        var meta = stack.getItemMeta();
        meta.setRarity(ItemRarity.RARE);
        stack.setItemMeta(meta);

        return stack;
    }

    private static @NotNull ItemStack makeFlintSteel() {
        ItemStack stack = new ItemStack(Material.FLINT_AND_STEEL, 1);
        stack.addEnchantment(Enchantment.UNBREAKING, 3);
        stack.addEnchantment(Enchantment.MENDING, 1);
        stack.addEnchantment(Enchantment.VANISHING_CURSE, 1);

        if (ThreadLocalRandom.current().nextBoolean()) {
            var meta = stack.getItemMeta();
            meta.setRarity(ItemRarity.RARE);
            stack.setItemMeta(meta);
        } else {
            var meta = stack.getItemMeta();
            meta.setRarity(ItemRarity.EPIC);
            meta.setUnbreakable(true);
            stack.setItemMeta(meta);
        }

        return stack;
    }

    private static @NotNull ItemStack makeHoe() {
        ItemStack stack = new ItemStack(Material.NETHERITE_HOE, 1);
        stack.addEnchantment(Enchantment.UNBREAKING, 3);
        stack.addEnchantment(Enchantment.MENDING, 1);
        stack.addEnchantment(Enchantment.EFFICIENCY, 5);
        stack.addEnchantment(Enchantment.FORTUNE, 3);
        stack.addEnchantment(Enchantment.SILK_TOUCH, 1);
        stack.addEnchantment(Enchantment.VANISHING_CURSE, 1);

        var meta = stack.getItemMeta();
        meta.setRarity(ItemRarity.EPIC);
        stack.setItemMeta(meta);

        // does this work? 🤔
        var damageable = (Damageable) stack.getItemMeta();
        damageable.setMaxDamage(1);
        stack.setItemMeta(damageable);

        return stack;
    }

    private static @NotNull ItemStack makeTrident() {
        ItemStack stack = new ItemStack(Material.TRIDENT, 1);
        stack.addEnchantment(Enchantment.UNBREAKING, 3);
        stack.addEnchantment(Enchantment.MENDING, 1);
        stack.addEnchantment(Enchantment.IMPALING, 5);
        stack.addEnchantment(Enchantment.VANISHING_CURSE, 1);

        var meta = stack.getItemMeta();
        if (ThreadLocalRandom.current().nextBoolean()) {
            stack.addEnchantment(Enchantment.LOYALTY, 3);
            stack.addEnchantment(Enchantment.CHANNELING, 1);
            meta.setRarity(ItemRarity.RARE);
        } else {
            stack.addEnchantment(Enchantment.RIPTIDE, 3);
            meta.setRarity(ItemRarity.EPIC);
        }
        stack.setItemMeta(meta);

        return stack;
    }

    private static @NotNull ItemStack makeEnchantedBook() {
        ItemStack stack = new ItemStack(Material.ENCHANTED_BOOK, 1);
        switch (ThreadLocalRandom.current().nextInt(0, 15)) {
            case  0 -> stack.addEnchantment(Enchantment.MENDING, 1);
            case  1 -> stack.addEnchantment(Enchantment.UNBREAKING, 3);
            case  2 -> stack.addEnchantment(Enchantment.EFFICIENCY, 5);
            case  3 -> stack.addEnchantment(Enchantment.FORTUNE, 3);
            case  4 -> stack.addEnchantment(Enchantment.SILK_TOUCH, 1);
            case  5 -> stack.addEnchantment(Enchantment.PROTECTION, 4);
            case  6 -> stack.addEnchantment(Enchantment.BLAST_PROTECTION, 4);
            case  7 -> stack.addEnchantment(Enchantment.DEPTH_STRIDER, 3);
            case  8 -> stack.addEnchantment(Enchantment.THORNS, 3);
            case  9 -> stack.addEnchantment(Enchantment.RESPIRATION, 3);
            case 10 -> stack.addEnchantment(Enchantment.SHARPNESS, 5);
            case 11 -> stack.addEnchantment(Enchantment.SWEEPING_EDGE, 3);
            case 12 -> stack.addEnchantment(Enchantment.FLAME, 1);
            case 13 -> stack.addEnchantment(Enchantment.INFINITY, 1);
            case 14 -> stack.addEnchantment(Enchantment.POWER, 5);
        }
        return stack;
    }

    private static void setRarity(@NotNull ItemStack stack, @NotNull ItemRarity rarity) {
        var meta = stack.getItemMeta();
        meta.setRarity(rarity);
        stack.setItemMeta(meta);
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent ev) {

        if (ThreadLocalRandom.current().nextBoolean())
            ev.getPlayer().getInventory().addItem(new ItemStack(Material.OAK_LOG,
                            ThreadLocalRandom.current().nextInt(1, 4)));

        if (ThreadLocalRandom.current().nextBoolean())
            ev.getPlayer().getInventory().addItem(new ItemStack(Material.IRON_BLOCK,
                            ThreadLocalRandom.current().nextInt(1, 2)));

        switch (ThreadLocalRandom.current().nextInt(0, 6)) {
            case 0, 1 -> ev.getPlayer().getInventory().addItem(new ItemStack(Material.COAL_BLOCK,
                            ThreadLocalRandom.current().nextInt(1, 2)));
            case 2, 3 -> ev.getPlayer().getInventory().addItem(new ItemStack(Material.WHITE_WOOL,
                    ThreadLocalRandom.current().nextInt(1, 4)));
            case 4, 5 -> ev.getPlayer().getInventory().addItem(new ItemStack(Material.SMOOTH_STONE,
                    ThreadLocalRandom.current().nextInt(4, 16)));
            case 7 -> ev.getPlayer().getInventory().addItem(new ItemStack(Material.QUARTZ_BLOCK,
                    ThreadLocalRandom.current().nextInt(2, 9)));
            case 8 -> ev.getPlayer().getInventory().addItem(new ItemStack(Material.GLOWSTONE,
                    ThreadLocalRandom.current().nextInt(2, 9)));
        }

        switch (ThreadLocalRandom.current().nextInt(0, 3)) {
            case 0 -> ev.getPlayer().getInventory().addItem(new ItemStack(Material.COOKED_BEEF,
                    ThreadLocalRandom.current().nextInt(2, 8)));
            case 1 -> ev.getPlayer().getInventory().addItem(new ItemStack(Material.PORKCHOP,
                    ThreadLocalRandom.current().nextInt(2, 8)));
            case 2 -> ev.getPlayer().getInventory().addItem(new ItemStack(Material.GOLDEN_CARROT,
                    ThreadLocalRandom.current().nextInt(2, 8)));
        }

    }

    @EventHandler
    public void onPlayerAdvancementDone(PlayerAdvancementDoneEvent ev) {
        ev.getPlayer().giveExp(ThreadLocalRandom.current().nextInt(10, 43), true);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent ev) {
        if (ev.getEntity().getType() == EntityType.PLAYER) return;
        if (!ev.getEntity().hasAI()) return;

        switch (ev.getEntity().getType()) {
            case BAT ->  {
                ev.getDrops().add(makeElytra());
                if (ThreadLocalRandom.current().nextBoolean()) {
                    ev.getDrops().add(new ItemStack(Material.DRAGON_HEAD));
                }
            }
            case CREEPER -> {
                var stack = new ItemStack(Material.FIREWORK_ROCKET,
                        ThreadLocalRandom.current().nextInt(2, 8));
                var meta = (FireworkMeta) stack.getItemMeta();
                meta.setPower(3);
                meta.setRarity(ItemRarity.UNCOMMON);
                stack.setItemMeta(meta);
                ev.getDrops().add(stack);
            }
            case ENDERMAN -> {
                ev.getDrops().add(new ItemStack(Material.OBSIDIAN,
                        ThreadLocalRandom.current().nextInt(1, 9)));
                if (ThreadLocalRandom.current().nextBoolean()) {
                    ev.getDrops().add(new ItemStack(Material.ENDER_CHEST,
                            ThreadLocalRandom.current().nextInt(1, 3)));
                } else {
                    if (ThreadLocalRandom.current().nextBoolean()) {
                        ev.getDrops().add(new ItemStack(Material.ENDER_EYE,
                                ThreadLocalRandom.current().nextInt(1, 3)));
                    } else {
                        ev.getDrops().add(new ItemStack(Material.END_CRYSTAL,
                                ThreadLocalRandom.current().nextInt(1, 5)));
                    }
                }
            }
            case SHEEP -> {
                if (ThreadLocalRandom.current().nextInt(0, 4) == 0) {
                    ev.getDrops().add(new ItemStack(Material.RED_BED, 1));
                }
            }
        }

        // add some cool extra loot
        switch (ThreadLocalRandom.current().nextInt(0, 100)) {
            case 0, 1, 2 -> {
                switch (ThreadLocalRandom.current().nextInt(0, 5)) {
                    case 0 -> ev.getDrops().add(new ItemStack(Material.MUSIC_DISC_STAL, 1));
                    case 1 -> ev.getDrops().add(new ItemStack(Material.MUSIC_DISC_WARD, 1));
                    case 2 -> ev.getDrops().add(new ItemStack(Material.MUSIC_DISC_OTHERSIDE, 1));
                    case 3 -> ev.getDrops().add(new ItemStack(Material.MUSIC_DISC_RELIC, 1));
                    case 4 -> ev.getDrops().add(new ItemStack(Material.MUSIC_DISC_PIGSTEP, 1));
                }
                ev.getDrops().add(new ItemStack(Material.JUKEBOX, 1));
            }
            case 3, 4 -> {
                ev.getDrops().add(new ItemStack(Material.SHULKER_SHELL, 2));
                ev.getDrops().add(new ItemStack(Material.CHEST, 1));
            }
            case 5, 6 -> ev.getDrops().add(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1));
            case 7, 8 -> ev.getDrops().add(new ItemStack(Material.TOTEM_OF_UNDYING, 1));
            case 9, 10, 11 -> ev.getDrops().add(makeEnchantedBook());
            case 12, 13 -> ev.getDrops().add(new ItemStack(Material.DIAMOND_BLOCK, 1));
            case 14 -> ev.getDrops().add(new ItemStack(Material.NETHERITE_SCRAP, 2));
            case 99 -> {
                switch (ThreadLocalRandom.current().nextInt(0, 4)) {
                    case 0 -> ev.getDrops().add(makeFishingRod());
                    case 1 -> {
                        ev.getDrops().add(makeFlintSteel());
                        ev.getDrops().add(new ItemStack(Material.OBSIDIAN, 14));
                    }
                    case 2 -> ev.getDrops().add(makeHoe());
                    case 3 -> ev.getDrops().add(makeTrident());
                }
            }
        }
    }

}
