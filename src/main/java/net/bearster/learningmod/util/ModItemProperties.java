package net.bearster.learningmod.util;

import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.component.ModDataComponentTypes;
import net.bearster.learningmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.DATA_TABLET.get(), ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "on"),
                (itemStack, clientLevel, livingEntity, i) -> itemStack.get(ModDataComponentTypes.FOUND_BLOCK.get()) != null ? 1f : 0f);

        makeBow(ModItems.AZURITE_BOW.get());
    }

    private static void makeBow(Item item) {
        ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pull"), (itemStack, clientLevel, livingEntity, i) -> {
            if (livingEntity == null) {
                return 0.0F;
            } else {
                return livingEntity.getUseItem() != itemStack ? 0.0F : (float)(itemStack.getUseDuration(livingEntity) - livingEntity.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pulling"), (itemStack, clientLevel, livingEntity, i) -> {
            return livingEntity != null && livingEntity.isUsingItem() && livingEntity.getUseItem() == itemStack ? 1.0F : 0.0F;
        });
    }
}
