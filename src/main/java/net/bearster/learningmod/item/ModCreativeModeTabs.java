package net.bearster.learningmod.item;

import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.block.ModBlocks;
import net.bearster.learningmod.fluid.ModFluids;
import net.bearster.learningmod.potion.ModPotions;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LearningMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> AZURITE_ITEMS_TAB = CREATIVE_MODE_TABS.register("azurite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AZURITE.get()))
                    .title(Component.translatable("creativetab.azurite_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.AZURITE.get());
                        output.accept(ModItems.RAW_AZURITE.get());

                        output.accept(ModItems.CHAINSAW.get());
                        output.accept(ModItems.ONION.get());
                        output.accept(ModItems.AURORA_ASHES.get());

                        output.accept(ModItems.AZURITE_SWORD.get());
                        output.accept(ModItems.AZURITE_PICKAXE.get());
                        output.accept(ModItems.AZURITE_SHOVEL.get());
                        output.accept(ModItems.AZURITE_AXE.get());
                        output.accept(ModItems.AZURITE_HOE.get());

                        output.accept(ModItems.AZURITE_PAXEL.get());

                        output.accept(ModItems.AZURITE_HAMMER.get());

                        output.accept(ModItems.AZURITE_HELMET.get());
                        output.accept(ModItems.AZURITE_CHESTPLATE.get());
                        output.accept(ModItems.AZURITE_LEGGINGS.get());
                        output.accept(ModItems.AZURITE_BOOTS.get());

                        output.accept(ModItems.AZURITE_HORSE_ARMOR.get());

                        output.accept(ModItems.KAUPEN_SMITHING_TEMPLATE.get());

                        output.accept(ModItems.METAL_DETECTOR.get());
                        output.accept(ModItems.DATA_TABLET.get());

                        output.accept(ModItems.AZURITE_BOW.get());

                        output.accept(ModItems.ONION_SEEDS.get());

                        output.accept(ModItems.BAR_BRAWL_MUSIC_DISC.get());

                        output.accept(ModItems.SPECTRE_STAFF.get());

                        output.accept(ModItems.RADIATION_STAFF.get());

                        output.accept(ModFluids.AZURITE_WATER_BUCKET.get());

                        output.accept(ModItems.CAPYBARA_SPAWN_EGG.get());
                        output.accept(ModItems.GIRAFFE_SPAWN_EGG.get());

                        output.accept(ModItems.TOMAHAWK.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> AZURITE_BLOCKS_TAB = CREATIVE_MODE_TABS.register("azurite_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.AZURITE_BLOCK.get()))
                    .withTabsBefore(AZURITE_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.azurite_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModBlocks.AZURITE_BLOCK.get());
                        output.accept(ModBlocks.AZURITE_ORE.get());
                        output.accept(ModBlocks.AZURITE_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.AZURITE_NETHER_ORE.get());
                        output.accept(ModBlocks.AZURITE_END_ORE.get());

                        output.accept(ModBlocks.MAGIC_BLOCK.get());

                        output.accept(ModBlocks.AZURITE_STAIRS.get());
                        output.accept(ModBlocks.AZURITE_SLAB.get());

                        output.accept(ModBlocks.AZURITE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.AZURITE_BUTTON.get());

                        output.accept(ModBlocks.AZURITE_FENCE.get());
                        output.accept(ModBlocks.AZURITE_FENCE_GATE.get());
                        output.accept(ModBlocks.AZURITE_WALL.get());

                        output.accept(ModBlocks.AZURITE_DOOR.get());
                        output.accept(ModBlocks.AZURITE_TRAPDOOR.get());

                        output.accept(ModBlocks.AZURITE_LAMP.get());

                        output.accept(ModBlocks.CATMINT.get());

                        output.accept(ModBlocks.COLORED_LEAVES.get());

                        output.accept(ModBlocks.PEDESTAL.get());

                        output.accept(ModBlocks.CRYSTALLIZER.get());

                        output.accept(ModBlocks.BALSA_LOG.get());

                        output.accept(ModBlocks.BALSA_WOOD.get());

                        output.accept(ModBlocks.STRIPPED_BALSA_LOG.get());

                        output.accept(ModBlocks.STRIPPED_BALSA_WOOD.get());

                        output.accept(ModBlocks.BALSA_PLANKS.get());

                        output.accept(ModBlocks.BALSA_SAPLING.get());

                        output.accept(ModBlocks.BALSA_LEAVES.get());

                        output.accept(ModBlocks.COAL_GENERATOR.get());

                    }).build());

    public static final RegistryObject<CreativeModeTab> CUSTOM_TAB = CREATIVE_MODE_TABS.register("custom_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LIGHTSABER.get()))
                    .title(Component.translatable("creativetab.custom"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.LIGHTSABER.get());

                        output.accept(ModItems.J0J0JETZ_CLUB_MUSIC_DISC.get());
                        output.accept(ModBlocks.TRIFORCE.get());

                        output.accept(ModItems.SWORD.get());

                        output.accept(ModItems.FIREFIGHTER_SPAWN_EGG.get());
                        output.accept(ModItems.FIRE_TRUCK_SPAWN_EGG.get());

                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
