package net.bearster.learningmod.entity.client;

import net.bearster.learningmod.LearningMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation CAPYBARA = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "capybara"), "main");

    public static final ModelLayerLocation FIREFIGHTER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "firefighter"), "main");

    public static final ModelLayerLocation GIRAFFE = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "giraffe"), "main");

    public static final ModelLayerLocation FIRE_TRUCK = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "fire_truck"), "main");

    public static final ModelLayerLocation TOMAHAWK = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "tomahawk"), "main");

    public static final ModelLayerLocation WARTURTLE = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "warturtle"), "main");
}
