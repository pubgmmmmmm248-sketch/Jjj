package com.tntwarner.handler;

import com.tntwarner.config.TNTWarnerConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TNTTracker {

    public static final List<TNTEntry> activeTNTs = new ArrayList<>();
    private static boolean wasEmpty = true;
    private int tickCounter = 0;

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Minecraft mc = Minecraft.getInstance();
        if (mc.level == null || mc.player == null) {
            activeTNTs.clear();
            return;
        }

        tickCounter++;
        if (tickCounter < 4) return;
        tickCounter = 0;

        PlayerEntity player = mc.player;
        double maxDist = TNTWarnerConfig.MAX_DISTANCE.get();
        int maxEntries = TNTWarnerConfig.MAX_ENTRIES.get();

        List<TNTEntry> found = new ArrayList<>();

        mc.level.entitiesForRendering().forEach(entity -> {
            if (entity instanceof TNTEntity) {
                double dist = player.distanceTo(entity);
                if (dist <= maxDist) {
                    TNT
