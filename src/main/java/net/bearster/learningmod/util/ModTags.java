package net.bearster.learningmod.util;

import net.bearster.learningmod.LearningMod;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.TagTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_AZURITE_TOOL = createTag("needs_azurite_tool");
        public static final TagKey<Block> INCORRECT_FOR_AZURITE_TOOL = createTag("incorrect_for_azurite_tool");

        public static final TagKey<Block> PAXEL_MINEABLE = createTag("mineable/paxel");

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        public static final TagKey<Item> BALSA_WOOD = createTag("balsa_wood");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, name));
        }
    }
}
