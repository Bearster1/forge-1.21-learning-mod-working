package net.bearster.learningmod.datagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.logging.LogUtils;
import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.block.ModBlocks;
import net.bearster.learningmod.fluid.ModFluids;
import net.bearster.learningmod.item.ModItems;
import net.bearster.learningmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.slf4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> AZURITE_SMELTABLES = List.of(ModItems.RAW_AZURITE.get(),
                ModBlocks.AZURITE_ORE.get(), ModBlocks.AZURITE_DEEPSLATE_ORE.get(), ModBlocks.AZURITE_END_ORE.get(), ModBlocks.AZURITE_NETHER_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AZURITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.AZURITE.get())
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHAINSAW.get())
                .pattern("  I")
                .pattern(" I ")
                .pattern("C  ")
                .define('I', Items.IRON_INGOT)
                .define('C', Items.COPPER_BLOCK)
                .unlockedBy("has_copper_block",has(Items.COPPER_BLOCK)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AURORA_ASHES.get())
                .pattern(" A ")
                .pattern("ADA")
                .pattern(" A ")
                .define('A', ModItems.AZURITE.get())
                .define('D', Items.DIAMOND)
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AZURITE_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" S ")
                .define('A', ModItems.AZURITE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AZURITE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.AZURITE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AZURITE_SHOVEL.get())
                .pattern(" A ")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.AZURITE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AZURITE_AXE.get())
                .pattern("AA ")
                .pattern("AS ")
                .pattern(" S ")
                .define('A', ModItems.AZURITE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AZURITE_HOE.get())
                .pattern("AA ")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.AZURITE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AZURITE_PAXEL.get())
                .pattern("ASP")
                .pattern(" s ")
                .pattern(" s ")
                .define('A', ModItems.AZURITE_AXE.get())
                .define('S', ModItems.AZURITE_SHOVEL.get())
                .define('P', ModItems.AZURITE_PICKAXE.get())
                .define('s', Items.STICK)
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AZURITE_HAMMER.get())
                .pattern("  A")
                .pattern(" S ")
                .pattern("S  ")
                .define('A', ModBlocks.AZURITE_BLOCK.get())
                .define('S', Items.STICK)
                .unlockedBy("has_azurite_block",has(ModBlocks.AZURITE_BLOCK.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AZURITE_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.AZURITE.get())
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AZURITE_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.AZURITE.get())
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AZURITE_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.AZURITE.get())
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AZURITE_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.AZURITE.get())
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AZURITE_HORSE_ARMOR.get())
                .pattern("  A")
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModItems.AZURITE.get())
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.KAUPEN_SMITHING_TEMPLATE.get())
                .pattern("SSS")
                .pattern("SAS")
                .pattern("SSS")
                .define('A', ModItems.AURORA_ASHES.get())
                .define('S', Tags.Items.STONES)
                .unlockedBy("has_aurora_ashes",has(ModItems.AURORA_ASHES.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METAL_DETECTOR.get())
                .pattern("  S")
                .pattern(" S ")
                .pattern("I  ")
                .define('S', Items.STICK)
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_iron_ingot",has(Items.IRON_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DATA_TABLET.get())
                .pattern("III")
                .pattern("IRI")
                .pattern("III")
                .define('R', Items.REDSTONE)
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_iron_ingot",has(Items.IRON_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AZURITE_BOW.get())
                .pattern(" AS")
                .pattern("A S")
                .pattern(" AS")
                .define('A', ModItems.AZURITE.get())
                .define('S', Items.STRING)
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ONION_SEEDS.get())
                .pattern("   ")
                .pattern(" O ")
                .pattern("   ")
                .define('O', ModItems.ONION.get())
                .unlockedBy("has_onion",has(ModItems.ONION.get())).save(recipeOutput, "learningmod:onion_seeds_from_onion");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ONION_SEEDS.get())
                .pattern("AAA")
                .pattern("ASA")
                .pattern("AAA")
                .define('A', ModItems.AZURITE.get())
                .define('S', Tags.Items.SEEDS)
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput, "learningmod:onion_seeds_from_azurite");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BAR_BRAWL_MUSIC_DISC.get())
                .pattern(" I ")
                .pattern("IAI")
                .pattern(" I ")
                .define('A', ModItems.AZURITE.get())
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SPECTRE_STAFF.get())
                .pattern("  A")
                .pattern(" S ")
                .pattern("S  ")
                .define('A', ModItems.AURORA_ASHES.get())
                .define('S', Items.STICK)
                .unlockedBy("has_aurora_ashes",has(ModItems.AURORA_ASHES.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RADIATION_STAFF.get())
                .pattern("  E")
                .pattern(" S ")
                .pattern("S  ")
                .define('E', Blocks.EMERALD_BLOCK)
                .define('S', Items.STICK)
                .unlockedBy("has_emerald_block",has(Blocks.EMERALD_BLOCK)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModFluids.AZURITE_WATER_BUCKET.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', ModItems.AZURITE.get())
                .define('B', Items.BUCKET)
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AZURITE_ORE.get())
                .pattern("SSS")
                .pattern("SAS")
                .pattern("SSS")
                .define('A', ModItems.AZURITE.get())
                .define('S',Items.STONE)
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AZURITE_DEEPSLATE_ORE.get())
                .pattern("DDD")
                .pattern("DAD")
                .pattern("DDD")
                .define('A', ModItems.AZURITE.get())
                .define('D',Items.DEEPSLATE)
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AZURITE_NETHER_ORE.get())
                .pattern("NNN")
                .pattern("NAN")
                .pattern("NNN")
                .define('A', ModItems.AZURITE.get())
                .define('N',Items.NETHERRACK)
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AZURITE_END_ORE.get())
                .pattern("EEE")
                .pattern("EAE")
                .pattern("EEE")
                .define('A', ModItems.AZURITE.get())
                .define('E',Items.END_STONE)
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK.get())
                .pattern(" A ")
                .pattern("ARA")
                .pattern(" A ")
                .define('A', ModItems.AZURITE.get())
                .define('R',ModItems.RADIATION_STAFF.get())
                .unlockedBy("has_radiation_staff",has(ModItems.RADIATION_STAFF.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AZURITE_LAMP.get())
                .pattern("AAA")
                .pattern("ARA")
                .pattern("AAA")
                .define('A', ModItems.AZURITE.get())
                .define('R',Items.REDSTONE_LAMP)
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COLORED_LEAVES.get())
                .pattern("LLL")
                .pattern("LDL")
                .pattern("LLL")
                .define('D',Tags.Items.DYES)
                .define('L', ModBlocks.BALSA_LEAVES.get())
                .unlockedBy("has_balsa_leaves",has(ModBlocks.BALSA_LEAVES.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PEDESTAL.get())
                .pattern("SSS")
                .pattern(" s ")
                .pattern("sss")
                .define('S', Items.SMOOTH_STONE)
                .define('s',Tags.Items.STONES)
                .unlockedBy("has_smooth_stone",has(Items.SMOOTH_STONE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CRYSTALLIZER.get())
                .pattern("SSS")
                .pattern("SAS")
                .pattern("SSS")
                .define('A', Items.AMETHYST_SHARD)
                .define('S',Items.STONE)
                .unlockedBy("has_amethyst_shard",has(Items.AMETHYST_SHARD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BALSA_WOOD.get())
                .pattern("BB ")
                .pattern("BB ")
                .pattern("   ")
                .define('B', ModBlocks.BALSA_LOG.get())
                .unlockedBy("has_balsa_log",has(ModBlocks.BALSA_LOG.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STRIPPED_BALSA_WOOD.get())
                .pattern("SS ")
                .pattern("SS ")
                .pattern("   ")
                .define('S', ModBlocks.STRIPPED_BALSA_LOG.get())
                .unlockedBy("has_stripped_balsa_log",has(ModBlocks.STRIPPED_BALSA_LOG.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.BALSA_PLANKS.get(), 4)
                .requires(ModTags.Items.BALSA_WOOD)
                .unlockedBy("has_balsa_wood", has(ModTags.Items.BALSA_WOOD)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.BALSA_SAPLING.get(), 1)
                .requires(ModBlocks.BALSA_LEAVES.get())
                .unlockedBy("has_balsa_leaves", has(ModBlocks.BALSA_LEAVES.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.BALSA_LEAVES.get(), 1)
                .requires(ModBlocks.BALSA_PLANKS.get())
                .unlockedBy("has_balsa_planks", has(ModBlocks.BALSA_PLANKS.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COAL_GENERATOR.get())
                .pattern("III")
                .pattern("ICI")
                .pattern("III")
                .define('I', Items.IRON_BLOCK)
                .define('C', Items.COAL_BLOCK)
                .unlockedBy("has_iron_block",has(Items.IRON_BLOCK)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.LIGHTSABER.get())
                .pattern("  R")
                .pattern(" R ")
                .pattern("B  ")
                .define('B', Items.BLAZE_ROD)
                .define('R', Items.REDSTONE)
                .unlockedBy("has_blaze_rod",has(Items.BLAZE_ROD)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.J0J0JETZ_CLUB_MUSIC_DISC.get())
                .pattern("AAA")
                .pattern("ATA")
                .pattern("AAA")
                .define('T', ModBlocks.TRIFORCE.get())
                .define('A', ModItems.AZURITE.get())
                .unlockedBy("has_triforce",has(ModBlocks.TRIFORCE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TRIFORCE.get())
                .pattern(" G ")
                .pattern("   ")
                .pattern("G G")
                .define('G', Items.GOLD_BLOCK)
                .unlockedBy("has_gold_block",has(Items.GOLD_BLOCK)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SWORD.get())
                .pattern("I  ")
                .pattern(" I ")
                .pattern("  T")
                .define('I', Items.IRON_INGOT)
                .define('T', ModBlocks.TRIFORCE.get())
                .unlockedBy("has_triforce",has(ModBlocks.TRIFORCE.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.AZURITE.get(), 9)
                .requires(ModBlocks.AZURITE_BLOCK.get())
                .unlockedBy("has_azurite_block", has(ModBlocks.AZURITE_BLOCK.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.AZURITE.get(), 9)
                .requires(ModBlocks.MAGIC_BLOCK.get())
                .unlockedBy("has_magic_block", has(ModBlocks.MAGIC_BLOCK.get())).save(recipeOutput, "learningmod:azurite_from_magic_block");

        oreSmelting(recipeOutput, AZURITE_SMELTABLES, RecipeCategory.MISC, ModItems.AZURITE.get(), 0.25f, 200, "azurite");
        oreBlasting(recipeOutput, AZURITE_SMELTABLES, RecipeCategory.MISC, ModItems.AZURITE.get(), 0.25f, 100, "azurite");

        stairBuilder(ModBlocks.AZURITE_STAIRS.get(), Ingredient.of(ModItems.AZURITE.get())).group("azurite")
                .unlockedBy("has_azurite",has(ModItems.AZURITE.get())).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.MISC, ModBlocks.AZURITE_SLAB.get(), ModItems.AZURITE.get());

        buttonBuilder(ModBlocks.AZURITE_BUTTON.get(), Ingredient.of(ModItems.AZURITE.get())).group("azurite")
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.AZURITE_PRESSURE_PLATE.get(), ModItems.AZURITE.get());

        fenceBuilder(ModBlocks.AZURITE_FENCE.get(), Ingredient.of(ModItems.AZURITE.get())).group("azurite")
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);

        fenceGateBuilder(ModBlocks.AZURITE_FENCE_GATE.get(), Ingredient.of(ModItems.AZURITE.get())).group("azurite")
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);

        wall(recipeOutput, RecipeCategory.MISC, ModBlocks.AZURITE_WALL.get(), ModItems.AZURITE.get());

        doorBuilder(ModBlocks.AZURITE_DOOR.get(), Ingredient.of(ModItems.AZURITE.get())).group("azurite")
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);

        trapdoorBuilder(ModBlocks.AZURITE_TRAPDOOR.get(), Ingredient.of(ModItems.AZURITE.get())).group("azurite")
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);

        trimSmithing(recipeOutput, ModItems.KAUPEN_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "kaupen"));
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, LearningMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
