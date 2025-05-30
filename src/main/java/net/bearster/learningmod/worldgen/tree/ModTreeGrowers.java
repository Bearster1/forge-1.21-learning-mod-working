package net.bearster.learningmod.worldgen.tree;

import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower BALSA = new TreeGrower(LearningMod.MOD_ID + ":balsa",
            Optional.empty(), Optional.of(ModConfiguredFeatures.BALSA_KEY), Optional.empty());
}
