package net.bearster.learningmod.datagen;

import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.block.ModBlocks;
import net.bearster.learningmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, LearningMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.AZURITE_BLOCK.get())
                .add(ModBlocks.AZURITE_ORE.get())
                .add(ModBlocks.AZURITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.AZURITE_END_ORE.get())
                .add(ModBlocks.AZURITE_NETHER_ORE.get())
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.AZURITE_SLAB.get())
                .add(ModBlocks.AZURITE_STAIRS.get())
                .add(ModBlocks.AZURITE_BUTTON.get())
                .add(ModBlocks.AZURITE_PRESSURE_PLATE.get())
                .add(ModBlocks.AZURITE_FENCE.get())
                .add(ModBlocks.AZURITE_FENCE_GATE.get())
                .add(ModBlocks.AZURITE_WALL.get())
                .add(ModBlocks.AZURITE_DOOR.get())
                .add(ModBlocks.CRYSTALLIZER.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.AZURITE_DEEPSLATE_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.AZURITE_END_ORE.get())
                .add(ModBlocks.AZURITE_NETHER_ORE.get());

        this.tag(BlockTags.FENCES).add(ModBlocks.AZURITE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(ModBlocks.AZURITE_FENCE_GATE.get());
        this.tag(BlockTags.WALLS).add(ModBlocks.AZURITE_WALL.get());

        this.tag(ModTags.Blocks.PAXEL_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL)
                .addTag(BlockTags.MINEABLE_WITH_AXE);

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.BALSA_LOG.get())
                .add(ModBlocks.BALSA_WOOD.get())
                .add(ModBlocks.STRIPPED_BALSA_LOG.get())
                .add(ModBlocks.STRIPPED_BALSA_WOOD.get());
    }

}
