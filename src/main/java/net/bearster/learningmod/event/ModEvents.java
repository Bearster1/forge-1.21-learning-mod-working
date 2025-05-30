package net.bearster.learningmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.command.ReturnHomeCommand;
import net.bearster.learningmod.command.SetHomeCommand;
import net.bearster.learningmod.item.ModItems;
import net.bearster.learningmod.item.custom.HammerItem;
import net.bearster.learningmod.potion.ModPotions;
import net.bearster.learningmod.villager.ModVillagers;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.brewing.BrewingRecipeRegisterEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = LearningMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        event.getEntity().getPersistentData().putIntArray("learningmod.homepos",
                event.getOriginal().getPersistentData().getIntArray("learningmod.homepos"));
    }

    @SubscribeEvent
    public static void onBrewingRecipeRegister(BrewingRecipeRegisterEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION.getHolder().get());
    }

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(ModItems.ONION.get(), 8), 6, 2, 0.025f
            ));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.DIAMOND, 9),
                    new ItemStack(ModItems.AURORA_ASHES.get(), 1), 4, 2, 0.025f
            ));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.DIAMOND, 16),
                    new ItemStack(ModItems.ONION.get(), 64), 4, 2, 0.025f
            ));
        }

        if (event.getType() == VillagerProfession.TOOLSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(ModItems.CHAINSAW.get(), 1), 1, 8, 0.025f
            ));
        }

        if (event.getType() == ModVillagers.KAUPENGER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(ModItems.CHAINSAW.get(), 1), 1, 8, 0.025f
            ));

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 32),
                    new ItemStack(ModItems.RAW_AZURITE.get(), 1), 32, 8, 0.025f
            ));

            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.AZURITE.get(), 12),
                    new ItemStack(Items.DIAMOND, 2), 32, 8, 0.025f
            ));

            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.AZURITE.get(), 32),
                    new ItemStack(ModItems.SPECTRE_STAFF.get(), 1), 1, 8, 0.025f
            ));

            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.AZURITE.get(), 64),
                    new ItemStack(ModItems.RADIATION_STAFF.get(), 1), 1, 8, 0.025f
            ));
        }
    }

    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 6),
                new ItemStack(ModItems.SPECTRE_STAFF.get(), 1), 1, 10, 0.02f
        ));

        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 64),
                new ItemStack(ModItems.BAR_BRAWL_MUSIC_DISC.get(), 1), 1, 10, 0.02f
        ));
    }

    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if (mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if (HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for (BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if (pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void livingDamage(LivingDamageEvent event) {
        if (event.getEntity() instanceof Sheep sheep) {
            if (event.getSource().getDirectEntity() instanceof Player player) {
                if (player.getMainHandItem().getItem() == ModItems.METAL_DETECTOR.get()) {
                    player.sendSystemMessage(Component.literal(player.getName().getString() + " just hit a Sheep with a metal detector"));
                }

                if (player.getMainHandItem().getItem() == ModItems.ONION.get()) {
                    player.sendSystemMessage(Component.literal(player.getName().getString() + " just hit a Sheep with an onion"));
                    sheep.addEffect(new MobEffectInstance(MobEffects.GLOWING, 400, 1, false, false));
                    player.getMainHandItem().shrink(1);
                }

                if (player.getMainHandItem().getItem() == Items.END_ROD) {
                    player.sendSystemMessage(Component.literal(player.getName().getString() + " just hit a Sheep with AN END ROD?"));
                    sheep.addEffect(new MobEffectInstance(MobEffects.POISON, 400, 1, false, false));
                    player.getMainHandItem().shrink(1);
                }
            }
        }
    }

}
