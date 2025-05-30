package net.bearster.learningmod.block;

import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.block.custom.*;
import net.bearster.learningmod.item.ModItems;
import net.bearster.learningmod.sound.ModSounds;
import net.bearster.learningmod.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LearningMod.MOD_ID);

    public static final RegistryObject<Block> AZURITE_BLOCK = registerBlock("azurite_block",
            ()-> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> AZURITE_ORE = registerBlock("azurite_ore",
            ()-> new DropExperienceBlock(UniformInt.of(2,5),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> AZURITE_DEEPSLATE_ORE = registerBlock("azurite_deepslate_ore",
            ()-> new DropExperienceBlock(UniformInt.of(3,7),
                    BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> AZURITE_NETHER_ORE = registerBlock("azurite_nether_ore",
            ()-> new DropExperienceBlock(UniformInt.of(1,5),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> AZURITE_END_ORE = registerBlock("azurite_end_ore",
            ()-> new DropExperienceBlock(UniformInt.of(5,9),
                    BlockBehaviour.Properties.of().strength(7f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock("magic_block",
            ()-> new MagicBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noLootTable().sound(ModSounds.MAGIC_BLOCK_SOUNDS)));

    public static final RegistryObject<Block> AZURITE_STAIRS = registerBlock("azurite_stairs",
            ()-> new StairBlock(ModBlocks.AZURITE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> AZURITE_SLAB = registerBlock("azurite_slab",
            ()-> new SlabBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> AZURITE_PRESSURE_PLATE = registerBlock("azurite_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> AZURITE_BUTTON = registerBlock("azurite_button",
            () -> new ButtonBlock(BlockSetType.IRON, 10, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noCollission()));

    public static final RegistryObject<Block> AZURITE_FENCE = registerBlock("azurite_fence",
            ()-> new FenceBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> AZURITE_FENCE_GATE = registerBlock("azurite_fence_gate",
            ()-> new FenceGateBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> AZURITE_WALL = registerBlock("azurite_wall",
            ()-> new WallBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> AZURITE_DOOR = registerBlock("azurite_door",
            ()-> new DoorBlock(BlockSetType.IRON,BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> AZURITE_TRAPDOOR = registerBlock("azurite_trapdoor",
            ()-> new TrapDoorBlock(BlockSetType.IRON,BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> AZURITE_LAMP = registerBlock("azurite_lamp",
            () -> new AzuriteLampBlock(BlockBehaviour.Properties.of().strength(3f)
                    .lightLevel(state -> state.getValue(AzuriteLampBlock.CLICKED) ? 15 : 0)));

    public static final RegistryObject<Block> ONION_CROP = BLOCKS.register("onion_crop",
            () -> new OnionCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));

    public static final RegistryObject<Block> CATMINT = registerBlock("catmint",
            () -> new FlowerBlock(MobEffects.LUCK, 6, BlockBehaviour.Properties.ofFullCopy(Blocks.ALLIUM)));
    public static final RegistryObject<Block> POTTED_CATMINT = BLOCKS.register("potted_catmint",
            () -> new FlowerPotBlock((() -> (FlowerPotBlock) Blocks.FLOWER_POT), CATMINT, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM)));

    public static final RegistryObject<Block> COLORED_LEAVES = registerBlock("colored_leaves",
            () -> new Block(BlockBehaviour.Properties.of().noOcclusion().sound(SoundType.AZALEA_LEAVES)));

    public static final RegistryObject<Block> PEDESTAL = registerBlock("pedestal",
            ()-> new PedestalBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));

    public static final RegistryObject<Block> TRIFORCE = registerBlock("triforce",
            () -> new TriforceBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));

    public static final RegistryObject<Block> CRYSTALLIZER = registerBlock("crystallizer",
            () -> new CrystallizerBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> BALSA_LOG = registerBlock("balsa_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> BALSA_WOOD = registerBlock("balsa_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));

    public static final RegistryObject<Block> STRIPPED_BALSA_LOG = registerBlock("stripped_balsa_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));

    public static final RegistryObject<Block> STRIPPED_BALSA_WOOD = registerBlock("stripped_balsa_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> BALSA_PLANKS = registerBlock("balsa_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> BALSA_LEAVES = registerBlock("balsa_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> BALSA_SAPLING = registerBlock("balsa_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.BALSA,BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), Blocks.END_STONE));

    public static final RegistryObject<Block> COAL_GENERATOR = registerBlock("coal_generator",
            () -> new CoalGeneratorBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().randomTicks()));



    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
