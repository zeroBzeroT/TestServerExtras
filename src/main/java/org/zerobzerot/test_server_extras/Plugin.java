package org.zerobzerot.test_server_extras;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.world.LootGenerateEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent ev) {

    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent ev) {

    }

    @EventHandler
    public void onPlayerAdvancementDone(PlayerAdvancementDoneEvent ev) {

    }

    @EventHandler
    public void onBlockDropItem(BlockDropItemEvent ev) {

    }

    @EventHandler
    public void onLootGenerate(LootGenerateEvent ev) {

    }

}
