package net.bearster.learningmod.item;

import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.block.ModBlocks;
import net.bearster.learningmod.entity.ModEntities;
import net.bearster.learningmod.item.custom.*;
import net.bearster.learningmod.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LearningMod.MOD_ID);

    public static final RegistryObject<Item> AZURITE = ITEMS.register("azurite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_AZURITE = ITEMS.register("raw_azurite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHAINSAW = ITEMS.register("chainsaw",
            () -> new ChainsawItem(new Item.Properties().durability(32)));

    public static final RegistryObject<Item> LIGHTSABER = ITEMS.register("lightsaber",
            () -> new SwordItem(Tiers.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(Tiers.NETHERITE, 10, -0.3f))) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.learningmod.lightsaber.tooltip.1"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final RegistryObject<Item> ONION = ITEMS.register("onion",
            () -> new Item(new Item.Properties().food(ModFoodProperties.ONION)) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.learningmod.onion.tooltip.1"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final RegistryObject<Item> AURORA_ASHES = ITEMS.register("aurora_ashes",
            () -> new FuelItem(new Item.Properties(), 800));

    public static final RegistryObject<Item> AZURITE_SWORD = ITEMS.register("azurite_sword",
            () -> new ModEffectSwordItem(ModToolTiers.AZURITE,new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.AZURITE,5, 3f)), MobEffects.LEVITATION, 400, 10));
    public static final RegistryObject<Item> AZURITE_PICKAXE = ITEMS.register("azurite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.AZURITE,new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.AZURITE,1.0F, -2.8F))));
    public static final RegistryObject<Item> AZURITE_SHOVEL = ITEMS.register("azurite_shovel",
            () -> new ShovelItem(ModToolTiers.AZURITE,new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.AZURITE,1.5F, -3.0F))));
    public static final RegistryObject<Item> AZURITE_AXE = ITEMS.register("azurite_axe",
            () -> new AxeItem(ModToolTiers.AZURITE,new Item.Properties().attributes(AxeItem.createAttributes(ModToolTiers.AZURITE,6.0F, -3.2F))));
    public static final RegistryObject<Item> AZURITE_HOE = ITEMS.register("azurite_hoe",
            () -> new HoeItem(ModToolTiers.AZURITE,new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.AZURITE,0, -3.0F))));

    public static final RegistryObject<Item> AZURITE_PAXEL = ITEMS.register("azurite_paxel",
            () -> new PaxelItem(ModToolTiers.AZURITE,new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.AZURITE,2.0F, -2.5F))));

    public static final RegistryObject<Item> AZURITE_HAMMER = ITEMS.register("azurite_hammer",
            () -> new HammerItem(ModToolTiers.AZURITE,new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.AZURITE,7.0F, -3.5F))));

    public static final RegistryObject<Item> AZURITE_HELMET = ITEMS.register("azurite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(11))));
    public static final RegistryObject<Item> AZURITE_CHESTPLATE = ITEMS.register("azurite_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(11))));
    public static final RegistryObject<Item> AZURITE_LEGGINGS = ITEMS.register("azurite_leggings",
            () -> new ModArmorItem(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(11))));
    public static final RegistryObject<Item> AZURITE_BOOTS = ITEMS.register("azurite_boots",
            () -> new ModArmorItem(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(11))));

    public static final RegistryObject<Item> AZURITE_HORSE_ARMOR = ITEMS.register("azurite_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN, false, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> KAUPEN_SMITHING_TEMPLATE = ITEMS.register("kaupen_armor_trim_smithing_template",
            () -> SmithingTemplateItem.createArmorTrimTemplate(ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "kaupen")));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> DATA_TABLET = ITEMS.register("data_tablet",
            () -> new DataTabletItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> AZURITE_BOW = ITEMS.register("azurite_bow",
            () -> new BowItem(new Item.Properties().durability(250)));

    public static final RegistryObject<Item> ONION_SEEDS = ITEMS.register("onion_seeds",
            () -> new ItemNameBlockItem(ModBlocks.ONION_CROP.get(),new Item.Properties()));

    public static final RegistryObject<Item> BAR_BRAWL_MUSIC_DISC = ITEMS.register("bar_brawl_music_disc",
            () -> new Item(new Item.Properties().stacksTo(1).jukeboxPlayable(ModSounds.BAR_BRAWL_KEY)));

    public static final RegistryObject<Item> J0J0JETZ_CLUB_MUSIC_DISC = ITEMS.register("j0j0jetz_club_music_disc",
            () -> new Item(new Item.Properties().stacksTo(1).jukeboxPlayable(ModSounds.JOJOJETZ_CLUB_KEY)));

    public static final RegistryObject<Item> SPECTRE_STAFF = ITEMS.register("spectre_staff",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> RADIATION_STAFF = ITEMS.register("radiation_staff",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> SWORD = ITEMS.register("sword",
            () -> new SwordItem(Tiers.NETHERITE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(Tiers.NETHERITE, 20, -0.3f))));

    public static final RegistryObject<Item> CAPYBARA_SPAWN_EGG = ITEMS.register("capybara_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CAPYBARA, 0x664216, 0xdeab1f,
                    new Item.Properties()));

    public static final RegistryObject<Item> FIREFIGHTER_SPAWN_EGG = ITEMS.register("firefighter_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.FIREFIGHTER, 0xb7340e, 0xe6ce18,
                    new Item.Properties()));

    public static final RegistryObject<Item> GIRAFFE_SPAWN_EGG = ITEMS.register("giraffe_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.GIRAFFE, 0xe7d7a5, 0x7e5b41,
                    new Item.Properties()));

    public static final RegistryObject<Item> FIRE_TRUCK_SPAWN_EGG = ITEMS.register("fire_truck_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.FIRE_TRUCK, 0xb02e26, 0xd8d8d8,
                    new Item.Properties()));

    public static final RegistryObject<Item> TOMAHAWK = ITEMS.register("tomahawk",
            () -> new TomahawkItem(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> WARTURTLE_SPAWN_EGG = ITEMS.register("warturtle_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.WARTURTLE, 0xdcca85, 0x3e352e,
                    new Item.Properties()));

    public static final RegistryObject<Item> IRON_WARTURTLE_ARMOR = ITEMS.register("iron_warturtle_armor",
            () -> new WarturtleArmorItem(ArmorMaterials.IRON, new Item.Properties().durability(200)));
    public static final RegistryObject<Item> GOLD_WARTURTLE_ARMOR = ITEMS.register("gold_warturtle_armor",
            () -> new WarturtleArmorItem(ArmorMaterials.GOLD, new Item.Properties().durability(400)));
    public static final RegistryObject<Item> DIAMOND_WARTURTLE_ARMOR = ITEMS.register("diamond_warturtle_armor",
            () -> new WarturtleArmorItem(ArmorMaterials.DIAMOND, new Item.Properties().durability(600)));
    public static final RegistryObject<Item> NETHERITE_WARTURTLE_ARMOR = ITEMS.register("netherite_warturtle_armor",
            () -> new WarturtleArmorItem(ArmorMaterials.NETHERITE, new Item.Properties().durability(800)));
    public static final RegistryObject<Item> AZURITE_WARTURTLE_ARMOR = ITEMS.register("azurite_warturtle_armor",
            () -> new WarturtleArmorItem(ModArmorMaterials.AZURITE_ARMOR_MATERIAL, new Item.Properties().durability(1000)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
