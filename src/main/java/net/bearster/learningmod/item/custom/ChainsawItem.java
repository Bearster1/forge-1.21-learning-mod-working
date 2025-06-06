package net.bearster.learningmod.item.custom;

import net.bearster.learningmod.component.ModDataComponentTypes;
import net.bearster.learningmod.sound.ModSounds;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.List;

public class ChainsawItem extends Item {
    public ChainsawItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();

        if (!level.isClientSide()) {
            if (level.getBlockState(pContext.getClickedPos()).is(BlockTags.LOGS)) {
                level.destroyBlock(pContext.getClickedPos(), true, pContext.getPlayer());

                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level),
                        ((ServerPlayer) pContext.getPlayer()), item ->
                        pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                pContext.getItemInHand().set(ModDataComponentTypes.COORDINATES.get(), pContext.getClickedPos());

                pContext.getLevel().playSound(null, pContext.getPlayer().blockPosition(), ModSounds.CHAINSAW_CUT.get(),
                        SoundSource.PLAYERS, 1f, 1f);

                ((ServerLevel) pContext.getLevel()).sendParticles(ParticleTypes.SMOKE, pContext.getClickedPos().getX() + 0.5f, pContext.getClickedPos().getY() + 1.0f,
                        pContext.getClickedPos().getZ() + 0.5f, 25, 0.0, 0.05, 0.0, 0.15f);
            } else {
                pContext.getLevel().playSound(null, pContext.getPlayer().blockPosition(), ModSounds.CHAINSAW_PULL.get(), SoundSource.PLAYERS, 1f, 1f);
            }
        }

        if (level.getBlockState(pContext.getClickedPos()).is(BlockTags.LOGS)) {
            pContext.getItemInHand().set(ModDataComponentTypes.COORDINATES.get(), pContext.getClickedPos());
        }

        return InteractionResult.CONSUME;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if (!Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.learningmod.chainsaw.tooltip.shift"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.learningmod.chainsaw.tooltip.1"));
            pTooltipComponents.add(Component.translatable("tooltip.learningmod.chainsaw.tooltip.2"));
        }

        if (pStack.get(ModDataComponentTypes.COORDINATES.get()) !=null) {
            pTooltipComponents.add(Component.literal("Last Tree was chopped at "+pStack.get(ModDataComponentTypes.COORDINATES.get())));
        }

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
