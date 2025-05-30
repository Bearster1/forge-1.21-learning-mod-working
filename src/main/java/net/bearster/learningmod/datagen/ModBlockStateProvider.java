package net.bearster.learningmod.datagen;

import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.block.ModBlocks;
import net.bearster.learningmod.block.custom.AzuriteLampBlock;
import net.bearster.learningmod.block.custom.OnionCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {

    static MultiVariantGenerator createSimpleBlock(Block pBlock, ResourceLocation pModelLocation) {
        return MultiVariantGenerator.multiVariant(pBlock, Variant.variant().with(VariantProperties.MODEL, pModelLocation));
    }

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, LearningMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.AZURITE_BLOCK);

        blockWithItem(ModBlocks.AZURITE_ORE);
        blockWithItem(ModBlocks.AZURITE_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.AZURITE_END_ORE);
        blockWithItem(ModBlocks.AZURITE_NETHER_ORE);

        blockWithItem(ModBlocks.MAGIC_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.AZURITE_STAIRS.get()), blockTexture(ModBlocks.AZURITE_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.AZURITE_SLAB.get()), blockTexture(ModBlocks.AZURITE_BLOCK.get()), blockTexture(ModBlocks.AZURITE_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.AZURITE_BUTTON.get()), blockTexture(ModBlocks.AZURITE_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.AZURITE_PRESSURE_PLATE.get()), blockTexture(ModBlocks.AZURITE_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.AZURITE_FENCE.get()),blockTexture(ModBlocks.AZURITE_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.AZURITE_FENCE_GATE.get()),blockTexture(ModBlocks.AZURITE_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.AZURITE_WALL.get()),blockTexture(ModBlocks.AZURITE_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.AZURITE_DOOR.get()), modLoc("block/azurite_door_bottom"), modLoc("block/azurite_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.AZURITE_TRAPDOOR.get()), modLoc("block/azurite_trapdoor"), true, "cutout");

        blockItem(ModBlocks.AZURITE_STAIRS);
        blockItem(ModBlocks.AZURITE_SLAB);
        blockItem(ModBlocks.AZURITE_PRESSURE_PLATE);
        blockItem(ModBlocks.AZURITE_FENCE_GATE);
        customLamp();
        blockItem(ModBlocks.AZURITE_TRAPDOOR, "_bottom");


        makeCrop(((CropBlock) ModBlocks.ONION_CROP.get()), "onion_crop_stage", "onion_crop_stage");

        simpleBlock(ModBlocks.CATMINT.get(),
                models().cross(blockTexture(ModBlocks.CATMINT.get()).getPath(), blockTexture(ModBlocks.CATMINT.get())).renderType("cutout"));
        simpleBlock(ModBlocks.POTTED_CATMINT.get(),
                models().singleTexture("potted_catmint", ResourceLocation.parse("flower_pot_cross"), "plant",
                        blockTexture(ModBlocks.CATMINT.get())).renderType("cutout"));

        leavesBlock(ModBlocks.COLORED_LEAVES);

        // horizontalBlock(ModBlocks.CRYSTALLIZER.get(), mcLoc("block/blast_furnace_side"), modLoc("block/crystallizer_front"), mcLoc("block/blast_furnace_top"));

        logBlock(((RotatedPillarBlock) ModBlocks.BALSA_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.BALSA_WOOD.get()), blockTexture(ModBlocks.BALSA_LOG.get()), blockTexture(ModBlocks.BALSA_LOG.get()));
        logBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_BALSA_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_BALSA_WOOD.get()), blockTexture(ModBlocks.STRIPPED_BALSA_LOG.get()), blockTexture(ModBlocks.STRIPPED_BALSA_LOG.get()));

        blockItem(ModBlocks.BALSA_LOG);
        blockItem(ModBlocks.BALSA_WOOD);
        blockItem(ModBlocks.STRIPPED_BALSA_LOG);
        blockItem(ModBlocks.STRIPPED_BALSA_WOOD);

        blockWithItem(ModBlocks.BALSA_PLANKS);

        leavesBlock(ModBlocks.BALSA_LEAVES);
        saplingBlock(ModBlocks.BALSA_SAPLING);

        blockWithItem(ModBlocks.COAL_GENERATOR);

    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((OnionCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "block/" + textureName + state.getValue(((OnionCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.AZURITE_LAMP.get()).forAllStates(state -> {
            if (state.getValue(AzuriteLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("azurite_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "block/" + "azurite_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("azurite_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "block/" + "azurite_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.AZURITE_LAMP.get(), models().cubeAll("azurite_lamp_on",
                ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "block/" + "azurite_lamp_on")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("learningmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("learningmod:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

}
