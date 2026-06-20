package com.tntwarner.handler;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.tntwarner.config.TNTWarnerConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class HUDRenderer {

    private static final int PADDING = 6;
    private static final int ENTRY_HEIGHT = 12;
    private static f
