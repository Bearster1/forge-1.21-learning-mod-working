package net.bearster.learningmod.datagen;

import com.mojang.logging.LogUtils;
import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.block.ModBlocks;
import net.bearster.learningmod.fluid.ModFluids;
import net.bearster.learningmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.checkerframework.checker.units.qual.N;
import org.slf4j.Logger;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {


    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
            super(output, LearningMod.MOD_ID, existingFileHelper);
        }

    @Override
    protected void registerModels() {
        Logger LOGGER = LogUtils.getLogger();
        LOGGER.info("A");
        basicItem(ModItems.AZURITE.get());
        basicItem(ModItems.RAW_AZURITE.get());

        basicItem(ModItems.CHAINSAW.get());
        handheldItem(ModItems.LIGHTSABER);
        basicItem(ModItems.AURORA_ASHES.get());
        basicItem(ModItems.ONION.get());

        buttonItem(ModBlocks.AZURITE_BUTTON, ModBlocks.AZURITE_BLOCK);
        fenceItem(ModBlocks.AZURITE_FENCE, ModBlocks.AZURITE_BLOCK);
        wallItem(ModBlocks.AZURITE_WALL, ModBlocks.AZURITE_BLOCK);

        simpleBlockItem(ModBlocks.AZURITE_DOOR);

        handheldItem(ModItems.AZURITE_SWORD);
        handheldItem(ModItems.AZURITE_PICKAXE);
        handheldItem(ModItems.AZURITE_SHOVEL);
        handheldItem(ModItems.AZURITE_AXE);
        handheldItem(ModItems.AZURITE_HOE);
        handheldItem(ModItems.AZURITE_PAXEL);
        handheldItem(ModItems.AZURITE_HAMMER);

        trimmedArmorItem(ModItems.AZURITE_HELMET);
        trimmedArmorItem(ModItems.AZURITE_CHESTPLATE);
        trimmedArmorItem(ModItems.AZURITE_LEGGINGS);
        trimmedArmorItem(ModItems.AZURITE_BOOTS);

        basicItem(ModItems.AZURITE_HORSE_ARMOR.get());

        basicItem(ModItems.KAUPEN_SMITHING_TEMPLATE.get());

        basicItem(ModItems.METAL_DETECTOR.get());

        basicItem(ModItems.ONION_SEEDS.get());

        simpleBlockBlockItem(ModBlocks.CATMINT);

        basicItem(ModItems.BAR_BRAWL_MUSIC_DISC.get());

        basicItem(ModItems.J0J0JETZ_CLUB_MUSIC_DISC.get());

        basicItem(ModFluids.AZURITE_WATER_BUCKET.get());

        horizontalBlockItem(ModBlocks.CRYSTALLIZER);

        saplingItem(ModBlocks.BALSA_SAPLING);

        withExistingParent(ModItems.CAPYBARA_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.FIREFIGHTER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        withExistingParent(ModItems.GIRAFFE_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.FIRE_TRUCK_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }

    private ItemModelBuilder saplingItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder horizontalBlockItem(RegistryObject<Block> block) {
        return getBuilder(block.getId().getPath()).parent(new ModelFile.UncheckedModelFile(ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID,
                "block/" + block.getId().getPath())));
    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = LearningMod.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "block/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}