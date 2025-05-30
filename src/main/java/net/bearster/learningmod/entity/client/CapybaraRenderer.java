package net.bearster.learningmod.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.bearster.learningmod.LearningMod;
import net.bearster.learningmod.entity.custom.CapybaraEntity;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class CapybaraRenderer extends MobRenderer<CapybaraEntity, CapybaraModel> {
    private static final Map<CapybaraVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(CapybaraVariant.class), map -> {
                map.put(CapybaraVariant.BROWN,
                        ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "textures/entity/capybara/capybara_brown.png"));
                map.put(CapybaraVariant.SNOW,
                        ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "textures/entity/capybara/capybara_snow.png"));
            });

    public CapybaraRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CapybaraModel(pContext.bakeLayer(ModModelLayers.CAPYBARA)), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(CapybaraEntity capybaraEntity) {
        return LOCATION_BY_VARIANT.get(capybaraEntity.getVariant()); // ResourceLocation.fromNamespaceAndPath(LearningMod.MOD_ID, "textures/entity/capybara/capybara_brown.png");
    }

    @Override
    public void render(CapybaraEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if (pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
