package net.bearster.learningmod.datagen;

import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.fluid.ModFluids;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModFluidTagsProvider extends FluidTagsProvider {

    public ModFluidTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, LearningMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(FluidTags.WATER)
                .add(ModFluids.SOURCE_AZURITE_WATER.get())
                .add(ModFluids.FLOWING_AZURITE_WATER.get());
    }
}
