package net.bearster.learningmod.enchantment;

import com.mojang.serialization.MapCodec;
import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.enchantment.custom.LightningStrikerEnchantmentEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantmentEffects {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_ENCHANTMENT_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, LearningMod.MOD_ID);

    public static final RegistryObject<MapCodec<? extends EnchantmentEntityEffect>> LIGHTNING_STRIKER =
            registerEntityEffect("lightning_striker", LightningStrikerEnchantmentEffect.CODEC);


    private static RegistryObject<MapCodec<? extends EnchantmentEntityEffect>> registerEntityEffect(String name,
                                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec) {
        return ENTITY_ENCHANTMENT_EFFECTS.register(name, () -> codec);
    }

    public static void register(IEventBus eventBus) {
        ENTITY_ENCHANTMENT_EFFECTS.register(eventBus);
    }
}
