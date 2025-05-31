package net.bearster.learningmod;

import com.mojang.logging.LogUtils;
import net.bearster.learningmod.block.ModBlocks;
import net.bearster.learningmod.block.entity.ModBlockEntities;
import net.bearster.learningmod.block.entity.renderer.PedestalBlockEntityRenderer;
import net.bearster.learningmod.component.ModDataComponentTypes;
import net.bearster.learningmod.effect.ModEffects;
import net.bearster.learningmod.enchantment.ModEnchantmentEffects;
import net.bearster.learningmod.entity.ModEntities;
import net.bearster.learningmod.entity.client.*;
import net.bearster.learningmod.fluid.ModFluidTypes;
import net.bearster.learningmod.fluid.ModFluids;
import net.bearster.learningmod.item.ModCreativeModeTabs;
import net.bearster.learningmod.item.ModItems;
import net.bearster.learningmod.potion.ModPotions;
import net.bearster.learningmod.recipe.ModRecipes;
import net.bearster.learningmod.screen.ModMenuTypes;
import net.bearster.learningmod.screen.custom.CoalGeneratorScreen;
import net.bearster.learningmod.screen.custom.CrystallizerScreen;
import net.bearster.learningmod.screen.custom.PedestalScreen;
import net.bearster.learningmod.sound.ModSounds;
import net.bearster.learningmod.util.ModItemProperties;
import net.bearster.learningmod.villager.ModVillagers;
import net.bearster.learningmod.worldgen.biome.ModBiomes;
import net.bearster.learningmod.worldgen.biome.ModSurfaceRules;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LearningMod.MOD_ID)
public class LearningMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "learningmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public LearningMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);

        ModDataComponentTypes.register(modEventBus);

        ModSounds.register(modEventBus);

        ModEffects.register(modEventBus);

        ModPotions.register(modEventBus);

        ModVillagers.register(modEventBus);

        ModFluidTypes.register(modEventBus);

        ModFluids.register(modEventBus);

        ModEnchantmentEffects.register(modEventBus);

        ModBlockEntities.register(modEventBus);

        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);

        ModEntities.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ComposterBlock.COMPOSTABLES.put(ModItems.ONION.get(), 0.65f);
            ComposterBlock.COMPOSTABLES.put(ModItems.ONION_SEEDS.get(), 0.35f);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CATMINT.getId(), ModBlocks.POTTED_CATMINT);

            ModBiomes.registerBiomes();

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRules.makeKaupenValleyRules());
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.NETHER, MOD_ID, ModSurfaceRules.makeGlowstonePlainsRules());
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.END, MOD_ID, ModSurfaceRules.makeEndRotRules());

        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.AZURITE);
            event.accept(ModItems.RAW_AZURITE);
        }

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ModItemProperties.addCustomItemProperties();

            event.enqueueWork(() -> {
                ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_AZURITE_WATER.get(), RenderType.translucent());
                ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_AZURITE_WATER.get(), RenderType.translucent());
            });

            MenuScreens.register(ModMenuTypes.PEDESTAL_MENU.get(), PedestalScreen::new);
            MenuScreens.register(ModMenuTypes.CRYSTALLIZER_MENU.get(), CrystallizerScreen::new);
            MenuScreens.register(ModMenuTypes.COAL_GENERATOR_MENU.get(), CoalGeneratorScreen::new);

            EntityRenderers.register(ModEntities.CAPYBARA.get(), CapybaraRenderer::new);
            EntityRenderers.register(ModEntities.FIREFIGHTER.get(), FirefighterRenderer::new);

            EntityRenderers.register(ModEntities.GIRAFFE.get(), GiraffeRenderer::new);
            EntityRenderers.register(ModEntities.FIRE_TRUCK.get(), FireTruckRenderer::new);

            EntityRenderers.register(ModEntities.TOMAHAWK.get(), TomahawkProjectileRenderer::new);

            EntityRenderers.register(ModEntities.WARTURTLE.get(), WarturtleRenderer::new);
        }

        @SubscribeEvent
        public static void registerColoredBlocks(RegisterColorHandlersEvent.Block event) {
            event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null &&
                    pPos != null ? BiomeColors.getAverageFoliageColor(pLevel, pPos) : FoliageColor.getDefaultColor(), ModBlocks.COLORED_LEAVES.get());
        }

        @SubscribeEvent
        public static void registerColoredItems(RegisterColorHandlersEvent.Item event) {
            event.register((pStack, pTintIndex) -> FoliageColor.getDefaultColor(), ModBlocks.COLORED_LEAVES.get());

        }

        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.PEDESTAL_BE.get(), PedestalBlockEntityRenderer::new);
        }
    }
}
