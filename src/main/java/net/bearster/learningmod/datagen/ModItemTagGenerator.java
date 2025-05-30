package net.bearster.learningmod.datagen;

import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.block.ModBlocks;
import net.bearster.learningmod.item.ModItems;
import net.bearster.learningmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, LearningMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.AZURITE.get())
                .add(ModItems.RAW_AZURITE.get())
                .add(Items.COAL)
                .add(Items.STICK)
                .add(Items.COMPASS)
                .addTag(ItemTags.PLANKS);

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.AZURITE_HELMET.get())
                .add(ModItems.AZURITE_CHESTPLATE.get())
                .add(ModItems.AZURITE_LEGGINGS.get())
                .add(ModItems.AZURITE_BOOTS.get());

        this.tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.AZURITE.get());

        this.tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.KAUPEN_SMITHING_TEMPLATE.get());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.BALSA_LOG.get().asItem())
                .add(ModBlocks.BALSA_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_BALSA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_BALSA_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.BALSA_PLANKS.get().asItem());

        this.tag(ModTags.Items.BALSA_WOOD)
                .add(ModBlocks.BALSA_LOG.get().asItem())
                .add(ModBlocks.BALSA_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_BALSA_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_BALSA_WOOD.get().asItem());
    }
}
